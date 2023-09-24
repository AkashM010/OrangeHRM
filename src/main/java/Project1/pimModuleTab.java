package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pimModuleTab {
	WebDriver driver;
	SoftAssert softAssertion = new SoftAssert();

	@BeforeTest
	public void setup() throws Exception {
		data.setup();
		driver = data.getDriver();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
	}

	@AfterTest
	public void teardown() {
		data.close();
	}

	@Test
	public void testcases() throws Exception {
		data.implicitSync();
		boolean displayed = driver.findElement(By.xpath("//span[text()='PIM']")).isDisplayed();
		softAssertion.assertEquals(displayed, true);
		boolean enabled = driver.findElement(By.xpath("//span[text()='PIM']")).isEnabled();
		softAssertion.assertEquals(enabled, true);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		String currentUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		softAssertion.assertEquals(currentUrl, driver.getCurrentUrl());
		softAssertion.assertAll();
	}
}
