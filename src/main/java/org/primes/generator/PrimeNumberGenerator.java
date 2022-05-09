package org.primes.generator;

import java.util.List;

//TODO {Add default Implementation}
interface PrimeNumberGenerator {

    /**
     * TODO
     *
     * @param startingValue
     * @param endingValue
     * @return
     */
    List<Integer> generate(int startingValue, int endingValue);

    /**
     * TODO
     *
     * @param value
     * @return
     */
    boolean isPrime(int value);
}
