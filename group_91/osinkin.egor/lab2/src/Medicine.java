import medicine.Antibiotic;
import medicine.Suppliment;
import medicine.Tablet;

public class Medicine {
    public static void main(String[] args) {
        Tablet[] tablets = new Tablet[8];
        tablets[0] = new Antibiotic(0.03, "Антибиотик №1", "Амиксин", "Вирусы");
        tablets[1] = new Antibiotic(0.05, "Антибиотик №2", "Пенициллин", "Бактерии");
        tablets[2] = new Antibiotic(0.08, "Антибиотик №3", "Фумиксин", "Грибки");
        tablets[3] = new Antibiotic(0.3, "Антибиотик №1", "Амиксин", "Вирусы");
        tablets[4] = new Suppliment(0.3, "БАД №1", "Аскорбинка", "Сахар, Витамин С");
        tablets[5] = new Suppliment(0.4, "БАД №2", "Гематоген", "...");
        tablets[6] = new Suppliment(0.3, "БАД №1", "Аскорбинка", "Сахар, Витамин С");
        tablets[7] = new Suppliment(0.5, "БАД №3", "Плацебо", "Сахар");

        for (Tablet tablet : tablets) {
            System.out.println(tablet);
            tablet.buy();
            tablet.use(15);
            if (tablet instanceof Suppliment suppliment) {
                suppliment.feast();
                if (suppliment.getStructure().equals("Сахар")) {
                    System.out.println("О нет, это была не аскорбинка!");
                }
            }
        }
    }
}
