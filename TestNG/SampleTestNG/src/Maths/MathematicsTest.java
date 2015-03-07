package Maths;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

public class MathematicsTest {

	Mathematics maths;
	
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  maths = new Mathematics();
	  System.out.println("@BeforeClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuite");
  }


  @Test
  public void add() {
	  assertEquals(maths.add(2, 3), 5);
  }

  @Test
  public void divide() {
	  assertEquals(maths.divide(4, 2), 2);
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
