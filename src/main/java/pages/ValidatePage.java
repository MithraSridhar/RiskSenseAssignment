package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class ValidatePage extends ProjectSpecificWrappers{
	
	public ValidatePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("RiskSense")){
			reportStep("This is not Validate Page", "Fail");
		}
	}
	public ValidatePage enterSecurityCode(String code){
		enterByClassName("Validate.Securitycode.Class", code);
		return this;
		
	}
	
	public NetworkHomePage clickSubmit(){
		clickByClassName("Validate.Submit.Class");		
		return new NetworkHomePage(driver, test);
	}

}
