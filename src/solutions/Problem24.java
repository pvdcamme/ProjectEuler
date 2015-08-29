package solutions;

import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class Problem24 extends Problem {

	public Problem24() {
		super(24);
	}

	void permute(int depth, int[] picking, Vector<Long> store) {
		if (depth == (picking.length - 1)) {
			store.add(toLong(picking));
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

	private long toLong(int[] picking) {
		long result = 0L;
		for (int ctr = 0; ctr < picking.length; ++ctr)
			result = 10 * result + (long) picking[ctr];
		return result;
	}

	@Override
	public void solve() {
		int[] digits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int nth = 1000000;
		Vector<Long> permutations = new Vector<Long>(4000000);
		permute(0, digits, permutations);
		Collections.sort(permutations);
		System.out.format("%s: : %d th permutions is %d\n", this, nth,
				permutations.get(nth - 1));

	}
}
