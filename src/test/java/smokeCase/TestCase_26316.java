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

public class TestCase_26316 extends TestUtils
{
	@Test	
	@Parameters("browser")
	public void Testcase_to_verify_functionality_of_Analytical_Visualization_Threshold_Edit(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_26316 : Web_Testcase to verify functionality of <Analytical Visualization Threshold_Edit>");
	   
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='All Reports']/ancestor::div[2]//span[text()='Threshold_New']");
		log.driver.findElement(By.xpath("//span[.='All Reports']/ancestor::div[2]//span[text()='Threshold_New']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Threshold_New' and @id='tab_close_btn']/ancestor::span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Threshold_New' and @id='tab_close_btn']/ancestor::span[1]")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		String textcolor = log.driver.findElement(By.xpath("(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]")).getCssValue("color");
		System.out.println("color present for AV is " +textcolor);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(1000);
		
		ui.dragAndDrop(log.driver.findElement(By.xpath(log.getData("Customer"))), log.driver.findElement(By.xpath(log.getData("Background"))));
		Thread.sleep(4000);
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Category'])[2]")), log.driver.findElement(By.xpath(log.getData("Row"))));
		Thread.sleep(4000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Category");
		System.out.println("Category is present in rows");

		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("InsertAllVisibleItem"));
		log.driver.findElement(By.xpath(log.getData("InsertAllVisibleItem"))).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
			
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Time']");
		log.driver.findElement(By.xpath("//span[text()='Time']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed(),true);
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
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
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		ui.rightClick("(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Single Data Cell']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed(),true);
		
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(text(),'Threshold Analysis: column 1')])[1]");
		log.driver.findElement(By.xpath("(//span[contains(text(),'Threshold Analysis: column 1')])[1]")).click();
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
		Assert.assertEquals(ElementLevel1,"Elements of level 1");
		
		//verifying the elements of level 1 are in bold
		List<WebElement> ele1 = log.driver.findElements(By.xpath("(//div[text()='All Customers'])[1]/../../../div[2]/div/div[@span='0']"));//step 23
		for (int i = 1; i < ele1.size(); i++) {
			assertEquals(ele1.get(i).getCssValue("font-weight"), "700");
		}
		
		System.out.println("elements of level 1 are in bold state");
		test.info("elements of level 1 are in bold state");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//label[text()='Based on index'])[1]/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//label[text()='Based on index'])[1]/../../td[1]/input")).isSelected(),true);
		System.out.println("Based on index is selected default");
		test.info("Based on index is selected default");
		Thread.sleep(1000);
		
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
		System.out.println("Use paths  enabled");
		test.info("Use paths  enabled");
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//button[text()='Whole table'])[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//button[text()='Whole table'])[1]")).isEnabled(),true);
		System.out.println("Whole table Enabled");
		test.info("Whole table Enabled");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//button[text()='Whole table'])[1]");
		log.driver.findElement(By.xpath("(//button[text()='Whole table'])[1]")).click();
		Thread.sleep(1000);
		/*	waits.waitUntil_Elmentis_visibilityOfElement(10," (//div[text()='2015']/../../..)[1]/div[4]/div[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath(" (//div[text()='2015']/../../..)[1]/div[4]/div[2]")).isEnabled(),true);*/
		
		
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
		Assert.assertEquals(ElementLevel1src,"Elements of level 1");
		
		//verifying the elements of level 1 are in bold
		List<WebElement> ele2 = log.driver.findElements(By.xpath("(//div[text()='Used Car'])[2]/../../../div[2]/div/div[@span='0']"));//step 23
		for (int i = 1; i < ele2.size(); i++) {
			assertEquals(ele2.get(i).getCssValue("font-weight"), "700");
		}
		
		System.out.println("elements of level 1 are in bold state");
		test.info("elements of level 1 are in bold state");
		Thread.sleep(200);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//label[text()='Based on index'])[2]/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//label[text()='Based on index'])[2]/../../td[1]/input")).isSelected(),true);
		System.out.println("Based on index is selected default in source window");
		test.info("Based on index is selected default in source window");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[2]/../../td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[2]/../../td[1]/input")).isSelected());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[2]/../../td[1]");
		log.driver.findElement(By.xpath("(//label[text()='Based on element'])[2]/../../td[1]")).click();
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[2]/../../td[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[2]/../../td[1]/input")).isSelected());
		System.out.println("Based on element is selected in source window");
		test.info("Based on element is selected in source window");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//button[text()='Delete selection']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Delete selection']")).isEnabled(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Aggregation:'])[1]/following::div[1]/div[1]/span/span/span[1]");	
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Aggregation:'])[1]/following::div[1]/div[1]/span/span/span[1]")).getText(), "No Aggregation");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Ignore empty values']/../../td[1]");	
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='Ignore empty values']/../../td[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//button[text()='Whole table'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//button[text()='Whole table'])[2]")).isEnabled(),true);
		System.out.println("Whole table Enabled");
		test.info("Whole table Enabled");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//button[text()='Whole table'])[2]");
		log.driver.findElement(By.xpath("(//button[text()='Whole table'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(4000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Threshold_New'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Threshold_New'])[2]")).isDisplayed(),true);
		
		
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Analytical Visualizations']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Analytical Visualizations']");
		log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit...']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit...']");
		log.driver.findElement(By.xpath("//span[text()='Edit...']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(text(),'Threshold Analysis')])[6]");
		log.driver.findElement(By.xpath("(//span[contains(text(),'Threshold Analysis')])[6]")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the Threshold Analysis']")).isDisplayed(),true);
		System.out.println("Settings for the Threshold Analysis====");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings for the Threshold Analysis']/ancestor::div[3]/div[2]/div[1]//button");
		log.driver.findElements(By.xpath("//span[text()='Settings for the Threshold Analysis']/ancestor::div[3]/div[2]/div[1]//button")).get(3).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Format']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Format']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Font name']/ancestor::td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='Font name']/ancestor::td[1]/input[1]")).isSelected());
		System.out.println("Font name checkbox is unchecked");
		test.info("Font name checkbox is unchecked");
		log.driver.findElement(By.xpath("//label[text()='Font name']/ancestor::td[1]")).click();
		Thread.sleep(1000);
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Font name']/ancestor::td[1]/input[1]")).isSelected());
		Thread.sleep(500);
		
		WebElement FontName=log.driver.findElement(By.xpath("//label[text()='Font name']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]"));
		//a1.click(FontName).sendKeys("Verdana", Keys.ENTER).build().perform();
		a1.click(FontName).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(FontName).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Font name']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Arial Black");
		System.out.println("Arial Black is selected in dropdown");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Font style']/ancestor::td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='Font style']/ancestor::td[1]/input[1]")).isSelected());
		System.out.println("Font style checkbox is unchecked");
		test.info("Font style checkbox is unchecked");
		
		log.driver.findElement(By.xpath("//label[text()='Font style']/ancestor::td[1]")).click();
		Thread.sleep(1000);
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Font style']/ancestor::td[1]/input[1]")).isSelected());
		Thread.sleep(100);
		System.out.println("Font style checkbox is checked");
		test.info("Font style checkbox is checked");
		
		Thread.sleep(1000);
		if(log.driver.findElement(By.xpath("//label[text()='Italic']/ancestor::td[1]")).isEnabled()){
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Italic']/ancestor::td[1]");
			log.driver.findElement(By.xpath("//label[text()='Italic']/ancestor::td[1]")).click();
			Thread.sleep(1000);
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Italic']/ancestor::td[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Italic']/ancestor::td[1]/input[1]")).isSelected(),true);
			
		}else{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Font style']/ancestor::td[1]");
			log.driver.findElement(By.xpath("//label[text()='Font style']/ancestor::td[1]")).click();
			Thread.sleep(1000);
			Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Italic']/ancestor::td[1]")).isEnabled(),true);
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Italic']/ancestor::td[1]");
			log.driver.findElement(By.xpath("//label[text()='Italic']/ancestor::td[1]")).click();
			Thread.sleep(1000);
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Italic']/ancestor::td[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Italic']/ancestor::td[1]/input[1]")).isSelected(),true);	
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(1000);	
		
		//validate the property 
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Sales by country'])[2]/ancestor::div[3]/div[5]/div/div/div[3]/div[1]/div");
		List<WebElement> column_Count = log.driver.findElements(By.xpath("(//span[text()='Sales by country'])[2]/ancestor::div[3]/div[5]/div/div/div[3]/div[1]/div"));
		
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Sales by country'])[2]/ancestor::div[3]/div[5]/div/div/div[3]/div[1]/div");
		for (int j = 1; j <= column_Count.size()-1; j++) {
			Thread.sleep(1000);
			List<WebElement> Row_count = log.driver.findElements(By.xpath("//div[text()='All Customers']/ancestor::div[4]/div/div[4]/div/div/div[1]"));
			
			for (int i = 0; i < Row_count.size()-1; i++) {
				if(j==1)
				{
					Thread.sleep(1000);
				List<WebElement> Verify_AV_EL1 = log.driver.findElements(By.xpath("//div[text()='All Customers']/ancestor::div[4]/div/div[4]/div/div/div["+j+ "]"));
				Assert.assertFalse(Verify_AV_EL1.get(i).getCssValue("color").equals(textcolor));
				System.out.println("first column does not have green color");
				}
				else{
					Thread.sleep(1000);
					List<WebElement> Verify_AV_EL1 = log.driver.findElements(By.xpath("//div[text()='All Customers']/ancestor::div[4]/div/div[4]/div/div/div["+j+ "]"));
					Assert.assertTrue(Verify_AV_EL1.get(i).getCssValue("color").equals(textcolor));
					System.out.println("column" +j+" is in green color");
					Thread.sleep(200);
					Assert.assertTrue(Verify_AV_EL1.get(i).getCssValue("font-style").equals("italic"));
					System.out.println("column" +j+ " element"+i+ " is italic");
					
				}
			}
			
		}
		
		System.out.println("THreshold AV edit applied successfully");
		test.info("THreshold AV edit applied successfully");
		
		
		log.driver.close();
		
		
		
		
	}
}
