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

public class TestCase_37771 extends TestUtils
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
	    System.out.println("37771---Test Task started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 37771: Cockpit Data Mashup Functionality Table Rows");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("======Test Case 25553: Cockpit Data Mashup Functionality Table Rows======");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  	
	  	 //Open Sales By Country Report:==============
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
  	  	Thread.sleep(5000);
	  	
  	  	//Click Data view link and proceed:============
  	  	log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
  	  	Utils.waitForElement("");
  	  	
  		//Click on Row Dimension:===============
		log.driver.findElement(By.xpath("//div[text()='Rows']/following::span[7]/span[2]")).click();
		Thread.sleep(3000);
  	  	
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for Rows window is displaying now.");
		Thread.sleep(1000);
  	  	
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Current sorting:']/following::span[text()='<No Sorting>'])[1]")).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Display:']/following::span[text()='Desc_EN'])[1]")).isDisplayed());
		Thread.sleep(1000);
		
		//Checking Buttons Enable/not??
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Limits...']")).isEnabled());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Cancel']")).isEnabled());
		Thread.sleep(1000);
		
		//Remove and add:==========
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
		Thread.sleep(3000);
		//Unckeck all the checkboxes:================
		log.driver.findElement(By.xpath("//span[text()='Selectable elements:']/following::div[2]")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//span[contains(text(),'Base elements with containers')]/following::div[2]")).click();
		Thread.sleep(3000);
		
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[3]")).click();
		Thread.sleep(3000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Please select one container only.')]")).isDisplayed());
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(1000);
		
		//Select calculated element from drop down list:======================
	    WebElement e2=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act2=new Actions(log.driver);
       // act2.click(e2).sendKeys("Calculated elements", Keys.ENTER).build().perform();
        Thread.sleep(2000);
        act2.click(e2).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.ENTER).perform();
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
		 Thread.sleep(3000);
		
		 try 
		 {
			 //Mashup is Added to the table verify:================
			 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
		 	 Thread.sleep(1000);
		 	 
		 }catch(Exception e)
		 {
			 System.out.println("Mashup for Row is hidden byDefault.");
		 }
		 
		 //Change the property:===============
		 //Right click on Row and Validate:======================
		 Actions Act=new Actions(log.driver);
		 Act.contextClick(log.driver.findElement(By.xpath("(//div[@id='-1/0'])[1]"))).perform();
		 Thread.sleep(2000);
		 try 
			{
				if(log.driver.findElement(By.xpath("//span[text()='Highlight consolidated elements']/span[1]")).isDisplayed())
				{
					System.out.println("Highlight consolidated elements is displaying.");
					Thread.sleep(1000);
				}
			}catch(Exception e)
			{
				Actions act_a=new Actions(log.driver);
				act_a.contextClick(log.driver.findElement(By.xpath("(//div[@id='-1/0'])[1]"))).build().perform();
				Thread.sleep(2000);
			}
		 
		 String Value1=log.driver.findElement(By.xpath("//span[text()='Highlight consolidated elements']/span[1]")).getAttribute("class");
		 String Value2=log.driver.findElement(By.xpath("//span[text()='Hide empty rows']/span[1]")).getAttribute("class");
		 String Value3=log.driver.findElement(By.xpath("//span[text()='Treat zero values the same as empty cells']/span[1]")).getAttribute("class");

		 int count=0;
		 if(Value1.contains("checkbox-checked"))
		 {
			 if(Value2.contains("checkbox-checked"))
			 {
				 if(Value3.contains("checkbox-checked"))
				 {
					 System.out.println("All default checkboxes are checked.");
					 count++;
				 }
			 }
		 }
		 Assert.assertEquals(count,1);
		 try 
		 {
			 if(Value2.contains("checkbox-checked"))
			 {
				 Thread.sleep(1000);
			 	 log.driver.findElement(By.xpath("//span[text()='Hide empty rows']/span[1]")).click();
			 	 Thread.sleep(1000);
			 }
		 }catch(Exception e)
		 {
			 System.out.println("Hide Empty Row is already unchecked.");
		 }
		 
		 //Mashup is Added to the table verify:================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
	 	 Thread.sleep(1000);
		 System.out.println("MASHUP is added in Table.");
		 Thread.sleep(1000);
		 
		//Click on Column and Proceed:=============
  	  	log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[7]/span[2]")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for Columns window is displaying now.");
		Thread.sleep(1000);
	  	
		//Remove All Items and Validate base element list:============
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Base elements with containers (0 Items)']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Base elements with containers having Zero Element is displaying now after remove all.");
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//div[text()='2014']")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//div[text()='2015']")).click();
		Thread.sleep(3000);
		
		//Check Enable/not Value??:===============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Limits...']")).isEnabled());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='Cancel']")).isEnabled());
		Thread.sleep(1000);
		
		//Search up and Down Validate:========================
		log.driver.findElement(By.xpath("//span[text()='Search and mark:']/following::div[4]")).click();
		Thread.sleep(3000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='No search criteria specified!']")).isDisplayed());
 		Thread.sleep(1000);
 		System.out.println("No such Criteria specified window is displaying.");
 		Thread.sleep(1000);
 		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(3000);
		
		log.driver.findElement(By.xpath("//span[text()='Search and mark:']/following::div[5]")).click();
		Thread.sleep(3000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='No search criteria specified!']")).isDisplayed());
 		Thread.sleep(1000);
 		System.out.println("No such Criteria specified window for down search button is displaying.");
 		Thread.sleep(1000);
 		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(3000);
		
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(3000);
		
		//Mashup Value Check And Validate:===================
		 //Enter Value to MASHUP:=============
		 Actions act=new Actions(log.driver);
		 act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='0/4']"))).perform();
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
			act_a.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='0/4']"))).build().perform();
			Thread.sleep(2000);
		}
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Single data Cell window is displaying.");
		
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Write...']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Write text is displaying.");
		 Thread.sleep(1000);
		 //Verify Write window after click on same:===========
		 log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		 Thread.sleep(1000);
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
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=C(1,2)");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		String FstRowMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='0/4']")).getText();
		Thread.sleep(2000);
		System.out.println("Mashup Cell value is:->"+FstRowMashupValue);
		
		String TableCellValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='0/4']")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(FstRowMashupValue, TableCellValue);
		System.out.println("Mashup Value is reflected as expected.");
		
		//Save the Report and close:====
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
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("c8 Cockpit Mashup element Row Check");
  		Thread.sleep(2000);
  		
  		//click folder:========
  		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
  		Thread.sleep(5000);
  		//Click Ok Button:============
  		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
  		Thread.sleep(5000);
  		
  		//Delete Report:==================
  		log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit Mashup element Row Check'])[3]")).click();
  		Thread.sleep(3000);
  		log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit Mashup element Row Check'])[1]/preceding::input[1]")).click();
  		Thread.sleep(1000);
  		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='c8 Cockpit Mashup element Row Check'])[1]"))).perform();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
  		Thread.sleep(2000);
  		
  		log.driver.close();
		
  }
}
