# Prime Number Generator

This project is intended to create a command line runner for generating prime numbers between an upper and lower bound.

## Interfaces

### [PrimeNumberGenerator](https://github.com/PottedBear/primes-generator/blob/main/src/main/java/org/primes/generator/PrimeNumberGenerator.java):

**`generate(int startingValue, int endingValue)` :** Will return a `List<Integer>` containing all prime values between
the `startingValue` and `endingValue`

**`isPrime(int value)` :** Will return a `boolean` indicating `true` if the value is prime otherwise `false`.

**Default
Implementation:** [PrimeNumberGeneratorImpl](https://github.com/PottedBear/primes-generator/blob/main/src/main/java/org/primes/generator/PrimeNumberGeneratorImpl.java)

## Runner

### [PrimeNumberGeneratorRunner](https://github.com/PottedBear/primes-generator/blob/main/src/main/java/org/primes/generator/PrimeNumberGeneratorRunner.java):

Class contains the `main` for running the `PrimeNumberGenerator` from the command line using the default implementation.

## Future Considerations

* Add GUI to interact with the `PrimeNumberGenerator`.
* Consider multiple implementations with a performance comparison/improvement.
* Factory/Builder pattern to serve different implementations.


