import classes.ConstructionVehicle;
import classes.Crane;
import classes.Truck;
import collectors.CollectorByClassName;
import enums.BodyType;
import enums.CraneBrand;
import enums.CraneStrokeType;
import enums.FuelType;
import enums.TruckBrand;
import enums.TypeCraneConstruction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConstructionVehicleRunner {

    private static final String DELIMITER = "\n\t\t";

    public static void main(String[] args) {
        ConstructionVehicle truck1 = new Truck(
                TruckBrand.DAF,
                FuelType.GASOLINE,
                BodyType.CLOSED,
                120000
        );
        ConstructionVehicle truck2 = new Truck(
                TruckBrand.IVECO,
                FuelType.DIESEL,
                BodyType.OPEN,
                250000
        );
        ConstructionVehicle truck3 = new Truck(
                TruckBrand.SCANIA,
                FuelType.DIESEL,
                BodyType.CLOSED,
                210000
        );

        ConstructionVehicle crane1 = new Crane(
                CraneBrand.SANY,
                TypeCraneConstruction.BOOM,
                CraneStrokeType.WHEELED,
                5000
        );

        ConstructionVehicle crane2 = new Crane(
                CraneBrand.SANY,
                TypeCraneConstruction.BOOM,
                CraneStrokeType.WHEELED,
                30000
        );
        ConstructionVehicle crane3 = new Crane(
                CraneBrand.ZOOMILON,
                TypeCraneConstruction.CABLE,
                CraneStrokeType.CRAWLER,
                45000
        );
        ConstructionVehicle crane4 = new Crane(
                CraneBrand.DEMAG,
                TypeCraneConstruction.BRIDGE,
                CraneStrokeType.WHEELED,
                32000
        );
        List<ConstructionVehicle> vehicles = List.of(truck1, truck2, truck3,
                crane1, crane2, crane3, crane4);
        Collector<ConstructionVehicle,
                Map<String, List<ConstructionVehicle>>,
                Map<String, List<ConstructionVehicle>>> collector = new CollectorByClassName();
        Map<String, List<ConstructionVehicle>> result = vehicles.stream()
                .collect(collector);
        printMap(result);
    }

    private static void printMap(Map<String, List<ConstructionVehicle>> map) {
        for (var entry : map.entrySet()) {
            String key = entry.getKey();
            String values = entry.getValue().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(DELIMITER));
            String result = key + ":" + DELIMITER + values;
            System.out.println(result);
        }
    }
}
