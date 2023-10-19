package MilitaryTechnics;

public abstract class MilitaryTechnics implements MilitaryActions {
    private static final int CRITICAL_DEGREE_OF_BREAKDOWN = 100;
    private final String model;
    private String ammunitionUsed;
    private boolean getReadyToFire;

    public MilitaryTechnics(String model, String ammunitionUsed) {
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
        return getReadyToFire;
    }

    public int getCriticalDegreeOfBreakdown() {
        return CRITICAL_DEGREE_OF_BREAKDOWN;
    }

    public void setAmmunitionUsed(String ammunitionUsed) {
        this.ammunitionUsed = ammunitionUsed;
    }

    public void setGetReadyToFire(boolean getReadyToFire) {
        if (!getReadyToFire) {
            this.getReadyToFire = false;
        }
    }

    public void repair() {
        System.out.println("Machine is fixed now");
    }

    @Override
    public void readyToFire() {
        getReadyToFire = true;
    }

    @Override
    public void fire() {
        if (getReadyToFire) {
            System.out.println("Fire is open with " + ammunitionUsed + '\n');
            getReadyToFire = false;
        } else {
            throw new MilitaryTechnicsExeption("Machine isn't ready to fire");
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
        return model.equals(((MilitaryTechnics) object).model);
    }

    @Override
    public int hashCode() {
        return model.hashCode();
    }

    @Override
    public String toString() {
        return "Military techinc: " + model.toString() + '\n';
    }
}
