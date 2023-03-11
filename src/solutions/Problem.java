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

}
