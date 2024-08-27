package Listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Base;

public class CustomerListener extends Base implements ITestListener{

	public void onTestFailure(ITestResult result) {
		try {
			getScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

}