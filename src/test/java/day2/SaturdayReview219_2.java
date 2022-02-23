package day2;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyReaderSaturday219;

public class SaturdayReview219_2 {
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(PropertyReaderSaturday219.getProperties("urlalert"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void alert() throws InterruptedException {
		
		System.out.println("Begin testing alert...");
		
		// Click Button to see alert
		driver.findElement(By.id("alertButton")).click();	
		// initiating explicit wait until alert window is present.
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println("Click Button to see alert");
		
		// On button click, alert will appear after 5 seconds
		driver.findElement(By.id("timerAlertButton")).click();
		wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println("On button click, alert will appear after 5 seconds");
		
		// On button click, confirm box will appear - click Ok button
		driver.findElement(By.id("confirmButton")).click();
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println("On button click, confirm box will appear - click Ok button");
		
		// On button click, confirm box will appear - click Cancel button
		driver.findElement(By.id("confirmButton")).click();
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		System.out.println("On button click, confirm box will appear - click Cancel button");
		
		// On button click, prompt box will appear. Enter name and click OK button.
		driver.findElement(By.id("promtButton")).click();
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys("Henry Leu");
		driver.switchTo().alert().accept();
		System.out.println("Click, prompt box will appear. Enter name and click OK button.");
		
		// On button click, prompt box will appear. Enter name and click Cancel button.
		driver.findElement(By.id("promtButton")).click();
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys("Henry Leu");
		driver.switchTo().alert().dismiss();
		System.out.println("Click, prompt box will appear. Enter name and click Cancel button.");
		
	}
}
