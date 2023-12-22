package edu.deals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import edu.deals.exceptions.DealParseException;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DealsParserTest {
    private static final Path RESOURCES_DIRECTORY = Path.of("src/test/resources");

    @Test
    public void whenOnlyCorrectLinesShouldReturnListOfMatchingDeals() throws IOException {
        List<Deal> result = DealsParser.parseFile(RESOURCES_DIRECTORY.resolve("correct.txt"));
        List<Deal> expected = new ArrayList<>() {{
            add(new Deal("Чайкин", "Иванов", 75000,
                    LocalDate.of(2023, 12, 12)));
            add(new Deal("Чайкин", "Андреев", 80000,
                    LocalDate.of(2023, 12, 20)));
            add(new Deal("Уткин", "Андреев", 35735,
                    LocalDate.of(2022, 9, 9)));
            add(new Deal("Соколовский", "Никитин", 55000,
                    LocalDate.of(2022, 7, 19)));
        }};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenEmptyFileShouldReturnEmptyList() throws IOException {
        List<Deal> result = DealsParser.parseFile(RESOURCES_DIRECTORY.resolve("empty.txt"));
        List<Deal> expected = new ArrayList<>();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenInvalidDealDateShouldThrowException() {
        assertThatExceptionOfType(DealParseException.class)
                .isThrownBy(() -> DealsParser.parseFile(RESOURCES_DIRECTORY.resolve("with_invalid_date.txt")));
    }

    @Test
    public void whenInvalidDealAmountShouldThrowException() {
        assertThatExceptionOfType(DealParseException.class)
                .isThrownBy(() -> DealsParser.parseFile(RESOURCES_DIRECTORY.resolve("with_invalid_amount.txt")));
    }

    @Test
    public void whenEmptyLineShouldThrowException() {
        assertThatExceptionOfType(DealParseException.class)
                .isThrownBy(() -> DealsParser.parseFile(RESOURCES_DIRECTORY.resolve("with_empty_line.txt")));
    }

    @Test
    public void whenLineIsNotInCorrectFormatShouldThrowException() {
        assertThatExceptionOfType(DealParseException.class)
                .isThrownBy(() -> DealsParser.parseFile(RESOURCES_DIRECTORY.resolve("with_incorrect_format_line.txt")));
    }
}
