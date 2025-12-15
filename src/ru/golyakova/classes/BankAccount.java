package ru.golyakova.classes;

import ru.golyakova.annotation.Cache;
import ru.golyakova.annotation.Mode;
import ru.golyakova.annotation.ToString;

/**
 * Класс банковского счета с аннотациями ToString и Cache.
 * Аннотация @ToString на уровне класса включает генерацию toString по умолчанию.
 * Аннотация @Cache указывает три области для кэширования данных счета.
 */
@ToString
@Cache({"account_balance", "account_details", "transactions"})
public class BankAccount {
    /** Номер счета - будет включен в строковое представление (режим по умолчанию) */
    private String accountNumber;

    /** Баланс счета - будет включен в строковое представление (режим по умолчанию) */
    private double balance;

    /** PIN-код - исключен из строкового представления аннотацией @ToString(Mode.NO) */
    @ToString(Mode.NO)
    private String pinCode;

    /**
     * Конструктор банковского счета.
     * @param accountNumber номер счета
     * @param balance начальный баланс
     * @param pinCode PIN-код для доступа
     */
    public BankAccount(String accountNumber, double balance, String pinCode){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pinCode = pinCode;
    }

    /**
     * Возвращает текущий баланс счета.
     * @return баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Возвращает номер счета.
     * @return номер счета
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Возвращает PIN-код счета.
     * @return PIN-код
     */
    public String getPinCode() {
        return pinCode;
    }
}
