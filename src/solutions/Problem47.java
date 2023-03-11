package solutions;

import java.util.Vector;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Problem47 extends Problem {

    public Problem47() {
        super(47);
    }

    private List<Integer> primeFactors(int n, List<Integer> primes) {
        List<Integer> factors = new ArrayList<>();
        int unresolved = n;

        for(int p: primes) {
            int factor = 1;
            while(unresolved % (p * factor) == 0) {
                factor *= p;
            }
            if(factor != 1)
                factors.add(factor);
            unresolved = unresolved / factor;

            if(unresolved == 1 || (p * p) > n) {
                break;
            }
        }
        return factors;
    }

    @Override
    public void solve() {
        long maxPrime = 10000000;
        int size = 4;
        List<Integer> primes = new ArrayList<>();
        PrimeSerie primeSerie = new PrimeSerie();
        while(primeSerie.next() < maxPrime) {
            primes.add((int)primeSerie.current());
        }
        Queue<List<Integer> > factors = new LinkedList<>();

        for(int ctr = 10; ctr < maxPrime; ++ctr)
        {
            factors.offer(primeFactors(ctr, primes));
            if(factors.size() > size)
                factors.poll();
            Set<Integer> factorSet = new HashSet<Integer>();
            int count = 0;
            for(List<Integer> fac: factors) {
                if (fac.size() != size) {
                    count = 1000;
                    break;
                }
                for(int f: fac) {
                    count++;
                    factorSet.add(f);
                }
            }
            if(count == factorSet.size()) {
                System.out.format("%s: Found %d consecutive elements starting from %d \n",this, size, (ctr - size) + 1);
                break;

            }

        }

    }
}
