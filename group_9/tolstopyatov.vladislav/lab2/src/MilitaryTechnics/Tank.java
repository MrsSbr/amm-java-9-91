package MilitaryTechnics;

import java.util.Objects;

public class Tank extends MilitaryTechnics implements MilitaryActions {
    private String type;
    private int numberOfCompletedCombatMissions = 0;
    private int degreeOfBreakdown = 0;

    public Tank(String model, String ammunitionUsed, String type, boolean thePresenceOfaMachineGun) {
        super(model, ammunitionUsed);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getNumberOfCompletedCombatMissions() {
        return numberOfCompletedCombatMissions;
    }

    public int getDegreeOfBreakdown() {
        return degreeOfBreakdown;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void repair() {
        degreeOfBreakdown = 0;
        System.out.println(type + "Tank " + getModel().toString() + " is fixed\n");
    }

    @Override
    public void fire() {
        if (getDegreeOfBreakdown() == getCriticalDegreeOfBreakdown()) {
            throw new MilitaryTechnicsExeption(type + "Tank" + getModel() + " is broken\n");
        }

        if (Objects.equals(getAmmunitionUsed(), "")) {
            throw new MilitaryTechnicsExeption("No ammunition type for " + type + " Tank" + getModel() + "\n");
        }

        if (isGetReadyToFire()) {
            System.out.println(type + " Tank " + getModel() + " open fire with " + getAmmunitionUsed() + "\n");
            numberOfCompletedCombatMissions++;
            degreeOfBreakdown += 2;
            setGetReadyToFire(false);
        } else {
            throw new MilitaryTechnicsExeption(type + " Tank" + getModel() + " isn't ready to fire\n");
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
                && Objects.equals(type, ((Tank) object).type);
    }

    @Override
    public int hashCode() {
        return getModel().hashCode() + getNumberOfCompletedCombatMissions() + type.hashCode();
    }

    @Override
    public String toString() {
        return type + " Tank: " + getModel().toString() + " Combat exp: " + numberOfCompletedCombatMissions + '\n';
    }
}
