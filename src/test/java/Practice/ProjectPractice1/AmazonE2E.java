package Practice.ProjectPractice1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonE2E {

	@Test
	public void E2EFlow() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("nav-search-dropdown-card")).click();
		List<WebElement> dropDownList = driver.findElements(By.cssSelector("option[value*=\"search-alias\"]"));
		
		for (int i = 0;i<dropDownList.size();i++) {
			if(dropDownList.get(i).getText().equalsIgnoreCase("Luxury Beauty")){
				dropDownList.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nail Polish");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]//div[@data-component-type=\"s-search-result\"]"));
		
		for (int i = 0;i<searchResults.size();i++) {
			if(searchResults.get(i).getText().contains("Long Lasting")){
				searchResults.get(i).click();
				break;
			}
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		String productName = driver.findElement(By.id("productTitle")).getText();
		
		if (productName.contains("Long Lasting")) {
			driver.findElement(By.id("buy-now-button")).click();
			/*
			 * driver.findElement(By.id("pp-SL73he-203")).click();
			 * driver.findElement(By.xpath("//span[@data-action=\"a-dropdown-button\"]")).
			 * click(); List<WebElement> bankList =
			 * driver.findElements(By.xpath("//li[@tabindex=\"0\"]"));
			 * 
			 * for (int i = 0; i < bankList.size(); i++) { if
			 * (bankList.get(i).getText().equalsIgnoreCase("HDFC Bank")) {
			 * bankList.get(i).click(); } }
			 */
		}
	
		driver.quit();
	}

}
