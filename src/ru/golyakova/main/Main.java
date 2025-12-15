package ru.golyakova.main;
import ru.golyakova.classes.BankAccount;
import ru.golyakova.classes.Person;
import ru.golyakova.classes.Point;
import ru.golyakova.classes.User;
import ru.golyakova.handler.AnnotationHandler;
import ru.golyakova.validator.Validator;

import java.lang.reflect.Field;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        while (!flag) {
            System.out.println("1.1");
            System.out.println("1.2");
            System.out.println("1.3");
            System.out.println("1.4");
            System.out.println("1.5");
            System.out.println("1.6");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");
            String choice;
            choice = scanner.nextLine();
            switch (choice) {
                case "1.1": {
                    System.out.print("Введите имя: ");
                    String namePerson = scanner.nextLine();
                    System.out.print("Введите возраст: ");
                    int age = Validator.inputInt();
                    try {
                        Person invokeObject = new Person(namePerson, age);
                        AnnotationHandler handler = new AnnotationHandler();
                        handler.invokeAnnotation(invokeObject);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    break;
                }
                case "1.2": {
                    AnnotationHandler handler = new AnnotationHandler();
                    handler.printDefault(User.class);
                    User user = new User();
                    try {
                        Class<?> myClass = user.getClass();
                        for (Field field : myClass.getDeclaredFields()) {
                            field.setAccessible(true);
                            System.out.print("Введите значение для '" + field.getName() + "': ");
                            String input = scanner.nextLine();
                            field.set(user, input);
                        }
                    } catch (Exception e) {
                        System.err.println("Ошибка при создании пользователя: " + e.getMessage());
                    }
                    System.out.println("Пользователь создан:");
                    System.out.println(user);
                    break;
                }
                case "1.3": {
                    AnnotationHandler handler = new AnnotationHandler();
                    try {
                        System.out.print("Введите номер счета: ");
                        String accountNumber = scanner.nextLine();

                        System.out.print("Введите начальный баланс: ");
                        double balance = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Введите пин-код: ");
                        String pinCode = scanner.nextLine();

                        BankAccount account = new BankAccount(accountNumber, balance, pinCode);
                        System.out.println("Счет создан!");
                        System.out.println("Строковое представление:");
                        System.out.println(handler.generateString(account));
                    } catch (Exception e) {
                        System.err.println("Ошибка: " + e.getMessage());
                    }
                    break;
                }
                case "1.4": {
                    System.out.print("Введите имя: ");
                    String namePerson = scanner.nextLine();
                    AnnotationHandler handler = new AnnotationHandler();
                    handler.printValidator(Person.class);
                    System.out.println();
                    break;
                }
                case "1.5": {
                    AnnotationHandler handler = new AnnotationHandler();
                    handler.printTwo(Point.class);
                    System.out.println();
                    break;
                }
                case "1.6": {
                    AnnotationHandler handler = new AnnotationHandler();
                    handler.printCache(BankAccount.class);
                    System.out.println();
                    break;
                }
                case "0": {
                    System.out.println("Выход из программы");
                    return;
                }
                default: {
                    System.out.println("Ошибка");
                    break;
                }
            }
        }
    }
}