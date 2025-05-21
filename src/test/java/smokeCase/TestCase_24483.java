package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24483 extends TestUtils
{
	static String Width; 
	static String Height;
	@Test	
	@Parameters("browser")
	
	//Web_Testcase to verify functionality of Analytical Visualization  MiniChart_Bar_New
	public void Testcase_Cockpit10_Analytical_Viz_Minichart_New(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24483 for verifying functionality of Analytical Visualization MiniChart_Bar_New");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		
		
		//c.Create_NewReport("//div[text()='Sales']","TestCase_24483_Minichart_New",true);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Sales by country']");
		log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
        Thread.sleep(2000);

        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Sales by country'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Time']");
		log.driver.findElement(By.xpath("//span[text()='Time']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed(),true);
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Removes all items from the selection list']");
		
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
	/*	waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Base elements with containers (0 Items)']");
	
		String basevalueempty=log.driver.findElement(By.xpath("//span[text()='Base elements with containers (0 Items)']")).getText();
		Assert.assertEquals(basevalueempty, "Base elements with containers (0 Items)");
		Thread.sleep(2000);*/
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='2014']");
		log.driver.findElement(By.xpath("//div[text()='2014']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='2015']");
		log.driver.findElement(By.xpath("//div[text()='2015']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");

		List<WebElement> basevalue = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> base= new ArrayList<String>();
		System.out.println("New Report radio button option");
		base.add("2014");
		base.add("2015");

		for(int i=0;i<basevalue.size()-1;i++)
		{
			assertEquals(basevalue.get(i).getText(), base.get(i));
			System.out.println(basevalue.get(i).getText());

		}
		Thread.sleep(2000);
		/*waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Base elements')]");
	
		String basevalueupdate=log.driver.findElement(By.xpath("//span[contains(text(),'Base elements')]")).getText();
		Assert.assertEquals(basevalueupdate, "Base elements with containers (2 Items)");
		System.out.println(basevalueupdate);*/
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]");
		List<WebElement> basevalueaftupdate = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]/input[1]"));
		for(int i=0;i<=basevalueaftupdate.size()-1;i++) 
		{
			Assert.assertTrue(basevalueaftupdate.get(i).isSelected());
			System.out.println("2014 and 2015 value is checked");
		}
		
		Thread.sleep(200);
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		//a1.click(e1).sendKeys("Calculated elements", Keys.ENTER).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]")).getText(), "Calculated elements");
		System.out.println("Calculated elements is selected in dropdown");
		
		log.driver.findElement(By.xpath("//div[.='-SEPARATOR-']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='-SEPARATOR-'])[2]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Properties of Element']");
	
		log.driver.findElement(By.xpath("//span[text()='Alias:']/following::div[4]/input")).sendKeys("Seperator");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
		//===================================AV======================================
	
		a1.contextClick(log.driver.findElement(By.xpath(("//div[text()='2014']")))).build().perform();
		Thread.sleep(2000);
		a1.moveToElement(log.driver.findElement(By.xpath(("//span[text()='Analytical Visualizations']")))).build().perform();
		Thread.sleep(1000);
		a1.click(log.driver.findElement(By.xpath(("//span[text()='New...']")))).build().perform();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Analytical Visualization']");
		System.out.println("Create new Analytical visualization");
		
		log.driver.findElement(By.xpath("//span[text()='Minichart']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()='Creates a new minichart.']")).isDisplayed();
		System.out.println("Minichart is selected");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Creates a new minichart.']")).isDisplayed(),true);
		Thread.sleep(1000);
		System.out.println("Creates a new minichart.");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the Minichart']")).isDisplayed(),true);
		System.out.println("Settings for the Minichart====");
		
		WebElement e2=log.driver.findElement(By.xpath("//div[text()='Type']/following::div[1]/span[1]/span[1]/span[1]"));
		//a1.click(e2).sendKeys("Pie", Keys.ENTER).build().perform();
		for(int i=1;i<=4;i++)
		{
			a1.click(e2).sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(1000);
			if(e2.getText().equals("Pie"))
			{
				a1.click(e2).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				break;
			}
		}
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Type']");
		log.driver.findElement(By.xpath("//div[text()='Type']")).click();;
		Thread.sleep(2000);
		WebElement e21=log.driver.findElement(By.xpath("//div[text()='Type']/following::div[1]/span[1]/span[1]/span[1]"));
		Assert.assertEquals(e21.getText(), "Pie");
		System.out.println("pie is selected");
		test.info("pie is slected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Width'])[1]/following::div[1]/div[1]/input[1]");
	    Width=log.driver.findElement(By.xpath("(//div[text()='Width'])[1]/following::div[1]/div[1]/input[1]")).getAttribute("value");
	    System.out.println(Width);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Height'])[1]/following::div[1]/div[1]/input[1]");
	    Height=log.driver.findElement(By.xpath("(//div[text()='Height'])[1]/following::div[1]/div[1]/input[1]")).getAttribute("value");
	    System.out.println(Height);
				
		log.driver.findElement(By.xpath("(//div[text()='Color']/following::button[1])[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select color']");
		log.driver.findElement(By.xpath("//span[text()='Select color']/following::td[2]")).click();
		
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed(),true);
		Thread.sleep(200);
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(2000);
		
		
		//========================================================================
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Assignment of the Analytical Visualization  [DataView: Sales]']");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).click();
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath(("//a[text()='Allocation(target)']"))).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath(("(//div[text()='Seperator'])[1]"))).click();
		Thread.sleep(2000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).click();
	
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[2]")).click();
		Thread.sleep(1000);
		try {
		if(log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[2]")).isEnabled()) {
			Thread.sleep(500);
			assertTrue(log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[2]")).isEnabled());
			System.out.println("2014 got selected in traget");
			
		}
		}catch(Exception e) {
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("//*[text()='Allocation(target)']/following::div[text()='2014']")).click();
			Thread.sleep(500);
			assertTrue(log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[2]")).isEnabled());
			System.out.println("2014 got selected in second time");
		}
		Actions act = new Actions(log.driver);
		act.sendKeys(Keys.SHIFT).build().perform();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2015'])[2]")).click();
		Thread.sleep(1000);
		Assert.assertEquals(log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2015'])[2]")).isEnabled(),true);
		 Thread.sleep(3000);
//		
//		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[text()='Whole table'])[2]");
//		driver.findElement(By.xpath("(//button[text()='Whole table'])[2]")).click();
//		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(4000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img");
		List<WebElement> imgvalueoftable = log.driver.findElements(By.xpath("//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img"));
		for (WebElement ele : imgvalueoftable) 
		{
			
			assertTrue(ele.getAttribute("style").contains(Width)&&ele.getAttribute("style").contains(Height));
		}
		
		System.out.println("anyaltical visulization_minichart applied successfully to table");
		test.info("anyaltical visulization_minichart applied successfully to table");
		
		
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
		 waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Name'])[1]/following::input[1]");
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("TESTCASE_MINICHART_NEW");
		 Thread.sleep(500);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(1000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(1000);
		
		try
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'A report named')]")).isDisplayed();
			log.driver.findElement(By.xpath("//input[@value='OK']")).click();
			System.out.println("popup appeared");
		}
		catch(Exception e)
		{
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TESTCASE_MINICHART_NEW']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='TESTCASE_MINICHART_NEW']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		//click On Navigator:=================
		
		
		//Delete Report:==================
		
		/*log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		 log.driver.findElement(By.xpath("(//span[text()='Testcase_24671'])[3]")).click();
		Thread.sleep(3000);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Testcase_24671'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);*/
		
		log.driver.close();
		
		
		
		
	}
}
