package figure;

import java.util.Objects;

// Абстрактный класс Figure представляет фигуру и реализует функциональность измеряемых объектов.
public abstract class Figure implements Measureable {

    private Point pivot;  // Точка начала фигуры

    // Конструктор принимает точку начала в качестве параметра и инициализирует ее.
    public Figure(Point pivot) {
        this.pivot = pivot;
    }

    // Метод для получения текущей точки начала фигуры.
    public Point getPivot() {
        return pivot;
    }

    // Метод для установки новой точки начала фигуры.
    public void setPivot(Point pivot) {
        this.pivot = pivot;
    }

    // Переопределение метода equals() для сравнения двух объектов Figure.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Figure figure = (Figure) o;
        return Objects.equals(pivot, figure.pivot);
    }

    // Переопределение метода hashCode() для генерации хэш-кода объекта Figure.
    @Override
    public int hashCode() {
        return Objects.hashCode(pivot);
    }

    // Переопределение метода toString() для представления объекта Figure в виде строки.
    @Override
    public String toString() {
        return "Figure{" +
                "pivot=" + pivot +
                '}';
    }
}


