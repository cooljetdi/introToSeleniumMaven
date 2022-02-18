package day2;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTesting {
	WebDriver driver;
	int delay = 2000;
	WebDriverWait wait;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Ignore
	@Test
	public void alertTest1() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='content']/div/ul/li[1]/button")).click();
		// Thread.sleep(4000);
		String s = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		// Thread.sleep(4000);
		System.out.println(s);

	}

	@Ignore
	@Test
	public void alertTest2() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		// Thread.sleep(4000);
		String s = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		// Thread.sleep(4000);
		System.out.println(s);
	}

	@Ignore
	@Test
	public void alertTest3() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		// Thread.sleep(4000);
		String s = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		// Thread.sleep(4000);
		System.out.println(s);
	}

	@Test
	public void alertTest4() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
		String thirdAlertText = driver.switchTo().alert().getText();
		System.out.println(thirdAlertText);

		String enteredText = "Batch9";

		driver.switchTo().alert().sendKeys(enteredText);
		driver.switchTo().alert().accept();

		String actualTextRetrieved = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();

		if (actualTextRetrieved.contains(enteredText)) {
			System.out.println("Prompt Took the text successfully and displayed it on the page");
		}
		
	}

	@After
	public void afterTest() {
		driver.close();
	}
}
