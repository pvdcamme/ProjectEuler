package solutions;

import java.math.BigInteger;
import java.util.WeakHashMap;
import java.util.function.Function;

public class Problem26 extends Problem {
	private static final class Cache {
		final WeakHashMap<Integer, BigInteger> seen = new WeakHashMap<>();
		private Function<Integer, BigInteger> divisorFun;

		Cache(int divisor) {
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

	int search(Cache seen, int divisor, int skip, int searchLength) {
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

			Cache cache = new Cache(ctr);
			while (-1 == (length = search(cache, ctr, 2 * attempt, 2 * attempt)))
				attempt++;

			if (length > cycleLength) {
				largestCycle = ctr;
				cycleLength = length;
			}
		}
		System.out.format("%s: : 1/%d has a reciprocal of %d digits\n", this, largestCycle, cycleLength);

	}
}
