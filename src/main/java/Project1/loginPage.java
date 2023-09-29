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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginPage {

	private WebDriver driver;
	static PageObject obj;

	@BeforeMethod
	public void setUp() {
		PageObject.setup();
		driver = PageObject.getDriver();
		obj = new PageObject(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@DataProvider(name = "testdata")
	public static Object[][] excel() throws IOException {
		FileInputStream f = new FileInputStream(
				"C:\\Users\\Akash\\OneDrive\\Desktop\\Project\\Automation Testing Project\\Project 2\\excelData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object data[][] = new Object[rowCount - 1][colCount];
		XSSFRow row;

		for (int i = 1; i < rowCount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				data[i - 1][j] = row.getCell(j).toString();
			}
		}
		return data;
	}

	@Test(dataProvider = "testdata")
	public static void testCase001(String user, String pass) throws Exception {
		obj.userName(user);
		obj.password(pass);
		obj.button();
	}
}
