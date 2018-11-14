package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.GmailLogin;
import pages.LoginPage;
import pages.NetworkHomePage;
import pages.ValidatePage;
import wrappers.ProjectSpecificWrappers;

public class SC01TC02 extends ProjectSpecificWrappers {
	@BeforeClass
	public void setData() {
		testCaseName = "Scenario1 & TestCase2";
		testDescription = "Comparing Donut chart total and security view count";
		browserName = "chrome";
		// dataSheetName="TC002";
		category = "Sanity";
		authors = "Mithra";
	}

	@Test
	public void EL() throws InterruptedException {
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
		new ValidatePage(driver, test).enterSecurityCode(code)
		.clickSubmit();
		new NetworkHomePage(driver, test).clickNetwork()
		.clickDashboard();
		int TotalValue = Integer.parseInt(new NetworkHomePage(driver, test).getTotalVul());
		/*int MediumValue = Integer.parseInt(new NetworkHomePage(driver, test).getMedVul());
		int HighValue = Integer.parseInt(new NetworkHomePage(driver, test).getHighVul());
		int LowValue = Integer.parseInt(new NetworkHomePage(driver, test).getLowVul());*/
		int SecurityViewTotalValue = Integer.parseInt(new NetworkHomePage(driver, test).getSecurityViewTotalVul());
	/*	int SecurityViewMediumValue = Integer.parseInt(new NetworkHomePage(driver, test).getSecurityViewMedVul());
		int SecurityViewHighValue = Integer.parseInt(new NetworkHomePage(driver, test).getSecurityViewHighVul());
		int SecurityViewLowValue = Integer.parseInt(new NetworkHomePage(driver, test).getSecurityViewLowVul());*/

		if(TotalValue==SecurityViewTotalValue) {
			System.out.println("Total vulnerabilities matches between network and security view");
			reportPass("Total Vulnerability");
		}
		else {
			System.out.println("Total vulnerabilities does not matches between network and security view");
			reportFail("Total Vulnerability");
		}
		/*if(MediumValue==SecurityViewMediumValue) {
			System.out.println("Medium vulnerabilities matches between network and security view");
			reportPass("Medium Vulnerability");
		}
		else {
			System.out.println("Medium vulnerabilities does not matches between network and security view");
			reportFail("Medium Vulnerability");
		}
		if(HighValue==SecurityViewHighValue) {
			System.out.println("High vulnerabilities matches between network and security view");
			reportPass("High Vulnerability");
		}
		else {
			System.out.println("High vulnerabilities does not matches between network and security view");
			reportFail("High Vulnerability");
		}
		if(LowValue==SecurityViewLowValue) {
			System.out.println("Low vulnerabilities matches between network and security view");
			reportPass("Low Vulnerability");
		}
		else {
			System.out.println("Low vulnerabilities does not matches between network and security view");
			reportFail("Low Vulnerability");
		}*/
		
	}

}
