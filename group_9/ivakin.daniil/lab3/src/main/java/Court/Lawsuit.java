package Court;

import java.time.LocalDate;

public class Lawsuit {
    private String suiterName;
    private String defendantName;
    private LocalDate date;
    private int clause;
    private boolean isSuited;

    public Lawsuit(String suiterName, String defendantName, LocalDate date, int clause, boolean isSuited) {
        this.suiterName = suiterName;
        this.defendantName = defendantName;
        this.date = date;
        this.clause = clause;
        this.isSuited = isSuited;
    }

    public String getSuiterName() {
        return suiterName;
    }

    public void setSuiterName(String suiterName) {
        this.suiterName = suiterName;
    }

    public String getDefendantName() {
        return defendantName;
    }

    public void setDefendantName(String defendantName) {
        this.defendantName = defendantName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getClause() {
        return clause;
    }

    public void setClause(int clause) {
        this.clause = clause;
    }

    public boolean isSuited() {
        return isSuited;
    }

    public void setSuitResult(boolean isSuited) {
        this.isSuited = isSuited;
    }
}
