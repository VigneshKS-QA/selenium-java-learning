package Base.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.Reports;

public class Listeners extends Base implements ITestListener {
	
	
	ExtentReports extent =Reports.config();
	ExtentTest test;
	ThreadLocal<ExtentTest> uniqueTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		 
		test =extent.createTest(result.getMethod().getMethodName());
		uniqueTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		uniqueTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		uniqueTest.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}
		
		String filePath=null;
		try {
			filePath =getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uniqueTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

}
