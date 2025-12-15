package ru.golyakova.classes;

import ru.golyakova.annotation.Invoke;
import ru.golyakova.annotation.Validate;

/**
 * Класс, представляющий человека, с аннотацией @Validate, указывающей допустимые типы (String и Integer) и @Invoke.
 */
@Validate({String.class, Integer.class})
public class Person{
    /** Имя человека (тип String) */
    private String name;

    /** Возраст человека (тип int, соответствует Integer) */
    private int age;

    /**
     * Создает человека с указанным именем.
     *
     * @param name имя человека
     * @param age возраст человека
     */
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    /**
     * Выводит приветствие в консоль.
     * Аннотация {@link Invoke} указывает на специальную обработку метода.
     */
    @Invoke
    public void sayHello(){
        System.out.println("Привет, " + (name != null ? name : "незнакомец"));
    }

    /**
     * Возвращает строковое представление человека.
     *
     * @return строка в формате "Человек: [имя]"
     */
    @Override
    public String toString() {
        return "Человек: " + name;
    }
}
