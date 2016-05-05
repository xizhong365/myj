package wky.java.base.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestJunitRunner {

	public static void main(String[] args) {
		Result r = JUnitCore.runClasses(TestTestSuite.class);

		for(Failure failure : r.getFailures()) {
			System.out.println(failure.toString());
		}
	}

}
