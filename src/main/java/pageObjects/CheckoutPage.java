package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends Login{
	@FindBy(xpath="//*[@id='billing-buttons-container']/input")
	WebElement BillingContinue;
	
	@FindBy(xpath="//*[@id='PickUpInStore']")
	WebElement StorePickupChkBox;
	
	@FindBy(xpath="//*[@id='shipping-buttons-container']/input")
	WebElement ShippingContinueChkBox;
	
	@FindBy(xpath="//label[contains(text(),'Cash On Delivery')]")
	WebElement PaymentMethodCOD;
	
	@FindBy(xpath="//*[@id='payment-method-buttons-container']/input")
	WebElement PaymentContinue;
	
	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement PaymentInfoContinue;
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Checkout() {
		BillingContinue.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(StorePickupChkBox));
		StorePickupChkBox.click();
		wait.until(ExpectedConditions.visibilityOf(ShippingContinueChkBox));
		ShippingContinueChkBox.click();
		wait.until(ExpectedConditions.visibilityOf(PaymentMethodCOD));
		PaymentMethodCOD.click();
		wait.until(ExpectedConditions.visibilityOf(PaymentContinue));
		PaymentContinue.click();
		wait.until(ExpectedConditions.visibilityOf(PaymentInfoContinue));
		PaymentInfoContinue.click();
		
	}

}
