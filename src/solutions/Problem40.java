package solutions;

public class Problem40 extends Problem {

	public Problem40() {
		super(40);
	}

	@Override
	public void solve() {
		String txt = "";
		int ctr = 1;
		StringBuilder builder = new StringBuilder(1000000);
		while (builder.length() < 1000000) {
			builder.append(ctr);
			ctr++;
		}
		txt = builder.toString();

		int pos = 1;
		long res = 1;
		for (int decCtr = 0; decCtr < 7; decCtr++) {
			res *= (txt.charAt(pos - 1) - '0');
			pos *= 10;

		}

		System.out.format("%s: counted to %d and found the product %d \n", this, pos / 10, res);

	}
}
