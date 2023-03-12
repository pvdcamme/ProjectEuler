package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * 
 * The prime 41, can be written as the sum of six consecutive primes: 41 = 2 + 3
 * + 5 + 7 + 11 + 13
 * 
 * This is the longest sum of consecutive primes that adds to a prime below
 * one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds to a
 * prime, contains 21 terms, and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most
 * consecutive primes?
 * 
 * 
 */
public class Problem50 extends Problem {

    public Problem50() {
        super(50);
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

    @Override
    public void solve() {
        final long minPrime = 1;
        final long maxPrime = 1_000_000;
        List<Long> primes = gatherPrimes(minPrime, maxPrime);
        Set<Long> isPrime = new HashSet<>(primes);

        int lenghtCtr = 5;
        long summedPrime = 953;
        boolean foundPrime = true;
        while (lenghtCtr < 1000) {
            foundPrime = false;
            int nextLenght = lenghtCtr + 1;
            long result = 0;
            for (int ctr = 0; ctr < nextLenght; ++ctr) {
                result += primes.get(ctr);
            }

            for (int ctr = nextLenght; ctr < primes.size(); ++ctr) {
                result -= (ctr - nextLenght);
                result += primes.get(ctr);
                foundPrime = isPrime.contains(result);
                lenghtCtr = nextLenght;
                if (foundPrime) {
                    summedPrime = result;
                    printSolution("length=  %d with %d", lenghtCtr, result);
                    break;
                }
            }
        }
        printSolution("Summed to %d", summedPrime);
    }
}
