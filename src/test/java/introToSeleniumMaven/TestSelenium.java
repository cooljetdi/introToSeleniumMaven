package introToSeleniumMaven;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSelenium {
	@Before
	public void beforeTest() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
	}
	
	@Test
	public void test1() {
		
	}
	

}
