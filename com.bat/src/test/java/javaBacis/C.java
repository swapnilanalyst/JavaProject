package javaBacis;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class C {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<String> actualList = new ArrayList<>();
		
		List<String> expectedList =  Arrays.asList("HTML", "CSS", "JavaScript", "About Us","test");
		
		WebElement btn = driver.findElement(By.xpath("//button[@id='menu1']"));
		btn.click();

		List<WebElement> elements = driver.findElements(By.xpath("//a[@role='menuitem']"));

		for (WebElement ele : elements) {

			String text = ele.getText();
			actualList.add(text);

		}

		
		if(actualList.equals(expectedList)) {
			
			System.out.println("Values are same");
			System.out.println("ActualList: " + actualList);
			System.out.println("ExpectedList: " + expectedList);
		}else {
			
			System.out.println("Values are not same");
			System.out.println("ActualList: " + actualList);
			System.out.println("ExpectedList: " + expectedList);

		}

	}

}