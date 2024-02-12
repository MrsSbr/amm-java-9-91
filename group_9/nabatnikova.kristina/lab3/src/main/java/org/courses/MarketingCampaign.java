package org.courses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class MarketingCampaign {
    private final LocalDate dateStart;
    private final LocalDate dateEnd;
    private final CampaignType type;
    private final Long coverage;
    private final Long budget;

    public MarketingCampaign(LocalDate dateStart, LocalDate dateEnd, CampaignType type, Long coverage, Long budget) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.type = type;
        this.coverage = coverage;
        this.budget = budget;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public CampaignType getType() {
        return type;
    }

    public Long getCoverage() {
        return coverage;
    }

    public Long getBudget() {
        return budget;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        MarketingCampaign that = (MarketingCampaign) object;

        if (!Objects.equals(dateStart, that.dateStart)) return false;
        if (!Objects.equals(dateEnd, that.dateEnd)) return false;
        if (type != that.type) return false;
        if (!Objects.equals(coverage, that.coverage)) return false;
        return Objects.equals(budget, that.budget);
    }

    @Override
    public int hashCode() {
        int result = dateStart != null ? dateStart.hashCode() : 0;
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (coverage != null ? coverage.hashCode() : 0);
        result = 31 * result + (budget != null ? budget.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MarketingCampaign{" +
                "dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", type=" + type +
                ", coverage=" + coverage +
                ", budget=" + budget +
                '}';
    }
}
