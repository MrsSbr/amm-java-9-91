import java.util.ArrayList;
public class OrganDisease extends Disease{
    public String organ;
    public boolean chronic;
    public String getOrgan() {
        return organ;
    }
    public boolean isChronic() {
        return chronic;
    }
    @Override
    public String toString(){
        return super.toString() + String.format("Воспеленный орган: %s\nНаличие хронического заболевания: %b\n",
                organ, chronic);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  OrganDisease organDis) {
            return (super.equals(organDis))
                    && (this.organ.equals(organDis.organ)) && (this.chronic == organDis.chronic);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    public OrganDisease(String name, ArrayList<String> symptoms,
                         int percentMorbidity, String organ, boolean chronic){
        super(name, symptoms, percentMorbidity);
        this.organ = organ;
        this.chronic = chronic;
    }
    @Override
    public void onsetDisease() { //начало заболевания
        System.out.println("У человека заболел огран - это " + organ +
                ". Необходимо обратиться к врачу!");
    }
    @Override
    public void methodsTreatment() { //методы лечения
        System.out.println("У пациента выявлено заболевание под названием " + name);
        if(chronic) {
            throw new MortalityException("Данную болезнь нельзя излечить, она хроническая!");
        }
        else {
            System.out.println("Пациент будет принимать необходимые лекарства и ходить на медикоментозные процедуры.");
        }
    }
}
