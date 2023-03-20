package solutions;

import java.util.Arrays;

/**
 * 
 * 
 * It can be seen that the number, 125874, and its double, 251748, contain
 * exactly the same digits, but in a different order.
 * 
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
 * contain the same digits.
 * 
 */
public class Problem52 extends Problem {

    public Problem52() {
        super(52);
    }

    private long merge(Long[] g) {
        long result = 0;
        for (long val : g) {
            result = 10 * result + val;
        }
        return result;
    }

    private boolean sameDigits(long orig, long... others) {
        boolean[] ref = new boolean[10];
        while (orig > 0) {
            int d = (int) (orig % 10);
            orig /= 10;
            ref[d] = true;
        }
        for (long anOther : others) {
            boolean[] next = new boolean[10];
            while (anOther > 0) {
                int digit = (int) anOther % 10;
                if (next[digit]) {
                    return false;
                }
                anOther /= 10;
                next[digit] = true;
            }
            if (!Arrays.equals(next, ref)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void solve() {
        Long[] digits = { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L };
        long smallest = Long.MAX_VALUE;
        for (Long[] a : new Permutations<Long>(digits)) {
            for (long size = 2; size <= a.length; ++size) {
                Long[] b = Arrays.copyOf(a, (int) size);
                long val = merge(b);

                if (sameDigits(val, 2 * val, 3 * val, 4 * val, 5 * val, 6 * val)) {
                    smallest = Math.min(val, smallest);
                }
            }
        }

        printSolution("%d : %d, %d, %d ,%d, %d", smallest, 2 * smallest, 3 * smallest, 4 * smallest, 5 * smallest,
                6 * smallest);
    }
}
