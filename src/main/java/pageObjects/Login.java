package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;

@FindBy(xpath = "//a[text()='Log in']")
WebElement loginLink;

public Login() {}

public Login(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void clickLoginLink() throws InterruptedException {
	loginLink.click();
	Thread.sleep(3000);
}
}
