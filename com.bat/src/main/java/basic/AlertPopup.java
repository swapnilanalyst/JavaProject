package basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopup {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.manage().window().maximize();
		
		WebElement ele= driver.findElement(By.xpath("//button[@id='alertBox']"));
		ele.click();
		Alert a= driver.switchTo().alert();
		a.accept();
		
		WebElement ele2= driver.findElement(By.id("confirmBox"));
		ele2.click();
		a.accept();
		ele2.click();
		a.dismiss();
		
		WebElement ele3 = driver.findElement(By.id("promptBox"));
		ele3.click();
		a.sendKeys("Hello");
		a.accept();
		
		ele3.click();
		a.sendKeys("World");
		a.dismiss();
	
	
	
	}

}
