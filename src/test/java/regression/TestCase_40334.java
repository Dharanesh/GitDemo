package regression;

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

public class TestCase_40334 extends TestUtils
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
	    System.out.println("40334---Test Task started........");
		//login to the application:==========
	  	test =extent.createTest("Test Task 40334: Test Case 28767: 14192 : Cockpit DataView Olap Functions for ClientRules_ExistSDLElem");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("==Test Task 40334: Test Case 28767: 14192 : Cockpit DataView Olap Functions for ClientRules_ExistSDLElem==");
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
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("ClientRules_ExistSDLElem_check");;
		Thread.sleep(1000);
				
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(1000);
		//Click on Finish Button:=====
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(1000);
		System.out.println("New Report is created for  client rule ClientRules_ExistSDLElem_check.");
		Thread.sleep(3000);
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
		
		//Select the Row and Select some specific Value:====
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
			if(ClientRules.get(i).getText().equals("Muster - Exoten_40334"))
			{
				System.out.println("Client Rule Found");
				log.driver.findElement(By.xpath("//span[text()='Muster - Exoten_40334']")).click();
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
		log.driver.findElement(By.xpath("//div[text()='Standard SDL']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		
		//Provide Name and Description:============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Name and Description window is displaying now.");
		
		//Enter the name:==
	    log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("Muster - Exoten_40334");
	    log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).click();
	    Thread.sleep(1000);
	    
	    log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
	    
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Selection']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Element selection window is displaying.");
		
		log.driver.findElement(By.xpath("//button[text()='Selection...']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for SDL')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for SDL window is displaying.");
		
		//Select the check box for following elements window:=====
		log.driver.findElement(By.xpath("//div[text()='Aston Martin']/preceding::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Cadillac']/preceding::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Ferrari']/preceding::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Jaguar']/preceding::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Lincoln']/preceding::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Lotus']/preceding::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Maserati']/preceding::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Porsche']/preceding::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Rolls-Royce']/preceding::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//button[@data-id='30157'])[1]")).click();
		Thread.sleep(2000);
		
		//Click Ok Button:============
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Selection']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Element selection window is displaying.");
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Selection']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Element selection window is displaying.");
		
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		
		//Select the container Element:======== 
		WebElement e2=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act2=new Actions(log.driver);
        act2.click(e2).sendKeys("Container elements", Keys.ENTER).build().perform();
        Thread.sleep(2000);
		
        //Check For Mashup Checkbox should be unselect:=====================
	     Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='Muster - Exoten']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("Client Rule check box are unchecked.");
		 Thread.sleep(1000);
				
		 //Rank Ascending element should be visible:==================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Muster - Exoten']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("Muster - Exoten client rule is displaying now..");
		
		 //Checkbox should be uncheck and select the checkbox:=============
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='Muster - Exoten']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("Muster - Exoten client rule is unchecked..");
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("//div[text()='Muster - Exoten_40334']/preceding::div[1]")).click();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
		 Thread.sleep(2000);
		 //Click Ok Button:============
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(2000);
		 
		 //Click on Dimension Measure:=============
		 log.driver.findElement(By.xpath("//span[text()='Columns']/following::span[7]/span[2]")).click();
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		 Thread.sleep(2000);
		
		 log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']/ancestor::div[1]")).click();
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("//div[text()='Purchase price']/preceding::div[1]")).click();
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
		 Thread.sleep(2000);
		 
		 //Add Client Rule:================
		 //Click On Element Group:====
		 log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed());
		 Thread.sleep(2000);
					
		 //Validate Element group window:====
		 String[] ActGroupList2={"Dimensiontree","Calculated elements","Container elements","Client Rules"};
		 List<WebElement> GroupNamelist2=log.driver.findElements(By.xpath("//span[text()='Groups']/following::ul[1]/li"));
			
		 int countGName2=0;
		 for(int i=0;i<GroupNamelist2.size();i++)
		 {
				System.out.println(ActGroupList2[i]+" And "+GroupNamelist2.get(i).getText());
				
				if(ActGroupList2[i].equals(GroupNamelist2.get(i).getText()))
				{
					countGName2++;
				}
		}
		Thread.sleep(2000);
		System.out.println("Count of Group Name list is:->"+countGName2);
		Assert.assertEquals(4,countGName2);
		System.out.println("All Group Name is Comming properly.");
		Thread.sleep(1000);
		
		//Click Client Rule and proceed:========
		log.driver.findElement(By.xpath("(//span[text()='Client Rules'])[1]")).click();
		Thread.sleep(2000);
		
		//Delete Exited Client Rule:===========================
		List<WebElement> ClientRules2=log.driver.findElements(By.xpath("//span[text()='Elements']/following::ul[1]/li/div//span/span[2]"));
		for(int i=0;i<ClientRules2.size();i++)
		{
			System.out.println(ClientRules2.get(i).getText());
			if(ClientRules2.get(i).getText().equals("ExistSDLElem0_40334"))
			{
				System.out.println("Client Rule Found");
				log.driver.findElement(By.xpath("//span[text()='ExistSDLElem0_40334']")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
				Thread.sleep(2000);
				break;
			}
		}
		
		log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Element']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("New Element window is displaying now.");
		
		//Element Type Window:===============
		//Validate Element group window:====
		String[] ElemntTypeList2={"Dimension Rule","Global Rule"};
		List<WebElement> Elemntlist2=log.driver.findElements(By.xpath("//span[text()='Available element types:']/following::div[1]/div[1]/div/div"));
		int countEName2=0;
		for(int i=0;i<Elemntlist2.size();i++)
		{
			System.out.println(ElemntTypeList2[i]+" And "+Elemntlist2.get(i).getText());
			
			if(ElemntTypeList2[i].equals(Elemntlist2.get(i).getText()))
			{
				countEName2++;
			}
		}
		Thread.sleep(2000);
		System.out.println("Count of Available Element type list is:->"+countEName);
		Assert.assertEquals(2,countEName2);
		System.out.println("All Available ement type is Comming properly.");
		Thread.sleep(1000);
		
		//Select Global Rule and proceed:====
		log.driver.findElement(By.xpath("//div[text()='Global Rule']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Edit Client Rule window is displaying now.");
		
		//Enter the name:==
	    log.driver.findElement(By.xpath("//span[text()='Name:']/following::input[1]")).sendKeys("ExistSDLElem0_40334");
	    log.driver.findElement(By.xpath("//span[text()='Name:']/following::input[1]")).click();
	    Thread.sleep(1000);
	    
	    //ExistDimElem( "A - Training Sales.[Products].[Product]",  "Muster - Exoten", "Toyota" ) 
		String SumFormula="ExistDimElem("+"\""+"A - Training Sales.[Products].[Product]"+"\","+" "+"\""+"Toyota"+"\" )";
  		Actions act=new Actions(log.driver);
  		act.moveToElement(log.driver.findElement(By.xpath("(//span[text()='Edit Client Rule']/following::div[4]//textarea[1])[2]")));
  		act.click();
  		act.sendKeys(SumFormula).build().perform();;
  		Thread.sleep(1000);
  		
  		//Check Syntax:============
  		log.driver.findElement(By.xpath("//button[text()='Check Syntax']")).click();
  		Thread.sleep(3000);
  		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(3000);
		
		//add the rule to list
		WebElement e3=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act3=new Actions(log.driver);
        act3.click(e3).sendKeys("Client Rules", Keys.ENTER).build().perform();
        Thread.sleep(2000);
				  		
        //Check For Mashup Checkbox should be unselect:=====================
	     Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='ExistSDLElem0_40334']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("Client Rule check box are unchecked.");
		 Thread.sleep(1000);
						
		 //Rank Ascending element should be visible:==================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='ExistSDLElem0_40334']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("ExistSDLElem0_40334 client rule is displaying now..");
		
		 //Checkbox should be uncheck and select the checkbox:=============
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='ExistSDLElem0_40334']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("ExistSDLElem0_40334 client rule is unchecked..");
		 log.driver.findElement(By.xpath("//div[text()='ExistSDLElem0_40334']/preceding::div[1]")).click();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
		 Thread.sleep(2000);
				
		 //Click Ok Button:============
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(2000);
		
		 //Validate the client Rule Column:====
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='ExistSDLElem0_40334']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Client Rule(ExistSDLElem0_40334) is displaying as Column");
  		
		 //Again Create Client rule in Measure and Rename it:================
		 log.driver.findElement(By.xpath("//span[text()='Columns']/following::span[7]/span[2]")).click();
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		 Thread.sleep(2000);
		 
		 log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed());
		 Thread.sleep(2000);
		 //Click Client Rule and proceed:========
		 log.driver.findElement(By.xpath("(//span[text()='Client Rules'])[1]")).click();
		 Thread.sleep(2000);
		 //Delete Exited Client Rule:===========================
		 List<WebElement> ClientRules3=log.driver.findElements(By.xpath("//span[text()='Elements']/following::ul[1]/li/div//span/span[2]"));
		 for(int i=0;i<ClientRules3.size();i++)
		 {
			System.out.println(ClientRules3.get(i).getText());
			if(ClientRules3.get(i).getText().equals("ExistDimElem1_40334"))
			{
				System.out.println("Client Rule Found");
				log.driver.findElement(By.xpath("//span[text()='ExistDimElem1_40334']")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
				Thread.sleep(2000);
				break;
			}
		}
			
		log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Element']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("New Element window is displaying now.");
			
		//Element Type Window:===============
		//Validate Element group window:====
		String[] ElemntTypeList3={"Dimension Rule","Global Rule"};
		List<WebElement> Elemntlist3=log.driver.findElements(By.xpath("//span[text()='Available element types:']/following::div[1]/div[1]/div/div"));
		
		int countEName3=0;
		for(int i=0;i<Elemntlist3.size();i++)
		{
			System.out.println(ElemntTypeList3[i]+" And "+Elemntlist3.get(i).getText());
			
			if(ElemntTypeList3[i].equals(Elemntlist3.get(i).getText()))
			{
				countEName3++;
			}
		}
		Thread.sleep(2000);
		System.out.println("Count of Available Element type list is:->"+countEName3);
		Assert.assertEquals(2,countEName3);
		System.out.println("All Available ement type is Comming properly.");
		Thread.sleep(1000);
			
		//Select Global Rule and proceed:====
		log.driver.findElement(By.xpath("//div[text()='Global Rule']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Edit Client Rule window is displaying now.");
		
		//Enter the name:==
	    log.driver.findElement(By.xpath("//span[text()='Name:']/following::input[1]")).sendKeys("ExistDimElem1_40334");
	    log.driver.findElement(By.xpath("//span[text()='Name:']/following::input[1]")).click();
	    Thread.sleep(1000);
		    
		String SumFormula2="ExistDimElem("+"\""+"A - Training Sales.[Products].[Product]"+"\","+" "+"\""+"Lotus"+"\" )";
  		Actions act4=new Actions(log.driver);
  		act4.moveToElement(log.driver.findElement(By.xpath("(//span[text()='Edit Client Rule']/following::div[4]//textarea[1])[2]")));
  		act4.click();
  		act4.sendKeys(SumFormula2).build().perform();;
  		Thread.sleep(1000);
	  		
  		//Check Syntax:============
  		log.driver.findElement(By.xpath("//button[text()='Check Syntax']")).click();
  		Thread.sleep(3000);
  		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(3000);

		//add the rule to list
		WebElement e4=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act5=new Actions(log.driver);
        act5.click(e4).sendKeys("Client Rules", Keys.ENTER).build().perform();
        Thread.sleep(2000);
		 
        //Check For Mashup Checkbox should be unselect:=====================
	     Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='ExistDimElem1_40334']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("Client Rule check box are unchecked.");
		 Thread.sleep(1000);
				
		 //Rank Ascending element should be visible:==================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='ExistDimElem1_40334']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("DimParent_40166 client rule is displaying now..");
		
		 //Checkbox should be uncheck and select the checkbox:=============
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='ExistDimElem1_40334']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("ExistDimElem1_40334 client rule is unchecked..");
		 log.driver.findElement(By.xpath("//div[text()='ExistDimElem1_40334']/preceding::div[1]")).click();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
		 Thread.sleep(2000);
				
		 //Click Ok Button:============
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(2000);
		
		 //Validate the client Rule Column:====
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='ExistDimElem1_40334']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Client Rule(ExistDimElem1_40334) is displaying as Column");
 		
		//Property Change:======
		log.driver.findElement(By.xpath("//span[text()='Columns']/following::span[7]/span[2]")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(3000);
		System.out.println("Selection Columns window is displaying now.");
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("(//div[text()='Purchase price']/preceding::div[1])[2]")).click();
		Thread.sleep(1000);
		//log.driver.findElement(By.xpath("(//div[text()='ExistSDLElem0_40334']/preceding::div[1])[2]")).click();
		//Thread.sleep(1000);
		//log.driver.findElement(By.xpath("(//button[@title='Deselect all visible items']/ancestor::div[1])[2]")).click();
		//Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='ExistDimElem1_40334']/preceding::div[1])[1]")).click();
		Thread.sleep(1000);
		 
		//Go For Client Rule Property and provide alias name:======
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isSelected());
		System.out.println("Property Of element window is displaying now.");
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//span[text()='Alias:']/following::input[1]")).clear();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Alias:']/following::input[1]")).sendKeys("ExistDimElem1_40334_Alias");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Automatic priority']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		//Validate For Change in Column:=====
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='ExistDimElem1_40334_Alias']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Client Rule(ExistDimElem1_40334) is displaying as Column");
 		
		 //Save As The Report:=====
		 //Save As:===============
		 log.driver.findElement(By.xpath("//span[text()='Save']/following::span[1]")).click();
		 Thread.sleep(2000);
		 //Click Down and do Save As:====================
		 log.driver.findElement(By.xpath("//span[text()='Save As']")).click();
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Save Report as window is displaying now.");
		
		 //Change Name:===========
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("ClientRules_DimParent");
		 Thread.sleep(2000);
					
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(5000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(5000);
					
		//Delete Report:==================
		log.driver.findElement(By.xpath("(//span[text()='ClientRules_DimParent'])[3]")).click();
		Thread.sleep(3000);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='ClientRules_DimParent'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		log.driver.close();
		 
  }
}
