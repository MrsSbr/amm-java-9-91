package edu.best_car_survey.survey;

import edu.best_car_survey.form.BestCarForm;
import edu.best_car_survey.form.BestCarFormFactory;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.best_car_survey.form.CarBrand;
import org.jetbrains.annotations.NotNull;

public class BestCarSurvey {
    Collection<BestCarForm> survey;

    private BestCarSurvey() {
    }

    BestCarSurvey(@NotNull Collection<BestCarForm> survey) {
        this.survey = survey;
    }

    public static BestCarSurvey generate(int sampleSize,
                                         Supplier<Collection<BestCarForm>> collectionSupplier) {
        if (sampleSize <= 0) {
            throw new IllegalArgumentException("Sample size must be positive");
        }

        BestCarSurvey result = new BestCarSurvey();

        result.survey = Stream.generate(BestCarFormFactory::generate)
                .limit(sampleSize)
                .collect(Collectors.toCollection(collectionSupplier));

        return result;
    }

    public int getSampleSize() {
        return survey.size();
    }

    public Optional<CarBrand> findMostPopularBrand() {
        return survey.stream()
                .collect(Collectors.groupingBy(BestCarForm::brand, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public Map<Integer, Optional<CarBrand>> findMostPopularBrandsByAge() {
        return survey.stream()
                .collect(Collectors.groupingBy(BestCarForm::age,
                        Collectors.groupingBy(BestCarForm::brand, Collectors.counting())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().entrySet().stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)));
    }

    public Set<CarBrand> getUniqueBrands() {
        return survey.stream()
                .map(BestCarForm::brand)
                .collect(Collectors.toSet());
    }
}
