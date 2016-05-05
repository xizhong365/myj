package wky.java.base.date;

import org.junit.Test;

public class DateBasis {

	@Test
	public void testCurrentDate(){
		// current date of java.sql.Date 
		System.out.println(new java.sql.Date(new java.util.Date().getTime()).toString()); 
	}
}
