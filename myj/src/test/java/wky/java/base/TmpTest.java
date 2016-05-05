package wky.java.base;


import java.util.Date;

import org.junit.Test;

public class TmpTest {

	@Test
	public void test01(){
//		System.out.println(Integer.parseInt("354"));
		System.out.println(java.sql.Date.valueOf("2016-04-26"));
		Date d = new Date();
		System.out.println(java.sql.Date.class.getName()); 
		System.out.println(d.toString()); 
//		System.out.println(java.sql.Date.valueOf(d.toString())); 
		System.out.println(new java.sql.Date(new java.util.Date().getTime()).toString()); 
	}
	
	@Test
	public void test02(){
		try {
			int a = 1/0;
		} catch (ArithmeticException ex){
			System.out.println("ArithmeticException");
		} catch (Exception ex){
			System.out.println("Exception");
		}
	}
}
