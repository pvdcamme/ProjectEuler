package solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.Vector;

public class Problem44 extends Problem {
	private Vector<Long> primes = new Vector<>();

	public Problem44() {
		super(44);
	}

	int pentagonal(int n) {
		return (n * (3 * n - 1)) / 2;
	}

	@Override
	public void solve() {
		boolean[] isPentagonal = new boolean[100000000];

		Vector<Integer> special = new Vector<>();
		for (int n = 0; pentagonal(n) < isPentagonal.length; n++) {
			int pent = pentagonal(n);
			isPentagonal[pent] = true;
			special.add(pent);
		}
		int[] pentNumbers = new int[special.size()];
		for (int ctr = 1; ctr < special.size(); ++ctr) {
			pentNumbers[ctr] = special.get(ctr);
		}
		special = null;

		long smallest = Long.MAX_VALUE;

		for (int a_ctr = 1; a_ctr < pentNumbers.length; ++a_ctr) {
			int a = pentNumbers[a_ctr];
			for (int b_ctr = 1; b_ctr < a_ctr
					&& (a + pentNumbers[b_ctr]) < isPentagonal.length; ++b_ctr) {
				int b = pentNumbers[b_ctr];
				int a_b = a + b;
				if (isPentagonal[a - b] && a_b < isPentagonal.length
						&& isPentagonal[a_b]) {
					smallest = Math.min(smallest, a - b);
				}
			}
		}

		System.out.format("%s: Smallest difference is %d\n", this, smallest);

	}
}
