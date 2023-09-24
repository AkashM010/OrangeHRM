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

public class ProfileImage {
	WebDriver driver;
	SoftAssert softAssertion = new SoftAssert();

	@BeforeTest
	public void setup() throws Exception {
		data.setup();
		driver = data.getDriver();
		data.login();
//		data.findingElement(By.xpath("//span[text()='PIM']")).click();
		data.pim();
		data.findingElement(By.xpath("//a[text()='Add Employee']")).click();
//		data.addEmployee();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void profileImage() throws Exception {
//		Thread.sleep(2000);
		data.explicitSync(
				By.xpath("//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']"));
		WebElement img = driver.findElement(
				By.xpath("//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']"));
		img.click();
		WebElement fileInputElement = driver.findElement(By.cssSelector("input[type='file']"));
		boolean displayed = fileInputElement.isDisplayed();
		softAssertion.assertEquals(displayed, true);

		// Verify that the Profile Picture field accepts 200px X 200px image in png
		// format that is exactly 1MB.
		String imgPath1 = "C:\\Users\\Akash\\OneDrive\\Documents\\image.jpg";
		fileInputElement.sendKeys(imgPath1);
		Thread.sleep(10000);

		WebElement uploadedImg1 = driver.findElement(By.xpath("//img[@class='employee-image']"));
		String imageSource1 = uploadedImg1.getAttribute("uploadedImg1");

		boolean isSizeValid1 = imageSource1.contains("200x200") && imageSource1.contains(".png")
				&& imageSource1.contains("1MB");
		softAssertion.assertEquals(isSizeValid1, true);

		// Verify that the Profile Picture field accepts 200px X 200px image in gif
		// format that is exactly 1MB.
		String imgPath2 = "C:\\Users\\Akash\\OneDrive\\Documents\\image1.jpg";
		fileInputElement.sendKeys(imgPath2);
		Thread.sleep(10000);

		WebElement uploadedImg2 = driver.findElement(By.xpath("//img[@class='employee-image']"));
		String imageSource2 = uploadedImg2.getAttribute("uploadedImg2");

		boolean isSizeValid2 = imageSource2.contains("200x200") && imageSource2.contains(".gif")
				&& imageSource2.contains("1MB");
		softAssertion.assertEquals(isSizeValid2, true);

		// Verify that the Profle Picture field does not accepts 300px X 300px image in
		// jpg format of 1MB size.
		String imgPath3 = "C:\\Users\\Akash\\OneDrive\\Documents\\image1.jpg";
		fileInputElement.sendKeys(imgPath3);
		Thread.sleep(10000);
		WebElement errorMsg = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean msg = errorMsg.isDisplayed();
		softAssertion.assertEquals(msg, true);

	}

	@Test
	public void saveButton() {

		WebElement saveBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));

		boolean displayed = saveBtn.isDisplayed();
		softAssertion.assertEquals(displayed, true);

		boolean enabled = saveBtn.isEnabled();
		softAssertion.assertEquals(enabled, true);
	}

	@Test
	public void cancelButton() {
		WebElement cancelBtn = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]"));

		boolean displayed = cancelBtn.isDisplayed();
		softAssertion.assertEquals(displayed, true);

		boolean enabled = cancelBtn.isEnabled();
		softAssertion.assertEquals(enabled, true);
	}
}
