package Court.performance;
public class TimeMeasurement {
    private long creation;
    private long unsuitedPeopleCount;
    private long peopleWithClausesInTenYears;
    private long peopleWithSuitsInThreeYears;

    public TimeMeasurement(long creation, long unsuitedPeopleCount, long peopleWithClausesInTenYears, long peopleWithSuitsInThreeYears) {
        this.creation = creation;
        this.unsuitedPeopleCount = unsuitedPeopleCount;
        this.peopleWithClausesInTenYears = peopleWithClausesInTenYears;
        this.peopleWithSuitsInThreeYears = peopleWithSuitsInThreeYears;
    }

    public long getCreation() {
        return creation;
    }

    public void setCreation(long creation) {
        this.creation = creation;
    }

    public long getUnsuitedPeopleCount() {
        return unsuitedPeopleCount;
    }

    public void setUnsuitedPeopleCount(long unsuitedPeopleCount) {
        this.unsuitedPeopleCount = unsuitedPeopleCount;
    }

    public long getPeopleWithClausesInTenYears() {
        return peopleWithClausesInTenYears;
    }

    public void setPeopleWithClausesInTenYears(long peopleWithClausesInTenYears) {
        this.peopleWithClausesInTenYears = peopleWithClausesInTenYears;
    }

    public long getPeopleWithSuitsInThreeYears() {
        return peopleWithSuitsInThreeYears;
    }

    public void setPeopleWithSuitsInThreeYears(long peopleWithSuitsInThreeYears) {
        this.peopleWithSuitsInThreeYears = peopleWithSuitsInThreeYears;
    }
}
