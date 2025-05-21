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

public class TestCase_24672 extends TestUtils
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
	  System.out.println("24672---Testcase started........");
		//login to the application:==========
	  	test =extent.createTest("Test Case 24672:");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);

	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
		System.out.println("Test Case 24672: Testcase for creating container elements using Child elements explicit parent===================");
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
	  	
	  	//Try to open CM ratio manufacturers Report:=====================
		log.driver.findElement(By.xpath("//span[text()='CM ratio manufacturers']")).click();
	  	Utils.waitForElement("");
		Thread.sleep(3000);
		Thread.sleep(5000);
		
		//Take Count After open:===========
	  	List<WebElement> ReportCount=log.driver.findElements(By.xpath("//span[text()='CM ratio manufacturers']"));
	  	
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
	  			log.driver.findElement(By.xpath("//span[text()='CM ratio manufacturers']")).click();
	  			Utils.waitForElement("");
	  	}
	  	
	  	//DataView Designer open :========================
	  	log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
	  	Thread.sleep(3000);
	  	
	  	String RowObject=log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText();
		System.out.println("Column Object is:->"+RowObject);
		Thread.sleep(1000);
		
		Assert.assertEquals(RowObject,"Product");
		Thread.sleep(1000);
		System.out.println("Product is selected as Row.");
		Thread.sleep(1000);
	  	
	  	//Click on Product:=================
		log.driver.findElement(By.xpath("//span[text()='Product']")).click();
	  	Thread.sleep(3000);
	  	Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows')]")).isDisplayed());
		Thread.sleep(2000);
	  	System.out.println("Product selection window is open now.");
	  	
	  	//Removes all items from the selection list:=================================
	  	log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
	  	Thread.sleep(3000);
	  
	  	//Click on Element group drop down and proceed:=================
	  	/*List<WebElement> options=log.driver.findElements(By.xpath("//span[contains(@class,'k-input')]"));
	 	for(WebElement option : options) 
	 	{
	 		//System.out.println(option.getText());
	 	    if (option.getText().equals("Container elements")) 
	 	    {
	 	        option.click();
	 	    }
	 	}
		log.driver.findElement(By.xpath("(//span[@class='k-widget k-dropdown w20_kendo'])[1]/span[1]")).click();
		Thread.sleep(3000);
		
		 Actions act = new Actions(log.driver);
	     act.sendKeys(Keys.chord(Keys.DOWN)).perform();
	     Thread.sleep(2000);
	     act.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(2000);*/
	  	waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1 = new Actions(log.driver);
		//a1.click(elemnt1).sendKeys("Container elements", Keys.ENTER).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);

		Assert.assertEquals(elemnt1.getText(),"Container elements");
	     //Click Child element Check box in container element:===================
	     log.driver.findElement(By.xpath("(//div[text()='Child elements'])/preceding::div[1]")).click();
		 Thread.sleep(3000);
		 log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();
		 Thread.sleep(3000);
		 
		 //Property of Element window validate:=================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Property of element window is displaying.");
		 
		 //Select Child elements (explicit parent element):====================
		 log.driver.findElement(By.xpath("//label[text()='Child elements (explicit parent element)']")).click();
		 Thread.sleep(3000);
		 log.driver.findElement(By.xpath("//span[text()='Parent element:']/following::button[1]")).click();
		 Thread.sleep(3000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Select Element')]")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Select element window is opened now.");
		 
		 //Select Acura and click OK button:=====================
		 log.driver.findElement(By.xpath("//div[text()='Acura']/preceding::div[1]")).click();
		 Thread.sleep(3000);
		 log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		 Thread.sleep(3000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Property of element window is displaying after select Acura.");
		 Thread.sleep(2000);
		 
		 //Parent Element field Verify and click Ok:================
		 String ParentElement=log.driver.findElement(By.xpath("//span[text()='Parent element:']/following::td[2]")).getText();
		 Assert.assertEquals(ParentElement,"Acura");
	  	 System.out.println("Acura is displaying in Parent element field.");
	  	 Thread.sleep(2000);
	  	 
	  	 //select "Add parent element to selection":============================
	  	 if(log.driver.findElement(By.xpath("//label[text()='Add parent element to selection']/preceding::input[1]")).isSelected())
	  	 {
	  		 System.out.println("Add Parent Element checkbox is selected.");
	  		 
	  	 }else
	  	 {
	  		 System.out.println("Add Parent Element checkbox is need to select.");
	  		 log.driver.findElement(By.xpath("//label[text()='Add parent element to selection']")).click();
	  		 Thread.sleep(2000);
	  	 }
	  	 Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Add parent element to selection']/preceding::input[1]")).isSelected());
	  	 System.out.println("Add Parent Elemnt to Selection is selected.");
	  	 Thread.sleep(2000);
	  	 
	  	 log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		 Thread.sleep(3000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows')]")).isDisplayed());
		 Thread.sleep(2000);
	  	 System.out.println("Product selection window is open now after click Ok Button.");
	  	 
	  	 log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		 Thread.sleep(3000);
	  	 //===Return Back to Report and Verify Acura=======================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Acura']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Acura is displaying after select as parent.");
	  	
		 
		 //Save report as some other name:=======================
		 //Save as the report:=============
		 log.driver.findElement(By.xpath("(//span[text()='Save'])[2]/following::span[1]")).click();
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
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Testcase_24672");
		 Thread.sleep(2000);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(5000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(5000);
		try
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'A report named')]")).isDisplayed();
			log.driver.findElement(By.xpath("//input[@value='OK']")).click();
			System.out.println("popup appeared");
		}
		catch(Exception e)
		{
		System.out.println("saves as completed without popup");
		Thread.sleep(1000);
		}
		Thread.sleep(1000);
		
		//click On Navigator:=================
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		
		//Delete Report:==================
		log.driver.findElement(By.xpath("(//span[text()='Testcase_24672'])[3]")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("(//span[text()='Testcase_24672'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);
		
		a1.contextClick(log.driver.findElement(By.xpath("(//span[text()='Testcase_24672'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		log.driver.close();
		 
		 
		 
		 
		 
	  	
  }
  
}
