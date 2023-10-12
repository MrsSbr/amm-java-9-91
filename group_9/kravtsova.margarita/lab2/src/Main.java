import disease.InfectiousDisease;
import disease.MentalDisease;
import disease.MortalityException;
import disease.OrganDisease;
import disease.Disease;

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
        Disease newDis = new InfectiousDisease("СуперПупер болезнь",
                Arrays.asList(symp.split(",")),
                70,"СуперПуперВирус",30);
        List<Disease> diseases = List.of(infDis, mentDis, orgDis, newDis);
        for(Disease dis : diseases) {
            try {
                dis.onsetDisease();
                dis.methodsTreatment();
            } catch (MortalityException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println();
            if ((dis instanceof InfectiousDisease infectDis) && (infectDis.getPercentageMorbidity() > 50)) {
                System.out.println("\nВирус " + infectDis.getNameInfection()
                        + " очень опасен! " + "Необходимо носить маску в общественных местах!");
            }
        }
    }
}
