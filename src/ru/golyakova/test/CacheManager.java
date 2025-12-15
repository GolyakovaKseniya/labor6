package ru.golyakova.test;
/**
 * Интерфейс менеджера кэша.
 * Определяет метод для получения данных из кэша по имени области и ключу.
 */
public interface CacheManager {
    /**
     * Получает значение из кэша по имени области и ключу.
     *
     * @param cacheName имя области кэширования
     * @param key ключ для поиска значения в кэше
     * @return значение из кэша или null, если значение отсутствует
     */
    String get(String cacheName, String key);
}
