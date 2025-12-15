package ru.golyakova.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация для указания допустимых типов данных.
 * Применяется к аннотациям и классам для валидации типов.
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    /**
     * Массив допустимых типов данных.
     * @return массив классов-типов
     */
    Class<?>[] value();
}
