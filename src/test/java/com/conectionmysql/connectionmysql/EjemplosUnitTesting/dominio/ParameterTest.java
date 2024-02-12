package com.conectionmysql.connectionmysql.EjemplosUnitTesting.dominio;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterTest {

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "other" })
    void palindromes(String candidate) {
        assertTrue(candidate.matches("[a-z]+"));
    }
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
    FRUIT,         RANK
    apple,         1
    banana,        2
    'lemon', 0xF1
    strawberry,    700_000
    """)
    void testWithCsvSource(String fruit, int rank) {
        System.out.println(fruit + rank);
        assertTrue(fruit.matches("[a-zA-Z]+"));
    }
}
