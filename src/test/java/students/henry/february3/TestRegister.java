/*
Class: TechCircle Batch #9
Date: February 5, 2022
Student: Ming-Jen Leu (Henry Leu)
Programming language: Java 11
Automated Testing Framework: Selenium 3.141.59
JUnit 4.13.2
Filename: TestRegister.java

Homework:

To automate test on Register web page on http://demo.automationtesting.in/Index.html.
*/

package students.henry.february3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRegister {
	WebDriver driver;
	WebElement element;
	int delay = 2000;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Index.html");
	}

	@Test
	public void testRegister() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		
		// Login page - Enter Email
		driver.findElement(By.id("email")).sendKeys("henryleu@gmail.com");
		//Thread.sleep(delay);
		driver.findElement(By.id("enterimg")).click();
		//Thread.sleep(delay);

		// Choose File - Upload file 
		String filePath = "C:\\Users\\Henry\\Desktop\\javaguy.jpg";	
		driver.findElement(By.id("imagesrc")).sendKeys(filePath);
		//Thread.sleep(delay);

		// First Name
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Henry");
		//Thread.sleep(delay);

		// Last Name
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Leu");
		//Thread.sleep(delay);

		// Address
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea"))
			  .sendKeys("Hello Kitty Ave, New York, NY 11354");
		//Thread.sleep(delay);

		// Email address
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("roadtosuccess@gmail.com");
		//Thread.sleep(delay);

		// Phone
		driver.findElement(By.xpath("(//input[@type='tel'])")).sendKeys("1234567890");
		//Thread.sleep(delay);

		// Gender - Male
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		//Thread.sleep(delay);

		// Hobbies
		driver.findElement(By.id("checkbox1")).click();
		//Thread.sleep(delay);
		driver.findElement(By.id("checkbox2")).click();
		//Thread.sleep(delay);

		// Languages
		String language1 = "Japanese";
		String language2 = "Thai";

		driver.findElement(By.id("msdd")).click();

		List<WebElement> listOfElement = driver
				.findElements(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li"));

		int size = listOfElement.size();

		for (int i = 1; i <= size; i++) {			

			element = driver.findElement(
					By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[" + i + "]"));

			String text = element.getText();

			if (text.equalsIgnoreCase(language1))
				element.click();//select[@id='country']

			if (text.equalsIgnoreCase(language2))
				element.click();
		}
		
		//Thread.sleep(delay);

		// Click on the white page to exit the language drop-down list
		driver.findElement(By.xpath("//*[@id=\"section\"]/div/div")).click();
		//Thread.sleep(delay);

		// Skill
		element = driver.findElement(By.id("Skills"));
		Select select = new Select(element);
		select.selectByVisibleText("Java");
		//Thread.sleep(delay);

		// Select Country - United States of America
		element = driver.findElement(By.xpath("//select[@id='country']"));
		select = new Select(element);
		select.selectByVisibleText("United States of America");
		//Thread.sleep(delay);
		
        //This will scroll the web page till end.		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		// Year
		driver.findElement(By.id("yearbox")).sendKeys("1979");
		//Thread.sleep(delay);

		// Month
		driver.findElement(By.xpath("(//select[@type='text'])[4]")).sendKeys("December");
		//Thread.sleep(delay);

		// Day
		driver.findElement(By.id("daybox")).sendKeys("24");
		//Thread.sleep(delay);

		// Password
		driver.findElement(By.id("firstpassword")).sendKeys("techcircle");
		//Thread.sleep(delay);

		// Confirm Password
		driver.findElement(By.id("secondpassword")).sendKeys("techcircle");
		//Thread.sleep(delay + delay);
	}

	@After
	public void afterTest() {
		driver.close();
		System.out.println("Testing Successfull!");
	}
}
