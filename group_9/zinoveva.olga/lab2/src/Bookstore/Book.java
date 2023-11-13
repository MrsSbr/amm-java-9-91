package Bookstore;

public class Book extends ForReading {
    public Book(String title, String description, double price, String author, int countPage, int count) {
        super(title, description, price, author, countPage, count);
    }

    @Override
    public void updatingAvailableProduct(int count) {
        if (count > 0) {
            if (getIsBuy()) {
                System.out.println("Книги с названием '" + getTitle() + "' теперь в наличии");
                setIsBuy(false);
                setCount(count);
            } else {
                System.out.println("Такие книги есть в наличии, добавление не требуется");
            }
        }
    }

    @Override
    public void buy() {
        if (!this.getIsBuy()) {
            System.out.println("Вы купили книгу");
        }
        super.buy();
    }

    @Override
    public void manyBuy(int count) {
        System.out.print("Вы пытаетесь купить книги в количестве: " + count);
        super.manyBuy(count);
    }

    @Override
    public String toString() {
        return "Book{} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
