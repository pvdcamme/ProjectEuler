package solutions;

public class Problem1 extends Problem {

    public Problem1() {
        super(1);
    }

    @Override
    public void solve() {
        int sum = 0;
        int maxVal = 1000;
        for (int ctr = 0; ctr < maxVal; ++ctr) {
            if (ctr % 3 == 0 || ctr % 5 == 0)
                sum += ctr;
        }
        printSolution("sum= %d", sum);
    }
}
