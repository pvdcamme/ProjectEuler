package solutions;

import java.util.Vector;

public class Problem46 extends Problem {

	public Problem46() {
		super(46);
	}

	public int verify(int maxVal) {
		Vector<Integer> primes = new Vector<Integer>();
		Vector<Integer> squares = new Vector<Integer>();
		boolean[] found = new boolean[maxVal];

		PrimeSerie series = new PrimeSerie();
		while (series.next() < maxVal) {
			int prime = (int) series.current();
			primes.add(prime);
			found[prime] = true;
		}

		for (int ctr = 1; ctr * ctr < maxVal; ++ctr) {
			squares.add(ctr * ctr);
		}

		for (int prime : primes)
			for (int square : squares) {
				int composite = prime + 2 * square;
				if (composite < maxVal)
					found[composite] = true;
				else
					break;
			}

		int smallestError = 0;
		for (int ctr = 3; ctr < maxVal; ctr += 2) {
			if (!found[ctr]) {
				smallestError = ctr;
				break;
			}
		}
		return smallestError;
	}

	@Override
	public void solve() {

		int smallestError = 0;
		int verifyRange = 1000;
		while (0 == (smallestError = verify(verifyRange))) {
			verifyRange *= 10;
		}

		System.out.format("%s: Smallest falsification is %d\n", this,
				smallestError);

	}
}
