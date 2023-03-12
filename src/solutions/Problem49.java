package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms
 * increases by 3330, is unusual in two ways: (i) each of the three terms are
 * prime, and, (ii) each of the 4-digit numbers are permutations of one another.
 * 
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 * 
 * What 12-digit number do you form by concatenating the three terms in this
 * sequence?
 *
 * 
 */
public class Problem49 extends Problem {

    public Problem49() {
        super(49);
    }

    private List<Long> gatherPrimes(long minPrime, long maxPrime) {
        List<Long> result = new ArrayList<>();
        PrimeSerie primes = new PrimeSerie();

        while (primes.next() < maxPrime) {
            long val = primes.current();
            if (val > minPrime) {
                result.add(primes.current());
            }
        }
        return result;
    }

    private long sortedDigits(long val) {
        List<Long> digits = new ArrayList<>();
        while (val > 0) {
            long d = val % 10;
            val = val / 10;
            digits.add(d);
        }
        digits.sort(Long::compare);
        long result = 0;
        for (long d : digits) {
            result = result * 10 + d;
        }
        return result;
    }

    public void searchIncrement(List<Long> bb) {
        Set<Long> g = new HashSet<>(bb);
        for (long a : g) {
            for (long b : g) {
                if (a == 1487) {
                    continue;
                }
                if (b <= a) {
                    continue;
                }
                long diff = b - a;
                long c = b + diff;
                if (g.contains(c)) {
                    printSolution("%d %d %d", a, b, c);
                }
            }
        }
    }

    @Override
    public void solve() {
        long minPrime = 999;
        long maxPrime = 10_000;
        List<Long> primes = gatherPrimes(minPrime, maxPrime);
        HashMap<Long, ArrayList<Long>> palinDromes = new HashMap<>();

        for (long aPrime : primes) {
            long key = sortedDigits(aPrime);
            List<Long> sharedDigits = palinDromes.computeIfAbsent(key, (a) -> new ArrayList<>());
            sharedDigits.add(aPrime);
        }
        for (List<Long> together : palinDromes.values()) {
            searchIncrement(together);
        }
    }
}
