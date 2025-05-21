package smokeCase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class TestCase_37764 extends TestUtils
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
	    System.out.println("37764---Test Task started........");
	  	//login to the application:==========
	  	test =extent.createTest("TestCase-37764: Cockpit Data Mashup Dim_Based filter check");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("======TestCase-25050:-Cockpit Data Mashup Dim_Based filter check======");
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
  	  	//Click Measure and proceed:====
  	  	log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[7]/span[2]")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for Columns window is displaying now.");
		Thread.sleep(1000);
  	  	
		//Remove All Items and Validate base elemnt list:============
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Base elements with containers (0 Items)']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Base elements with containers having Zero Element is displaying now after remove all.");
		Thread.sleep(1000);
	  	
		log.driver.findElement(By.xpath("//div[text()='2014']")).click();
		Thread.sleep(3000);
		//log.driver.findElement(By.xpath("//div[text()='2015']")).click();
		//Thread.sleep(3000);
		
		//Add Mashup:================
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
	  	
		 //Click on fst cell then shift to end:=======
		 /*log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		 Thread.sleep(2000);
		 Robot robot=new Robot();
		 robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyRelease(KeyEvent.VK_RIGHT); 
	     Thread.sleep(1000);*/
		 
		 //Mashup is Added to the table verify:================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
	 	 Thread.sleep(1000);
		 System.out.println("MASHUP is added in Table.");
		 Thread.sleep(1000);
	  	
		 //Add Mashup value:===============
		 //Mashup cell should display write on rightclick opt:=====
		 Actions act=new Actions(log.driver);
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
		// =C(1,2)
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=C(1,1)");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		String FstRowMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		System.out.println("Mashup Cell value is:->"+FstRowMashupValue);
		
		//Click on Components manager:==========
		log.driver.findElement(By.xpath("//span[text()='Components']")).click();
		Thread.sleep(3000);
		//Right click on User Defined filters:====
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='User-defined Filters']"))).perform();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New User-defined Filter...']")).isDisplayed());
		Thread.sleep(1000);
		//click on new User defiened Filter:====
		log.driver.findElement(By.xpath("//span[text()='New User-defined Filter...']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Filter']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("New Filter window is opened now.");
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Creates a new dimension-based filter.']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("default text is displaying.");
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		//Select Dimension as Category and proceed:=============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dimension of user-defined filter']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Dimension selection window is displaying now.");
		log.driver.findElement(By.xpath("//div[text()='Pantara AS2008']/preceding::div[1]")).click();
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//div[text()='Sales']/preceding::div[1]")).click();
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//div[text()='Category']/preceding::div[1]")).click();
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("(//div[text()='Category'])[2]")).click();
		Thread.sleep(2000);	
		
		//Click Next And proceed:====
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);	
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element groups for filter selection']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Element group filter selection window is displaying now.");
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);	
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='User-defined selection']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("User-defined selection window is displaying now.");
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);	
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Please select at least one source element')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Error message is displaying without select the source element.");
		
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(2000);	
		
		//click Button for select element:=====
		log.driver.findElement(By.xpath("//button[text()='Elements...']")).click();
		Thread.sleep(2000);	
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for source of dimension based filter')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for source of dimension window is displaying now.");
		
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);	
		
		//Properties window and some Validations:====
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Properties'])[1]")).isDisplayed());
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//div[text()='Caption']/following::input[1]")).clear();
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//div[text()='Caption']/following::input[1]")).sendKeys("Userdeffilter_DimensionCategory");
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//div[text()='Caption']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()='Caption']")).click();
		Thread.sleep(2000);
		
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Visible']/following::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Iterable']/following::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Enable selection by drop-down menu']/following::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Selection type']/following::span[2]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Property window default validation completed.");
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);	
			
		//Finish Window  Validations:====
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		System.out.println("Name and Description window is displaying now.");		
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(2000);
		//Click Finish:=====
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(5000);
		
		//Click created filter and Validate Mashup:====
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Userdeffilter_DimensionCategory']")).isDisplayed());
		System.out.println("Created user defied filter is displaying now.");		
		Thread.sleep(2000);	
		
		log.driver.findElement(By.xpath("//span[text()='Userdeffilter_DimensionCategory']/following::span[3]")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//span[text()='All Categories']/preceding::span[1]")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//span[text()='Used Car']")).click();
		Thread.sleep(3000);
		
		//Validate After Change:=====================
		//Click on fst cel then shift to end:====
		/*log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
	
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		
		String MashupValueAfterFilter=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		System.out.println("Mashup Cell value after filter is:->"+MashupValueAfterFilter);
		
		try{
				if(MashupValueAfterFilter.equals(FstRowMashupValue))
				{
					System.out.println("Not equal.");
				}
						
		}catch(Exception e)
		{
				System.out.println("Mashup value changed as per created filter.");
		}
		
		System.out.println("Testcase-25050 Done.");
		Thread.sleep(500);
		log.driver.close();
		
  }
}
