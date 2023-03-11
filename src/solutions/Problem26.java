package solutions;

import java.math.BigInteger;

public class Problem26 extends Problem {

	public Problem26() {
		super(26);
	}

	int search(int divisor, int skip, int searchLength) {
		BigInteger bigDivisor = BigInteger.valueOf(divisor);
		for (int lengthCtr = 1; lengthCtr < searchLength; ++lengthCtr) {
			BigInteger small = BigInteger.TEN.modPow(BigInteger.valueOf(lengthCtr + skip), bigDivisor);
			BigInteger large = BigInteger.TEN.modPow(BigInteger.valueOf(lengthCtr * 2 + skip), bigDivisor);
			BigInteger gigantic = BigInteger.TEN.modPow(BigInteger.valueOf(lengthCtr * 3 + skip), bigDivisor);

			if (small.equals(large) && small.equals(gigantic)) {
				return lengthCtr;
			}
		}
		return -1;
	}

	@Override
	public void solve() {
		int largestCycle = 0;
		int cycleLength = 0;
		for (int ctr = 2; ctr < 1000; ++ctr) {

			int attempt = 1;
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
