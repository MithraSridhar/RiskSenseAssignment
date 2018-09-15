package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class CreateLead extends ProjectSpecificWrappers{
	
	public CreateLead(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Create Lead | opentaps CRM")){
			reportStep("This is not Home Page", "Fail");
		}
	}
	public CreateLead entercompanyname(String CN){
		enterById("createLeadForm_companyName", CN); 
		return this;
	}
	public CreateLead enterfisrtname(String FN){
		enterById("createLeadForm_firstName", FN); 
		return this;
	}
	public CreateLead enterlastname(String LN){
		enterById("createLeadForm_lastName", LN);
		return this;
	}
	
	public CreateLead enterphonenumber(String PN){
		enterById("createLeadForm_primaryPhoneNumber",PN);
		return this;
	}
	public CreateLead enteremailid(String email){
		enterById("createLeadForm_primaryEmail", email);
		return this;
	}
	public CreateLead selectdatasource(String source){
		selectIndexById("createLeadForm_dataSourceId", source);
		return this;
	}
	public CreateLead selectmarketing(String value){
		selectIndexById("createLeadForm_marketingCampaignId", value);
		return this;
	}

	public ViewLead clickcreatelead(){
		clickByName("submitButton");
		return new ViewLead(driver,test);
	}
	}
	
	