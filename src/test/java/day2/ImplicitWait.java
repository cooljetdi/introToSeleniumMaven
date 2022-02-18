package day2;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {
	WebDriver driver;
	int delay = 2000;
	WebDriverWait wait;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void fluentWait() {
		Wait wait = new FluentWait(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(Exception.class);
		
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	@Test
	public void explicitWait() {
		// login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");		
		driver.findElement(By.id("btnLogin")).click();
		
		// initiating explicit wait object
		wait = new WebDriverWait(driver, 30);
		
		// waiting for element to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
		
		// after visible is true, then store the element text for verification.
		String actualWelcomeText = driver.findElement(By.id("welcome")).getText();
		String expectedText = "Welcome Paul";
		
		
		if(actualWelcomeText.equalsIgnoreCase(expectedText))
			System.out.println("Passed!");
		else System.out.println("Failed");
		
		
	}
	
	@After
	public void afterTest() {
		driver.close();
	}
}
