package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class MergeLeadPage extends ProjectSpecificWrappers {

	public MergeLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Merge Leads | opentaps CRM")){
			reportStep("This is not Merge Leads page", "Fail");
		}
	}
	
	public FindLead clickfromiconbyxpath(){
		clickByXpath("//input[@id='partyIdFrom']//following::a/descendant::img");
		return new FindLead(driver,test);
	}
	public FindLead clicktoiconbyxpath(){
	
	clickByXpath("//input[@id='partyIdTo']//following::a/descendant::img");
	return new FindLead(driver,test);
	}
	public MergeLeadPage clickmerge(){
		
	clickByLink("Merge");
	return this;
}

}