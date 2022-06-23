import java.util.*;


public class StringCalculator {

    public static int add(String numbers) {
        int result = 0;
        if (numbers.length() == 0) {
            result = 0;
        } else if (numbers.length() == 1) {
            result = Integer.parseInt(numbers.substring(0));
        } else {
            String[] values = numbers.split(",");
            for(int i = 0; i < values.length; i++) {
                result += Integer.parseInt(values[i]);
            }
        }
        return result;
    }
}
