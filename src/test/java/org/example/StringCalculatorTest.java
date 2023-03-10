package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void empty_string_should_add_to_zero() {
        assertThat(calculator.add("")).isZero();
    }

    @ParameterizedTest(name = "input numbers {0} add to {1}")
    @CsvSource({
            "1, 1",
            "2, 2",
            "10, 10",
            "2022, 2022",
    })
    void single_number_string_should_add_to_that_number(String input, int sumExpected) {
        assertThat(calculator.add(input)).isEqualTo(sumExpected);
    }

    @Test
    void adding_two_numbers_should_return_their_sum() {
        assertThat(calculator.add("12,23")).isEqualTo(35);
    }

    @Test
    void adding_unknown_number_of_numbers() {
        assertThat(calculator.add("1,2,3,4,5,6,7,8,9")).isEqualTo(45);
    }
}
