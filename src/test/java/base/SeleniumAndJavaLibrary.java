package base;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAndJavaLibrary {

	private WebDriver driver;

	public SeleniumAndJavaLibrary(WebDriver _driver) {
		driver = _driver;
	}

	public WebDriver startChromeBrowser() {

		// automatically checking chrome version/download the latest version
		WebDriverManager.chromedriver().setup();
		// starting the chrome driver.
		driver = new ChromeDriver();
		// maximizing the window
		driver.manage().window().maximize();
		// wait/check if any element is not available on a web page.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// wait for web page to load/display fully.
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));

		return driver;
	}

	public void enterText(By by, String inputText) {
		try {
			WebElement element = driver.findElement(by);
			element.clear();
			element.sendKeys(inputText);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickByElement(By by) {
		try {
			WebElement element = driver.findElement(by);
			element.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickManyTimes(By by, int x) {
		WebElement clickElement = driver.findElement(by);
		for (int i = 0; i < x; i++) {
			clickElement.click();
		}
	}

	public WebElement waitForVisibilityOfElement(By by) {
		WebElement element = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public void assertEqualsCheck(By by, String expectedText) {
		try {
			WebElement actualText = driver.findElement(by);
			String actualAssert = actualText.getText();
			assertEquals(actualAssert, expectedText);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void assertEqualsCheck(WebElement element, String expectedText) {
		try {
			WebElement actualText = element;
			String actualAssert = actualText.getText();
			assertEquals(actualAssert, expectedText);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollToView(By by) {
		try {
			WebElement element = driver.findElement(by);
			Actions action = new Actions(driver);
			action.scrollToElement(element).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollToView(WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.scrollToElement(element).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pauseTheTest(double inSeconds) {
		try {
			// casting/converting data type from double to long.
			long seconds = (long) (inSeconds * 1000);
			Thread.sleep(seconds);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void highlightWebElement(By by) {
		try {
			WebElement element = driver.findElement(by);
			WrapsDriver wrappedElement = (WrapsDriver) element;
			JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();

			for (int i = 1; i < 4; i++) {// This will help the highlight to flash on and off.
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"colour: red; border: 2px solid yellow");
				pauseTheTest(0.5);

				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
				pauseTheTest(0.5);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void highlightWebElement(WebElement element) {
		try {
			WrapsDriver wrappedElement = (WrapsDriver) element;
			JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();

			for (int i = 1; i < 4; i++) {// This will help the highlight to flash on and off.
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"colour: red; border: 2px solid yellow");
				pauseTheTest(0.5);

				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
				pauseTheTest(0.5);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
