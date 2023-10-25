package figure;

import java.util.Objects;

// Класс Rectangle представляет геометрическую фигуру прямоугольник
// и наследуется от абстрактного класса Figure.
public class Rectangle extends Figure {
    private Point secPoint;

    // Конструктор прямоугольника принимает две точки: pivot и secPoint.
    public Rectangle(Point pivot, Point secPoint) {
        super(pivot);
        this.secPoint = secPoint;
    }

    // Геттер для получения второй точки прямоугольника.
    public Point getSecPoint() {
        return secPoint;
    }

    // Сеттер для установки новой второй точки прямоугольника.
    public void setSecPoint(Point secPoint) {
        this.secPoint = secPoint;
    }

    // Метод для вычисления периметра прямоугольника.
    @Override
    public double getPerimeter() {
        double length = Math.abs(getPivot().getX() - secPoint.getX());
        double width = Math.abs(getPivot().getY() - secPoint.getY());
        return 2 * (length + width);
    }

    // Метод для вычисления площади прямоугольника.
    @Override
    public double getSquare() {
        double length = Math.abs(getPivot().getX() - secPoint.getX());
        double width = Math.abs(getPivot().getY() - secPoint.getY());
        return length * width;
    }

    // Переопределение метода equals() для сравнения двух объектов Rectangle.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Rectangle rectangle = (Rectangle) o;

        return Objects.equals(secPoint, rectangle.secPoint);
    }

    // Переопределение метода hashCode() для генерации хэш-кода объекта Rectangle.
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(secPoint);
        return result;
    }

    // Переопределение метода toString() для представления объекта Rectangle в виде строки.
    @Override
    public String toString() {
        return "Rectangle{" +
                "secPoint=" + secPoint +
                '}';
    }
}
