import java.util.*;


public class StringCalculator {

    public static int add(String numbers) throws Exception {
        String delimiters = ",|\\\n";
        int result = 0;
        // flag to check if negative values are present
        boolean error = false;
        List<String> negatives_values = new ArrayList<String>();
        if (numbers.length() > 0) {
            String[] values;
            if (numbers.startsWith("//")) {
                String str_numbers = numbers.substring(numbers.lastIndexOf("\n") + 1);
                values = str_numbers.split(StringCalculator.getDelimiterFromFirstLine(numbers));
            } else {
                values = numbers.split(delimiters);
            }

            for(String value: values) {
                if (Integer.parseInt(value) >= 0 ) {
                    result += Integer.parseInt(value);
                } else {
                    negatives_values.add(value);
                    error = true;
                }
            }
        }
        if (error) {
            throw new Exception("negatives not allowed " + negatives_values);
        } else {
            return result;
        }
    }

    public static String getDelimiterFromFirstLine(String text) {
        String delimiter = text.substring(text.lastIndexOf("//") + 2, text.indexOf("\n"));
        return delimiter;
    }
}
