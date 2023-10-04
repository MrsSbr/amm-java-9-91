import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
public abstract class Disease implements ActionsDuringIllness{
    private String name;
    private ArrayList <String> symptoms;
    private int percentageMorbidity;                                         //процент заболеваемости
    public Disease(String name, ArrayList <String> symptoms,
                   int percentMorbidity) {
        this.name = name;
        this.symptoms = symptoms;
        this.percentageMorbidity = percentMorbidity;
    }
    public String getName() {
        return name;
    }
    public ArrayList <String> getSymptoms() {
        return symptoms;
    }
    public int getPercentageMorbidity() {
        return percentageMorbidity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSymptoms(ArrayList<String> symptoms) {
        this.symptoms = symptoms;
    }
    public void setPercentageMorbidity(int percentageMorbidity) {
        this.percentageMorbidity = percentageMorbidity;
    }
    @Override
    public void courseDisease () {                                           //течение заболевания
        System.out.println("У человека наблюдаются симптомы: ");
        for (String symp : symptoms) {
            System.out.println(symp);
        }
    }
    @Override
    public void valuePercentageMorbidity () {                                //величина процента заболеваемости
        System.out.println("Процент заболеваемости болезни " + name +
                " равен " + Integer.toString(percentageMorbidity) + "%");
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Disease disease = (Disease) object;
        if (percentageMorbidity != disease.percentageMorbidity) return false;
        if (!name.equals(disease.name)) return false;
        return symptoms.equals(disease.symptoms);
    }
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + symptoms.hashCode();
        result = 31 * result + percentageMorbidity;
        return result;
    }
    @Override
    public String toString() {
        return "Disease{" +
                "name='" + name + '\'' +
                ", symptoms=" + symptoms +
                ", percentageMorbidity=" + percentageMorbidity + '}';
    }
}