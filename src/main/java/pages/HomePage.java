package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class HomePage extends ProjectSpecificWrappers  {

	public HomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Leaftaps - TestLeaf Automation Platform")){
			reportStep("This is not Home Page", "Fail");
		}
	}
	
	public LoginPage clickLogOut(){
		clickByClassName("decorativeSubmit");
		return new LoginPage(driver, test); 
	}	
	
	public MyHome clickcrmsfa(){
		clickByLink("CRM/SFA");
		return new MyHome(driver, test); 
	}
}
