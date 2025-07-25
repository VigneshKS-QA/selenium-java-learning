package SeleniumMaven.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	
	public static ExtentReports config() {
		
		String path =System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Test Reports");
		
		ExtentReports extent = new  ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vignesh");
		return extent;
		
	}
}
