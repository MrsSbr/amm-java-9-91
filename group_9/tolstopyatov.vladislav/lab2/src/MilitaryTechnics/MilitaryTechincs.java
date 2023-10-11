import java.awt.*;
import java.util.Objects;

public abstract class MilitaryTechincs implements ActionsOfMilitaryTechincs {
    private static final int CRITICAL_DEGREE_OF_BREAKDOWN = 100;
    private final String model;
    private String ammunitionUsed;
    private boolean GetReadyToFire;

    public MilitaryTechincs(String model, String ammunitionUsed) {
        this.model = model;
        this.ammunitionUsed = ammunitionUsed;
    }
    public String getModel() {
        return model;
    }
    public String getAmmunitionUsed() {
        return ammunitionUsed;
    }
    public boolean isGetReadyToFire() {
        return GetReadyToFire;
    }
    public int getCriticalDegreeOfBreakdown() {
        return CRITICAL_DEGREE_OF_BREAKDOWN;
    }
    public void setAmmunitionUsed(String ammunitionUsed) {
        this.ammunitionUsed = ammunitionUsed;
    }
    public void setGetReadyToFire(boolean getReadyToFire) {
        if(getReadyToFire)
            return;
        else
            this.GetReadyToFire = false;
    }
    @Override
    public void ReadyToFire() {
        GetReadyToFire = true;
    }

    @Override
    public void repair() {
        System.out.println("Machine is fixed now");
    }

    @Override
    public void fire() {
        if (GetReadyToFire) {
            System.out.println("Fire is open with " + ammunitionUsed + '\n');
            GetReadyToFire = false;
        } else {
            throw  new MilitaryTechnicsExeption("Machine isn't ready to fire");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        return model.equals(((MilitaryTechincs) object).model);
    }
    @Override
    public int hashCode() {
        return model.hashCode();
    }
    @Override
    public String toString() {
        return "Military techinc: " + model.toString() +'\n';
    }
}
