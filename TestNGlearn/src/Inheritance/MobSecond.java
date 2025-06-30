package Inheritance;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MobSecond extends Mob {

	@Test
	public void getMsg() {
		Login();
		System.out.println("success");
	}
	
	@Test(dependsOnMethods="getMsg")
	public void construct() {
		Constructors cs= new Constructors(5);	//3 is the value of a used in Constructor class and we can give int a=3; then Constructors(a)
		System.out.println(cs.add());
		System.out.println(cs.minus());
		
		System.out.println(cs.multi());
	}
	
	@BeforeTest
	public void Login1() {
		System.out.println("before success");
	}
}
