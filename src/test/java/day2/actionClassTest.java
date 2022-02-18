package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionClassTest {
	private WebDriver driver;
	private WebDriverWait wait;

	@Before
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}
	
	@Ignore
	@Test
	public void test() throws InterruptedException {
		driver.get("http://amazon.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		String xpath = "//*[@id=\"nav-link-accountList\"]";
		Actions action = new Actions(driver); 
		WebElement actionListButton = driver.findElement(By.xpath(xpath));
		action.moveToElement(actionListButton).build().perform();
		Thread.sleep(1000);
	}
	
	// incomplete
	@Ignore
	@Test
	public void test2() {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		By dressesBtn = By.xpath("//ul[contains(@class, 'product')]/li[1]/div//descendant::img");

		// Click Dresses button
		driver.findElement(dressesBtn).click();
		
		WebElement element = driver.findElement(By.xpath("//ul[contains(@class, 'product')]/li[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		//driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")).click();
		
	}
	
	// drag and drop - incomplete
	@Ignore
	@Test
	public void test3() throws InterruptedException {

		Actions action = new Actions(driver);
		Thread.sleep(3000);
		WebElement box1 = driver.findElement(By.id("columb-a"));
		WebElement box2 = driver.findElement(By.id("columb-b"));
		Thread.sleep(3000);
		action.dragAndDrop(box1, box2).build().perform();	
	}
	
	@Test
	public void mouseHover() throws InterruptedException {
		
		driver.get("http://automationpractice.com/index.php");
		//driver.manage().window().maximize();
		By dressesBtn = By.xpath("//div[@id='block_top_menu']/ul/child::li[2]");

		// Click Dresses button
		driver.findElement(dressesBtn).click();
		Thread.sleep(1000);
    	
		By productsForSalePath = By.xpath("//ul[contains(@class, 'product')]/li");
		List<WebElement> allProducts = driver.findElements(productsForSalePath);
		
		Actions action = new Actions(driver);
		WebElement actionAddToCart = driver.findElement(By.xpath("//ul[contains(@class, 'product')]/li[3]//descendant::img"));
		action.moveToElement(actionAddToCart).build().perform();
		
		// Click Add to cart button
		driver.findElement(By.xpath("//ul[contains(@class, 'product')]/li[3]//span[text()='Add to cart']")).click();

		Thread.sleep(3000);
		
		// Continue shopping
		driver.findElement(By.xpath("//div[@id='layer_cart']//span[contains(@title, 'shopping')]")).click();
		
		
		System.out.println("PRINTING");
	}

}
