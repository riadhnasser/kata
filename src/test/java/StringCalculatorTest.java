import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void when_emptyString_then_ShouldReturn_zero() throws Exception{
        int result = StringCalculator.add("");

        assertEquals("Test failed for empty string", 0, result);
    }

    @Test
    public void when_SingleNumber_then_ShouldReturn_thatNumber() throws Exception{
        int result = StringCalculator.add("5");

        assertEquals("Test failed for single number addition", 5, result);
    }

    @Test
    public void when_additionOfTwoNumbers_then_ShouldReturn_theSum() throws Exception{
        int result = StringCalculator.add("2,3");

        assertEquals("Test failed for 2 numbers addition", 5, result);
    }

    @Test
    public void when_multipleNumbers_then_ShouldReturn_theSum() throws Exception{
        int result = StringCalculator.add("2,3,5,12");

        assertEquals("Test 0 failed for unknown/multiple numbers addition", 22, result);
    }

    @Test
    public void when_multipleDelimiterUsed_then_ShouldReturn_theSum() throws Exception{
        int result = StringCalculator.add("1\n2,3");

        assertEquals("Test failed for delimiter \n ", 6, result);
    }

    @Test
    public void when_delimiterLinePresent_then_ShouldReturn_delimiter() throws Exception{
        String result = StringCalculator.getDelimiterFromFirstLine("//;\n1;2");

        assertEquals("Test failed for retrieving delimiter from text ", ";", result);
    }

    @Test
    public void when_delimiterMultipleCharactersLinePresent_then_ShouldReturn_delimiter() throws Exception{
        String result = StringCalculator.getDelimiterFromFirstLine("//;;\n1;2");

        assertEquals("Test failed for retrieving delimiter from text ", ";;", result);
    }

    @Test
    public void when_delimiterDelimiterIsProvided_then_ShouldReturn_sumBasedOnDelimiter() throws Exception{
        int result = StringCalculator.add("//;\n1;2");

        assertEquals("Test failed for addition using provided delimiter ; ", 3, result);
    }

    @Test
    public void when_negativeValuesPresent_then_shouldThrow_exception() throws Exception{
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("negatives not allowed");
        int result = StringCalculator.add("-5,9");

    }

    @Test
    public void when_negativeValuesPresent_then_shouldThrow_exceptionWithNegativeValues() throws Exception{
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("[-5, -88]");
        int result = StringCalculator.add("-5,9,-88");

    }


}