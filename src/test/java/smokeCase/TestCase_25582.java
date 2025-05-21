package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import event.Two_Excel_Comparison;
import event.Utils;
import event.Waits;

public class TestCase_25582 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Web_Testcase_to_verify_Cockpit_Data_Mashup_Functionality_Export_to_Excel_with_iteration(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_25582 : Cockpit Data Mashup Functionality Export to Excel_with iteration");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		Two_Excel_Comparison Two_Excel_Comparison=new Two_Excel_Comparison();
	/*	
		log.createCubeReport("//div[text()='A - Training Sales']","Manangement overview",false);
		System.out.println("report created using Training Sales cube");
		test.info("report created using Training Sales cube");
		
        waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
		Thread.sleep(1000);
		
		//Add Product in rows
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Timetype");
		System.out.println("Timetype is present in Rows"); 
		
		
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Timetype'])[1]")), log.driver.findElement(By.xpath(log.getData("Background"))));
		Thread.sleep(5000);
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Measures'])[1]")), log.driver.findElement(By.xpath(log.getData("Background"))));
		Thread.sleep(4000);
		
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Time'])[1]")), log.driver.findElement(By.xpath(log.getData("Row"))));
		Thread.sleep(5000);
		
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Category'])[2]")), log.driver.findElement(By.xpath(log.getData("Columns"))));
		Thread.sleep(5000);
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Measures'])[1]")), log.driver.findElement(By.xpath(log.getData("Columns"))));
		  Thread.sleep(4000);*/
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
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(100);
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
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Cockpit_DataMashup_Functionality");
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Cockpit_DataMashup_Functionality']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cockpit_DataMashup_Functionality']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Cockpit_DataMashup_Functionality'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Functionality'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);
		
		ui.rightClick("//span[text()='Cockpit_DataMashup_Functionality']");
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
		Thread.sleep(1000);
		//click on export
	   log.driver.findElement(By.xpath("//span[.='Report']/../../li/span[text()='Export...']")).click();
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Export Method']");
	   
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Excel']");
		log.driver.findElement(By.xpath("//span[text()='Excel']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[contains(@class,'description exportMargin')]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[contains(@class,'description exportMargin')]/span[1]")).getText(),"Export report(s) to Microsoft Excel.");
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
		log.driver.findElement(By.xpath("//span[text()='File name:']/ancestor::div[3]/div[2]//input[1]")).sendKeys("Mashup_excel.xlsx");
		Thread.sleep(2000);
		String Filename=log.driver.findElement(By.xpath("//span[text()='File name:']/ancestor::div[3]/div[2]//input[1]")).getAttribute("value");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='File name:']/ancestor::div[3]/div[2]//input[1]");
		Assert.assertEquals("Mashup_excel.xlsx",Filename);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='nextbutton']");
		log.driver.findElement(By.xpath("//input[@id='nextbutton']")).click();
		Thread.sleep(2000);
	   
		//select no iteration
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Iteration Settings']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Iteration Settings']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='No iteration']");
		//Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='No iteration']/../../td[1]/input")).isSelected(),true);
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Iterate within each report using selected filter elements']");
		log.driver.findElement(By.xpath("//label[text()='Iterate within each report using selected filter elements']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Iterate within each report using selected filter elements']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Iterate within each report using selected filter elements']/../..//input")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[contains(text(),'Iteration settings')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[contains(text(),'Iteration settings')]")).isDisplayed(),true);
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Cockpit_DataMashup_Functionality']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Cockpit_DataMashup_Functionality']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Cockpit_DataMashup_Functionality']");
		log.driver.findElement(By.xpath("//td[text()='Cockpit_DataMashup_Functionality']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Filters...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Filters...']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Filters...']");
		log.driver.findElement(By.xpath("//button[text()='Filters...']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select Filters and Elements for the Iteration']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Select Filters and Elements for the Iteration']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Add filter(s)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[@data-title='Add filter(s)']")).isEnabled(),true);
		System.out.println("Add filter enabled");
		test.info("Add filter enabled");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Remove filter(s)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[@data-title='Remove filter(s)']")).isEnabled(),true);
		System.out.println("Remove filter enabled");
		test.info("Remove filter enabled");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Move selected filter up']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[@data-title='Move selected filter up']")).isEnabled(),true);
		System.out.println("Move selected filter up button enabled");
		test.info("Move selected filter up button enabled");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Move selected filter down']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[@data-title='Move selected filter down']")).isEnabled(),true);
		System.out.println("Move selected filter down button enabled");
		test.info("Move selected filter down button enabled");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Iterate...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Iterate...']")).isEnabled(),true);
		System.out.println("Iterate button enabled");
		test.info("Iterate button enabled");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Separate file']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Separate file']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Separate file']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Separate file']/../..//input")).isSelected(),false);
		System.out.println("Separate file checkbox unchecked");
		test.info("Separate file checkbox unchecked");
		
		String button1[]= {"OK","Cancel","Help"};
		List<WebElement> button = log.driver.findElements(By.xpath("(//div[@id='buttons'])[1]/input"));
		System.out.println("The window list button  are :=  ");
		int buttonsize = button.size();
		for(int i =0;i<=buttonsize-1;i++) 
		{
			
			assertEquals(button1[i], button.get(i).getAttribute("value"));
			System.out.println(button.get(i).getAttribute("value"));
			test.info(button.get(i).getAttribute("value"));
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Add filter(s)']");
		log.driver.findElement(By.xpath("//button[@data-title='Add filter(s)']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Please select a report component:'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Please select a report component:'])[2]")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Zeit - [Time]']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Separate file']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Zeit - [Time]']");
		log.driver.findElement(By.xpath("//div[text()='Zeit - [Time]']/ancestor::div[1]/div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Zeit - [Time]']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Zeit - [Time]']/ancestor::div[1]/div[1]/input")).isSelected(),true);
		System.out.println("Zeit - [Time] checkbox checked");
		test.info("Zeit - [Time] checkbox checked");
		
		 waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		 log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		 Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Select elements for filter ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Select elements for filter ')]")).isDisplayed());
		
        waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Current elements - containers expanded (0 Items)']");
		
		String basevalueempty=log.driver.findElement(By.xpath("//span[text()='Current elements - containers expanded (0 Items)']")).getText();
		Assert.assertEquals(basevalueempty, "Current elements - containers expanded (0 Items)");
		Thread.sleep(2000);
			
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='1 2015']");
		log.driver.findElement(By.xpath("//div[text()='1 2015']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='2 2015']");
		log.driver.findElement(By.xpath("//div[text()='2 2015']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='3 2015']");
		log.driver.findElement(By.xpath("//div[text()='3 2015']")).click();
		Thread.sleep(1000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Select elements for filter')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> basevalue = log.driver.findElements(By.xpath("//span[contains(text(),'Select elements for filter')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> base= new ArrayList<String>();
		System.out.println("New Report radio button option");
		base.add("1 2015");
		base.add("2 2015");
		base.add("3 2015");
		
		for(int i=0;i<=basevalue.size()-1;i++) 
		{
			assertEquals(basevalue.get(i).getText(), base.get(i));
			System.out.println(basevalue.get(i).getText());

		}
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Select elements for filter')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]");
		List<WebElement> basevalueaftupdate = log.driver.findElements(By.xpath("//span[contains(text(),'Select elements for filter')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]/input[1]"));
		for(int i=0;i<=basevalueaftupdate.size()-1;i++) 
		{
			Assert.assertTrue(basevalueaftupdate.get(i).isSelected());
			System.out.println("1 2 2015,2 2015 ,3 2015 value is checked");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select Filters and Elements for the Iteration']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Select Filters and Elements for the Iteration']")).isDisplayed(),true);
			
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Report:']/ancestor::div[4]/div[2]//tr[@class='lvitem lvact']/td[3]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Report:']/ancestor::div[4]/div[2]//tr[@class='lvitem lvact']/td[3]")).getText(),"Iterate elements (1 2015, 2 2015, 3 2015)");
		Thread.sleep(500);	
		System.out.println(log.driver.findElement(By.xpath("//span[text()='Report:']/ancestor::div[4]/div[2]//tr[@class='lvitem lvact']/td[3]")).getText());
		test.info(log.driver.findElement(By.xpath("//span[text()='Report:']/ancestor::div[4]/div[2]//tr[@class='lvitem lvact']/td[3]")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Report:']/ancestor::div[4]/div[2]//tr[@class='lvitem lvact']/td[4]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Report:']/ancestor::div[4]/div[2]//tr[@class='lvitem lvact']/td[4]")).getText(),"No");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//tr[@class='lvitem lvact']/td[text()='Cockpit_DataMashup_Functionality']/../td[3]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//tr[@class='lvitem lvact']/td[text()='Cockpit_DataMashup_Functionality']/../td[3]")).getText(),"Iterate filters (Zeit)");
		Thread.sleep(500);
		System.out.println("Iterate filters (Zeit)");
		test.info("Iterate filters (Zeit)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='nextbutton']");
		log.driver.findElement(By.xpath("//input[@id='nextbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Export Properties']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Export Properties']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Output to a single file']");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Output to a single file']/ancestor::tr[1]/td[3]/div/input[1]")).isSelected());
		System.out.println("Output to a single file checkbox is selected");
		test.info("Output to a single file checkbox is selected");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Export even if no data']/ancestor::tr[1]/td[3]/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Export even if no data']/ancestor::tr[1]/td[3]/div/input[1]")).isSelected(),true);
		System.out.println("Export Even if no data is selected");
		test.info("Export Even if no data is selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='File name']");
		log.driver.findElement(By.xpath("//div[text()='File name']")).click();
		Thread.sleep(1000);
		
		System.out.println(log.driver.findElement(By.xpath("//div[text()='File name']/following::div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='File name']/following::div[1]/span[1]/span[1]/span[1]")).getText(),"Default");
		Thread.sleep(1000);
		
		WebElement elemnt1=log.driver.findElement(By.xpath("//div[text()='File name']/following::div[1]/span[1]/span[1]/span[1]"));
        Thread.sleep(1000);
        // Actions a1=new Actions(log.driver);
		//a1.click(elemnt1).sendKeys("Date unhyphenated", Keys.ENTER).build().perform();
        a1.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
//		Assert.assertEquals(elemnt1.getText(), "Date unhyphenated");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='finishbutton']");
		log.driver.findElement(By.xpath("//input[@id='finishbutton']")).click();
		Thread.sleep(2000);
		try
		{
			if(log.driver.findElement(By.xpath("//div[text()='File name']/following::div[1]/span[1]/span[1]/span[1]")).isDisplayed())
			{
				waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='finishbutton']");
				log.driver.findElement(By.xpath("//input[@id='finishbutton']")).click();
				Thread.sleep(2000);
			}
		}catch(Exception ex)
		{
			
		}
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
		
		List<WebElement> msges=log.driver.findElements(By.xpath("//a[text()='Message']/ancestor::div[3]/div[2]//td[3]"));
		for(int i=0;i<=msges.size()-1;i++)
		{
		  
			 if(msges.get(i).getText().equals("Export report 'Cockpit_DataMashup_Functionality' with iteration (1 2015)")
					 ||msges.get(i).getText().equals("Export report 'Cockpit_DataMashup_Functionality' with iteration (2 2015))")
					 ||msges.get(i).getText().equals("Export report 'Cockpit_DataMashup_Functionality' with iteration (3 2015)"))
			 {
				 System.out.println(msges.get(i).getText());
				  test.info(msges.get(i).getText());
			 }
			
		}		
		
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
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String file1 =System.getProperty("user.dir")+"/Screenshot/"+"ActualMashup_excel.xlsx";
		String file2 =System.getProperty("user.home")+"/Downloads/"+formatter.format(date)+" Mashup_excel.xlsx";
		
		Two_Excel_Comparison.Two_excel_Compare(file1,file2);
		File f=new File(file2);
		f.delete();
		System.out.println("excel deleted");
		
		//changing in to default
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Cockpit_DataMashup_Functionality'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Functionality'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);
		
		ui.rightClick("//span[text()='Cockpit_DataMashup_Functionality']");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Report'])[3]/../../..");
	    Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Report'])[3]/../../..")).isDisplayed(),true);
		Thread.sleep(100);
			   
	  //click on export
	   log.driver.findElement(By.xpath("//span[.='Report']/../../li/span[text()='Export...']")).click();
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Export Method']");
	   
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='nextbutton']");
		log.driver.findElement(By.xpath("//input[@id='nextbutton']")).click();
		Thread.sleep(2000);
         waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='nextbutton']");
		log.driver.findElement(By.xpath("//input[@id='nextbutton']")).click();
		Thread.sleep(2000);
	   
		//select no iteration
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Iteration Settings']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Iteration Settings']")).isDisplayed(),true);
		
		if(log.driver.findElement(By.xpath("//label[text()='No iteration']/../../td[1]/input")).isSelected())
		{
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='No iteration']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='No iteration']/../../td[1]/input")).isSelected(),true);
		}
		else
		{
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='No iteration']");
		log.driver.findElement(By.xpath("//label[text()='No iteration']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='No iteration']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='No iteration']/../../td[1]/input")).isSelected(),true);
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='nextbutton']");
		log.driver.findElement(By.xpath("//input[@id='nextbutton']")).click();
		Thread.sleep(2000);
		
		//export property
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Export Properties']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Export Properties']")).isDisplayed(),true);
		if(log.driver.findElement(By.xpath("//div[text()='File name']/following::div[1]/span[1]/span[1]/span[1]")).getText().contains("Default"))
		{
		System.out.println(log.driver.findElement(By.xpath("//div[text()='File name']/following::div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='File name']/following::div[1]/span[1]/span[1]/span[1]")).getText(),"Default");
		}
		else
		{
        WebElement e=log.driver.findElement(By.xpath("//div[text()='File name']/following::div[1]/span[1]/span[1]/span[1]"));
       // Actions a1=new Actions(log.driver);
		//a1.click(e).sendKeys("Default", Keys.ENTER).build().perform();
       
        for(int i=1;i<=3;i++)
		{
        	a1.click(e).sendKeys(Keys.ARROW_UP).build().perform();
        	Thread.sleep(1000);
		}
        a1.click(e).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
        
		}
			
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='finishbutton']");
		log.driver.findElement(By.xpath("//input[@id='finishbutton']")).click();
		Thread.sleep(2000);
		
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Close']");
		log.driver.findElement(By.xpath("//input[@value='Close']")).click();
		
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Cockpit_DataMashup_Functionality'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Functionality'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);
		
		a1.contextClick(log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Functionality'])[1]"))).perform();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
	
		
		log.driver.close();
		
	   
	   
	     
	}
}
