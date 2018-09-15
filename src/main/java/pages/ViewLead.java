package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class ViewLead extends ProjectSpecificWrappers{
	

	public ViewLead(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This is not View Lead", "Fail");
		}
	}
	public String getfirstname(){
		String Firstname = getTextById("viewLead_firstName_sp");
		System.out.println(Firstname);
		return Firstname;
	}
	
	public ViewLead getcompanyname(String editedCN){
		verifyTextContainsById("viewLead_companyName_sp", editedCN);
		return this;
	}
	public DuplicateLeadpage clickduplicatelead(){
		clickByLink("Duplicate Lead");
		return new DuplicateLeadpage(driver,test);
		
	}
	public String getleadname(){
		getTextById("viewLead_firstName_sp");
		return toString();
	}
	public EditLead clickeditlead(){
		clickByLink("Edit");
		return new EditLead(driver,test);
		
	}
	public MyLeads clickdeletelead(){
		clickByClassName("subMenuButtonDangerous");
		return new MyLeads(driver,test);
		
	}
	public FindLead clickviewfindlead(){
		clickByLink("Find Leads");
		return new FindLead(driver,test);
	
		
	}
	
	
}