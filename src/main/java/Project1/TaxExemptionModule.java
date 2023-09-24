package Project1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TaxExemptionModule {
	WebDriver driver;
	SoftAssert softAssertion = new SoftAssert();
	boolean actual = false;

	@BeforeTest
	public void setup() throws Exception {
		data.setup();
		driver = data.getDriver();
		data.login();
		data.pim();
		data.addEmployee();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test
	public void taxExemptionModuleTab() {
		WebElement texExemption = driver.findElement(By.xpath("//a[text()='Tax Exemptions']"));

		boolean displayed = texExemption.isDisplayed();
		softAssertion.assertEquals(displayed, true);

		boolean enabled = texExemption.isEnabled();
		softAssertion.assertEquals(enabled, true);

		// Status dropdown box verification
		WebElement statusddElement = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]"));
		boolean statusddDisplayed = statusddElement.isDisplayed();
		softAssertion.assertEquals(statusddDisplayed, true);

		boolean statusddEnabled = statusddElement.isEnabled();
		softAssertion.assertEquals(statusddEnabled, true);

		Select statusdd = new Select(statusddElement);

		List<WebElement> optionsStatus = statusdd.getOptions();
		if (optionsStatus.size() > 0) {
			actual = true;
		}
		softAssertion.assertEquals(actual, true);

		// Exemption TextBox
		WebElement exemptionTextBox = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input"));

		boolean exemptionTextBoxDisplayed = exemptionTextBox.isDisplayed();
		softAssertion.assertEquals(exemptionTextBoxDisplayed, true);

		boolean exemptionTextBoxEnabled = exemptionTextBox.isEnabled();
		softAssertion.assertEquals(exemptionTextBoxEnabled, true);

		exemptionTextBox.sendKeys("9");
		String value = exemptionTextBox.getAttribute("value");
		softAssertion.assertEquals(value.matches("^[0-9]*$"), true);

		exemptionTextBox.sendKeys("09");
		String value2 = exemptionTextBox.getAttribute("value");
		softAssertion.assertEquals(value2.matches("^[0-9]*$"), true);

		exemptionTextBox.sendKeys("009");
		WebElement errorMsg = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean displayed1 = errorMsg.isDisplayed();
		softAssertion.assertEquals(displayed1, true);

		// State dropdown box verification
		WebElement stateddElement = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div[2]/div/div"));
		boolean stateddDisplayed = stateddElement.isDisplayed();
		softAssertion.assertEquals(stateddDisplayed, true);

		boolean stateddEnabled = stateddElement.isEnabled();
		softAssertion.assertEquals(stateddEnabled, true);

		Select statedd = new Select(stateddElement);

		List<WebElement> optionsState = statedd.getOptions();
		if (optionsState.size() > 0) {
			actual = true;
		}
		softAssertion.assertEquals(actual, true);

		// Status dropdown box verification
		WebElement statusddElement1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/div/div/div[1]"));
		boolean statusddDisplayed1 = statusddElement1.isDisplayed();
		softAssertion.assertEquals(statusddDisplayed1, true);

		boolean statusddEnabled1 = statusddElement1.isEnabled();
		softAssertion.assertEquals(statusddEnabled1, true);

		Select statusdd1 = new Select(statusddElement1);

		List<WebElement> optionsStatus1 = statusdd1.getOptions();
		if (optionsStatus1.size() > 0) {
			actual = true;
		}
		softAssertion.assertEquals(actual, true);

		// Exemption TextBox
		WebElement exemptionTextBox1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[3]/div/div[2]/input"));

		boolean exemptionTextBoxDisplayed1 = exemptionTextBox1.isDisplayed();
		softAssertion.assertEquals(exemptionTextBoxDisplayed1, true);

		boolean exemptionTextBoxEnabled1 = exemptionTextBox1.isEnabled();
		softAssertion.assertEquals(exemptionTextBoxEnabled1, true);

		exemptionTextBox1.sendKeys("9");
		String value1 = exemptionTextBox1.getAttribute("value");
		softAssertion.assertEquals(value1.matches("^[0-9]*$"), true);

		exemptionTextBox1.sendKeys("09");
		String value3 = exemptionTextBox1.getAttribute("value");
		softAssertion.assertEquals(value3.matches("^[0-9]*$"), true);

		exemptionTextBox1.sendKeys("009");
		WebElement errorMsg1 = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean displayed2 = errorMsg1.isDisplayed();
		softAssertion.assertEquals(displayed2, true);

		// Unemployed State dropdown box verification
		WebElement UnemployedStateddElement = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[4]/div/div[2]/div/div"));
		boolean UnemployedStateddDisplayed = UnemployedStateddElement.isDisplayed();
		softAssertion.assertEquals(UnemployedStateddDisplayed, true);

		boolean UnemployedStateddEnabled = UnemployedStateddElement.isEnabled();
		softAssertion.assertEquals(UnemployedStateddEnabled, true);

		Select UnemployedStatedd = new Select(UnemployedStateddElement);

		List<WebElement> optionUnemployedState = UnemployedStatedd.getOptions();
		if (optionUnemployedState.size() > 0) {
			actual = true;
		}
		softAssertion.assertEquals(actual, true);

		// Work State dropdown box verification
		WebElement WorkStateddElement = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[5]/div/div[2]/div/div"));
		boolean WorkStateddDisplayed = WorkStateddElement.isDisplayed();
		softAssertion.assertEquals(WorkStateddDisplayed, true);

		boolean WorkStateddEnabled = WorkStateddElement.isEnabled();
		softAssertion.assertEquals(WorkStateddEnabled, true);

		Select WorkStatedd = new Select(WorkStateddElement);

		List<WebElement> optionWorkState = WorkStatedd.getOptions();
		if (optionWorkState.size() > 0) {
			actual = true;
		}
		softAssertion.assertEquals(actual, true);

		// Save Button
		WebElement saveBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));

		boolean saveDisplayed = saveBtn.isDisplayed();
		softAssertion.assertEquals(saveDisplayed, true);

		boolean saveEenabled = saveBtn.isEnabled();
		softAssertion.assertEquals(saveEenabled, true);

		// Add button
		WebElement addBtn2 = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/button"));

		boolean addBtndisplayed = addBtn2.isDisplayed();
		softAssertion.assertEquals(addBtndisplayed, true);

		boolean addBtnenabled = addBtn2.isEnabled();
		softAssertion.assertEquals(addBtnenabled, true);

		WebElement selectFileBox = driver.findElement(By.xpath("//div[text()='No file selected']"));
		boolean selectFileBoxDisplayed = selectFileBox.isDisplayed();
		softAssertion.assertEquals(selectFileBoxDisplayed, true);
	}

	@Test
	public void addAttachment() {
		WebElement selectFileBox = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[5]/div/form/div[1]/div/div/div/div[2]/div"));
		boolean selectFileBoxEnabled = selectFileBox.isEnabled();
		softAssertion.assertEquals(selectFileBoxEnabled, true);

		// Comment textbox
		WebElement comment2 = driver.findElement(
				By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']"));

		comment2.sendKeys("Random Text");
		String commentValue = comment2.getAttribute("value");
		softAssertion.assertEquals(commentValue.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$"), true);

		// Save Button
		WebElement saveBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));

		boolean saveDisplayed = saveBtn.isDisplayed();
		softAssertion.assertEquals(saveDisplayed, true);

		boolean saveEenabled = saveBtn.isEnabled();
		softAssertion.assertEquals(saveEenabled, true);

		// Cancel button
		WebElement cancelBtn = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]"));

		boolean cancelBtnDisplayed = cancelBtn.isDisplayed();
		softAssertion.assertEquals(cancelBtnDisplayed, true);

		boolean cancelBtnEnabled = cancelBtn.isEnabled();
		softAssertion.assertEquals(cancelBtnEnabled, true);

		// Saved records
		WebElement records = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div"));

		boolean recordsDisplayed = records.isDisplayed();
		softAssertion.assertEquals(recordsDisplayed, true);

		boolean recordsEnabled = records.isEnabled();
		softAssertion.assertEquals(recordsEnabled, true);

		WebElement recordsCheckbox = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/div[1]/div/div[1]/div/label/span/i"));
		boolean recordsCheckboxEnabled = recordsCheckbox.isEnabled();
		softAssertion.assertEquals(recordsCheckboxEnabled, true);

		// Edit button
		WebElement editBtn = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]"));

		boolean editBtnDisplayed = editBtn.isDisplayed();
		softAssertion.assertEquals(editBtnDisplayed, true);

		boolean editBtnEnabled = editBtn.isEnabled();
		softAssertion.assertEquals(editBtnEnabled, true);

		// Delete button
		WebElement deleteBtn = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]"));

		boolean deleteBtnDisplayed = deleteBtn.isDisplayed();
		softAssertion.assertEquals(deleteBtnDisplayed, true);

		boolean deleteBtnEnabled = deleteBtn.isEnabled();
		softAssertion.assertEquals(deleteBtnEnabled, true);

		// Download button
		WebElement downloadBtn = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]"));

		boolean downloadBtnDisplayed = downloadBtn.isDisplayed();
		softAssertion.assertEquals(downloadBtnDisplayed, true);

		boolean downloadBtnEnabled = downloadBtn.isEnabled();
		softAssertion.assertEquals(downloadBtnEnabled, true);
	}
}
