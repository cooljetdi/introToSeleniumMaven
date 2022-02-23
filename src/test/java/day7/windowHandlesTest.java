package day7;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandlesTest {
	private WebDriver driver;
	
	@Before
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get("https://phptravels.com/demo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test1() {
		String email = "agent@phptravels.com";
		String password = "demoagent";
		
		// open front page
		driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/a/small")).click();	
		
		System.out.println("Before switching - title is " + driver.getTitle());
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> id = ids.iterator();
		
		String parentID = id.next();
		String childID = id.next();
		
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		
		
		// switch my selenium to new window
		driver.switchTo().window(childID);
		System.out.println("After switching, child window title is " + driver.getTitle());
		
		// Enter email
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys(email);
		
		// Enter password
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input")).sendKeys(password);

		// Login
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button/span[1]")).click();
		
		driver.switchTo().window(parentID);
		System.out.println("After switching back to parent, window title is " + driver.getTitle());
		
	}
}
