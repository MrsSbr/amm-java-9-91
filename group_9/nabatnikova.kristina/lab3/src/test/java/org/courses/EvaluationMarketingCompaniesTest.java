package org.courses;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class EvaluationMarketingCompaniesTest {
    private final List<MarketingCampaign> storage = List.of(
            new MarketingCampaign(LocalDate.of(2023, 12, 10),
                    LocalDate.of(2024, 2, 10),
                    CampaignType.CALL, 10000L, 500000L),
            new MarketingCampaign(LocalDate.of(2022, 8, 22),
                    LocalDate.of(2023, 2, 15),
                    CampaignType.SMS, 50000L, 750000L),
            new MarketingCampaign(LocalDate.of(2022, 4, 5),
                    LocalDate.of(2023, 6, 18),
                    CampaignType.MAILING_LIST, 1000L, 100000L));
    private final List<MarketingCampaign> emptyStorage = List.of();
    private final List<MarketingCampaign> storageNullCoverageAndBudget = List.of(
            new MarketingCampaign(LocalDate.of(2023, 4, 5),
                    LocalDate.of(2022, 6, 18),
                    CampaignType.MAILING_LIST, null, null));
    private final List<Supplier<Collection<MarketingCampaign>>> listSuppliers = List.of(
            LinkedList::new,
            ArrayList::new,
            HashSet::new
    );

    private Collection<MarketingCampaign> getCollection(Supplier<Collection<MarketingCampaign>> supplier,
                                                        List<MarketingCampaign> storage) {
        Collection<MarketingCampaign> collection = supplier.get();
        collection.addAll(storage);
        return collection;
    }

    @Test
    void averageCampaignDuration() {
        for (Supplier<Collection<MarketingCampaign>> supplier : listSuppliers) {
            EvaluationMarketingCompanies appraiser = new EvaluationMarketingCompanies(getCollection(supplier, storage));
            assertEquals(226D, appraiser.AverageCampaignDuration());
        }
    }


    @Test
    void typesOfCompaniesConductedOverThePastYear() {
        for (Supplier<Collection<MarketingCampaign>> supplier : listSuppliers) {
            EvaluationMarketingCompanies appraiser = new EvaluationMarketingCompanies(getCollection(supplier, storage));
            Set<CampaignType> result = Set.of(CampaignType.CALL);
            assertEquals(result, appraiser.TypesOfCompaniesConductedOverThePastYear());
        }
    }

    @Test
    void bestCampaignInTermsOfBudgetCoverageRatio() {
        for (Supplier<Collection<MarketingCampaign>> supplier : listSuppliers) {
            EvaluationMarketingCompanies appraiser = new EvaluationMarketingCompanies(getCollection(supplier, storage));
            Set<MarketingCampaign> result = Set.of(storage.get(1));
            assertEquals(result, appraiser.BestCampaignInTermsOfBudgetCoverageRatio());
        }
    }

    @Test
    void averageCampaignDurationEmptyCollection() {
        for (Supplier<Collection<MarketingCampaign>> supplier : listSuppliers) {
            EvaluationMarketingCompanies appraiser = new EvaluationMarketingCompanies(getCollection(supplier, emptyStorage));
            assertEquals(0, appraiser.AverageCampaignDuration());
        }
    }

    @Test
    void typesOfCompaniesConductedOverThePastYearEmptyCollection() {
        for (Supplier<Collection<MarketingCampaign>> supplier : listSuppliers) {
            EvaluationMarketingCompanies appraiser = new EvaluationMarketingCompanies(getCollection(supplier, emptyStorage));
            assertEquals(new HashSet<>(), appraiser.TypesOfCompaniesConductedOverThePastYear());
        }
    }

    @Test
    void bestCampaignInTermsOfBudgetCoverageRatioEmptyCollection() {
        for (Supplier<Collection<MarketingCampaign>> supplier : listSuppliers) {
            EvaluationMarketingCompanies appraiser = new EvaluationMarketingCompanies(getCollection(supplier, emptyStorage));
            assertThrows(RuntimeException.class, appraiser::BestCampaignInTermsOfBudgetCoverageRatio);
        }
    }

    @Test
    void bestCampaignInTermsOfBudgetCoverageRatioNullCoverageAndBudget() {
        for (Supplier<Collection<MarketingCampaign>> supplier : listSuppliers) {
            EvaluationMarketingCompanies appraiser = new EvaluationMarketingCompanies(getCollection(supplier, storageNullCoverageAndBudget));
            assertThrows(RuntimeException.class, appraiser::BestCampaignInTermsOfBudgetCoverageRatio);
        }
    }
}