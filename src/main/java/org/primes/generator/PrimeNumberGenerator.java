package org.primes.generator;

import java.util.List;

/**
 * Class used to generate and determine prime values.
 * <p>
 * Default Implementation: {@link PrimeNumberGeneratorImpl}
 */
interface PrimeNumberGenerator {

    /**
     * Generates prime numbers between the starting and ending value.
     *
     * @param startingValue The lower bound for generating values.
     * @param endingValue   The upper bound for generating values.
     * @return {@link List} of {@link Integer}s containing the prime values.
     * @throws IllegalArgumentException if startingValue is below zero.
     * @throws IllegalArgumentException if endingValue is below zero.
     */
    List<Integer> generate(int startingValue, int endingValue);

    /**
     * Determines is a given value is prime.
     *
     * @param value The number to validate.
     * @return True if the number is prime false otherwise.
     */
    boolean isPrime(int value);
}
