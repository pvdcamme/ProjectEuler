package solutions;

import java.math.BigInteger;

/**
 * Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
 *
 */
public class Problem48 extends Problem {

    public Problem48() {
        super(48);
    }

    @Override
    public void solve() {
        BigInteger result = BigInteger.ZERO;
        int length = 10;
        BigInteger modVal = BigInteger.TEN.pow(length + 2);
        for (int ctr = 1; ctr < 1000; ctr++) {
            BigInteger a = BigInteger.valueOf(ctr);
            a = a.modPow(a, modVal);
            result = result.add(a);
        }

        String textValue = result.toString();
        String lastPart = textValue.substring(textValue.length() - length);

        printSolution("counted to %s", lastPart);

    }
}
