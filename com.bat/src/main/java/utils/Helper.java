package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

		String parentID = driver.getWindowHandle();
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

	public void frameSwitch(String id) {

		driver.switchTo().frame(id);
	}

	public void switchToMainScreen() {
		driver.switchTo().defaultContent();
	}
	
	public String gettTitle() {
		try {
			return driver.getTitle();
			
			
		}catch(Exception e) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			return (String) js.executeScript("return document.title;");
			
		}
		
	}
	
	public String getPageInnerTextByJS() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String text = (String) js.executeScript("return document.documentElement.innerText;");
		System.out.println("Page InnerText: " + text);
		return text;
	}
	
	public String getElementInnerTextByJS(WebElement ele) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String text =(String) js.executeScript("return arguments[0].innerText;", ele);
		System.out.println("Element Inner Text: " + text);
		return text;
	}
	
	public void clickOnElement(WebElement ele) {
		try {
			
			ele.click();
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
		}
		
	}
	public void clearAndSendKeys(WebElement ele, String value) {
		try {
			
			ele.clear();
			ele.sendKeys(value);
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].value= arguments[1]);", ele, value);
				
	}
	}
	
	public void scrollIntoViewByJS(WebElement ele) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollInTOView(true);", ele);
		
	}
	
	public void highlightElementByJS(WebElement ele, String style) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribut('style',arguments[1]);", ele, style);
	}
	
	public WebElement explicitWait(WebElement ele, long seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public Alert waitForAlertPresnt(long seconds) {
			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	public Boolean  waitForAlertPresnt(WebElement ele, String attribute, String value, long seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return  wait.until(ExpectedConditions.attributeContains(ele, attribute, value));
	}
	public WebElement  elementToBeClickable(WebElement ele, long seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return  wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void takeScreenShot(String ssName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(System.getProperty("user.dir")+"/Screenshots/test"+ssName+".png"));
		
	}
	
	public void switchToWindowByTitle(WebElement ele, String expectedTitle) {
		
		String parentID = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentID);
		ele.click();
		
		Set<String> allWindowIds= driver.getWindowHandles();
		System.out.println("Tab ID: " + allWindowIds);
		for(String id : allWindowIds) {
			System.out.println("Ids" +id);
			if (!id.equals(parentID)) {  
			driver.switchTo().window(id);
			
			String title= gettTitle();
			
			if(title.contains(expectedTitle)) {
				System.out.println("Switched to window: " + expectedTitle);
	            return; 
				
			}
			
			}
		}
	}
	
}
