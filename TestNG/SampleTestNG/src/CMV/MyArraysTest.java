package CMV;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class MyArraysTest {

	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
				new Object[] { new int[] { 1, 2, 3, 4, 5 }, 3, 4, 1 },
				new Object[] { new int[] { 2, 9, 3, 3, 5 }, 1, 4, 3 }, };
	}

	@Test(dataProvider = "dp")
	public void getMinimum(int[] array, int startIndex, int endIndex,
			int expectedValue) {
		Assert.assertEquals(MyArrays.getMinimum(array, startIndex, endIndex),
				expectedValue);
	}
}
