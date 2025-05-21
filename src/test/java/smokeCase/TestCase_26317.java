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
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;


public class TestCase_26317 extends TestUtils
{
	
	@Test	
	@Parameters("browser")
	public void Testcase_to_verify_functionality_of_Analytical_Visualization_InCell_Bar_New(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_26317 : Web_Testcase to verify functionality of <Analytical Visualization  InCell Bar_New>");
	   
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
	  
		
		/*c.Create_NewReport("TestCase_24483_Minichart_New");*/
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Sales by country']");
		log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
        Thread.sleep(1000);

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
		Thread.sleep(1000);;
		
		/*waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Base elements with containers (0 Items)']");
	
		String basevalueempty=driver.findElement(By.xpath("//span[text()='Base elements with containers (0 Items)']")).getText();
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

		for(int i=0;i<=basevalue.size()-1;i++) 
		{
			assertEquals(basevalue.get(i).getText(), base.get(i));
			System.out.println(basevalue.get(i).getText());

		}
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]");
		List<WebElement> basevalueaftupdate = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]/input[1]"));
		for(int i=0;i<=basevalueaftupdate.size()-1;i++) 
		{
			Assert.assertTrue(basevalueaftupdate.get(i).isSelected());
			System.out.println("2014 and 2015 value is checked");
		}
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		Actions a1=new Actions(log.driver);
		a1.contextClick(log.driver.findElement(By.xpath(("//div[text()='2014']")))).build().perform();
		Thread.sleep(2000);
		a1.moveToElement(log.driver.findElement(By.xpath(("//span[text()='Analytical Visualizations']")))).build().perform();
		Thread.sleep(200);
		a1.click(log.driver.findElement(By.xpath(("//span[text()='New...']")))).build().perform();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Analytical Visualization']");
		System.out.println("Create new Analytical visualization");
		
		log.driver.findElement(By.xpath("//span[text()='In Cell Bar']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()='Creates a new In Cell Bar analysis.']")).isDisplayed();
		System.out.println(" In Cell Bar is selected");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Creates a new In Cell Bar analysis.']")).isDisplayed(),true);
		Thread.sleep(200);
		System.out.println("Creates a new Incell Bar.");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the In Cell Bar Analysis']")).isDisplayed(),true);
		System.out.println("Settings for the In Cell Bar Analysis====");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='Settings for the In Cell Bar Analysis']/ancestor::div[6]//button/span");
		List<WebElement> Buttons = log.driver.findElements(By.xpath("//span[text()='Settings for the In Cell Bar Analysis']/ancestor::div[6]//button/span"));
		
		for(int i =0;i<=Buttons.size()-1;i++) 
		{
			//String check = window_button.get(i).getText();
			assertEquals(Buttons.get(i).isDisplayed(),true);
			
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings for the In Cell Bar Analysis']/ancestor::div[6]//input[@role='button']");
		List<WebElement> Buttons1 = log.driver.findElements(By.xpath("//span[text()='Settings for the In Cell Bar Analysis']/ancestor::div[6]//input[@role='button']"));
		ArrayList<String> button1 = new ArrayList<String>();
		button1.add("Next >>");
		button1.add("Finish");
		button1.add("Cancel");
		button1.add("Help");
		System.out.println("Action button on settings for Incell bar analysis window are");
		test.info("Action button on settings for Incell bar analysis window are");
		for(int i =0;i<=button1.size()-1;i++) 
		{
			//String check = window_button.get(i).getText();
			assertEquals(Buttons1.get(i).getAttribute("value"), button1.get(i));
			System.out.println(Buttons1.get(i).getAttribute("value"));
			test.info(Buttons1.get(i).getText());
		}
		
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='Bar color']/following::td[5])[1]/button");
		log.driver.findElement(By.xpath("(//div[text()='Bar color']/following::td[5])[1]/button")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select color']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Select color']")).isDisplayed());
		System.out.println("select color window displayed");
		test.info("select color window displayed");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select color']/following::td[19]");
		log.driver.findElement(By.xpath("//span[text()='Select color']/following::td[19]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, " //td[text()='Red:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath(" //td[text()='Red:']/..//input")).getAttribute("value"), "50");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Green:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Green:']/..//input")).getAttribute("value"), "205");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Blue:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Blue:']/..//input")).getAttribute("value"), "50");
		
		System.out.println("values present in red, green and blue fields are correct");
		test.info("values present in red, green and blue fields are correct");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Actual:']/../div[2]");
		String Bar_color= log.driver.findElement(By.xpath("//div[text()='Actual:']/../div[2]")).getCssValue("background-color");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Actual:']/../div[2]")).getCssValue("background-color").contains("50, 205, 50"));
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='Bar color']/following::td[3])[1]");
		assertTrue(log.driver.findElement(By.xpath("(//div[text()='Bar color']/following::td[3])[1]")).getCssValue("background-color").contains("50, 205, 50"));
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Show values']/ancestor::tr/td[3]/div");
		Assert.assertTrue(log.driver.findElement(By.xpath("//div[text()='Show values']/ancestor::tr/td[3]//input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Show values']/ancestor::tr/td[3]/div");
		log.driver.findElement(By.xpath("//div[text()='Show values']/ancestor::tr/td[3]/div")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Show values']/ancestor::tr/td[3]/div");
		Assert.assertFalse(log.driver.findElement(By.xpath("//div[text()='Show values']/ancestor::tr/td[3]//input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		ui.multiButton("//input[@value='Finish']");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Assignment of the Analytical Visualization  [DataView: Sales]']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Assignment of the Analytical Visualization  [DataView: Sales]']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Allocation(target)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Allocation(target)']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).isDisplayed(),true);
		
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[1]")).click();
		Thread.sleep(1000);
		try {
		if(log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[1]")).isEnabled()) {
			Thread.sleep(500);
			assertTrue(log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[1]")).isEnabled());
			System.out.println("2014 got selected in traget");
			
		}
		}catch(Exception e) {
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("//*[text()='Allocation(target)']/following::div[text()='2014']")).click();
			Thread.sleep(500);
			assertTrue(log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[1]")).isEnabled());
			System.out.println("2014 got selected in second time");
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Element level:'])[2]/following::div[1]/div[1]/span/span/span[1]");
		String ElementLevel1src= log.driver.findElement(By.xpath("(//span[text()='Element level:'])[2]/following::div[1]/div[1]/span/span/span[1]")).getText();
		Assert.assertEquals(ElementLevel1src,"(all levels)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//label[text()='Based on index'])[2]/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//label[text()='Based on index'])[2]/../../td[1]/input")).isSelected(),true);
		System.out.println("Based on index is selected default in source window");
		test.info("Based on index is selected default in source window");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[2]/../../td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[2]/../../td[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//button[text()='Delete selection']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Delete selection']")).isEnabled(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/../../..)[2]/div[3]/div/div[@span='0']");
		log.driver.findElements(By.xpath("(//div[text()='2014']/../../..)[2]/div[3]/div/div[@span='0']")).get(0).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(4000);
		
		
		List<WebElement> verifications = log.driver.findElements(By.xpath("//div[text()='2014']/ancestor::div[4]/div/div[4]/div/div/div[1]/div"));
		 for (WebElement web : verifications)
		 {
			 assertTrue(web.getCssValue("background-color").equals(Bar_color));
			 System.out.println("AV_incell bar applied correctly");
		}
		 
		 test.info("AV_incell bar applied correctly");
		
		
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
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("TestCase_InCell_Bar_New");
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TestCase_InCell_Bar_New']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='TestCase_InCell_Bar_New']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		
		
		log.driver.close();
		
		
		
	}
}
