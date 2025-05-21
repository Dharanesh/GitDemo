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

public class TestCase_25056 extends TestUtils
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
	    System.out.println("25056---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 25056:Cockpit Data Mashup Analytical Viz_Minichart");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("Test Case 25056: Cockpit Data Mashup Analytical Viz_Minichart===================");
	  	Utils.waitForElement("");
	  	
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
  		
  	    //Go For Time and Add only 2014 and 2015 column:===========
  	    //Click on DataView Designer window:================
  	    log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dataview Designer']/following::div[text()='Background'][1]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Data View Designer window is displaying.");
		Thread.sleep(1000);
  		
		//Click Time link in Column:===========
		log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[text()='Time']")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Selection for column window opened now.");
		
		//Remove all base elements:===============
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
  	    Thread.sleep(3000);
		//Select 2014 & 2015:=========
  	    log.driver.findElement(By.xpath("//div[text()='2014']/preceding::div[1]")).click();
	    Thread.sleep(2000);
	    //log.driver.findElement(By.xpath("//div[text()='2015']/preceding::div[1]")).click();
  	   // Thread.sleep(2000);
  	    log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();
	    Thread.sleep(3000);
  	  	
	    //Select calculated element from drop down list:======================
	    WebElement e2=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act=new Actions(log.driver);
        /*act.click(e2).sendKeys("Calculated elements", Keys.ENTER).build().perform();
        Thread.sleep(2000);*/
        act.click(e2).perform();
        /*act.sendKeys("Calculated elements", Keys.ENTER).build().perform();
        Thread.sleep(2000);*/
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
	  	 
        //Check For Mashup Checkbox should be unselect:=====================
	     Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='MASHUP']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("Calculated element check boxs are unchecked.");
		 Thread.sleep(1000);
		
		 //Rank Ascending element should be visible:==================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("MASHUP text is displaying now..");
		
		 //Checkbox should be uncheck and select the checkbox:=============
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='MASHUP']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("MASHUP checkbox is unchecked..");
		 log.driver.findElement(By.xpath("//div[text()='MASHUP']/preceding::div[1]")).click();
		 Thread.sleep(2000);
		
		 log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
		 Thread.sleep(2000);
		 //Click Ok Button:============
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(2000);
	  	
		 //Mashup is Added to the table verify:================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
	 	 Thread.sleep(1000);
		 System.out.println("MASHUP is added in Table.");
		 Thread.sleep(1000);
		 
		//Mashup cell should display write on rightclick opt:=====
		log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).click();
		Thread.sleep(1000);
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).perform();
		Thread.sleep(1000);
		try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed())
			{
				System.out.println("Single data Cell window is displaying.");
				Thread.sleep(1000);
			}
		}catch(Exception e)
		{
			Actions act_a=new Actions(log.driver);
			act_a.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).build().perform();
			Thread.sleep(2000);
		}
		
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Single data Cell window is displaying.");
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Write...']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Write text is displaying.");
		
		//Verify Write window after click on same:===========
		log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Cell Value']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Cell Value window is displaying.");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Please enter a value.']")).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Cancel']")).isEnabled());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Help']")).isEnabled());
		Thread.sleep(1000);
		System.out.println("Write window buttons are enabled.");
		
		//enter input value for mashup cell:===========
		//=getcelvalue(1,1,"Sales")
		String Value="="+"getcellvalue"+"("+"1"+","+"1"+","+"\""+"Sales"+"\""+")";
			
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys(Value);
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		String ExptVal=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		
		String ActualVal=log.driver.findElement(By.xpath("//div[text()='All Customers']/following::div[@id='0/0']")).getText();
		Thread.sleep(2000);
  	 
		Assert.assertEquals(ExptVal, ActualVal);
  	    System.out.println("Mashup Value is Comming properly as expected.");
  	    Thread.sleep(2000);
  		
  	    //Validate after add AV to table:=============
  		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']"))).perform();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).click();
		Thread.sleep(3000);
		
		act.moveToElement(log.driver.findElement(By.xpath("//span[text()='New...']"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='New...']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Analytical Visualization']")).isDisplayed());
		System.out.println("New Analytical Visualization window is displaying now.");
		 
		
	  	String[] AvList={"Threshold","Gradient","In Cell Bar","Minichart"};
	  	List<WebElement> ActAVList=log.driver.findElements(By.xpath("//span[text()='New Analytical Visualization']/following::span[@class='reportNametxt']"));
	  	
	  	int count=0;
	  	for(int i=0;i<AvList.length;i++)
	  	{
	  		if(AvList[i].equals(ActAVList.get(i).getText()))
	  		{
	  			count++;	
	  		}
	  	}
	  	Assert.assertEquals(count,4);
	  	System.out.println("All New Analytical Visualization types are available.");
		
	    //Check for Default:=============
	  	Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Creates a new threshold analysis.']")).isDisplayed());
		System.out.println("Default New Analytical Visualization window is displaying now.");
	  	
		//Select Gradient and proceed:=======
		log.driver.findElement(By.xpath("//span[text()='Minichart']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Creates a new minichart.']")).isDisplayed());
		System.out.println("Av as minichart is selected."); 
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Settings for the Minichart'])[1]")).isDisplayed());
		System.out.println("Minichart Settings window is displaying now."); 
		Thread.sleep(1000);
		
		//Enter Caption and proceed:=================
		log.driver.findElement(By.xpath("//div[text()='Caption']/following::input[1]")).clear();
		log.driver.findElement(By.xpath("//div[text()='Caption']/following::input[1]")).sendKeys("Datamashup Visualization ");
		Thread.sleep(2000);
		
		//Select Bar as Type:=================
		WebElement Type=log.driver.findElement(By.xpath("//div[text()='Type']/following::span[1]"));
        Actions TypeAct=new Actions(log.driver);
        TypeAct.click(Type).sendKeys("Bar", Keys.ENTER).build().perform();
        Thread.sleep(2000);
		
       //Validate Meesage after click on link:========
  		log.driver.findElement(By.xpath("//div[text()='Type']")).click();
  		Thread.sleep(1000);
  		log.driver.findElement(By.xpath("//div[text()='Type']")).click();
  		Thread.sleep(2000);
  		
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//p[text()='Type']")).isDisplayed());
  		System.out.println("After click on link,respected message is displaying."); 
  		Thread.sleep(2000);
        
        //Click Height largest value check box:===============
  		log.driver.findElement(By.xpath("//div[text()='Highlight largest value']")).click();
  		Thread.sleep(1000);
        
  		if(!(log.driver.findElement(By.xpath("//div[text()='Highlight largest value']/following::label[1]")).isSelected()))
  		{
  			log.driver.findElement(By.xpath("//div[text()='Highlight largest value']/following::div[1]")).click();
  			Thread.sleep(1000);
  		}
  		else
  		{
  			System.out.println("Highlight largest value checkbox is selected.");
  		}
  		Thread.sleep(3000);
  		
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Highlight largest value']/following::input[1]")).isSelected());
  		
  		//Highest value should display:===========
  		Assert.assertEquals(log.driver.findElement(By.xpath("//input[@value='(0;147;0)']")).isDisplayed(),true);
  		Thread.sleep(1000);
  		
  		//Lowest also validate:==============
  		log.driver.findElement(By.xpath("//div[text()='Highlight smallest value']")).click();
  		Thread.sleep(1000);
  		if(!(log.driver.findElement(By.xpath("//div[text()='Highlight smallest value']/following::label[1]")).isSelected()))
  		{
  			log.driver.findElement(By.xpath("//div[text()='Highlight smallest value']/following::div[1]")).click();
  			Thread.sleep(1000);
  		}
  		else
  		{
  			System.out.println("Highlight smallest value checkbox is selected.");
  		}
  		Thread.sleep(2000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Highlight smallest value']/following::input[1]")).isSelected());
  		
  		//Highest value should display:===========
  		Assert.assertEquals(log.driver.findElement(By.xpath("//input[@value='(255;0;0)']")).isDisplayed(),true);
  		
  		//Click Next:==========
  		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
  		
		//Name & Description window:========
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Minichart  Mashup analysis ");
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(2000);
		
		//Click On Finish Button:==============
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(2000);
		
		//Allocation window:=====================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Assignment')]")).isDisplayed());
		System.out.println("Assignment window is displaying."); 
		
		log.driver.findElement(By.xpath("//a[contains(text(),'Allocation')]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//div[text()='MASHUP'])[1]")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//a[contains(text(),'Data area')]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//div[@id='-1/-1'])[2]")).click();
		Thread.sleep(1000);
		
		/*Robot a=new Robot();
		a.keyPress(KeyEvent.VK_CONTROL);*/
		
	   /*log.driver.findElement(By.xpath("(//div[@id='-1/-1'])[2]")).click();
		Thread.sleep(1000);*/
		
	/*	a.keyRelease(KeyEvent.VK_CONTROL);  
		Thread.sleep(1000);*/
		
		log.driver.findElement(By.xpath("//input[@value='Apply']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(2000);
		
		//Validate after apply Filters:=================
		log.driver.findElement(By.xpath("//div[@id='1/-1']")).click();
		Thread.sleep(2000);
		
		//Issue in Whole table:==============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[@id='1/0']/img[1]")).isDisplayed());
		System.out.println("minichart bar is displaying on report."); 
		
		System.out.println("Testcase-25056 Verified.");
		
		log.driver.close();
		
  }
  
}
