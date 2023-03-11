package solutions;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

public class Problem29 extends Problem {

    public Problem29() {
        super(29);

    }

    @Override
    public void solve() {
        int max = 100;
        Set<BigInteger> distinctValues = new TreeSet<>();
        for (int a = 2; a <= max; ++a)
            for (int b = 2; b <= max; ++b) {
                BigInteger power = BigInteger.valueOf(a).pow(b);
                distinctValues.add(power);
            }
        System.out.format("%s: : a^b for 2 <= a,b<= %d results in %d distinct numbers \n", this, max,
                distinctValues.size());

    }
}
