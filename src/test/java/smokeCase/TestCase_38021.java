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

public class TestCase_38021 extends TestUtils
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
	  	System.out.println("38021---Test Task started........");
  		//login to the application:==========
	  	test =extent.createTest("Test Task 38021:Test Case 25790: Testcase to verify Cockpit Data Mashup Functionality Table Cell Properties(Data tab)");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("==Test Case 25790: Testcase to verify Cockpit Data Mashup Functionality Table Cell Properties(Data tab)==");
	  	Thread.sleep(3000);
	  	
	  	//Select Sales By Country and dataView Designer:======
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
  	  	
  	  	//Add Mashup Column:================
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
  	  	
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Base elements with containers (2 Items)']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Base elements with containers having three Element is displaying.");
		 Thread.sleep(1000);
  	  	
		 //Click Ok Button:============
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(3000);
	  	
		 //Click on fst cell then shift to end:=======
		/* log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
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
		 
		 //Enter Value In any Mashup cell:=================
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
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=E1");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		String MashupCellValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		System.out.println("Mashup Cell value is:->"+MashupCellValue); 
		 
		//cell property Validate:============== 
		/*log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
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
		log.driver.findElement(By.xpath("//span[text()='Cell properties...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Cell properties']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Cell Properties window is displaying now.");
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Automatic priority']/following::div[1]")).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//div[text()='Explicit priority']/following::input[@value='1'])[1]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Cell default options are available.");
		
		//Click Value Format:==============
		log.driver.findElement(By.xpath("//a[text()='Data']")).click();
		Thread.sleep(3000);
		//Validate Elements in Same window:====
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='Font size']/preceding::input[1]")).isSelected());
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='Font name']/preceding::input[1]")).isSelected());
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='Font style']/preceding::input[1]")).isSelected());
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Style:']/following::span[1]")).isDisplayed());
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Horizontal:']/following::span[1]")).isDisplayed());
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Vertical:']/following::span[1]")).isDisplayed());
		
		System.out.println("default properties are working as expected.");
		
		//Type Font Name:=======
		log.driver.findElement(By.xpath("//label[text()='Font name']/ancestor::div[1]")).click();
		Thread.sleep(1000);
		WebElement e3=log.driver.findElement(By.xpath("//label[text()='Font name']/following::span[1]"));
		//act2.click(e3).sendKeys("Book  Antiqua", Keys.ENTER).build().perform();
		act2.click(e3).perform();
		Thread.sleep(1000);
		act2.sendKeys(Keys.DOWN).perform();
		Thread.sleep(1000);
		act2.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		//Font size:=====
		log.driver.findElement(By.xpath("//label[text()='Font size']/ancestor::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//label[text()='Font size']/following::input[1]")).clear();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//label[text()='Font size']/following::input[1]")).sendKeys("15");
		Thread.sleep(1000);
		
		//Font Style:====(Bold)====
		log.driver.findElement(By.xpath("//label[text()='Font style']/ancestor::div[1]")).click();
		log.driver.findElement(By.xpath("//label[text()='Font style']/ancestor::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//label[text()='Bold']/ancestor::div[1]")).click();
		Thread.sleep(1000);
		
		//Horizontal And Vertical Enter Value:=======
		WebElement e4=log.driver.findElement(By.xpath("//span[text()='Horizontal:']/following::span[1]"));
		//act2.click(e4).sendKeys("Right", Keys.ENTER).build().perform();
		act2.click(e4).perform();
		Thread.sleep(2000);
		act2.sendKeys(Keys.DOWN).perform();
		Thread.sleep(1000);
		act2.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		
		WebElement e5=log.driver.findElement(By.xpath("//span[text()='Vertical:']/following::span[1]"));
		//act2.click(e5).sendKeys("Top", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		act2.click(e5).perform();
		Thread.sleep(2000);
		act2.sendKeys(Keys.DOWN).perform();
		Thread.sleep(1000);
		act2.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		
		//Text Color:=================
		log.driver.findElement(By.xpath("//button[text()='Text color']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select color']")).isDisplayed());
		System.out.println("select Color Window is displaying now.");
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Default color']/preceding::input[1]")).isSelected());
		System.out.println("ByDefault Checkbox is checked.");
		Thread.sleep(1000);
		
		//default Color Check box:================== 
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//td[text()='Red:']/following::input[1]")).isEnabled());
		System.out.println("ByDefault Red textBox is not Enabled.");
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//td[text()='Blue:']/following::input[1]")).isEnabled());
		System.out.println("ByDefault Blue textBox is not Enabled.");
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//td[text()='Green:']/following::input[1]")).isEnabled());
		System.out.println("ByDefault Green textBox is not Enabled.");
		
		//Select Any Color:====
		log.driver.findElement(By.xpath("//span[text()='Select color']/following::tr[2]/td[1]")).click();
		Thread.sleep(3000);
		String ActColrVal=log.driver.findElement(By.xpath("//div[text()='Actual:']/following::div[1]")).getCssValue("background-color");
		System.out.println(ActColrVal);
		//Click OK bUTTON:======
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(3000);
		//Verify Again Default Check box:====
		String DataNumberMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getAttribute("style");
		Thread.sleep(2000);
		System.out.println("Mashup Cell value after Data Cell case is:->"+DataNumberMashupValue);
		Thread.sleep(1000);
		int DataCount=0;
		if(DataNumberMashupValue.contains("font-size: 15pt"))
		{
			//if(DataNumberMashupValue.contains("font-family: \"Book Antiqua\""))
			//{
				//if(DataNumberMashupValue.contains("vertical-align: top"))
				//{
					if(DataNumberMashupValue.contains("color: rgb(139, 0, 0)"))
					{
						DataCount++;
					}
				//}
			//}
		}
		Thread.sleep(1000);
		Assert.assertEquals(DataCount,1);
		System.out.println("Testcase to verify Cockpit Data Mashup Functionality Table Cell Properties(Data tab) Validation Done.");
		Thread.sleep(1000);
		
		//Save As The Report:===================
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
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys(" c8 Cockpit_DataMashup_Functionality  Table_CellProperties_ check");
  		Thread.sleep(2000);
  		
  		//click folder:========
  		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
  		Thread.sleep(5000);
  		//Click Ok Button:============
  		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
  		Thread.sleep(5000);
  		
  		//Delete Report:==================
  		log.driver.findElement(By.xpath("(//span[text()=' c8 Cockpit_DataMashup_Functionality  Table_CellProperties_ check'])[3]")).click();
  		Thread.sleep(3000);
  		log.driver.findElement(By.xpath("(//span[text()=' c8 Cockpit_DataMashup_Functionality  Table_CellProperties_ check'])[1]/preceding::input[1]")).click();
  		Thread.sleep(2000);
  		act.contextClick(log.driver.findElement(By.xpath("(//span[text()=' c8 Cockpit_DataMashup_Functionality  Table_CellProperties_ check'])[1]"))).perform();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
  		Thread.sleep(2000);
  		log.driver.close();
  }
}
