package edu.best_car_survey.survey;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import edu.best_car_survey.form.BestCarForm;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BestCarSurveyTest {
    private BestCarSurvey bestCarSurvey;

    @BeforeEach
    public void setUp() {
        List<BestCarForm> bestCarFormList = new ArrayList<>() {{
            add(new BestCarForm(20, "BMW"));
            add(new BestCarForm(30, "Skoda"));
            add(new BestCarForm(30, "Skoda"));
            add(new BestCarForm(30, "Skoda"));
            add(new BestCarForm(30, "Peugeot"));
            add(new BestCarForm(45, "BMW"));
            add(new BestCarForm(45, "BMW"));
            add(new BestCarForm(45, "BMW"));
            add(new BestCarForm(45, "Audi"));
            add(new BestCarForm(60, "Ford"));
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
        String expected = "BMW";
        String result = bestCarSurvey.findMostPopularBrand().get();
        assertThat(result).isEqualTo(expected);

        BestCarSurvey emptySurvey = new BestCarSurvey(new ArrayList<>());
        assertThat(emptySurvey.findMostPopularBrand()).isEmpty();
    }

    @Test
    public void testFindMostPopularBrandsByAge() {
        Map<Integer, String> result = bestCarSurvey.findMostPopularBrandsByAge();

        assertThat(result.size()).isEqualTo(4);
        assertThat(result).containsEntry(20, "BMW");
        assertThat(result).containsEntry(30, "Skoda");
        assertThat(result).containsEntry(45, "BMW");
        assertThat(result).containsEntry(60, "Ford");

        BestCarSurvey emptySurvey = new BestCarSurvey(new ArrayList<>());
        assertThat(emptySurvey.findMostPopularBrandsByAge()).isEmpty();
    }

    @Test
    public void testGetUniqueBrands() {
        Set<String> expected = Set.of("BMW", "Audi", "Skoda", "Ford", "Peugeot");
        Set<String> result = bestCarSurvey.getUniqueBrands();
        assertThat(result.size()).isEqualTo(expected.size());
        assertThat(result).containsAll(expected);

        BestCarSurvey emptySurvey = new BestCarSurvey(new ArrayList<>());
        assertThat(emptySurvey.getUniqueBrands()).isEmpty();
    }
}
