package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class MyLeads extends ProjectSpecificWrappers{
	
	public MyLeads(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("My Leads | opentaps CRM")){
			reportStep("This is not My Leads page", "Fail");
		}
	}
	public CreateLead clickcreateleads(){
		clickByLink("Create Lead");
		return new CreateLead(driver, test); 
		
	}
public FindLead clickfindlead(){
	
	clickByLink("Find Leads");
	return new FindLead(driver,test);
}

public MergeLeadPage clickmergelead(){
	
	clickByLink("Merge Leads");
	return new MergeLeadPage(driver,test);
}
}
