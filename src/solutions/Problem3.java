package solutions;

public class Problem3 extends Problem {

    public Problem3() {
        super(3);
    }

    @Override
    public void solve() {
        PrimeSerie serie = new PrimeSerie();
        long start = 600851475143l;
        long prime;
        do {
            prime = serie.next();
            if (start % prime == 0) {
                start /= prime;
                System.out.println("divisor: " + prime);
            }
        } while (start > 1);
        System.out.println(this + "largest prime divisor: " + prime);
    }

}
