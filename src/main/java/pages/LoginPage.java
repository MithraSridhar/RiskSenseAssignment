package pages;


import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class LoginPage extends ProjectSpecificWrappers  {

	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Leaftaps - TestLeaf Automation Platform")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	public LoginPage enterUserName(){
		enterById("username", username);
		return this;
	}
	
	public LoginPage enterPassword(){
		enterByName("PASSWORD", password);
		return this;
		
	}
	
	public HomePage clickLogin(){
/*		WebElement element = driver.findElementByClassName("decorativeSubmit");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);*/
		clickByClassName("decorativeSubmit");		
		return new HomePage(driver, test);
	}
	
	public LoginPage clickLoginForFailure(){
		clickByClassName("decorativeSubmit");
		return this;
	}
	
	public LoginPage verifyErrorMsg(String text){
		verifyTextContainsById("errorDiv", text);
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
