package edu.best_car_survey.survey;

import edu.best_car_survey.form.BestCarForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


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
    public void testFindMostPopularBrand() {
        String expected = "BMW";
        String result = bestCarSurvey.findMostPopularBrand();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testFindMostPopularBrandsByAge() {
        Map<Integer, String> result = bestCarSurvey.findMostPopularBrandsByAge();

        assertThat(result.size()).isEqualTo(4);
        assertThat(result).containsEntry(20, "BMW");
        assertThat(result).containsEntry(30, "Skoda");
        assertThat(result).containsEntry(45, "BMW");
        assertThat(result).containsEntry(60, "Ford");
    }

    @Test
    public void testGetUniqueBrands() {
        List<String> expected = List.of("BMW", "Audi", "Skoda", "Ford", "Peugeot");
        List<String> result = bestCarSurvey.getUniqueBrands();
        assertThat(result.size()).isEqualTo(expected.size());
        assertThat(result).containsAll(expected);
    }
}
