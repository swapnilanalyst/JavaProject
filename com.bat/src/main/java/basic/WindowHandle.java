package basic;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String parentID = driver.getWindowHandle();

		System.out.println(parentID);

		WebElement btn = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
		btn.click();

		Set<String> allWindowsId = driver.getWindowHandles();
		System.out.println(allWindowsId);

		for (String s : allWindowsId) {

			if (!parentID.equals(s)) {

				driver.switchTo().window(s);
				driver.manage().window().maximize();
				WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
				firstName.sendKeys("Test");
				driver.close();
				break;
			}

		}

		driver.switchTo().window(parentID);
		WebElement parentName= driver.findElement(By.xpath("//input[@id='name']")); 
		parentName.sendKeys("Hello");

		WebElement tabBtn = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
		tabBtn.click();

		Set<String> allTabID = driver.getWindowHandles();
		System.out.println("TabIDs: " + allTabID);

		for (String a : allTabID) {
			if (!parentID.equals(a)) {
				driver.switchTo().window(a);
//				WebElement alertBtn = driver.findElement(By.xpath("//button[@id='alertBox']"));
//				alertBtn.click();
				driver.close();
				break;
			}
		}

		// Switch back to parent again
		driver.switchTo().window(parentID);
		parentName.clear();
		parentName.sendKeys(" Back Again!");
		
		WebElement multiWindowBtn= driver.findElement(By.xpath("//button[@id='newWindowsBtn']"));
		multiWindowBtn.click();
		
		Set <String>multiWindowIds = driver.getWindowHandles();
		System.out.println("Ids are: " + multiWindowIds);
	}
	
	
}
