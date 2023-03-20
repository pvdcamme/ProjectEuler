package solutions;

public class Problem39 extends Problem {

    public Problem39() {
        super(39);
    }

    @Override
    public void solve() {
        final int MAX_PERIMETER = 1000;
        boolean[] isSquare = new boolean[MAX_PERIMETER * MAX_PERIMETER];
        int[] methods = new int[MAX_PERIMETER];

        for (int ctr = 0; ctr < MAX_PERIMETER; ++ctr) {
            isSquare[ctr * ctr] = true;
        }

        for (int a = 1; a < 1000; a++)
            for (int b = 1; b < a && ((a + b) < 1000); b++) {
                int cc = a * a + b * b;
                int c;
                if (cc < (MAX_PERIMETER * MAX_PERIMETER) && isSquare[cc])
                    c = (int) Math.sqrt(cc);
                else
                    continue;

                int p = a + b + c;
                if (p < MAX_PERIMETER)
                    methods[p]++;
            }

        int bestP = 0;
        int pSolutions = 0;
        for (int ctr = 0; ctr < MAX_PERIMETER; ++ctr) {
            if (methods[ctr] > pSolutions) {
                pSolutions = methods[ctr];
                bestP = ctr;
            }
        }

        System.out.format("%s: :a perimeter equal to  %d has %d solutions\n", this, bestP, pSolutions);

    }
}
