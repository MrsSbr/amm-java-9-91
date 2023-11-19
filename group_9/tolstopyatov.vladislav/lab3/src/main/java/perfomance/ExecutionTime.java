package perfomance;

public class ExecutionTime {
    private long creation;
    private long theNumberOfSacrificesAfterWhichRainFellTheNextDay;
    private long theLastMonthInWhichThereWereNoAnimalSacrifices;
    private long compareTheEffectivenessOfHumanSacrificesComparedToAnimals;

    public ExecutionTime(long creation, long theNumberOfSacrificesAfterWhichRainFellTheNextDay, long theLastMonthInWhichThereWereNoAnimalSacrifices, long compareTheEffectivenessOfHumanSacrificesComparedToAnimals) {
        this.creation = creation;
        this.theNumberOfSacrificesAfterWhichRainFellTheNextDay = theNumberOfSacrificesAfterWhichRainFellTheNextDay;
        this.theLastMonthInWhichThereWereNoAnimalSacrifices = theLastMonthInWhichThereWereNoAnimalSacrifices;
        this.compareTheEffectivenessOfHumanSacrificesComparedToAnimals = compareTheEffectivenessOfHumanSacrificesComparedToAnimals;
    }

    public long getCreation() {
        return creation;
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

    public void setCreation(long creation) {
        this.creation = creation;
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
