package solutions;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Problem19 extends Problem {

	public Problem19() {
		super(19);
	}

	@Override
	public void solve() {
		Calendar start =  new GregorianCalendar();
		start.set(1901, 0, 1);
		
		int count = 0;
		while(start.get(Calendar.YEAR) <2001)
		{
			if((start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) && (start.get(Calendar.DAY_OF_MONTH) == 1))
			{
				count++;
			}
			start.add(Calendar.DAY_OF_WEEK, 1);
		}
		
			
		System.out
				.println(this + ": amount of sundays in 20th century is " + count);
	}
}
