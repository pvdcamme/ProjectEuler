package solutions;

import java.util.Collections;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class Problem32 extends Problem {
	Set<Long> mProducts;

	public Problem32() {
		super(32);
		mProducts = new TreeSet<>();
	}

	void permute(int depth, int[] picking) {
		if (depth == (picking.length - 1)) {
			verify(picking);
		} else {
			for (int digitCtr = depth; digitCtr < picking.length; ++digitCtr) {
				int a = picking[depth];
				int b = picking[digitCtr];

				picking[depth] = b;
				picking[digitCtr] = a;

				permute(depth + 1, picking);

				picking[depth] = a;
				picking[digitCtr] = b;
			}
		}
	}

	private void verify(int[] digits) {
		for (int a = 1; a < digits.length - 1; ++a) {
			for (int b = a; b < (digits.length - 1); ++b) {
				long aVal = toLong(digits, 0, a);
				long bVal = toLong(digits, a, b);
				long cVal = toLong(digits, b, digits.length);
				if (aVal * bVal == cVal)
					mProducts.add(cVal);
			}
		}
	}

	private long toLong(int[] digits, int start, int end) {
		int val = 0;
		for (int ctr = start; ctr < end; ++ctr)
			val = val * 10 + digits[ctr];
		return val;
	}

	@Override
	public void solve() {
		int[] digits = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		permute(0, digits);
		long sum = 0;
		for(long product: mProducts)
			sum += product;
		System.out
				.format("%s: found %d products with a total sum of %d \n", this, mProducts.size(),sum);

	}
}
