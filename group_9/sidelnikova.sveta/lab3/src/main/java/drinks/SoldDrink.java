package drinks;

import java.time.LocalDate;
import java.time.LocalTime;

public record SoldDrink(DrinkType type, LocalDate saleDate, LocalTime saleTime) {
}
