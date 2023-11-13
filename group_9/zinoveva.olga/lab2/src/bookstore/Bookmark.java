package bookstore;

import java.util.Objects;

public class Bookmark extends Product {
    private String color;
    private String drawing;

    public Bookmark(String title, String description, double price, String color, String drawing, int count) {
        super(title, description, price, count);
        this.color = color;
        this.drawing = drawing;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String newColor) {
        color = newColor;
    }

    public String getDrawing() {
        return drawing;
    }

    public void setDrawing(String newDrawing) {
        drawing = newDrawing;
    }

    @Override
    public void buy() {
        if (!isBuy()) {
            System.out.println("Вы купили закладку ");
        }
        super.buy();
    }

    @Override
    public void buy(int count) {
        System.out.println("Вы пытаетесь купить закладки с названием '" + getTitle() + "' в количестве: " + count);
        super.buy(count);
    }

    @Override
    public void updatingAvailableProduct(int count) {
        if (count > 0) {
            setCount(getCount() + count);
            System.out.print("Закладка с названием '" + getTitle() + "' добавлены. ");
            System.out.println("Теперь их количество составляет: " + getCount());
        }
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "color='" + color + '\'' +
                ", drawing='" + drawing + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bookmark bookmark = (Bookmark) o;
        return Objects.equals(color, bookmark.color) && Objects.equals(drawing, bookmark.drawing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, drawing);
    }
}
