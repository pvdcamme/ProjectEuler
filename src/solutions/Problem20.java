package solutions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.Format;

public class Problem20 extends Problem {

	public Problem20() {
		super(20);
	}

	@Override
	public void solve() {

		int facEnd=100;
		BigDecimal fac = BigDecimal.ONE;
		for (int ctr = 1; ctr <= facEnd; ++ctr) {
			fac = fac.multiply(new BigDecimal(ctr));
		}
		long sumDigits = 0;
		String strDecimals = fac.toPlainString();
		for (int ctr = 0; ctr < strDecimals.length(); ++ctr) {
			sumDigits += strDecimals.charAt(ctr) - '0';
		}
		System.out.format("%s: sum of digits in fac(%d): %d\n",this,facEnd, sumDigits);

	}
}
