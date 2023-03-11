package solutions;

import java.math.BigInteger;

public class Problem33 extends Problem {

    int denum = 1;
    int num = 1;

    public Problem33() {
        super(33);

    }

    void storeClose(double frac, int a, int b) {
        double difference = Math.abs(frac - a / ((double) b));
        boolean isClose = difference < 0.00001;
        if (isClose) {
            denum *= b;
            num *= a;
        }
    }

    @Override
    public void solve() {
        for (int denum = 2; denum < 10; denum++)
            for (int num = 1; num < denum; num++) {
                double frac = num / (double) denum;
                for (int digit = 1; digit <= 9; ++digit) {
                    storeClose(frac, digit * 10 + num, digit * 10 + denum);
                    storeClose(frac, digit * 10 + num, digit + 10 * denum);
                    storeClose(frac, digit + 10 * num, digit * 10 + denum);
                    storeClose(frac, digit + 10 * num, digit + 10 * denum);

                }
            }

        BigInteger bDenum = BigInteger.valueOf(this.denum);
        BigInteger bNum = BigInteger.valueOf(this.num);
        BigInteger common = bDenum.gcd(bNum);
        System.out.format("%s: reduced denumerator is 1/%s\n", this, bDenum.divide(common));

    }
}
