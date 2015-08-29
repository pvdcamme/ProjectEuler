package solutions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.Format;
import java.util.Vector;

public class Problem21 extends Problem {

	public Problem21() {
		super(21);
	}

	private class Number {
		long mValue;
		Vector<Long> mDivisors;

		public Number(long value) {
			mValue = value;
			mDivisors = new Vector<>();
		}

		public void addDivisor(long prime) {
			mDivisors.add(prime);
		}
		public long divisorSum()
		{
			long sum = 0;
			for(long div: mDivisors)
				sum += div;
			return sum;
		}
		public long value() {
			return mValue;
		}
	}

	@Override
	public void solve() {
		int maxVal = 10000;
		Vector<Number> numbers = new Vector<Number>(maxVal);
		for (int ctr = 0; ctr < maxVal; ++ctr) {
			Number now = new Number(ctr);
			numbers.add(now);
			now.addDivisor(1);
			for (int divCtr = 2; (divCtr * divCtr) <= ctr; ++divCtr) {
				if (ctr % divCtr == 0){
					int othOperand = ctr / divCtr;
					now.addDivisor(divCtr);
					if(othOperand != divCtr)
						now.addDivisor(ctr / divCtr);
				}
			}
		}
		
		int sum = 0;
		for(int ctr =2; ctr < maxVal;++ctr)
		{
			Number now = numbers.get(ctr);
			long divSum = now.divisorSum();
			if(divSum != ctr && divSum < maxVal && numbers.get((int)divSum).divisorSum() == ctr)
			{
				sum += ctr;
			}
				
		}

		System.out.format("%s: sum of amicable numbers: %d\n", this, sum);

	}
}
