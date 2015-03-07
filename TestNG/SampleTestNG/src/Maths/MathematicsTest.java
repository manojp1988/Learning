package Maths;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MathematicsTest {

	Mathematics maths;

	@BeforeSuite
	public void beforeSuite() {
		maths = new Mathematics();
	}

	@Test(suiteName="AddSuite", testName="Add", threadPoolSize=3, invocationCount=3)
	public void add() {
		assertEquals(maths.add(2, 3), 5);
	}

	@Test(expectedExceptions={ArithmeticException.class})
	public void divide() {
		assertEquals(maths.divide(4, 0), 2);
	}

	@Test
	public void multiply() {
		assertEquals(maths.multiply(2, 3), 6);
	}

	@Test
	public void sub() {
		assertEquals(maths.sub(2, 3), -1);
	}
}
