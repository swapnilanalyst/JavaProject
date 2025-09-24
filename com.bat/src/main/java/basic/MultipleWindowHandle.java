package basic;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String parentID = driver.getWindowHandle();
		System.out.println(parentID);
		
		WebElement btn= driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
		btn.click();
		
		Set <String> allTabId= driver.getWindowHandles();
		System.out.println("Tab ID: " + allTabId);
		
		for(String s: allTabId) {
			
			if (!s.equals(parentID)) {  // skip parent
		        driver.switchTo().window(s);
		        String title = driver.getTitle();
		        System.out.println("Switched to: " + title);
			
			if(title.contains("Basic Con")) {

				WebElement ele= driver.findElement(By.xpath("//input[@id='firstName']"));
				ele.sendKeys("Hello WOrld");
				driver.close();
			
			}else if(title.contains("Alerts")) {
				driver.switchTo().window(s);
				WebElement ele2= driver.findElement(By.xpath("//button[@id='alertBox']"));
				ele2.click();
				 driver.switchTo().alert().accept();
				 System.out.println("Alert accepted!");
				driver.close();
			}
			}
		}
		
		driver.switchTo().window(parentID);
		driver.findElement(By.id("name")).sendKeys("Back agian!");
		driver.close();
	}

}
