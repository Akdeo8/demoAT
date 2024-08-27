package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryNG implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 0;

	public boolean retry(ITestResult result) {
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
