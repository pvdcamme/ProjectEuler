package solutions;

import java.util.Vector;

public class PrimeSerie {

	private Vector<Long> mFoundPrimes;

	private long currentIndex;
	private long lastSieve;

	private final int sieveSize = 10000000;

	public PrimeSerie() {
		mFoundPrimes = new Vector<>();

		lastSieve = 2;
		mFoundPrimes.add(2L);
		currentIndex = -1;
	}

	private void sieve() {
		boolean[] naturals = new boolean[sieveSize];

		long startSieve = lastSieve;
		long endSieve = lastSieve + sieveSize;
		for (int ctr = 0; ctr < sieveSize; ++ctr)
			naturals[ctr] = true;

		for (Long prime : mFoundPrimes) {
			long startCtr = (prime * prime) * (startSieve / (prime * prime));
			while (startCtr < startSieve)
				startCtr += prime;
			
			for (long ctr = startCtr; ctr < endSieve; ctr += prime) {
				naturals[(int) (ctr - startSieve)] = false;
			}
		}
		for (int ctr = 0; ctr < sieveSize; ++ctr) {
			if (naturals[ctr]) {
				long newPrime = ctr + startSieve;
				mFoundPrimes.add(newPrime);
				long reduce = newPrime * newPrime;
				while (reduce < endSieve) {
					naturals[(int) (reduce - startSieve)] = false;
					reduce += newPrime;
				}
			}
		}
		lastSieve = endSieve;
	}

	public long current() {
		return mFoundPrimes.elementAt((int) currentIndex);
	}

	public void reset() {
		currentIndex = -1;
	}

	public long next() {
		if ((currentIndex + 1) < mFoundPrimes.size()) {
			currentIndex++;
			return current();
		} else {
			sieve();
			return next();
		}
	}

	public long next2() {
		if (mFoundPrimes.size() == 0) {
			mFoundPrimes.add(2L);
		} else {
			long start = current() + 1;
			boolean isPrime = true;
			do {
				isPrime = true;
				for (long val : mFoundPrimes) {
					if (start % val == 0) {
						isPrime = false;
						start++;
						break;
					} else if (val * val > start)
						break;
				}
			} while (!isPrime);
			mFoundPrimes.add(start);
		}
		return current();
	}

}
