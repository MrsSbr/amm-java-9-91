import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ArrayList<MilitaryTechincs> list = new ArrayList<>();
        
        list.add(new Tank("T-34","Kornet","medium",true));
        list.add(new Tank("KV-1","LMAT","heavy",true));

        list.add(new Howitzer("PLZ-05","3ОФ45",52 ));
        list.add(new Howitzer("PzH 2000","M107",50 ));

        for (MilitaryTechincs techincs:list) {
            techincs.ReadyToFire();
            try {
                techincs.fire();
            } catch (MilitaryTechnicsExeption ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (MilitaryTechincs techincs:list) {
            // techincs.ReadyToFire();
            try {
                techincs.fire();
            } catch (MilitaryTechnicsExeption ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (MilitaryTechincs techincs : list) {
            techincs.repair();
        }

        for (MilitaryTechincs techincs : list) {
            if (techincs instanceof Tank && ((Tank) techincs).getDegreeOfBreakdown() < 10) {
                System.out.println(techincs.toString() + " has good condition!");
            }
        }
    }
}