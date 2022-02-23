package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyReaderSaturday219;

public class SaturdayReview219 {
	WebDriver driver;
	WebElement element;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(PropertyReaderSaturday219.getProperties("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		// First Name
		driver.findElement(By.xpath(PropertyReaderSaturday219.getProperties("firstname"))).sendKeys("Henry");

		// Last Name
		driver.findElement(By.xpath(PropertyReaderSaturday219.getProperties("lastname"))).sendKeys("Leu");
		
		// Phone
		driver.findElement(By.xpath(PropertyReaderSaturday219.getProperties("phone"))).sendKeys("987654321");

		// Email
		driver.findElement(By.id(PropertyReaderSaturday219.getProperties("email"))).sendKeys("disneyland@gmail.com");
		
		// Address
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("1234 Continental Ave");
		
		// City
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Flushing");
		
		// State
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("New York");
		
		// Postal code
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("11354");
		
		//Country solution #1
		driver.findElement(By.xpath("//select[@name='country']"));
		element = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(element);
		//Thread.sleep(2000);
		select.selectByValue("TAIWAN");
		
		
		/*
		// Country Solution #2
		List<WebElement> countries = driver.findElements(By.xpath("//select[@name='country']/option"));
		int size = countries.size();
		for(int i=0; i<size; i++) {
			element = driver.findElement(By.xpath("//select[@name='country']/option[" + (i+1) + "]"));

			if(element.getText().contains("TAIWAN")) 
				element.click();
		}*/	
		
		// User Name
		driver.findElement(By.id("email")).sendKeys("cooljetdi");
		
		// Password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mypassword");

		// Confirm password
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("mypassword");
		
		// Submit
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
}

