package com.conectionmysql.connectionmysql.EjemplosUnitTesting.dominio;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class TimeOutsTest {
    @Test
    @Tag("TimeFail")
    @Timeout(1)
    void shouldFailAfterOneSecond() throws InterruptedException {
        Thread.sleep(10_000);
    }

    @Test
    @Tag("TimeFail")
    @Timeout(value = 2, unit = TimeUnit.MINUTES)
    void shouldFailAfterTwoMinutes() throws InterruptedException {
        Thread.sleep(10_000);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void failsIfExecutionTimeExceeds500Milliseconds() {
        // fails if execution time exceeds 500 milliseconds
    }

    @Test
    void assertionTimeOut() {
        assertTimeout(Duration.ofSeconds(5), () -> TimeUnit.MILLISECONDS.sleep(5500));
    }

    @Test
    void assertionTimeOutMathRandom() {
        assertTimeout(Duration.ofSeconds(2), Math::random);
    }


}
