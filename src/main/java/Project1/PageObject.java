package Project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageObject {

	public static WebDriver driver;

	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		implicitSync();
		launchApp("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void launchApp(String url) {
		driver.get(url);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(tagName = "button")
	WebElement btn;
	
	@FindBy(tagName = "//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']")
	WebElement image;
	
	@FindBy(css = "input[type='file']")
	WebElement fileEle;
	
	@FindBy(xpath = "//img[@class='employee-image']")
	WebElement imgElement;
	
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	WebElement errorElementMsg;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement saveElement;
	
	@FindBy(xpath = "//*[@id=\\\"app\\\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]")
	WebElement cancelElement;
	
	public void userName(String name) {
		username.sendKeys(name);
	}
	
	public void password(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void button() {
		btn.click();
	}
	
	public void imageButton() {
		image.click();
	}
	
	public boolean fileDisplayed() {
		return fileEle.isDisplayed();
	}
	
	public WebElement imageUpload() {
		return imgElement;
	}
	
	public WebElement imageErrorMsg() {
		return errorElementMsg;
	}
	
	public WebElement saveButton() {
		return saveElement;
	}
	
	public WebElement cancelButton() {
		return cancelElement;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static WebElement findingElement(By locator) {
		WebElement ele = driver.findElement(locator);
		return ele;
	}

	public static void implicitSync() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void explicitSync(By locator) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void login() {
		WebElement username = findingElement(By.xpath("//input[@name='username']"));
		username.sendKeys("Admin");
//		Thread.sleep(2000);
		WebElement password = findingElement(By.xpath("//input[@name='password']"));
		password.sendKeys("admin123");
//		Thread.sleep(2000);
		WebElement button = findingElement(By.tagName("button"));
		button.click();
	}

	public static void pim() {
		findingElement(By.xpath("//span[text()='PIM']")).click();
//		driver.findElement(By.xpath("//span[text()='PIM']")).click();
	}

	public static void addEmployee() {
		findingElement(By.xpath("//a[text()='Add Employee']")).click();
		findingElement(By.xpath("//input[@name='firstName']")).sendKeys("Random");
		findingElement(By.xpath("//input[@name='middleName']")).sendKeys("Mid");
		findingElement(By.xpath("//input[@name='lastName']")).sendKeys("Name");
		findingElement(By.xpath("//button[@type=\"submit\"]")).click();
	}

	public static void close() {
		driver.quit();
	}

}
