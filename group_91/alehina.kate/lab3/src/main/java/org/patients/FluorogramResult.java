package org.patients;

import java.util.Random;

public enum FluorogramResult {
    NOT_DETECTED("Не обнаружено"),
    DETECTED("Обнаружено"),
    ADDITIONAL_EXAMINATION("Дополнительное обследование");

    private final String resultName;
    private static final Random random = new Random();

    private FluorogramResult(String resultName) {
        this.resultName = resultName;
    }

    public String getResultName() {
        return resultName;
    }

    public static FluorogramResult randomResult() {
        FluorogramResult[] results = values();
        return results[random.nextInt(results.length)];
    }
}
