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



public class TestCase_24484 extends TestUtils
{
	//TestCase_24483 var=new TestCase_24483();
	
    @Test	
	@Parameters("browser")
	public void Web_Testcase_to_verify_functionality_of_Analytical_Visualization_MiniChart_Bar_Edit(String browser) throws Exception
	{
 
	    test =extent.createTest("TestCase_24484 :Web_Testcase to verify functionality of <Analytical Visualization  MiniChart_Bar_Edit>");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TESTCASE_MINICHART_NEW']");
		log.driver.findElement(By.xpath("//span[text()='TESTCASE_MINICHART_NEW']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='TESTCASE_MINICHART_NEW'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='TESTCASE_MINICHART_NEW'])[2]")).isDisplayed(),true);
		
		
		String width=TestCase_24483.Width;
		String height=TestCase_24483.Height;
		System.out.println(width+"==="+height);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img");
		List<WebElement> imgvalueoftable = log.driver.findElements(By.xpath("//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img"));
		for (WebElement ele : imgvalueoftable) 
		{
			
			assertTrue(ele.isDisplayed());
		}
		
		System.out.println("anyaltical visulization_minichart applied successfully to table");
		test.info("anyaltical visulization_minichart applied successfully to table");
		Thread.sleep(1000);
		
	/*	waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
		Thread.sleep(1000);*/
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Customer");
		System.out.println("Customer is present in Rows");
		
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Customer'])[1]")), log.driver.findElement(By.xpath(log.getData("Background"))));
		Thread.sleep(5000);
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Category'])[2]")), log.driver.findElement(By.xpath(log.getData("Row"))));
		Thread.sleep(5000);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Category");
		System.out.println("Category is present in Rows");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(), "Time");
		System.out.println("Time is present in columns");
		
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Measures'])[2]")), log.driver.findElement(By.xpath(log.getData("Columns"))));
		Thread.sleep(2000);
		
		List<WebElement> colmns = log.driver.findElements(By.xpath(log.getData("Columns_Value")));
		for (WebElement we : colmns) 
		{
			if(we.getText().equals("Time") || we.getText().equals("Measures"))
			{
				System.out.println(we.getText());
			}	
		}
		
		List<WebElement> colmn_headers = log.driver.findElements(By.xpath("//div[text()='All Categories']/ancestor::div[3]/div[3]/div/div"));
		if(colmn_headers.contains("Sales")){
			assertTrue(true);
			System.out.println("Measures is added in the table");
			test.info("Measures is added in the table");
		}
		
		
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img)[1]");
		log.driver.findElement(By.xpath("(//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img)[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img)[1]");
		ui.rightClick("(//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img)[1]");
		Thread.sleep(2000);
		
//		try
//		{
//			if(log.driver.findElement(By.xpath("//span[text()='//span[.='Single Data Cell']']")).isDisplayed())
//			{
//				System.out.println("Single Data Cell Available");
//			}
//		}
//		catch(Exception e)
//		{
//			 Actions act = new Actions(log.driver);
//		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='2/0'])[1]"))).perform();
//		     Thread.sleep(2000);
//		}
		
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Single Data Cell']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed(),true);
		
		List<WebElement> Context = log.driver.findElements(By.xpath("//span[text()='Single Data Cell']/../../li/span[1]"));
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
		for(int i=0;i<Context.size()-1;i++) 
		{
			assertEquals(Context.get(i).getText(), CV.get(i));
			System.out.println(Context.get(i).getText());

		}
		
		Context.get(6).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Assignment']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit Assignment']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Assignment']");
		log.driver.findElement(By.xpath("//span[text()='Edit Assignment']")).click();
		Thread.sleep(1000);
		waitForVisibilityOfElement(By.xpath("(//span[text()='Minichart 1: column 3'])[1]"));
		clickableClick(By.xpath("(//span[text()='Minichart 1: column 3'])[1]"));
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Assignment of the Analytical Visualization  [DataView: Sales]']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Assignment of the Analytical Visualization  [DataView: Sales]']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Allocation(target)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Allocation(target)']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath(("(//div[text()='Seperator'])[1]"))).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Seperator'])[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Seperator'])[1]")).isEnabled(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Element level:'])[1]/following::div[1]/div[1]/span/span/span[1]");
		String ElementLevel= log.driver.findElement(By.xpath("(//span[text()='Element level:'])[1]/following::div[1]/div[1]/span/span/span[1]")).getText();
		Assert.assertEquals(ElementLevel,"(all levels)");
		Thread.sleep(200);
		
		WebElement e1=log.driver.findElement(By.xpath("(//span[text()='Element level:'])[1]/following::div[1]/div[1]/span/span/span[1]"));
		Actions a1=new Actions(log.driver);
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		waitForVisibilityOfElement(By.xpath("(//span[text()='Element level:'])[1]/following::div[1]/div[1]/span/span/span[1]"));
		String ElementLevel1= findVisible(By.xpath("(//span[text()='Element level:'])[1]/following::div[1]/div[1]/span/span/span[1]")).getText();
		Assert.assertEquals(ElementLevel1,"Elements of level 1");
		Thread.sleep(1000);
		//verifying the elements of level 1 are in bold
		List<WebElement> ele1 = log.driver.findElements(By.xpath("(//div[text()='Used Car'])[1]/../../../div[2]/div/div[@span='0']"));//step 23
		for (int i = 1; i < ele1.size(); i++) {
			assertEquals(ele1.get(i).getCssValue("font-weight"), "700");
		}
		
		System.out.println("elements of level 1 are in bold state");
		test.info("elements of level 1 are in bold state");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//label[text()='Based on index'])[1]/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//label[text()='Based on index'])[1]/../../td[1]/input")).isSelected(),true);
		System.out.println("Based on index is selected default");
		test.info("Based on index is selected default");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[1]/../../td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[1]/../../td[1]/input")).isSelected());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[1]/../../td[1]");
		log.driver.findElement(By.xpath("(//label[text()='Based on element'])[1]/../../td[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[1]/../../td[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[1]/../../td[1]/input")).isSelected());
		System.out.println("Based on element is selected");
		test.info("Based on element is selected");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Use paths'])[1]/../../td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Use paths'])[1]/../../td[1]/input")).isSelected());
		System.out.println("Use paths enabled");
		test.info("Use paths enabled");
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//button[text()='Whole table'])[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//button[text()='Whole table'])[1]")).isEnabled(),true);
		System.out.println("Whole table Enabled");
		test.info("Whole table Enabled");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).click();
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		WebElement e2=log.driver.findElement(By.xpath("(//span[text()='Element level:'])[2]/following::div[1]/div[1]/span/span/span[1]"));
		//a1.click(e2).sendKeys("Elements of level 1", Keys.ENTER).build().perform();
		a1.click(e2).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e2).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e2).sendKeys(Keys.ENTER).build().perform();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Element level:'])[2]/following::div[1]/div[1]/span/span/span[1]");
		String ElementLevel1src= find(By.xpath("(//span[text()='Element level:'])[2]/following::div[1]/div[1]/span/span/span[1]")).getText();
		Assert.assertEquals(ElementLevel1src, "Elements of level 1");
		
		//verifying the elements of level 1 are in bold
		List<WebElement> ele2 = log.driver.findElements(By.xpath("(//div[text()='Used Car'])[2]/../../../div[2]/div/div[@span='0']"));//step 23
		for (int i = 1; i < ele2.size(); i++) {
			assertEquals(ele2.get(i).getCssValue("font-weight"), "700");
		}
		
		System.out.println("elements of level 1 are in bold state");
		test.info("elements of level 1 are in bold state");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//button[text()='Delete selection']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Delete selection']")).isEnabled(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(4000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='TESTCASE_MINICHART_NEW'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='TESTCASE_MINICHART_NEW'])[2]")).isDisplayed(),true);
		
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img)[1]");
		ui.rightClick(" (//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img)[1]");
		
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
		CV1.add("Assign Analytical Visualization to Chart 'Grafik'...");
		CV1.add("Analytical Visualizations");
		CV1.add("Edit Table...");
		CV1.add("Table Properties...");
		for(int i=0;i< Context1.size()-1;i++) 
		{
			assertEquals(Context1.get(i).getText(), CV1.get(i));
			System.out.println(Context1.get(i).getText());

		}
		
		Context1.get(6).click();
		Thread.sleep(1000);
		waitForVisibilityOfElement(By.xpath("//span[text()='Edit...']"));
		Assert.assertEquals(findVisible(By.xpath("//span[text()='Edit...']")).isDisplayed(),true);
		click(By.xpath("//span[text()='Edit...']"));
		waitForVisibilityOfElement(By.xpath("(//span[text()='Minichart 1'])[4]"));
		click(By.xpath("(//span[text()='Minichart 1'])[4]"));
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings for the Minichart']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the Minichart']")).isDisplayed(),true);
		System.out.println("Settings for the Minichart====");
		
		WebElement Chrttype=log.driver.findElement(By.xpath("//div[text()='Type']/following::div[1]/span[1]/span[1]/span[1]"));
		a1.click(Chrttype).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Type']/following::div[1]/span[1]/span[1]/span[1]")).getText(),"Line");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Line']/../../../td[1]/a /span");
		if(log.driver.findElement(By.xpath("//span[text()='Line']/../../../td[1]/a /span")).getAttribute("class").contains("plus"))
		{
			log.driver.findElement(By.xpath("//span[text()='Line']/../../../td[1]/a /span")).click();
			System.out.println("line is not expanded");
			test.info("line is not expanded");
		}
		else
		{
			System.out.println("line is expanded");
			test.info("line is expanded");
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Show markers']/following::td[1]/div");
		if(log.driver.findElement(By.xpath("//div[text()='Show markers']/following::td[1]/div/input")).isSelected())
		{
			
			System.out.println("Show marker is selected");
			test.info("Show marker is selected");
		}
		else
		{
			log.driver.findElement(By.xpath("//div[text()='Show markers']/following::td[1]/div")).click();
			System.out.println("show marker is not selected");
			test.info("show marker is not selected");
			Thread.sleep(500);
			Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Show markers']/following::td[1]/div/input")).isSelected(), true);
		}
				
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Marker color']/following::td[5]/button[1]");
		log.driver.findElement(By.xpath("//div[text()='Marker color']/following::td[5]/button[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select color']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Select color']")).isDisplayed());
		System.out.println("select color window displayed");
		test.info("select color window displayed");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select color']/following::td[14]");
		log.driver.findElement(By.xpath("//span[text()='Select color']/following::td[14]")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, " //td[text()='Red:']/..//input");
		Assert.assertEquals(findVisible(By.xpath(" //td[text()='Red:']/..//input")).getAttribute("value"), "0");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Green:']/..//input");
		Assert.assertEquals(findVisible(By.xpath("//td[text()='Green:']/..//input")).getAttribute("value"), "0");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Blue:']/..//input");
		Assert.assertEquals(findVisible(By.xpath("//td[text()='Blue:']/..//input")).getAttribute("value"), "255");
		
		System.out.println("values present in red, green and blue fields are correct");
		test.info("values present in red, green and blue fields are correct");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Actual:']/../div[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Actual:']/../div[2]")).getCssValue("background-color"),"rgba(0, 0, 255, 1)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the Minichart']")).isDisplayed(),true);
		System.out.println("Settings for the Minichart====");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Marker color']/following::td[3]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Marker color']/following::td[3]")).getCssValue("background-color"),"rgba(0, 0, 255, 1)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		ui.multiButton("//input[@value='Finish']");
		Thread.sleep(2000);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img");
		List<WebElement> imgsvalueoftable = log.driver.findElements(By.xpath("//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img"));
		for (WebElement ele : imgsvalueoftable) {
			
			Assert.assertEquals(ele.getAttribute("style"),"width: 100px; height: 18px;");
		}
		
		System.out.println("anyaltical visulization_minichart displayed successfully in table");
		test.info("anyaltical visulization_minichart displayed successfully in table");
		
		
		
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
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("TestCase_MiniChart_Bar_Edit");
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TestCase_MiniChart_Bar_Edit']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='TestCase_MiniChart_Bar_Edit']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
	}
}
