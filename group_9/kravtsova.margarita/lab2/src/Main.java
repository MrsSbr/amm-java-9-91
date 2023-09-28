import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        String symp = "Насморк,кашель,боль в горле,слабость,температура";
        InfectiousDisease infDis = new InfectiousDisease("ОРВИ",
                new ArrayList<String>(Arrays.asList(symp.split(","))),
                5,"СуперВирус",1);
        symp = "плохое настроение,снижение деятельности";
        MentalDisease mentDis = new MentalDisease("Депрессия",
                new ArrayList<String>(Arrays.asList(symp.split(","))),5,
                true,false);
        symp = "Снижение резкости зрения";
        OrganDisease orgDis = new OrganDisease("Миопия",
                new ArrayList<String>(Arrays.asList(symp.split(","))),
                0,"Глаза",false);
        infDis.onsetDisease();
        infDis.methodsTreatment();
        mentDis.valuePercentageMorbidity();
        mentDis.courseDisease();
        orgDis.onsetDisease();
        orgDis.methodsTreatment();
    }
}
