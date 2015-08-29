package solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.Vector;

public class Problem43 extends Problem {
	private Vector<Long> primes = new Vector<>();

	public Problem43() {
		super(43);
	}

	void permute(int depth, int[] picking, Vector<Long> store) {
		if (depth == 4 && (toLong(picking, 1, 4) % 2) != 0) {
			return;
		}
		if (depth == 5 && (toLong(picking, 2, 5) % 3) != 0) {
			return;
		}
		if (depth == 6 && (toLong(picking, 3, 6) % 5) != 0) {
			return;
		}
		if (depth == 7 && (toLong(picking, 4, 7) % 7) != 0) {
			return;
		}
		if (depth == 8 && (toLong(picking, 5, 8) % 11) != 0) {
			return;
		}
		if (depth == 9 && (toLong(picking, 6, 9) % 13) != 0) {
			return;
		}
		if (depth == 10 && (toLong(picking, 7, 10) % 17) != 0) {
			return;
		}

		if (depth == picking.length) {
			long value = toLong(picking, 0, picking.length);
			store.add(value);
		} else {
			for (int digitCtr = depth; digitCtr < picking.length; ++digitCtr) {
				int a = picking[depth];
				int b = picking[digitCtr];

				picking[depth] = b;
				picking[digitCtr] = a;

				permute(depth + 1, picking, store);

				picking[depth] = a;
				picking[digitCtr] = b;
			}
		}
	}

	private long toLong(int[] picking, int start, int end) {
		long result = 0L;
		for (int ctr = start; ctr < end; ++ctr)
			result = 10 * result + (long) picking[ctr];
		return result;
	}

	@Override
	public void solve() {
		int[] digits = new int[10];
		for (int ctr = 0; ctr < digits.length; ctr++)
			digits[ctr] = ctr;

		Vector<Long> special = new Vector<>();
		permute(0, digits, special);
		long totalSum = 0;
		for (long l : special) {
			totalSum += l;
		}

		System.out.format("%s: counted %d special cases, summing to  %d\n",
				this, special.size(), totalSum);

	}
}
