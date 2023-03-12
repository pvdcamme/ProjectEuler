package solutions;

/**
 * Find the first four consecutive integers to have four distinct prime factors
 * each. What is the first of these numbers?
 *
 */
public class Problem47 extends Problem {

    public Problem47() {
        super(47);
    }

    public int boundedSearch(int minCount, int maxSearch) {
        int[] factorCount = new int[maxSearch];
        PrimeSerie primes = new PrimeSerie();
        while (primes.next() < maxSearch) {
            int currentPrime = (int) primes.current();
            int multiples = currentPrime;

            while (multiples < maxSearch) {
                factorCount[multiples] += 1;
                multiples += currentPrime;
            }
        }

        for (int firstPos = 0; firstPos < (maxSearch - minCount); ++firstPos) {
            boolean allGood = true;
            for (int neighbourIdx = 0; allGood && neighbourIdx < minCount; ++neighbourIdx) {
                allGood = allGood && (factorCount[firstPos + neighbourIdx] == minCount);
            }
            if (allGood) {
                return firstPos;
            }
        }
        return -1;
    }

    public void solve() {
        int searchSize = 10;
        while (true) {
            int res = boundedSearch(4, searchSize);
            if (res > 0) {
                printSolution("First of four is %d", res);
                return;
            }
            searchSize *= 10;
        }
    }
}
