package practise;

import java.util.List;

import org.openqa.selenium.WebElement;

import utils.Helper;

public class userHelperforSelectDropdown {

//	WebDriver driver;
	Helper h = new Helper();

	public static void main(String[] args) {

		userHelperforSelectDropdown ob = new userHelperforSelectDropdown();

//		ob.selectDDTest();
//		ob.bootstrapTest();
		ob.handleWindow();
	}

	public void selectDDTest() {

		h.setup("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

		WebElement btn = h.getElementByXPath("//select[@id='course']");
		btn.click();

		h.selectDropdownByIndex(btn, 2);
		h.closeBrowser();

	}
	
	public void bootstrapTest() {
		
		h.setup("https://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		
		WebElement btn = h.getElementByXPath("//button[@id='menu1']");
		btn.click();
		List <WebElement> list = h.getElementsByXPath("//ul[@class='dropdown-menu']/child::li/a");
		
		h.bootStrapDropDown(list, "JavaScript");
		h.closeBrowser();
	}
	
	public void handleWindow() {
		h.setup("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		WebElement btn = h.getElementByXPath("//button[@id='newWindowBtn']");
		
		h.windowHandle(btn);
		
	}
	

}
