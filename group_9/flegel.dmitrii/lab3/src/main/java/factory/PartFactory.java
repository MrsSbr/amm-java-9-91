package factory;

import java.util.Random;

public class PartFactory {
    public static Part generatePart() {
        Random random = new Random();

        int randomId = random.nextInt(1000000);
        PartType randomPartType = getRandomPartType();

        return new Part(randomId, randomPartType);
    }

    private static PartType getRandomPartType() {
        PartType[] partTypes = PartType.values();
        Random random = new Random();
        int randomIndex = random.nextInt(partTypes.length);
        return partTypes[randomIndex];
    }
}
