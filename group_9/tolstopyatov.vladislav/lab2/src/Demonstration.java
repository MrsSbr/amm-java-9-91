import java.util.ArrayList;
import java.util.List;

import MilitaryTechnics.MilitaryTechnicsExeption;
import MilitaryTechnics.Howitzer;
import MilitaryTechnics.Tank;
import MilitaryTechnics.MilitaryTechnics;

public class Demonstration {
    public static void main(String[] args) {

        List<MilitaryTechnics> list = new ArrayList<>();

        list.add(new Tank("T-34", "Kornet", "medium", true));
        list.add(new Tank("KV-1", "LMAT", "heavy", true));

        list.add(new Howitzer("PLZ-05", "3ОФ45", 52));
        list.add(new Howitzer("PzH 2000", "M107", 50));

        for (var technics : list) {
            technics.readyToFire();
            try {
                technics.fire();
            } catch (MilitaryTechnicsExeption ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (var technics : list) {
            // technics.ReadyToFire();
            try {
                technics.fire();
            } catch (MilitaryTechnicsExeption ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (var technics : list) {
            technics.repair();
        }

        for (var technics : list) {
            if (technics instanceof Tank tank && tank.getDegreeOfBreakdown() < 10) {
                System.out.println(tank.toString() + " has good condition!");
            }
        }
    }
}