package day2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertPractice {
	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Ignore
	@Test
	public void assertFalseTest() {
		// checkbox 1
		WebElement element = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		Assert.assertFalse(element.isSelected());  // To test if the check box is not selected. This would pass.
		System.out.println("Hello1");
		
		// checkbox 2
		element = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
		Assert.assertFalse(element.isSelected());  // To test if the check box is not selected. This would fail.
		System.out.println("Hello2");
		
	}
	
	@Ignore
	@Test
	public void assertTrueTest() {
		// Check if "Checkboxes" words displayed.
		WebElement element = driver.findElement(By.id("checkboxes"));
		Assert.assertTrue(element.isDisplayed());
		System.err.println("This should pass.");
		
	}
	
	@Test
	public void assertEqualsTest() {
		// 
		WebElement element = driver.findElement(By.xpath("//div[@id='content']//h3"));
		String actual = element.getText();
		String expected = "Checkboxes";
		Assert.assertEquals(actual, expected);
		System.out.println("Pass");
	}

}
