package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem41 extends Problem {
    private List<Long> primes = new ArrayList<>();

    public Problem41() {
        super(41);
    }

    void permute(int depth, int[] picking, List<Long> store) {
        if (depth == (picking.length - 1)) {
            long value = toLong(picking);
            if (isPrime(value))
                store.add(value);
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

    private long toLong(int[] picking) {
        long result = 0L;
        for (int ctr = 0; ctr < picking.length; ++ctr)
            result = 10 * result + (long) picking[ctr];
        return result;
    }

    private boolean isPrime(long value) {
        for (long p : primes) {
            if ((value % p) == 0) {
                return false;
            }
            if (p * p > value)
                break;
        }
        return true;
    }

    @Override
    public void solve() {
        int[] digits = new int[9];
        for (int ctr = 0; ctr < 9; ctr++)
            digits[ctr] = ctr + 1;

        PrimeSerie series = new PrimeSerie();

        List<Long> palinPrime = new ArrayList<>();
        long largestValue = 987654321L;

        while (true) {
            long prime = series.next();
            primes.add(prime);
            if ((prime * prime) > largestValue)
                break;
        }

        for (int ctr = digits.length; palinPrime.isEmpty() && ctr > 0; --ctr) {
            int[] selectedDigits = Arrays.copyOfRange(digits, 0, ctr);
            permute(0, selectedDigits, palinPrime);

        }

        long largestPrime = 0;
        for (long p : palinPrime) {
            if (p > largestPrime)
                largestPrime = p;
        }

        System.out.format("%s: %d is the largest pan-digital prime\n", this, largestPrime);

    }
}
