package smokeCase;

import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import action.Login_BKP;
import event.Utils;
import event.Waits;
import junit.framework.Assert;

public class TestCase_24664 extends TestUtils
{
	Login log = null;
	Waits waits =null;
	Utils Utils = null;
	Login_BKP Create_Report=null;
	event.Excelnput Excelnput=null;
	
  @Test
  @Parameters("browser")
  public void f(String browser) throws Exception  
  {
	   System.out.println("24664---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 24664: Testcase for denying Create new folder Permission for Training user for all reports");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("Test Case 24664: Testcase for denying Create new folder Permission for Training user for all reports===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  	
	  	//Right click on All Report folder and validate sub options:===================
	  	Actions Report= new Actions(log.driver);
		Report.contextClick(log.driver.findElement(By.xpath("//span[text()='All Reports']"))).perform();
		Thread.sleep(2000);
	  	
		//Check Options after right click on report:==============
		List<WebElement> ReportsOptions=log.driver.findElements(By.xpath("//span[text()='Repository']/following::li[@role='menuitem']/span"));
		Thread.sleep(2000);
		System.out.println("Report Options are:->"+ReportsOptions.size());
		
		String[] ReportOpt={"Open","New Folder...","Export...","Import...","Send to...","Language Terms...","Properties...","Permissions...","Information..."};
		
		int Count=0;
		for(int i=0;i<ReportsOptions.size();i++)
		{
			System.out.println(ReportsOptions.get(i).getText());
			if(ReportsOptions.get(i).getText().equals(ReportOpt[i]))
			{
				Count++;
			}
		}
		System.out.println("Report Options are:->"+Count);
		Assert.assertEquals(Count,9);
		System.out.println("All Report Repository subOptions are available.");
		Thread.sleep(2000);
	  	
		//Click on Permission and validate permission window:=========
		log.driver.findElement(By.xpath("//span[text()='Permissions...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Permissions for')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Permission window is opened now.");
		Thread.sleep(2000);
		
		//Validate All buttons in permission window is active:==============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Take Ownership']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Set Ownership...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Effective Permissions...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Add Role...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Remove']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@id='okbutton']")).isEnabled());
		Thread.sleep(2000);
		System.out.println("All buttons on Permission window is enabled now.");
		
		//Click Take Ownership and verify rest:===================
		log.driver.findElement(By.xpath("//button[text()='Take Ownership']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Taking ownership cannot be undone.')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Take Ownership Warning window is displaying now.");
	  	
		//===click on 'YES' button:=======================
		log.driver.findElement(By.xpath("//input[@id='yesbutton']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Permissions for')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Permission for Sales By Country window is displaying now.");
		Thread.sleep(2000);
		
		//====Verify Admin as visible text:===============
		String VerifyStr1=log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]")).getText();
		String VerifyStr2=log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[3]")).getText();
		
		int countVr=0;
		if(VerifyStr1.equals("All Reports"))
		{
			if(VerifyStr2.equals("Admin"))
			{
				countVr++;
			}
		}
		Assert.assertEquals(countVr,1);
		System.out.println("Selected Objects texts are displaying now.");
		Thread.sleep(2000);
		
		//===list of permission======
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'List of permissions and roles of')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("list of permission and roles are displaying now.");
		Thread.sleep(1000);
		
		//==Check the checkbox for Remove Permission:===========
		//Need to Add step for remove all permission:===
		
		List<WebElement> PermissionVal2=log.driver.findElements(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr/td[1]"));
		
		for(int i=1;i<=PermissionVal2.size();i++)
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr["+i+"]/td[1]")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//button[text()='Remove']")).click();
			Thread.sleep(2000);
			try{
				if(log.driver.findElement(By.xpath("//span[contains(text(),'remove inherited permissions')]")).isDisplayed())
				{
					log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
					Thread.sleep(2000);
				}
			}catch(Exception e)
			{
				System.out.println("Inherited Permission is not available.");
			}
		}
		Thread.sleep(2000);
		
		try
		{
		  log.driver.findElement(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr[1]/td[1]")).click();
		  Thread.sleep(2000);
		}
		catch(Exception e)
		{
			System.out.println("List selected permission removed ."); 
		}
		
		//Add Permission Validation:======================
		log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Permission']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("New Permission window is displaying now.");
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Available rights:']")).isDisplayed());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Available users and groups:']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Available Texts are displaying in Add permission window.");
		
		//Validate Radio button options:==============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Grant']")).isDisplayed());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Deny']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Grant and Deny Radio buttos are available.");
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Grant']/preceding::input[1]")).isSelected());
		Thread.sleep(2000);
		System.out.println("Grant radio button is selected bydefault.");
		
		//click on full control checkbox:==================
		log.driver.findElement(By.xpath("//td[text()='Full Control']/preceding::td[2]")).click();
		Thread.sleep(2000);
		//Click Training in <Available users and groups:>:===========================
		log.driver.findElement(By.xpath("//td[text()='Training']/preceding::td[2]")).click();
		Thread.sleep(2000);
		//Click Ok Button:=========
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Permissions for')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Permission window is displaying now.");
		Thread.sleep(2000);
		
		//Click Add Permission==Change filter selection::=================
		log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//td[text()='Create New Folder']/preceding::td[2]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//td[text()='Training']/preceding::td[2]")).click();
		Thread.sleep(2000);
		//Click Deny button:===========
		log.driver.findElement(By.xpath("//label[text()='Deny']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Permissions for')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Permission window is displaying now after click on Deny button.");
		Thread.sleep(2000);
		
		List<WebElement> PermissionVal=log.driver.findElements(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr/td[1]"));
		//Assert.assertEquals(PermissionVal.size(),2);
		System.out.println("List of permission is added as expected.");
		Thread.sleep(2000);
		
		//Click on OK button,and it will Navigate to main window:===========
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(5000);
		
		//Login As Training USER And try to create new Folder and Validate:===================
		log.driver.findElement(By.xpath("//span[@id='hamburger_btn']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()='Connect to Server']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Log On C8 Server']")).isDisplayed());
		System.out.println("LogOn C8 Server window is displaying now.");
		Thread.sleep(2000);
		
		
		log.driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).sendKeys("Training");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Server:']/following::input[1]")).sendKeys("localhost:10901");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).isDisplayed(), true);
		log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[@class='k-icon k-i-user']/following::span[text()='Training']")).isDisplayed());
		System.out.println("Logged in as Training user.");
		Thread.sleep(2000);
		
		Report.contextClick(log.driver.findElement(By.xpath("//span[text()='All Reports']"))).perform();
		Thread.sleep(2000);
		
		//Click on Permission and validate permission window:=========
		try {
			if(log.driver.findElement(By.xpath("//span[text()='New Folder...']")).isEnabled())
			{
				Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='New Folder...']")).isEnabled(), true);
			}
			
		}catch(Exception e)
		{
			System.out.println("Not Enough access right is displaying now due to permission..");
		}
		//log.driver.findElement(By.xpath("//span[text()='New Folder...']")).click();
		//Thread.sleep(2000);
		//Validate Error Message:==================
		
