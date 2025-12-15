package ru.golyakova.classes;

import ru.golyakova.annotation.Default;

/**
 * Класс пользователя с аннотациями @Default.
 * Класс имеет аннотацию @Default, указывающую на себя же в качестве типа по умолчанию.
 */
@Default(User.class)
public class User {
    /** Возраст с типом по умолчанию Integer */
    @Default(Integer.class)
    private Object age;

    /** Зарплата с типом по умолчанию Double */
    @Default(Double.class)
    private Object salary;

    /** Имя без типа по умолчанию */
    private Object name;

    /**
     * Конструктор по умолчанию.
     * Инициализирует объект User без параметров.
     */
    public User(){
    }

    /**
     * Возвращает строковое представление пользователя.
     * @return строка с данными пользователя
     */
    @Override
    public String toString() {
        return String.format("{name=%s, age=%s, salary=%s}",
                name, age, salary);
    }
}
