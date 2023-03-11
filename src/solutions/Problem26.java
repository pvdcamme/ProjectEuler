package solutions;

import java.math.BigInteger;
import java.util.WeakHashMap;
import java.util.function.Function;

public class Problem26 extends Problem {

	public Problem26() {
		super(26);
	}

	int search(int divisor, int skip, int searchLength) {
		WeakHashMap<Integer, BigInteger> seen = new WeakHashMap<>();
		BigInteger bigDivisor = BigInteger.valueOf(divisor);
		Function<Integer, BigInteger> blas = (Integer v) -> {
			return BigInteger.TEN.modPow(BigInteger.valueOf(v), bigDivisor);
		};
		for (int lengthCtr = 1; lengthCtr < searchLength; ++lengthCtr) {
			BigInteger small = seen.computeIfAbsent(lengthCtr + skip, blas);
			BigInteger large = seen.computeIfAbsent(lengthCtr * 2 + skip, blas);
			BigInteger gigantic = seen.computeIfAbsent(lengthCtr * 3 + skip, blas);

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
			while (-1 == (length = search(ctr, 2 * (attempt + 5), 2 * (attempt + 5))))
				attempt++;

			if (length > cycleLength) {
				largestCycle = ctr;
				cycleLength = length;
			}

		}
		System.out.format("%s: : 1/%d has a reciprocal of %d digits\n", this, largestCycle, cycleLength);

	}
}
