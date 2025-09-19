package newLook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewLook_Login_Elemments {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver (Selenium 4.35)
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Base URL
        String baseURL = "https://www.newlook.com/uk/login";
        driver.get(baseURL);
        Thread.sleep(4000);

        System.out.println("===== Checking Elements on New Look Login Page =====");

        // -------- Header Section --------
        checkElement(driver, "(//a[@title='New Look home'])[1]", "Logo");
        checkElement(driver, "(//a[@data-uid='uk-womens'])[1]", "Women");
        checkElement(driver, "(//a[@data-uid='cmsitem_00543062'])[1]", "Girls");
        checkElement(driver, "(//a[@data-uid='uk-mens'])[1]", "Mens");
        checkElement(driver, "(//a[@data-uid='uk-trends'])[1]", "Gift Cards");
        checkElement(driver, "(//a[@data-uid='uk-Sale'])[1]", "Sale");
        checkElement(driver, "//input[@id='searchQuery']", "Search Field", "Jeans");
        checkElement(driver, "(//button[@class='auto-complete__button d-flex'])[1]", "Search Button");
        checkElement(driver, "//a[@title='Login']", "Profile Icon");
        checkElement(driver, "//a[@title='Find in store']", "Find in Store");
        checkElement(driver, "//a[@title='Saved items']", "Saved Items");
        checkElement(driver, "//a[@title='bag has 0 items']", "Bag");

        // -------- Hero Section --------
        checkElement(driver, "//button[normalize-space()=\"I've got an account\"]", "I've got an account");
        checkElement(driver, "//button[normalize-space()='CREATE AN ACCOUNT']", "Create an Account");

        // -------- I've Got an Account Section --------
        checkElement(driver, "//input[@id='j_username']", "Login Email", "test@example.com");
        checkElement(driver, "//input[@id='j_password']", "Login Password", "Password123");
        checkElement(driver, "//span[@class='input__inline-control checkout__form-span']", "Show Password");
        checkElement(driver, "//button[@class='checkout__form-button button button--primary button-green']", "Sign In Button");
        checkElement(driver, "//a[@class='js-password-forgotten']", "Forgotten Password");

        // -------- Switch to Create an Account --------
        driver.findElement(By.xpath("//button[normalize-space()='CREATE AN ACCOUNT']")).click();
        Thread.sleep(2000);

        checkElement(driver, "//input[@id='email']", "Create Email", "newuser@test.com");
        checkElement(driver, "//input[@id='pwd']", "Create Password", "Pass1234");
        checkElement(driver, "//span[@class='input__inline-control input__inline-control--account']", "Show Password Create");
        checkElement(driver, "//select[@id='titleCode']", "Title Dropdown");
        checkElement(driver, "//input[@id='firstName']", "First Name", "John");
        checkElement(driver, "//input[@id='lastName']", "Last Name", "Doe");
        checkElement(driver, "//input[@id='emailConsent']", "Sign Up Checkbox");
        checkElement(driver, "//button[@class='button button--primary button--full-width button-green button--mouse-up']", "Create My Account Button");

        // -------- Footer Section --------
        checkElement(driver, "//input[@id='EMAIL_ADDRESS_']", "Footer Email", "footer@test.com");
        checkElement(driver, "//button[@class='button button--secondary button--secondary-black page-footer__sign-up-button button--mouse-up']", "Sign me up Button");

        System.out.println("===== ✅ All elements checked successfully! =====");

        driver.quit();
    }

    // Method to check element presence (no typing)
    public static void checkElement(WebDriver driver, String xpath, String elementName) {
        try {
            WebElement el = driver.findElement(By.xpath(xpath));
            if (el.isDisplayed()) {
                System.out.println("✔ " + elementName + " found.");
            }
        } catch (Exception e) {
            System.out.println("❌ " + elementName + " NOT found!");
        }
    }

    // Overloaded method for input fields (with typing)
    public static void checkElement(WebDriver driver, String xpath, String elementName, String text) {
        try {
            WebElement el = driver.findElement(By.xpath(xpath));
            if (el.isDisplayed()) {
                el.clear();
                el.sendKeys(text);
                System.out.println("✔ " + elementName + " found and text entered: " + text);
            }
        } catch (Exception e) {
            System.out.println("❌ " + elementName + " NOT found!");
        }
    }
}
