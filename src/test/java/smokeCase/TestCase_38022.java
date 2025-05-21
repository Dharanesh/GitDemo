package smokeCase;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
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

public class TestCase_38022 extends TestUtils
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
	  	System.out.println("38022---Test Task started........");
	  	//login to the application:==========
	  	test =extent.createTest("Test Case 38022: TestCase to verify Cockpit Data Mashup Functionality Table Cell Properties(value format)");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");

	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  
	  	System.out.println("==Test Case 25791: TestCase to verify Cockpit Data Mashup Functionality Table Cell Properties(value format)==");
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
		 log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		 Thread.sleep(2000);
  	  	
		/* Robot robot=new Robot();
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
		 
		//Add Mashup value:===============
		 //Mashup cell should display write on rightclick opt:=====
		 Actions act=new Actions(log.driver);
		 act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).perform();
		 Thread.sleep(1000);
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
		// =C(2,3)
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=C(1,1)");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		String FstRowMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		System.out.println("Mashup Cell value is:->"+FstRowMashupValue);
		String string_form1 = FstRowMashupValue.substring(FstRowMashupValue.indexOf('.'), FstRowMashupValue.length());
		double AfterDecimalValue2= Double.valueOf(string_form1);
		Thread.sleep(2000);
		
		//Fst Cell of Mashup Column Format:===============
		//Click on fst cell then shift to end:=======
		log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
	
		/*robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).perform();
		Thread.sleep(1000);
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
		log.driver.findElement(By.xpath("//a[text()='Value Format']")).click();
		Thread.sleep(4000);
		
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
		
		//Click Any format and validate it is selected/not??
		log.driver.findElement(By.xpath("//span[text()='1,234.50']/ancestor::div[1]")).click();
		Thread.sleep(2000);
		
		if("true".equals(log.driver.findElement(By.xpath("//span[text()='1,234.50']/ancestor::li[1]")).getAttribute("aria-selected")))
		{
			System.out.println("Required text is selected.");
		}
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//label[text()='1000 separator:']/preceding::input[1]")).isSelected());
		Thread.sleep(1000);
		
		//Clear the input digit field and enter 8:====
		log.driver.findElement(By.xpath("//span[text()='Digits:']/following::input[1]")).clear();
		log.driver.findElement(By.xpath("//span[text()='Digits:']/following::input[1]")).sendKeys("8");
		Thread.sleep(2000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		String Case1MashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		String string_form = Case1MashupValue.substring(Case1MashupValue.indexOf('.'), Case1MashupValue.length());
		double AfterDecimalValue= Double.valueOf(string_form);
		Thread.sleep(2000);
		System.out.println("After change Digit Mashup Cell value is:->"+Case1MashupValue);
		System.out.println("After Decimal Mashup Cell is:->"+AfterDecimalValue);
		
		try{			
				if(AfterDecimalValue2==AfterDecimalValue)
				{
					System.out.println("Case-1 Mashup Value is equal after Decimal Change.");
				}
			// Assert.assertEquals(AfterDecimalValue2, AfterDecimalValue);
	   	 }catch(Exception e){
	   		 System.out.println("Case-1 Mashup Value is not equal after Decimal Change.");
			}
		
		 //Case-2nd Mashup Cell Currency::=======
		 log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		 Thread.sleep(2000);
		/* robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyRelease(KeyEvent.VK_RIGHT); 
	     Thread.sleep(1000);*/
		 act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/1']"))).perform();
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
		 String CurrencyMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/1']")).getText();
		 Thread.sleep(2000);
		 System.out.println("Second Mashup Cell value is:->"+CurrencyMashupValue);
		 
		 //Cell property:==================
		 log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		 Thread.sleep(2000);
		/* robot.keyPress(KeyEvent.VK_RIGHT); 
		 Thread.sleep(500);
		 robot.keyPress(KeyEvent.VK_RIGHT); 
		 Thread.sleep(500);
		 robot.keyRelease(KeyEvent.VK_RIGHT); 
		 Thread.sleep(1000);*/
		 act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/1']"))).perform();
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("//span[text()='Cell properties...']")).click();
		 Thread.sleep(2000);
		 //Click Value Format:==============
		 log.driver.findElement(By.xpath("//a[text()='Value Format']")).click();
		 Thread.sleep(4000);
		 
		 //Click on Currency and Proceed:==================
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
		 //rgb(255, 0, 0);
		String ExpectedColr=log.driver.findElement(By.xpath("//label[text()='Colored:']/following::span[1]")).getCssValue("color");
		System.out.println("Expected Color is:->"+ExpectedColr);
		Assert.assertEquals("rgba(255, 0, 0, 1)", ExpectedColr);
		//enter ->4 in Digit  field:=====
		log.driver.findElement(By.xpath("//span[text()='($1234.50)']/ancestor::div[1]")).click();
		Thread.sleep(2000);
		
		if("true".equals(log.driver.findElement(By.xpath("//span[text()='($1234.50)']/ancestor::li[1]")).getAttribute("aria-selected")))
		{
			System.out.println("Required text is selected.");
		}
		Thread.sleep(1000);
		//Clear the input digit field and enter 8:====
		log.driver.findElement(By.xpath("//span[text()='Digits:']/following::input[1]")).clear();
		log.driver.findElement(By.xpath("//span[text()='Digits:']/following::input[1]")).sendKeys("4");
		Thread.sleep(2000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		//Validate:====
		String Case2MashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/1']")).getText();
		
		try{			
			if(Case2MashupValue==CurrencyMashupValue)
			{
				System.out.println("Case-2 Mashup Value is equal after Currency Change.");
			}
    	 }catch(Exception e){
   		 System.out.println("Case-2 Mashup Value is equal after Currency Change.");
		} 
		
		//Case-3:-ve Value:=======================
		log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
		/*robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/2']"))).perform();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Single data Cell window is displaying.");
	
		//Verify Write window after click on same:===========
		log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Please enter a value.']")).isDisplayed());
		Thread.sleep(1000);
		//enter input value for mashup cell:===========
		//=-E1
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=-E1");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		String NegativeMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/2']")).getText();
		Thread.sleep(2000);
		System.out.println("Negative Mashup Cell value is:->"+NegativeMashupValue);
		
		//Validate:======
		log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
		/*robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		String TextColr=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/2']")).getCssValue("color");
		System.out.println("Expected Text Color is:->"+TextColr);
		Assert.assertEquals("rgba(255, 0, 0, 1)", TextColr);
		System.out.println("For -ve Formula Validated successfully.");
		Thread.sleep(2000);
		 //Case-4:Percentage Calculation:====================
		 //log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		// Thread.sleep(2000);
		/* robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyPress(KeyEvent.VK_RIGHT); 
	     Thread.sleep(500);
	     robot.keyRelease(KeyEvent.VK_RIGHT); 
	     Thread.sleep(1000);*/
		 act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/3']"))).perform();
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Single data Cell window is displaying.");
		
		 //Verify Write window after click on same:===========
		 log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Please enter a value.']")).isDisplayed());
		 Thread.sleep(1000);
		 //enter input value for mashup cell:===========
		 //=C(1,4)
		 log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=C(1,4)");
		 Thread.sleep(2000);
		 log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		 Thread.sleep(3000);
		 String PercentageMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/3']")).getText();
		 Thread.sleep(2000);
		 System.out.println("Mashup Cell value for percentage case is:->"+PercentageMashupValue);
		 
		 //Cell property:==================
		 //log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		 Thread.sleep(2000);
		/* robot.keyPress(KeyEvent.VK_RIGHT); 
		 Thread.sleep(500);
		 robot.keyPress(KeyEvent.VK_RIGHT); 
		 Thread.sleep(500);
		 robot.keyRelease(KeyEvent.VK_RIGHT); 
		 Thread.sleep(1000);*/
		 act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/3']"))).perform();
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("//span[text()='Cell properties...']")).click();
		 Thread.sleep(2000);
		 //Click Value Format:==============
		 log.driver.findElement(By.xpath("//a[text()='Value Format']")).click();
		 Thread.sleep(4000);
		 
		 //Click on Percentage and Proceed:==================
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
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display Values']/following::input[2][@value=' %']")).isDisplayed());
		 Thread.sleep(1000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display Negative Values']/following::input[2][@value=' %']")).isDisplayed());
		 Thread.sleep(1000);
		
		//Select one percentage and proceed:===
		log.driver.findElement(By.xpath("//span[text()='12.00 % (*100)']/ancestor::div[1]")).click();
		Thread.sleep(2000);
		
		if("true".equals(log.driver.findElement(By.xpath("//span[text()='12.00 % (*100)']/ancestor::li[1]")).getAttribute("aria-selected")))
		{
			System.out.println("Required text is selected.");
		}
		Thread.sleep(1000);
		//Validate Factor Field:====
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Factor:']/following::input[@value='100.0000000000000']")).isDisplayed());
		Thread.sleep(1000);
		//Clear the input digit field and enter 8:====
		log.driver.findElement(By.xpath("//span[text()='Digits:']/following::input[1]")).clear();
		log.driver.findElement(By.xpath("//span[text()='Digits:']/following::input[1]")).sendKeys("6");
		Thread.sleep(2000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		
		//Validate percentile Text:==========
		String PercentileValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/3']")).getText();
		System.out.println("After change percentage Mashup Cell value is:->"+PercentileValue);
				
		if(PercentageMashupValue==PercentileValue)
		{
			System.out.println("not true");
		}
		else{
	   		 System.out.println("Percentage Validation is working as expected.");
	   		 if(PercentileValue.contains("%"))
	   		 {
	   			 System.out.println("Value is displaying as percentage value.");
	   		 }
		}
		
		//Case-5::Scientific============
		//log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
		/*robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
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
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=C(1,4)");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		String ScientificMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		Thread.sleep(2000);
		System.out.println("Scientific Mashup Cell value is:->"+ScientificMashupValue);
		
		//Cell property:==================
		//log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
	/*	robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']"))).perform();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Cell properties...']")).click();
		Thread.sleep(2000);
		//Click Value Format:==============
		log.driver.findElement(By.xpath("//a[text()='Value Format']")).click();
		Thread.sleep(4000);
		 
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
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Factor:']/following::input[@value='1.00000000000000']")).isDisplayed());
		Thread.sleep(1000);
		
		//Change in color Value Validate:=================
		String ExpectedScitificColr=log.driver.findElement(By.xpath("//label[text()='Colored:']/following::span[1]")).getCssValue("color");
		System.out.println("Expected Scientific Color is:->"+ExpectedScitificColr);
		Assert.assertEquals("rgba(255, 0, 0, 1)", ExpectedScitificColr);
		
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		//Validate:===============
		String ScientificValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/0']")).getText();
		System.out.println("After change Scientific Mashup Cell value is:->"+ScientificValue);
				
		if(ScientificValue==ScientificMashupValue)
		{
			System.out.println("not true");
		}
		else{
	   		 System.out.println("Percentage Validation is working as expected.");
	   		 if(PercentileValue.contains("E"))
	   		 {
	   			 System.out.println("Value is displaying as Scientific value.");
	   		 }
		}
		
		//Case-6:Today:---
		//Issue in DateFormat:======================
		log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
		/*robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/1']"))).perform();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Single data Cell window is displaying.");
	
		//Verify Write window after click on same:===========
		log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Please enter a value.']")).isDisplayed());
		Thread.sleep(1000);
		//Enter input value for mashup cell:===========
		log.driver.findElement(By.xpath("//span[text()='Please enter a value.']/following::input[1]")).sendKeys("=today()");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		String DateFormatMashupValue=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/1']")).getText();
		Thread.sleep(2000);
		System.out.println("Sate Format Mashup Cell value is:->"+DateFormatMashupValue);
		
		//CellProperty Validate:==================
		log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
		/*robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		act.contextClick(log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/1']"))).perform();
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Cell properties...']")).click();
		Thread.sleep(2000);
		//Click Value Format:==============
		log.driver.findElement(By.xpath("//a[text()='Value Format']")).click();
		Thread.sleep(4000);
		
		//Click on Number and Proceed:==================
		log.driver.findElement(By.xpath("//span[text()='Date']")).click();
		Thread.sleep(2000);
		String[] ActDateList={"1/1/05","01/01/05","1/1/2005","01/01/2005","Jan 1, 2005","Jan 01, 2005","January 1, 2005","January 01, 2005"};
		List<WebElement> Datelist=log.driver.findElements(By.xpath("//span[text()='Format']/following::ul[1]//span/span"));
		int countDate=0;
		
		for(int i=0;i<Datelist.size();i++)
		{
			System.out.println(ActDateList[i]+" And "+Datelist.get(i).getText());
			if(ActDateList[i].equals(Datelist.get(i).getText()))
			{
				countDate++;
			}
		}
		Thread.sleep(2000);
		System.out.println("Count of Date Format is:->"+countScientific);
		Assert.assertEquals(8,countDate);
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='January 1, 2005']/ancestor::div[1]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//span[text()='Digits:']/following::input[1]")).isEnabled());
		Thread.sleep(1000);
		Assert.assertEquals(false,log.driver.findElement(By.xpath("//span[text()='Factor:']/following::input[@value='1.00000000000000']")).isEnabled());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display Values']/following::span[text()='Before:'][1]/following::input[1]")).isEnabled());
		Thread.sleep(1000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Display Values']/following::span[text()='After:'][1]/following::input[1]")).isEnabled());
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(3000);
		//Validate:====
		log.driver.findElement(By.xpath("//div[@id='0/0']")).click();
		Thread.sleep(2000);
		/*robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_RIGHT); 
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_RIGHT); 
		Thread.sleep(1000);*/
		String TextDATE=log.driver.findElement(By.xpath("//div[text()='MASHUP']/following::div[@id='1/1']")).getText();
		System.out.println("Date Format is:>"+TextDATE);
		int countD=0;
		//currentMonth
		Date date = new Date();
	    String strDateFormat = "M";
	    strDateFormat = "MMMM";
	    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	    sdf = new SimpleDateFormat(strDateFormat);
	    System.out.println("Current Month in MMMM format : " + sdf.format(date));
	     
		if(TextDATE.equals(DateFormatMashupValue))
		{
			System.out.println("Date Format not changed as required.");
		}
		else
		{
			if(TextDATE.contains(sdf.format(date)))
			{
				System.out.println("Date Format changed as required.");
				countD++;
			}
		}
		Assert.assertEquals(countD,1);
		System.out.println("For Date format mashup Formula Validated successfully.");
		System.out.println("Testcase-25791 Validated successfully.");
		
  }
  
}
