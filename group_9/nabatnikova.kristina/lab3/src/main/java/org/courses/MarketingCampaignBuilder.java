package org.courses;

import java.time.LocalDate;

public class MarketingCampaignBuilder {
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private CampaignType type;
    private Long coverage;
    private Long budget;

    public MarketingCampaignBuilder withDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public MarketingCampaignBuilder withDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public MarketingCampaignBuilder withType(CampaignType type) {
        this.type = type;
        return this;
    }

    public MarketingCampaignBuilder withCoverage(Long coverage) {
        this.coverage = coverage;
        return this;
    }

    public MarketingCampaignBuilder withBudget(Long budget) {
        this.budget = budget;
        return this;
    }

    public MarketingCampaign build() {
        return new MarketingCampaign(dateStart, dateEnd, type, coverage, budget);
    }
}
