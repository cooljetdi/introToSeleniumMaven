/*
go to amazon.com
type in search "iphone"
click on the first iphone the price over $1400, if the first page not found, click go to the next page until it found
print the name of the product
then verify the price that actually over $1400 
 
 */

package day2;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElements {
	WebDriver driver;
	int delay = 2000;

	@Before
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test
	public void testAmazon() throws InterruptedException {
		driver.get("https://www.amazon.com/");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
		Thread.sleep(1000);

		// String x =
		// driver.findElement(By.xpath("(//span[@class='a-price'])[2]")).getText();
		String x = driver.findElement(By.xpath("(//span[@class='a-price'])|(//span[@data-a-color='base'])")).getText();
		Thread.sleep(200);
		System.out.println("Single item price is " + x.replace("\n", ".") + ".");

		// List<WebElement> elements =
		// driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div"));
		// List<WebElement> elements =
		// driver.findElements(By.xpath("(//span[@class='a-price-whole'])"));
		// List<WebElement> elements =
		// driver.findElements(By.xpath("(//span[@class='a-price'])"));
		//List<WebElement> elements = driver.findElements(By.xpath("(//span[@class='a-price'])|(//span[@data-a-color='base'])"));

		By productPrices = By.xpath("//div[@class='a-section']//span[@class='a-price-whole']");
		List<WebElement> elements = driver.findElements(productPrices);
		int size = elements.size();
		System.out.println(size + " item price(s) found.");

		Thread.sleep(1000);
		WebElement e;

		Thread.sleep(5000);

		for (int i = 1; i <= size; i++) {
			Thread.sleep(100);
			//e = driver.findElement(By.xpath("(//span[@class='a-price'])[" + i + "]"));
			e = driver.findElement(By.xpath("(//span[@class='a-price'])|(//span[@data-a-color='base'])["+i+"]"));
	
				String price = e.getText().replace("\n", ".");
				price = price.replaceAll("[$,]", "");
				System.out.println(price);
				// double d = Double.valueOf(price);
				// System.out.println("$" + d);
			
		}
		Thread.sleep(1000);

		/*
		 * // Get # of elements (slider) List<WebElement> elements =
		 * driver.findElements( By.xpath(
		 * "//div[@class='row_inner']/div[1]/div/div[@id='text-22-0-0-1']/div/div/div[@id='n2-ss-6']/div[1]/div/div/div"
		 * ));
		 */
		// Get # of elements (slider) - another way
		/*
		 * 
		 * List<WebElement> elements =
		 * driver.findElements(By.xpath("//div[@id='n2-ss-6']/div"));
		 * 
		 * int size = elements.size();
		 * 
		 * String slider = "";
		 * 
		 * Thread.sleep(4000);
		 * 
		 * // Retrieve slider name for(int i = 1; i <= size; i++) slider += "Slider " +
		 * i + " : " + driver.findElement( By.xpath(
		 * "//div[@class='row_inner']/div[1]/div/div[@id='text-22-0-0-1']/div/div/div[@id='n2-ss-6']/div[1]/div/div/div["
		 * +i+"]/div/img")).getAttribute("alt") + "\n";
		 * 
		 * 
		 * System.out.println(slider);
		 * 
		 * System.out.println(size ==3 ? "Pass! There are 3 sliders.":
		 * "Failed! No 3 sliders.");
		 * 
		 * Thread.sleep(4000);
		 */
	}

	/*
	@Ignore
	@After
	public void afterTest() {
		driver.close();
	}*/
}
