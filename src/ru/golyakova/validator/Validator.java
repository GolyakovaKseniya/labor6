package ru.golyakova.validator;

import java.util.Scanner;

public class Validator {
    public static Scanner scanner = new Scanner(System.in);

    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }
}
