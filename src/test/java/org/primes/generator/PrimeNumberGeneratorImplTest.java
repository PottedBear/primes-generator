package org.primes.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link PrimeNumberGeneratorImpl}
 */
public class PrimeNumberGeneratorImplTest {

    private PrimeNumberGenerator primeNumberGenerator;

    @BeforeEach
    public void beforeEach() {
        primeNumberGenerator = new PrimeNumberGeneratorImpl();
    }

    @Test
    public void testGenerate1to100() {
        List<Integer> listToCheck = primeNumberGenerator.generate(1, 100);

        assertThat(listToCheck).containsExactly(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
    }

    @Test
    public void testGenerate7900to7920() {
        List<Integer> listToCheck = primeNumberGenerator.generate(7900, 7920);

        assertThat(listToCheck).containsExactly(7901, 7907, 7919);
    }

    @Test
    public void testGenerateStartingValueZero() {
        assertThatThrownBy(() -> primeNumberGenerator.generate(0, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("StartingValue must be greater than zero.");
    }

    @Test
    public void testGenerate0EndingValueZero() {
        assertThatThrownBy(() -> primeNumberGenerator.generate(100, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("EndingValue must be greater than zero.");
    }

    @Test
    public void testGenerateStartingValueNegative() {
        assertThatThrownBy(() -> primeNumberGenerator.generate(-1, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("StartingValue must be greater than zero.");
    }

    @Test
    public void testGenerate0EndingValueNegative() {
        assertThatThrownBy(() -> primeNumberGenerator.generate(100, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("EndingValue must be greater than zero.");
    }

    @Test
    public void testIsNegativePrime() {
        assertFalse(primeNumberGenerator.isPrime(-1));
    }

    @Test
    public void testIs0Prime() {
        assertFalse(primeNumberGenerator.isPrime(0));
    }

    @Test
    public void testIs1Prime() {
        assertFalse(primeNumberGenerator.isPrime(1));
    }

    @Test
    public void testIs3Prime() {
        assertTrue(primeNumberGenerator.isPrime(3));
    }

    @Test
    public void testIs4Prime() {
        assertFalse(primeNumberGenerator.isPrime(4));
    }

    @Test
    public void testIs1111Prime() {
        assertFalse(primeNumberGenerator.isPrime(1111));
    }

    @Test
    public void testIs14009Prime() {
        assertTrue(primeNumberGenerator.isPrime(14009));
    }
}
