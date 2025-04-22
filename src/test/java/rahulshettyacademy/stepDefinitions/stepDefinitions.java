package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalog;
import rahulshettyacademy.pageobjects.cartPage;
import rahulshettyacademy.pageobjects.confirmationPage;

public class stepDefinitions extends BaseTest{
	public LandingPage landingPage;
	public ProductCatalog proCatalog;
	public confirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage=launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_passowrd(String username,String password) {
		proCatalog = landingPage.loginApplication(username, password);
	}
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException {
		List<WebElement> products = proCatalog.getProductList();
		proCatalog.addProductToCart(productName);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) {
		cartPage cartpage= proCatalog.gotoCart();	  
		  
	      Boolean match=cartpage.VerifyProductDisplay(productName);
	      Assert.assertTrue(match);
	      CheckoutPage checkoutPage=cartpage.gotoCheckout();
	      checkoutPage.selectCountry("india");
	      confirmationPage=checkoutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on confirmationPage")
	public void message_is_displayed_confirmation_page(String string) {
		String confirmMsg = confirmationPage.getConfirmMessage();
		  Assert.assertTrue(confirmMsg.equalsIgnoreCase(string));
		  driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
	    Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	    driver.close();
	}
}
