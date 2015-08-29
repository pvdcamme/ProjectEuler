package solutions;

public class Problem12 extends Problem {
	public Problem12() {
		super(12);
	}

	@Override
	public void solve() {
		long sum = 0;
		int ctr = 1;
		int numDivisors = 500;
		while(true)
		{
			sum += ctr;
			ctr++;
			int divisors = 0;
			for(int divCtr= 1; divCtr  <= sum && (divCtr * divCtr)<= sum + 3;++divCtr)
				if(sum  % divCtr== 0)
					divisors++;
			divisors *= 2;
			if(divisors >numDivisors)
				break;
		}
		System.out.println(this + ": first triangle to have over " + numDivisors +" divisors: " +sum);
	}
}
