package org.primes.generator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Main class to run the prime number generator from the command line.
 */
public class PrimeNumberGeneratorRunner {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the first whole number bound: ");
        int bound1 = 0;
        try {
            bound1 = scan.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Your first bound input was nonnumerical or larger than Integer.MAX_VALUE, please retry.");
        }

        if (bound1 < 1) {
            throw new IllegalArgumentException("The first bound was less than one, please retry [1, 2, .... 1000, etc..).");
        }

        System.out.print("Enter the second whole number bound: ");
        int bound2 = 0;
        try {
            bound2 = scan.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Your second bound input was nonnumerical or larger than Integer.MAX_VALUE, please retry.");
        }

        if (bound2 < 1) {
            throw new IllegalArgumentException("The second bound was less than one, please retry [1, 2, .... 1000, etc..).");
        }

        int minBound = Math.min(bound2, bound1);
        int maxBound = Math.max(bound2, bound1);

        List<Integer> primes = new PrimeNumberGeneratorImpl().generate(minBound, maxBound);

        System.out.println("The primes between the lower bound(" + minBound + ")" + " and the upper bound(" + maxBound + ")" + " are:" + primes.toString());
    }
}
