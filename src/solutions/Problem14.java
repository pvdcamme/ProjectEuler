package solutions;


public class Problem14 extends Problem {

	int[] mSolved;

	public Problem14() {
		super(14);
		mSolved = new int[2500000];
		for (int ctr = 0; ctr < mSolved.length; ++ctr)
			mSolved[ctr] = -1;
	}

	private boolean containsKey(long val) {
		return val < mSolved.length && mSolved[(int) val] != -1;
	}

	private long getKey(long val) {
		return mSolved[(int) val];
	}

	private void putKey(long idx, long val) {
		if (idx < mSolved.length)
			mSolved[(int) idx] = (int)val;
	}

	private long solve(long v) {
		long current = v;
		if (v == 1)
			return 0;
		else if (containsKey(v)) {
			return getKey(current);
		} else if (v % 2 == 0) {
			long result = 1 + solve(v / 2);
			putKey(v, result);
			return result;
		} else {
			long result = 1 + solve(3 * v + 1);
			putKey(v, result);
			return result;
		}
	}

	@Override
	public void solve() {

		long highest = 0;
		long bestStart = 0;
		for (long ctr = 1; ctr < 1000 * 1000; ++ctr) {
			long found = solve(ctr);
			if (found > highest) {
				highest = found;
				bestStart = ctr;
			}
		}

		System.out.println(this + ": bestStart is " + bestStart
				+ " with a chain of " + highest + " elements");
	}
}
