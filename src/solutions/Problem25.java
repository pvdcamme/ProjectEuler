package solutions;

import java.math.BigDecimal;

public class Problem25 extends Problem {


	public Problem25() {
		super(25);
	}

	@Override
	public void solve() {
		BigDecimal a = BigDecimal.ZERO;
		BigDecimal b = BigDecimal.ONE;
		int searchDecimals = 1000;
		int ctr = 1;
		while(b.toPlainString().length() < searchDecimals)
		{
			BigDecimal c = b.add(a);
			a = b;
			b = c;
			ctr++;
		}
		System.out.format("%s: : first fib to contain %d decimals is %d \n", this, searchDecimals,
				ctr);

	}
}
