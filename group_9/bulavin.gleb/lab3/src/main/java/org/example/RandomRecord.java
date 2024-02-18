package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class RandomRecord {
    private static final List<String> NAMES;
    static {
        NAMES = List.of(
                "Alberty",
                "Alexander",
                "Allard",
                "Allen",
                "Anderson",
                "Bailiff",
                "Bell",
                "Bennett",
                "Biffle",
                "Brooks",
                "Brown",
                "Butler",
                "Castillo",
                "Chia",
                "Christensen"
        );
    }
    private String getRandomName() {
        Random rand = new Random();
        int nameIndex = rand.nextInt(NAMES.size());
        return NAMES.get(nameIndex);
    }
    private LocalDate getRandomDate() {
        Random rand = new Random();
        int year  = rand.nextInt(50) + LocalDate.now().getYear() - 50;
        int mouth = rand.nextInt(12) + 1;
        int day = rand.nextInt(28) + 1;
        return LocalDate.of(year, mouth, day);
    }
    private TrialVerdict getRandomTrialResult() {
        Random rand = new Random();
        int trialResultIndex = rand.nextInt(TrialVerdict.values().length);
        return switch (trialResultIndex) {
            case 0 -> TrialVerdict.ACQUITTED;
            case 1 -> TrialVerdict.CONVICTED;
            default -> TrialVerdict.CONVICTED;
        };
    }
    public CourtCase getRecording() {
        Random rand = new Random();
        int articleNumber = rand.nextInt(400);
        return new CourtCase(getRandomName(), getRandomName(), getRandomDate(), articleNumber, getRandomTrialResult());
    }
}
