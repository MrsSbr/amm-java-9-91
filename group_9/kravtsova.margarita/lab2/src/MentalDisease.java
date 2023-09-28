import java.util.ArrayList;
public class MentalDisease extends Disease{
    public boolean possibilityTreatment;//возможность лечения
    public boolean strangeBehavior;// странное поведение
    public boolean isPossibilityTreatment() {
        return possibilityTreatment;
    }
    public boolean isStrangeBehavior() {
        return strangeBehavior;
    }
    @Override
    public String toString(){
        return super.toString() + String.format("Возможность лечения: %b\nСтранное поведение: %b\n",
                possibilityTreatment, strangeBehavior);
    }
   @Override
   public boolean equals(Object obj) {
        if(obj instanceof MentalDisease mentDis) {
            return (super.equals(mentDis))
                    && (this.possibilityTreatment == mentDis.possibilityTreatment)
                    && (this.strangeBehavior == mentDis.strangeBehavior);
        }
        return false;
   }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    public MentalDisease(String name, ArrayList <String> symptoms,
                         int percentMorbidity, boolean possibilityTreatment, boolean strangeBehavior){
        super(name, symptoms, percentMorbidity);
        this.possibilityTreatment = possibilityTreatment;
        this.strangeBehavior = strangeBehavior;
    }
    @Override
    public void onsetDisease() { //начало заболевания
        System.out.println("У человека наблюдаются отклонения в поведении.\n" +
                "Видимо, ему нужно обратиться к психологу, а при необходимости к психиатру.");
    }
    @Override
    public void methodsTreatment() { //методы лечения
        System.out.println("У пациента выявлено заболевание под названием " + name);
        if(!possibilityTreatment) {
            throw new MortalityException("Данную болезнь нельзя излечить!");
        }
        else {
            System.out.println("Пациент будет принимать необходимые лекарства и находиться под присмотром врачей.");
        }
    }
    public void specialCases(){ //наличие особых случаев
        if(strangeBehavior) {
            System.out.println("Этот пациент ведет себя неодекватно, нужно быть с ним осторожнее!");
        }
        else {
            System.out.println("Поведение данного пациента не опасно для общества.");
        }
    }
}
