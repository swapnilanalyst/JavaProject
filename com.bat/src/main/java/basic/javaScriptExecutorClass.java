package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutorClass {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
	
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor  js = (JavascriptExecutor) driver;
		
		WebElement userName = driver.findElement(By.xpath("//input[@name='user-name']"));
//		userName.clear();
		
		js.executeScript("arguments[0].value='test@gmail.com';", userName);;
		
		
		WebElement password  = driver.findElement(By.xpath("//input[@name='password']"));
//		password.clear();
		
		js.executeScript("arguments[0].value='Redv@g123';", password);;
		
		Thread.sleep(2000);
		
		WebElement signInBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		
		js.executeScript("arguments[0].click();", signInBtn);
//		signInBtn.click();
		
		
	}

}
