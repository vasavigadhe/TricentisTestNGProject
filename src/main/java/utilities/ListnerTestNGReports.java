package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerTestNGReports implements  ITestListener{
	
	public ExtentSparkReporter sparkreporter; //UI of the Report
	public ExtentReports extent; //common info of Report
	public ExtentTest test; //Creating Test Entries in the Report and update the status of the Test methods
	
	public void onStart(ITestContext context) {
		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreport.html");
		sparkreporter.config().setDocumentTitle("Automation Tricentis Report");
		sparkreporter.config().setReportName("Web Testing");
		sparkreporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "chrome");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Tester Name", "Vasavi");
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS,"Test Case PASSED is:"+ result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case FAILED is:"+ result.getName());
		test.log(Status.FAIL, "Error is:"+ result.getThrowable());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case SKIPPED is:"+ result.getName());
		
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}
