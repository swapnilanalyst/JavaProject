package officeWork;

import org.openqa.selenium.WebElement;

import utils.Helper;

public class MultiWindowHandle {

	public static void main(String[] args) {
		
		
		Helper h = new Helper();
		
		h.setup("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		WebElement ele = h.explicitWait(h.getElementByXPath("//button[@id='newTabsBtn']"), 10);
		
       h.switchToWindowByTitle(ele, "Basic Controls");
       
       WebElement fname = h.explicitWait(h.getElementByXPath("//input[@id='firstName']"), 10);
       h.clearAndSendKeys(fname, "Hello World");

	}

}
