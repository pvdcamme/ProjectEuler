package solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Problem38 extends Problem {

    public Problem38() {
        super(38);
    }

    void permute(int depth, int[] picking, Vector<int[]> store) {
        if (depth == (picking.length - 1)) {
            store.add(Arrays.copyOf(picking, picking.length));
        } else {
            for (int digitCtr = depth; digitCtr < picking.length; ++digitCtr) {
                int a = picking[depth];
                int b = picking[digitCtr];

                picking[depth] = b;
                picking[digitCtr] = a;

                permute(depth + 1, picking, store);

                picking[depth] = a;
                picking[digitCtr] = b;
            }
        }
    }

    private long toLong(int[] picking, int start, int end) {
        long result = 0L;
        for (int ctr = start; ctr < end; ++ctr)
            result = 10 * result + (long) picking[ctr];
        return result;
    }

    @Override
    public void solve() {
        int[] digits = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Vector<int[]> permutations = new Vector<int[]>();
        permute(0, digits, permutations);
        Collections.sort(permutations, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                for (int ctr = 0; ctr < o1.length; ++ctr) {
                    if (o1[ctr] != o2[ctr])
                        return o1[ctr] - o2[ctr];
                }
                return 0;
            }

        });
        Collections.reverse(permutations);

        boolean found = false;
        long result = Long.MIN_VALUE;
        for (int[] permutation : permutations) {
            for (int chunkSize = 1; chunkSize < (digits.length - 1); chunkSize++) {
                int base = (int) toLong(permutation, 0, chunkSize);
                int n = 1;
                boolean hasChance = true;
                boolean matched = false;
                int search = chunkSize;
                do {
                    n++;
                    int next = n * base;
                    Vector<Integer> specificDigits = new Vector<Integer>();
                    while (next > 0) {
                        specificDigits.add(next % 10);
                        next /= 10;
                    }
                    Collections.reverse(specificDigits);
                    for (int dig : specificDigits) {
                        hasChance = hasChance && (search < permutation.length) && (dig == permutation[search]);
                        search++;
                    }
                    matched = hasChance && (search == permutation.length);
                } while (hasChance && !matched);
                if (matched) {
                    found = true;
                    break;
                }
            }
            if (found) {
                result = toLong(permutation, 0, permutation.length);
                break;
            }
        }

        System.out.format("%s: : largest permution is %d\n", this, result);

    }
}
