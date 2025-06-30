package Inheritance;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Mob {
	
	
	public void Login() {
		System.out.println("Login success");
	}
	
	@AfterTest
	public void Logout() {
		System.out.println("Logout success");
	}
	
}
