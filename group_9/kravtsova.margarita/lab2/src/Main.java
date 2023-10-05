import disease.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String symp = "Насморк,кашель,боль в горле,слабость,температура";
        InfectiousDisease infDis = new InfectiousDisease("ОРВИ",
                Arrays.asList(symp.split(",")),
                5,"СуперВирус",1);
        symp = "плохое настроение,снижение деятельности,апатия";
        MentalDisease mentDis = new MentalDisease("Депрессия",
                Arrays.asList(symp.split(",")),
                40, true,false);
        symp = "Снижение резкости зрения,боль в глазах";
        OrganDisease orgDis = new OrganDisease("Миопия",
                Arrays.asList(symp.split(",")),
                0,"Глаза",false);
        symp = "Кашель,боль в горле,боль в животе,температура,головная боль";
        Disease newDis = new InfectiousDisease("Неизвестная болезнь",
                Arrays.asList(symp.split(",")),
                70,"СуперПуперВирус",1);
        List<Disease> diseases = List.of(infDis, mentDis, orgDis, newDis);
        infDis.onsetDisease();
        try {
            infDis.methodsTreatment();
        } catch (MortalityException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
        mentDis.courseDisease();
        try {
            mentDis.methodsTreatment();
        } catch (MortalityException ex) {
            System.out.println(ex.getMessage());
        }
        mentDis.valuePercentageMorbidity();
        System.out.println();
        orgDis.onsetDisease();
        try {
            orgDis.methodsTreatment();
        } catch (MortalityException ex) {
            System.out.println(ex.getMessage());
        }
        for(Disease dis : diseases) {
        if ((dis instanceof InfectiousDisease) && (dis.getPercentageMorbidity() > 50)) {
            System.out.println("\nВирус " +((InfectiousDisease) dis).getNameInfection()
                    + " очень опасен! " + "Необходимо носить маску в общественных местах!");
        }
        }
    }
}
