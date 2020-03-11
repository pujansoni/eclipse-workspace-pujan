/**
 * @author Pujan
 * @version 1
 * Trigonometric Functions SIN, COS, TAN [Non-implemented methods and constructors]
 */
package jUnittest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TrigonometricJunitTestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Result result = JUnitCore.runClasses(TrigonometricJunitTest.class);
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if(result.wasSuccessful()) {
			System.out.println("All the test cases were successfully executed");
		}
	}
}
