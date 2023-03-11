package solutions;

public class Problem10 extends Problem {

    public Problem10() {
        super(10);
    }

    @Override
    public void solve() {
        PrimeSerie primes = new PrimeSerie();
        long sum = 0;
        int maxPrime = 2 * 1000 * 1000;
        for (long prime = primes.next(); primes.current() < maxPrime; prime = primes.next()) {
            sum += prime;
        }

        System.out.println(this + ": sum of primes below " + maxPrime + " is " + sum);
    }
}
