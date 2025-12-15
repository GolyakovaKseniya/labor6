package ru.golyakova.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация для управления включением полей в строковое представление.
 * Может применяться как к классам, так и к полям.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    /**
     * Режим отображения поля или класса в строковом представлении.
     * @return режим отображения (YES или NO)
     */
    Mode value() default Mode.YES;
}
