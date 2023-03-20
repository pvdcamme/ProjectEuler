package solutions;

public class Problem30 extends Problem {

    public Problem30() {
        super(30);

    }

    long sumDigits(int a) {
        long sum = 0;
        while (a != 0) {
            int digit = a % 10;
            a /= 10;
            sum += digit * digit * digit * digit * digit;
        }
        return sum;
    }

    @Override
    public void solve() {
        int sumSpecial = 0;
        int count = 0;
        for (int ctr = 10; ctr < 1000000; ctr++) {
            if (ctr == sumDigits(ctr)) {
                count++;
                sumSpecial += ctr;

            }
        }
        System.out.format("%s: : found %d special number, summing to %d\n", this, count, sumSpecial);

    }
}
