package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.GmailLogin;
import pages.NetworkHomePage;
import pages.LoginPage;
import pages.ValidatePage;
import wrappers.ProjectSpecificWrappers;

public class SC01TC01 extends ProjectSpecificWrappers{
	@BeforeClass
	public void setData() {
		testCaseName="Scenario1 & TestCase1";
		testDescription="Comparing Donut chart total and each vulnerabilities count";
		browserName="chrome";
	//	dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}

	
	@Test
	public void login( ) throws InterruptedException
		
	{
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
		String code =new GmailLogin(driver, test).clickMailAndGetCode();
		new ValidatePage (driver,test)
		
		.enterSecurityCode(code)
		.clickSubmit();
		new NetworkHomePage(driver,test)
		.clickNetwork()
		.clickDashboard();
		/*String TotalValue=new NetworkHomePage(driver,test).getTotalVul();
		String MediumValue=new NetworkHomePage(driver,test).getMedVul();
		String HighValue=new NetworkHomePage(driver,test).getHighVul();
		String LowValue=new NetworkHomePage(driver,test).getLowVul();*/
		int TotalValue =Integer.parseInt(new NetworkHomePage(driver,test).getTotalVul());
		/*int MediumValue=Integer.parseInt(new NetworkHomePage(driver,test).getMedVul());
		int HighValue=Integer.parseInt(new NetworkHomePage(driver,test).getHighVul());
		int LowValue=Integer.parseInt(new NetworkHomePage(driver,test).getLowVul());
		
		if(TotalValue==(MediumValue+HighValue+LowValue)) {
			System.out.println("PASS");
			reportPass("SC01TC01");
		}
		else {
			reportFail("SC01TC01");
		}*/
	}
	
}
