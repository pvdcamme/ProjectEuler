package solutions;

public class Problem6 extends Problem {

    public Problem6() {
        super(6);
    }

    @Override
    public void solve() {
        long sumSquares = 0;
        long sum = 0;
        for (int ctr = 1; ctr <= 100; ++ctr) {
            sumSquares += ctr * ctr;
            sum += ctr;
        }

        long difference = sum * sum - sumSquares;
        printSolution("difference between squares= %d", difference);
    }

}
