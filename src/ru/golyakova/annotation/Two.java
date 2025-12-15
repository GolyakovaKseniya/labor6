package ru.golyakova.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация с двумя параметрами: строкой и целым числом.
 * Применяется только к классам (ElementType.TYPE).
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    /**
     * Строковый параметр аннотации.
     * @return строка-описание
     */
    String first();
    /**
     * Целочисленный параметр аннотации.
     * @return целое число
     */
    int second();
}
