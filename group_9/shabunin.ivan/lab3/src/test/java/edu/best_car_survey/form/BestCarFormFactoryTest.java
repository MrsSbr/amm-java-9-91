package edu.best_car_survey.form;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BestCarFormFactoryTest {
    private static final int TEST_REPETITIONS_COUNT = 500;

    @RepeatedTest(TEST_REPETITIONS_COUNT)
    public void shouldReturnBestCarFormWithAgeInDiapason() {
        int age = BestCarFormFactory.generate().age();
        assertThat(age >= BestCarFormFactory.LOWER_AGE
                && age <= BestCarFormFactory.UPPER_AGE).isTrue();
    }

    @RepeatedTest(TEST_REPETITIONS_COUNT)
    public void shouldReturnBestCarFormWithBrandFromBrandsList() {
        CarBrand brand = BestCarFormFactory.generate().brand();
        assertThat(BestCarFormFactory.BRANDS).contains(brand);
    }

    @Test
    public void shouldNotReturnFixedBestCarForm() {
        Set<BestCarForm> forms = new HashSet<>();
        for (int i = 0; i < 5; ++i) {
            forms.add(BestCarFormFactory.generate());
        }
        assertThat(forms.size()).isGreaterThan(1);
    }
}
