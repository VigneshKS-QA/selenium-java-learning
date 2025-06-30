package Pack2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test3 {
	@AfterSuite
	public void suiteLevel() {
		System.out.println("I will execute last from test3 class by using after suite");
	}
@Test(dataProvider="getData")	
public void DemoSLOGIN(String username,String pass) {
	System.out.println("LoggedIn");
	System.out.println(username);
	System.out.println(pass);
}

@Test(groups="Smoke")
public void DemoSLOGOUT() {
	System.out.println("LoggedOut");
}
@Test
public void LOGOUT() {
	System.out.println("Out");
}
@Parameters({"URL","sURL"})
@Test
public void HomeLoan(String firstURL,String secondURL) {
	System.out.println("holeloanURL");
	System.out.println(firstURL);
	System.out.println(secondURL);
}

@DataProvider
public Object[][] getData() {
	Object[][] datas = new Object[3][2];	//we have 3 username and pass ie, 3(rows), 2(column username and pass)
	//set 1 or row 1
	datas[0][0]="OneUsername";
	datas[0][1]="OnePassword";
	
	//set 2
	datas[1][0]="TwoUsername";
	datas[1][1]="TwoPassword";
	
	//set 3
	datas[2][0]="ThreeUsername";
	datas[2][1]="ThreePassword";
	return datas;
}
}
