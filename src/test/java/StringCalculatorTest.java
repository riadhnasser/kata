import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void when_emptyString_then_ShouldReturn_zero() {
        int result = StringCalculator.add("");

        assertEquals("Test failed for empty string", 0, result);
    }

    @Test
    public void when_SingleNumber_then_ShouldReturn_thatNumber() {
        int result = StringCalculator.add("5");

        assertEquals("Test failed for single number addition", 5, result);
    }

    @Test
    public void when_additionOfTwoNumbers_then_ShouldReturn_theSum() {
        int result = StringCalculator.add("2,3");

        assertEquals("Test failed for 2 numbers addition", 5, result);
    }

    @Test
    public void when_multipleNumbers_then_ShouldReturn_theSum() {
        int result = StringCalculator.add("2,3,5,12");

        assertEquals("Test 0 failed for unknown/multiple numbers addition", 22, result);
    }

    @Test
    public void when_multipleDelimiterUsed_then_ShouldReturn_theSum() {
        int result = StringCalculator.add("1\n2,3");

        assertEquals("Test failed for delimiter \n ", 6, result);
    }

    @Test
    public void when_delimiterLinePresent_then_ShouldReturn_delimiter() {
        String result = StringCalculator.getDelimiterFromFirstLine("//;\n1;2");

        assertEquals("Test failed for retrieving delimiter from text ", ";", result);
    }

    @Test
    public void when_delimiterMultipleCharactersLinePresent_then_ShouldReturn_delimiter() {
        String result = StringCalculator.getDelimiterFromFirstLine("//;;\n1;2");

        assertEquals("Test failed for retrieving delimiter from text ", ";;", result);
    }

    @Test
    public void when_delimiterDelimiterIsProvided_then_ShouldReturn_sumBasedOnDelimiter() {
        int result = StringCalculator.add("//;\n1;2");

        assertEquals("Test failed for addition using provided delimiter ; ", 3, result);
    }

    @Test
    public void when_delimiterDelimiterIsProvidedAndBigNumbers_then_ShouldReturn_sumBasedOnDelimiter() {
        int result = StringCalculator.add("//;:\n1000;:2500");

        assertEquals("Test failed for addition using provided delimiter ; ", 3500, result);
    }


}