package Base.Test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int count=0;
	int maxTry=1;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxTry) {
			System.out.println("Retrying: "+(count+1));
			count++;
			return true;
		}
		return false;
	}

}
