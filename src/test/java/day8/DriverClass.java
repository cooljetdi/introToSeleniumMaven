package day8;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertiesReader;

public class DriverClass {
	WebDriver driver;
	String url = PropertiesReader.getProperties("urlHeroku");

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://www.makemytrip.com/");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		
	}
}
