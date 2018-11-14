package pages;


import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class LoginPage extends ProjectSpecificWrappers  {

	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("RiskSense")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	public LoginPage enterUserName(){
		enterByXpath("Login.UserName.Xpath", username);
		return this;
	}
	
	public LoginPage enterPassword(){
		enterByXpath("Login.Password.Xpath", password);
		return this;
		
	}
	
	public GmailLogin clickLogin(){
/*		WebElement element = driver.findElementByClassName("decorativeSubmit");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);*/
		clickByClassName("Login.LoginButton.Class");		
		return new GmailLogin(driver, test);
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
