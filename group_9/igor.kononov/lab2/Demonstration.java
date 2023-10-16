import src.satellite.Satellite;
import src.satellite.MeteorologicalSatellite;
import src.satellite.NavigationSatellite;
import src.satellite.MilitarySatellite;
import src.satellite.enums.Orbit;

import java.util.ArrayList;
import java.util.List;

public class Demonstration {

    private static final String DELIMITER = "--------------------------------------";
    private static final List<Satellite> satelliteList = new ArrayList<>();
    private static final List<String> spaceports = new ArrayList<>();

    private static void createSatellites() {

        spaceports.add("Восточный");
        spaceports.add("Байконур");
        spaceports.add("Куру");
        spaceports.add("Кадьяк");

        satelliteList.add(new MeteorologicalSatellite("Метеорология-1", Orbit.EQUATORIAL, "Империя"));
        satelliteList.add(new NavigationSatellite("Полярный-1", Orbit.SOLAR_SYNCHRONOUS, "Империя"));
        satelliteList.add(new MilitarySatellite("Имперский-1", Orbit.POLAR, "Империя"));
        satelliteList.add(new MilitarySatellite("Имперский-2", Orbit.SOLAR_SYNCHRONOUS, "Империя"));

        System.out.println(DELIMITER);
        for (var satellite : satelliteList) {
            System.out.println(
                    satellite.launch(
                            spaceports.get(
                                    (int) (Math.random() * 2))));
        }
        System.out.println(DELIMITER);
    }

    private static void printSatellites() {
        for (var satellite : satelliteList) {
            System.out.println(satellite);
        }
        System.out.println(DELIMITER);
    }

    private static void createMilitarySatellite() {
        MilitarySatellite militarySatellite = new MilitarySatellite("Повстанец-1", Orbit.POLAR, "Повстанцы");
        System.out.println(militarySatellite.launch(spaceports.get(3)));

        System.out.println(militarySatellite.sendSignal());
        System.out.println(DELIMITER);
        var stringBilder = new StringBuilder();
        var targenList = militarySatellite.targeting(satelliteList, stringBilder);
        System.out.println(stringBilder);
        System.out.println(militarySatellite.emp(targenList));

        System.out.println(DELIMITER);
    }

    public static void main(String[] args) {

        createSatellites();
        printSatellites();
        createMilitarySatellite();

        for (var satellite : satelliteList) {
            System.out.println(satellite.sendSignal());
        }
        System.out.println(DELIMITER);

        printSatellites();
    }
}
