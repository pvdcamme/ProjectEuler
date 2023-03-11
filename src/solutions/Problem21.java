package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Problem21 extends Problem {

    public Problem21() {
        super(21);
    }

    private class Number {
        List<Long> mDivisors = new ArrayList<>();

        public void addDivisor(long prime) {
            mDivisors.add(prime);
        }

        public long divisorSum() {
            long sum = 0;
            for (long div : mDivisors)
                sum += div;
            return sum;
        }
    }

    @Override
    public void solve() {
        int maxVal = 10000;
        Vector<Number> numbers = new Vector<Number>(maxVal);
        for (int ctr = 0; ctr < maxVal; ++ctr) {
            Number now = new Number();
            numbers.add(now);
            now.addDivisor(1);
            for (int divCtr = 2; (divCtr * divCtr) <= ctr; ++divCtr) {
                if (ctr % divCtr == 0) {
                    int othOperand = ctr / divCtr;
                    now.addDivisor(divCtr);
                    if (othOperand != divCtr)
                        now.addDivisor(ctr / divCtr);
                }
            }
        }

        int sum = 0;
        for (int ctr = 2; ctr < maxVal; ++ctr) {
            Number now = numbers.get(ctr);
            long divSum = now.divisorSum();
            if (divSum != ctr && divSum < maxVal && numbers.get((int) divSum).divisorSum() == ctr) {
                sum += ctr;
            }

        }

        System.out.format("%s: sum of amicable numbers: %d\n", this, sum);

    }
}
