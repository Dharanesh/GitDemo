package features;

import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
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

public class TestCase_36752 extends TestUtils
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
	    System.out.println("36752--Testcase started........");
	  	//login to the application:================
	  	test =extent.createTest("Test Case 35675: Filter_LL_length and height of the search bar in case the filter size changes.");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");
	  	
	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  	
	  	System.out.println("Test Case 35675: Filter_LL_length and height of the search bar in case the filter size changes===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000); 
	  	
	  	//Open CM Manufacture ratio:=================
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
  	  	Thread.sleep(3000);
  	  	
  	  	//Check for Check boxes of element click:=================
  	  	Actions act_Check=new Actions(log.driver);
  	  	act_Check.contextClick(log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::input[1]"))).perform();;
		Thread.sleep(3000);
		try 
		{
			if(log.driver.findElement(By.xpath("//span[text()='Enable selection by drop-down menu']/span[@class='k-icon k-i-checkbox-checked']")).isDisplayed())
			{
				System.out.println("Enable selction drop down check box is checked.");
				Thread.sleep(3000);
				log.driver.navigate().refresh();
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Enable selction drop down check box is not checked,so need to check.");
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//span[text()=' Enable selection by drop-down menu']")).click();
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		//log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::input[1]")).click();
		//Thread.sleep(3000);
  		log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::span[4]")).click();
		Utils.waitForElement("");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]")).isDisplayed());
  	  	Thread.sleep(1000);
		System.out.println("Type here to search text is displaying now.");
		
	  	//Right click on any filter and check value:==========
		String Before_TypeStringWidth_at10=log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]")).getAttribute("offsetWidth");
		System.out.println("Before width of input box is:="+Before_TypeStringWidth_at10);
		
		log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::input[1]")).click();
		Thread.sleep(3000);
		
	  	//Right click on Filters and select element selection width:============
		Actions act=new Actions(log.driver);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::input[1]"))).perform();;
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("//span[text()=' Element Display Width...']")).click();
		Utils.waitForElement("");
		
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Width of the element display:']")).isDisplayed());
  	  	Thread.sleep(1000);
		System.out.println("With of Element display window is displaying now.");
		
		log.driver.findElement(By.xpath("//span[text()='Width of the element display:']/following::input[1]")).clear();
		Utils.waitForElement("");
		log.driver.findElement(By.xpath("//span[text()='Width of the element display:']/following::input[1]")).sendKeys("80");
		
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Utils.waitForElement("");
		
		//Right click and Validate width when filter width is small:=====
		log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/following::span[4]")).click();
		Utils.waitForElement("");
		Thread.sleep(3000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]")).isDisplayed());
  	  	Thread.sleep(1000);
		System.out.println("Type here to search text is displaying now.");
		String TypeStringWidth_at10=log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]")).getAttribute("offsetWidth");
		
		System.out.println("width of input box is:="+TypeStringWidth_at10);
		
		Assert.assertEquals(TypeStringWidth_at10, Before_TypeStringWidth_at10);
		System.out.println("Length of the context menu and  search bar is same as the length of the filter.");
		
		//Case-2:====
		//Verify Filter Elements after change value:=================
		//Compare div locations:=============
		
		String Parent_Filter_Tab=log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]/ancestor::div[2]")).getCssValue("height");
		String Parent_1=Parent_Filter_Tab.replaceAll("px","").trim();
		int Parent_2=(int) Double.parseDouble(Parent_1);
		System.out.println("Parent Filter height:="+Parent_2);
				
		String SubChild_Type_Tab=log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]/ancestor::div[1]")).getCssValue("height");
		String SubChild=SubChild_Type_Tab.replaceAll("px","").trim();
		int SubChild_2=Integer.parseInt(SubChild);
		System.out.println("SubChild_Type_Tab:="+SubChild_2);		
		
		String Sub_Filter_Tab=log.driver.findElement(By.xpath("(//input[@placeholder='Type here to search...'])[1]/following::div[1]")).getCssValue("height");
		String Sub_Filter_1=Sub_Filter_Tab.replaceAll("px","").trim();
		int Sub_Filter_2=(int) Double.parseDouble(Sub_Filter_1);
		System.out.println("Sub_Filter_Tab:="+Sub_Filter_2);
				
		int Expt_Result=Sub_Filter_2+SubChild_2;	
		System.out.println("Expected Result:="+Expt_Result);
		Assert.assertEquals(Expt_Result, Parent_2);
		System.out.println("Overlapping is not happening in filter with search tab.");
		Thread.sleep(1000);
		
		log.driver.close();
		
		
	  	
  }
}
