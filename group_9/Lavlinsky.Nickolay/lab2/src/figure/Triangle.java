package figure;

import java.awt.geom.Point2D;
import java.util.Objects;

// Класс Triangle представляет геометрическую фигуру треугольник
// и наследуется от абстрактного класса Figure.
public class Triangle extends Figure {
    private Point2D secondPoint;
    private Point2D thirdPoint;

    // Конструктор треугольника принимает три точки: pivot, secondPoint и thirdPoint
    public Triangle(Point2D pivot, Point2D secondPoint, Point2D thirdPoint) {
        super(pivot);
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    // Геттер для получения второй точки треугольника
    public Point2D getSecondPoint() {
        return secondPoint;
    }

    // Геттер для получения третьей точки треугольника
    public Point2D getThirdPoint() {
        return thirdPoint;
    }

    // Сеттер для установки новой третьей точки треугольника
    public void setThirdPoint(Point2D thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    // Метод для вычисления периметра треугольника, используя расстояние между точками
    @Override
    public double getPerimeter() {
        double a = getPivot().distance(secondPoint);
        double b = secondPoint.distance(thirdPoint);
        double c = thirdPoint.distance(getPivot());
        return a + b + c;
    }

    // Метод для вычисления площади треугольника, используя формулу Герона
    @Override
    public double getSquare() {
        double a = getPivot().distance(secondPoint);
        double b = secondPoint.distance(thirdPoint);
        double c = thirdPoint.distance(getPivot());
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // Переопределение метода equals() для сравнения двух объектов Triangle
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Triangle triangle = (Triangle) o;

        if (!Objects.equals(secondPoint, triangle.secondPoint)) return false;
        return Objects.equals(thirdPoint, triangle.thirdPoint);
    }

    // Переопределение метода hashCode() для генерации хэш-кода объекта Triangle
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(secondPoint);
        result = 31 * result + Objects.hashCode(thirdPoint);
        return result;
    }

    // Переопределение метода toString() для представления объекта Triangle в виде строки
    @Override
    public String toString() {
        return "Triangle{" +
                "secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                '}';
    }
}
