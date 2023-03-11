package solutions;

public class Problem27 extends Problem {

    final boolean[] isPrime;
    final int PRIMECACHE = 10000000;

    public Problem27() {
        super(27);

        isPrime = new boolean[PRIMECACHE];

        PrimeSerie serie = new PrimeSerie();

        long currentPrime = serie.next();
        while (currentPrime < PRIMECACHE) {
            isPrime[(int) currentPrime] = true;
            currentPrime = serie.next();
        }
    }

    int search(int a, int b) {
        int n = 0;
        int value = n * n + a * n + b;
        while (value > 0 && value < PRIMECACHE && isPrime[n * n + a * n + b]) {
            n++;
            value = n * n + a * n + b;
        }
        return n - 1;
    }

    @Override
    public void solve() {
        int maxN = 0;
        int bestA = 0;
        int bestB = 0;
        for (int a = -999; a < 1000; a++)
            for (int b = -999; b < 1000; b++) {
                int current = search(a, b);
                if (current > maxN) {
                    maxN = current;
                    bestA = a;
                    bestB = b;
                }
            }
        System.out.format("%s: : a= %d and b= %d (product %d) has %d primes \n", this, bestA, bestB, bestA * bestB,
                maxN);

    }
}
