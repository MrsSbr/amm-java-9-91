package MilitaryTechnics;

import java.util.Objects;

public class Howitzer extends MilitaryTechnics implements MilitaryActions {
    private int caliber;
    private int numberOfCompletedCombatMissions = 0;
    private int degreeOfBreakdown = 0;

    public Howitzer(String model, String ammunitionUsed, int caliber) {
        super(model, ammunitionUsed);
        this.caliber = caliber;
    }

    public int getCaliber() {
        return caliber;
    }

    public int getNumberOfCompletedCombatMissions() {
        return numberOfCompletedCombatMissions;
    }

    public int getDegreeOfBreakdown() {
        return degreeOfBreakdown;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }

    @Override
    public void repair() {
        degreeOfBreakdown = 0;
        System.out.println("Howitzer " + getModel().toString() + " is fixed\n");
    }

    @Override
    public void fire() {
        if (degreeOfBreakdown == getCriticalDegreeOfBreakdown()) {
            throw new MilitaryTechnicsExeption("Howitzer" + getModel() + "caliber " + caliber + " is broken\n");
        }

        if (Objects.equals(getAmmunitionUsed(), "")) {
            throw new MilitaryTechnicsExeption("No ammunition type for" + "Howitzer " + getModel() + " caliber " + caliber + "\n");
        }

        if (isGetReadyToFire()) {
            System.out.println("Howitzer " + getModel() + " caliber " + caliber + " open fire with " + getAmmunitionUsed() + '\n');
            numberOfCompletedCombatMissions++;
            degreeOfBreakdown++;
            setGetReadyToFire(false);
        } else {
            throw new MilitaryTechnicsExeption("Howitzer " + getModel() + " caliber " + caliber + " isn't ready to fire\n");
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
        return getModel().equals(((MilitaryTechnics) object).getModel())
                && caliber == ((Howitzer) object).caliber;
    }

    @Override
    public int hashCode() {
        return getModel().hashCode() + numberOfCompletedCombatMissions + caliber;
    }

    @Override
    public String toString() {
        return "Howitzer: " + getModel().toString() + "Combat exp: " + numberOfCompletedCombatMissions
                + " caliber: " + caliber + '\n';
    }
}
