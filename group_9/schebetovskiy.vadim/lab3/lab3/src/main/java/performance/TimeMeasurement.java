package performance;

public class TimeMeasurement {
    private long creation;
    private long birdTypesByCond;
    private long theMostProductiveMonth;
    private long totalNumberOfEggsProduced;

    public TimeMeasurement(long creation, long birdTypesByCond, long theMostProductiveMonth, long totalNumberOfEggsProduced) {
        this.creation = creation;
        this.birdTypesByCond = birdTypesByCond;
        this.theMostProductiveMonth = theMostProductiveMonth;
        this.totalNumberOfEggsProduced = totalNumberOfEggsProduced;
    }

    public long getCreation() {
        return creation;
    }

    public void setCreation(long creation) {
        this.creation = creation;
    }

    public long getBirdTypesByCond() {
        return birdTypesByCond;
    }

    public void setBirdTypesByCond(long birdTypesByCond) {
        this.birdTypesByCond = birdTypesByCond;
    }

    public long getTheMostProductiveMonth() {
        return theMostProductiveMonth;
    }

    public void setTheMostProductiveMonth(long theMostProductiveMonth) {
        this.theMostProductiveMonth = theMostProductiveMonth;
    }

    public long getTotalNumberOfEggsProduced() {
        return totalNumberOfEggsProduced;
    }

    public void setTotalNumberOfEggsProduced(long totalNumberOfEggsProduced) {
        this.totalNumberOfEggsProduced = totalNumberOfEggsProduced;
    }
}