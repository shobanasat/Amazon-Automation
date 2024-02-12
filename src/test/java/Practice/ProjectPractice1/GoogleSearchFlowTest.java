package Practice.ProjectPractice1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchFlowTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		//Thread.sleep(5000);
		//driver.findElement(By.className("M6CB1c rr4y5c")).click();
		driver.findElement(By.id("APjFqb")).sendKeys("AI");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		driver.findElement(By.name("btnK")).click();
		
		Thread.sleep(2000);
		List<WebElement> searchItems = driver.findElements(By.cssSelector("h3[class=\"LC20lb MBeuO DKV0Md\"]"));
		int searchItemSize = driver.findElements(By.cssSelector("h3[class=\"LC20lb MBeuO DKV0Md\"]")).size();
		int count = 0;
		
		for(int i = 0;i<searchItemSize;i++) {
			
			if (searchItems.get(i).getText().contains("Artificial Intelligence") || searchItems.get(i).getText().contains("Artificial intelligence") || searchItems.get(i).getText().contains("AI")){
				count = count + 1;
			}	
		}
		
		System.out.println(searchItemSize);
		System.out.println(count);
		assertTrue(count > 5);
		
		driver.quit();
		
		
		

	}

}
