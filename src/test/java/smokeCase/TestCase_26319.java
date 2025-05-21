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



public class TestCase_26319 extends TestUtils
{
	
	@Test	
	@Parameters("browser")
	public void Web_Testcas_to_verify_functionality_of_Analytical_Visualization_InCellBar_Negative_Value(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_26319 : Web_Testcase to verify functionality of <Analytical Visualization In Cell Bar_Negative Value/Separate Color>");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		
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
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Base elements with containers (0 Items)']");
	
		String basevalueempty=log.driver.findElement(By.xpath("//span[text()='Base elements with containers (0 Items)']")).getText();
		Assert.assertEquals(basevalueempty, "Base elements with containers (0 Items)");
		Thread.sleep(2000);
		
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
		Thread.sleep(1000);
		
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		//a1.click(e1).sendKeys("Calculated elements", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		System.out.println(log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]")).getText());
		assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]")).getText(), "Calculated elements");
		System.out.println("Calculated elements is selected in drop down");
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			String aa = selectble_ele.get(i).getText();
			selectable.add(aa);
			if(selectable.contains("DIFFERENCE"))
			{
				assertTrue(true);
				
			}
			
		}
		System.out.println("DIFFERENCE is present in the list of selectable elements");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='DIFFERENCE']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='DIFFERENCE']/../div[1]")).isDisplayed());
		System.out.println("DIFFERENCE Checkbox is present in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='DIFFERENCE']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='DIFFERENCE']/../div[1]")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='DIFFERENCE']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='DIFFERENCE']/../div[1]/input[1]")).isSelected());
		
		System.out.println("DIFFERENCE Checkbox is checked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		
		List<WebElement> Mashup = log.driver.findElements(By.xpath("//div[text()='DIFFERENCE']/../div[1]/input"));
		for (int i = 0; i < Mashup.size(); i++)
		{
			
			assertTrue(Mashup.get(i).isSelected());
		}
		System.out.println("DIFFERENCE is selected");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> el = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
			
		Assert.assertEquals(el.get(el.size()-1).getText(), "DIFFERENCE");
		
		System.out.println("DIFFERENCE is present a the last in base elements area");
		test.info("DIFFERENCE is present a the last in base elements area");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		//waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MASHUP']");
		//Assert.assertTrue(log.driver.findElement(By.xpath("//div[text()='MASHUP']")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		log.driver.findElement(By.xpath("(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		ui.rightClick("(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='//span[.='Single Data Cell']']")).isDisplayed())
			{
				System.out.println("Single Data Cell Available");
			}
		}
		catch(Exception e)
		{
			 Actions act = new Actions(log.driver);
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='0/0'])[1]"))).perform();
		     Thread.sleep(2000);
		}		
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Single Data Cell']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed(),true);
		
		List<WebElement> Context1 = log.driver.findElements(By.xpath("//span[text()='Single Data Cell']/../../li/span[1]"));
		ArrayList<String> CV1= new ArrayList<String>();
		System.out.println("Single Data cell context menu options are:");
		test.info("Single Data cell context menu options are:");
		CV1.add("Single Data Cell");
		CV1.add("Start Write Mode");
		CV1.add("Copy");
		CV1.add("Copy (value formatted)");
		CV1.add("Define Subview...");
		CV1.add("Analytical Visualizations");
		CV1.add("Edit Table...");
		CV1.add("Table Properties...");
		CV1.add("Information...");
		
		for(int i=0;i<Context1.size()-1;i++) 
		{
			assertEquals(Context1.get(i).getText(), CV1.get(i));
			System.out.println(Context1.get(i).getText());

		}
		
		Context1.get(5).click();
		Thread.sleep(1000);
	
	/*	//Actions a1=new Actions(log.driver);
		a1.contextClick(log.driver.findElement(By.xpath(("//div[text()='2014']")))).build().perform();
		Thread.sleep(200);
		a1.moveToElement(log.driver.findElement(By.xpath(("//span[text()='Analytical Visualizations']")))).build().perform();
		Thread.sleep(200);*/
		a1.click(log.driver.findElement(By.xpath(("//span[text()='New...']")))).build().perform();
		Thread.sleep(1000);
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings for the In Cell Bar Analysis']/ancestor::div[6]//button/span");
		List<WebElement> Buttons = log.driver.findElements(By.xpath("//span[text()='Settings for the In Cell Bar Analysis']/ancestor::div[6]//button/span"));
		
		for(int i =0;i<=Buttons.size()-1;i++) 
		{
			//String check = window_button.get(i).getText();
			assertEquals(Buttons.get(i).isDisplayed(),true);
			
		}
		Thread.sleep(1000);
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
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings for the In Cell Bar Analysis']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the In Cell Bar Analysis']")).isDisplayed(),true);
		System.out.println("Settings for the Incellbar====");
		
	    if(log.driver.findElement(By.xpath("//span[text()='Negative Values']/ancestor::tr[1]/td[1]/a/span")).getAttribute("class").contains("minu")){
				
				waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Use explicit negative color']/ancestor::tr/td[3]/div[1]");
				Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Use explicit negative color']/ancestor::tr/td[3]/div[1]")).isDisplayed(),true);
				System.out.println("Negative values is expanded by default");
				
			}
	    else{
				waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Negative Values']/ancestor::tr[1]/td[1]/a/span");
				log.driver.findElement(By.xpath("//span[text()='Negative Values']/ancestor::tr[1]/td[1]/a/span")).click();
				Thread.sleep(1000);
				waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Negative Values']/ancestor::tr[1]/td[1]/a/span");
				Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Negative Values']/ancestor::tr[1]/td[1]/a/span")).getAttribute("class").contains("minu"),true);
				
				waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Use explicit negative color']/ancestor::tr/td[3]/div[1]");
				Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Use explicit negative color']/ancestor::tr/td[3]/div[1]")).isDisplayed(),true);
				System.out.println("NEgative values got expanded");
			}
		
	    Thread.sleep(200);
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Use explicit negative color']/ancestor::tr/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Use explicit negative color']/ancestor::tr/td[3]/div[1]/input")).isSelected(),false);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='Bar color']/ancestor::tr/td[3]//td[1]//td[1])[2]");
		assertTrue(log.driver.findElement(By.xpath("(//div[text()='Bar color']/ancestor::tr/td[3]//td[1]//td[1])[2]")).getCssValue("background-color").contains("255, 0, 0"));
		String color_nv= log.driver.findElement(By.xpath("(//div[text()='Bar color']/ancestor::tr/td[3]//td[1]//td[1])[2]")).getCssValue("background-color");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Use explicit negative color']/ancestor::tr/td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Use explicit negative color']/ancestor::tr/td[3]/div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Use explicit negative color']/ancestor::tr/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Use explicit negative color']/ancestor::tr/td[3]/div[1]/input")).isSelected(),true);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[.='Name and Description']/../..");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[.='Name and Description']/../..")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Name']/ancestor::div[3]/div[2]/div/div/input");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).getAttribute("value"),"In-Cell Bars 1");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		ui.multiButton("//input[@value='Finish']");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Assignment of the Analytical Visualization  [DataView: Sales]']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Assignment of the Analytical Visualization  [DataView: Sales]']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Allocation(target)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Allocation(target)']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).isDisplayed(),true);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//label[text()='Based on index'])[1]/../../td[1]");
		log.driver.findElement(By.xpath("(//label[text()='Based on index'])[1]/../../td[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//label[text()='Based on index'])[1]/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//label[text()='Based on index'])[1]/../../td[1]/input")).isSelected(),true);
		System.out.println("Based on index is selected");
		test.info("Based on index is selected");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[1]/../../td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[1]/../../td[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='DIFFERENCE'])[1]");	
		log.driver.findElement(By.xpath("(//div[text()='DIFFERENCE'])[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='DIFFERENCE'])[1]/../../../div[4]/div[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='DIFFERENCE'])[1]/../../../div[4]/div[2]")).isEnabled(),true);
		 
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//label[text()='Based on index'])[2]/../../td[1]");
		log.driver.findElement(By.xpath("(//label[text()='Based on index'])[2]/../../td[1]")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//label[text()='Based on index'])[2]/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//label[text()='Based on index'])[2]/../../td[1]/input")).isSelected(),true);
		System.out.println("Based on index is selected");
		test.info("Based on index is selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[2]/../../td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[2]/../../td[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//button[text()='Delete selection']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Delete selection']")).isEnabled(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Aggregation:'])[1]/following::div[1]/div[1]/span/span/span[1]");
		String ElementLevel1src= log.driver.findElement(By.xpath("(//span[text()='Aggregation:'])[1]/following::div[1]/div[1]/span/span/span[1]")).getText();
		Assert.assertEquals(ElementLevel1src,"No Aggregation");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='DIFFERENCE'])[2]");	
		log.driver.findElement(By.xpath("(//div[text()='DIFFERENCE'])[2]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='DIFFERENCE'])[2]/../../../div[4]/div[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='DIFFERENCE'])[2]/../../../div[4]/div[2]")).isEnabled(),true);
		 
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(4000);
		
		
     List<WebElement> incellBars = log.driver.findElements(By.xpath("//div[text()='DIFFERENCE']/ancestor::div[4]/div/div[4]/div/div/div[3]/div"));
	
	 for (int i = 0; i < incellBars.size(); i++) 
	 {
		
		if(incellBars.get(i).getCssValue("background-color").contains("255, 0, 0"))
		{
		assertTrue(true);
		System.out.println("incell bar negative value property applied successfully.");
		}else
		{
			if(incellBars.get(i).getCssValue("background-color").contains("0, 0, 0"))
			{
				System.out.println("Incell bar color for positive value is correct.");
			}else
			{
				System.out.println("Incell bar color for positive value is correct.");
			}
			
		}
		
 	}
	test.info("incell bar negative value property applied successfully.");
		
	Thread.sleep(2000);
	 //Click Down and do Save As:====================
	 log.driver.findElement(By.xpath("(//span[text()='Save'])[2]/following::span[1]")).click();
	 Thread.sleep(2000);
	 waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Save As'])[2]");
	 log.driver.findElement(By.xpath("(//span[text()='Save As'])[2]")).click();
	 Thread.sleep(2000);
	 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report as']")).isDisplayed());
	 Thread.sleep(1000);
	 System.out.println("Save Report as window is displaying now.");
	
	 //Change Name:===========
	 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
	 waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Name'])[1]/following::input[1]");
	 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("TestCase_InCellBar_Negative_Value");
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
	waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TestCase_InCellBar_Negative_Value']");
	Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='TestCase_InCellBar_Negative_Value']")).isDisplayed());
	System.out.println("saves as completed without popup");
	}
	
	//Delete Report:==================
	log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
	Thread.sleep(3000);
	log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
	Thread.sleep(3000);
	
	waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='TestCase_InCellBar_Negative_Value'])[1]/ancestor::div[1]/span[1]");
	log.driver.findElement(By.xpath("(//span[text()='TestCase_InCellBar_Negative_Value'])[1]/ancestor::div[1]/span[1]")).click();
	Thread.sleep(3000);
		
	Actions act1=new Actions(log.driver);
	act1.contextClick(log.driver.findElement(By.xpath("(//span[text()='TestCase_InCellBar_Negative_Value'])[1]"))).perform();
	Thread.sleep(2000);
	log.driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
	Thread.sleep(2000);
	log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
	Thread.sleep(2000);
	
	log.driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
