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

        List<String> splitValue = Arrays.asList(String.valueOf(twoDecimalDouble * 10).split("\\."));

        int integerPart = Integer.parseInt(splitValue.get(0));
        int decimalPart = Integer.parseInt(splitValue.get(1).substring(0,1));

        if (decimalPart >= 1 && decimalPart <= 4) return Double.parseDouble(df.format((integerPart + 0.5) / 10.00));
        if (decimalPart >= 6 && decimalPart <= 9) return Double.parseDouble(df.format(integerPart / 10.00 + 1));

        return this.value;
    }

    public Double getValue() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(this.value));
    }
}
