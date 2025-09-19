package scrapData;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.OCRUtil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
//import org.apache.commons.io.FileUtils;

public class KFintechLogin {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mfs.kfintech.com/mfs/distributor/distributor_Loginold.aspx");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement username = wait.until(
        	    ExpectedConditions.visibilityOfElementLocated(By.id("txtUserId"))
        	);
        	username.sendKeys("1024191");


        WebElement passWord = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        passWord.sendKeys("Karvy123");

//        WebElement captchaCanvas = driver.findElement(By.xpath("//div[@class='MuiBox-root css-k008qs']/canvas"));
//        File screenshot = captchaCanvas.getScreenshotAs(OutputType.FILE);
//        File captchaImage = new File("captcha.png");
//        FileUtils.copyFile(screenshot, captchaImage);
//
//        // OCR Read
//        String captchaText = OCRUtil.readCaptcha(captchaImage);
//        System.out.println("Captcha Detected: " + captchaText);
//
//        WebElement enterCaptcha= driver.findElement(By.xpath("//input[@id='captcha']"));
//        		enterCaptcha.sendKeys(captchaText);
        		
//        / Wait for the CAPTCHA label to be visible
        WebElement captchaLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='mainCaptcha']")));

        // Get the text of the CAPTCHA (e.g., "dB727")
        String captchaText = captchaLabel.getText();
        System.out.println("Captcha Detected: " + captchaText);

        // Find the CAPTCHA input box and enter the text
        WebElement captchaInput = driver.findElement(By.xpath("//input[@name='txtcapthca$txtcptcha']"));
        captchaInput.sendKeys(captchaText);
        
        		driver.wait(5000);
        		
       WebElement signIn= driver.findElement(By.xpath("//input[@type='submit']"));
        signIn.click();
        
        driver.wait(3000);

        // Wait for dashboard or error
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("dashboard"),
            ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Captcha')]"))
        ));
        
        
        driver.quit();

//        Assert.assertTrue(driver.getPageSource().contains("Dashboard") 
//                || !driver.findElements(By.xpath("//div[contains(text(),'Captcha')]")).isEmpty());

        
        
    }
}
