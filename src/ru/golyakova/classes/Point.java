package ru.golyakova.classes;

import ru.golyakova.annotation.Two;

/**
 * Класс точки с аннотацией @Two, содержащей описание и числовой параметр.
 * Аннотация задает описание "Координаты точки" и числовое значение 100.
 */
@Two(first = "Координаты точки", second = 100)
public class Point {
    /** Координата X точки */
    private int x;

    /** Координата Y точки */
    private int y;


    /**
     * Создает точку с указанными координатами.
     * @param x координата X
     * @param y координата Y
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату X точки.
     * @return координата X
     */
    public int getX() {
        return x;
    }

    /**
     * Возвращает координату Y точки.
     * @return координата Y
     */
    public int getY() {
        return y;
    }

    /**
     * Устанавливает координату Y точки.
     * @param y новая координата Y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Устанавливает координату X точки.
     * @param x новая координата X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Возвращает строковое представление точки в формате "Point(x, y)".
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}
