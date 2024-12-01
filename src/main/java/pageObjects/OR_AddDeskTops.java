package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DeskTopExcelUtils;


public class OR_AddDeskTops extends Login{

	WebDriver driver;
	DeskTopExcelUtils eu = new DeskTopExcelUtils();
	
	
	@FindBy(id ="products-orderby")
	WebElement SortBy;
	
	@FindBy(id = "products-pagesize")
	WebElement Display;
	
	@FindBy(id = "products-viewmode")
	WebElement List;
	
	@FindBy(xpath="(//span[text()='1000.00'])[1]")
	WebElement SelectPrice;
	
//	@FindBy(xpath = "//div//h2//a[contains(text(),'PLACEHOLDER')]//parent::h2//following-sibling::div[@class='add-info']//child::div[2]//input")
//	WebElement SelectProducts;
	
	@FindBy(css = "input#add-to-cart-button-72")
	WebElement AddtoCartBtn;
	
//	@FindBy(xpath = "//li//label[contains(text(),'PLACEHOLDER')]")
//	public WebElement SelectProcessor;
	
	@FindBy(xpath="//p[contains(text(),'The product has been added to your')]")
	WebElement ProductAddedLabelMsg;
	
	@FindBy(xpath="//span[text()='Shopping cart']")
	WebElement ShoppingCartLink;
	
	public OR_AddDeskTops(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void Desktops() throws InterruptedException {
		SortBy.click();
		Thread.sleep(2000);
		Select sortBySelect = new Select(SortBy);
		sortBySelect.selectByVisibleText("Name: A to Z");
		
		Thread.sleep(2000);
		Display.click();
		Select dDisplay = new Select(Display);
		dDisplay.selectByIndex(2);
		Thread.sleep(2000);
		List.click();
		Select L = new Select(List);
		int LastIndex = L.getOptions().size();
		L.selectByIndex(LastIndex-1);
		Thread.sleep(2000);
		SelectPrice.click();	
	}
	
	public void Addtocart() throws IOException, InterruptedException {
		Thread.sleep(2000);
		String name = eu.AddProduct("C:\\Automation_Workspace\\TricentisProject\\resources\\data.xlsx", "sheet1");
		String dynamicxpath = "//div//h2//a[contains(text(),'"+name+"')]//parent::h2//following-sibling::div[@class='add-info']//child::div[2]//input";
		WebElement AddCart = driver.findElement(By.xpath(dynamicxpath));
		AddCart.click();
		Thread.sleep(2000);	
		
	}
	
	public void Addcomputer() throws IOException, InterruptedException {
		String processor = eu.AddProcessor("C:\\Automation_Workspace\\TricentisProject\\resources\\data.xlsx", "sheet1");
//		WebElement dynamicProcessor = driver.findElement(By.xpath(SelectProcessor.getAttribute("xpath").replace("PLACEHOLDER", processor)));
		String dynamicxpath = "//li//label[contains(text(),'"+processor+"')]";
		WebElement dynamicProcessor = driver.findElement(By.xpath(dynamicxpath));
		Thread.sleep(3000);
		dynamicProcessor.click();
	}
	public void AddCartClick() throws InterruptedException {
		AddtoCartBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ProductAddedLabelMsg));
		if(ProductAddedLabelMsg.isDisplayed())
			System.out.println("Product added to the cart Label");
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_UP).perform();
		Thread.sleep(5000);
		ShoppingCartLink.click();
		Thread.sleep(2000);
	}
	
}
