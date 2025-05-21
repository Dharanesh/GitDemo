package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Waits;

public class TestCase_24479 extends TestUtils
{
	@Test	
	@Parameters("browser")

	//Web_Testcase to verify functionality of Analytical Visualization  MiniChart_Bar_New
	public void Testcase_Cockpit10_Analytical_Viz_Minichart_New(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24479 Web_Testcase to verify functionality of <Analytical Visualization Gradient_New>");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Sales by country']");
		clickableClick(By.xpath("//span[text()='Sales by country']"));
        Thread.sleep(2000);

        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Sales by country'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		 waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Sales by country'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Time']");
		clickableClick(By.xpath("//span[text()='Time']"));
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
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		Actions a1=new Actions(log.driver);
		a1.contextClick(log.driver.findElement(By.xpath(("//div[text()='2014']")))).build().perform();
		Thread.sleep(1000);
		a1.moveToElement(log.driver.findElement(By.xpath(("//span[text()='Analytical Visualizations']")))).build().perform();
		Thread.sleep(200);
		a1.click(log.driver.findElement(By.xpath(("//span[text()='New...']")))).build().perform();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Analytical Visualization']");
		System.out.println("Create new Analytical visualization");
		
		log.driver.findElement(By.xpath("//span[text()='Gradient']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()='Creates a new gradient analysis.']")).isDisplayed();
		System.out.println("gradient is selected");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Creates a new gradient analysis.']")).isDisplayed(),true);
		Thread.sleep(200);
		System.out.println("Creates a new gradient analysis.");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the Gradient Analysis']")).isDisplayed(),true);
		System.out.println("Settings for the Gradient Analysis====");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='Settings for the Gradient Analysis']/ancestor::div[6]//button/span");
		List<WebElement> Buttons = log.driver.findElements(By.xpath("//span[text()='Settings for the Gradient Analysis']/ancestor::div[6]//button/span"));
		
		for(int i =0;i<=Buttons.size()-1;i++) 
		{
			//String check = window_button.get(i).getText();
			assertEquals(Buttons.get(i).isDisplayed(),true);
			
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings for the Gradient Analysis']/ancestor::div[6]//input[@role='button']");
		List<WebElement> Buttons1 = log.driver.findElements(By.xpath("//span[text()='Settings for the Gradient Analysis']/ancestor::div[6]//input[@role='button']"));
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
		
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed(),true);
		Thread.sleep(200);
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(2000);
		
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
		
		List<WebElement> verifications = log.driver.findElements(By.xpath("//div[text()='2014']/ancestor::div[4]/div/div[4]/div/div/div[1]"));
		ArrayList<Float> value = new ArrayList<Float>();
		 for (int i =0;i<=verifications.size()-1;i++)
		 {
			 String text=verifications.get(i).getText();
			 String value1 = text.replaceAll("[€,()]","").trim();
			 Float convertedActualvalue =Float.parseFloat(value1);
			 value.add(convertedActualvalue);
		 }
	
		 // sorting array
		 Collections.sort(value);

	      // let us print all the elements available in list
	      System.out.println("The sorted float array is:");
	      for (float number : value) {
	         System.out.println("Number = " + number);
	         
	      }
		
		
		
		log.driver.close();
		
		
		
	}
}
