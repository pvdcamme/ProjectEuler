package solutions;


public class Problem7 extends Problem {

	public Problem7() {
		super(7);
	}

	@Override
	public void solve() {
		PrimeSerie primes = new PrimeSerie();
		int nth = 10001;
		for (int ctr = 0; ctr < nth; ++ctr )
		{
			primes.next();
		}
		
		System.out.println(this + ": " +nth + "th prime is: "+ primes.current());
	}
}
