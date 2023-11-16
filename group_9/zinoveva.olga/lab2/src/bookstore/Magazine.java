package bookstore;

import java.util.Objects;

public class Magazine extends ForReading {
    private int number;

    public Magazine(String title, String description, double price, String author, int countPage, int number, int count) {
        super(title, description, price, author, countPage, count);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int newNumber) {
        number = newNumber;
    }

    @Override
    public void updatingAvailableProduct(int count) {
        if (count > 0) {
            if (isBuy()) {
                System.out.println("Недостающие журналы '" + getTitle() + "' добавлены");
                setCount(count);
            } else {
                System.out.println("Такие журналы уже есть в наличии");
            }
        }
    }

    @Override
    public void buy() {
        if (!isBuy())
            System.out.println("Вы купили журнал ");
        super.buy();
    }

    @Override
    public void buy(int count) {
        System.out.print("Вы пытаетесь купить журналы в количестве: " + count);
        super.buy(count);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "number=" + number + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return number == magazine.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number);
    }
}
