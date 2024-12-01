package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends Login{
	
	@FindBy(xpath= "//*[@id='CountryId']")
	WebElement SelectCountry;
	
	@FindBy(css = "input[value='Estimate shipping']")
	WebElement EstimateShippingButton;
	
	@FindBy(xpath="//*[@id=\"termsofservice\"]")
	WebElement termsofservice;
	
	@FindBy(xpath="//*[@id=\"checkout\"]")
	WebElement CheckoutBtn;
	
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void shoppingCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(SelectCountry));
		Select select = new Select(SelectCountry);
		select.selectByValue("41");
		
		
		EstimateShippingButton.click();
		termsofservice.click();
		
		CheckoutBtn.click();
		
	}
}
