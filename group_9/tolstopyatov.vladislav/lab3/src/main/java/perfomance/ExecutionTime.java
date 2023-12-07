package perfomance;

public class ExecutionTime {
    private long theNumberOfSacrificesAfterWhichRainFellTheNextDay;
    private long theLastMonthInWhichThereWereNoAnimalSacrifices;
    private long compareTheEffectivenessOfHumanSacrificesComparedToAnimals;

    public ExecutionTime(
            long theNumberOfSacrificesAfterWhichRainFellTheNextDay,
            long theLastMonthInWhichThereWereNoAnimalSacrifices,
            long compareTheEffectivenessOfHumanSacrificesComparedToAnimals
    ) {
        this.theNumberOfSacrificesAfterWhichRainFellTheNextDay = theNumberOfSacrificesAfterWhichRainFellTheNextDay;
        this.theLastMonthInWhichThereWereNoAnimalSacrifices = theLastMonthInWhichThereWereNoAnimalSacrifices;
        this.compareTheEffectivenessOfHumanSacrificesComparedToAnimals = compareTheEffectivenessOfHumanSacrificesComparedToAnimals;
    }

    public long getTheNumberOfSacrificesAfterWhichRainFellTheNextDay() {
        return theNumberOfSacrificesAfterWhichRainFellTheNextDay;
    }

    public long getTheLastMonthInWhichThereWereNoAnimalSacrifices() {
        return theLastMonthInWhichThereWereNoAnimalSacrifices;
    }

    public long getCompareTheEffectivenessOfHumanSacrificesComparedToAnimals() {
        return compareTheEffectivenessOfHumanSacrificesComparedToAnimals;
    }

    public void setTheNumberOfSacrificesAfterWhichRainFellTheNextDay(long theNumberOfSacrificesAfterWhichRainFellTheNextDay) {
        this.theNumberOfSacrificesAfterWhichRainFellTheNextDay = theNumberOfSacrificesAfterWhichRainFellTheNextDay;
    }

    public void setTheLastMonthInWhichThereWereNoAnimalSacrifices(long theLastMonthInWhichThereWereNoAnimalSacrifices) {
        this.theLastMonthInWhichThereWereNoAnimalSacrifices = theLastMonthInWhichThereWereNoAnimalSacrifices;
    }

    public void setCompareTheEffectivenessOfHumanSacrificesComparedToAnimals(long compareTheEffectivenessOfHumanSacrificesComparedToAnimals) {
        this.compareTheEffectivenessOfHumanSacrificesComparedToAnimals = compareTheEffectivenessOfHumanSacrificesComparedToAnimals;
    }
}
