import java.util.List;

import enums.Size;
import models.AbstractClothing;
import models.Pants;
import models.Shirt;

public class Clothes {

    public static void main(String[] args) {
        AbstractClothing shirt = new Shirt("Синяя", 25.99, Size.L);
        AbstractClothing anotherShirt = new Shirt("Синяя", 23.99, Size.S);
        AbstractClothing pants = new Pants("Черные", 35.50, Size.M, 100);

        List<AbstractClothing> items = List.of(shirt, anotherShirt, pants);

        for (AbstractClothing item : items) {
            System.out.println("Информация о предмете одежды:");
            System.out.println(item.toString());

            System.out.print("Попытки надеть одежду: ");
            item.wear();

            System.out.print("Попытки кастомизировать одежду: ");
            item.customize();

            System.out.print("Какое-то действие с одеждой: ");
            if (item instanceof Shirt shirtItem) {
                shirtItem.fold();
            } else if (item instanceof Pants pantsItem) {
                pantsItem.iron();
            }

            System.out.println();
        }
    }

}