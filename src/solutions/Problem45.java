package solutions;

public class Problem45 extends Problem {

	public Problem45() {
		super(45);
	}

	long triangle(long n) {
		return (n * (n + 1)) / 2;
	}

	long pentagonal(long n) {
		return (n * (3 * n - 1)) / 2;
	}

	long hexagonal(long n) {
		return n * (2 * n - 1);
	}

	@Override
	public void solve() {
		int n_triangle = 2;
		int n_pent = 2;
		int n_hex = 2;

		long tri = triangle(n_triangle);
		long pent = pentagonal(n_pent);
		long hex = hexagonal(n_hex);

		while (tri != pent || tri != hex || tri <= 40755) {
			if (tri < hex) {
				if (tri < pent)
					n_triangle++;
				else
					n_pent++;
			} else if (hex < pent)
				n_hex++;
			else
				n_pent++;

			tri = triangle(n_triangle);
			pent = pentagonal(n_pent);
			hex = hexagonal(n_hex);
		}

		System.out.format("%s: Next smallest equal is %d\n", this, tri);

	}
}
