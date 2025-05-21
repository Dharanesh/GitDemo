package smokeCase;

import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class TestCase_25048 extends TestUtils
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
	    System.out.println("25048---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 25048:");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("Test Case 25048: Cockpit Data Mashup Criteria DDL===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  	
	  	 //Try to Open any Report i.e->"Contribution margin exotic":======================================
  		log.driver.findElement(By.xpath("//span[text()='Contribution margin exotic']")).click();
  	  	Utils.waitForElement("");
  		Thread.sleep(3000);
  		Thread.sleep(5000);
  		//Take Count After open:===========
  	  	List<WebElement> ReportCount=log.driver.findElements(By.xpath("//span[text()='Contribution margin exotic']"));
  	  	
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
  	  			log.driver.findElement(By.xpath("//span[text()='Contribution margin exotic']")).click();
  	  			Utils.waitForElement("");
  	  		}
  	  	Thread.sleep(2000);
	  	
  	  	//Data View Designer window should open:===============
  		//Click on DataView Designer window:================
  	    log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dataview Designer']/following::span[text()='Background'][2]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Data View Designer window is displaying.");
		Thread.sleep(1000);
		
		//Product on Row Dimension:==================
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Rows']/following::span[text()='Product']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Product is displaying in Row area.");
		
		//Time As Column:==============
		log.driver.findElement(By.xpath("//span[text()='Columns']/following::span[text()='Time']")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Selection for column window opened now.");
		
		//Remove all elemnts:============
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
  	    Thread.sleep(3000);
		
  	    //Expand 2014:==============
  	    log.driver.findElement(By.xpath("//div[text()='2014']/preceding::div[2]")).click();
  	    Thread.sleep(1000);
		List<WebElement> Column=log.driver.findElements(By.xpath("//span[text()='Selectable elements:']/following::div[contains(text(),'2014')]/preceding::div[1]/label[1]"));
  	    
		System.out.println(Column.size());
		
		for(int i=1;i<=Column.size();i++)
		{
			log.driver.findElement(By.xpath("(//div[contains(text(),'2014')]/preceding::div[1])["+i+"]")).click();
		}
		Thread.sleep(1000);
		
		//Click To right symbol:==========
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();
  	    Thread.sleep(2000);
  	    //Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(2000);
		
		//Product Row Click and perform next:==================
		log.driver.findElement(By.xpath("//span[text()='Rows']/following::span[text()='Product']")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Selection for Row window opened now.");
		
		 //Element group Button:=================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled());
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		 Thread.sleep(1000);
		 
		 //Validate Elements group window:==========
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isEnabled());
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Groups']")).isEnabled());
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Elements']")).isEnabled());
		 Thread.sleep(2000);
		 
		 List<WebElement> ContainerElements=log.driver.findElements(By.xpath("//span[text()='Groups']/following::div[3]/div[1]/div[1]/ul/li/div/span/span[2]"));
		 Assert.assertEquals(ContainerElements.size(),4);
		 System.out.println("All Container elements are available.");
		 
		 //Select Container Element:======
		 log.driver.findElement(By.xpath("(//span[text()='Container elements'])[1]")).click();
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='New...']")).isEnabled());
		 Thread.sleep(2000);
		
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//button[text()='Edit...']")).isEnabled());
		 Thread.sleep(2000);
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//button[text()='Check All']")).isEnabled());
		 Thread.sleep(2000);
		 
		 //Click NEW button and proceed:========
		 log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Element']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("New Element window is opened now.");
		 
		 //New Element list:===================
		 List<WebElement> ElementOpt=log.driver.findElements(By.xpath("(//span[text()='New Element']/following::div[@class='w20_treeview'])[1]/div/div"));
		 
		 String[] NewElement={"Criteria DDL","Data DDL","Script DDL","Standard SDL"};
		
		 int Count=0;
		 for(int i=0;i<ElementOpt.size();i++)
		 {
			System.out.println(ElementOpt.get(i).getText());
			if(ElementOpt.get(i).getText().equals(NewElement[i]))
			{
				Count++;
			}
		 }
		 System.out.println("Report Options are:->"+Count);
		 Assert.assertEquals(Count,4);
		 System.out.println("All New Element Options are available.");
		 Thread.sleep(2000);		
		
		 //Select Criteria DDL And Proceed:=============
		 log.driver.findElement(By.xpath("//div[text()='Criteria DDL']")).click();
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'New Criteria DDL')]")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("New Criteria DDL window is displaying now.");
		
		//Enter Criteria name and proceed:==============
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Criteria DDL of Car type");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@value='Next >>'])[1]")).click();
		Thread.sleep(2000);
		
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Preselection of Elements']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Preselection window is displaying now.");
		
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[contains(text(),'All elements of the dimension')]/preceding::input[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("All elements of dimension radio button is selected default.");
		 
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//button[text()='Selection...']")).isEnabled());
		 Thread.sleep(2000);
		 System.out.println("Selection Button is not enabled.");
		 
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select hierarchy:']/following::td[2]")).isEnabled());
		 Thread.sleep(2000);
		 System.out.println("Select hierarchy check box is enabled.");
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select hierarchy:']/following::button[@data-id='70185']")).isEnabled());
		 Thread.sleep(1000);
		 
		 //select Hierarchy window ,Validate and proceed by selecting product:===================
		 log.driver.findElement(By.xpath("//span[text()='Select hierarchy:']/following::button[@data-id='70185']")).click();
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select Hierarchy']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Select Hierarchy window is displaying now.");
		 
		 log.driver.findElement(By.xpath("(//div[text()='Product'])[1]")).click();
		 Thread.sleep(1000);
		 
		 //Click Ok And Getting back to preselection window:==============
		 log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Preselection of Elements']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Preselection window is displaying now.");
		 
		 log.driver.findElement(By.xpath("(//input[@value='Next >>'])[1]")).click();
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Criteria']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Element Criteria window is displaying now.");
		 
		 //Element Selection window verify buttons:======================
		
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Add']")).isEnabled());
		 Thread.sleep(2000);
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//button[text()='Remove']")).isEnabled());
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='<< Back']")).isEnabled());
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Cancel']")).isEnabled());
		 Thread.sleep(2000);
  	    
  	    //Label Type Checkbox Validate:=================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='N-Elements']/preceding::input[1]")).isSelected());
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='S-Elements']/preceding::input[1]")).isSelected());
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='C-Elements']/preceding::input[1]")).isSelected());
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='R-Elements']/preceding::input[1]")).isSelected());
		 Thread.sleep(2000);
  	     System.out.println("All Lebel Type checkboxes are selected by default.");
  	    
  	     //Element Name Text box should be clear:========
  	     log.driver.findElement(By.xpath("//span[text()='Elementname']/following::input[1]")).clear();
		 Thread.sleep(2000);
  	     
		 //Enter " wildcard " and click add button:===================
		 log.driver.findElement(By.xpath("//span[text()='Elementname']/following::input[1]")).sendKeys("*");
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//button[text()='Add']")).click();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//button[text()='Add']")).click();
		 Thread.sleep(2000);
		 
		 //Except N,All checkboxes need to uncheck:===============
		 log.driver.findElement(By.xpath("//label[text()='S-Elements']")).click();
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("//label[text()='C-Elements']")).click();
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("//label[text()='R-Elements']")).click();
		 Thread.sleep(1000);
		 
		 //Verify And Radio Button:============
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("(//label[text()='And'])[2]/preceding::input[1]")).isSelected());
		 Thread.sleep(1000);	 
		 System.out.println("And Radio button is selected Bydefault.");
		 
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='All']/preceding::input[1]")).isSelected());
		 Thread.sleep(1000);	 
		 System.out.println("All Checkbox is selected Bydefault.");
		 log.driver.findElement(By.xpath("(//input[@value='Next >>'])[1]")).click();
		 Thread.sleep(2000);
		
		 //Validate Attribute Criteria window:=========
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Criteria']")).isDisplayed());
		 Thread.sleep(1000);	
		 System.out.println("Element Criteria Window is displaying.");
		 
		 //Select Car Type in Attribute DialogBox:===================
		 WebElement e1=log.driver.findElement(By.xpath("//span[text()='Attribute 1:']/following::span[2]"));
         Actions a1=new Actions(log.driver);
         a1.click(e1).sendKeys("CarType", Keys.ENTER).build().perform();
         Thread.sleep(2000);
		 
		 //Enter value in filter assignment field and proceed:=========
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Filter for attribute value:'])[1]/following::div[1]/div[2]/div[1]/div/input[1]")).isEnabled());
		 Thread.sleep(1000);	
		 log.driver.findElement(By.xpath("(//span[text()='Filter for attribute value:'])[1]/following::div[1]/div[2]/div[1]/div/input[1]")).clear();
		 Thread.sleep(1000);	
		 log.driver.findElement(By.xpath("(//span[text()='Filter for attribute value:'])[1]/following::div[1]/div[2]/div[1]/div/input[1]")).sendKeys("Coupe");
		 Thread.sleep(1000);	
		 log.driver.findElement(By.xpath("(//input[@value='Next >>'])[1]")).click();
		 Thread.sleep(2000);
		 
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Unsorted']/preceding::input[1]")).isSelected());
		 Thread.sleep(1000);	
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Unlimited number']/preceding::input[1]")).isSelected());
		 Thread.sleep(1000);	
		 System.out.println("unsorted and Unlimited radio button is checked bydefault.");
  	  	
		 log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		 Thread.sleep(2000);
	  	
		 //Element group window validate is displaying/not:==============
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed());
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows')]")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Selection for Row window opened now.");
		 
		 //add Created Element to list:============
		 log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
	  	 Thread.sleep(3000);
	  	    
		 WebElement e2=log.driver.findElement(By.xpath("(//span[@class='k-widget k-dropdown w20_kendo'])[1]/span[1]"));
         Actions a2=new Actions(log.driver);
         a2.click(e2).sendKeys("Container elements", Keys.ENTER).build().perform();
         Thread.sleep(2000);
         log.driver.findElement(By.xpath("//div[text()='Criteria DDL of Car type']")).click();
		 Thread.sleep(2000);
		 
		 //Adding MashUp:==================
		 WebElement e3=log.driver.findElement(By.xpath("(//span[@class='k-widget k-dropdown w20_kendo'])[1]/span[1]"));
         Actions a3=new Actions(log.driver);
         a3.click(e3).sendKeys("Calculated  Elements", Keys.ENTER).build().perform();
         Thread.sleep(2000);
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
		 
		 //Now Click on DataView designer and click on Property:============
		 log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("(//a[@data-title='Edit properties'])[1]")).click();
		 Thread.sleep(3000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Properties of')]")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Data view Property window is opened now.");
		 Thread.sleep(2000);
		 //=================
      /*   if(log.driver.findElement(By.xpath("(//div[text()='Hide empty rows'])[1]/following::label[1]")).isSelected())
         {
        	 System.out.println("Check boX need to Uncheck.");
        	 Thread.sleep(2000);
        	 log.driver.findElement(By.xpath("(//div[text()='Hide empty rows'])[1]/following::label[1]")).click();
        	 Thread.sleep(2000);
        	 
         }
         else
         {
        	 System.out.println("Check boX is Uncheckd.");
         }
         Thread.sleep(2000);*/
         
         if(log.driver.findElement(By.xpath("(//div[text()='Hide empty rows'])[1]/following::input[1]")).isSelected())
         {
        	 System.out.println("Check boX need to Uncheck.");
        	 Thread.sleep(2000);
        	 log.driver.findElement(By.xpath("(//div[text()='Hide empty rows'])[1]/following::div[1]")).click();
        	 Thread.sleep(2000);
        	 
         }
         else
         {
        	 System.out.println("Check boX is Uncheckd.");
         }
         Thread.sleep(2000);
         
         Assert.assertEquals(false,log.driver.findElement(By.xpath("(//div[text()='Hide empty rows'])[1]/following::input[1]")).isSelected());
         Thread.sleep(2000);
         
         log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(3000);
		 
		 //drop Down Issue:==============
		 
		 WebElement mashup=log.driver.findElement(By.xpath("//div[text()='MASHUP']"));
		 ((JavascriptExecutor) log.driver).executeScript("arguments[0].scrollIntoView(true);", mashup);
		 Utils.waitForElement("");
		 Thread.sleep(2000);
		 
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
		 Thread.sleep(1000);
	     System.out.println("Mashup Row is displaying now.");
		 
		
		 WebElement mashup2=log.driver.findElement(By.id("0/198"));
		 ((JavascriptExecutor) log.driver).executeScript("arguments[0].scrollIntoView(true);", mashup2);
		 Utils.waitForElement("");
		 Thread.sleep(2000);
		 

	/*	 WebElement mashup2=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='0/197']"));
		 ((JavascriptExecutor) log.driver).executeScript("arguments[0].scrollIntoView(true);", mashup2);
		 Utils.waitForElement("");
		 Thread.sleep(2000);*/
		
		 log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='0/197']")).click();
		 Thread.sleep(1000);
		
		Actions act=new Actions(log.driver);
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='0/198']"))).perform();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Single data Cell window is displaying.");
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Write...']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Write text is displaying.");
		
		//Verify Write window after click on same:===========
		log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		Thread.sleep(1000);
		//enter input value for mashup cell:===========
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=getcellvalue(1,3)");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		 
		String ExpValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='0/198']")).getText();
		String ActValue=log.driver.findElement(By.xpath("//div[text()='2014']/following::div[@id='0/2']")).getText();
		
		Assert.assertEquals(ExpValue,ActValue);
		System.out.println("Value is comming properly.");
		
		
		 
		
		
		
		
		
		
	  	
  }
  
}
