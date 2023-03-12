package solutions;

public class Problem9 extends Problem {

    public Problem9() {
        super(9);
    }

    @Override
    public void solve() {
        long a = 0, b = 0, c = 0;
        for (b = 1; b < 1000; ++b)
            for (a = 1; a < b; ++a) {
                c = 1000 - (a + b);
                if (c > b && (a * a) + (b * b) == (c * c)) {
                    printSolution("Pythagorean triplet for a+b+c = 1000 ( %d, %d, %d) = %d", a, b, c, a * b * c);

                    return;
                }
            }
    }
}
