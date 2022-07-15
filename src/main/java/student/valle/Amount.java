package student.valle;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Amount {
    private final Double value;

    public Amount(Double value) {
        this.value = value;
    }

    public Double getRoundedValue() {
        DecimalFormat df = new DecimalFormat("#.##");
        double twoDecimalDouble = Double.parseDouble(df.format(this.value));

        List<String> splitValue = Arrays.asList(String.valueOf(twoDecimalDouble).split("\\."));

        int integerPart = Integer.parseInt(splitValue.get(0));
        int firstDecimalPart = Integer.parseInt(splitValue.get(1).substring(0,1));
        int lastDecimalPart;
        try {
            lastDecimalPart = Integer.parseInt(splitValue.get(1).substring(1,2));
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            lastDecimalPart = 0;
        }

        if (lastDecimalPart >= 1 && lastDecimalPart <= 4) return Double.parseDouble(df.format(integerPart + (firstDecimalPart / 10.00) + 0.05));
        if (lastDecimalPart >= 6 && lastDecimalPart <= 9) return Double.parseDouble(df.format(integerPart + (firstDecimalPart / 10.00) + 0.1));

        return this.value;
    }

    public Double getValue() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(this.value));
    }
}
