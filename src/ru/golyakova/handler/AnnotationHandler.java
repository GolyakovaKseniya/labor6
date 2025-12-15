package ru.golyakova.handler;

import ru.golyakova.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationHandler {
    /**
     * Автоматически вызываем все методы с аннотацией {@link ru.golyakova.annotation.Invoke} в указанном объекте
     * @param object объект, методы которого нужно проверить на наличие аннотации @Invoke
     */
    public void invokeAnnotation(Object object){
        System.out.println("Поиск методов с аннотацией @Invoke в классе: " + object.getClass().getSimpleName());
        for (Method method : object.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(Invoke.class)){
                System.out.println("Найден метод с @Invoke: " + method.getName());
                method.setAccessible(true);
                try {
                    method.invoke(object);
                }catch (Exception e){
                    System.out.println("Ошибка вызова метода: " + e.getMessage());
                }

            }
        }
    }

    /**
     * Анализирует и выводит информацию об аннотации @Default у переданного класса.
     * Проверяет, имеет ли класс аннотацию @Default, и если имеет - выводит информацию о типе по умолчанию.
     * @param myClass класс для анализа
     */
    public void printDefault(Class<?> myClass){
        System.out.println("Анализ класса: " + myClass.getSimpleName());
        if(myClass.isAnnotationPresent(Default.class)){
            Default classAnnotation = myClass.getAnnotation(Default.class);
            System.out.println("Класс имеет аннотацию @Default:"+ myClass.getSimpleName());
            System.out.println("Тип по умолчанию: " + classAnnotation.value().getSimpleName());
        } else {
            System.out.println("Класс не имеет аннотации @Default");
        }
    }

    /**
     * Генерирует строковое представление объекта на основе аннотаций ToString.
     * Анализирует аннотации @ToString на уровне класса и полей для определения,
     * какие поля включать в результат.
     *
     * @param object объект для генерации строкового представления
     * @return строковое представление объекта
     * @throws Exception если возникает ошибка доступа к полям
     */
    public String generateString(Object object)throws Exception{
        Class<?> myClass = object.getClass();
        String className = myClass.getSimpleName();

        ToString classAnnotation = myClass.getAnnotation(ToString.class);
        if(classAnnotation != null && classAnnotation.value() == Mode.NO){
            return className + "{...}";
        }
        StringBuilder result = new StringBuilder();
        result.append(className).append("{");
        Field[] fields = myClass.getDeclaredFields();
        for(int i = 0; i<fields.length; i++){
            Field field = fields[i];
            field.setAccessible(true);
            ToString fieldAnnotation = field.getAnnotation(ToString.class);
            if(fieldAnnotation == null || fieldAnnotation.value() == Mode.YES){
                if(i > 0 && result.length() > className.length() + 1){
                    result.append(", ");
                }
                String fieldName = field.getName();
                Object fieldValue = field.get(object);
                result.append(fieldName).append("=").append(fieldValue);
            }
        }
        result.append("}");
        return result.toString();
    }

    /**
     * Выводит информацию о аннотации Validate у переданного класса.
     * Если класс имеет аннотацию @Validate, метод выводит список типов,
     * указанных в параметрах аннотации.
     *
     * @param myClass класс для анализа аннотации Validate
     */
    public void printValidator(Class<?> myClass){
        Validate annotation = myClass.getAnnotation(Validate.class);
        if(annotation == null){
            System.out.println("Класс " + myClass.getSimpleName() + " не имеет аннотации @Validate");
        }else{
            System.out.println("Класс " + myClass.getSimpleName() + " - проверяемые типы:");
            for(Class<?> validateClass : annotation.value()){
                System.out.println(" " + validateClass.getSimpleName());
            }
        }
    }

    /**
     * Анализирует и выводит информацию об аннотации @Two у переданного класса.
     * Проверяет наличие аннотации @Two и если она присутствует, выводит значения
     * ее параметров first и second.
     *
     * @param myClass класс для анализа на наличие аннотации @Two
     */
    public void printTwo(Class<?> myClass){
        System.out.println("Анализ класса: " + myClass.getSimpleName());
        Two annotation = myClass.getAnnotation(Two.class);
        if(annotation == null){
            System.out.println("Нет аннтоации @Two");
        }else{
            System.out.println("Аннотация @Two найдена: ");
            System.out.println("first(String): " + annotation.first());
            System.out.println("second(int): "+ annotation.second());
        }
    }

    /**
     * Анализирует и выводит информацию об аннотации @Cache у переданного класса.
     * Проверяет наличие аннотации @Cache и если она присутствует, выводит список
     * областей кэширования, указанных в параметре value.
     *
     * @param myClass класс для анализа на наличие аннотации @Cache
     */
    public void printCache(Class<?> myClass){
        Cache annotation = myClass.getAnnotation(Cache.class);
        if(annotation == null){
            System.out.println("Класс " + myClass.getSimpleName() + " не имеет аннотации @Cache");
        }else{
            String[] areas = annotation.value();
            if(areas.length == 0){
                System.out.println("Класс " + myClass.getSimpleName() + " список пуст");
            }else {
                System.out.println("Аннотация @Cache найдена");
                System.out.println("Кешируемые области (" + areas.length + ")");
                for(int i = 0; i<areas.length; i++){
                    System.out.println((i+1) + ") " + areas[i]);
                }
            }
        }
    }
}
