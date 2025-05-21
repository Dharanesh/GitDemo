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

public class TestCase_24671 extends TestUtils
{
	Login log = null;
	Waits waits =null;
	Utils Utils = null;
	event.Excelnput Excelnput=null;
	
  @Test
  @Parameters("browser")
  public void Testcase_24671_for_creating_container_elements_using_child_element_via_Parameter(String browser) throws Exception
  {
	  	System.out.println("24671---Testcase started........");
  		//login to the application:==========
	  	test =extent.createTest("Test Case 24671:");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);

	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
//	  	Utils.waitForElement("");

//	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
//	  	Utils.waitForElement("");
		System.out.println("Test Case 24671: Testcase for creating container elements using child element via Parameter===================");
//	  	Utils.waitForElement("");
//	  	Thread.sleep(3000);
	  
	  	//Verify Navigator window on the Left side:=======
		Assert.assertTrue(findVisibleBool(By.xpath("//span[text()='Navigator']")));
//		Thread.sleep(2000);
		Assert.assertTrue(findVisibleBool(By.xpath("//span[text()='Navigator']/following::div[1]")));
//		Thread.sleep(2000);
	    System.out.println("Navigator window is displaying now.");
	    
	    //Verify the Status bar :==================================
	    Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='<neutral>'])[1]")).isDisplayed());
//		Thread.sleep(2000);
		System.out.println("Neutral language is displaying now on button of report.");
	  	
	  	//Try to open CM ratio manufacturers Report:=====================
		waits.waituUnitil_Element_Clickable(20,"//span[text()='Eigene Berichte']");
		log.driver.findElement(By.xpath("//span[text()='Eigene Berichte']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='CM ratio manufacturers']")).click();
//	  	Utils.waitForElement("");
		Thread.sleep(2000);
//		Thread.sleep(5000);
		
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
	  	
	  	//select Components text and verify:===========
	  	log.driver.findElement(By.xpath("//span[text()='Components']")).click();
//	  	Utils.waitForElement("");
		Thread.sleep(3000);
		
		//Rightclick on Userdefiend Filter and Proceed:===========
		Actions Report= new Actions(log.driver);
		Report.contextClick(log.driver.findElement(By.xpath("//div[text()='User-defined Filters']"))).perform();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='User-defined Filters']")).isDisplayed());
		Thread.sleep(1000);
		//Validate UserDefiend List:=====
		
		List<WebElement> UserDefiendOptions=log.driver.findElements(By.xpath("//span[text()='User-defined Filters']/following::li/span"));
		Thread.sleep(2000);
		System.out.println("UserDefiend Options are:->"+UserDefiendOptions.size());
		
		String[] ReportOpt={"Paste","New User-defined Filter..."};
		
		int Count=0;
		for(int i=0;i<UserDefiendOptions.size();i++)
		{
			System.out.println(UserDefiendOptions.get(i).getText());
			if(UserDefiendOptions.get(i).getText().equals(ReportOpt[i]))
			{
				Count++;
			}
		}
		System.out.println("UserDefiend Options are:->"+Count);
		Assert.assertEquals(Count,2);
		System.out.println("All UserDefiend Options are available.");
		Thread.sleep(2000);
		
		//Click on New UserDefiened Filter and proceed:=========================
		log.driver.findElement(By.xpath("//span[text()='New User-defined Filter...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Filter']")).isDisplayed());
//		Thread.sleep(2000);
		System.out.println("New User Defined Filter window is displaying now.");
		
		//:==================================
		List<WebElement> NewFilterOptions=log.driver.findElements(By.xpath("//span[text()='New Filter']/following::span[@class='reportNametxt']"));
		Thread.sleep(1000);
		System.out.println("New UserDefiened Filter Options are:->"+NewFilterOptions.size());
		
		String[] NewFilterOpt={"Dimension-based Filter","Query-based Filter","Static Filter"};
		int Count2=0;
		for(int i=0;i<NewFilterOptions.size();i++)
		{
			System.out.println(NewFilterOptions.get(i).getText());
			if(NewFilterOptions.get(i).getText().equals(NewFilterOpt[i]))
			{
				Count2++;
			}
		}
		System.out.println("New UserDefiend Options are:->"+Count2);
		Assert.assertEquals(Count2,3);
		System.out.println("All new UserDefiend Options are available.");
//		Thread.sleep(2000);
		
		//=Verify Text after Click================
		log.driver.findElement(By.xpath("//span[text()='Dimension-based Filter']")).click();
		Thread.sleep(2000);
		String SelectText=log.driver.findElement(By.xpath("//div[@class='w20_newwiz_description']")).getText();
		Assert.assertEquals(SelectText,"Creates a new dimension-based filter.");
		System.out.println("User Defiened selected Text is displaying.");
		
		//click Next and proceed:=================
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dimension of user-defined filter']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Diamension of UserDefiened Filter window is displaying.");
		
		//Pantara Dimension click:===========
		log.driver.findElement(By.xpath("//div[text()='Pantara AS2008']/preceding::span[1]")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//div[contains(text(),'Training Sales')]/preceding::span[1]")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//div[text()='Products']/preceding::span[1]")).click();
		Thread.sleep(2000);
//		log.driver.findElement(By.xpath("//div[text()='Products']/following::div[1]")).click();
		log.driver.findElement(By.xpath("//div[text()='Products']/following::div[text()='Product']")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
	  	//Element Group Filter window is displaying now======
			Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element groups for filter selection']")).isDisplayed());
//		Thread.sleep(2000);
		
		//Uncheck both the checkbox and validate product selection field:==============
		if(log.driver.findElement(By.xpath("//label[text()='User-defined selection']/preceding::input[1]")).isSelected())
		{
			log.driver.findElement(By.xpath("//label[text()='User-defined selection']")).click();
			Thread.sleep(2000);
		}else
		{
			System.out.println("User defiened check box is selected.");
		}
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='User-defined selection']/preceding::input[1]")).isSelected());
//		Thread.sleep(2000);
		
		//case-2:=================================
		if(log.driver.findElement(By.xpath("//label[text()='All global element groups']/preceding::input[1]")).isSelected())
		{
			log.driver.findElement(By.xpath("//label[text()='All global element groups']")).click();
			Thread.sleep(2000);
		}else
		{
			System.out.println("All global element groups check box is selected.");
		}
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='All global element groups']/preceding::input[1]")).isSelected());
//		Thread.sleep(2000);
		
		//select Product and click next:===============
		log.driver.findElement(By.xpath("//div[text()='Product.Manufacturer']/preceding::div[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Properties'])[1]")).isDisplayed());
