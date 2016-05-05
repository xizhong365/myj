/**
 * 
 */
package wky.java.base.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * junit 4 http://junit.org/junit4/
 * 
 * @author Erxwu
 *
 *         junit 5 http://junit.org/junit5/
 */
public class TestJunit {

	@BeforeClass
	public static void init() {
		System.out.println("@BeforeClass > init");
	}

	@Before
	public void setup() {
		System.out.println("> Before");
	}

	@Test(timeout = 1000)
	public void testAssert() {
		System.out.println("testAssert");
		assertEquals("abc", "abc");
		assertFalse(1 == 2);
		assertTrue(1 > 0);

		String a = "", b = "";
		assertSame(a, b); // tests if two object references point to the same object

		int[] a_arr = { 1, 2 };
		int[] b_arr = { 2, 1 };
		assertNotNull(b_arr);
		assertArrayEquals("array order matters.", a_arr, b_arr);

		assertNull(a_arr); // will not run this assert as it already failed.
	}

	@Test
	@Ignore
	public void testAssert2() {
		String a = "", b = "";
		assertSame(a, b);
	}

	@Test
	public void testAssertFail() {
		System.out.println("testAssertFail");
		fail();
	}

	@Test(expected = ArithmeticException.class)
	public void testException() {
		System.out.println("testException");
		int a = 1 / 0;
		System.out.println(a);
	}

	@After
	public void after() {
		System.out.println("> After");
	}

	@AfterClass
	public static void finish() {
		System.out.println("@BeforeClass > finish");
	}

}
