package org.primes.generator;

import com.google.common.base.Preconditions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Implementation of {@link PrimeNumberGenerator}
 */
public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> generate(int startingValue, int endingValue) {
        Preconditions.checkArgument(startingValue > 0, "StartingValue must be greater than zero.");
        Preconditions.checkArgument(endingValue > 0, "EndingValue must be greater than zero.");

        return IntStream.rangeClosed(startingValue, endingValue)
                .filter(this::isPrime).boxed()
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }

        return IntStream.rangeClosed(2, (int) (Math.sqrt(value)))
                .allMatch(n -> value % n != 0);
    }
}