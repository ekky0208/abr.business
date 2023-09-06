package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.AbnLookUpPage;

public class AbrBusinessTest extends BaseClass {

	@Test(enabled = true)
	public void abnLookUptest() {

		AbnLookUpPage callAbnLookUp = new AbnLookUpPage();
		callAbnLookUp.gotoAbrBusinessMainPage();
		callAbnLookUp.enterInSearchField("Automic PTY LTD");
		callAbnLookUp.clickOnSearch();
		callAbnLookUp.assertTheSearchResult("27 152 260 814", "Active");
		
		callAbnLookUp.gotoAbrBusinessMainPage();
		callAbnLookUp.enterInSearchField("MARIO BROS PTY LTD");
		callAbnLookUp.clickOnSearch();
		callAbnLookUp.clickOnNext();
		callAbnLookUp.findTheAbnNumber();
		callAbnLookUp.assertTheAbnSearchResult("The Trustee for MAURO BROTHERS SENIOR SUPER FUND");
	}

}
