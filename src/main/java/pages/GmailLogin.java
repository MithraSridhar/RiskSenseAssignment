package pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class GmailLogin extends ProjectSpecificWrappers {

	public GmailLogin(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Gmail")){
			reportStep("This is not Gmail page", "Fail");
		}
	}
	
	public GmailLogin openGmail(){
		openNewWindow("http://www.gmail.com");
		return new GmailLogin(driver,test);
	}
	public GmailLogin enterUserName(){
		enterById("Gmail.Login.UserName.ID", gusername);
		return this;
	}
	public GmailLogin switchToGmail(){
		switchToLastWindow();
		return this;
	}
	
	public GmailLogin enterPassword(){
		enterByName("Gmail.Login.Password.ID", gpassword);
		return this;
		
	}
	
	public GmailLogin clickMoreWays(){
		clickByXpath("Gmail.Login.Waytosingin.Xpath");		
		return new GmailLogin(driver, test);
	}
	public GmailLogin clickEnterPassword(){
		clickByXpath("Gmail.Login.ClickEnterpassword.Xpath");		
		return new GmailLogin(driver, test);
	}
	public GmailLogin clickNext(){
				clickByXpath("Gmail.Login.Next.Xpath");		
				return new GmailLogin(driver, test);
			}
	public String clickMailAndGetCode() throws InterruptedException{
		 String Code = null;
		List<WebElement> mail = driver.findElementsByXPath("//div[@class='yW']/span")	;
		System.out.println(mail.size());
		 mail.get(0).click();
		//WebElement mailtoclick = mail.get(0);
		//mailtoclick.click();
		/*for(int i=0;i<mail.size();i++) {
			//System.out.println(mail.get(i).getText());
			try {
			if(mail.get(i).getText().equals("no-reply")) {
				// new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(mail.get(i)));
				
				mail.get(i).click();
			}}	
				catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
					Thread.sleep(3000);
					// new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(mail.get(i)));

					mail.get(i).click();
				}
				
			}*/
		Thread.sleep(3000);
		//waitForElementVisibilityBXpath("Gmail.Mail.Text.Xpath");
					WebElement parentdiv=driver.findElementByXPath("//*[text()[contains(.,'Your code is')]]");
					String parentdivtext=parentdiv.getText();
					System.out.println("parent div:" +parentdivtext);

						   final Pattern p = Pattern.compile( "(\\d{6})" );
						   final Matcher m = p.matcher( parentdivtext );
						   if ( m.find() ) {
							    Code = m.group( 0 );
						     System.out.println("Code is " +Code);
						     closeBrowser();
						     switchToParentWindow();
						   }
							return Code;
							
		
			}

}