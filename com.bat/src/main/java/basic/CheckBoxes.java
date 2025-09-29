package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {
	

	public static void main(String[] args) {
	
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				List<WebElement> checkBoxes =driver.findElements(By.xpath("//input[@type='checkbox']"));
				
				for(WebElement ele : checkBoxes) {
					
					System.out.println(ele);
					
					String id= ele.getAttribute("id");
					
					if(id.equals("englishchbx") || id.equals("chinesechbx") || id.equals("frenchchbx")) {
						
						ele.click();
						
						
					}
				}
				
//				/ele.isDisplayed();
//				ele.isSelected();
//				ele.isEnabled();
		

	}

}
