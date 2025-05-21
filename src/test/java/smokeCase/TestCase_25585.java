package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import action.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import event.Utils;
import event.Waits;

public class TestCase_25585 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Web_Testcase_to_verify_Cockpit_Data_Mashup_Functionality_Export_to_PDF_without_iteration(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_25585 : Cockpit Data Mashup Functionality Export to PDF_without iteration");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		/*waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Cockpit_DataMashup_Functionality PriorityCeck']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Cockpit_DataMashup_Functionality PriorityCeck']")).isDisplayed(),true);
		Thread.sleep(500);	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Cockpit_DataMashup_Functionality PriorityCeck']");
		log.driver.findElement(By.xpath("//span[text()='Cockpit_DataMashup_Functionality PriorityCeck']")).click();
	    Thread.sleep(1000);
		
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Cockpit_DataMashup_Functionality PriorityCeck'])[2]");
	   Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Functionality PriorityCeck'])[2]")).isDisplayed(),true);
	   Thread.sleep(500);
	   
	   int count1=0;
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MASHUP']");
		List<WebElement> mash_col_val = log.driver.findElements(By.xpath("//div[text()='MASHUP']"));
		for (WebElement webElement : mash_col_val)
		{
			count1+=1;
		}
		assertEquals(count1,5);
		System.out.println("Total mashup column "+ count1);
		test.info("Total mashup column "+count1);
		Thread.sleep(1000);*/
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Manangement overview']/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("//span[text()='Manangement overview']/ancestor::div[1]/span[1]")).click();
	    Thread.sleep(1000);
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Sales overview manangement']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Sales overview manangement']")).isDisplayed(),true);
		Thread.sleep(500);	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Sales overview manangement']");
		log.driver.findElement(By.xpath("//span[text()='Sales overview manangement']")).click();
	    Thread.sleep(1000);
		
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Sales overview manangement'])[2]");
	   Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sales overview manangement'])[2]")).isDisplayed(),true);
	   Thread.sleep(500);
		
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
	   Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
	   Thread.sleep(1000);
	   waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
	   Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Time");
	   System.out.println("Rows is present in Rows");
	   
	   waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
	   List<WebElement> column=log.driver.findElements(By.xpath(log.getData("Columns_Value")));
	   Assert.assertEquals(column.get(0).getText(),"Category");
	   Thread.sleep(2000);
	   System.out.println("Category is present in columns");
	   Assert.assertEquals(column.get(column.size()-1).getText(),"Measures");
	   Thread.sleep(2000);
	   System.out.println("Measures is present in columns");
		
	   //click on measures
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Measures']");
		log.driver.findElement(By.xpath("//span[text()='Measures']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
	   
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]");
		WebElement e2=log.driver.findElement(By.xpath("//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e2.getText(), "<No Limits>");
		System.out.println("Limits displayed correctly");
		test.info("Limits displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Current sorting:']/following::div[2]/span/span[1]/span[1]");
		WebElement e3=log.driver.findElement(By.xpath("//span[text()='Current sorting:']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e3.getText(), "<No Sorting>");
		System.out.println("Current sorting displayed correctly");
		test.info("Current sorting displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Display:']/following::div[2]/span/span[1]/span[1]");
		WebElement e4=log.driver.findElement(By.xpath("//span[text()='Display:']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e4.getText(), "<Element Name>");
		System.out.println("Value present in Display displayed correctly");
		test.info("Value present in Display displayed correctly");

		List<WebElement> AB = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for Rows')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB) {
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getText() + "    is displayed and Enabled");
			test.info(btn.getText() + "    is displayed and Enabled");
		}
	   
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		
		a1.click(elemnt).sendKeys(Keys.ENTER).build().perform();
		//a1.click(elemnt).sendKeys("Calculated elements", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elmntindrpdwn=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwn.getText(),"Calculated elements");
		System.out.println(elmntindrpdwn.getText());
		System.out.println("Calculated elements is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			String aa = selectble_ele.get(i).getText();
			selectable.add(aa);
			if(selectable.contains("MASHUP"))
			{
				assertTrue(true);
				
			}
			
		}
		System.out.println("MASHUP is present in the list of selectable elements");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MASHUP']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='MASHUP']/../div[1]")).isDisplayed());
		System.out.println("MASHUP Checkbox is present in the list of selectable elements");
        
		ArrayList<String > type = new ArrayList<String>();
		type.add("-SEPARATOR-");
		type.add("FORMULA");
		type.add("MASHUP");
		type.add("SUM");
		type.add("DIFFERENCE");
		type.add("PRODUCT");
		type.add("PRODUCT (X*Y)");
		type.add("AVERAGE");
		type.add("MINIMUM");
		
		
		System.out.println("ELements present in Selectable area are:  ");
		for(int i =0;i<=8;i++) 
		{
			Assert.assertEquals(selectble_ele.get(i).getText(),type.get(i));
			System.out.println(selectble_ele.get(i).getText());

			test.info(" MASHUP Position is correct");
		}
         Thread.sleep(500);
		for (int i =0;i< selectble_ele.size()-1;i++) 
		{
			Assert.assertEquals(selectble_ele.get(i).isSelected(), false);

		}
		System.out.println("checkboxes are unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MASHUP']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='MASHUP']/../div[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MASHUP']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='MASHUP']/../div[1]/input[1]")).isSelected());
		System.out.println("MASHUP Checkbox is Selected in the list of selectable elements");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		
		List<WebElement> Percentage = log.driver.findElements(By.xpath("//div[text()='MASHUP']/../div[1]/input"));
		for (int i = 0; i < Percentage.size()-1; i++) {
			
			assertTrue(Percentage.get(i).isSelected());
		}
		System.out.println("MASHUP is selected");			
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> el = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
		
		Assert.assertEquals(el.get(el.size()-1).getText(), "MASHUP");
						
		System.out.println("MASHUP is present a the last in Selected elements area");
		test.info("MASHUP is present a the last in Selected elements area");
        Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> BAseelemtAdded = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		ArrayList<String > type1 = new ArrayList<String>();
		int count=0;
		for(int i=0;i<=BAseelemtAdded.size()-1;i++)
		{
		   type1.add(BAseelemtAdded.get(i).getText());
		   count++;
		}
        System.out.println("Base element added "+count);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(4000);
		
		int count1=0;
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MASHUP']");
		List<WebElement> mash_col_val = log.driver.findElements(By.xpath("//div[text()='MASHUP']"));
		for (WebElement webElement : mash_col_val)
		{
			count1+=1;
		}
		assertEquals(count1,5);
		System.out.println("Total mashup column "+ count1);
		test.info("Total mashup column "+count1);
		Thread.sleep(1000);
		
		//write in january 2014 cell
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
		log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
		ui.rightClick("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
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
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='2/0'])[1]"))).perform();
		     Thread.sleep(2000);
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Single Data Cell']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Write...']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Write...']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Write...']");
		log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell Value']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cell Value']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell Value']/ancestor::div[2]/div[2]/div[1]//input[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cell Value']/ancestor::div[2]/div[2]/div[1]//input[1]")).isDisplayed());
		log.driver.findElement(By.xpath("//span[text()='Cell Value']/ancestor::div[2]/div[2]/div[1]//input[1]")).sendKeys("=E1");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[1])[1]");
		String Normalvalue1=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[1])[1]")).getText();
		System.out.println(Normalvalue1);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
		String Normalvalue=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]")).getText();
		System.out.println(Normalvalue);
		
		Float parsed_table_Value1= Float.parseFloat(Normalvalue);
		int Normalval = (int)Math.round(parsed_table_Value1);
		System.out.println(Normalval);
		Thread.sleep(1000);
		
		Assert.assertEquals(Normalvalue1,Integer.toString(Normalval));
		System.out.println("Value showing as expected");
		test.info("Value showing as expected");
		
		//Click Down and do Save As:====================
		log.driver.findElement(By.xpath("(//span[text()='Save'])[2]/following::span[1]")).click();
		 Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Save As'])[2]")).click();
		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report as']")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Save Report as window is displaying now.");
		
		//Change Name:===========
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Cockpit_DataMashup_Functionality PriorityCeck");
		Thread.sleep(2000);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(5000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(5000);
		try
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'A report named')]")).isDisplayed();
			log.driver.findElement(By.xpath("//input[@value='OK']")).click();
			System.out.println("popup appeared");
		}
		catch(Exception e)
		{
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Cockpit_DataMashup_Functionality PriorityCeck']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cockpit_DataMashup_Functionality PriorityCeck']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Cockpit_DataMashup_Functionality PriorityCeck'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Functionality PriorityCeck'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);
		
	   ui.rightClick("(//span[text()='Cockpit_DataMashup_Functionality PriorityCeck'])[1]");
	   Thread.sleep(2000);
       waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Report'])[3]/../../..");
	   Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Report'])[3]/../../..")).isDisplayed(),true);
	   Thread.sleep(100);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Report']/../../li/span[1]");
		List<WebElement> report_contextmenu_options =log.driver.findElements(By.xpath("//span[.='Report']/../../li/span[1]"));
		ArrayList<String > contextmenu_btn = new ArrayList<String>();
		contextmenu_btn.add("Open");
		contextmenu_btn.add("Add to Favorite Folder");
		contextmenu_btn.add("Duplicate");
		contextmenu_btn.add("Rename");
		contextmenu_btn.add("Delete");
		contextmenu_btn.add("Move...");
		contextmenu_btn.add("Export...");
		contextmenu_btn.add("Import...");
		contextmenu_btn.add("Send to...");
		contextmenu_btn.add("Language Terms...");
		contextmenu_btn.add("Description...");
		contextmenu_btn.add("Properties...");
		contextmenu_btn.add("Print and Export Settings...");
		contextmenu_btn.add("Permissions...");
		contextmenu_btn.add("Information...");
		
		System.out.println("Report context menu options are : ");
		Thread.sleep(5000);
		for (WebElement we : report_contextmenu_options)
		{
			report_contextmenu_options.contains(contextmenu_btn);
			System.out.println(we.getText());
			test.info(we.getText());
		}
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[.='Report']/../../li/span[text()='Print and Export Settings...']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Print settings for')])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Print settings for')])[2]")).isDisplayed());
		System.out.println(log.driver.findElement(By.xpath("(//div[contains(.,'Print settings for')])[3]/span")).getText());
		test.info(log.driver.findElement(By.xpath("(//div[contains(.,'Print settings for')])[3]/span")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Use current print template']");
		Thread.sleep(1000);
		if(log.driver.findElement(By.xpath("//label[text()='Use current print template']/../..//input")).isSelected()){
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Use current print template']/ancestor::td[1]");
			log.driver.findElement(By.xpath("//label[text()='Use current print template']")).click();
			Thread.sleep(1000);
			Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Use current print template']/../..//input")).isSelected(),false);
			Thread.sleep(500);
			System.out.println("use current print template Checkbox got uncheked");
			test.info("use current print template Checkbox got uncheked");

		}else{

			waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Use current print template']/ancestor::td[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Use current print template']/../..//input")).isSelected(),false);
			System.out.println("use current print template Checkbox is unchecked by default");
			test.info("use current print template Checkbox is unchecked by default");

		}
		Thread.sleep(1000);
		
		//click on adjust button
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Adjust...']");
		assertTrue(log.driver.findElement(By.xpath("//button[text()='Adjust...']")).isEnabled());
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Adjust...']");
		log.driver.findElement(By.xpath("//button[text()='Adjust...']")).click();
	    Thread.sleep(1000);	
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Print Template']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Print Template']")).isDisplayed());

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//a[text()='Footer']");
		assertTrue(log.driver.findElement(By.xpath("//a[text()='Footer']")).isDisplayed());

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//a[text()='Footer']");
		log.driver.findElement(By.xpath("//a[text()='Footer']")).click();

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Show footer']/ancestor::td[1]");
		assertTrue(log.driver.findElement(By.xpath("//label[text()='Show footer']/ancestor::td[1]/input[1]")).isSelected());

		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Right'])[2]/following::input[1]");
		assertEquals(log.driver.findElement(By.xpath("(//span[text()='Right'])[2]/following::input[1]")).getAttribute("value"), "<date>");

		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Right'])[2]/following::input[1]");
		log.driver.findElement(By.xpath("(//span[text()='Right'])[2]/following::input[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Right'])[2]/following::input[1]");
		log.driver.findElement(By.xpath("(//span[text()='Right'])[2]/following::input[1]")).clear();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Right'])[2]/following::input[1]");
		log.driver.findElement(By.xpath("(//span[text()='Right'])[2]/following::input[1]")).click();
		Thread.sleep(1000);

		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Print settings for')])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Print settings for')])[2]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		//click on export
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Cockpit_DataMashup_Functionality PriorityCeck'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Functionality PriorityCeck'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);
		
	   ui.rightClick("//span[text()='Cockpit_DataMashup_Functionality PriorityCeck']");
	   Thread.sleep(2000);
       waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Report'])[3]/../../..");
	   Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Report'])[3]/../../..")).isDisplayed(),true);
	   Thread.sleep(2000);
	   log.driver.findElement(By.xpath("//span[.='Report']/../../li/span[text()='Export...']")).click();
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Export Method']");
	   Thread.sleep(2000);
	   
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Export Method']/following::span[@class='reportNametxt']");
		List<WebElement> ExportReport = log.driver.findElements(By.xpath("//span[text()='Export Method']/following::span[@class='reportNametxt']"));
		ArrayList<String> ExportReportvalue= new ArrayList<String>();
		System.out.println("Export type radio button option");
		ExportReportvalue.add("Excel");
		ExportReportvalue.add("PowerPoint");
		ExportReportvalue.add("PDF");
		ExportReportvalue.add("PDF+");
		ExportReportvalue.add("One Page");
		ExportReportvalue.add("Image file");
		ExportReportvalue.add("CSV format");
		ExportReportvalue.add("HTML format");
		ExportReportvalue.add("XML export");
		ExportReportvalue.add("Excel (VBS)");
		ExportReportvalue.add("Word (VBS)");
		ExportReportvalue.add("PowerPoint (VBS)");
		ExportReportvalue.add("Definition (CWDX)");


		for(int i =0;i<=ExportReport.size()-1;i++) 
		{
			//String check = window_button.get(i).getText();
			assertEquals(ExportReport.get(i).getText(), ExportReportvalue.get(i));
			System.out.println("export window option is : "+ExportReport.get(i).getText());
			test.info("export window option is : "+ExportReport.get(i).getText());

		}

		test.info(" Export type radio button option is displayed ");
		System.out.println(" Export type radio button option is displayed ");
		Thread.sleep(1000);
		
		//select pdf as export
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='PDF']");
		log.driver.findElement(By.xpath("//span[text()='PDF']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[contains(@class,'description exportMargin')]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[contains(@class,'description exportMargin')]/span[1]")).getText(),"Export report(s) into PDF documents.");
		Thread.sleep(1000);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='nextbutton']");
		log.driver.findElement(By.xpath("//input[@id='nextbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Output']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Output']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='File name:']/ancestor::div[3]/div[2]//input[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='File name:']/ancestor::div[3]/div[2]//input[1]")).isEnabled(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='File name:']/ancestor::div[3]/div[2]//input[1]");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='File name:']/ancestor::div[3]/div[2]//input[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='File name:']/ancestor::div[3]/div[2]//input[1]")).clear();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='File name:']/ancestor::div[3]/div[2]//input[1]")).sendKeys("Mashup_PDF.pdf");
		Thread.sleep(2000);
		String Filename=log.driver.findElement(By.xpath("//span[text()='File name:']/ancestor::div[3]/div[2]//input[1]")).getAttribute("value");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='File name:']/ancestor::div[3]/div[2]//input[1]");
		Assert.assertEquals("Mashup_PDF.pdf",Filename);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='nextbutton']");
		log.driver.findElement(By.xpath("//input[@id='nextbutton']")).click();
		Thread.sleep(2000);
		
		//select no iteration
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Iteration Settings']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Iteration Settings']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='No iteration']");
		if(log.driver.findElement(By.xpath("//label[text()='No iteration']/../../td[1]/input")).isSelected())
		{
		  Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='No iteration']/../../td[1]/input")).isSelected(),true);
		  System.out.println("No iteration is  selected");
		  test.info("No iteration is  selected");
		}
		else
		{
			System.out.println("No iteration is not selected");
			test.info("No iteration is not selected");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='nextbutton']");
		log.driver.findElement(By.xpath("//input[@id='nextbutton']")).click();
		Thread.sleep(2000);
		
		//export property
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Export Properties']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Export Properties']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Output to a single file']");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Output to a single file']/ancestor::tr[1]/td[3]/div/input[1]")).isSelected());
		System.out.println("Output to a single file checkbox is selected");
		test.info("Output to a single file checkbox is selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Export even if no data']/ancestor::tr[1]/td[3]/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Export even if no data']/ancestor::tr[1]/td[3]/div/input[1]")).isSelected(),true);
		System.out.println("Export Even if no data is selected");
		test.info("Export Even if no data is selected");

		System.out.println(log.driver.findElement(By.xpath("//div[text()='File name']/following::div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='File name']/following::div[1]/span[1]/span[1]/span[1]")).getText(),"Default");

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='finishbutton']");
		log.driver.findElement(By.xpath("//input[@id='finishbutton']")).click();
		Thread.sleep(2000);
		
		//export window
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Export Execution']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//*[text()='Export Execution']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Start export...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//*[text()='Start export...']")).isEnabled(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Start export...']");
		log.driver.findElement(By.xpath("//*[text()='Start export...']")).click();
		
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,".//*[text()='Export finished successfully']");
		Assert.assertEquals(log.driver.findElement(By.xpath(".//*[text()='Export finished successfully']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Download']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//*[text()='Download']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Save Log...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//*[text()='Save Log...']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Download']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//*[text()='Download']")).isEnabled(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Download']");
		log.driver.findElement(By.xpath("//*[text()='Download']")).click();
				
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Close']");
		log.driver.findElement(By.xpath("//input[@value='Close']")).click();
		
		//changing the settings as before
		
	   ui.rightClick("//span[text()='Cockpit_DataMashup_Functionality PriorityCeck']");
	   Thread.sleep(2000);
       waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Report'])[3]/../../..");
	   Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Report'])[3]/../../..")).isDisplayed(),true);
	   Thread.sleep(100);
		
	   log.driver.findElement(By.xpath("//span[.='Report']/../../li/span[text()='Print and Export Settings...']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Print settings for')])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Print settings for')])[2]")).isDisplayed());
		System.out.println(log.driver.findElement(By.xpath("(//div[contains(.,'Print settings for')])[3]/span")).getText());
		test.info(log.driver.findElement(By.xpath("(//div[contains(.,'Print settings for')])[3]/span")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Use current print template']");
		Thread.sleep(1000);
		if(log.driver.findElement(By.xpath("//label[text()='Use current print template']/../..//input")).isSelected()){
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Use current print template']/ancestor::td[1]");
			log.driver.findElement(By.xpath("//label[text()='Use current print template']")).click();
			Thread.sleep(1000);
			Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Use current print template']/../..//input")).isSelected(),false);
			Thread.sleep(500);
			System.out.println("use current print template Checkbox got uncheked");
			test.info("use current print template Checkbox got uncheked");

		}else{

			waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Use current print template']/ancestor::td[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Use current print template']/../..//input")).isSelected(),false);
			System.out.println("use current print template Checkbox is unchecked by default");
			test.info("use current print template Checkbox is unchecked by default");

		}
		Thread.sleep(1000);
		
		//click on adjust button
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Adjust...']");
		assertTrue(log.driver.findElement(By.xpath("//button[text()='Adjust...']")).isEnabled());
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Adjust...']");
		log.driver.findElement(By.xpath("//button[text()='Adjust...']")).click();
	    Thread.sleep(1000);	
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Print Template']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Print Template']")).isDisplayed());

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//a[text()='Footer']");
		assertTrue(log.driver.findElement(By.xpath("//a[text()='Footer']")).isDisplayed());

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//a[text()='Footer']");
		log.driver.findElement(By.xpath("//a[text()='Footer']")).click();

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Show footer']/ancestor::td[1]");
		assertTrue(log.driver.findElement(By.xpath("//label[text()='Show footer']/ancestor::td[1]/input[1]")).isSelected());
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("(//span[text()='Right'])[2]/following::input[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Right'])[2]/following::input[1]");
		log.driver.findElement(By.xpath("(//span[text()='Right'])[2]/following::input[1]")).sendKeys("<date>");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Right'])[2]/following::input[1]");
		log.driver.findElement(By.xpath("(//span[text()='Right'])[2]/following::input[1]")).click();

		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Print settings for')])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Print settings for')])[2]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		
		CompareImage Cm= new CompareImage();
		
		Thread.sleep(2000);
		PDFtoIMGConversion.generateImageFromPDF("Mashup_PDF", "png", "Mashup_PDF");
		System.out.println("DOne");
		Thread.sleep(1000);
		Assert.assertTrue(Cm.processImage("Mashup_PDF_Actual", "Mashup_PDF"));
		System.out.println("comparison DONE");
		Thread.sleep(1000);
		
		File file = new File(System.getProperty("user.dir")+"/Screenshot/"+"Mashup_PDF"+".png");
		Thread.sleep(1000);
	    file.delete();
		
		Thread.sleep(1000);
	    File file1 = new File(System.getProperty("user.home")+"/Downloads/"+"Mashup_PDF.pdf");
	    Thread.sleep(1000);
	    file1.delete();
	    System.out.println("file got deleted");
	    
	    log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		
		if(log.driver.findElement(By.xpath("//span[contains(text(),'Save changes?')]")).isDisplayed())
		{
			log.driver.findElement(By.xpath("//input[@id='nobutton']")).click();
			Thread.sleep(2000);
		}
		else
		{
			System.out.println("Save changes not available");
		}
		Thread.sleep(1000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Cockpit_DataMashup_Functionality PriorityCeck'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Functionality PriorityCeck'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);
		
		a1.contextClick(log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Functionality PriorityCeck'])[1]"))).perform();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
	    
		log.driver.close();
		
		
		
	}
}
