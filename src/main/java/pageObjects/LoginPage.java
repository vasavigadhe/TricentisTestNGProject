package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Login{
	WebDriver driver;
	
	@FindBy(id = "Email")
	WebElement Email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement login;
	
	@FindBy(xpath = "//span[contains(text(),'Login was unsuccessful')]")
	WebElement ErrorMsg;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void EnterMail(String mail) {
		Email.sendKeys(mail);
	}
	
	public void EnterPwd(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void ClickLogin() {
		login.click();
	}
	
	public boolean isErrorMessageDisplayed() {
		return ErrorMsg.isDisplayed();
	}
}
