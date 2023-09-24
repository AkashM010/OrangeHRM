package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addEmployeeTab {
	WebDriver driver;
	SoftAssert softAssertion = new SoftAssert();

	@BeforeTest
	public void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
	}

	@BeforeClass
	public void preConditions() throws Exception {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void employeeFullName() {
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
		boolean displayedFirst = firstName.isDisplayed();
		softAssertion.assertEquals(displayedFirst, true);
		firstName.sendKeys("Random");

		WebElement middleName = driver.findElement(By.xpath("//input[@name='middleName']"));
		boolean displayedMiddle = middleName.isDisplayed();
		softAssertion.assertEquals(displayedMiddle, true);
		middleName.sendKeys("Mid");

		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		boolean displayedLast = lastName.isDisplayed();
		softAssertion.assertEquals(displayedLast, true);
		lastName.sendKeys("Name");
	}

	@Test(priority = 2)
	public void employeeIDTextBox() {
		WebElement empID = driver.findElement(By.xpath("//form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"));
		boolean displayed = empID.isDisplayed();
		softAssertion.assertEquals(displayed, true);
		empID.sendKeys("123");
	}

	@Test(priority = 3)
	public void createLoginDetails() {
		WebElement loginDetails = driver
				.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']"));

		boolean displayed = loginDetails.isDisplayed();
		softAssertion.assertEquals(displayed, true);

		boolean enabled = driver
				.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']"))
				.isEnabled();
		softAssertion.assertEquals(enabled, true);

		loginDetails.click();
		WebElement formElement = driver
				.findElement(By.xpath("//form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
		boolean elementDisplayed = formElement.isDisplayed();
		softAssertion.assertEquals(elementDisplayed, true);
	}

	@Test(priority = 4)
	public void creatLoginDetailsForm() {
		WebElement userName = driver.findElement(By.xpath("//form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));

		userName.sendKeys("Randmom123");
		String valueEntered = userName.getAttribute("value");
		softAssertion.assertEquals(valueEntered.matches("^[a-zA-Z0-9]*$"), true);

		userName.sendKeys("Randommonnarqwertyytrewq1234567894567890");
		String maxLengthValue = userName.getAttribute("value");
		softAssertion.assertEquals(maxLengthValue.matches("^[a-zA-Z0-9]*$"), true);

		userName.sendKeys("Randommonnarqwertyytrewq12345678945678900");
		WebElement errorMsg = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean displayed = errorMsg.isDisplayed();
		softAssertion.assertEquals(displayed, true);

		userName.clear();
		userName.sendKeys(" ");
		WebElement blankedTextBox = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean displayedMsg = blankedTextBox.isDisplayed();
		softAssertion.assertEquals(displayedMsg, true);

		WebElement enabledRadioBtn = driver.findElement(By.xpath("//input[@value='1']"));
		enabledRadioBtn.isSelected();

		enabledRadioBtn.isEnabled();

		WebElement enabledRadioLabel = driver
				.findElement(By.xpath("//form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div/label"));
		enabledRadioLabel.click();

		WebElement disabledRadioBtn = driver.findElement(By.xpath("//input[@value='2']"));
		disabledRadioBtn.isSelected();

		disabledRadioBtn.isEnabled();

		WebElement disabledRadioLabel = driver
				.findElement(By.xpath("//form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[2]/div[2]/div/label+6"));
		disabledRadioLabel.click();

		WebElement pwdTextBox = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
		pwdTextBox.clear();
		pwdTextBox.sendKeys("Random@123");
		String pwdValueEntered = pwdTextBox.getAttribute("value");
		boolean isValidCombination = pwdValueEntered.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$");
		softAssertion.assertEquals(isValidCombination, true);

		pwdTextBox.clear();
		pwdTextBox.sendKeys("Random123");
		String invalidPwdValueEntered = pwdTextBox.getAttribute("value");
		boolean invalidCombination = invalidPwdValueEntered.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$");
		softAssertion.assertEquals(invalidCombination, false);

		pwdTextBox.clear();
		pwdTextBox.sendKeys("R@123");
		WebElement pwdErrorMsg = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean pwdErrorDisplayed = pwdErrorMsg.isDisplayed();
		softAssertion.assertEquals(pwdErrorDisplayed, true);

		pwdTextBox.clear();
		pwdTextBox.sendKeys("Randm@1");
		String validPwdlength = pwdTextBox.getAttribute("value");
		boolean pwdValidLength = validPwdlength.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$");
		softAssertion.assertEquals(pwdValidLength, true);

		pwdTextBox.clear();
		pwdTextBox.sendKeys("Random1@");
		String validPwdlength1 = pwdTextBox.getAttribute("value");
		boolean pwdValidLength1 = validPwdlength1.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$");
		softAssertion.assertEquals(pwdValidLength1, true);

		pwdTextBox.clear();
		pwdTextBox.sendKeys("Random@123"); // Verify that the characters entered in the Password Text Box is properly
											// masked
		String pwdValue = userName.getAttribute("value");
		softAssertion.assertEquals(pwdValue.matches("^[*]+$"), true);

		WebElement confirmPwdTextBox = driver
				.findElement(By.xpath("//form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input"));
		confirmPwdTextBox.clear();
		confirmPwdTextBox.sendKeys("Random@123");
		String confirmPwdValue = userName.getAttribute("value");
		softAssertion.assertEquals(pwdValue, confirmPwdValue);

		confirmPwdTextBox.clear();
		softAssertion.assertEquals(confirmPwdValue.matches("^[*]+$"), true); // Verify that the characters entered in
																				// the confirm Password Text Box is
																				// properly masked
	}
}
