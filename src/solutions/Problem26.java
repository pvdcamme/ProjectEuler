package solutions;

import java.math.BigInteger;
import java.util.WeakHashMap;
import java.util.function.Function;

/**
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 *
 */
public class Problem26 extends Problem {
    private static final class ReciprocalCache {
        final WeakHashMap<Integer, BigInteger> seen = new WeakHashMap<>();
        private Function<Integer, BigInteger> divisorFun;

        ReciprocalCache(int divisor) {
            BigInteger bigDivisor = BigInteger.valueOf(divisor);
            divisorFun = (Integer v) -> {
                return BigInteger.TEN.modPow(BigInteger.valueOf(v), bigDivisor);
            };
        }

        BigInteger get(int power) {
            return seen.computeIfAbsent(power, divisorFun);
        }
    }

    public Problem26() {
        super(26);
    }

    int search(ReciprocalCache seen, int divisor, int skip, int searchLength) {
        for (int lengthCtr = 1; lengthCtr < searchLength; ++lengthCtr) {
            BigInteger small = seen.get(lengthCtr + skip);
            BigInteger large = seen.get(lengthCtr * 2 + skip);
            BigInteger gigantic = seen.get(lengthCtr * 3 + skip);

            if (small.equals(large) && small.equals(gigantic)) {
                return lengthCtr;
            }
        }
        int NOT_FOUND = -1;
        return NOT_FOUND;
    }

    @Override
    public void solve() {
        int largestCycle = 0;
        int cycleLength = 0;
        for (int ctr = 2; ctr < 1000; ++ctr) {

            int attempt = 1 + (largestCycle / 10);
            int length = -1;

            ReciprocalCache cache = new ReciprocalCache(ctr);
            while (-1 == (length = search(cache, ctr, attempt, 2 * attempt)))
                attempt++;

            if (length > cycleLength) {
                largestCycle = ctr;
                cycleLength = length;
            }
        }
        printSolution("1/%d has a reciprocal of %d digits", largestCycle, cycleLength);

    }
}
