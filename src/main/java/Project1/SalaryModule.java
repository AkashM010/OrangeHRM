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

public class SalaryModule {
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

//	@BeforeClass
//	public void preConditions() throws Exception {
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
//		driver.findElement(By.tagName("button")).click();
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//span[text()='PIM']")).click();
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Random");
//		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("Mid");
//		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Name");
//		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
//	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test
	public void salaryModuleTab() {
		WebElement salary = driver.findElement(By.xpath("//a[text()='Salary']"));

		boolean displayed = salary.isDisplayed();
		softAssertion.assertEquals(displayed, true);

		boolean enabled = salary.isEnabled();
		softAssertion.assertEquals(enabled, true);
	}

	@Test
	public void addSalaryComponents() {
		WebElement addBtn1 = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button/i"));

		boolean displayed = addBtn1.isDisplayed();
		softAssertion.assertEquals(displayed, true);

		boolean enabled = addBtn1.isEnabled();
		softAssertion.assertEquals(enabled, true);

		WebElement salaryComponenets = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input"));
		boolean elementDisplayed = salaryComponenets.isDisplayed();
		softAssertion.assertEquals(elementDisplayed, true);

		boolean elementEnabled = salaryComponenets.isEnabled();
		softAssertion.assertEquals(elementEnabled, true);

		salaryComponenets.sendKeys("Basic Pay");
		String valueEntered = salaryComponenets.getAttribute("value");
		softAssertion.assertEquals(valueEntered.matches("^[a-zA-Z]*$"), true);

		// Pay Grade dropdown box verification
		WebElement payGradeddElement = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]"));
		boolean payGradeddDisplayed = payGradeddElement.isDisplayed();
		softAssertion.assertEquals(payGradeddDisplayed, true);

		boolean payGradeddEnabled = payGradeddElement.isEnabled();
		softAssertion.assertEquals(payGradeddEnabled, true);

		Select payGradedd = new Select(payGradeddElement);

		List<WebElement> optionsPayGrade = payGradedd.getOptions();
		if (optionsPayGrade.size() > 0) {
			actual = true;
		}
		softAssertion.assertEquals(actual, true);

