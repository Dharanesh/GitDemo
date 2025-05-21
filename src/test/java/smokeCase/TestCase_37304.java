package smokeCase;

import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import action.Login_BKP;
import event.Utils;
import event.Waits;

public class TestCase_37304 extends TestUtils
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
	  	System.out.println("37304---Test Task started........");
	  	//login to the application:==========
	  	test =extent.createTest("TestCase-24670: TestCase For Checking DataMashup For MDXSales");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("======TestCase-24670: TestCase For Checking DataMashup For MDXSales======");
	  	Utils.waitForElement("");
	  	Thread.sleep(2000);
	  	
	  	//Expand Department and open Any Report:=============
	  	log.driver.findElement(By.xpath("//span[text()='Departments']/preceding::span[@class='k-icon k-i-expand'][1]")).click();
	  	Thread.sleep(2000);
	  	
	  	log.driver.findElement(By.xpath("//span[text()='Sales by manufacturers']")).click();
  	  	Utils.waitForElement("");
  		Thread.sleep(3000);
  		Thread.sleep(5000);
  		//Take Count After open:=========================
  	  	List<WebElement> ReportCount=log.driver.findElements(By.xpath("//span[text()='Sales by manufacturers']"));
  	  	
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
  	  			log.driver.findElement(By.xpath("//span[text()='Sales by manufacturers']")).click();
  	  			Utils.waitForElement("");
  	  		}
  	  	Thread.sleep(2000);
	  	//Click on Component Manager and create a DataView:===============
  	  	log.driver.findElement(By.xpath("//span[text()='Components']")).click();
		Utils.waitForElement("");
		
		Actions act=new Actions(log.driver);
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='DataViews']"))).perform();
		Utils.waitForElement("");
		Thread.sleep(2000);
	  	//validate Options in data view:==========
		List<WebElement> OptDataView=log.driver.findElements(By.xpath("//span[text()='DataViews']/following::li/span[1]"));
	  	String[] array= {"Paste","New DataView..."};
		Thread.sleep(2000);
	  	int count=0;
	  	for(int i=0;i<array.length;i++)
	  	{
	  		if(array[i].equals(OptDataView.get(i).getText()))
	  		{
	  			count++;
	  		}
	  	}
	  	System.out.println("Count for Data View options are:->"+count);
	  	Thread.sleep(2000);
	  	Assert.assertEquals(2, count);
	  	System.out.println("All New dataview options are available.");
	  	
	  	log.driver.findElement(By.xpath("(//span[text()='DataViews']/following::li/span)[2]")).click();
		Utils.waitForElement("");
		System.out.println("New DataView link is clicked.");
	 
		//New DataView Window Validation:===============
		log.driver.findElement(By.xpath("//span[text()='New DataView']")).click();
		Utils.waitForElement("");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Please select a DataView type']")).isDisplayed());
		System.out.println("New DataView type window is displaying now.");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Creates a new Cube DataView.']")).isDisplayed());
		System.out.println("Default Text is displaying now.");
		
		//New Data View List Check:==================
		
		List<WebElement> DataViewType=log.driver.findElements(By.xpath("//div[text()='Please select a DataView type']/following::span[@class='reportNametxt']"));
	  	String[] array2= {"Cube DataView","SQL DataView","MDX DataView"};
		Thread.sleep(2000);
	  	int count2=0;
	  	for(int i=0;i<array2.length;i++)
	  	{
	  		if(array2[i].equals(DataViewType.get(i).getText()))
	  		{
	  			count2++;
	  		}
	  	}
	  	System.out.println("Count for Data View Type are:->"+count2);
	  	Thread.sleep(2000);
	  	Assert.assertEquals(3, count2);
	  	System.out.println("All New dataview Type are available.");
		
		//select Cube DataView And Proceed:==============
		log.driver.findElement(By.xpath("(//div[text()='Please select a DataView type']/following::span[@class='reportNametxt'])[1]")).click();
		Utils.waitForElement("");		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);	
	  			
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select Cube']")).isDisplayed());
		System.out.println("Select Cube window is displaying now.");		
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("(//div[text()='Pantara AS2008'])[1]/preceding::div[1]")).click();
		Thread.sleep(2000);	
		
		//Select Sales cube and proceed:===============
		//Check Before Select:====
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Please select a cube!']")).isDisplayed());
		System.out.println("--Please select a cube-- Validate message is displaying now.");		
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//div[text()='Sales']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dimension Selection']")).isDisplayed());
		System.out.println("Dimension Selection window is displaying now.");		
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Settings for the DataView']")).isDisplayed());
		System.out.println("Settings for the DataView window is displaying now.");		
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Assignment of Layout Component']")).isDisplayed());
		System.out.println("Assignment of Layout Component window is displaying now.");		
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Please define at least one Layout Component ')]")).isDisplayed());
		System.out.println("Error message for selecting layout data view is displaying.");		
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(2000);
		
		//Check for button enable/not?:=====================
		int Valcount=0;
		for(int i=0;i<5;i++)
		{
			if(log.driver.findElement(By.xpath("//div[@id='IDDIVBUTTONS']/div/button")).isEnabled())
			{
				Valcount++;
			}
		}
		System.out.println("Enable Buttons are:->"+Valcount);
		Assert.assertEquals(5,Valcount);
		System.out.println("All Buttons are Enabled on Selecting layout window.");
		Thread.sleep(2000);
		
		//Uncheck the checkbox:==============
		log.driver.findElement(By.xpath("//label[text()='Define Layout Components later']")).click();
		Thread.sleep(2000);
		
		int Valcount2=0;
		for(int i=0;i<5;i++)
		{
			if(!(log.driver.findElement(By.xpath("//div[@id='IDDIVBUTTONS']/div/button")).isEnabled()))
			{
				Valcount2++;
			}
		}
		System.out.println("Enable Buttons are:->"+Valcount2);
		Assert.assertEquals(5,Valcount2);
		System.out.println("All Buttons are NOT Enabled on Selecting layout window.");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		//Name and Description window:=====================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		System.out.println("Name and Description window is displaying now.");		
		Thread.sleep(2000);	
		
		//Change the name:===============
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).clear();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("DataView_37304");;
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(2000);
		
		//Click Finish:=====
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(5000);
		
		//Create a New layout as Table and Assign the created ::==================
		log.driver.findElement(By.xpath("//div[text()='Layout Components']")).click();
		Thread.sleep(2000);
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='Layout Components']"))).perform();
		Utils.waitForElement("");
		Thread.sleep(2000);
				
		//Click on Create New Layout:=============
		log.driver.findElement(By.xpath("//span[text()='New Layout Component...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Please select a layout component type']")).isDisplayed());
		System.out.println("New Layout window is displaying now.");		
		Thread.sleep(2000);	
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Inserts a title into the report.']")).isDisplayed());
		System.out.println("Insert Into Title default Text is displaying now.");		
		Thread.sleep(2000);	
		
		//select Table:====
		log.driver.findElement(By.xpath("//span[text()='Table']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Inserts a table into the report.']")).isDisplayed());
		System.out.println("Insert Into table default Text is displaying now.");		
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//button[text()='Assign...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Please select a report component:'])[1]")).isDisplayed());
		System.out.println("Please select report window is displaying now.");		
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()=\"DataView_37304\"]/preceding::div[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(2000);
		
		//Click next and proceed:================
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Layout Component...']")).isDisplayed());
		System.out.println("New Layout Component window is displaying now.");		
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Settings for the layout component']")).isDisplayed());
		System.out.println("Settings for layout component window is displaying now.");		
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//div[text()='Autofit']/following::div[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Formatting for planning/value entry']")).isDisplayed());
		System.out.println("Formatting for planning entry window is displaying now.");		
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		System.out.println("Name and Description window is displaying now.");		
		Thread.sleep(2000);	
		
		//Change the name:===============
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).clear();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("DataView_Table_Layout_37304");;
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(2000);

		//Click Finish:==========
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(5000);
		
		//Click Measure and proceed:====
		log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[7]/span[2]")).click();
		Thread.sleep(5000);
		
		//Select calculated element from drop down list:======================
	    WebElement e2=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act2=new Actions(log.driver);
       // act2.click(e2).sendKeys("Calculated elements", Keys.ENTER).build().perform();
        act2.click(e2).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
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
		log.driver.findElement(By.xpath("//div[@id='1/0']")).click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		
		
		
		
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
		//=getcellvalue(1,1,"MDX-Sales")
		String Value="="+"getcellvalue"+"("+"1"+","+"1"+","+"\""+"MDX-Sales"+"\""+")";
			
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys(Value);
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		String ExptVal=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		
		String ActualVal=log.driver.findElement(By.xpath("(//div[@id='0/0'])[1]")).getText();
		Thread.sleep(2000);
  	 
		Assert.assertEquals(ExptVal, ActualVal);
  	    System.out.println("Mashup Value is Comming properly as expected.");
  	    Thread.sleep(2000);
		
		//Save the report with different name and try to open:==========
  	    //Save As:===============
  
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
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("c8 Cockpit_DataMashup_MDX_Check ");
  		Thread.sleep(2000);
  		
  		//click folder:========
  		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
  		Thread.sleep(5000);
  		//Click Ok Button:============
  		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
  		Thread.sleep(5000);
  		
  		//Delete Report:==================
  		log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit_DataMashup_MDX_Check '])[3]")).click();
  		Thread.sleep(3000);
  		log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit_DataMashup_MDX_Check '])[1]/preceding::input[1]")).click();
  		Thread.sleep(1000);
  		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit_DataMashup_MDX_Check '])[1]"))).perform();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
  		Thread.sleep(2000);
  		
  		log.driver.close();
		
	  	
  }
}
