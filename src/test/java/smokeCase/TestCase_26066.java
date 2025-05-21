package smokeCase;

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

public class TestCase_26066 extends TestUtils
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
	   System.out.println("26066---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 26066:Web Cockpit Calculated Elements_ELEMENTCOUNT");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("Test Case 26066: Web Cockpit Calculated Elements_ELEMENTCOUNT===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000);
	  	
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
	  	
	  	//Click on DataView Designer window:================
  	    log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dataview Designer']/following::div[text()='Background'][1]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Data View Designer window is displaying.");
		Thread.sleep(2000);
	  	
		//Drag and Drop:=======================
		
		//In Row Category should present:==============
		//Other Element:==========
		WebElement RowElement=log.driver.findElement(By.xpath("(//div[text()='Rows']/following::div[@class='k-list-scroller k-selectable'])[2]/ul"));
		WebElement BackGroundloc=log.driver.findElement(By.xpath("(//div[text()='Background'])[1]/following::div[1]/div/div"));
		
	    Actions builder  = new Actions(log.driver);  
		builder.dragAndDrop(RowElement,BackGroundloc).perform();
		Thread.sleep(3000);
		
		log.driver.findElement(By.xpath("//span[text()='Properties']")).click();
	    Thread.sleep(2000);
	    log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
	    Thread.sleep(2000);
	  	
		//Category To Row:=================
		WebElement RowElement2=log.driver.findElement(By.xpath("(//span[text()='Category'])[2]"));
	    Thread.sleep(1000);
		WebElement Rowloc=log.driver.findElement(By.xpath("//div[text()='Rows']/following::div[5]/div[1]"));
	    Thread.sleep(1000);
	    
		Actions builder2 = new Actions(log.driver);  
		builder2.dragAndDrop(RowElement2,Rowloc).perform();
		Thread.sleep(5000);
		
		//Click on Row and verify Row window:==================
		log.driver.findElement(By.xpath("(//span[text()='Category'])[1]")).click();
		Thread.sleep(3000);
  	  	
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows')]")).isDisplayed());
		Thread.sleep(2000);
		//Element Group Availability check:=============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isDisplayed());
		Thread.sleep(2000);
		//Check Display check:=====================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display:']")).isDisplayed());
		Thread.sleep(2000);
		//Current sorting text validate:===============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Current sorting:']")).isDisplayed());
		Thread.sleep(2000);
		//No Sorting Display Validate:===============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='<No Sorting>'])[1]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Element property window texts are visible.");
		
		//Check for Button Enable/not:==============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Limits...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='User defined...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Formula Editor']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Properties...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='OK']")).isEnabled());
		Thread.sleep(2000);
		System.out.println("Element property window all Buttons are enabled");
	  	
		//Select calculated element from drop down list:======================
	    WebElement e2=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act=new Actions(log.driver);
        //act.click(e2).sendKeys("Calculated elements", Keys.ENTER).build().perform();
        Thread.sleep(2000);
        act.click(e2).perform();
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
		
        //Check For Mashup Checkbox should be unselect:=====================
	     Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='ELEMENTCOUNT']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("Calculated element check boxs are unchecked.");
		 Thread.sleep(1000);
		
		 //Rank Ascending element should be visible:==================
		/* Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='ELEMENTCOUNT']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("ELEMENTCOUNT text is displaying now..");*/
		
		 //Checkbox should be uncheck and select the checkbox:=============
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='ELEMENTCOUNT']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("ELEMENTCOUNT checkbox is unchecked..");
		 log.driver.findElement(By.xpath("//div[text()='ELEMENTCOUNT']/preceding::div[1]")).click();
		 Thread.sleep(2000);
		
		 log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
		 Thread.sleep(2000);
		
		 //Click Ok Button:============
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(2000);
	  	
		 //Mashup is Added to the table verify:================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='ELEMENTCOUNT']")).isDisplayed());
	 	 Thread.sleep(1000);
		 System.out.println("ELEMENTCOUNT is added in Table.");
		 Thread.sleep(1000);
		 
		//check time as column:===============
		String ColumnObject=log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[7]/span[2]")).getText();
		System.out.println("Column Object is:->"+ColumnObject);
		Thread.sleep(1000);
		
		Assert.assertEquals(ColumnObject,"Time");
		Thread.sleep(1000);
		System.out.println("Time is selected as column.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Columns']/following::span[7]/span[2]")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(2000);
		
		//Element Group Availability check:=============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isDisplayed());
		Thread.sleep(2000);
		//Check Display check:=====================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display:']")).isDisplayed());
		Thread.sleep(2000);
		//Current sorting text validate:===============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Current sorting:']")).isDisplayed());
		Thread.sleep(2000);
		//No Sorting Display Validate:===============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='<No Sorting>'])[1]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Element property window texts are visible.");
		
		//Check for Button Enable/not:==============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Limits...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='User defined...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Formula Editor']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//button[text()='Properties...']")).isEnabled());
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@value='OK']")).isEnabled());
		Thread.sleep(2000);
		System.out.println("Element property window all Buttons are enabled");
		 
		
		//Select calculated element from drop down list:======================
		WebElement e3=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act2=new Actions(log.driver);
       // act2.click(e3).sendKeys("Calculated elements", Keys.ENTER).build().perform();
        Thread.sleep(2000);
        act2.click(e3).perform();
        /*act.sendKeys("Calculated elements", Keys.ENTER).build().perform();
        Thread.sleep(2000);*/
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act2.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
		
        //Check For Mashup Checkbox should be unselect:=====================
	     Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='ELEMENTCOUNT']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("Calculated element check boxs are unchecked.");
		 Thread.sleep(1000);
		
		 //Rank Ascending element should be visible:==================
		/* Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='ELEMENTCOUNT']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("ELEMENTCOUNT text is displaying now..");*/
		
		 //Checkbox should be uncheck and select the checkbox:=============
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='ELEMENTCOUNT']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("ELEMENTCOUNT checkbox is unchecked..");
		 log.driver.findElement(By.xpath("//div[text()='ELEMENTCOUNT']/preceding::div[1]")).click();
		 Thread.sleep(2000);
		
		 log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
		 Thread.sleep(2000);
		
		 //Click Ok Button:============
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(2000);
	  	
		 //Mashup is Added to the table verify As Column:================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='ELEMENTCOUNT']")).isDisplayed());
	 	 Thread.sleep(1000);
		 System.out.println("ELEMENTCOUNT is added in Table As Column.");
		 Thread.sleep(1000);
		
	  	//Validate:===============
		 
		//Save As:===============
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
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Cockpit Calculated Elements_ELEMENTCOUNT");
		Thread.sleep(2000);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(5000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(5000);
		
		//Delete Report:==================
		log.driver.findElement(By.xpath("(//span[text()='Cockpit Calculated Elements_ELEMENTCOUNT'])[3]")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("(//span[text()='Cockpit Calculated Elements_ELEMENTCOUNT'])[1]/preceding::input[1]")).click();
		Thread.sleep(3000);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Cockpit Calculated Elements_ELEMENTCOUNT'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		log.driver.close();
	  	
	  	
	  	
	  	
  }
  
  
}
