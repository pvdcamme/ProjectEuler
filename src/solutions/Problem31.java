package solutions;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class Problem31 extends Problem {

	public Problem31() {
		super(31);

	}

	int countOut(int value, int[] coinTypes, int amtTypes) {
		if (amtTypes == 0) {
			return 1;
		}

		int n = 0;
		int count = 0;
		int currentType = coinTypes[amtTypes];
		while (n * currentType < value) {
			count += countOut(value - currentType * n, coinTypes, amtTypes - 1);
			n++;

		}
		if (n * currentType == value)
			count++;

		return count;
	}

	@Override
	public void solve() {
		int[] coins = { 1, 2, 5,10, 20, 50, 100, 200 };
		int money = 200;
		int nWays = countOut(money, coins, coins.length - 1);
		System.out.format("%s: : counted %d ways to %d\n", this, nWays, money);

	}
}
