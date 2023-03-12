package solutions;

public abstract class Problem {
    private final int mProblemNumer;

    public Problem(int number) {
        mProblemNumer = number;
    }

    public abstract void solve();

    @Override
    public String toString() {
        return "problem " + mProblemNumer;
    }

    protected void printSolution(String baseformat, Object ... args) {
        String formatted = String.format(baseformat, args);
        System.out.format("%s: %s%n", this, formatted);        
    }
}
