package ru.golyakova.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация для указания типа по умолчанию.
 * Может применяться к классам и полям.
 * @value класс типа по умолчанию
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {
    /**
     * Тип по умолчанию.
     * @return класс типа по умолчанию
     */
    Class<?> value();
}
