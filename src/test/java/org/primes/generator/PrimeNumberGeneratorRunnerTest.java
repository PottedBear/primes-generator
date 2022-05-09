package org.primes.generator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link PrimeNumberGeneratorRunner}
 */
public class PrimeNumberGeneratorRunnerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private String input;

    @BeforeEach
    public void beforeEach() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void afterEach() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void test1To10() {
        input = "1 10";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        PrimeNumberGeneratorRunner.main(null);

        assertThat(outContent.toString()).contains("Enter the first whole number bound: ");
        assertThat(outContent.toString()).contains("Enter the second whole number bound: ");
        assertThat(outContent.toString()).contains("The primes between the lower bound(1) and the upper bound(10) are:[2, 3, 5, 7]");
    }

    @Test
    public void test10To1() {
        input = "10 1";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        PrimeNumberGeneratorRunner.main(null);

        assertThat(outContent.toString()).contains("Enter the first whole number bound: ");
        assertThat(outContent.toString()).contains("Enter the second whole number bound: ");
        assertThat(outContent.toString()).contains("The primes between the lower bound(1) and the upper bound(10) are:[2, 3, 5, 7]");
    }

    @Test
    public void test0To10() {
        input = "0 10";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThatThrownBy(() -> PrimeNumberGeneratorRunner.main(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The first bound was less than one, please retry [1, 2, .... 1000, etc..).");
    }

    @Test
    public void test10To0() {
        input = "10 0";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThatThrownBy(() -> PrimeNumberGeneratorRunner.main(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The second bound was less than one, please retry [1, 2, .... 1000, etc..).");
    }

    @Test
    public void testNegativeTo10() {
        input = "-1 10";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThatThrownBy(() -> PrimeNumberGeneratorRunner.main(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The first bound was less than one, please retry [1, 2, .... 1000, etc..).");
    }

    @Test
    public void test10ToNegative() {
        input = "10 -1";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThatThrownBy(() -> PrimeNumberGeneratorRunner.main(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The second bound was less than one, please retry [1, 2, .... 1000, etc..).");
    }

    @Test
    public void testAboveMaxIntTo10() {
        input = "2147483648 10";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThatThrownBy(() -> PrimeNumberGeneratorRunner.main(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Your first bound input was nonnumerical or larger than Integer.MAX_VALUE, please retry.");
    }

    @Test
    public void test10ToAboveMaxInt() {
        input = "10 2147483648";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThatThrownBy(() -> PrimeNumberGeneratorRunner.main(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Your second bound input was nonnumerical or larger than Integer.MAX_VALUE, please retry.");
    }

    @Test
    public void testNonNumericalTo10() {
        input = "bilbo baggins 10";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThatThrownBy(() -> PrimeNumberGeneratorRunner.main(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Your first bound input was nonnumerical or larger than Integer.MAX_VALUE, please retry.");
    }

    @Test
    public void test10ToNonNumerical() {
        input = "10 bilbo baggins";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThatThrownBy(() -> PrimeNumberGeneratorRunner.main(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Your second bound input was nonnumerical or larger than Integer.MAX_VALUE, please retry.");
    }

}
