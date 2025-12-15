package ru.golyakova.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация для указания областей кэширования.
 * Применяется к классам для обозначения, какие данные должны кэшироваться.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * Массив строк, представляющих области кэширования.
     * @return массив названий областей кэширования
     */
    String[] value() default {};
}
