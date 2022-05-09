# primes-generator

Welcome! This project is a command line runner for generating prime numbers.

## Prerequisites

* [Maven](https://maven.apache.org/download.cgi): 3.6.x or greater
* [Java](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html): 8

## Running the Program

### Windows

The `runner.bat` file will package the project and execute the runnable jar.

### Linux and Mac

The `runner.bash` file will package the project and execute the runnable jar.

## Reports

You can run `mvn clean install site` to view the project reports under the `target` directory
in `{project directory}/target/site/project-reports.html`

* [Jacoco](https://www.eclemma.org/jacoco/trunk/doc/maven.html): Test coverage
* [maven-dependency-plugin](https://maven.apache.org/plugins/maven-dependency-plugin/): Dependency analysis

## References

* [Living Design](https://github.com/PottedBear/primes-generator/blob/main/docs/living-design.md)
* [Prime Values in Java](https://www.baeldung.com/java-generate-prime-numbers)