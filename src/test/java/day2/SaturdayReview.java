package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaturdayReview {
	WebDriver driver;
	WebDriverWait wait;
	int delay = 2000;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Ignore
	@Test
	public void test1() {
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Techcircle School", Keys.ENTER);
		wait = new WebDriverWait(driver, 30);
		WebElement element = driver.findElement(By.id("result-stats"));
		wait.until(ExpectedConditions.visibilityOf(element));

		System.out.println(element.getText());

	}

	@Ignore
	@Test
	public void testRadioButton() throws InterruptedException {
		driver.get("https://jqueryui.com/checkboxradio/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		Thread.sleep(500);
		String city = "London";

		List<WebElement> elements = driver.findElements(By.xpath("//fieldset[1]/label"));
		int size = elements.size();
		System.out.println("Total number of radio buttons: " + size);

		boolean isClicked = false;

		for (int i = 0; i < size; i++) {
			WebElement element = elements.get(i);
			if (element.getText().equalsIgnoreCase(city)) {
				element.click();
				System.out.println("PASSED!");
				System.out.println("radio is " + element.getText());
				isClicked = true;
			}
		}
		if (!isClicked)
			System.out.println("Radio button failed!");

		Thread.sleep(5000);
	}

	@Ignore
	@Test
	public void testHotelRatingCheckBox() throws InterruptedException {
		driver.get("https://jqueryui.com/checkboxradio/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		Thread.sleep(500);
		String star2 = "2 Star";
		String star3 = "3 Star";

		List<WebElement> elements = driver.findElements(By.xpath("//fieldset[2]/label"));
		int size = elements.size();
		System.out.println("Total number of checkboxes: " + size);

		boolean isClicked = false;

		for (int i = 0; i < size; i++) {
			WebElement element = elements.get(i);

			if (element.getText().equalsIgnoreCase(star2)) {
				if (!element.isSelected()) {
					element.click();
					System.out.println("PASSED!");
					System.out.println("Hotel rating is " + element.getText());
					isClicked = true;
				}
			}
			if (element.getText().equalsIgnoreCase(star3)) {
				if (!element.isSelected()) {
					element.click();
					System.out.println("PASSED!");
					System.out.println("Hotel rating is " + element.getText());
					isClicked = true;
				}
			}
		}
		if (!isClicked)
			System.out.println("Hotel rating radio button failed!");

		Thread.sleep(5000);
	}

	
	@Test
	public void testBedCheckBox() throws InterruptedException {
		driver.get("https://jqueryui.com/checkboxradio/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		Thread.sleep(500);
		String bed2Queen = "2 Queen";
		String bed1King = "1 King";

		List<WebElement> elements = driver.findElements(By.xpath("//fieldset[3]/label"));
		int size = elements.size();
		System.out.println("Total number of bed type checkboxes: " + size);

		boolean isClicked = false;

		for (int i = 0; i < size; i++) {
			WebElement element = elements.get(i);

			if (element.getText().equalsIgnoreCase(bed2Queen)) {
				element.click();
				System.out.println("PASSED!");
				System.out.println("Bed type is " + element.getText());
				isClicked = true;
			}
			
			if (element.getText().equalsIgnoreCase(bed1King)) {
				element.click();
				System.out.println("PASSED!");
				System.out.println("Bed type is " + element.getText());
				isClicked = true;
			}
		}
		if (!isClicked)
			System.out.println("Bed type checkbox failed!");

		Thread.sleep(5000);
	}

	@After
	public void afterTest() {
		driver.close();
	}
}
