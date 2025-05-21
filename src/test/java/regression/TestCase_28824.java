package regression;

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

public class TestCase_28824 extends TestUtils
{
	@Test	
	@Parameters("browser")

	public void TestCase_for_Cockpit_Navigator_functionality_Report_from_a_Template(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_28824: Cockpit Navigator functionality -  Report from a Template");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		java.util.List<WebElement> menu=log.driver.findElements(By.xpath("//ul[@class='w20_toolbar_mainlist']/li[@id]"));
		ArrayList<String> menulist = new ArrayList();
		menulist.add("New");
		menulist.add("Open");
		menulist.add("Save");
		menulist.add("Filter");
		menulist.add("Refresh");
		menulist.add("Presentation");
		menulist.add("Print");
		menulist.add("Layout");
		menulist.add("Export");
		for (int  i =0;i<=menu.size()-1;i++) 
		{
			assertEquals(menulist.get(i),menu.get(i).getText());
		}
		menu.get(0).click();
		List<WebElement>reports =log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
		ArrayList<String> reportList  = new ArrayList();
		reportList.add("Standard Report");
		reportList.add("ABC Classification");
		reportList.add("Empty Report");
		reportList.add("Relational Report");
		reportList.add("MDX Report");
		reportList.add("Entry Report");
		reportList.add("Report from a Template");
		reportList.add("Local Export");
		for (int i =0;i<=reports.size()-1;i++) 
		{
			assertEquals(reportList.get(i), reports.get(i).getText());
		}
		Thread.sleep(500);
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Standard Report']/../../../../../div[@class='reportLitile cursor k-state-selected' and @aria-selected='true']")).isDisplayed());
		Thread.sleep(500);
		
		log.driver.findElement(By.xpath("//span[text()='Report from a Template']")).click();
		Thread.sleep(1000);
		List<WebElement> buttons = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		ArrayList<String> buttonList = new  ArrayList();
		buttonList.add("Next >>");
		buttonList.add("Cancel");
		buttonList.add("Help");
		for (int  i =0;i<=buttons.size()-1;i++) 
		{
			
			assertEquals(buttons.get(i).getAttribute("value"), buttonList.get(i));
		}
		buttons.get(0).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@id='finishbutton']");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select Report Template']")).isDisplayed());
		Thread.sleep(500);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Please select a template, which will be the base for the new Report.']/following::div[3]/div/div[2]");
		List<WebElement> ReportTemplate= log.driver.findElements(By.xpath("//span[.='Please select a template, which will be the base for the new Report.']/following::div[3]/div/div[2]"));
		ArrayList<String> ReportTemplatevalue= new ArrayList<String>();
		System.out.println("Report Template Radio button options are=====");
		ReportTemplatevalue.add("Templates");
		ReportTemplatevalue.add("Pantara report without dataview");
		ReportTemplatevalue.add("Manufacturer");
		ReportTemplatevalue.add("Employee");
		ReportTemplatevalue.add(" ");
		ArrayList<String> ReportTemplatevalue1= new ArrayList<String>();
         Thread.sleep(2000);
		for(int i=0;i<=ReportTemplate.size()-1;i++) 
		{
			String check = ReportTemplate.get(i).getText();
			
			//assertEquals(check,ReportTemplatevalue.get(i));
			ReportTemplatevalue1.add(check);
			System.out.println("options present in report template is : " +ReportTemplate.get(i).getText());
			test.info("options present in report template window is : " +ReportTemplate.get(i).getText());
			Thread.sleep(2000);
		}

		
		for(int j=0;j<=ReportTemplate.size()-1;j++) 
		{
			ReportTemplatevalue.get(j).equals(ReportTemplatevalue1.get(j));
		}
		
		
		test.info("report template radio button option is diaplayed correctly ");
		System.out.println("report template radio button option is diaplayed correctly");
		
		//ReportTemplate.get(2).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Manufacturer']/ancestor::div[1]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Manufacturer']/ancestor::div[1]/div[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.id("nextbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@id='finishbutton']");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'next')]")).isDisplayed());
		Thread.sleep(500);
		assertEquals("Don't show this page again", log.driver.findElement(By.xpath("//label[@class='k-checkbox-label']")).getText());

		List<WebElement> buttons3 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		ArrayList<String> buttonList3= new  ArrayList();
		buttonList3.add("<< Back");
		buttonList3.add("Next >>");
		buttonList3.add("Finish");
		buttonList3.add("Cancel");
		buttonList3.add("Help");
		for (int  i =0;i<=buttons3.size()-1;i++) 
		{
			
			assertEquals(buttons3.get(i).getAttribute("value"), buttonList3.get(i));
		}
		log.driver.findElement(By.id("nextbutton")).click();
		Thread.sleep(2000);
		waits.waituUnitil_Element_Clickable(20,"//input[@id='finishbutton']");
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
		Assert.assertEquals(log.driver.findElement(By.xpath("//input[@class='k-textbox w20_webedit_left']")).getAttribute("value"),"New Report from Manufacturer");
		
		List<WebElement> buttons4 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		ArrayList<String> buttonList4= new  ArrayList();
		buttonList4.add("<< Back");
		buttonList4.add("Finish");
		buttonList4.add("Cancel");
		buttonList4.add("Help");
		for (int  i =0;i<=buttons4.size()-1;i++) 
		{
			
			assertEquals(buttons4.get(i).getAttribute("value"), buttonList4.get(i));
		}
		Actions act  = new Actions(log.driver);
		act.sendKeys(Keys.TAB).perform();
		log.driver.findElement(By.id("finishbutton")).click();
		waits.waituUnitil_Element_Clickable(30,"//li[@class='k-item k-state-default k-first k-last k-tab-on-top k-state-active']/span[@class='k-link']");
		Thread.sleep(5000);
		assertEquals("New Report from Manufacturer", log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).getText());
		Thread.sleep(2000);
		
		//save the report
		 log.driver.findElement(By.xpath("//span[text()='Save']/following::span[1]")).click();
		 Thread.sleep(2000);
		 //Click Down and do Save As:====================
		 log.driver.findElement(By.xpath("//span[text()='Save As']")).click();
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Save Report as window is displaying now.");
		
	/*	 //Change Name:===========
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		 waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Name'])[1]/following::input[1]");
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("New Report from Manufacturer");
		 Thread.sleep(500);*/
		
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Report from Manufacturer']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='New Report from Manufacturer']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		Actions action=new Actions(log.driver);
		action.contextClick(log.driver.findElement(By.xpath("(//span[text()='New Report from Manufacturer'])[1]"))).perform();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		log.driver.close();
		
		
		
		
		
	}
}
