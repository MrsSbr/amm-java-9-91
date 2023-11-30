package solddrink.utils;

import drinks.SoldDrink;

import java.util.Comparator;

public class SoldDrinkDateTimeTypeComparator implements Comparator<SoldDrink> {
    @Override
    public int compare(SoldDrink drink1, SoldDrink drink2) {
        int dateComparison = drink1.saleDate().compareTo(drink2.saleDate());
        if (dateComparison != 0) {
            return dateComparison;
        }
        int timeComparison = drink1.saleTime().compareTo(drink2.saleTime());
        if (timeComparison != 0) {
            return timeComparison;
        }
        return drink1.type().compareTo(drink2.type());
    }
}
