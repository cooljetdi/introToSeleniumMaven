package day2;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenVerifyTitle {
	WebDriver driver;

	@Before
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.youtube.com");
		driver.manage().window().maximize();
	}
	
	@After
	public void afterTest() {
		driver.close();
	}
	
	@Ignore
	@Test
	public void verifyTitle() {

		String actualPageTitle = driver.getTitle();

		String expectedPagetitle = "YouTube";

		if (expectedPagetitle.equalsIgnoreCase(actualPageTitle)) {
			System.out.println("Pass! Title matched.");
		} else {
			System.out.println("Title failed to match.");
			System.out.println("Expected to see ---> " + expectedPagetitle);
			System.out.println("The driver got ---> " + actualPageTitle);
		}
	}

	@Ignore
	@Test
	public void verifyUrl() {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.youtube.com/";

		if (expectedUrl.equalsIgnoreCase(actualUrl)) {
			System.out.println("Pass! Url matched.");
		} else {
			System.out.println("Url failed to match.");
			System.out.println("Expected to see ---> " + expectedUrl);
			System.out.println("The driver got ---> " + actualUrl);
		}
	}
	
	
	@Test
	public void pageSourcePrint() {
		String pageSource = driver.getPageSource();
		
		System.out.println(pageSource);
		
		driver.navigate().to("https://www.techcircleschool.com");
		driver.navigate().back();
	}
}
