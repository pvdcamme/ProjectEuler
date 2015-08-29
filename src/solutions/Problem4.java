package solutions;

public class Problem4 extends Problem {

	public Problem4() {
		super(4);
	}

	boolean isPalinDrome(long val) {
		String strVal = "" + val;
		int length = strVal.length();
		for (int ctr = 0; ctr < (length / 2); ++ctr) {
			char fromStart = strVal.charAt(ctr);
			char fromEnd = strVal.charAt(length - (ctr + 1));
			if (fromStart != fromEnd)
				return false;

		}
		return true;
	}

	@Override
	public void solve() {
		long largest = 0;
		
		for(int a = 100; a< 999; ++a)
			for(int b = 100; b< 999; ++b)
			{
				if(isPalinDrome(a * b))
					largest = Math.max(largest, a * b);
			}
		System.out.println(this + ":largest palindrome-product is " + largest);
	}

}
