package solutions;

import java.util.Vector;

public class Problem23 extends Problem {

    public Problem23() {
        super(23);
    }

    private class Number {
        Vector<Long> mDivisors;

        public Number() {
            mDivisors = new Vector<>();
        }

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
        int maxVal = 24000;
        Vector<Integer> baseElements = new Vector<Integer>(maxVal);
        for (int ctr = 1; ctr < maxVal; ++ctr) {
            Number now = new Number();
            now.addDivisor(1);
            for (int divCtr = 2; (divCtr * divCtr) <= ctr; ++divCtr) {
                if (ctr % divCtr == 0) {
                    int othOperand = ctr / divCtr;
                    now.addDivisor(divCtr);
                    if (othOperand != divCtr)
                        now.addDivisor(ctr / divCtr);
                }
            }
            if (now.divisorSum() > ctr)
                baseElements.add(ctr);
        }
        long sum = 0;
        boolean[] matchedNumber = new boolean[maxVal];
        for (int ctr = 0; ctr < matchedNumber.length; ++ctr)
            matchedNumber[ctr] = false;

        for (int a : baseElements)
            for (int b : baseElements) {
                if ((a + b) >= maxVal)
                    break;
                matchedNumber[a + b] = true;
            }

        for (int ctr = 1; ctr < matchedNumber.length; ++ctr) {
            if (!matchedNumber[ctr]) {
                sum += ctr;
            }
        }
        System.out.format("%s: sum of elements without amicable dual-sum-base: %d\n", this, sum);

    }
}
