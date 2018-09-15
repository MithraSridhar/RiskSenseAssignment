package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectSpecificWrappers;

public class TC001_Login extends ProjectSpecificWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Login";
		testDescription="Login To Opentaps";
		browserName="chrome";
		dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}

	@Test(dataProvider="fetchData")
	public void login(String userName, String passWord)
			{

		new LoginPage(driver, test)
		.enterUserName()
		.enterPassword()
		.clickLogin()
		.clickLogOut();

	}

}
