package solutions;

public class Problem2 extends Problem {

    public Problem2() {
        super(2);
    }

    @Override
    public void solve() {
        FibSerie serie = new FibSerie();
        long sum = 0;
        do {
            long next = serie.next();
            if (next % 2 == 0)
                sum += next;
        } while (serie.current() < 4 * 1000 * 1000);
        System.out.println(this + ": sum=" + sum);
    }

}
