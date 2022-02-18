package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.digest.HmacUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicDropDown {
	WebDriver driver;
	int delay = 2000;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void selectDynamicDropDown() throws InterruptedException {
		WebDriverWait wait;

		String actualCity = "", expectedCity = "tpe";

		driver.findElement(By.xpath("//html")).click();

		// Click FROM drop down list
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div/div[1]/label/input")).click();

		// Enter city name
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"))
				.sendKeys(expectedCity);

		// initiating explicit wait object
		wait = new WebDriverWait(driver, 10);

		// waiting for element to be visible. In this case, the FROM field
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")));

		// Number of city found
		List<WebElement> listOfElements = driver.findElements(By.xpath(
				"//div[@id='root']/div/div[@class='minContainer']/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div/div[1]/ul"));

		// initiating explicit wait object
		wait = new WebDriverWait(driver, 10);

		// waiting for element to be visible. In this case, the FROM field
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")));

		// Thread.sleep(1000);
		int size = listOfElements.size();

		String s = driver.findElement(By.xpath(
				"//div[@id='root']/div/div[@class='minContainer']/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div/div[1]/ul/li[1]/div/div[2]"))
				.getText();
		System.out.println(s);

		System.out.println("Number of cities found: " + size);

		String airport = "";
		// Print city and airport
		for (int i = 1; i <= size; i++) {
			// get actual city
			actualCity = driver.findElement(By.xpath(
					"//div[@id='root']/div/div[@class='minContainer']/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div/div[1]/ul/li["
							+ i + "]/div/div[2]"))
					.getText();

			// get airport
			airport = driver.findElement(By.xpath(
					"//div[@id='root']/div/div[@class='minContainer']/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div/div[1]/ul/li["
							+ i + "]/div/div[1]/p[2]"))
					.getText();

			System.out.println("City: " + actualCity);
			System.out.println("Airport: " + airport);
			System.out.println();

			if (expectedCity.equalsIgnoreCase(actualCity)) {
				driver.findElement(By.xpath(
						"//div[@id='root']/div/div[@class='minContainer']/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div/div[1]/ul/li["
								+ i + "]/div/div[2]")).click();
				System.out.println("Pass! City found: " + expectedCity);
			} else
				System.out.println("Failed! City " + expectedCity + " not found.");
		}
		Thread.sleep(4000);
	}

	@Ignore
	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("root")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div/div[1]/label/input")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"))
				.sendKeys("TPE");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]")).click();
		Thread.sleep(6000);

	}

	@After
	public void afterTest() {
		driver.close();
	}
}
