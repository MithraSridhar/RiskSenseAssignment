package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

@SuppressWarnings("unused")
public class NetworkHomePage extends ProjectSpecificWrappers  {

	public NetworkHomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("RiskSense")){
			reportStep("This is not network Home Page", "Fail");
		}
	}
	
	public NetworkHomePage clickNetwork(){
		clickByXpath("Home.Network.Xpath");
		return new NetworkHomePage(driver, test); 
	}	
	
	public NetworkHomePage clickDashboard() throws InterruptedException{
		driver.get("https://platform2.risksense.com/start#/NetworkSecurity/Dashboard");
		 Thread.sleep(20000);
		 WebElement googleLogo = findByXpath("Network.Graph.Total.Xpath");
		 waitForElementVisibilityBXpath("Network.Graph.Total.Xpath");
		// new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(googleLogo));
		  //  new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(googleLogo));
		
		   // WebElement googleLogo = driver.findElementByXPath("//*[@d='M4.479145667881445e-15,-73.15A73.15,73.15 0 0,1 39.619920054082634,61.491336258924335L30.615392769063853,47.516032563714255A56.525000000000006,56.525000000000006 0 0,0 3.4611580160902073e-15,-56.525000000000006Z']");
		   // WebElement googleLogo = driver.findElementByXPath("(//*[contains(text(),'Microsoft Internet Infor...')])[2]");
		   // WebElement googleLogo = driver.findElementByXPath("(//div[@id='rsd-exec-net-chart-five']/child::*/child::*/*[@class='arc']/child::*)[1]");
			//  WebElement googleLogo = driver.findElementByXPath("//*[contains(text(),'Unique Vulnerabilities')]");
		 WebElement tool = driver.findElementByXPath("//div[@id='rsd-exec-net-chart-five']/child::*/child::*/child::*/child::*");
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("arguments[0].scrollIntoView()", tool);
		    System.out.println(tool);
		    System.out.println(tool.getLocation());
		    Thread.sleep(5000);
		    driver.executeScript("arguments[0].setAttribute('d', 'M4.785307367668283e-15,-78.15A78.15,78.15 0 0,1 42.328048560855194,65.69443511462661L30.615392769063853,47.516032563714255A56.525000000000006,56.525000000000006 0 0,0 3.4611580160902073e-15,-56.525000000000006Z')", tool);
		    jse.executeScript("$(arguments[0]).hover();", tool);
		 Actions builder = new Actions(driver);
		 int width = tool.getSize().getWidth();
		 int height = tool.getSize().getHeight();
		 System.out.println(width);
		 System.out.println(height);
		 int j = 0;
		 for (int i = 0; i < 20; i++) {
			 System.out.println(i);
			builder.moveByOffset(tool.getLocation().getX()*(height/2), tool.getLocation().getY()*(width/2)).build().perform();
			System.out.println(tool.getLocation().getY()+j);
			j= j+5;
		}
		 builder.moveToElement(tool).build().perform();
//		 builder.sendKeys( tool, Keys.CONTROL).moveByOffset(0, tool.getLocation().getY()).build().perform();
//		 builder.sendKeys(Keys.CONTROL, tool).moveToElement(tool).build().perform();
		  
		    
		/*    
		    System.out.println(googleLogo);
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("arguments[0].scrollIntoView()", googleLogo);
		    Thread.sleep(4000);*/	
	/*	 WebElement WE = driver.findElementByXPath("//div[@id='d3helperTooltip']");
			   
		 Actions builder = new Actions(driver);
		 builder.moveToElement(WE).build().perform();
		  Thread.sleep(3000);
		 Point t=  WE.getLocation();
		 int x=  t.getX();
		  int  y= t.getY();
		  System.out.println("X" +x);
		  System.out.println("Y" +y);*/
		 /* builder.moveToElement(googleLogo).build().perform();
		  builder.doubleClick(googleLogo).build().perform();
		  builder.release(googleLogo).build().perform();
		  Thread.sleep(3000);*/
		 // builder.moveByOffset(x, y).doubleClick(googleLogo).build().perform();
	
		  /* //builder.moveToElement(googleLogo).build().perform();
		  builder.moveByOffset(x, y).build().perform();
		  builder.clickAndHold(googleLogo).perform();
		    builder.moveByOffset(5,5).perform();
		    builder.release(googleLogo);*/
		//	Thread.sleep(3000);	
		  //  mouseOverByXpath("Network.Graph.Xpath");
		/* Actions ToolTip1 = new Actions(driver);
		    WebElement googleLogo = driver.findElementByXPath("//*[@class='pie-slice']");
		    System.out.println(googleLogo);
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("arguments[0].scrollIntoView()", googleLogo);
		   // googleLogo.click();
		  Point t=  googleLogo.getLocation();
		  int x=  t.getX();
		  int  y= t.getY();
		  System.out.println("X" +x);
		  System.out.println("Y" +y);
		    Thread.sleep(2000);
		  //  new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(googleLogo));
		   // action.moveToElement(elementToHover).click(elementToClick).build().perform();
		  //  jse.executeScript("arguments[0].click();", googleLogo);
		    ToolTip1.clickAndHold(googleLogo).moveByOffset(1, 1).pause(2000).build().perform();*/
		   /* ToolTip1.moveByOffset(x, y).build().perform();
		    ToolTip1.moveToElement(driver.findElementByXPath("//*[@class='pie-slice']"), x, y).build().perform();
		    ToolTip1.moveToElement(driver.findElementByXPath("//*[@class='pie-slice']")).perform();
		    ToolTip1.clickAndHold(driver.findElementByXPath("//*[@class='pie-slice']")).build().perform();
		    Thread.sleep(2000);
		    
		    ToolTip1.clickAndHold().moveToElement(googleLogo);					
		    ToolTip1.moveToElement(googleLogo).build().perform();
		    Actions builder = new Actions(driver);
		    builder.clickAndHold(googleLogo).perform();
		    builder.moveByOffset(5,5).perform();
		    builder.release(googleLogo); */    // <--- you need this or else code will hang.
		   // WebElement tooltiplocator = FindElement(By.XPath(tooltip_locator));
		////*[@class='pie-slice']
		  //  String ToolTipText = googleLogo.getText();

		  //  String ToolTipText1 = googleLogo.getAttribute("title");

		  //  Thread.sleep(2000);
		 //   System.out.println("Tooltip value is: " + ToolTipText);
		   // System.out.println("Tooltip value is: " + ToolTipText1);
		 //   ToolTip1.moveToElement(googleLogo).clickAndHold(googleLogo).build().perform();
			// Thread.sleep(2000);
			 
			// JavascriptExecutor jse = (JavascriptExecutor)driver;
	          //  jse.executeScript("document.getElement(By.xpath('//div[@id='d3helperTooltip']/span[2];']').click()");
			/* WebElement tooltext = driver.findElementByXPath("//div[@id='d3helperTooltip']");
		 String try1 =tooltext.getAttribute("textContent");
		 String try2 =tooltext.getAttribute("innerText");
		 String try3 =tooltext.getAttribute("innerHTML");
	System.out.println("a1"+try1);
	System.out.println("a2"+try2);
	System.out.println("a3"+try3);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	 Object text= executor.executeScript("document.getElementById('d3helperTooltip').innerHTML");
	 System.out.println("final"+text);
	 Object text1= executor.executeScript("document.getElementById('d3helperTooltip').innerText");
	 System.out.println("final1"+text1);
	 Object text2= executor.executeScript("document.getElementById('d3helperTooltip').textContent");
	 System.out.println("final2"+text2);*/
		return new NetworkHomePage(driver, test); 
	}
	public String getLowVul(){
		 WebElement LowVulE = findByXpath("Network.Graph.Low.Xpath");
	    
		    System.out.println(LowVulE);
		    scrollToElement(LowVulE);		  

			   
		mouseOverByXpath("Network.Graph.Low.Xpath");
		  
		String Lowvul=  LowVulE.getText();
		System.out.println("Low Unique vulnerabilities is "+Lowvul);
		return Lowvul; 
	}	
	
	
	public String getTotalVul(){
		 WebElement TotalVulE = findByXpath("Network.Graph.Total.Xpath");
	    
		    System.out.println(TotalVulE);
		    scrollToElement(TotalVulE);		  

			   
		mouseOverByXpath("Network.Graph.Total.Xpath");
		  
		String Totalvul=  TotalVulE.getText();
		System.out.println("Total Unique vulnerabilities is "+Totalvul);
		return Totalvul; 
	}	
	
	
	
	public String getHighVul(){
		 WebElement HighVulE = findByXpath("Network.Graph.High.Xpath");
	    
		    System.out.println(HighVulE);
		    scrollToElement(HighVulE);		  

			   
		mouseOverByXpath("Network.Graph.High.Xpath");
		  
		String Highvul=  HighVulE.getText();
		System.out.println("High Unique vulnerabilities is "+Highvul);
		return Highvul; 
	}	
	
	
	public String getMedVul(){
		 WebElement MedVulE = findByXpath("Network.Graph.Medium.Xpath");
	    
		    System.out.println(MedVulE);
		    scrollToElement(MedVulE);		  

			   
		mouseOverByXpath("Network.Graph.Medium.Xpath");
		  
		String Medvul=  MedVulE.getText();
		System.out.println("Medium Unique vulnerabilities is "+Medvul);
		return Medvul; 
	}	
	
	public String getSecurityViewLowVul(){
		String LowvulNum =null;
		 WebElement LowVulE = findByXpath("Network.Graph.Low.Xpath");	    
		    System.out.println(LowVulE);
		    scrollToElement(LowVulE);		  
			   
		    doubleClickByXpath("Network.Graph.Low.Xpath");
		    waitForElementVisibilityBXpath("Vulnerabilities.Text.Xpath");
		 WebElement LowVulText=   findByXpath("Vulnerabilities.Text.Xpath");
		String Lowvul=  LowVulText.getText();
		System.out.println("Low Unique vulnerabilities is "+Lowvul);
		String number= Lowvul.replaceAll("[^0-9.]", "");
		LowvulNum=number.substring(3);
		     System.out.println("Low value is  " +LowvulNum);
		 
		return LowvulNum; 
	}	
	
	
	public String getSecurityViewTotalVul(){
		
	String TotalvulNum =null;
		 WebElement TotalVulE = findByXpath("Network.Graph.Total.Xpath");	    
		    System.out.println(TotalVulE);
		    scrollToElement(TotalVulE);		  			   
		    doubleClickByXpath("Network.Graph.Total.Xpath");
		    waitForElementVisibilityBXpath("Vulnerabilities.Text.Xpath");
		 WebElement TotalVulText=   findByXpath("Vulnerabilities.Text.Xpath");		  
		String Totalvul=  TotalVulText.getText();		
		System.out.println("Total Unique vulnerabilities is "+Totalvul);
		String number= Totalvul.replaceAll("[^0-9.]", "");
		TotalvulNum=number.substring(3);		
		     System.out.println("Total value is  " +TotalvulNum);
		return TotalvulNum; 
	}	
	
	
	
	public String getSecurityViewHighVul(){
		String HighvulNum=null;
		 WebElement HighVulE = findByXpath("Network.Graph.High.Xpath");
	    
		    System.out.println(HighVulE);
		    scrollToElement(HighVulE);		  

			   
		    doubleClickByXpath("Network.Graph.High.Xpath");
		    waitForElementVisibilityBXpath("Vulnerabilities.Text.Xpath");
		 WebElement HighVulText=   findByXpath("Vulnerabilities.Text.Xpath");
		  
		String Highvul=  HighVulText.getText();
		System.out.println("High Unique vulnerabilities is "+Highvul);
		String number= Highvul.replaceAll("[^0-9.]", "");
		HighvulNum=number.substring(3);	
		 System.out.println("High value is  " +HighvulNum);
		return HighvulNum; 
	}	
	
	
	public String getSecurityViewMedVul(){
		String MedvulNum = null;
		 WebElement MedVulE = findByXpath("Network.Graph.Medium.Xpath");
	    
		    System.out.println(MedVulE);
		    scrollToElement(MedVulE);		  

			   
		    doubleClickByXpath("Network.Graph.Medium.Xpath");
		    waitForElementVisibilityBXpath("Vulnerabilities.Text.Xpath");
		 WebElement MedVulText=   findByXpath("Vulnerabilities.Text.Xpath");		  
		String Medvul=  MedVulText.getText();
		System.out.println("Medium Unique vulnerabilities is "+Medvul);
		String number= Medvul.replaceAll("[^0-9.]", "");
		MedvulNum=number.substring(3);	
		 System.out.println("Medium value is  " +MedvulNum);
		return Medvul; 
	}	
	
	public void applyFilter(String Filtername) {
		System.out.println(Filtername);
		clickByXpath("NetWork.Filter.Xpath");
		if(Filtername.equals("hp_path")) {
		clickByXpath("Network.Filter.Hp_path.Xpath");
		}
		else if(Filtername.equals("Test1")) {
			clickByXpath("Network.Filter.Test1.Xpath");
		}
		else if(Filtername.equals("hp_path_2")) {
			clickByXpath("Network.Filter.Hp_path_2.Xpath");
		}
		clickByXpath("NetWork.Filter.Apply.Xpath");
		
	}
}
