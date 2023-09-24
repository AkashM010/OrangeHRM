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

public class EmployeeListTab {
	WebDriver driver;
	SoftAssert softAssertion = new SoftAssert();

	@BeforeTest
	public void setup() throws Exception {
		data.setup();
		driver = data.getDriver();
		data.login();
		data.pim();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void testcases() {
		boolean displayed = driver.findElement(By.xpath("//a[text()='Employee List']")).isDisplayed();
		softAssertion.assertEquals(displayed, true);
		boolean enabled = driver.findElement(By.xpath("//a[text()='Employee List']")).isEnabled();
		softAssertion.assertEquals(enabled, true);
		String currentUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		softAssertion.assertEquals(currentUrl, driver.getCurrentUrl());
		softAssertion.assertAll();
	}

	@Test
	public void employeeInformationPage() {
		WebElement employeeName = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"));
		boolean enabled = employeeName.isEnabled();
		softAssertion.assertEquals(enabled, true);
	}

	@Test
	public void employeeID() {
		WebElement empID = driver.findElement(By.xpath("//form/div[1]/div/div[2]/div/div[2]/input"));
		boolean enabled = empID.isEnabled();
		softAssertion.assertEquals(enabled, true);
		empID.sendKeys("123");
	}

	@Test
	public void employeeStatus() {
		WebElement empStatus = driver.findElement(By.xpath("//form/div[1]/div/div[3]/div/div[2]/div/div"));
		boolean displayed = empStatus.isDisplayed();
		softAssertion.assertEquals(displayed, true);
		boolean enabled = empStatus.isEnabled();
		softAssertion.assertEquals(enabled, true);
	}
}
