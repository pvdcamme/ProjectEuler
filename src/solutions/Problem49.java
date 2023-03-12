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
        long sortedVal = 0;
        for (long sortedDigit : digits) {
            sortedVal = sortedVal * 10 + sortedDigit;
        }
        return sortedVal;
    }

    public List<Long> tripleIncrement(List<Long> bb) {
        Set<Long> g = new HashSet<>(bb);
        ArrayList<Long> triples = new ArrayList<Long>();
        for (long smallest : g) {
            for (long middle : g) {
                if (middle <= smallest) {
                    continue;
                }
                long diff = middle - smallest;
                long largest = middle + diff;
                if (g.contains(largest)) {
                    String together = String.format("%d%d%d", smallest, middle, largest);
                    triples.add(Long.decode(together));
                }
            }
        }
        return triples;
    }

    @Override
    public void solve() {
        final long minPrime = 999;
        final long maxPrime = 10_000;
        final long forbidden = 148748178147L;
        List<Long> primes = gatherPrimes(minPrime, maxPrime);
        HashMap<Long, ArrayList<Long>> palinDromes = new HashMap<>();

        for (long aPrime : primes) {
            long key = sortedDigits(aPrime);
            List<Long> sharedDigits = palinDromes.computeIfAbsent(key, (a) -> new ArrayList<>());
            sharedDigits.add(aPrime);
        }
        for (List<Long> together : palinDromes.values()) {
            for (long triple : tripleIncrement(together)) {
                if (triple != forbidden) {
                    printSolution("%d", triple);
                }
            }

        }
    }
}
