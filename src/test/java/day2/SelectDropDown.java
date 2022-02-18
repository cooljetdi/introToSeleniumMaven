package day2;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDown {
	WebDriver driver;
	int delay = 2000;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void selectStaticDropDown() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dropdown");
		WebElement element = driver.findElement(By.id("dropdown"));
		Select select = new Select(element);
		Thread.sleep(3000);
		select.selectByIndex(1);  // select option 1
		Thread.sleep(3000);
		select.selectByValue("2");    // select option 2
		Thread.sleep(3000);
		select.selectByVisibleText("Option 1");  // select option 1
		
	}
	
	@After
	public void afterTest() {
		driver.close();
	}
}

