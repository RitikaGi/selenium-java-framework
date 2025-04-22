package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;
import rahulshettyacademy.TestComponents.Authenticator;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.ProductCatalog;
import rahulshettyacademy.pageobjects.cartPage;

public class ErrorValidation extends BaseTest {
	

	@Test(groups={"ErrorHandling"}, retryAnalyzer = Authenticator.Retry.class)
	public void LoginErrorValidation() throws InterruptedException, IOException {
		
     landingPage.loginApplication("keshu34dtgyh@gmail.com", "Keshrit@123");
    Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    //

}
	
	@Test
	public void ProductValidation() throws InterruptedException, IOException {
		String productName="ZARA COAT 3";
	      launchApplication();
	      ProductCatalog proCatalog =  landingPage.loginApplication("keshu@gmail.com", "Keshri@123");
	      List<WebElement> products=proCatalog.getProductList();
	      proCatalog.addProductToCart(productName);
	      cartPage cartpage= proCatalog.gotoCart();	  
		  
	      Boolean match=cartpage.VerifyProductDisplay(productName);
	      Assert.assertTrue(match);
	}
}