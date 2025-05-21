package regression;

import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
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

public class TestCase_40340 extends TestUtils
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
	    System.out.println("40340---Test Task started........");
		//login to the application:==========
	  	test =extent.createTest("Test Task 40340: Test Case 28760: 14198 : Cockpit DataView Olap Functions for ClientRules_CalcDDL");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("==Test Task 40340: Test Case 28760: 14198 : Cockpit DataView Olap Functions for ClientRules_CalcDDL==");
	  	Thread.sleep(3000); 
	  
	  //Validate New Report window Elements:=============
	  	log.driver.findElement(By.xpath("//span[text()='New']/preceding::span[1]")).click();
	  	Utils.waitForElement("");
	  	
	  	Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Report']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for Columns window is displaying now.");
		Thread.sleep(1000);
		
		String[] ActReportNameList={"Standard Report","ABC Classification","Empty Report","Relational Report","MDX Report","Entry Report","Report from a Template","Local Export"};
		List<WebElement> ReportNamelist=log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
		
		int count=0;
		for(int i=0;i<ReportNamelist.size();i++)
		{
			System.out.println(ActReportNameList[i]+" And "+ReportNamelist.get(i).getText());
			
			if(ActReportNameList[i].equals(ReportNamelist.get(i).getText()))
			{
				count++;
			}
		}
		Thread.sleep(2000);
		System.out.println("Count of Report Name list is:->"+count);
		Assert.assertEquals(8,count);
		
		//Standard Report Select And Proceed:============
		log.driver.findElement(By.xpath("//span[text()='Standard Report']")).click();
		Thread.sleep(1000);
	 	Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Creates a new standard report with tables and charts.']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Standard Report Message is displaying now.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select Cube']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Select Cube Window is displaying now.");
		Thread.sleep(1000);
				
		//Select Pantara:==========
		log.driver.findElement(By.xpath("//div[text()='Pantara AS2008']/preceding::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='A - Training Sales']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dimension Selection']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Dimension Selection window is displaying now.");
		
		//Validate Default Value in Dimension selection window:=======
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Use all dimensions of cube']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='Use only selected dimensions']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Report Layout']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Report Layout window is displaying now.");
		
		//Validate Default Value:====================================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Table only']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Hide empty rows']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Automatic value refresh']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Filter Components']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Filter Components window is displaying now.");

		//Validate Default Property in Filter Components window:=============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Display filter bar']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//label[text()='Display selection bar']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'next?')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Whats Next? window is displaying now.");
		Thread.sleep(1000);
				
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Name And Description window is displaying now.");
		
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).clear();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("ClientRules_CalcDDL_check");;
		Thread.sleep(1000);
				
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(1000);
		//Click on Finish Button:=====
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(1000);
		System.out.println("New Report is created for  client rule ClientRules_CalcDDL_check.");
		Thread.sleep(3000);
	  	
		//Select product and remove all elemnts:==========
		//Click on DataView Designer window:================
  	    log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dataview Designer']/following::span[text()='Background'][2]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Data View Designer window is displaying.");
		Thread.sleep(2000);
  	  	
		//Drag and Drop(Category):=======================
		//Other Element:==========
		WebElement RowElement=log.driver.findElement(By.xpath("(//span[text()='Rows']/following::div[@class='k-list-scroller k-selectable'])[2]/ul"));
		WebElement BackGroundloc=log.driver.findElement(By.xpath("(//span[text()='Background'])[2]/following::div[1]/div/div"));
		
	    Actions builder  = new Actions(log.driver);  
		builder.dragAndDrop(RowElement,BackGroundloc).perform();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//span[text()='Properties']")).click();
	    Thread.sleep(2000);
	    log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
	    Thread.sleep(2000);
	  	
		//Category To Row:=================
		WebElement RowElement2=log.driver.findElement(By.xpath("(//span[text()='Product'])[2]"));
	    Thread.sleep(1000);
		WebElement Rowloc=log.driver.findElement(By.xpath("//span[text()='Rows']/following::div[5]/div[1]"));
	    Thread.sleep(1000);
	    
		Actions builder2 = new Actions(log.driver);  
		builder2.dragAndDrop(RowElement2,Rowloc).perform();
		Thread.sleep(5000);
		
		//Select the Row and Select all Values:====
		log.driver.findElement(By.xpath("//span[text()='Rows']/following::span[7]/span[2]")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows')]")).isDisplayed());
		Thread.sleep(2000);
		
		//Remove all Items:=====
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']/ancestor::div[1]")).click();
		Thread.sleep(1000);
		//Select Element grp and Continue:=======
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed());
		Thread.sleep(2000);
				
		//Validate Element group window:====
		String[] ActGroupList={"Dimensiontree","Calculated elements","Container elements","Client Rules"};
		List<WebElement> GroupNamelist=log.driver.findElements(By.xpath("//span[text()='Groups']/following::ul[1]/li"));
		
		int countGName=0;
		for(int i=0;i<GroupNamelist.size();i++)
		{
			System.out.println(ActGroupList[i]+" And "+GroupNamelist.get(i).getText());
			
			if(ActGroupList[i].equals(GroupNamelist.get(i).getText()))
			{
				countGName++;
			}
		}
		Thread.sleep(2000);
		System.out.println("Count of Group Name list is:->"+countGName);
		Assert.assertEquals(4,countGName);
		System.out.println("All Group Name is Comming properly.");
		Thread.sleep(1000);
				
		//Select Container Element and proceed:=====
		log.driver.findElement(By.xpath("(//span[text()='Container elements'])[1]")).click();
		Thread.sleep(2000);
				
		//Delete the created one:===========
		List<WebElement> ClientRules=log.driver.findElements(By.xpath("//span[text()='Elements']/following::ul[1]/li/div//span/span[2]"));
		for(int i=0;i<ClientRules.size();i++)
		{
			System.out.println(ClientRules.get(i).getText());
			if(ClientRules.get(i).getText().equals("Muster - BMW Touring_40340"))
			{
				System.out.println("Client Rule Found");
				log.driver.findElement(By.xpath("//span[text()='Muster - BMW Touring_40340]")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
				Thread.sleep(2000);
				break;
			}
		}
		
		//Click new:===
		log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Element']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("New Element window is displaying now.");
		
		//Element Type Window:===============
		//Validate Element group window:====
		String[] ElemntTypeList={"Criteria DDL","Data DDL","Script DDL","Standard SDL"};
		List<WebElement> Elemntlist=log.driver.findElements(By.xpath("//span[text()='Available element types:']/following::div[1]/div[1]/div/div"));
		
		int countEName=0;
		for(int i=0;i<Elemntlist.size();i++)
		{
			System.out.println(ElemntTypeList[i]+" And "+Elemntlist.get(i).getText());
			
			if(ElemntTypeList[i].equals(Elemntlist.get(i).getText()))
			{
				countEName++;
			}
		}
		Thread.sleep(2000);
		System.out.println("Count of Available Element type list is:->"+countEName);
		Assert.assertEquals(4,countEName);
		System.out.println("All Available element type is Comming properly.");
		Thread.sleep(1000);
		
		//Select Standard SDL and proceed:====
		log.driver.findElement(By.xpath("//div[text()='Criteria DDL']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		
		//Provide Name and Description:============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Name and Description window is displaying now.");
		
		//Enter the name:==
	    log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("Muster - BMW Touring_40340");
	    log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).click();
	    Thread.sleep(1000);
	    
	    log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Preselection of Elements']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("preselection Element window is displaying.");
		
		//select the following element radio button:==============
		log.driver.findElement(By.xpath("//label[contains(text(),'Following elements are used for the creation of the DDL')]")).click();
		Thread.sleep(1000);
		
		//click on Selection:=============
		log.driver.findElement(By.xpath("//button[text()='Selection...']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Column')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for Column window is displaying.");
		
		
		
		
		
	  	
	  	
  }
  
}
