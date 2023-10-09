import src.satellite.MeteorologicalSatellite;
import src.satellite.MilitarySatellite;
import src.satellite.NavigationSatellite;
import src.satellite.Satellite;
import src.satellite.enums.Orbit;

import java.util.ArrayList;

public class Demonstration {

    public static void main(String[] args) {

        var satelliteArrayList = new ArrayList<Satellite>();
        var spaceports = new ArrayList<String>();

        spaceports.add("Восточный");
        spaceports.add("Байконур");
        spaceports.add("Куру");
        spaceports.add("Кадьяк");

        satelliteArrayList.add(new MeteorologicalSatellite("Метеорология-1", Orbit.EQUATORIAL, "Империя"));
        satelliteArrayList.add(new NavigationSatellite("Полярный-1", Orbit.SOLAR_SYNCHRONOUS, "Империя"));
        satelliteArrayList.add(new MilitarySatellite("Имперский-1", Orbit.POLAR, "Империя"));

        System.out.println("--------------------------------------");
        for (var satellite : satelliteArrayList) {
            System.out.println(
                    satellite.launch(
                            spaceports.get(
                                    (int) (Math.random() * 2))));
        }
        System.out.println("--------------------------------------");

        System.out.println("--------------------------------------");
        for (var satellite : satelliteArrayList) {
            System.out.println(satellite.toString());
        }
        System.out.println("--------------------------------------");

        MilitarySatellite militarySatellite = new MilitarySatellite("Повстанец-1", Orbit.POLAR, "Повстанцы");
        System.out.println(militarySatellite.launch(spaceports.get(3)));
        System.out.println(militarySatellite.sendSignal());
        System.out.println(militarySatellite.emp(satelliteArrayList));

        System.out.println("--------------------------------------");
        for (var satellite : satelliteArrayList) {
            System.out.println(satellite.sendSignal());
        }
        System.out.println("--------------------------------------");

        System.out.println("--------------------------------------");
        System.out.println(militarySatellite.toString());
        for (var satellite : satelliteArrayList) {
            System.out.println(satellite.toString());
        }
        System.out.println("--------------------------------------");
    }
}
