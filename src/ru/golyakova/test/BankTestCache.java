package ru.golyakova.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.golyakova.classes.BankAccount;
import ru.golyakova.annotation.Cache;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Тестовый класс для проверки работы аннотации @Cache.
 * Использует Mockito для тестирования взаимодействия с CacheManager.
 */
@ExtendWith(MockitoExtension.class)
public class BankTestCache {

    /**
     * Мок-объект для имитации работы менеджера кэша.
     * Используется для тестирования взаимодействия с внешней системой кэширования.
     */
    @Mock
    CacheManager cacheManager;

    /**
     * Тест проверяет корректное чтение аннотации @Cache у класса BankAccount.
     * Убеждается, что аннотация присутствует и содержит правильные значения областей кэширования.
     */
    @Test
    public void testReadCorrectly(){
        Cache annotation = BankAccount.class.getAnnotation(Cache.class);
        assertNotNull(annotation);
        assertArrayEquals(new String[]{"account_balance", "account_details", "transactions"}, annotation.value());
    }

    /**
     * Тест проверяет работу с мок-объектом CacheManager.
     * Демонстрирует использование Mockito для имитации поведения внешней зависимости.
     */
    @Test
    public void testMockCache(){
        when(cacheManager.get("account_balance", "acc123")).thenReturn("cached_data");
        String result = cacheManager.get("account_balance", "acc123");
        verify(cacheManager).get("account_balance", "acc123");
        assertEquals("cached_data", result);
    }

    /**
     * Тест проверяет работу аннотации @Cache с пустым массивом областей.
     * Создает локальный класс с аннотацией @Cache({}) и проверяет его.
     */
    @Test
    public void testEmptyCache(){
        @Cache({})
        class EmptyCache{
        }
        Cache annotation = EmptyCache.class.getAnnotation(Cache.class);
        assertEquals(0, annotation.value().length);
    }

    /**
     * Тест проверяет работу аннотации @Cache с несколькими областями кэширования.
     * Создает локальный класс с тремя областями и проверяет их количество и значения.
     */
    @Test
    public void testMultipleCache(){
        @Cache({"area1","area2", "area3"})
        class MultiCache {}
        Cache annotation = MultiCache.class.getAnnotation(Cache.class);
        assertEquals(3,annotation.value().length);
        assertArrayEquals(new String[] {"area1","area2", "area3"}, annotation.value());
    }
}
