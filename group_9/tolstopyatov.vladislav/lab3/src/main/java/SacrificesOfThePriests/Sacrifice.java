package SacrificesOfThePriests;

public class Sacrifice {
    private String typeOfVictim; // тип жертвы(человек, животное, материальный объект)
    private String victim;       // конкретная жертва(собака и т.д)

    public Sacrifice(String typeOfVictim, String victim) {
        this.typeOfVictim = typeOfVictim;
        this.victim = victim;
    }

    public String getTypeOfVictim() {
        return typeOfVictim;
    }

    public String getVictim() {
        return victim;
    }

    public void setTypeOfVictim(String typeOfVictim) {
        this.typeOfVictim = typeOfVictim;
    }

    public void setVictim(String victim) {
        this.victim = victim;
    }
}
