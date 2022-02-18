/*
Class: TechCircle Batch #9
Date: February 5, 2022
Student: Ming-Jen Leu (Henry Leu)
Programming language: Java 11
Automated Testing Framework: Selenium 3.141.59
JUnit 4.13.2
Filename: SaturdaySelenium.java
 
  
1. Go to Amazon 
2. Send "any key" 
3. click search 
4. select one of the item 
5. add it to cart
6. validate the item in the cart
7. remove the item
8. validate the cart is empty
9. navigate to youtube 
10. validate the title is youtube 
11. search video 
12. play the video.
*/
package introToSeleniumMaven;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaturdaySelenium {
	WebDriver driver;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
		
	@Test
	public void testAmazonYouTube() throws InterruptedException {
		driver.get("https://www.amazon.com");
	
		// Search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java");
		Thread.sleep(2000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"0search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[1]/h2/a/span")).click();		
		// Select a product - Murach's Java Programming Training & Reference
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[1]/h2/a")).click();
		driver.findElement(By.xpath("//img[@alt=\"Sponsored Ad - Murach's Java Programming: Training & Reference\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("nav-cart-count")).click();
		Thread.sleep(2000);
		String quantity = driver.findElement(By.id("sc-subtotal-label-activecart")).getText();
		System.out.println(quantity);		
		
		// Delete a product
		driver.findElement(By.id("a-autoid-1-announce")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("0 (Delete)")).click();
		
		// 2nd way of delete a product
		//driver.findElement(By.xpath("//input[@value='Delete']")).click();
		//Thread.sleep(2000);
		
		Thread.sleep(2000);
		System.out.println("deleted");
		

		driver.get("https://www.youtube.com");
		
		String actualPageTitle = driver.getTitle();
		String expectedPagetitle = "YouTube";

		if (expectedPagetitle.equalsIgnoreCase(actualPageTitle)) {
			System.out.println("Pass! YouTube title matched.");
		} else {
			System.out.println("YouTube title failed to match.");
			System.out.println("Expected to see ---> " + expectedPagetitle);
			System.out.println("The driver got ---> " + actualPageTitle);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("google stadia");
		Thread.sleep(2000);
		driver.findElement(By.id("search-icon-legacy")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//img[@src='https://i.ytimg.com/vi/rFTMGZNbZjg/hqdefault.jpg?sqp=-oaymwEcCOADEI4CSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAzSrqFIJsOrxEMNEtr5uoBLhYjPQ']")).click();
		Thread.sleep(10000);
	}
		
	@Ignore
	@Test
	public void youtube() throws InterruptedException {
		driver.get("https://www.youtube.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("google stadia");
		Thread.sleep(2000);
		driver.findElement(By.id("search-icon-legacy")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//img[@src='https://i.ytimg.com/vi/rFTMGZNbZjg/hqdefault.jpg?sqp=-oaymwEcCOADEI4CSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAzSrqFIJsOrxEMNEtr5uoBLhYjPQ']")).click();
		driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
		
		Thread.sleep(10000);

	}
	
	@After
	public void afterTest() {
		driver.close();
	}
}
