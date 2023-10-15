package figure;

import java.awt.geom.Point2D;

// Класс Circle представляет геометрическую фигуру круг и наследуется от абстрактного класса Figure.
public class Circle extends Figure {
    private int radius;

    // Конструктор круга принимает центральную точку (pivot) и радиус.
    public Circle(Point2D pivot, int radius) {
        super(pivot);
        this.radius = radius;
    }

    // Геттер для получения радиуса круга.
    public int getRadius() {
        return radius;
    }

    // Сеттер для установки нового радиуса круга.
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // Метод для вычисления периметра (окружности) круга.
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Метод для вычисления площади круга.
    @Override
    public double getSquare() {
        return Math.PI * Math.pow(radius, 2);
    }

    // Переопределение метода equals() для сравнения двух объектов Circle.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Circle circle = (Circle) o;

        return radius == circle.radius;
    }

    // Переопределение метода hashCode() для генерации хэш-кода объекта Circle.
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + radius;
        return result;
    }

    // Переопределение метода toString() для представления объекта Circle в виде строки.
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
