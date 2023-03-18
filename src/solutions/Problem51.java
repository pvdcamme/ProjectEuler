package solutions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * 
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of
 * the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
 * 
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this
 * 5-digit number is the first example having seven primes among the ten
 * generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663,
 * 56773, and 56993. Consequently 56003, being the first member of this family,
 * is the smallest prime with this property.
 * 
 * Find the smallest prime which, by replacing part of the number (not
 * necessarily adjacent digits) with the same digit, is part of an eight prime
 * value family.
 * 
 * 
 */
public class Problem51 extends Problem {

    public Problem51() {
        super(51);
    }

    List<Integer> mask(List<Integer> digits, int mask) {
        List<Integer> result = new ArrayList<>();
        for (int digitCtr = 0; digitCtr < digits.size(); ++digitCtr) {
            boolean currentBit = (mask & 1) > 0;
            if (currentBit) {
                result.add(digits.get(digitCtr));
            }
            mask = mask >> 1;
        }
        return result;
    }

    boolean sameValue(List<Integer> digits, int mask) {
        int digit = -10;
        boolean stillGood = true;
        for (int digitCtr = 0; stillGood && digitCtr < digits.size(); ++digitCtr) {
            boolean currentBit = (mask & 1) == 0;
            if (currentBit && (digit >= 0)) {
                stillGood = stillGood && digit == digits.get(digitCtr);
            } else if (currentBit) {
                digit = digits.get(digitCtr);
            }
            mask = mask >> 1;
        }
        return stillGood;
    }

    long boundedSearch(int digitCount, int targetSize) {
        final long lowerBound = BigInteger.valueOf(10).pow(digitCount - 1).longValue();
        final long upperBound = BigInteger.valueOf(10).pow(digitCount).longValue();
        final int replaceAllMask = ((1 << digitCount) - 1);

        List<List<Integer>> primeDigits = PrimeUtils.gatherPrimes(lowerBound, upperBound).stream()
                .map(DigitUtils::toDigits).toList();

        for (int maskCtr = 1; maskCtr < replaceAllMask; maskCtr++) {
            Map<Long, List<Long>> sameCount = new HashMap<>();
            for (List<Integer> currentDigits : primeDigits) {
                if (sameValue(currentDigits, maskCtr)) {
                    long key = DigitUtils.fromDigits(mask(currentDigits, maskCtr));
                    sameCount.computeIfAbsent(key, (a) -> new ArrayList<>()).add(DigitUtils.fromDigits(currentDigits));
                }
            }
            for (Entry<Long, List<Long>> grouped : sameCount.entrySet()) {
                if (grouped.getValue().size() == targetSize) {
                    long minVal = Long.MAX_VALUE;
                    for (long d : grouped.getValue()) {
                        minVal = Math.min(minVal, d);
                    }
                    return minVal;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public void solve() {
        final int targetSize = 8;
        boolean found = false;
        for (int searchSize = 1; !found; searchSize++) {
            long result = boundedSearch(searchSize, targetSize);
            found = result > 0;
            if (found) {
                printSolution("Found %d for %d digits", result, searchSize);
            }
        }
    }
}
