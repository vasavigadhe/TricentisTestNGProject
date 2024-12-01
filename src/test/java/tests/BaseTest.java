package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	ExtentReports Extent;
	ExtentTest Tests;
	
  WebDriver driver;
  /*@BeforeSuite
  public void setUpReport() {
	  ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
	  Extent = new ExtentReports();
	  Extent.attachReporter(sparkReporter);
  }*/
  @BeforeMethod
  public void setUp() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demowebshop.tricentis.com/");
//	  Tests = Extent.createTest("Test Name");
	  
  }

  @AfterMethod
  public void TearDown() {
//	  Extent.flush();
	  driver.quit();
  }

}
