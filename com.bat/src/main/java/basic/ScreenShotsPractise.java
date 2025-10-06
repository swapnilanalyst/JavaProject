package basic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotsPractise {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		SimpleDateFormat  date = new SimpleDateFormat("yyyymmdd_hhmmss");
		String dateTime= date.format(new Date()); 
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(src, new File(System.getProperty("user.dir")+"/Screenshots/test"+dateTime+".png"));
		
		
		

	}

}
