package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalog;
import rahulshettyacademy.pageobjects.cartPage;
import rahulshettyacademy.pageobjects.confirmationPage;

public class SubmitOrderTest extends BaseTest{
	 String productName="ZARA COAT 3";
	
	@Test(dataProvider="getData", groups="Purchase")
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
     
      ProductCatalog proCatalog =  landingPage.loginApplication(input.get("email"), input.get("password"));
      List<WebElement> products=proCatalog.getProductList();
      proCatalog.addProductToCart(input.get("productName"));
      cartPage cartpage= proCatalog.gotoCart();	  
	  
      Boolean match=cartpage.VerifyProductDisplay(productName);
      Assert.assertTrue(match);
      CheckoutPage checkoutPage=cartpage.gotoCheckout();
      checkoutPage.selectCountry("india");
      confirmationPage confirmationPage=checkoutPage.submitOrder();
	  
	  String confirmMsg = confirmationPage.getConfirmMessage();
	  Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	  
	  
}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() {
		ProductCatalog proCatalog =  landingPage.loginApplication("keshu@gmail.com", "Keshri@123");
		OrderPage orderPage  =proCatalog.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap("C:\\Users\\prave\\eclipse-workspace\\SeleniumFramework\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	
	}
	
	
 
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("email", "keshu@gmail.com");
//	map.put("password", "Keshri@123");
//	map.put("productName", "ZARA COAT 3");
//	HashMap<String,String> map1 = new HashMap<String,String>();
//	map1.put("email", "ritusingh@gmail.com");
//	map1.put("password", "Keshri@123");
//	map1.put("productName", "ADIDAS ORIGINAL");
	
}
