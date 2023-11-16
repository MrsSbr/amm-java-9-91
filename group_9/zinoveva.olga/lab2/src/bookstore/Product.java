package bookstore;

import java.util.Objects;

public abstract class Product implements Bought {
    private String title;
    private String description;
    private double price;
    private int count;

    public Product(String title, String description, double price, int count) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int newCount) {
        count = newCount;
    }

    @Override
    public void buy() {
        if (!isBuy()) {
            count--;
            System.out.println("Покупка на сумму: " + price);
        } else {
            System.out.println("Невозможно купить, так как нет в наличии");
        }
    }

    @Override
    public void buy(int count) {
        if (this.count >= count) {
            this.count -= count;
            System.out.println("Покупка успешно совершена на сумму: " + price * count);
        } else {
            System.out.println("Невозможно купить, так как такого количества нет в наличии");
        }
    }

    protected boolean isBuy() {
        return count == 0;
    }

    public void updatingAvailableProduct(int count) {
        if (count < 0) {
            count = 0;
        }
        this.count += count;
        System.out.println("Количество товара: " + this.count);
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(title, product.title) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, price);
    }
}
