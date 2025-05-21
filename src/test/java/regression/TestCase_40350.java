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

public class TestCase_40350 extends TestUtils
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
	    System.out.println("40350---Test Task started........");
		//login to the application:==========
	  	test =extent.createTest("Test Task 40350: Test Case 29007: 14457 : Cockpit Client Rules dimension based - dynamic share calculation");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("==Test Task 40350: Test Case 29007: 14457 : Cockpit Client Rules dimension based - dynamic share calculation==");
	  	Thread.sleep(3000); 
	  	
	  	//Create report on Sales cube:====
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
		log.driver.findElement(By.xpath("//div[text()='Sales']")).click();
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
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("Dynamic share calculation");;
		Thread.sleep(1000);
				
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(1000);
		//Click on Finish Button:=====
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(1000);
		System.out.println("New Report is created for Dynamic share calculation.");
		Thread.sleep(3000);
		
		//=======================================
		//Drag Product to Column:===========
		log.driver.findElement(By.xpath("//span[text()='Properties']")).click();
	    Thread.sleep(2000);
	    log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
	    Thread.sleep(2000);
		WebElement ColumnElement=log.driver.findElement(By.xpath("(//span[text()='Columns']/following::div[@class='k-list-scroller k-selectable'])[2]/ul"));
		WebElement BackGroundloc2=log.driver.findElement(By.xpath("(//span[text()='Background'])[2]/following::div[1]/div/div"));
		Thread.sleep(2000);
		
		Actions builder3 = new Actions(log.driver);
		builder3.dragAndDrop(ColumnElement,BackGroundloc2).perform();
		Thread.sleep(5000);
				
		log.driver.findElement(By.xpath("//li[@id=\"refresh_report\"]")).click();
  	    Thread.sleep(3000);
			    
		//Product To Column:=================
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Product'])[2]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Product is displaying");
		
		WebElement ColumnElement_P=log.driver.findElement(By.xpath("(//span[text()='Product'])[2]"));
		WebElement Columnloc_P=log.driver.findElement(By.xpath("//span[text()='Columns']/following::div[5]/div[1]"));
	    Thread.sleep(2000);
	    
		Actions builder_p= new Actions(log.driver);
		builder_p.dragAndDrop(ColumnElement_P,Columnloc_P).perform();
		Thread.sleep(5000);
		
		//DataView Designer:================
		log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dataview Designer']/following::span[text()='Background'][2]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Data View Designer window is displaying.");
		Thread.sleep(2000);
		//Drag Customer to Row:==============
		WebElement RowElement=log.driver.findElement(By.xpath("(//span[text()='Rows']/following::div[@class='k-list-scroller k-selectable'])[2]/ul"));
		WebElement BackGroundloc=log.driver.findElement(By.xpath("(//span[text()='Background'])[2]/following::div[1]/div/div"));
		
	    Actions builder  = new Actions(log.driver);  
		builder.dragAndDrop(RowElement,BackGroundloc).perform();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//span[text()='Properties']")).click();
	    Thread.sleep(2000);
	    log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
	    Thread.sleep(2000);
					  	
		//Customer To Row:=================
		WebElement RowElement2=log.driver.findElement(By.xpath("(//span[text()='Customer'])[1]"));
	    Thread.sleep(1000);
		WebElement Rowloc=log.driver.findElement(By.xpath("//span[text()='Rows']/following::div[5]/div[1]"));
	    Thread.sleep(1000);
	    
		Actions builder2 = new Actions(log.driver);  
		builder2.dragAndDrop(RowElement2,Rowloc).perform();
		Thread.sleep(5000);
		
		//===============================================================
		
		//Click on Product:===
		log.driver.findElement(By.xpath("//span[text()='Columns']/following::span[7]/span[2]")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(2000);
		
		//Click on Element group and then container element:===
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
		
		//Select Container Element and proceed:=====
		log.driver.findElement(By.xpath("(//span[text()='Container elements'])[1]")).click();
		Thread.sleep(2000);
		//Delete the created one:===============
		List<WebElement> ClientRules=log.driver.findElements(By.xpath("//span[text()='Elements']/following::ul[1]/li/div//span/span[2]"));
		for(int i=0;i<ClientRules.size();i++)
		{
			System.out.println(ClientRules.get(i).getText());
			if(ClientRules.get(i).getText().equals("SUV Sold_40350"))
			{
				System.out.println("Client Rule Found");
				log.driver.findElement(By.xpath("//span[text()='SUV Sold_40350']")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
				Thread.sleep(2000);
				break;
			}
		}
		//Click new:======
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
		
		//Select Criteria DDL and proceed:====
		log.driver.findElement(By.xpath("//div[text()='Criteria DDL']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		
		//Provide Name and Description:============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Name and Description window is displaying now.");
		
		//Enter the name:==
	    log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("SUV Sold_40350");
	    log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).click();
	    Thread.sleep(500);
		
	    log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(500);
	    log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
	    
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Preselection of Elements']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("preselection of elements window is displaying now.");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
	    
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Criteria']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Element criteria window is displaying now.");
		log.driver.findElement(By.xpath("//button[text()='Add']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//label[text()='S-Elements']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//label[text()='C-Elements']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//label[text()='R-Elements']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Element Criteria']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Element criteria window is displaying now.");
		
		//add the Car type to list:======================
		WebElement e3=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
		Actions act3=new Actions(log.driver);
		act3.click(e3).sendKeys("CarType", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("(//span[text()='Filter for attribute value:'])[1]/following::input[2]")).clear();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("(//span[text()='Filter for attribute value:'])[1]/following::input[2]")).sendKeys("*SUV*");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
	    
		//Click on Finish Button:===================
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(1000);
		
		//Create One Data DDL:================
		List<WebElement> ClientRules2=log.driver.findElements(By.xpath("//span[text()='Elements']/following::ul[1]/li/div//span/span[2]"));
		for(int i=0;i<ClientRules2.size();i++)
		{
			System.out.println(ClientRules2.get(i).getText());
			if(ClientRules2.get(i).getText().equals("SUV Sold_2_40350"))
			{
				System.out.println("Client Rule Found");
				log.driver.findElement(By.xpath("//span[text()='SUV Sold_2_40350']")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
				Thread.sleep(2000);
				break;
			}
		}
		//Click new:======
		log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Element']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("New Element window is displaying now.");
		
		//Select Criteria DDL and proceed:====
		log.driver.findElement(By.xpath("//div[text()='Data DDL']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		
		//Provide Name and Description:============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Name and Description window is displaying now.");
		
		//Enter the name:==
	    log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("SUV Sold_2_40350");
	    log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).click();
	    Thread.sleep(500);
		
	    log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(500);
	    log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Preselection of Elements']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("preselection of elements window is displaying now.");
		
		//Select Following:=====
		log.driver.findElement(By.xpath("//label[contains(text(),'Following elements are used for the creation of the DDL')]")).click();
		Thread.sleep(1000);
		//Click on Selection button:==========
		log.driver.findElement(By.xpath("//button[text()='Selection...']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("selcetion for column window is displaying.");
		
		//Go For Element group and select container element:=====
		//add the rule to list:======================
		WebElement e4=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
		Actions act4=new Actions(log.driver);
		act4.click(e4).sendKeys("Container elements", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		//Add created DDL:===============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='SUV Sold_40350']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("SUV Sold_40350 ddl is displaying now..");
		
		//Checkbox should be uncheck and select the checkbox:=============
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='SUV Sold_40350']/preceding::div[1]")).isSelected());
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='SUV Sold_40350']/preceding::div[1]")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(5000);
		 
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		//Select Cube window :===============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Cube Selection']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Cube Selection Window is displaying now.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		//Data Area Window:=============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Limitation of the data area']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Limitation of the data area Window is displaying now.");
		Thread.sleep(1000);
		//Uncheck Measure:====================
		log.driver.findElement(By.xpath("(//div[text()='Measures'])[1]/preceding::div[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='Measures'])[1]/following::div[2]")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for value range of Data DDL')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Selection for value range of Data DDL Window is displaying now.");
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[contains(text(),'Current elements')]/following::div[text()='Purchase price'])[1]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Purchase price is displaying in current element list.");
		
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Value Comparison and Settings']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Value Comparison and Settings Window is displaying now.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Sorting and Limiting']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Sorting and Limiting Window is displaying now.");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		//Click on Finish Button:=====
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(1000);
		
		//Create Client Rule:=================
		//Click Client Rule and proceed:========
		log.driver.findElement(By.xpath("(//span[text()='Client Rules'])[1]")).click();
		Thread.sleep(2000);
		//Delete:=================
		List<WebElement> ClientRules3=log.driver.findElements(By.xpath("//span[text()='Elements']/following::ul[1]/li/div//span/span[2]"));
		for(int i=0;i<ClientRules3.size();i++)
		{
			System.out.println(ClientRules3.get(i).getText());
			if(ClientRules3.get(i).getText().equals("ClientRule_40350"))
			{
				System.out.println("Client Rule Found");
				log.driver.findElement(By.xpath("//span[text()='ClientRule_40350']")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
				Thread.sleep(2000);
				break;
			}
		}
		//Create New:==============
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
		System.out.println("Count of Available Element type list is:->"+countEName2);
		Assert.assertEquals(2,countEName2);
		System.out.println("All Available ement type is Comming properly.");
		Thread.sleep(1000);
		
		//Select Dimension Rule and proceed:====
		log.driver.findElement(By.xpath("//div[text()='Dimension Rule']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Edit Client Rule window is displaying now.");
		
		//Enter the name:==
	    log.driver.findElement(By.xpath("//span[text()='Name:']/following::input[1]")).sendKeys("ClientRule_40350");
	    log.driver.findElement(By.xpath("//span[text()='Name:']/following::input[1]")).click();
	    Thread.sleep(1000);
	    
	    String SumFormula="SumOfDDL("+"\""+"Sales.[Product].[Product]"+"\","+"SUV  Sold2"+"\")";
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
		
		//Again Create Dimension rule:==========
		/*(SumOfDDL (  "Sales.[Product].[Product]","SUV Sold2")/
			    GetValue( ["Sales.[Measures]","Purchase  price"]))*100*/
	    
		log.driver.findElement(By.xpath("(//span[text()='Client Rules'])[1]")).click();
		Thread.sleep(2000);
		//Delete:=================
		List<WebElement> ClientRules4=log.driver.findElements(By.xpath("//span[text()='Elements']/following::ul[1]/li/div//span/span[2]"));
		for(int i=0;i<ClientRules4.size();i++)
		{
			System.out.println(ClientRules4.get(i).getText());
			if(ClientRules4.get(i).getText().equals("share of SUVs sold_40350"))
			{
				System.out.println("Client Rule Found");
				log.driver.findElement(By.xpath("//span[text()='share of SUVs sold_40350']")).click();
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
		//Select Dimension Rule and proceed:====
		log.driver.findElement(By.xpath("//div[text()='Dimension Rule']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Edit Client Rule window is displaying now.");
		
		//Enter the name:==
	    log.driver.findElement(By.xpath("//span[text()='Name:']/following::input[1]")).sendKeys("share of SUVs sold_40350");
	    log.driver.findElement(By.xpath("//span[text()='Name:']/following::input[1]")).click();
	    Thread.sleep(1000);
	    
	    ///*(SumOfDDL (  "Sales.[Product].[Product]","SUV Sold2")/GetValue( ["Sales.[Measures]","Purchase  price"]))*100*/
	    
	    String SumFormula2="(SumOfDDL("+"\""+"Sales.[Product].[Product]"+"\","+"SUV  Sold2"+"\")/GetValue( ["+"\""+"Sales.[Measures]"+"\","+"\""+"Purchase  price"+"\"]))*100";
 		Actions act2=new Actions(log.driver);
 		act2.moveToElement(log.driver.findElement(By.xpath("(//span[text()='Edit Client Rule']/following::div[4]//textarea[1])[2]")));
 		act2.click();
 		act2.sendKeys(SumFormula2).build().perform();;
 		Thread.sleep(1000);
	    
 		//Check Syntax:============
 		log.driver.findElement(By.xpath("//button[text()='Check Syntax']")).click();
 		Thread.sleep(3000);
 		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(3000);
		
		//add the rule to list
		WebElement e5=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
		Actions act5=new Actions(log.driver);
		act5.click(e5).sendKeys("Client Rules", Keys.ENTER).build().perform();
		Thread.sleep(2000);
				  		
        //Check For Mashup Checkbox should be unselect:=====================
	     Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='share of SUVs sold_40350']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("Client Rule check box are unchecked.");
		 Thread.sleep(1000);
						
		 //Rank Ascending element should be visible:==================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='share of SUVs sold_40350']")).isDisplayed());
		 Thread.sleep(2000);
		 System.out.println("share of SUVs sold_40350 client rule is displaying now..");
		
		 //Checkbox should be uncheck and select the checkbox:=============
		 Assert.assertEquals(false,log.driver.findElement(By.xpath("//div[text()='share of SUVs sold_40350']/preceding::div[1]")).isSelected());
		 Thread.sleep(1000);
		 System.out.println("share of SUVs sold_40350 client rule is unchecked..");
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("//div[text()='share of SUVs sold_40350']/preceding::div[1]")).click();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		 Thread.sleep(2000);
		 
		 //Validate:=============
		 
		 //Save:===============
		 
		 
  }
}
