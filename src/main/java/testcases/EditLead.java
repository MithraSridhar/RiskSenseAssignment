package testcases;




import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLead;
import pages.LoginPage;
import pages.ViewLead;
import wrappers.ProjectSpecificWrappers;

public class EditLead extends ProjectSpecificWrappers{
	@BeforeClass
	public void setData() {
		testCaseName="EditLead";
		testDescription="Editing Leads";
		browserName="chrome";
		dataSheetName="TC002";
		category="Sanity";
		authors="Mithra";
	}
@Test(dataProvider="fetchData")
public void EL(String EFN,String ECN,String editedCN) throws InterruptedException
{
	new LoginPage(driver, test).
	enterUserName()
	.enterPassword()
	.clickLogin()
	.clickcrmsfa()
	.clickleads()
	.clickfindlead()
	.enterfirstname(EFN);
	Thread.sleep(2000);
	new FindLead(driver, test).clickfindlead();
	Thread.sleep(3000);
	new FindLead(driver, test).clickleadbyxpath();
	Thread.sleep(3000);
	new ViewLead(driver, test).clickeditlead()
	.entereditname(ECN)
	.clicksubmit()
	.getcompanyname(editedCN);
	
}

}
