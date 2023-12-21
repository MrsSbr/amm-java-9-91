package ru.ponitkovdaniil.delivery;

import java.time.LocalDate;
import java.util.Random;

public class DeliveryDataGenerator {
    public static DeliveryRecord generateData() {
        Random random = new Random();
        return new DeliveryRecord(
                LocalDate.now().minusDays(random.nextInt(365)),
                random.nextDouble() * 10,
                random.nextInt(24));
    }
}
