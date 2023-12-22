package org.example;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @param date             Дата; название цветка; количество воды для полива; марка удобрения, если было использовано
 * @param amountOfWatering Для удобства предположим, что в литрах
 */
public record DataPlant(LocalDate date, String nameFlower, double amountOfWatering, String brandOfFertilizer) {

    public boolean isFertilized() {
        return !brandOfFertilizer.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataPlant that = (DataPlant) o;
        return Double.compare(that.amountOfWatering, amountOfWatering) == 0 && date.equals(that.date)
                && nameFlower.equals(that.nameFlower) && Objects.equals(brandOfFertilizer, that.brandOfFertilizer);
    }

    @Override
    public String toString() {
        return "FileWithDataPlant{" +
                "date=" + date +
                ", nameFlower='" + nameFlower + '\'' +
                ", amountOfWatering=" + amountOfWatering +
                ", brandOfFertilizer='" + brandOfFertilizer + '\'' +
                '}';
    }
}
