package figure;

import java.awt.geom.Point2D;
import java.util.Random;

public class Main {

    // Инициализация генератора случайных чисел.
    private static Random random = new Random();

    // Метод для генерации случайной точки.
    private static Point2D generateRandomPoint() {
        double x = random.nextDouble() * 10;
        double y = random.nextDouble() * 10;
        return new Point2D.Double(x, y);
    }

    public static void main(String[] args) {

        // Создаем объекты разных геометрических фигур с случайными координатами точек.
        Figure circle = new Circle(generateRandomPoint(), random.nextInt(10) + 1); // радиус в диапазоне [1, 10]
        Figure rectangle = new Rectangle(generateRandomPoint(), generateRandomPoint());
        Figure triangle = new Triangle(generateRandomPoint(), generateRandomPoint(), generateRandomPoint());

        // Создаем массив из этих объектов для дальнейшей обработки.
        Figure[] figures = {circle, rectangle, triangle};

        // Обходим массив, используя оператор instanceof для проверки типа объекта,
        // и выводим информацию о каждой фигуре.
        for (Figure figure : figures) {
            // Выводим общую информацию о фигуре.
            System.out.println("Figure: " + figure.toString());
            System.out.println("Perimeter: " + figure.getPerimeter());
            System.out.println("Square: " + figure.getSquare());

            // Выводим дополнительную информацию, основанную на типе фигуры.
            if (figure instanceof Circle) {
                System.out.println("Radius: " + ((Circle) figure).getRadius());
            } else if (figure instanceof Rectangle) {
                System.out.println("Second point: " + ((Rectangle) figure).getSecPoint());
            } else if (figure instanceof Triangle) {
                System.out.println("Second point: " + ((Triangle) figure).getSecondPoint());
                System.out.println("Third point: " + ((Triangle) figure).getThirdPoint());
            }

            // Выводим пустую строку для отделения информации о разных фигурах.
            System.out.println();
        }
    }
}
