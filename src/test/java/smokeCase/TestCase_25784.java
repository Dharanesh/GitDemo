package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
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

public class TestCase_25784 extends TestUtils
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
	  	System.out.println("25784---Testcase started........");
  		//login to the application:==========
	  	test =extent.createTest("Test Case 25784:");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);

	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	log.createCubeReport("//div[text()='Sales']", "TestCase_25784", false);
	  	
	  	

		//Testcase step 5 to step 7
		//Retrieving status value
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("DisplayvalueStatusXpath"));
		String Status_Value=log.driver.findElement(By.xpath(log.getData("DisplayvalueStatusXpath"))).getText();
		System.out.println(Status_Value);
		int value=Status_Value.indexOf("C");
		System.out.println(value);
		String NewValue =Status_Value.substring(value);
		System.out.println(NewValue);
		System.out.println("Repository Name"+NewValue);
		
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
		
		log.driver.findElement(By.xpath("//div[text()='Sales']/preceding::span[1]")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//div[text()='Time']/preceding::span[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()='Time']/following::div[text()='Time']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		
		//Element Group Filter window is displaying now======
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element groups for filter selection']")).isDisplayed());
//	Thread.sleep(2000);
	
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
//	Thread.sleep(2000);
	
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
	log.driver.findElement(By.xpath("//div[text()='Time.Years']/preceding::div[1]")).click();
	Thread.sleep(2000);
	log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
	Thread.sleep(2000);
	
	Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Properties'])[1]")).isDisplayed());
//	Thread.sleep(2000);
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
	
	
	String RowValue=log.driver.findElement(By.xpath("//div[text()='Rows']/following::span[7]/span[2]")).getText();
	Assert.assertEquals(RowValue,"Category");
	System.out.println("Category is displaying as row value.");
	log.driver.findElement(By.xpath("//span[text()='Category']")).click();
	waits.waituUnitil_Element_Clickable(10,"//button[text()='Element Groups...']");
	//Remove all selection object:=============
	log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
	Thread.sleep(1000);
	
	waits.waituUnitil_Element_Clickable(10,"//button[text()='Element Groups...']");
	Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isDisplayed(),true);
	
	log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
	Thread.sleep(2000);	
	
	List<WebElement>cont = log.driver.findElements(By.xpath("(//div[@class='k-list-scroller k-selectable'])[2]/ul/li/div/span/span[2]"));
	for (int z =0;z<=cont.size()-1;z++) 
	{
		System.out.println(cont.get(z).getText());
		if(cont.get(z).getText().equals("lag"))
		{
			System.out.println(cont.get(z).getText());
			System.out.println("INside =============================");
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//span[text()='lag']")).click();
			Thread.sleep(2000);
			waits.waituUnitil_Element_Clickable(20,"//button[text()='Delete']");
			log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
			waits.waituUnitil_Element_Clickable(20,"//input[@id='yesbutton']");
			log.driver.findElement(By.xpath("//input[@id='yesbutton']")).click();
			break;
		}
  	
	}
	
	waits.waituUnitil_Element_Clickable(20,"//button[text()='New...']");
	Thread.sleep(2000);	
	log.driver.findElement(By.xpath("//button[text()='New...']")).click();
	List<WebElement>ele = log.driver.findElements(By.xpath("(//div[@class='w20_treeview'])[1]/div/div"));
	ArrayList<String> elem = new ArrayList();
	elem.add("Criteria DDL");
	elem.add("Data DDL");
	elem.add("Script DDL");
	elem.add("Standard SDL");
	for (int j =0;j<=ele.size()-1;j++) 
	{
		assertEquals(ele.get(j).getText(), elem.get(j));
		
	}
	log.driver.findElement(By.xpath("//div[text()='Script DDL']")).click();
	Thread.sleep(500);
	log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
	waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
	Thread.sleep(1000);
	log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("lag");
	Thread.sleep(1000);
	Actions act = new Actions(log.driver);
	act.sendKeys(Keys.TAB).perform();
	Thread.sleep(1000);
	List<WebElement>button = log.driver.findElements(By.xpath("(//div[@id='buttons'])[1]/input"));
	ArrayList<String> but = new ArrayList();
	but.add("Next >>");
	but.add("Cancel");
	but.add("Help");
	for(int i =0;i<=button.size()-1;i++) 
	{
		assertEquals(but.get(i), button.get(i).getAttribute("value"));
	}
	Thread.sleep(2000);
	log.driver.findElement(By.xpath("(//input[@value='Next >>'])[1]")).click();
	waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");	
	assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New Script DDL')]/following::tbody[1]/tr/td/label")).getText(), "TCL Script");
	assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New Script DDL')]/following::tbody[2]/tr/td/label")).getText(), "MDX Expression");
	assertTrue(log.driver.findElement(By.xpath("//label[text()='TCL Script']/../input")).isSelected());
	log.driver.findElement(By.xpath("//label[text()='MDX Expression']/../label")).click();
	Thread.sleep(1000);
	log.driver.findElement(By.xpath("(//input[@value='Next >>'])[1]")).click();
	waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
	Thread.sleep(3000);
	assertEquals(log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]")).getText(),"SET Expression");
	log.driver.findElement(By.xpath("//span[text()='MDX Expression:']")).click();
	Thread.sleep(2000);
	Thread.sleep(1000);
	act.sendKeys(Keys.TAB).perform();
	Thread.sleep(1000);
	act.sendKeys(Keys.TAB).perform();
	act.sendKeys("<@Time.Time>.Lag(1)").perform();
	Thread.sleep(1000);
	log.driver.findElement(By.xpath("//span[contains(text(),'Only when')]")).click();
	Thread.sleep(1000);
	log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
	waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
	Thread.sleep(1000);
	log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
	waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
	Thread.sleep(2000);
	assertFalse(true);
	
	
}
}