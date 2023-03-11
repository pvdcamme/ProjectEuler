package solutions;

import java.util.ArrayList;
import java.util.List;

public class PrimeUtils {

	public static class PrimeFactor {
		public final long prime;
		public final long times;

		public PrimeFactor(long prime, long times) {
			this.prime = prime;
			this.times = times;
		}

	}

	public static List<PrimeFactor> factorize(long val) {
		return factorize(val, new PrimeSerie());
	}

	public static List<PrimeFactor> factorize(long val, PrimeSerie primes) {
		List<PrimeFactor> result = new ArrayList<PrimeUtils.PrimeFactor>();

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
