package udemyselenium;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators1 {
	WebDriver driver;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	
	@Test
	public void test() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("henry leu");
		driver.findElement(By.name("inputPassword")).sendKeys("mypassword");
		driver.findElement(By.className("signInBtn")).click();		
		String s = driver.findElement(By.cssSelector("p.error")).getText();	
		System.out.println(s); 
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000); // wait for the next page to load up.
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("new name");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("henryleu@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("cooljetdi@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("3475534898");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000); // wait for the next page to load up.
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		//div[@class='forgot-pwd-btn-conainer']/button[1]
		
		
		
	}
}
