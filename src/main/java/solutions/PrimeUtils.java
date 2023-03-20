package solutions;

import java.util.ArrayList;
import java.util.List;

public class PrimeUtils {
    private static PrimeSerie serie = new PrimeSerie();

    public static class PrimeFactor {
        public final long prime;
        public final long times;

        PrimeFactor(long prime, long times) {
            this.prime = prime;
            this.times = times;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof PrimeFactor) {
                PrimeFactor oth = (PrimeFactor) obj;
                return oth.prime == prime && oth.times == times;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (int) (prime ^ times);
        }

        @Override
        public String toString() {
            return String.format("%d ** %d", prime, times);
        }
    }

    public static List<PrimeFactor> factorize(long val) {
        serie.reset();
        return factorize(val, serie);
    }

    public static List<PrimeFactor> factorize(long val, PrimeSerie primes) {
        List<PrimeFactor> result = new ArrayList<PrimeUtils.PrimeFactor>();
        do {
            long testPrime = primes.next();
            int ctr = 0;
            while (val % testPrime == 0) {
                val /= testPrime;
                ctr++;
            }

            if (ctr != 0) {
                result.add(new PrimeFactor(testPrime, ctr));
            }
        } while (val > 1);
        return result;
    }

    public static List<Long> gatherPrimes(long minPrime, long maxPrime) {
        List<Long> result = new ArrayList<>();
        serie.reset();

        while (serie.next() < maxPrime) {
            long val = serie.current();
            if (val > minPrime) {
                result.add(serie.current());
            }
        }
        return result;
    }
}
