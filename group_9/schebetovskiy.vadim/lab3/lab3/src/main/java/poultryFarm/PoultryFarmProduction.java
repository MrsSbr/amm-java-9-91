package poultryFarm;

import java.time.LocalDate;

public class PoultryFarmProduction {
    private BirdType birdType;
    private int numberOfEggsProduced;
    private LocalDate productionDate;

    public PoultryFarmProduction(BirdType birdType, int numberOfEggsProduced, LocalDate productionDate) {
        this.birdType = birdType;
        this.numberOfEggsProduced = numberOfEggsProduced;
        this.productionDate = productionDate;
    }

    public BirdType getBirdType() {
        return birdType;
    }

    public void setBirdType(BirdType birdType) {
        this.birdType = birdType;
    }

    public int getNumberOfEggsProduced() {
        return numberOfEggsProduced;
    }

    public void setNumberOfEggsProduced(int numberOfEggsProduced) {
        this.numberOfEggsProduced = numberOfEggsProduced;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }
}
