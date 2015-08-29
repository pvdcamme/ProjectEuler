package solutions;

public class FibSerie {

	private long a;
	private long b;

	public FibSerie() {
		a = 0;
		b = 1;
	}

	public long current() {
		return a + b;
	}

	public long next() {
		long result = a + b;
		a = b;
		b = result;
		return result;
	}

}
