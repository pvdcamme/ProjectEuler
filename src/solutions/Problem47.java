package solutions;

import java.util.Vector;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Problem47 extends Problem {

    public Problem47() {
        super(47);
    }

    private Vector<Integer> primeFactors(int n, Vector<Integer> primes) {
        Vector<Integer> result = new Vector<>();

        for(int p: primes) {
            int factor = 1;
            while(n % (p * factor) == 0)
            {
                factor *= p;
            }
            if(factor != 1)
                result.add(factor);
            n = n / factor;
            if(n == 1)
                return result;
        }
        return result;
    }

    @Override
    public void solve() {
        long maxPrime = 1000000;
        int size = 4;
        Vector<Integer> primes = new Vector<>();
        PrimeSerie primeSerie = new PrimeSerie();
        while(primeSerie.next() < maxPrime) {
            primes.add((int)primeSerie.current());
        }
        Queue<Vector<Integer> > factors = new LinkedList<Vector<Integer> >();

        for(int ctr = 10; ctr < maxPrime; ++ctr)
        {
            factors.offer(primeFactors(ctr, primes));
            if(factors.size() > size)
                factors.poll();
            Set<Integer> factorSet = new HashSet<Integer>();
            int count = 0;
            for(Vector<Integer> fac: factors) {
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



        System.out.format("%s: \n",this);
    }
}