//		Thread.sleep(2000);
		System.out.println("Property window is displaying properly.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Name and Description window is displaying.");
		Thread.sleep(1000);
		//click Finish:==================
		log.driver.findElement(By.xpath("//input[@id='finishbutton']")).click();
		Thread.sleep(2000);
		
		//Drag and Drop user defiend Filter to <Filterleiste > location:===========
		click(By.xpath("//div[text()='User-defined Filters']/preceding::div[1]"));
		
		Report.dragAndDrop(findVisible(By.xpath("//div[text()='Products.Product']")), findVisible(By.xpath("(//div[text()='Filterleiste'])[1]"))).perform();
		Thread.sleep(2000);
		
		//Click Data view Designer from toolbar and proceed:================
		log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//*[text()='Background']")).isDisplayed());
//		Thread.sleep(2000);
		System.out.println("DataView Designer window is opened now.");
		Thread.sleep(2000);
		String RowValue=log.driver.findElement(By.xpath("//*[text()='Rows']/following::span[7]/span[2]")).getText();
		Assert.assertEquals(RowValue,"Product");
		System.out.println("Product is displaying as row value.");
//		Thread.sleep(2000);
		
		Report.doubleClick(log.driver.findElement(By.xpath("//*[text()='Rows']/following::span[7]/span[2]"))).perform();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows')]")).isDisplayed());
//		Thread.sleep(2000);
		System.out.println("Selection for row window displaying.");
		
		//Remove all selection object:=============
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//span[text()='Product'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//*[text()='Container elements']")).click();
		
		
	 	List<WebElement> options=log.driver.findElements(By.xpath("(//span[contains(@class,'k-input')])[1]"));
	 	for(WebElement option : options)
	 	{
	 		System.out.println(option.getText());
	 	    if (option.getText().equals("Container elements"))
	 	    {
	 	        option.click();
	 	    }
	 	}

		
	     //Click Child elemnet Checkbox in container element:===================
	     log.driver.findElement(By.xpath("(//div[text()='Child elements'])/preceding::div[1]")).click();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();
		 Thread.sleep(2000);
		 
		 //Property of Elemnt window validate:=================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Property of element window is displaying.");
		 
		 //Select Child elements (via parameter):====================
		 log.driver.findElement(By.xpath("//label[text()='Child elements (via parameter)']")).click();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//label[text()='All N elements']")).click();
		 Thread.sleep(2000);
		
		 log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		 Thread.sleep(3000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows')]")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Selection for row window displaying.");
		 
		 List<WebElement> ChildElementList=log.driver.findElements(By.xpath("//div[text()='Child elements']"));
		 Assert.assertEquals(ChildElementList.size(),2);
		 System.out.println("Child element is available in base element area.");
		
		 //Click OK after select element:===============
		 log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		 Thread.sleep(3000);
		 
		 //
		 
		 //Work to verify on Report:===================
		 //Click drop down and Validate:========================
		 log.driver.findElement(By.xpath("(//input[@class='k-input dropdowninput'])[2]")).click();
		 Thread.sleep(2000);
		 //select BMW And proceed:================
		 log.driver.findElement(By.xpath("//li[@role='treeitem']/div/span[text()='BMW']")).click();
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='116i']")).isDisplayed());
		 Thread.sleep(2000);
		 //Another click:===========
		 log.driver.findElement(By.xpath("(//input[@class='k-input dropdowninput'])[2]")).click();
		 Thread.sleep(2000);
	 	 log.driver.findElement(By.xpath("//li[@role='treeitem']/div/span[text()='Bentley']")).click();
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Arnage']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Filter is working as expected.");
		 
		 
		 //Save as the report:=============

	     click(By.xpath("//span[@id='hamburger_btn']"));
	     click(By.xpath("//span[text()='Report']"));
	 	 click(By.xpath("//span[text()='Save As']"));

		 System.out.println("Save Report as window is displaying now.");
		
		 //Change Name:===========

	  	 click(By.xpath("(//span[text()='Name'])[1]/following::input[1]"));
		 findVisible(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		 Thread.sleep(1000);
		 findVisible(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Testcase_24671");
		 Thread.sleep(1000);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(3000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		//click On Navigator:=================
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(3000);
		
		//Delete Report:==================
		log.driver.findElement(By.xpath("(//span[text()='Testcase_24671'])[3]")).click();
		Thread.sleep(2000);
		 Actions act = new Actions(log.driver);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Testcase_24671'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		log.driver.close();
		 
		 
		
		 
		 
		
  }
  
}
