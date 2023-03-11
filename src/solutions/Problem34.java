package solutions;

public class Problem34 extends Problem {

	public Problem34() {
		super(34);
	}

	int shortFac(int v) {
		if (v <= 1)
			return 1;
		else
			return v * shortFac(v - 1);
	}

	@Override
	public void solve() {
		int[] digitFac = new int[10];

		for (int ctr = 0; ctr < digitFac.length; ++ctr)
			digitFac[ctr] = shortFac(ctr);

		long goodSum = 0;
		int goodCount = 0;
		for (int ctr = 10; ctr < 5000000; ctr++) {
			int sumFac = 0;
			int digits = ctr;
			while (digits > 0) {
				sumFac += digitFac[digits % 10];
				digits /= 10;
			}
			if (sumFac == ctr) {
				goodSum += ctr;
				goodCount++;
			}

		}

		System.out.format("%s: found %d special numbers, summing up to %d\n",
				this, goodCount, goodSum);

	}
}
