package day2;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathPractice {
	WebDriver driver;
	int delay = 2000;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test
	public void test3Slider() throws InterruptedException {
		driver.get("http://practice.automationtesting.in/");
		
		/*
		// Get # of elements (slider)
		List<WebElement> elements = driver.findElements(
				By.xpath(
						"//div[@class='row_inner']/div[1]/div/div[@id='text-22-0-0-1']/div/div/div[@id='n2-ss-6']/div[1]/div/div/div"));
*/
		// Get # of elements (slider) - another way
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='n2-ss-6']/div"));
		
		int size = elements.size();
		
		String slider = "";

		Thread.sleep(4000);
	
		// Retrieve slider name
		for(int i = 1; i <= size; i++) 
			slider += "Slider " + i + " : " +  
					driver.findElement(
					By.xpath("//div[@class='row_inner']/div[1]/div/div[@id='text-22-0-0-1']/div/div/div[@id='n2-ss-6']/div[1]/div/div/div["+i+"]/div/img")).getAttribute("alt") + "\n";
		    
		
		System.out.println(slider);
		
		System.out.println(size ==3 ? "Pass! There are 3 sliders.": "Failed! No 3 sliders.");
		
		Thread.sleep(4000);
	}

	@Ignore
	@Test
	public void testCheckBox() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com");
		Thread.sleep(4000);

		driver.findElement(By.xpath("//ul/li[6]/a[@href='/checkboxes']")).click();
		// driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();

		WebElement firstCheckboxElement = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
		WebElement secondCheckboxElement = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

		Boolean firstCheckbox = firstCheckboxElement.isSelected(); // false

		Boolean secondCheckbox = secondCheckboxElement.isSelected();

		if (firstCheckbox) {
			System.out.println("First Checkbox is alread selected");
		} else {
			firstCheckboxElement.click();
		}

		if (secondCheckbox) {
			System.out.println("Second Checkbox is alread selected");
		} else {
			secondCheckboxElement.click();
		}

		Thread.sleep(4000);

	}

	@After
	public void afterTest() {
		driver.close();
	}
}
