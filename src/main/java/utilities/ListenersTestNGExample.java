package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTestNGExample implements ITestListener {
	public void onStart(ITestContext context) {
		System.out.println("On Method started");
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("On Finish Method started");
	}
	
	public void onTeststart(ITestResult result) {
		System.out.println("New Test started" + result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("OnTest Success method" +result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("OnTestFailure Method"+result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("OnTestSkipped Method" +result.getName());
	}
	
	public void OnTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("OnTestFailedButWithinSuccessPercentage"+ result.getName());
	}
	
}