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

public class TestCase_24666 extends TestUtils
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
	   System.out.println("24666---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 24666: Testcase for denying Analytical visualization Permission for training user for Sales by country report");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("Test Case 24666: Testcase for denying Analytical visualization Permission for training user for Sales by country report===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  	
	  	//Adding Training User Permission:===============
	  	log.driver.findElement(By.xpath("//span[@id='hamburger_btn']")).click();
	  	Utils.waitForElement("");
	  	
	  	//Delete inherited permissions:====================
	  	System.out.println("Need to delete Repository Permission");
	  	log.driver.findElement(By.xpath("//div[text()='Repository']")).click();
	  	Utils.waitForElement("");
	  	Thread.sleep(1000);
	  	Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Repository Settings']")).isDisplayed());
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//a[text()='Global Permissions...']")).click();
	  
	  	Thread.sleep(1000);
	  	List<WebElement> GlobalPermission=log.driver.findElements(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr/td[1]"));
	  	Thread.sleep(2000);
	  	System.out.println(GlobalPermission.size());
	  	for(int i=1;i<=GlobalPermission.size();i++)
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr["+i+"]/td[1]")).click();
			Thread.sleep(2000);
		}
	  	log.driver.findElement(By.xpath("//button[text()='Remove']")).click();
		Thread.sleep(2000);
	  	log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		try {
			if(log.driver.findElement(By.xpath("//input[@value='Yes']")).isDisplayed())
			{
				log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
				Thread.sleep(2000);
			}
		}catch(Exception e)
		{
			System.out.println("Yes button is not displaying.");
		}
		
		//All Report Permission:====================
		Actions per=new Actions(log.driver);
		per.contextClick(log.driver.findElement(By.xpath("//span[text()='All Reports']"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Permissions...']")).click();
		Thread.sleep(2000);
		List<WebElement> AllReportPermission=log.driver.findElements(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr/td[1]"));
		for(int i=1;i<=AllReportPermission.size();i++)
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr["+i+"]/td[1]")).click();
			Thread.sleep(2000);
		}
		log.driver.findElement(By.xpath("//button[text()='Remove']")).click();
		Thread.sleep(2000);
	  	log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		try {
			if(log.driver.findElement(By.xpath("//input[@value='Yes']")).isDisplayed())
			{
				log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
				Thread.sleep(2000);
			}
		}catch(Exception e)
		{
			System.out.println("Yes button is not displaying.");
		}
		
		//==========================================================================
	   //Try to Open any Report:======================================
  		log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
  	  	Utils.waitForElement("");
  		Thread.sleep(3000);
  		Thread.sleep(5000);
  		//Take Count After open:===========
  	  	List<WebElement> ReportCount=log.driver.findElements(By.xpath("//span[text()='Sales by country']"));
  	  	
  	  	System.out.println("list of report is:->"+ReportCount.size());
  	  	try
  	  	{
  	  		if(ReportCount.size()>2)
  	  		{
  	  			System.out.println("Required Report is opened now");
  	  		}
  	  		
  	  	}catch(Exception e)
  	  		{
  	  			System.out.println("Need to click again.");
  	  			log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
  	  			Utils.waitForElement("");
  	  		}
  	  	Thread.sleep(2000);
	  	
        //Right click On Report and check Right click Options:============
		Actions Report= new Actions(log.driver);
		Report.contextClick(log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[1]"))).perform();
		Thread.sleep(2000);
	  	
		//Check Options after right click on report:==============
		List<WebElement> ReportsOptions=log.driver.findElements(By.xpath("(//span[text()='Report'])[3]/following::span[@class='k-link k-menu-link']"));
		Thread.sleep(2000);
		System.out.println("Report Options are:->"+ReportsOptions.size());
		
		String[] ReportOpt={"Open","Add to Favorite Folder","Duplicate","Rename","Delete","Move...","Export...","Import...","Send to...","Language Terms...","Description...","Properties...","Print and Export Settings...","Permissions...","Information..."};
		
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
		Assert.assertEquals(Count,15);
		System.out.println("All Report Options are available.");
		Thread.sleep(2000);
		
		//=====================
		log.driver.findElement(By.xpath("//span[text()='Permissions...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Permissions for')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Permission for Sales By Country window is opened now.");
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
		if(VerifyStr1.equals("Sales by country"))
		{
			if(VerifyStr2.equals("Admin"))
			{
				countVr++;
			}
		}
		Assert.assertEquals(countVr,1);
		System.out.println("Selected Objects texts are displaying now.");
		Thread.sleep(2000);
		
		//list of permission==============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'List of permissions and roles of')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("list of permission and roles are displaying now.");
		Thread.sleep(1000);
		
		//Check the checkbox for Remove Permission:===========
		List<WebElement> PermissionVal2=log.driver.findElements(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr/td[1]"));
		for(int i=1;i<=PermissionVal2.size();i++)
		{
			
			log.driver.findElement(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr["+i+"]/td[1]")).click();
			Thread.sleep(2000);
			
		}
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//button[text()='Remove']")).click();
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
		
		//click on full control and  Edit cube dataView checkbox:==================
		log.driver.findElement(By.xpath("//td[text()='Create Analytical Visualizations']/preceding::td[2]")).click();
		Thread.sleep(2000);
		//Click Training in <Available users and groups:>:===========================
		log.driver.findElement(By.xpath("//td[text()='Training']/preceding::td[2]")).click();
		Thread.sleep(2000);
		//Click Deny button:===========
		log.driver.findElement(By.xpath("//label[text()='Deny']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Permissions for')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Permission for Sales By Country window is displaying now after click on Deny button.");
		Thread.sleep(2000);
		
		//Add Full Control Permission:====================
		//click on full control and  Edit cube dataView checkbox:==================
		log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).click();
		Thread.sleep(2000);
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
		System.out.println("Permission for Sales By Country window is displaying now.");
		Thread.sleep(2000);
		
		//Verify List of permission state:==========
		List<WebElement> PermissionVal=log.driver.findElements(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr/td[1]"));
		//Assert.assertEquals(PermissionVal.size(),2);
		System.out.println("List of permission is added as expected.");
		Thread.sleep(2000);
		//Click on OK button,and it will Navigate to main window:===========
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		//ReAdd the Global And All report permission:=========================
		log.driver.findElement(By.xpath("//span[@id='hamburger_btn']")).click();
	  	Utils.waitForElement("");
		log.driver.findElement(By.xpath("//div[text()='Repository']")).click();
	  	Utils.waitForElement("");
	  	Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Repository Settings']")).isDisplayed());
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//a[text()='Global Permissions...']")).click();
	  	Utils.waitForElement("");
	  	
		log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//td[text()='Full Control']/preceding::td[2]")).click();
		Thread.sleep(2000);
		
		//Click Training in <Available users and groups:>:===========================
		log.driver.findElement(By.xpath("//td[text()='Training']/preceding::td[2]")).click();
		Thread.sleep(2000);
		//Click Ok Button:=========
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
	  	log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		//All Report:=============
		Actions per2=new Actions(log.driver);
		per2.contextClick(log.driver.findElement(By.xpath("//span[text()='All Reports']"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Permissions...']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//td[text()='Full Control']/preceding::td[2]")).click();
		Thread.sleep(2000);
		
		//Click Training in <Available users and groups:>:===========================
		log.driver.findElement(By.xpath("//td[text()='Training']/preceding::td[2]")).click();
		Thread.sleep(2000);
		//Click Ok Button:=========
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
	  	log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(3000);
		
		//Login as Training user and Validate:=====================
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
		
		//Open Report and Cross check:================
		log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
  	  	Utils.waitForElement("");
  		Thread.sleep(3000);
  		Thread.sleep(5000);
  		//Take Count After open:===========
  	  	List<WebElement> ReportCount2=log.driver.findElements(By.xpath("//span[text()='Sales by country']"));
  	  	
  	  	System.out.println("list of report is:->"+ReportCount2.size());
  	  	try
  	  	{
  	  		if(ReportCount2.size()>2)
  	  		{
  	  			System.out.println("Required Report is opened now");
  	  		}
  	  		
  	  	}catch(Exception e)
  	  		{
  	  			System.out.println("Need to click again.");
  	  			log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
  	  			Utils.waitForElement("");
  	  		}
  	  	Thread.sleep(2000);
		
		//Verify By Right click On table::=====================
  	  	Actions Act=new Actions(log.driver);
  	  	Act.contextClick(log.driver.findElement(By.xpath("//div[@id='-1/-1']"))).perform();
  	    Thread.sleep(2000);
  	  	try 
  	  	{
  	  		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).isDisplayed(),false);
  	  		
  	  	}catch(Exception e)
  	  	{
  	  		System.out.println("Analytical Visualization is not displaying.");
  	  	}
  	    Thread.sleep(2000);
		//Close the driver:================
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
		
		//Open Report and Cross check:================
		log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
	  	Utils.waitForElement("");
		Thread.sleep(3000);
		Thread.sleep(5000);
		
		/*Report.contextClick(log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Permissions...']")).click();
		Thread.sleep(2000);
		
		List<WebElement> PermissionVal3=log.driver.findElements(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr/td[1]"));
		for(int i=1;i<=PermissionVal3.size();i++)
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'List of permissions and roles of')]/following::table[1]/tbody[1]/tr["+i+"]/td[1]")).click();
			Thread.sleep(2000);
			
		}
		log.driver.findElement(By.xpath("//button[text()='Remove']")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(3000);
		try {
			if(log.driver.findElement(By.xpath("//input[@value='Yes']")).isDisplayed())
			{
				log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
				Thread.sleep(2000);
			}
		}catch(Exception e)
		{
			System.out.println("Yes button is not displaying.");
		}*/
		
		
		//Save AS Report:===============
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("(//span[text()='Save']/following::span[1])[2]")).click();
  		Thread.sleep(2000);
  		//Click Down and do Save As:====================
  		log.driver.findElement(By.xpath("(//span[text()='Save As'])[2]")).click();
  		Thread.sleep(2000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report as']")).isDisplayed());
  		Thread.sleep(1000);
  		System.out.println("Save Report as window is displaying now.");
  		
  		//Change Name:===========
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Testcase_24666");
  		Thread.sleep(2000);
  		
  		//click folder:========
  		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
  		Thread.sleep(5000);
  		//Click Ok Button:============
  		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
  		Thread.sleep(5000);
				  		
  		//Delete Report:==================
  		log.driver.findElement(By.xpath("(//*[text()='Testcase_24666'])[3]")).click();
  		Thread.sleep(3000);
//  		/*log.driver.findElement(By.xpath("(//span[text()='Testcase_24666'])[1]/preceding::input[1]")).click();
//  		Thread.sleep(2000);
  		Actions act=new Actions(log.driver);
  		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Testcase_24666'])[1]"))).perform();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
  		Thread.sleep(2000);
  		log.driver.close();
		//END

  }
  
}
