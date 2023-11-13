package Bookstore;

import java.util.Objects;

public abstract class Product implements Bought {
    private String title;
    private String description;
    private double price;
    private boolean isBuy = false;
    private int count;

    public Product(String title, String description, double price, int count) {
        this.title = title;
        this.description = description;
        this.price = price;
        if (count == 0) {
            isBuy = true;
        } else {
            this.count = count;
        }
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

    public boolean getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(boolean isBuy) {
        this.isBuy = isBuy;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int newCount) {
        count = newCount;
    }

    public void updatingAvailableProduct(int count) {
        if (count < 0)
            updatingAvailableProduct(0);
        this.count += count;
        if (this.count != 0)
            isBuy = false;
        System.out.println("Количество товара: " + this.count);
    }

    @Override
    public void buy() {
        if (!isBuy) {
            count--;
            if (count == 0) {
                isBuy = true;
            }
            System.out.println("Покупка на сумму: " + price);
        } else {
            System.out.println("Невозможно купить, так как нет в наличии");
        }
    }

    @Override
    public void manyBuy(int count) {
        if (this.count >= count) {
            this.count -= count;
            if (count == 0) {
                isBuy = true;
            }
            System.out.println("Покупка успешно совершена на сумму: " + price * count);
        } else {
            System.out.println("Невозможно купить, так как такого количества нет в наличии");
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price + '\'' +
                ", isBuy=" + isBuy + '\'' +
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
