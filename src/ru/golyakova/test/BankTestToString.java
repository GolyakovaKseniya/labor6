package ru.golyakova.test;

import org.junit.jupiter.api.Test;
import ru.golyakova.handler.AnnotationHandler;
import ru.golyakova.classes.BankAccount;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Тестовый класс для проверки работы метода generateString с аннотациями ToString.
 * Тестирует правильность генерации строкового представления объектов BankAccount.
 */
public class BankTestToString {
    /**
     * Тест проверяет, что метод generateString корректно включает поля accountNumber и balance
     * в строковое представление объекта BankAccount.
     * Эти поля не имеют аннотации @ToString или имеют значение по умолчанию Mode.YES.
     * @throws Exception если возникает ошибка при генерации строки
     */
    @Test
    public void testNumberAndBalance() throws Exception{
        BankAccount account = new BankAccount("12345", 1000.0, "9999");
        AnnotationHandler handler = new AnnotationHandler();
        String result = handler.generateString(account);
        assertTrue(result.contains("accountNumber=12345"));
        assertTrue(result.contains("balance=1000.0"));
    }

    /**
     * Тест проверяет, что метод generateString НЕ включает поле pinCode
     * в строковое представление объекта BankAccount, так как это поле помечено аннотацией @ToString(Mode.NO).
     * @throws Exception если возникает ошибка при генерации строки
     */
    @Test
    public void testPinCode() throws Exception{
        BankAccount account = new BankAccount("12345", 1000.0, "9999");
        AnnotationHandler handler = new AnnotationHandler();
        String result = handler.generateString(account);
        assertFalse(result.contains("pinCode"));
        assertFalse(result.contains("9999"));
    }
}
