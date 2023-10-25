import classes.*;
import enums.*;

public class ProductRunner {
    public static void main(String[] args) {
        Product mug1 = new Mug(
                TablewareMaterial.GLASS,
                SizeType.MEDIUM,
                Color.RED,
                200
        );
        Product mug2 = new Mug(
                TablewareMaterial.CERAMICS,
                SizeType.LARGE,
                Color.GREEN,
                500
        );
        Product mug3 = new Mug(
                TablewareMaterial.GLASS,
                SizeType.SMALL,
                Color.BLUE,
                400
        );
        Product mug4 = new Mug(
                TablewareMaterial.GLASS,
                SizeType.MEDIUM,
                Color.RED,
                350
        );
        Product kitchenSet1 = new KitchenSet(
                FurnitureMaterial.WOOD,
                SizeType.LARGE,
                Color.GREEN,
                50000,
                true
        );
        Product kitchenSet2 = new KitchenSet(
                FurnitureMaterial.WOOD,
                SizeType.SMALL,
                Color.RED,
                30000,
                true
        );
        Product kitchenSet3 = new KitchenSet(
                FurnitureMaterial.GLASS,
                SizeType.LARGE,
                Color.BLUE,
                55000,
                true
        );
        Product kitchenSet4 = new KitchenSet(
                FurnitureMaterial.STONE,
                SizeType.MEDIUM,
                Color.BLUE,
                70000,
                false
        );

        Product[] products = {mug1, mug2, mug3, mug4,
                kitchenSet1,  kitchenSet2,  kitchenSet3,  kitchenSet4};

        printInfAboutProducts(products);
    }

    static void printInfAboutProducts(Product[] products){
        for (Product product : products){
            product.inspect();
            product.buy();
            product.deliver();
            System.out.println();
        }
    }

}