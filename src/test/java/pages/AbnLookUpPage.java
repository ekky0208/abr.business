package pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class AbnLookUpPage extends BaseClass {

	public AbnLookUpPage gotoAbrBusinessMainPage() {
		driver.get("https://abr.business.gov.au/");
		String websiteTitle = driver.getTitle();
		assertEquals(websiteTitle, "ABN Lookup");
		return this;
	}

	public AbnLookUpPage enterInSearchField(String entertext) {
		library.enterText(By.cssSelector("#SearchText"), entertext);
		return this;
	}

	public AbnLookUpPage clickOnSearch() {
		library.clickByElement(By.cssSelector("#MainSearchButton"));
		return this;
	}

	public AbnLookUpPage assertTheSearchResult(String abnNumber, String status) {
		library.waitForVisibilityOfElement(By.xpath("//a[contains(text(),'152 260 814')][1]"));
		library.highlightWebElement(By.xpath("//a[contains(text(),'152 260 814')][1]"));
		library.assertEqualsCheck(By.xpath("//a[contains(text(),'152 260 814')][1]"), abnNumber);
		library.highlightWebElement(By.xpath("//span[contains(text(),'Active')][1]"));
		library.assertEqualsCheck(By.xpath("//span[contains(text(),'Active')][1]"), status);
		return this;
	}

	public AbnLookUpPage clickOnNext() {
		library.scrollToView(By.cssSelector("li.PagedList-skipToNext > button"));
		library.clickManyTimes(By.cssSelector("li.PagedList-skipToNext > button"), 1);
		library.scrollToView(By.cssSelector("li.PagedList-skipToNext > button"));
		library.clickManyTimes(By.cssSelector("li.PagedList-skipToNext > button"), 1);
		return this;
	}

	public AbnLookUpPage findTheAbnNumber() {
		library.waitForVisibilityOfElement(By.xpath("//a[contains(text(),'93 118 220 920')][1]"));
		library.scrollToView(By.xpath("//a[contains(text(),'93 118 220 920')][1]"));
		library.highlightWebElement(By.xpath("//a[contains(text(),'93 118 220 920')][1]"));
		return this;
	}

	public AbnLookUpPage assertTheAbnSearchResult(String abnName) {
		library.waitForVisibilityOfElement(
				By.xpath("//td[contains(text(),'The Trustee for MAURO BROTHERS SENIOR SUPER FUND')][1]"));
		library.highlightWebElement(
				By.xpath("//td[contains(text(),'The Trustee for MAURO BROTHERS SENIOR SUPER FUND')][1]"));
		library.assertEqualsCheck(
				By.xpath("//td[contains(text(),'The Trustee for MAURO BROTHERS SENIOR SUPER FUND')][1]"), abnName);
		return this;
	}

	/***
	 * tried 2nd task differently. Assert that the search result contains an entry
	 * with ABN: 152 260 814 and status: "Active". Below is working but not in use.
	 * 
	 * @param abnNumber
	 * @return
	 */
	public AbnLookUpPage assertTheSearchResult2(String abnNumber) {
		// locating element from parent to child
		WebElement matchingNamesParentElem = driver.findElement(By.id("content-matching"));
		List<WebElement> matchingNameSection = matchingNamesParentElem
				.findElements(By.cssSelector("#content-matching > div > div > table > tbody"));

		for (WebElement tbodyElem : matchingNameSection) {
			WebElement aElem = tbodyElem.findElement(By.tagName("a"));
			String aElemText = aElem.getText();

			if (abnNumber.contains(aElemText)) {
				library.scrollToView(aElem);
				library.highlightWebElement(aElem);
				library.assertEqualsCheck(aElem, abnNumber);
				break;
			}
		}
		return this;
	}
}
