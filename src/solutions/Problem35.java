package solutions;

import java.util.Collections;
import java.util.Vector;

public class Problem35 extends Problem {

    public Problem35() {
        super(35);
    }

    private int toInt(int[] digits, int start, int end) {
        int val = 0;
        for (int ctr = start; ctr < end; ++ctr)
            val = val * 10 + digits[ctr];
        return val;
    }

    private Vector<Integer> digits(int val) {
        Vector<Integer> result = new Vector<Integer>();
        while (val > 0) {
            result.add(val % 10);
            val /= 10;
        }
        Collections.reverse(result);
        return result;
    }

    @Override
    public void solve() {
        PrimeSerie serie = new PrimeSerie();
        int maxVal = 1000000;
        boolean[] isPrime = new boolean[maxVal];
        Vector<Integer> primes = new Vector<Integer>();

        while (serie.next() < maxVal) {
            primes.add((int) serie.current());
            isPrime[(int) serie.current()] = true;
        }

        int circularPrimeCount = 0;

        for (int prime : primes) {
            Vector<Integer> dig = digits(prime);
            int[] rotation = new int[dig.size()];

            boolean allPrime = true;
            for (int ctr = 0; allPrime && ctr < dig.size(); ++ctr) {

                for (int fillCtr = 0; fillCtr < rotation.length; ++fillCtr) {
                    int sourceLocation = (ctr + fillCtr) % rotation.length;
                    rotation[fillCtr] = dig.get(sourceLocation);
                }
                allPrime = isPrime[toInt(rotation, 0, rotation.length)];
            }
            if (allPrime) {
                circularPrimeCount++;
            }

        }
        System.out.format("%s: there are %d circular primes below %d\n", this, circularPrimeCount, maxVal);

    }
}
