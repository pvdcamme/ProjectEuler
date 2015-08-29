package solutions;

import java.util.Vector;

public class Problem37 extends Problem {

	public Problem37() {
		super(37);
	}

	@Override
	public void solve() {
		PrimeSerie serie = new PrimeSerie();
		int maxVal = 1000000;
		boolean[] isPrime = new boolean[maxVal];
		Vector<Integer> primes = new Vector<Integer>();

		while (serie.next() < maxVal) {
			primes.add((int) serie.current());
			isPrime[(int) serie.current()] = true;
		}

		int trucablePrimeCount = 0;
		int truncablePrimeSum = 0;

		for (int prime : primes) {
			if (prime < 10)
				continue;

			int step = 0;
			int rightTrunc = prime;
			while (0 < (rightTrunc /= 10) && isPrime[rightTrunc]) {
				step++;
			}
			if (rightTrunc > 0)
				continue;

			int tens = 10;
			for (int ctr = 0; ctr < step; ++ctr) {
				if (!isPrime[prime % tens]) {
					break;
				}
				tens *= 10;
			}
			if (tens > prime) {
				trucablePrimeCount++;
				truncablePrimeSum += prime;

			}
		}
		System.out.format("%s: there are %d truncable primes, summing to %d\n",
				this, trucablePrimeCount, truncablePrimeSum);

	}
}
