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



public class TestCase_26318 extends TestUtils
{
	
	@Test	
	@Parameters("browser")
	public void Testcase_to_verify_functionality_of_Analytical_Visualization_InCell_Bar__Edit(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_26318 : Web_Testcase to verify functionality of <Analytical Visualization InCell Bar_Edit>");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TestCase_InCell_Bar_New']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='TestCase_InCell_Bar_New']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TestCase_InCell_Bar_New']");
		log.driver.findElement(By.xpath("//span[text()='TestCase_InCell_Bar_New']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='TestCase_InCell_Bar_New'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='TestCase_InCell_Bar_New'])[2]")).isDisplayed(),true);
		
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='2014']/ancestor::div[4]/div/div[4]/div/div/div[1]/div");
		String textcolor = log.driver.findElements(By.xpath("//div[text()='2014']/ancestor::div[4]/div/div[4]/div/div/div[1]/div")).get(0).getCssValue("background-color");
		System.out.println("color present for AV is " +textcolor);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
		Thread.sleep(2000);
		
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Customer'])[1]")), log.driver.findElement(By.xpath(log.getData("Background"))));
		Thread.sleep(5000);
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Category'])[2]")), log.driver.findElement(By.xpath(log.getData("Row"))));
		Thread.sleep(5000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Category");
		System.out.println("Category is present in rows");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Category");
		System.out.println("Category is present in Rows");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,log.getData("InsertAllVisibleItem"));
		log.driver.findElement(By.xpath(log.getData("InsertAllVisibleItem"))).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(), "Time");
		System.out.println("Time is present in columns");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Time']");
		log.driver.findElement(By.xpath("//span[text()='Time']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Columns_Dimension_Header"))).isDisplayed());
		
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(2000);
		
		/*waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Base elements with containers (0 Items)']");
	
		String basevalueempty=log.driver.findElement(By.xpath("//span[text()='Base elements with containers (0 Items)']")).getText();
		Assert.assertEquals(basevalueempty, "Base elements with containers (0 Items)");
		Thread.sleep(2000);
		System.out.println("base element with container area is empty");*/
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='All Periods']/../div[2]");
		log.driver.findElement(By.xpath("//div[text()='All Periods']/../div[2]")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='All Periods']/../div[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='All Periods']/../div[2]/input")).isSelected(),true);
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014'])[1]/../div[2]");
		log.driver.findElement(By.xpath("(//div[text()='2014'])[1]/../div[2]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014'])[1]/../div[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='2014'])[1]/../div[2]/input")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2015'])[1]/../div[2]");
		log.driver.findElement(By.xpath("(//div[text()='2015'])[1]/../div[2]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2015'])[1]/../div[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='2015'])[1]/../div[2]/input")).isSelected(),true);
		
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();
		Thread.sleep(1000);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");

		List<WebElement> basevalue = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> base= new ArrayList<String>();
		System.out.println("New Report radio button option");
		base.add("All Periods");
		base.add("2014");
		base.add("2015");

		for(int i=0;i<=basevalue.size()-1;i++) 
		{
			assertEquals(basevalue.get(i).getText(), base.get(i));
			System.out.println(basevalue.get(i).getText());

		}
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Sales by country']/ancestor::div[3]/div[5]/div/div/div[3]/div/div");
		Assert.assertEquals(log.driver.findElements(By.xpath("//span[text()='Sales by country']/ancestor::div[3]/div[5]/div/div/div[3]/div/div")).get(0).getText(),"All Periods");
		
		Thread.sleep(1000);
		List<WebElement> verifications = log.driver.findElements(By.xpath("//div[text()='2014']/ancestor::div[4]/div/div[4]/div/div/div[1]/div"));
		 for (WebElement web : verifications)
		 {
			 assertTrue(web.getCssValue("background-color").equals(textcolor));
			 
		}
		System.out.println("AV_incell bar present correctly, AV based on index working fine");
		test.info("AV_incell bar is present correctly in first column, AV based on index working fine");
		
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		log.driver.findElement(By.xpath("(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		ui.rightClick("(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[.='Single Data Cell']")).isDisplayed())
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
		
/*		List<WebElement> Context = log.driver.findElements(By.xpath("//span[text()='Single Data Cell']/../../li/span[1]"));
		ArrayList<String> CV= new ArrayList<String>();
		System.out.println("Single Data cell context menu options are:");
		test.info("Single Data cell context menu options are:");
		CV.add("Single Data Cell");
		CV.add("Start Write Mode");
		CV.add("Copy");
		CV.add("Copy (value formatted)");
		CV.add("Define Subview...");
		CV.add("Assign Analytical Visualization to Chart 'Grafik'...");
		CV.add("Analytical Visualizations");
		CV.add("Edit Table...");
		CV.add("Table Properties...");
		for(int i=0;i< Context.size()-1;i++) 
		{
			assertEquals(Context.get(i).getText(), CV.get(i));
			System.out.println(Context.get(i).getText());

		}
		
		Context.get(6).click();
		Thread.sleep(1000);*/
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Analytical Visualizations']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Analytical Visualizations']");
		log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Assignment']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit Assignment']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Assignment']");
		log.driver.findElement(By.xpath("//span[text()='Edit Assignment']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Assignment']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit Assignment']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Assignment']");
		log.driver.findElement(By.xpath("//span[text()='Edit Assignment']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(text(),'In-Cell Bars 1:')])[1]");
		log.driver.findElement(By.xpath("(//span[contains(text(),'In-Cell Bars 1:')])[1]")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Assignment of the Analytical Visualization  [DataView: Sales]']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Assignment of the Analytical Visualization  [DataView: Sales]']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Allocation(target)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Allocation(target)']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).isDisplayed(),true);
		Thread.sleep(2000);
		
		WebElement e1=log.driver.findElement(By.xpath("(//span[text()='Element level:'])[1]/following::div[1]/div[1]/span/span/span[1]"));
		Actions a1=new Actions(log.driver);
		//a1.click(e1).sendKeys("Elements of level 1", Keys.ENTER).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Element level:'])[1]/following::div[1]/div[1]/span/span/span[1]");
		String ElementLevel1= log.driver.findElement(By.xpath("(//span[text()='Element level:'])[1]/following::div[1]/div[1]/span/span/span[1]")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(ElementLevel1,"Elements of level 1");
		
		//verifying the elements of level 1 are in bold
		List<WebElement> ele1 = log.driver.findElements(By.xpath("(//div[text()='Used Car'])[1]/../../../div[2]/div/div[@span='0']"));//step 23
		for (int i = 1; i < ele1.size(); i++) {
			assertEquals(ele1.get(i).getCssValue("font-weight"), "700");
		}
		
		System.out.println("elements of level 1 are in bold state");
		test.info("elements of level 1 are in bold state");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//label[text()='Based on index'])[1]/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//label[text()='Based on index'])[1]/../../td[1]/input")).isSelected(),true);
		System.out.println("Based on index is selected default");
		test.info("Based on index is selected default");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[1]/../../td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[1]/../../td[1]/input")).isSelected());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[1]/../../td[1]");
		log.driver.findElement(By.xpath("(//label[text()='Based on element'])[1]/../../td[1]")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[1]/../../td[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[1]/../../td[1]/input")).isSelected());
		System.out.println("Based on element is selected");
		test.info("Based on element is selected");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Use paths'])[1]/../../td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Use paths'])[1]/../../td[1]/input")).isSelected());
		System.out.println("Use paths enabled");
		test.info("Use paths enabled");
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//button[text()='Whole table'])[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//button[text()='Whole table'])[1]")).isEnabled(),true);
		System.out.println("Whole table Enabled");
		test.info("Whole table Enabled");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='2015'])[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10," (//div[text()='2015']/../../..)[1]/div[4]/div[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath(" (//div[text()='2015']/../../..)[1]/div[4]/div[2]")).isEnabled(),true);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).click();
		Thread.sleep(2000);
		
		WebElement e2=log.driver.findElement(By.xpath("(//span[text()='Element level:'])[2]/following::div[1]/div[1]/span/span/span[1]"));
		//a1.click(e2).sendKeys("Elements of level 1", Keys.ENTER).build().perform();
		a1.click(e2).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e2).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e2).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Element level:'])[2]/following::div[1]/div[1]/span/span/span[1]");
		String ElementLevel1src= log.driver.findElement(By.xpath("(//span[text()='Element level:'])[2]/following::div[1]/div[1]/span/span/span[1]")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(ElementLevel1src,"Elements of level 1");
		
		//verifying the elements of level 1 are in bold
		List<WebElement> ele2 = log.driver.findElements(By.xpath("(//div[text()='Used Car'])[2]/../../../div[2]/div/div[@span='0']"));//step 23
		for (int i = 1; i < ele2.size(); i++) {
			assertEquals(ele2.get(i).getCssValue("font-weight"), "700");
		}
		
		System.out.println("elements of level 1 are in bold state");
		test.info("elements of level 1 are in bold state");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//label[text()='Based on index'])[2]/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//label[text()='Based on index'])[2]/../../td[1]/input")).isSelected(),true);
		System.out.println("Based on index is selected default in source window");
		test.info("Based on index is selected default in source window");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[2]/../../td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[2]/../../td[1]/input")).isSelected());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[2]/../../td[1]");
		log.driver.findElement(By.xpath("(//label[text()='Based on element'])[2]/../../td[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[2]/../../td[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[2]/../../td[1]/input")).isSelected());
		System.out.println("Based on element is selected in source window");
		test.info("Based on element is selected in source window");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//button[text()='Delete selection']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Delete selection']")).isEnabled(),true);
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='2015'])[2]")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10," (//div[text()='2015']/../../..)[2]/div[4]/div[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath(" (//div[text()='2015']/../../..)[2]/div[4]/div[2]")).isEnabled(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Aggregation:'])[1]/following::div[1]/div[1]/span/span/span[1]");	
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Aggregation:'])[1]/following::div[1]/div[1]/span/span/span[1]")).getText(), "No Aggregation");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Ignore empty values']/../../td[1]");	
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='Ignore empty values']/../../td[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(4000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='TestCase_InCell_Bar_New'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='TestCase_InCell_Bar_New'])[2]")).isDisplayed(),true);
		
		/*waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		ui.rightClick("(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		Thread.sleep(2000);*/
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		log.driver.findElement(By.xpath("(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		ui.rightClick("(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[.='Single Data Cell']")).isDisplayed())
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Analytical Visualizations']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Analytical Visualizations']");
		log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit...']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit...']");
		log.driver.findElement(By.xpath("//span[text()='Edit...']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(text(),'In-Cell Bars')])[6]");
		log.driver.findElement(By.xpath("(//span[contains(text(),'In-Cell Bars')])[6]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings for the In Cell Bar Analysis']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the In Cell Bar Analysis']")).isDisplayed(),true);
		System.out.println("Settings for the Incellbar====");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Show values']/ancestor::tr/td[3]/div");
		Assert.assertFalse(log.driver.findElement(By.xpath("//div[text()='Show values']/ancestor::tr/td[3]//input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Show values']/ancestor::tr/td[3]/div");
		log.driver.findElement(By.xpath("//div[text()='Show values']/ancestor::tr/td[3]/div")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Show values']/ancestor::tr/td[3]/div");
		Assert.assertTrue(log.driver.findElement(By.xpath("//div[text()='Show values']/ancestor::tr/td[3]//input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		ui.multiButton("//input[@value='Finish']");
		Thread.sleep(2000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Sales by country'])[2]/ancestor::div[3]/div[5]/div/div/div[3]/div[1]/div");
		List<WebElement> column_Count = log.driver.findElements(By.xpath("(//span[text()='Sales by country'])[2]/ancestor::div[3]/div[5]/div/div/div[3]/div[1]/div"));
		System.out.println("column_Count===="+column_Count.size());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Sales by country'])[2]/ancestor::div[3]/div[5]/div/div/div[3]/div[1]/div");
		for (int j =1; j <= column_Count.size()-1; j++)
		{
			Thread.sleep(1000);
			List<WebElement> Row_count = log.driver.findElements(By.xpath("//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div[1]"));
			System.out.println("Row_count======"+Row_count.size());
			
			for (int i = 0; i < Row_count.size()-1; i++) 
			{
				if(j==3)
				{
					Thread.sleep(2000);
				List<WebElement> Verify_AV_EL1 = log.driver.findElements(By.xpath("//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div["+j+ "]"));
				if(i==0)
				{
					Assert.assertFalse(Verify_AV_EL1.get(i).getCssValue("background-color").equals(textcolor));
					System.out.println("column" +j +" element" +i +" does not have AV applied to it." );
				}else
				{
					List<WebElement> incellBars = log.driver.findElements(By.xpath("//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div["+j+ "]/div"));
					for (int k = 0; k < incellBars.size(); k++) 
					{
						Assert.assertTrue(incellBars.get(k).getCssValue("background-color").equals(textcolor));
						System.out.println("column" +j +" element" +k +" have AV applied to it." );
					}
					
				}
				}
				else{
					Thread.sleep(2000);
					List<WebElement> Verify_AV_EL1 = log.driver.findElements(By.xpath("//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div["+j+ "]"));
					Assert.assertFalse(Verify_AV_EL1.get(i).getCssValue("background-color").equals(textcolor));
					System.out.println("column" +j +" element" +i + " does not have AV applied to it.");
						
				}
			}
			
		}
		Thread.sleep(2000);
		System.out.println("In cell bar based on element applied successfully.");
		test.info("In cell bar based on element applied successfully.");
		
		
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
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("TestCase_InCell_Bar_Edit");
		 Thread.sleep(2000);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(1000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(2000);
		
		try
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'A report named')]")).isDisplayed();
			log.driver.findElement(By.xpath("//input[@value='OK']")).click();
			System.out.println("popup appeared");
		}
		catch(Exception e)
		{
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TestCase_InCell_Bar_Edit']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='TestCase_InCell_Bar_Edit']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		Thread.sleep(2000);
		//Delete Report:==================
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='TestCase_InCell_Bar_New'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='TestCase_InCell_Bar_New'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);
		
		
		Actions act1=new Actions(log.driver);
		act1.contextClick(log.driver.findElement(By.xpath("(//span[text()='TestCase_InCell_Bar_New'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		/*act1.contextClick(log.driver.findElement(By.xpath("(//span[text()='TestCase_InCell_Bar_Edit'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);*/
		
		log.driver.close();	
		
		
		
		
		
		
		
		
		
		
	}

}
