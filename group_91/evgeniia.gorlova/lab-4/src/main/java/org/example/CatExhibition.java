package org.example;

import java.util.ArrayList;
import java.util.List;

public class CatExhibition {
    private List<Cat> winners;

    public CatExhibition() {
        winners = new ArrayList<>();
    }

    public void addWinner(Cat cat) {
        winners.add(cat);
    }

    public List<Cat> getWinners() {
        return winners;
    }
}
