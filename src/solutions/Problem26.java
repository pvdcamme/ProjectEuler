package solutions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Vector;

public class Problem26 extends Problem {

	public Problem26() {
		super(26);
	}

	int search(int divisor, int skip, int searchLength) {
		BigInteger bigDivisor = BigInteger.valueOf(divisor);
		for (int ctr = 1; ctr < searchLength; ++ctr) {
			BigInteger small = BigInteger.TEN.modPow(
					BigInteger.valueOf(ctr + skip), bigDivisor);
			BigInteger large = BigInteger.TEN.modPow(
					BigInteger.valueOf(ctr * 2 + skip), bigDivisor);
			BigInteger gigantic = BigInteger.TEN.modPow(
					BigInteger.valueOf(ctr * 3 + skip), bigDivisor);

			
			if (small.equals(large) && small.equals(gigantic)) {
				return ctr;
			}
		}
		return -1;
	}

	@Override
	public void solve() {
		BigDecimal b = BigDecimal.ONE;
		int largestCycle = 0;
		int cycleLength = 0;
		for (int ctr = 2; ctr < 1000; ++ctr) {

			int attempt = 1;
			int length = -1;
			while (-1 == (length = search(ctr, 2 * (attempt + 5),
					2 * (attempt + 5))))
				attempt++;

			if (length > cycleLength) {
				largestCycle = ctr;
				cycleLength = length;
			}

		}
		System.out.format("%s: : 1/%d has a reciprocal of %d digits\n", this,
				largestCycle, cycleLength);

	}
}