		// Pay Frequency dropdown box verification
		WebElement payFreqddElement = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]"));
		boolean payFreqddDisplayed = payFreqddElement.isDisplayed();
		softAssertion.assertEquals(payFreqddDisplayed, true);

		boolean payFreqddEnabled = payFreqddElement.isEnabled();
		softAssertion.assertEquals(payFreqddEnabled, true);

		Select payFreqdd = new Select(payFreqddElement);

		List<WebElement> optionsPayFreq = payFreqdd.getOptions();
		if (optionsPayFreq.size() > 0) {
			actual = true;
		}
		softAssertion.assertEquals(actual, true);

		// Currency dropdown box verification
		WebElement payCurrencyddElement = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]"));
		boolean payCurrencyddDisplayed = payCurrencyddElement.isDisplayed();
		softAssertion.assertEquals(payCurrencyddDisplayed, true);

		boolean payCurrencyddEnabled = payCurrencyddElement.isEnabled();
		softAssertion.assertEquals(payCurrencyddEnabled, true);

		Select payCurrencydd = new Select(payCurrencyddElement);

		List<WebElement> optionsCurrency = payCurrencydd.getOptions();
		if (optionsCurrency.size() > 0) {
			actual = true;
		}
		softAssertion.assertEquals(actual, true);

		// PIM Amount TextBox
		WebElement pimAmount = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/input"));

		boolean pimAmtDisplayed = pimAmount.isDisplayed();
		softAssertion.assertEquals(pimAmtDisplayed, true);

		boolean pimAmtEnabled = pimAmount.isEnabled();
		softAssertion.assertEquals(pimAmtEnabled, true);

		pimAmount.sendKeys("254");
		String value = pimAmount.getAttribute("value");
		softAssertion.assertEquals(value.matches("^[0-9]*$"), true);

		pimAmount.sendKeys("Random");
		WebElement errorMsg = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean msg = errorMsg.isDisplayed();
		softAssertion.assertEquals(msg, true);

		pimAmount.sendKeys("Randommonnarqwertyytrewq12345678945678900");
		WebElement errorMsg1 = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean displayed1 = errorMsg1.isDisplayed();
		softAssertion.assertEquals(displayed1, true);

		pimAmount.clear();
		pimAmount.sendKeys(" ");
		WebElement blankedTextBox = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean displayedMsg = blankedTextBox.isDisplayed();
		softAssertion.assertEquals(displayedMsg, true);

		// Comment textbox
		WebElement comment = driver.findElement(
				By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']"));

		comment.sendKeys("Random Text");
		String value1 = comment.getAttribute("value");
		softAssertion.assertEquals(value1.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$"), true);

		// Include DirectDepositDetails Radio Button
		WebElement directDeposit = driver
				.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']"));

		boolean directDepositdisplayed = directDeposit.isDisplayed();
		softAssertion.assertEquals(directDepositdisplayed, true);

		boolean directDepositenabled = directDeposit.isEnabled();
		softAssertion.assertEquals(directDepositenabled, true);

		WebElement accountNmbr = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div[1]/div[1]/div/div[2]/input"));
		boolean accountNmbrDisplayed = accountNmbr.isDisplayed();
		softAssertion.assertEquals(accountNmbrDisplayed, true);

		// Account Number
		accountNmbr.sendKeys("2546BCFG654");
		String accountNmbrEntered = accountNmbr.getAttribute("value");
		softAssertion.assertEquals(accountNmbrEntered.matches("^[a-zA-Z0-9]*$"), true);

		accountNmbr.clear();
		accountNmbr.sendKeys(" ");
		WebElement accountNmbrMsg = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean accountNmbrDisplayedMsg = accountNmbrMsg.isDisplayed();
		softAssertion.assertEquals(accountNmbrDisplayedMsg, true);

		// Account type dropdown box verification
		WebElement accountTypeddElement = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div[1]/div[2]/div/div[2]/div/div/div[1]"));
		boolean accountTypeddDisplayed = accountTypeddElement.isDisplayed();
		softAssertion.assertEquals(accountTypeddDisplayed, true);

		boolean accountTypeddEnabled = accountTypeddElement.isEnabled();
		softAssertion.assertEquals(accountTypeddEnabled, true);

		Select accountTypedd = new Select(accountTypeddElement);

		List<WebElement> optionsAccountType = accountTypedd.getOptions();
		if (optionsAccountType.size() > 0) {
			actual = true;
		}
		softAssertion.assertEquals(actual, true);

		// Routing Number
		WebElement routingNmbr = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div[2]/div[1]/div/div[2]/input"));

		boolean routingNmbrDisplayed = pimAmount.isDisplayed();
		softAssertion.assertEquals(routingNmbrDisplayed, true);

		boolean routingNmbrEnabled = pimAmount.isEnabled();
		softAssertion.assertEquals(routingNmbrEnabled, true);

		pimAmount.sendKeys("254");
		String routingNmbrValue = routingNmbr.getAttribute("value");
		softAssertion.assertEquals(routingNmbrValue.matches("^[0-9]*$"), true);

		routingNmbr.sendKeys("Random");
		WebElement routingNmbrErrorMsg = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean routingNmbrMsg = routingNmbrErrorMsg.isDisplayed();
		softAssertion.assertEquals(routingNmbrMsg, true);

		routingNmbr.clear();
		routingNmbr.sendKeys(" ");
		WebElement routingNmbrBlankedTextBox = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean routingNmbrDisplayedMsg = routingNmbrBlankedTextBox.isDisplayed();
		softAssertion.assertEquals(routingNmbrDisplayedMsg, true);

		// PIM Amount TextBox
		WebElement pimAmount2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/input"));

		boolean pimAmtDisplayed2 = pimAmount2.isDisplayed();
		softAssertion.assertEquals(pimAmtDisplayed2, true);

		boolean pimAmtEnabled2 = pimAmount2.isEnabled();
		softAssertion.assertEquals(pimAmtEnabled2, true);

		pimAmount2.sendKeys("254");
		String value2 = pimAmount2.getAttribute("value");
		softAssertion.assertEquals(value2.matches("^[0-9]*$"), true);

		pimAmount2.sendKeys("Random");
		WebElement errorMsg2 = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean msg2 = errorMsg2.isDisplayed();
		softAssertion.assertEquals(msg2, true);

		pimAmount.sendKeys("Randommonnarqwertyytrewq12345678945678900");
		WebElement errorMsg21 = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean displayed2 = errorMsg21.isDisplayed();
		softAssertion.assertEquals(displayed2, true);

		pimAmount2.clear();
		pimAmount2.sendKeys(" ");
		WebElement blankedTextBox2 = driver.findElement(By.xpath(
				"//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		boolean displayedMsg2 = blankedTextBox2.isDisplayed();
		softAssertion.assertEquals(displayedMsg2, true);

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

		// Add button
		WebElement addBtn2 = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button/i"));

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
