package solutions;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * How many comb(n,r), not necessarily distinct, values of for 1<= n <= 100, are
 * greater than one-million?
 * 
 */
public class Problem53 extends Problem {
    private Map<Integer, BigInteger> facCache = new HashMap<>();

    public Problem53() {
        super(53);
    }

    BigInteger fac(int a) {
        if (a <= 1) {
            return BigInteger.ONE;
        } else if (facCache.containsKey(a)) {
            return facCache.get(a);
        } else {
            BigInteger result = BigInteger.valueOf(a).multiply((fac(a - 1)));
            facCache.put(a, result);
            return result;
        }
    }

    BigInteger prob(int a, int b) {
        BigInteger num = fac(a);
        BigInteger denum = fac(b).multiply(fac(a - b));
        return num.divide(denum);
    }

    @Override
    public void solve() {
        int count = 0;

        BigInteger million = BigInteger.valueOf(1_000_000);
        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= a; b++) {
                BigInteger res = prob(a, b);
                if (res.compareTo(million) == 1) {
                    count++;
                }
            }
        }
        printSolution("Collected %d results", count);
    }
}
