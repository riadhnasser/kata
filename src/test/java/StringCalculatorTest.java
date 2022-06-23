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

        assertEquals("Test failed for single number addition", 5, result);
    }


}