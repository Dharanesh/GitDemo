package smokeCase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class TestCase_26340 extends TestUtils
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
	    System.out.println("26340---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 26340:");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("Test Case 26340: Scenario 2 Testcase :11109 Cockpit Export PDF with User-defined placeholders in Header and Footer===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  
	  	//Verify Navigator window on the Left side:=======
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Navigator']")).isDisplayed());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Navigator']/following::div[1]")).isDisplayed());
		Thread.sleep(2000);
	    System.out.println("Navigator window is displaying now.");
	    
	    //Verify the Status bar :==================================
	    Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='<neutral>'])[1]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Neutral language is displaying now on button of report.");
	    
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
		List<WebElement> ReportsOptions=log.driver.findElements(By.xpath("(//span[text()='Report'])[2]/following::li[@class='k-item k-state-default w20_menuitem']"));
		Thread.sleep(2000);
		System.out.println("Report Options are:->"+ReportsOptions.size());
		
		String[] ReportOpt={"Open","Add to Favorite Folder","Duplicate","Rename","Delete","Move...","Export...","Send to...","Language Terms...","Description...","Properties...","Print and Export Settings..."};
		
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
		Assert.assertEquals(Count,12);
		System.out.println("All Report Options are available.");
		Thread.sleep(2000);
		
		//log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[1]")).click();
		//Thread.sleep(2000);
		
		//Select >>'Print and Export Settings':============================
		
	    //Report.contextClick(log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[1]"))).perform();
		//Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Report'])[2]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Print and Export Settings...']")).click();
		Thread.sleep(2000);
		
		//Validate After click print and export Setting:=========
	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Print settings for')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Print and export Setting window is displaying now.");
		
		//Language Symbol which is next to the Title field::=========================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[@data-title='Language terms']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Language Terms title field is displaying now.");
		Thread.sleep(1000);
		
		//Click on Language Button field:============
		log.driver.findElement(By.xpath("//button[@data-title='Language terms']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Title'])[1]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Language Title field is displaying now.");
		Thread.sleep(1000);
		
		//Enter Language Value:===============
	    //Sales By country Neutral field try:==========
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='<neutral>'])[1]/following::input[1]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Sales By country Neutral field is displaying now.");
		Thread.sleep(1000);
		//Enter Sales By Country Value and click on Ok Button:==================
		log.driver.findElement(By.xpath("(//span[text()='<neutral>'])[1]/following::input[1]")).sendKeys("sales By country NU");
		Thread.sleep(3000);
		
		log.driver.findElement(By.xpath("(//span[text()='<neutral>'])[1]/following::input[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Title'])[1]")).click();
		Thread.sleep(2000);
		
		//Click Ok Button:==============
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(3000);
		
		//Check Return Back to title Field and name:============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Title'])[1]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Title window is displaying after click ok Button.");
		Thread.sleep(1000);
		
		String TitleValue=log.driver.findElement(By.xpath("(//span[text()='Title'])[1]/following::input[1]")).getAttribute("value");
		System.out.println("Title Value is:->"+TitleValue);
		Thread.sleep(1000);
		
		Assert.assertEquals("sales By country NU",TitleValue);
		System.out.println("Sales By Country Report Title is displaying properly.");
		Thread.sleep(1000);
		
		//DiSelect>>Use Current print Template check box:==================
		
		if(log.driver.findElement(By.xpath("//label[text()='Use current print template']/preceding::input[1]")).isSelected())
		{
			Thread.sleep(2000);
			System.out.println("Check box is selected,need to uncheck.");
			log.driver.findElement(By.xpath("//label[text()='Use current print template']")).click();
			Thread.sleep(2000);
		}else
		{
			System.out.println("Check box is unchecked.");
		}
		
		//Select User defined Template now:======================================
		log.driver.findElement(By.xpath("//label[text()='Use current print template']/following::span[1]")).click();
		Thread.sleep(3000);
		
		 Actions act = new Actions(log.driver);
	     act.sendKeys(Keys.chord(Keys.DOWN,Keys.DOWN)).perform();
	     Thread.sleep(2000);
	     act.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(2000);
		
		//Click on Button Adjust and perform :============================
		log.driver.findElement(By.xpath("//button[text()='Adjust...']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Print Template']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Print Template window is displaying now.");
		
		//Click on Header tab:==========
		log.driver.findElement(By.xpath("//a[text()='Header']")).click();
		Thread.sleep(2000);
		
		//Need to DeSelect Show header tab:===============
		if(log.driver.findElement(By.xpath("//label[text()='Show header']/preceding::input[1]")).isSelected())
		{
			Thread.sleep(2000);
			System.out.println("Show header Tab,need to uncheck.");
			log.driver.findElement(By.xpath("//label[text()='Show header']")).click();
			Thread.sleep(2000);
		}else
		{
			System.out.println("Show header Tab is unchecked.");
		}
		
		//Check Format Field need to deselect fst:==============
		Assert.assertEquals(false,log.driver.findElement(By.xpath("(//span[text()='Format:'])[1]/following::input[1]")).isEnabled());
		Thread.sleep(2000);
		System.out.println("Format Field is not enabled after Unchecked show header checkbox.");
		Thread.sleep(2000);
		
		//Need to find show header check box is Select then check format field is active/not:=================
		log.driver.findElement(By.xpath("//label[text()='Show header']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Format:'])[1]/following::input[1]")).isEnabled());
		Thread.sleep(2000);
		System.out.println("Format Field is enabled after Unchecked show header checkbox.");
		Thread.sleep(2000);
		
		//observe that all text, format and Image fields can be extended by clicking :=======================
		log.driver.findElement(By.xpath("(//span[text()='Text:'])[1]/following::button[@id='w_502']")).click();
		Thread.sleep(2000);
		//check for specify text after click ,check and validate:================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Specify Text']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Specify text is displaying now.");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		//Observe image side dot button and Validate:==============
		log.driver.findElement(By.xpath("(//span[text()='Image left'])[1]/following::button[@id='w_508']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Image Manager']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Image Manager Text is displaying now.");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Print Template']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Print Template window is displaying now.");
		
		//========Font Selection window:=========
		log.driver.findElement(By.xpath("(//span[text()='Format:'])[1]/following::button[@id='w_506']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Font selection']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Font Selection window is displaying now.");
		
		//Font Selection window work:===============
		log.driver.findElement(By.xpath("//span[text()='Font:']/following::span[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Font:']/following::span[1]")).click();
		Thread.sleep(1000);
		//===========Font Size======
		log.driver.findElement(By.xpath("//span[text()='Font size:']/following::input[1]")).clear();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Font size:']/following::input[1]")).sendKeys("10");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Font size:']/following::input[1]")).click();
		Thread.sleep(5000);
		
		//===Font Color:========
		log.driver.findElement(By.xpath("//button[text()='Font color']")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//button[text()='Font color']")).click();
		Thread.sleep(3000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select color']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Select Color window is displaying now.");
		 
		//Select Color and click Ok:================
		log.driver.findElement(By.xpath("//table[@class='w20_dlgcolor']/tbody[1]/tr[1]/td[5]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Arial,10,#00005e']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Able to Select Color in select color window.");
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Print Template']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Print Template window is displaying now.");
		
		//select Text format and validate:=================
		log.driver.findElement(By.xpath("(//span[text()='Text:'])[1]/following::button[@id='w_502']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Specify Text']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Specify text is displaying now.");
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//span[text()='Text:']/following::input[@id='w_661']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Text:']/following::input[@id='w_661']")).clear();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Text:']/following::input[@id='w_661']")).clear();
		Thread.sleep(2000);
		//===========Add some PlaceHolder:=============
		log.driver.findElement(By.xpath("//td[text()='<yy>']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//button[text()='Insert Placeholder']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//td[text()='<time>']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//button[text()='Insert Placeholder']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Print Template']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Print Template window is displaying now.");
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Text:'])[1]/following::input[@value='<yy><time>']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selected place holder is displaying for text area.");
		Thread.sleep(1000);
		
		//=============
		//Getting Issue with placeHolder:=================
		
		
		
		//=========================================
		
		
		
		
		
		
		
		
		
	  
  }
  
}
