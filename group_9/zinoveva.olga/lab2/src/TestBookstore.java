import Bookstore.Book;
import Bookstore.Bookmark;
import Bookstore.Magazine;
import Bookstore.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestBookstore {
    public static void buy(int count, Product product){
        if(count == 1) {
            product.buy();
            System.out.println("Товар остался в колличестве: " + product.getCount());
        }
        else
            product.manyBuy(count);
    }
    public static void choose(Product product) {
        if(product instanceof Book)
            ((Book) product).setAuthor("Изменён");
        else
            if(product instanceof Bookmark)
                ((Bookmark) product).setColor("Изменён");
            else if(product instanceof Magazine)
                ((Magazine) product).setNumber(0);
    }
    public static void updateCount(Product product, int count){
        product.updatingAvailableProduct(count);
    }
    public static boolean search(List<Product> products, Product product){
        for (Product tmp : products){
            if(tmp.equals(product)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        List<Product> products = new ArrayList<>();
        products.add(new Book("Трудно быть кошкой", "", 1200, "", 350 , 7));
        products.add(new Book("Гимназия №13", "", 2100, "А.В. Жвалевский и Е.Б. Пастернак", 200, 35));
        products.add(new Bookmark("Котята", "Закладка с рисунком котят", 200, "Серый", "Котята", 20));
        products.add(new Bookmark("Цветы", "Металлическая закладка с гравировкой цветов", 350, "Золотистый", "Цветы", 40));
        products.add(new Magazine("Космос", "Что-то там про космос", 700, "", 24, 13, 25));
        products.add(new Book("Вельгельм Телль", "", 500,"",20, 0));
        products.add(new Magazine("Без названия", "", 350, "", 15, 2, 0));
        products.add(new Bookmark("Космос", "", 100, "Синий", "Космос", 5));

        System.out.println(products.get(0).toString());
        System.out.println();

        buy(13, products.get(3));
        System.out.println();

        updateCount(products.get(5), 10);
        updateCount(products.get(6), 10);
        updateCount(products.get(7), 10);
        System.out.println();

        choose(products.get(0));
        System.out.println(products.get(0).toString());
        System.out.println();

        Book bookForSearch = new Book("Вельгельм Телль", "", 500,"",20, 0);
        Bookmark bookmarkForSearch = new Bookmark("Котята", "Закладка с рисунком котят", 200, "Серый", "Котята", 20);
        Magazine magazineForSearch = new Magazine("Космос", "Что-то там про космос", 700, "", 24, 13, 25);
        if(search(products, bookForSearch))
            System.out.println("Книга найдена");
        else
            System.out.println("Книга не найдена");

        if(search(products, bookmarkForSearch))
            System.out.println("Закладка найдена");
        else
            System.out.println("Закладка не найдена");

        if(search(products, magazineForSearch))
            System.out.println("Журнал найден");
        else
            System.out.println("Журнал не найден");
    }
}
