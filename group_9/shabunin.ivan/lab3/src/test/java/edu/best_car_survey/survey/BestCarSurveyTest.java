package edu.best_car_survey.survey;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import edu.best_car_survey.form.BestCarForm;

import edu.best_car_survey.form.CarBrand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.Set;

public class BestCarSurveyTest {
    private BestCarSurvey bestCarSurvey;

    @BeforeEach
    public void setUp() {
        List<BestCarForm> bestCarFormList = new ArrayList<>() {{
            add(new BestCarForm(20, CarBrand.BMW));
            add(new BestCarForm(30, CarBrand.SKODA));
            add(new BestCarForm(30, CarBrand.SKODA));
            add(new BestCarForm(30, CarBrand.SKODA));
            add(new BestCarForm(30, CarBrand.PEUGEOT));
            add(new BestCarForm(45, CarBrand.BMW));
            add(new BestCarForm(45, CarBrand.BMW));
            add(new BestCarForm(45, CarBrand.BMW));
            add(new BestCarForm(45, CarBrand.AUDI));
            add(new BestCarForm(60, CarBrand.FORD));
        }};

        bestCarSurvey = new BestCarSurvey(bestCarFormList);
    }

    @Test
    public void testGenerate() {
        BestCarSurvey generated = BestCarSurvey.generate(100, LinkedList::new);
        assertThat(generated.getSampleSize()).isEqualTo(100);
        assertThat(generated.survey instanceof LinkedList).isTrue();
    }

    @Test
    public void testGenerateWhenNonPositiveSampleSizeShouldThrowException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BestCarSurvey.generate(-1, LinkedList::new));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BestCarSurvey.generate(0, LinkedList::new));
    }

    @Test
    public void testFindMostPopularBrand() {
        CarBrand expected = CarBrand.BMW;
        CarBrand result = bestCarSurvey.findMostPopularBrand().get();
        assertThat(result).isEqualTo(expected);

        BestCarSurvey emptySurvey = new BestCarSurvey(new ArrayList<>());
        assertThat(emptySurvey.findMostPopularBrand()).isEmpty();
    }

    @Test
    public void testFindMostPopularBrandsByAge() {
        Map<Integer, Optional<CarBrand>> result = bestCarSurvey.findMostPopularBrandsByAge();

        assertThat(result.size()).isEqualTo(4);
        assertThat(result).containsEntry(20, Optional.of(CarBrand.BMW));
        assertThat(result).containsEntry(30, Optional.of(CarBrand.SKODA));
        assertThat(result).containsEntry(45, Optional.of(CarBrand.BMW));
        assertThat(result).containsEntry(60, Optional.of(CarBrand.FORD));

        BestCarSurvey emptySurvey = new BestCarSurvey(new ArrayList<>());
        assertThat(emptySurvey.findMostPopularBrandsByAge()).isEmpty();
    }

    @Test
    public void testGetUniqueBrands() {
        Set<CarBrand> expected = Set.of(CarBrand.BMW, CarBrand.AUDI, CarBrand.SKODA, CarBrand.FORD, CarBrand.PEUGEOT);
        Set<CarBrand> result = bestCarSurvey.getUniqueBrands();
        assertThat(result.size()).isEqualTo(expected.size());
        assertThat(result).containsAll(expected);

        BestCarSurvey emptySurvey = new BestCarSurvey(new ArrayList<>());
        assertThat(emptySurvey.getUniqueBrands()).isEmpty();
    }
}