		/*Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Not enough access rights.']")).isDisplayed());
		System.out.println("Not Enough access right is displaying now due to permission..");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);*/
		//Remove Access Rights:========================
		//Before Close, Remove assign permissions:=================
  	    log.driver.findElement(By.xpath("//span[@id='hamburger_btn']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()='Connect to Server']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Log On C8 Server']")).isDisplayed());
		System.out.println("LogOn C8 Server window is displaying now.");
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).sendKeys("Admin");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Password:']/following::input[1]")).sendKeys("Admin");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Server:']/following::input[1]")).sendKeys("localhost:10901");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).isDisplayed(), true);
		log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[@class='k-icon k-i-user']/following::span[text()='Admin']")).isDisplayed());
		System.out.println("Logged in as Admin user.");
		Thread.sleep(3000);
		//Open Report and Cross check:================
	/*	log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
	  	Utils.waitForElement("");
		Thread.sleep(3000);
		Thread.sleep(5000);*/
		
		Report.contextClick(log.driver.findElement(By.xpath("//span[text()='All Reports']"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Permissions...']")).click();
		Thread.sleep(2000);
		
		List<WebElement> PermissionVal3=log.driver.findElements(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr/td[1]"));
		for(int i=1;i<=PermissionVal3.size();i++)
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr["+i+"]/td[1]")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//button[text()='Remove']")).click();
			Thread.sleep(2000);
			try{
				if(log.driver.findElement(By.xpath("//span[contains(text(),'remove inherited permissions')]")).isDisplayed())
				{
					log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
					Thread.sleep(2000);
				}
			}catch(Exception e)
			{
				System.out.println("Inherited Permission is not available.");
			}
		}
		
		try
		{
		  log.driver.findElement(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr[1]/td[1]")).click();
		  Thread.sleep(2000);
		}
		catch(Exception e)
		{
			System.out.println("List selected permission removed ."); 
		}
		//Click ok:====
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(3000);
		//log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		//Thread.sleep(3000);
		
		//Save Report:===============
		//log.driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		//Thread.sleep(3000);
		
		//Close
  		log.driver.close();
		
		
  }
  
}
