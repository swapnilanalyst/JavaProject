package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Helper;

public class FrameClass {
	
  
	public static void main(String[] args) {
		
		WebDriver driver;
		Helper h = new Helper();
		h.setup("https://www.hyrtutorials.com/p/frames-practice.html");
		
		h.frameSwitch("frm1");
		
		WebElement dd= h.getElementByXPath("//select[@id='selectnav1']");
		
		h.selectDropdownByVisibleText(dd, "Tech News");
		
		h.switchToMainScreen();
		
		WebElement name= h.getElementByXPath("//input[@id='name']");
		name.sendKeys("Hello");
		
		h.closeBrowser();

	}

}
