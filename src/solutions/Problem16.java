package solutions;

import java.math.BigDecimal;

public class Problem16 extends Problem {

    public Problem16() {
        super(16);
    }

    @Override
    public void solve() {
        BigDecimal value = new BigDecimal(2);
        value = value.pow(1000);
        long sum = 0;
        String strValue = value.toPlainString();
        for (int charCtr = 0; charCtr < strValue.length(); ++charCtr) {
            sum += strValue.charAt(charCtr) - '0';
        }

        System.out.println(this + ": sum of digits in 2^1000: " + sum);
    }
}
