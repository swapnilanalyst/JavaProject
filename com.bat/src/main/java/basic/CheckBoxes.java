package basic;

import java.util.List;

import org.openqa.selenium.WebElement;

import utils.Helper;

public class CheckBoxes {

	Helper h = new Helper();

	public static void main(String[] args) {

		CheckBoxes cb = new CheckBoxes();
		cb.checkbox();

	}

	public void checkbox() {

		h.setup("https://www.hyrtutorials.com/p/basic-controls.html");

		List<WebElement> checkBoxesList = h.getElementsByXPath("//input[@type='checkbox']");

		for (WebElement ele : checkBoxesList) {

			System.out.println(ele);

//					String id= ele.getAttribute("id");
//					
//					if(id.equals("englishchbx") || id.equals("chinesechbx") || id.equals("frenchchbx")) {
//						
//						ele.click();

			if (!ele.isSelected()) {
				ele.click();
				

			}
		}

//				/ele.isDisplayed();
//				ele.isSelected();
//				ele.isEnabled();
	}

}