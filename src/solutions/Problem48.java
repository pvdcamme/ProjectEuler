package solutions;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class Problem48 extends Problem {

    public Problem48() {
        super(48);
    }

    @Override
    public void solve() {
        BigInteger result = BigInteger.ZERO;
        int length = 10;
        BigInteger modVal = BigInteger.TEN.pow(length + 2);
        for(int ctr = 1; ctr < 1000; ctr++) {
            BigInteger a = BigInteger.valueOf(ctr);
            a = a.modPow(a, modVal);
            result = result.add(a);
        };
        String g = result.toString();
        g = g.substring(g.length() - length);

        System.out.format("%s: counted to %s \n", this, g);

    }
}
