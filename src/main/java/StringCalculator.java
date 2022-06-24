import java.util.*;


public class StringCalculator {

    public static int add(String numbers) {
        String delimiters = ",|\\\n";
        int result = 0;
        if (numbers.length() > 0) {
            String[] values;
            if (numbers.startsWith("//")) {
                String str_numbers = numbers.substring(numbers.lastIndexOf("\n") + 1);
                values = str_numbers.split(StringCalculator.getDelimiterFromFirstLine(numbers));
            } else {
                values = numbers.split(delimiters);
            }

            for(int i = 0; i < values.length; i++) {
                result += Integer.parseInt(values[i]);
            }
        }
        return result;
    }

    public static String getDelimiterFromFirstLine(String text) {
        String delimiter = text.substring(text.lastIndexOf("//") + 2, text.indexOf("\n"));
        return delimiter;
    }
}
