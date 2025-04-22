package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalog;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
      
      WebDriver driver = new ChromeDriver();
      String productName="ZARA COAT 3";
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize();
      LandingPage ld=new LandingPage(driver);
   //   ld.goTo();
   //   ld.loginApplication();
      ProductCatalog productCatalog = new ProductCatalog(driver);
      List<WebElement> products=productCatalog.getProductList();
      WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
      
       
      WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
	//  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	//  wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))); 
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	//  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
	  
	  List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	  System.out.println(driver.findElement(By.cssSelector("div[class='cartSection'] h3")).getText());
	  Thread.sleep(2000);
//	  
	  boolean match = cartProducts.stream()
			    .anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	 
	  Assert.assertTrue(match);
	  driver.findElement(By.cssSelector(".totalRow button")).click();
	  Actions a = new Actions(driver);
	  a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"india").build().perform();
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	  driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	  driver.findElement(By.cssSelector(".action__submit")).click();
	  String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
	  Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
	  
	  
	  
      
      
	  
}
}

