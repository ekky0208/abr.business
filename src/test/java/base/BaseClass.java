package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;
	public static SeleniumAndJavaLibrary library;

	//TestNG Annotations
	@BeforeClass // This will run test before any methods for ones.
	public void beforeAllTheTest() {
		library = new SeleniumAndJavaLibrary(driver);
	}

	@BeforeMethod // This method will run before each test
	public void setUp() {
		driver = library.startChromeBrowser();
	}

	@AfterMethod // This method will run after each test
	public void tearDown() {
		driver.close();
	}

	@AfterClass // This will run test for ones after all the methods.
	public void afterAllTheTests() {
		if (driver != null) {
			driver.quit();
		}
	}

}
