package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLead;
import pages.LoginPage;
import pages.MyLeads;
import pages.ViewLead;
import wrappers.ProjectSpecificWrappers;

public class DeleteLead extends ProjectSpecificWrappers {

	@BeforeClass
	public void setData() {
		testCaseName="Delete Lead";
		testDescription="Deleting Leads";
		browserName="chrome";
		dataSheetName="TC003";
		category="Sanity";
		authors="Mithra";
	}
@Test(dataProvider="fetchData")
public void DEL(String phoneno) throws InterruptedException
{
	new LoginPage(driver, test).
	enterUserName()
	.enterPassword()
	.clickLogin()
	.clickcrmsfa()
	.clickleads()
	.clickfindlead()
	.findleadbyphoneno();
	Thread.sleep(2000);
	new FindLead(driver,test).enterphoneno(phoneno);
	Thread.sleep(3000);
	new FindLead(driver,test).clickfindleadbytext();
	Thread.sleep(3000);
	String leadIDdel=new FindLead(driver,test).getleadidbyxpath();
	System.out.println("Lead ID is "+leadIDdel);
	new FindLead(driver,test).clickleadbyxpath();	
	Thread.sleep(3000);
	new ViewLead(driver, test).clickdeletelead();
	Thread.sleep(3000);
	new MyLeads(driver, test).clickfindlead();
	Thread.sleep(3000);
	new FindLead(driver, test).findbyleadxpath(leadIDdel);
	Thread.sleep(3000);
	new FindLead(driver, test).clickfindlead()
	 .verifynoleadtext();	
}

}


