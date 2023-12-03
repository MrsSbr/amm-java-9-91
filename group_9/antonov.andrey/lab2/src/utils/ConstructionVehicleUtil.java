package utils;

import classes.Crane;
import classes.Truck;
import classes.ConstructionVehicle;

public final class ConstructionVehicleUtil {

    private static final String TRUCK_CLASS_NAME = "Truck";
    private static final String CRANE_CLASS_NAME = "Crane";
    private static final String UNDEFINED_CLASS_NAME = "UNDEFINED";

    private ConstructionVehicleUtil() {
    }

    public static String getNameClassConstructionMachine(ConstructionVehicle constructionVehicle) {
        if (isTruck(constructionVehicle)) {
            return TRUCK_CLASS_NAME;
        } else if (isCrane(constructionVehicle)) {
            return CRANE_CLASS_NAME;
        }
        return UNDEFINED_CLASS_NAME;
    }

    private static boolean isTruck(ConstructionVehicle constructionVehicle) {
        return constructionVehicle instanceof Truck;
    }

    private static boolean isCrane(ConstructionVehicle constructionVehicle) {
        return constructionVehicle instanceof Crane;
    }
}
