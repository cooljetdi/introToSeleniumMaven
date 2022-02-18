package day2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JUnitTesting {

	// Open browser
	@Before
	public void setUp() {
		/*
		 * WebDriver driver; WebDriverManager.chromedriver().setup(); driver = new
		 * ChromeDriver(); driver.get("https://www.techcircleschools.com");
		 */
		
		System.out.println("Openining browser...");
	}
	
	// Closing browser
	@After
	public void tearDown() {
		System.out.println("Closing browser...");
	}
	
	@Test 
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
	}
	
}
