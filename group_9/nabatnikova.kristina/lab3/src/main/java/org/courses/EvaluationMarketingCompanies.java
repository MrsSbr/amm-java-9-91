package org.courses;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class EvaluationMarketingCompanies {
    private final Collection<MarketingCampaign> marketingCampaigns;

    public EvaluationMarketingCompanies(Collection<MarketingCampaign> marketingCampaigns) {
        this.marketingCampaigns = marketingCampaigns;
    }

    public Double AverageCampaignDuration() {
        return marketingCampaigns.stream()
                .mapToLong(companies -> ChronoUnit.DAYS.between(companies.getDateStart(), companies.getDateEnd()))
                .average()
                .orElse(0);
    }

    public Set<CampaignType> TypesOfCompaniesConductedOverThePastYear() {
        LocalDate lastYearStart = LocalDate.now().minusYears(1).withDayOfYear(1);
        return marketingCampaigns.stream()
                .filter(campaign -> campaign.getDateStart().isAfter(lastYearStart))
                .map(MarketingCampaign::getType)
                .collect(Collectors.toSet());
    }

    public Set<MarketingCampaign> BestCampaignInTermsOfBudgetCoverageRatio() {
        Set<MarketingCampaign> campaigns = new HashSet<>();
        if (marketingCampaigns.isEmpty()) {
            throw new RuntimeException();
        }
        marketingCampaigns.stream().forEach(campaign -> {
            Optional<MarketingCampaign> firstCampaignOptional = campaigns.stream().findFirst();
            if (firstCampaignOptional.isPresent()) { //проверяет есть ли в campaigns значение
                try {
                    MarketingCampaign firstCampaign = firstCampaignOptional.get();
                    double bestRatio = firstCampaign.getBudget().doubleValue() / firstCampaign.getCoverage().doubleValue();
                    double currentRatio = campaign.getBudget().doubleValue() / campaign.getCoverage().doubleValue();
                    if (currentRatio < bestRatio) {
                        campaigns.clear();
                        campaigns.add(campaign);
                    } else if (currentRatio == bestRatio) {
                        campaigns.add(campaign);
                    }
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            } else {
                if (campaign.getCoverage() == null || campaign.getBudget() == null) {
                    throw new RuntimeException();
                }
                campaigns.add(campaign);
            }
        });
        return campaigns;
    }
}