/*
Class: TechCircle Batch #9
Date: February 16, 2022
Student: Ming-Jen Leu (Henry Leu)
Programming language: Java 11
Automated Testing Framework: Selenium 3.141.59
JUnit 4.13.2
Filename: DressAutomation2.java

Homework:

 1. go to http://automationpractice.com/index.php
 2. click on DRESSES button
 3. add items on sale to cart and checkout
 4. continue to checkout until you see the 'authentication' page and verify it
*/

package students.henry.february14;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DressAutomation2 {
	WebDriver driver;
	WebElement element;

	@Before
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		By dressesBtn = By.xpath("//div[@id='block_top_menu']/ul/child::li[2]");

		// Click Dresses button
		driver.findElement(dressesBtn).click();

		int totalProduct = driver.findElements(By.xpath("//ul[contains(@class, 'product')]/li")).size();

		// If no product for sale, fail the test.
		Assert.assertFalse(totalProduct == 0);
		
		// Search all products that are sale.
		for (int i = 1; i <= totalProduct; i++) {

			// xpath for product price
			By productPricePath = By.xpath("//ul[contains(@class, 'product')]/li[" + i
					+ "]//div[@class='right-block']/div[@itemprop='offers']/*");

			// For each product, search if a product is on sale by checking %.
			List<WebElement> prices = driver.findElements(productPricePath);
			for (int j = 0; j < prices.size(); j++) {

				String percent = prices.get(j).getText();
				
				// This product is on sale. Perform the action.
				if (percent.contains("%")) {

					// Hover mouse to this item
					Actions action = new Actions(driver);
					WebElement hoverToItem = driver
							.findElement(By.xpath("//ul[contains(@class, 'product')]/li[" + i + "]//descendant::img"));
					action.moveToElement(hoverToItem).build().perform();

					// Click Add to cart button
					driver.findElement(
							By.xpath("//ul[contains(@class, 'product')]/li[" + i + "]//span[text()='Add to cart']"))
							.click();

					Thread.sleep(3000);

					// Continue shopping
					driver.findElement(By.xpath("//div[@id='layer_cart']//span[contains(@title, 'shopping')]")).click();
				} // if on sale
			} // for - loop for prices
			Thread.sleep(2000);
		} // for - loop all products

		// click Cart button
		driver.findElement(By.xpath("//div[@class ='shopping_cart']/a")).click();

		Thread.sleep(2000);

		// Proceed checkout
		driver.findElement(By.xpath("//a[contains(@class, 'standard-checkout')]/span")).click();

		// Authentication
		String expectedAuthentication = "AUTHENTICATION";
		String actualAuthentication = driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText();
		Assert.assertEquals(expectedAuthentication, actualAuthentication);
		System.out.println("PASSED TEST!");

		// Enter new email
		Random random = new Random();
		int randomEmail = random.nextInt() + 100;
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("cooljetdi" + randomEmail + "@gmail.com");

		// Create a new account
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

		// Gender 
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();

		// First Name
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Henry");

		// Last Name
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Leu");

		// Password
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("mypassword");

		// Day of Birth 
		element = driver.findElement(By.xpath("//select[@id='days']"));
		Select select = new Select(element);
		Thread.sleep(2000);
		select.selectByValue("24");
		Thread.sleep(2000);

		// Month of Birth 
		element = driver.findElement(By.xpath("//select[@id='months']"));
		select = new Select(element);
		Thread.sleep(2000);
		select.selectByValue("12");

		// Year of Birth 
		element = driver.findElement(By.xpath("//select[@id='years']"));
		select = new Select(element);
		Thread.sleep(2000);
		select.selectByValue("1979");

		// Checkbox - Receive special offers from our partners!
		driver.findElement(By.xpath("//input[@id='optin']")).click();

		// First Name
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Irene");

		// Last Name
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Garcia");

		// Company 
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("TechCircle School");

		// Address 
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("101 Disneyland Ave, Tampa, Florida");

		// City
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Flushing");

		// State 
		element = driver.findElement(By.xpath("//select[@id='id_state']"));
		select = new Select(element);
		Thread.sleep(2000);
		select.selectByVisibleText("New York");

		// Zip/Postal Code
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("11354");

		// Country 
		element = driver.findElement(By.xpath("//select[@name='id_country']"));
		select = new Select(element);
		Thread.sleep(2000);
		select.selectByVisibleText("United States");

		// Additional Information
		driver.findElement(By.xpath("//textarea[@id='other']"))
				.sendKeys("Please drop the package at the front porch.");

		// Home Phone
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("9876543210");

		// Mobile Phone
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("1234567890");

		// Assign alias address 
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("Henry's home address");

		// Register button
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

		// Proceed to checkout
		driver.findElement(By.xpath("//div[@id='center_column']//button/span")).click();

		// Terms of Service
		driver.findElement(By.xpath("//input[@id='cgv']")).click();

		// Proceed to checkout
		driver.findElement(By.xpath("//div[@id='center_column']//button/span")).click();

		// Pay by check
		driver.findElement(By.xpath("//div[@id='HOOK_PAYMENT']//descendant::a[2]")).click();

		// Confirm order
		driver.findElement(By.xpath("//p[@id='cart_navigation']/button[@type='submit']")).click();
	}
}
