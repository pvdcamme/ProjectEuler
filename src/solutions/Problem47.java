package solutions;

import java.util.List;
import java.util.Map;
import java.util.Set;

import solutions.PrimeUtils.PrimeFactor;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Find the first four consecutive integers to have four distinct prime factors
 * each. What is the first of these numbers?
 *
 */
public class Problem47 extends Problem {

	public Problem47() {
		super(47);
	}

	private boolean areDistinct(List<PrimeFactor> factors) {
		Set<Long> seen = new HashSet<>();
		for (PrimeFactor p : factors) {
			seen.add(p.prime);
		}
		return factors.size() == seen.size();

	}

	@Override
	public void solve() {
		final long minCount = 4;
		long maxPrime = 10000000;
		Map<Integer, List<PrimeFactor>> cache = new HashMap<>();
		for (int ctr = 10; ctr < maxPrime; ++ctr) {
			boolean found = true;
			for (int extra = 0; found && extra < minCount; ++extra) {
				List<PrimeFactor> factors = cache.computeIfAbsent(ctr + extra, PrimeUtils::factorize);
				found = found && (factors.size() == minCount && areDistinct(factors));
			}

			if (!found) {
				continue;
			}

			System.out.format("%s: Found %d %n", this, ctr);
			return;
		}
	}
}
