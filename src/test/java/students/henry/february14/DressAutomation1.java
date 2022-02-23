package students.henry.february14;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import day2.FindElements;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DressAutomation1 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	@Test
	public void test() throws InterruptedException {
		
		By dressesBtn = By.xpath("//div[@id='block_top_menu']/ul/child::li[2]");
		
		//Click Dresses button
		driver.findElement(dressesBtn).click();
		
		// Add product to cart
		String productForSale = "//ul[contains(@class, 'product')]/li";
		List<WebElement> elements = driver.findElements(By.xpath(productForSale));
		int productQty = elements.size();
		int qtyToBuy = 1;
		int randomItem = 0;
		
		if(productQty == 0) {
			wait = new WebDriverWait(driver, 3);	
			System.out.println("FAILED! No product available for sale!");
			driver.close();
		}
		
		String available = "";
		WebElement element;
		// Check product availability and add to cart./
		for(int i = 0; i < qtyToBuy; i++) {	
			int j =3;  // random product selected to add
			element = driver.findElement(By.xpath("//ul[contains(@class, 'product')]/li["+j+"]/descendant::img"));
			//element = driver.findElement(By.xpath("//ul[contains(@class, 'product')]/li[" + j + "]/descendant::a[contains(@class, 'product')][1]"));
			//element = driver.findElement(By.xpath("//ul[contains(@class, 'product')]/li["+ j + "]/descendant::div[contains(@class, 'image')]"));
			Thread.sleep(2000);
			//driver.switchTo().frame(0);
			element.click();
			element = driver.findElement(By.xpath("//ul[contains(@class, 'product')]/li[" + j + "]/div/div[2]/div[2]/a[2]"));
			Thread.sleep(2000);
			element.click();
			System.out.println(element.getText());
			System.out.println("item clicked...");	
			//element = driver.findElement(By.xpath("//body[@id='product']//descendant::form/div/div[3]//descendant::button")); // add quantity
			  
			
		}
		

		
	}
	
}
