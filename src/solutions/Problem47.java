package solutions;

import java.util.List;
import java.util.Map;
import java.util.Set;

import solutions.PrimeUtils.PrimeFactor;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Find the first four consecutive integers to have four distinct prime factors
 * each. What is the first of these numbers?
 *
 */
public class Problem47 extends Problem {

    public Problem47() {
        super(47);
    }

    public int boundedSearch(int minCount, int maxval) {
        int[] cnt = new int[maxval];
        PrimeSerie p = new PrimeSerie();
        while (p.next() < maxval) {
            int currentPrime = (int) p.current();
            long val = currentPrime;

            while (val < maxval) {
                cnt[(int) val] += 1;
                val += currentPrime;
            }
        }

        for (int ctr = 0; ctr < (maxval - minCount); ++ctr) {
            boolean allGood = true;
            for (int inner = 0; allGood && inner < minCount; ++inner) {
                allGood = allGood && (cnt[ctr + inner] == minCount);
            }
            if (allGood) {
                return ctr;
            }
        }
        return -1;
    }

    public void solve() {
        int size = 10;
        while (true) {
            int res = boundedSearch(4, size);
            if (res > 0) {
                printSolution("First of four is %d", res);
                return;
            }
            size *= 10;
        }
    }
}
