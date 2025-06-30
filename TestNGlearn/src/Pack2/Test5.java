package Pack2;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test5 {
	@AfterTest
	public void Colour1() {
		System.out.println("1Red");
	}
	
	@Test(groups="Smoke")
	public void Colour2() {
		System.out.println("2Green");
	}
	@BeforeTest
	public void Colour3() {
		System.out.println("3White used beforetest");
	}
	@BeforeSuite
	public void suiteLevel() {
		System.out.println("I will execute first from test5 class by using before suite");
}
}
