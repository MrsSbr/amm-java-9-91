package org.courses;

import java.time.LocalDate;
import java.util.*;


public class MarketingCampaignFactory {
    public static MarketingCampaign generateMarketingCampaign() {
        Random rand = new Random();
        int dayStart = rand.nextInt(1, 29);
        int monthStart = rand.nextInt(1, 13);
        int yearStart = rand.nextInt(2000, LocalDate.now().getYear() + 1);

        return new MarketingCampaignBuilder()
                .withDateStart(LocalDate.of(yearStart, monthStart, dayStart))
                .withDateEnd(LocalDate.of(rand.nextInt(yearStart, LocalDate.now().getYear() + 3),
                        rand.nextInt(monthStart, 13), rand.nextInt(dayStart, 29)))
                .withType(CampaignType.values()[rand.nextInt(1, CampaignType.values().length)])
                .withCoverage(rand.nextLong())
                .withBudget(rand.nextLong())
                .build();
    }
}
