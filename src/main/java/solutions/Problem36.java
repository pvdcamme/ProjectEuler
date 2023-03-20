package solutions;

import java.util.Vector;

public class Problem36 extends Problem {

    public Problem36() {
        super(36);
    }

    private boolean isPalindrome(Vector<Integer> digits) {
        int amtDigits = digits.size();
        for (int ctr = 0; ctr < (amtDigits / 2); ++ctr) {
            if (digits.get(ctr) != digits.get(amtDigits - (ctr + 1)))
                return false;
        }
        return true;
    }

    @Override
    public void solve() {
        int sum = 0;
        int maxVal = 1000000;
        for (int ctr = 1; ctr < maxVal; ++ctr) {
            int val = ctr;

            Vector<Integer> base10 = new Vector<>();
            while (val > 0) {
                base10.add(val % 10);
                val /= 10;
            }
            if (!isPalindrome(base10))
                continue;

            Vector<Integer> base2 = new Vector<>();
            val = ctr;
            while (val > 0) {
                base2.add(val % 2);
                val /= 2;
            }
            if (!isPalindrome(base2))
                continue;

            sum += ctr;

        }
        System.out.format("%s: summed palindromes to %d\n", this, sum);

    }
}
