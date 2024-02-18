package org.example;


import java.time.LocalDate;

public class CourtCase {
    private String defendantName;
    private String plaintiffName;
    private LocalDate eventDate;
    private int articleNumber;
    private TrialVerdict verdict;

    public CourtCase(String defendantName, String plaintiffName, LocalDate eventDate, int articleNumber, TrialVerdict verdict) {
        this.defendantName = defendantName;
        this.plaintiffName = plaintiffName;
        this.eventDate = eventDate;
        this.articleNumber = articleNumber;
        this.verdict = verdict;
    }
    public String getDefendantName() {
        return defendantName;
    }
    public void setDefendantName(String defendantName) {
        this.defendantName = defendantName;
    }
    public String getPlaintiffName() {
        return plaintiffName;
    }
    public void setPlaintiffName(String plaintiffName) {
        this.plaintiffName = plaintiffName;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
    public int getArticleNumber() {
        return articleNumber;
    }
    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }
    public TrialVerdict getResult () {
        return verdict;
    }
    public void setResult(TrialVerdict verdict) {
        this.verdict = verdict;
    }
}
