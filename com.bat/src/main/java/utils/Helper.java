package utils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper {

	WebDriver driver;

	public void setup(String url) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public WebElement getElementByXPath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public List<WebElement> getElementsByXPath(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	public void selectDropdownByValue(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByValue(value);
	}

	public void selectDropdownByVisibleText(WebElement ele, String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}

	public void selectDropdownByIndex(WebElement ele, int index) {
		Select s = new Select(ele);
		s.selectByIndex(index);
	}

	public void bootStrapDropDown(List<WebElement> dropdwonlist, String text) {

//			List<WebElement>options= driver.findElements(By.xpath("//ul[@class='dropdown-menu']/child::li/a"));
		System.out.println("BootStrap Dropdown List Size:" + dropdwonlist.size() + "  List Name:- ");

		for (WebElement ele : dropdwonlist) {

			String name = ele.getText();
			System.out.println(name);
			if (name.equals(text)) {
				ele.click();
				break;
			}
		}

	}

	public void windowHandle(WebElement ele) {
		
		String parentID =driver.getWindowHandle();
		System.out.println("Parent Window: " + parentID);
		ele.click();
		
		Set<String> allWindowIDs = driver.getWindowHandles();
		

		for (String a : allWindowIDs) {
			System.out.println("TabIDs: " + a);
			if (!parentID.equals(a)) {
				driver.switchTo().window(a);
				

			}
		}
	}

	public void closeBrowser() {
		if (driver != null) {
			try {
				Thread.sleep(2000); // Adding a short delay
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.quit(); // Properly close the session
		}
	}

}
