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

public class TestCase_38023 extends TestUtils
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
	  	System.out.println("38023---Test Task started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 38023: Cockpit Data Mashup Element Properties Check(Value format)");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("======Test Case 25810: Cockpit Data Mashup Element Properties Check(Value format)======");
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
  	  	
		//Add Mashup:============
		//Select calculated element from drop down list:======================
	    WebElement e2=log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]"));
        Actions act2=new Actions(log.driver);
        //act2.click(e2).sendKeys("Calculated elements", Keys.ENTER).build().perform();
        Thread.sleep(2000);
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
		 //Uncheck all the base element and select Mashup:=========
		 log.driver.findElement(By.xpath("//span[contains(text(),'Base elements with container')]/following::div[2]")).click();
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("(//div[text()='MASHUP']/preceding::div[1])[2]")).click();
		 Thread.sleep(2000);
		 //Click on Property:==============
		 log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Properties of element window is displaying.");
		 //Validate Tabs Available:==================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//a[text()='Element']")).isDisplayed());
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//a[text()='Value Format']")).isDisplayed());
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//a[text()='Data Cell']")).isDisplayed());
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//a[text()='Header Cell']")).isDisplayed());
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//a[text()='Chart']")).isDisplayed());
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//a[text()=' Maps ']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("ALL Tabs are available on Elemnt property window.");
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//a[text()='Element']/ancestor::li[1][@aria-selected='true']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Default Button is selected.");
		
		 //Click Value Format Tab:===============
		 log.driver.findElement(By.xpath("//a[text()='Value Format']")).click();
		 
		 //Validate all the element availability:================
		 String[] ActCategoryList={"Default","Number","Currency","Date","Time","Percentage","Scientific","Text"};
		 List<WebElement> Categorylist=log.driver.findElements(By.xpath("(//span[text()='Category'])[1]/following::div[1]//child::span[1]/span[1]"));
		
		int count=0;
		for(int i=0;i<Categorylist.size();i++)
		{
			System.out.println(ActCategoryList[i]+" And "+Categorylist.get(i).getText());
			
			if(ActCategoryList[i].equals(Categorylist.get(i).getText()))
			{
				count++;
			}
		}
		Thread.sleep(2000);
		System.out.println("Count of Category is:->"+count);
		Assert.assertEquals(8,count);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='Format']/following::span[text()='Default'])[1]")).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//input[@id='helpbutton']")).isEnabled());
		Thread.sleep(1000);
		
		//Click on Number and Proceed:==================
		log.driver.findElement(By.xpath("//span[text()='Number']")).click();
		Thread.sleep(2000);
		
		String[] ActFormatList={"1234.50","1,234.50","-1234.50","-1,234.50","1,234.50 T","1,234.50 Mio"};
		List<WebElement> Formatlist=log.driver.findElements(By.xpath("//span[text()='Format']/following::ul[1]//span/span"));
		
		int countFormat=0;
		for(int i=0;i<Formatlist.size();i++)
		{
			System.out.println(ActFormatList[i]+" And "+Formatlist.get(i).getText());
			if(ActFormatList[i].equals(Formatlist.get(i).getText()))
			{
				countFormat++;
			}
		}
		Thread.sleep(2000);
		System.out.println("Count of Number Format is:->"+countFormat);
		Assert.assertEquals(6,countFormat);
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Digits:']/following::input[@value='2']")).isEnabled());
		Thread.sleep(1000);
		System.out.println("Default Digits Field is Displaying.");
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Factor:']/following::input[@value='1.00000000000000']")).isDisplayed());
		Thread.sleep(1000);
		
		//Click Any format and validate it is selected/not??
		log.driver.findElement(By.xpath("//span[text()='1,234.50 Mio']/ancestor::div[1]")).click();
		Thread.sleep(2000);
		if("true".equals(log.driver.findElement(By.xpath("//span[text()='1,234.50 Mio']/ancestor::li[1]")).getAttribute("aria-selected")))
		{
			System.out.println("Required text is selected.");
		}
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='1000 separator:']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		//Verify Factor Field:======================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Factor:']/following::input[@value='0.000001000000000']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Factor field value changed after select 1,234.50Mio.");
		
		//Display value after Mio Should be display:===============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display Values']/following::input[2][@value=' Mio']")).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display Negative Values']/following::input[2][@value=' Mio']")).isDisplayed());
		Thread.sleep(1000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		//Write Mashup Value:==================
		/*Robot robot=new Robot();
		log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		
		Actions act=new Actions(log.driver);
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).perform();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Single data Cell window is displaying.");
		
		 //Verify Write window after click on same:===========
		 log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Please enter a value.']")).isDisplayed());
		 Thread.sleep(1000);
		 //enter input value for mashup cell:===========
		 //=E1
		 log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=E1");
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(3000);
		 String NumberMioMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		 Thread.sleep(2000);
		 System.out.println("Mashup Cell value for Number_Mio case is:->"+NumberMioMashupValue);
		 
		 //Validate Number :=====
		 int CountMio=0;
		 if(NumberMioMashupValue.contains("Mio"))
		 {
			 System.out.println("Number is a Mio Number as Expected.");
			 CountMio++;
		 }
		 Assert.assertEquals(CountMio,1);
		 
		 //Right click on Mashup Column:->>ContextMenu property window:======
		 /*log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		 Thread.sleep(2000);
		 robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyRelease(KeyEvent.VK_RIGHT); 
	     Thread.sleep(1000);*/
		 act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']"))).perform();
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("//span[text()='Element properties...']")).click();
		 Thread.sleep(3000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Properties of element window is displaying.");
		 
		 //Validate Default Selected One:================
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//a[text()='Element']/ancestor::li[1][@aria-selected='true']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Default Button is selected.");
		 //Click Value Format Tab:===============
		 log.driver.findElement(By.xpath("//a[text()='Value Format']")).click();
		 
		 //Select Currency:==================
		 log.driver.findElement(By.xpath("//span[text()='Currency']")).click();
		 Thread.sleep(2000);
		 String[] ActCurrencyList={"$1234.50","$1,234.50","($1234.50)","($1,234.50)","(T$1.234)","(Mio $1.23)"};
		 List<WebElement> Currencylist=log.driver.findElements(By.xpath("//span[text()='Format']/following::ul[1]//span/span"));
		
		 int countCurrency=0;
		 for(int i=0;i<Currencylist.size();i++)
		 {
			System.out.println(ActCurrencyList[i]+" And "+Currencylist.get(i).getText());
			if(ActCurrencyList[i].equals(Currencylist.get(i).getText()))
			{
				countCurrency++;
			}
		 }
		 Thread.sleep(2000);
		 System.out.println("Count of Currency Format is:->"+countCurrency);
		 Assert.assertEquals(6,countCurrency);
		 
		//Check Color:====
		String ExpectedColr=log.driver.findElement(By.xpath("//label[text()='Colored:']/following::span[1]")).getCssValue("color");
		System.out.println("Expected Color is:->"+ExpectedColr);
		Assert.assertEquals("rgba(255, 0, 0, 1)", ExpectedColr);
		
		//Factor:=====
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Factor:']/following::input[@value='0.000001000000000']")).isDisplayed());
		Thread.sleep(1000);
		
		//enter ->4 in Digit  field:=====
		log.driver.findElement(By.xpath("//span[text()='(T$1.234)']/ancestor::div[1]")).click();
		Thread.sleep(2000);
		if("true".equals(log.driver.findElement(By.xpath("//span[text()='(T$1.234)']/ancestor::li[1]")).getAttribute("aria-selected")))
		{
			System.out.println("Required text is selected.");
		}
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Currency:']/following::input[@value='T$']")).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='1000 separator:']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		//validate Mashup Cell:==============
		String MashupCurrencyValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		int CountCurrency=0;
		if(MashupCurrencyValue.contains("T$"))
		 {
			 System.out.println("Number is a Currency(T$) Number as Expected.");
			 CountCurrency++;
		 }
		Assert.assertEquals(CountCurrency,1);
		
		//Percentage Now:=====================
		/*log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']"))).perform();
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Element properties...']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Properties of element window is displaying.");
	 
		//Validate Default Selected One:================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//a[text()='Element']/ancestor::li[1][@aria-selected='true']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Default Button is selected.");
		//Click Value Format Tab:===============
		log.driver.findElement(By.xpath("//a[text()='Value Format']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Currency:']/following::input[@value='T$']")).isDisplayed());
		Thread.sleep(1000);
		
		//Click Percentage:============
		 log.driver.findElement(By.xpath("//span[text()='Percentage']")).click();
		 Thread.sleep(2000);
		 String[] ActPercentageList={"0.12 %","-0.12 %","12.00 % (*100)","-12.00 % (*100)"};
		 List<WebElement> Percentagelist=log.driver.findElements(By.xpath("//span[text()='Format']/following::ul[1]//span/span"));
		
		 int countPercentage=0;
		 for(int i=0;i<Percentagelist.size();i++)
		 {
			System.out.println(ActPercentageList[i]+" And "+Percentagelist.get(i).getText());
			if(ActPercentageList[i].equals(Percentagelist.get(i).getText()))
			{
				countPercentage++;
			}
		 }
		 Thread.sleep(2000);
		 System.out.println("Count of percentage Format is:->"+countPercentage);
		 Assert.assertEquals(4,countPercentage);
		 
		 //Display Value Issue:=====================
		 
		/* Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display Values']/following::input[2][@value=' %']")).isDisplayed());
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display Negative Values']/following::input[2][@value=' %']")).isDisplayed());
		 Thread.sleep(1000);*/
		
		//Select one percentage and proceed:===
		log.driver.findElement(By.xpath("//span[text()='-12.00 % (*100)']/ancestor::div[1]")).click();
		Thread.sleep(2000);
		
		if("true".equals(log.driver.findElement(By.xpath("//span[text()='-12.00 % (*100)']/ancestor::li[1]")).getAttribute("aria-selected")))
		{
			System.out.println("Required text is selected.");
		}
		Thread.sleep(1000);
		//Validate Factor Field:(Also Having issue)====
		/*Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Factor:']/following::input[@value='100.0000000000000']")).isDisplayed());
		Thread.sleep(1000);*/
		
		String ExpectedColr2=log.driver.findElement(By.xpath("//label[text()='Colored:']/following::span[1]")).getCssValue("color");
		System.out.println("Expected Color is:->"+ExpectedColr2);
		Assert.assertEquals("rgba(255, 0, 0, 1)", ExpectedColr2);
		
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		//Validate Percentile '%' in Number:=====
		//Same Issue:=====
		String MashupPercentageValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		int CountPercentage=0;
		if(MashupPercentageValue.contains("%"))
		 {
			 System.out.println("Number is a Percentage(%) Number as Expected.");
			 CountPercentage++;
		 }
		Assert.assertEquals(CountPercentage,1);
		
		//Scientific Value:================
		/*log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']"))).perform();
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Element properties...']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Properties of element window is displaying.");
	 
		//Validate Default Selected One:================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//a[text()='Element']/ancestor::li[1][@aria-selected='true']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Default Button is selected.");
		//Click Value Format Tab:===============
		log.driver.findElement(By.xpath("//a[text()='Value Format']")).click();
		Thread.sleep(1000);
		//Previous check:===========================
		//(Having Issue:==========))))
		
		//Click on Scientific and Proceed:==================
		log.driver.findElement(By.xpath("//span[text()='Scientific']")).click();
		Thread.sleep(2000);
		String[] ActScientificList={"1,2E+01","-1,2E+01"};
		List<WebElement> Scientificlist=log.driver.findElements(By.xpath("//span[text()='Format']/following::ul[1]//span/span"));
		
		int countScientific=0;
		for(int i=0;i<Scientificlist.size();i++)
		{
			System.out.println(ActScientificList[i]+" And "+Scientificlist.get(i).getText());
			if(ActScientificList[i].equals(Scientificlist.get(i).getText()))
			{
				countScientific++;
			}
		}
		Thread.sleep(2000);
		System.out.println("Count of Scientific Format is:->"+countScientific);
		Assert.assertEquals(2,countScientific);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='Colored:']/ancestor::div[1]")).isEnabled());
		Thread.sleep(1000);
		//Select one percentage and proceed:============
		log.driver.findElement(By.xpath("//span[text()='-1,2E+01']/ancestor::div[1]")).click();
		Thread.sleep(2000);
		if("true".equals(log.driver.findElement(By.xpath("//span[text()='-1,2E+01']/ancestor::li[1]")).getAttribute("aria-selected")))
		{
			System.out.println("Required text is selected.");
		}
		Thread.sleep(1000);
		//Validate Factor Field:=================
		//Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Factor:']/following::input[@value='1.00000000000000']")).isDisplayed());
		//Thread.sleep(1000);
		
		//Change in color Value Validate:=================
		String ExpectedScitificColr=log.driver.findElement(By.xpath("//label[text()='Colored:']/following::span[1]")).getCssValue("color");
		System.out.println("Expected Scientific Color is:->"+ExpectedScitificColr);
		Assert.assertEquals("rgba(255, 0, 0, 1)", ExpectedScitificColr);
		
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		//validate:==============
		String MashupScientificValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		int CountScientific=0;
		if(MashupScientificValue.contains("E"))
		 {
			 System.out.println("Number is a Scientific(%) Number as Expected.");
			 CountScientific++;
		 }
		Assert.assertEquals(CountScientific,1);
		
		//Text:======================
		/*log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']"))).perform();
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Element properties...']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Properties of element window is displaying.");
	 
		//Validate Default Selected One:================
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//a[text()='Element']/ancestor::li[1][@aria-selected='true']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Default Button is selected.");
		//Click Value Format Tab:===============
		log.driver.findElement(By.xpath("//a[text()='Value Format']")).click();
		Thread.sleep(1000);
		
		//previous Value check(Issue)===========
		//Click Text:========
		log.driver.findElement(By.xpath("//span[text()='Text']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Format']/following::span[2][text()='Text']")).isDisplayed());
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display Values']/following::span[text()='Before:'][1]/following::input[1]")).isEnabled());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display Values']/following::span[text()='After:'][1]/following::input[1]")).isEnabled());
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//span[text()='Display Values']/following::span[text()='After:'][1]/following::input[1]")).sendKeys("Text");
		
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		//validate:==============
		String MashupTextValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		int CountText=0;
		if(MashupTextValue.contains("Text"))
		 {
			 System.out.println("Number is a Text Number as Expected.");
			 CountText++;
		 }
		Assert.assertEquals(CountText,1);
		
		//Save the Report:============
	  	log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Save']/following::span[1]")).click();
  		Thread.sleep(2000);
  		//Click Down and do Save As:====================
  		log.driver.findElement(By.xpath("//span[text()='Save As']")).click();
  		Thread.sleep(2000);
  		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report as']")).isDisplayed());
  		Thread.sleep(1000);
  		System.out.println("Save Report as window is displaying now.");
  		
  		//Change Name:===========
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys(": Mashup_element_properties_check_ValueFormat");
  		Thread.sleep(2000);
  		
  		//click folder:========
  		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
  		Thread.sleep(5000);
  		//Click Ok Button:============
  		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
  		Thread.sleep(5000);
  		
  		//Delete Report:==================
  		log.driver.findElement(By.xpath("(//span[text()=': Mashup_element_properties_check_ValueFormat'])[3]")).click();
  		Thread.sleep(3000);
  		act.contextClick(log.driver.findElement(By.xpath("(//span[text()=': Mashup_element_properties_check_ValueFormat'])[1]"))).perform();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
  		Thread.sleep(2000);
  		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
  		Thread.sleep(2000);
  		log.driver.close();
		
	  
  }
}
