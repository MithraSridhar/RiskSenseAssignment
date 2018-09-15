package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.ProjectSpecificWrappers;

public class CreateLead extends ProjectSpecificWrappers{
	@BeforeClass
	public void setData() {
		testCaseName="CreateLead";
		testDescription="Creating Leads";
		browserName="chrome";
		dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}

	@Test(dataProvider="fetchData")
	public void login( String CN, String FN, String LN,String PN, String email,String source,String value )
			{

		new LoginPage(driver, test)
		.enterUserName()
		.enterPassword()
		.clickLogin()
		.clickcrmsfa()
		.clickleads()
	     .clickcreateleads()
	     .entercompanyname(CN)
	     .enterfisrtname(FN)
	     .enterlastname(LN)
	     .enterphonenumber(PN)
	     .enteremailid(email)
	     .selectdatasource(source)
	     .selectmarketing(value)
	     .clickcreatelead()
	     .getfirstname();		
	}
	
}
