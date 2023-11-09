import makeup.CosmeticProduct;
import makeup.Lipstick;
import makeup.Mascara;

public class CosmeticDemo {
    public static void main(String[] args) {
        CosmeticProduct lipstick1 = new Lipstick("Красная помада", 10.99, "Красный");
        CosmeticProduct lipstick2 = new Lipstick("Красная помада", 10.99, "Красный");
        CosmeticProduct mascara1 = new Mascara("Водостойкая тушь", 8.99, true);
        CosmeticProduct mascara2 = new Mascara("Тушь без водостойкости", 7.99, false);

        if (lipstick1.equals(lipstick2)) {
            System.out.println("Первая и вторая помады равны.");
        } else {
            System.out.println("Первая и вторая помады не равны.");
        }

        if (mascara1.equals(mascara2)) {
            System.out.println("Первая и вторая туши равны.");
        } else {
            System.out.println("Первая и вторая туши не равны.");
        }

        System.out.println(lipstick1);
        System.out.println(lipstick2);
        System.out.println(mascara1);
        System.out.println(mascara2);

        System.out.println("Помада и тушь равны? " + lipstick1.deepEquals(mascara1));

        Lipstick redLipstick = new Lipstick("Красная помада", 10.99, "Красный");
        Mascara voluminousMascara = new Mascara("Объемная тушь", 9.99, false);

        System.out.println("Описание красной помады:");
        redLipstick.describe();

        System.out.println("Описание объемной туши:");
        voluminousMascara.describe();
    }
}