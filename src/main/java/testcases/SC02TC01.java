package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GmailLogin;
import pages.LoginPage;
import pages.NetworkHomePage;
import pages.ValidatePage;
import wrappers.ProjectSpecificWrappers;

public class SC02TC01 extends ProjectSpecificWrappers {

	@BeforeClass
	public void setData() {
		testCaseName = "Scenario2 & TestCase1";
		testDescription = "Comparing Donut chart total and each vulnerabilities count by applying filters";
		browserName = "chrome";
		dataSheetName = "FilterNameSheet";
		category = "Smoke";
		authors = "Mithra";
	}

	@Test(dataProvider = "fetchData")
	public void DEL(String Filter) throws InterruptedException {

		new LoginPage(driver, test)
		.enterUserName()
		.enterPassword()
		.clickLogin()
		.openGmail()
		.switchToGmail()
		.enterUserName()
		.clickNext()
		.enterPassword()
		.clickNext();
		String code = new GmailLogin(driver, test).clickMailAndGetCode();
		new ValidatePage(driver, test)
		.enterSecurityCode(code)
		.clickSubmit();
		new NetworkHomePage(driver, test).clickNetwork()
		.clickDashboard()
		.applyFilter(Filter);
		waitForElementVisibilityBXpath("Network.Graph.Total.Xpath");
		/*
		 * String TotalValue=new NetworkHomePage(driver,test).getTotalVul(); String
		 * MediumValue=new NetworkHomePage(driver,test).getMedVul(); String
		 * HighValue=new NetworkHomePage(driver,test).getHighVul(); String LowValue=new
		 * NetworkHomePage(driver,test).getLowVul();
		 */

		int TotalValue = Integer.parseInt(new NetworkHomePage(driver, test).getTotalVul());
		/*int MediumValue = Integer.parseInt(new NetworkHomePage(driver, test).getMedVul());
		int HighValue = Integer.parseInt(new NetworkHomePage(driver, test).getHighVul());
		int LowValue = Integer.parseInt(new NetworkHomePage(driver, test).getLowVul());
*/
		/*if(TotalValue==(MediumValue+HighValue+LowValue)) {
			System.out.println("PASS");
			reportPass("SC02TC01");
		}
		else {
			reportFail("SC02TC01");
		}*/
	}
}
