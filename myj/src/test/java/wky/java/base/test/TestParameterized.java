package wky.java.base.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestParameterized {
	public class PrimeNumberChecker {
		public Boolean validate(final Integer primeNumber) {
			for (int i = 2; i < (primeNumber / 2); i++) {
				if (primeNumber % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	private Integer inputNumber;
	private Boolean expectedResult;
	private PrimeNumberChecker primeNumberChecker;

	@Before
	public void initialize() {
		primeNumberChecker = new PrimeNumberChecker();
	}

	// Each parameter should be placed as an argument here
	// Every time runner triggers, it will pass the arguments
	// from parameters we defined in primeNumbers() method
	public TestParameterized(Integer inputNumber, 
	      Boolean expectedResult) {
	      this.inputNumber = inputNumber;
	      this.expectedResult = expectedResult;
	   }

	@Parameterized.Parameters
	public static List<Object[]> primeNumbers() {
		return Arrays.asList(new Object[][] { { 2, true }, { 6, false }, { 19, true }, { 22, false }, { 23, true } });
	}

	// This test will run 4 times since we have 5 parameters defined
	@Test
	public void testPrimeNumberChecker() {
		System.out.println("Parameterized Number is : " + inputNumber);
		assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
	}
}
