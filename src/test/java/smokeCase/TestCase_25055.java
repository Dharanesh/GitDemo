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

public class TestCase_25055 extends TestUtils
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
	    System.out.println("25055---Testcase started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 25055:Cockpit Data Mashup Analytical Viz_Gradient");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("Test Case 25055:Cockpit Data Mashup Analytical Viz_Gradient===================");
	  	Utils.waitForElement("");
	  	
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
	  	//==========================================
  	  	//Other Element:==========
		WebElement RowElement=log.driver.findElement(By.xpath("(//div[text()='Rows']/following::div[@class='k-list-scroller k-selectable'])[2]/ul"));
		WebElement BackGroundloc=log.driver.findElement(By.xpath("(//div[text()='Background'])[1]/following::div[1]/div/div"));
		
	    Actions builder  = new Actions(log.driver);  
		builder.dragAndDrop(RowElement,BackGroundloc).perform();
		Thread.sleep(5000);
		
		log.driver.findElement(By.xpath("//span[text()='Properties']")).click();
	    Thread.sleep(2000);
	    log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
	    Thread.sleep(1000);
	  
		//Customer To Row:=================
		WebElement RowElement2=log.driver.findElement(By.xpath("(//span[text()='Customer'])[2]"));
		WebElement Rowloc=log.driver.findElement(By.xpath("//div[text()='Rows']/following::div[5]/div[1]"));
		//Thread.sleep(1000);
		
		Actions builder2 = new Actions(log.driver);  
		builder2.dragAndDrop(RowElement2,Rowloc).perform();
		Thread.sleep(5000);
		
  	  	//Go For Time and Add only 2014 and 2015 column:===========
  	    //Click on DataView Designer window:================
  	    log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dataview Designer']/following::div[text()='Background'][1]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Data View Designer window is displaying.");
		Thread.sleep(1000);
		
		//Add all Customers:======================
		log.driver.findElement(By.xpath("(//div[text()='Rows']/following::span[text()='Customer'])[1]")).click();
  	    Thread.sleep(3000);
  	   // log.driver.findElement(By.xpath("//button[@title='Inserts all visible items to the selection list']/span[1]")).click();
	    //Thread.sleep(3000);
		log.driver.findElement(By.xpath("(//button[@data-title='Select all visible items'])[1]")).click();
	    Thread.sleep(3000);
	    log.driver.findElement(By.xpath("//button[@data-id='30157']")).click();
	    Thread.sleep(2000);
	    log.driver.findElement(By.xpath("//input[@value='OK']")).click();
  	    Thread.sleep(3000);
		
		//Click Time link in Column:===========
		log.driver.findElement(By.xpath("(//div[text()='Columns']/following::span[text()='Time'])[1]")).click();
  	    Thread.sleep(3000);
  	    Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Selection for column window opened now.");
		
		//Remove all base elements:===============
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
  	    Thread.sleep(3000);
		//Select 2014 & 2015:======================
  	    log.driver.findElement(By.xpath("//div[text()='2014']/preceding::div[1]")).click();
	    Thread.sleep(2000);
	   // log.driver.findElement(By.xpath("//div[text()='2015']/preceding::div[1]")).click();
  	   // Thread.sleep(2000);
  	    log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();
	    Thread.sleep(3000);
  	  	
	    //Select calculated element from drop down list:======================
	    WebElement e2=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act=new Actions(log.driver);
        //act.click(e2).sendKeys("Calculated elements", Keys.ENTER).build().perform();
        act.click(e2).perform();
        Thread.sleep(2000);
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.DOWN).perform();
        Thread.sleep(500);
        act.sendKeys(Keys.ENTER).perform();
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
		 Thread.sleep(2000);
	  	
		 //Mashup is Added to the table verify:================
		 //log.driver.findElement(By.xpath("//div[text()='MASHUP']")).click();
		// Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
	 	 Thread.sleep(2000);
		 System.out.println("MASHUP is added in Table.");
		 Thread.sleep(2000);
		 
		//Mashup cell should display write on rightclick opt:=====
		log.driver.findElement(By.xpath("//div[@id='1/0']")).click();
		Thread.sleep(2000);
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).perform();
		Thread.sleep(2000);
		//Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		//Thread.sleep(1000);
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
		//=getcelvalue(1,1,"Sales")
		String Value="="+"getcellvalue"+"("+"1"+","+"1"+","+"\""+"Sales"+"\""+")";
			
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys(Value);
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		String ExptVal=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		
		//String ActualVal=log.driver.findElement(By.xpath("//div[text()='All Customers']/following::div[@id='0/0']")).getText();
		String ActualVal=log.driver.findElement(By.xpath("//div[@id='0/0']")).getText();
		Thread.sleep(2000);
  	 
		Assert.assertEquals(ExptVal, ActualVal);
  	    System.out.println("Mashup Value is Comming properly as expected.");
  	    Thread.sleep(2000);
		 
		//Validate after add AV to table:=============
  		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']"))).perform();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).click();
		Thread.sleep(1000);
		
		act.moveToElement(log.driver.findElement(By.xpath("//span[text()='New...']"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='New...']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='New Analytical Visualization']")).isDisplayed());
		System.out.println("New Analytical Visualization window is displaying now.");
		 
		
	  	String[] AvList={"Threshold","Gradient","In Cell Bar","Minichart"};
	  	List<WebElement> ActAVList=log.driver.findElements(By.xpath("//span[text()='New Analytical Visualization']/following::span[@class='reportNametxt']"));
	  	
	  	int count=0;
	  	for(int i=0;i<AvList.length;i++)
	  	{
	  		if(AvList[i].equals(ActAVList.get(i).getText()))
	  		{
	  			count++;	
	  		}
	  	}
	  	Assert.assertEquals(count,4);
	  	System.out.println("All New Analytical Visualization types are available.");
		
	  	//Check for Default:=============
	  	Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Creates a new threshold analysis.']")).isDisplayed());
		System.out.println("Default New Analytical Visualization window is displaying now."); 	
	  	
		//Select Gradient and proceed:=======
		log.driver.findElement(By.xpath("//span[text()='Gradient']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Creates a new gradient analysis.']")).isDisplayed());
		System.out.println("Av as Gradient is selected."); 
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Gradient Analysis'])[1]")).isDisplayed());
		System.out.println("Gradient Analysis window is displaying now."); 
		Thread.sleep(1000);
		//Enter Caption and proceed:=================
		log.driver.findElement(By.xpath("//div[text()='Caption']/following::input[1]")).clear();
		log.driver.findElement(By.xpath("//div[text()='Caption']/following::input[1]")).sendKeys("Datamashup Visualization ");
		Thread.sleep(2000);
		
		//Validate Meesage after click on link:========
		log.driver.findElement(By.xpath("//div[text()='Color for minimum']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//div[text()='Color for minimum']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//p[text()='Color for minimum']")).isDisplayed());
		System.out.println("After click on link,respected message is displaying."); 
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//div[text()='Color for minimum']/following::button[1]")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select color']")).isDisplayed());
		System.out.println("Select Color window is displaying."); 
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//span[text()='Select color']/following::table[@class='w20_dlgcolor']/tbody/tr[2]/td[1]")).click();
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		//Name & Description window:========
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Gradient Mashup analysis");
		Thread.sleep(2000);
		
		
		log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
		Thread.sleep(2000);
		
		//Click On Finish Button:==============
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'Assignment')]")).isDisplayed());
		System.out.println("Assignment window is displaying."); 
		
		log.driver.findElement(By.xpath("//a[contains(text(),'Allocation')]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//div[text()='MASHUP'])[1]")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//a[contains(text(),'Data area')]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//div[@id='-1/-1'])[2]")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		//Validate with color:=======================
		
		String BGColor=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getCssValue("background-color");
		Thread.sleep(2000);
		
		System.out.println("BG Color is:->"+BGColor);
		int count2=0;
		if(BGColor.contains("0, 0, 255"))
		{
			count2++;
		}
		//Rgba and rgb issue in firefox and chrome:=============
		Assert.assertEquals(count2,1);
		Thread.sleep(2000);
		System.out.println("AV is Reflected on report.");
		Thread.sleep(2000);
		
		//Filter:====
		log.driver.findElement(By.xpath("(//span[text()='Category'])[1]/following::button[1]")).click();
		Thread.sleep(3000);
		
		/*try
		{
			Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[contains(text(),'Select elements')])[1]")).isDisplayed());
			Thread.sleep(2000);
			System.out.println("Select Element window is displaying now.");
			
		}catch(Exception e)
		{
			log.driver.findElement(By.xpath("(//span[text()='Category'])[1]/following::button[1]")).click();
			Thread.sleep(2000);
			System.out.println("Select Element window is displaying now.");
			Thread.sleep(1000);
		}
		Thread.sleep(3000);*/
		
		log.driver.findElement(By.xpath("//div[text()='Veteran']")).click();
		Thread.sleep(2000);
		//log.driver.findElement(By.xpath("//input[@value='OK']")).click();/preceding::div[1]/input[1]
		//Thread.sleep(2000);
		
		//Validate with File:==================
		String ExptVal2=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		
		String ActualVal2=log.driver.findElement(By.xpath("//div[text()='All Customers']/following::div[@id='0/0']")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(ExptVal2, ActualVal2);
  	    System.out.println("Mashup Value is Comming properly as expected after Filter.");
  	    Thread.sleep(2000);
		
  	    String BGColor2=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getCssValue("background-color");
		Thread.sleep(2000);
		
		System.out.println("BG Color is:->"+BGColor2);
		//Assert.assertEquals(BGColor2,"rgba(0, 0, 255, 1)");
		int count3=0;
		if(BGColor.contains("0, 0, 255"))
		{
			count3++;
		}
		//Rgba and rgb issue in firefox and chrome:=============
		Assert.assertEquals(count3,1);
		Thread.sleep(2000);
		System.out.println("AV is Reflected on report after Filter.");
  	    
		log.driver.close();
		
		
		
  }
}
