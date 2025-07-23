package SeleniumMaven.Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumMaven.Resources.Reports;

public class Listeners extends BaseTest implements ITestListener  {
	
	ExtentTest test;
	ExtentReports extent =Reports.config();
	ThreadLocal<ExtentTest> uniqueTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test =extent.createTest(result.getMethod().getMethodName());
		uniqueTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		uniqueTest.get().fail(result.getThrowable());
		
		//screenshot, attach to report
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}
		
		
		String filePath = null;
		try {
			filePath =getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uniqueTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
