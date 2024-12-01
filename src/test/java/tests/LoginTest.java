package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.OR_AddDeskTops;
import pageObjects.OR_Dashboard;
import pageObjects.ShoppingCartPage;
import utilities.ListnerTestNGReports;

//@Listeners(ListnerTestNGReports.class)
public class LoginTest extends BaseTest {
	
  @Test(priority=1)
  public void testValidLogin() throws InterruptedException {
	  Assert.fail("Test case Failed");
	  LoginPage login = new LoginPage(driver);
	  login.clickLoginLink();
	  Thread.sleep(2000);
	  login.EnterMail("vasavi0805@gmail.com");
	  login.EnterPwd("17Rj1@0442");
	  login.ClickLogin();
	  Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
	  
  }
  
  @Test(priority=2, dependsOnMethods = "testValidLogin")
  public void testInvalidLogin() throws InterruptedException {
	  LoginPage l = new LoginPage(driver);
	  l.clickLoginLink();
	  l.EnterMail("fghj@gmail.com");
	  l.EnterPwd("3456ghj");
	  l.ClickLogin();
	  Assert.assertTrue(l.isErrorMessageDisplayed());
  }
  
  @Test(priority=3)
  public void SelectProductandCheckout() throws InterruptedException, IOException {
	  LoginPage l = new LoginPage(driver);
	  l.clickLoginLink();
	  l.EnterMail("vasavi0805@gmail.com");
	  l.EnterPwd("17Rj1@0442");
	  l.ClickLogin();
	  
	  OR_Dashboard ord = new OR_Dashboard(driver);
	  ord.SelectDeskTopOption();
	  
	  OR_AddDeskTops oad = new OR_AddDeskTops(driver);
	  oad.Desktops();
	  oad.Addtocart();
	  oad.Addcomputer();
	  oad.AddCartClick();
	  
	  ShoppingCartPage shopping = new ShoppingCartPage(driver);
	  shopping.shoppingCart();
	  
	  CheckoutPage checkout = new CheckoutPage(driver);
	  checkout.Checkout();
	  
  }
}
