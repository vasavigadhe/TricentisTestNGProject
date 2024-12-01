package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OR_Dashboard extends Login{
	
	WebDriver driver;
	@FindBy(xpath="(//div[@class='header-menu']//descendant::a[contains(text(),'Computers')])[1]")
	WebElement computers;
	
	@FindBy(xpath="(//a[contains(text(),'Desktops')] )[1]")
	WebElement desktops;
	
	
	
	public OR_Dashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SelectDeskTopOption() throws InterruptedException {
		Actions A = new Actions(super.driver);
		A.moveToElement(computers).perform();;
		A.moveToElement(desktops).click().build().perform();
		
		Thread.sleep(3000);
	}
	
}
