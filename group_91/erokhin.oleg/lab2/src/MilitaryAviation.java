package src;

import src.Aircrafts.Aircraft;
import src.Aircrafts.AircraftModel;
import src.Aircrafts.Bomber;
import src.Aircrafts.FighterJet;

import java.util.ArrayList;
import java.util.List;

public class MilitaryAviation {

    public static void main(String[] args) {
        FighterJet f22_1 = new FighterJet(AircraftModel.F22_RAPTOR, "22A-01F", 6);
        FighterJet f22_2 = new FighterJet(AircraftModel.F22_RAPTOR, "22A-02F", 6);
        Bomber b52 = new Bomber(AircraftModel.B52_STRATOFORTRESS, "52B-02B", 32);
        FighterJet su57 = new FighterJet(AircraftModel.SU57, "57S-01R", 4);

        f22_1.refuel();
        b52.bomb();
        su57.engage();

        List<Aircraft> militaryPlanes = new ArrayList<>();
        militaryPlanes.add(f22_1);
        militaryPlanes.add(f22_2);
        militaryPlanes.add(b52);
        militaryPlanes.add(su57);

        for (Aircraft militaryPlane : militaryPlanes) {
            militaryPlane.fly();
        }
        
        if (militaryPlanes.get(0).equals(militaryPlanes.get(2))) {
            System.out.println("Одна и та же модель и бортовой номер.");
        } else {
            System.out.println("Не одна и та же модель и бортовой номер.");
        }
    }
}