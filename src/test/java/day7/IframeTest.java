package day7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeTest {
	private WebDriver driver;

	@Before
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void iFrameDragDropTest() throws InterruptedException {
		Actions action = new Actions(driver);
		
		driver.switchTo().frame(0);
		WebElement draggable1 = driver.findElement(By.id("draggable"));
		WebElement droppable2 = driver.findElement(By.id("droppable"));
        Thread.sleep(3000);  // Need to wait before drag and drop!!!

		action.dragAndDrop(draggable1, droppable2).build().perform();
		
        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[3]/a")).click();
		/*
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
		
		System.out.println(iframes.size());
		driver.findElement(By.xpath("//iframe")).getSize();
		
		driver.switchTo().frame(0);
		*/
	}
}
