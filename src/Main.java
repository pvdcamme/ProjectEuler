
import solutions.*;

public class Main {

	public static void main(String[] args) {
		/*
		 * Problem[] p = { new Problem1(), new Problem2(), new Problem3(), new
		 * Problem4(), new Problem5(), new Problem6(), new Problem7(), new
		 * Problem8(), new Problem9(), new Problem10(), new Problem11(), new
		 * Problem12(), new Problem13() , new Problem14(), new Problem15(), new
		 * Problem16(), new Problem18(), new Problem19(), new Problem20(), new
		 * Problem21(),new Problem22(),new Problem23(),new Problem24(),new
		 * Problem25(), new Problem26()};
		 */
		Problem[] p = { new Problem27(), new Problem28(), new Problem29(),
				new Problem30(), new Problem31(), new Problem32(),
				new Problem33(), new Problem34(), new Problem35(), new Problem36() , new Problem37(), new Problem38()};
		long now = System.currentTimeMillis();
		for (Problem prob : p)
			prob.solve();
		System.out.println(System.currentTimeMillis() - now);
	}

}
