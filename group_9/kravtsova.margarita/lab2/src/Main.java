import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        String symp = "Насморк,кашель,боль в горле,слабость,температура";
        InfectiousDisease infDis = new InfectiousDisease("ОРВИ",
                new ArrayList<String>(Arrays.asList(symp.split(","))),
                5,"СуперВирус",1);
        symp = "плохое настроение,снижение деятельности,апатия";
        MentalDisease mentDis = new MentalDisease("Депрессия",
                new ArrayList<String>(Arrays.asList(symp.split(","))),
                40, true,false);
        symp = "Снижение резкости зрения,боль в глазах";
        OrganDisease orgDis = new OrganDisease("Миопия",
                new ArrayList<String>(Arrays.asList(symp.split(","))),
                0,"Глаза",false);
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
    }
}
