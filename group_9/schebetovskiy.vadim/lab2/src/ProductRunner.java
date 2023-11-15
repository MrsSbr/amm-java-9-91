import classes.KitchenSet;
import classes.Mug;
import classes.Plate;
import classes.Product;
import enums.Color;
import enums.FurnitureMaterial;
import enums.PlateClassification;
import enums.SizeType;
import enums.TablewareMaterial;

public class ProductRunner {
    public static void main(String[] args) {

        Mug mug1 = new Mug(
                TablewareMaterial.GLASS,
                SizeType.MEDIUM,
                300,
                Color.RED,
                200
        );
        Mug mug2 = new Mug(
                TablewareMaterial.CERAMICS,
                SizeType.LARGE,
                500,
                Color.GREEN,
                500
        );
        Mug mug3 = new Mug(
                TablewareMaterial.GLASS,
                SizeType.SMALL,
                200,
                Color.BLUE,
                400
        );
        Mug mug4 = new Mug(
                TablewareMaterial.GLASS,
                SizeType.MEDIUM,
                300,
                Color.RED,
                350
        );
        Plate plate1 = new Plate(
                TablewareMaterial.GLASS,
                SizeType.SMALL,
                25,
                Color.WHITE,
                PlateClassification.DEEP_DINING,
                1000
        );
        Plate plate2 = new Plate(
                TablewareMaterial.PORCELAIN,
                SizeType.MEDIUM,
                35,
                Color.WHITE,
                PlateClassification.STAND,
                1500
        );
        KitchenSet kitchenSet1 = new KitchenSet(
                FurnitureMaterial.WOOD,
                SizeType.LARGE,
                Color.GREEN,
                50000,
                true
        );
        KitchenSet kitchenSet2 = new KitchenSet(
                FurnitureMaterial.WOOD,
                SizeType.SMALL,
                Color.RED,
                30000,
                true
        );
        KitchenSet kitchenSet3 = new KitchenSet(
                FurnitureMaterial.GLASS,
                SizeType.LARGE,
                Color.BLUE,
                55000,
                true
        );
        KitchenSet kitchenSet4 = new KitchenSet(
                FurnitureMaterial.STONE,
                SizeType.MEDIUM,
                Color.BLUE,
                70000,
                false
        );

        kitchenSet3.setDeliveryOrdered(false);
        Product[] products = {mug1, mug2, mug3, mug4,
                plate1, plate2,
                kitchenSet1, kitchenSet2, kitchenSet3, kitchenSet4};

        printInfAboutProducts(products);
    }

    static void printInfAboutProducts(Product... products) {
        for (var product : products) {
            product.inspect();
            product.buy();
            product.deliver();
            System.out.println();
        }
    }

}