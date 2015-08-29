package solutions;

import java.util.Vector;

public class PrimeUtils {

	private PrimeUtils() {
		// TODO Auto-generated constructor stub
	}

	public static class PrimeFactor {
		public final long prime;
		public final long times;

		public PrimeFactor(long prime, long times) {
			this.prime = prime;
			this.times = times;
		}

	}

	public static Vector<PrimeFactor> factorize(long val) {
		return factorize(val, new PrimeSerie());
	}

	public static Vector<PrimeFactor> factorize(long val, PrimeSerie primes) {
		Vector<PrimeFactor> result = new Vector<PrimeUtils.PrimeFactor>();

		do {
			long testPrime = primes.next();
			int ctr = 0;
			while (val % testPrime == 0) {
				val /= testPrime;
				ctr++;
			}

			if (ctr != 0) {
				result.add(new PrimeFactor(testPrime, ctr));
			}
		} while (val > 1);
		return result;
	}
}
