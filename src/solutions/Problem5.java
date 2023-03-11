package solutions;

import java.util.HashMap;

import solutions.PrimeUtils.PrimeFactor;

public class Problem5 extends Problem {

    public Problem5() {
        super(5);
    }

    @Override
    public void solve() {
        HashMap<Long, PrimeFactor> factors = new HashMap<Long, PrimeUtils.PrimeFactor>();

        PrimeSerie primes = new PrimeSerie();
        for (long ctr = 2; ctr <= 20; ++ctr) {
            for (PrimeFactor fac : PrimeUtils.factorize(ctr, primes)) {
                PrimeFactor current = factors.get(fac.prime);
                if (current == null || current.times < fac.times) {
                    factors.put(fac.prime, fac);
                }
                primes.reset();
            }
        }

        long result = 1;
        for (PrimeFactor a : factors.values()) {
            for (int ctr = 0; ctr < a.times; ctr++) {
                result *= a.prime;
            }
        }

        System.out.println(this + ": smallest multiple= " + result);
    }

}
