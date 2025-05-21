package smokeCase;

import static org.testng.Assert.assertEquals;

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



public class TestCase_24485 extends TestUtils
{
	
    @Test	
	@Parameters("browser")
	public void Web_Testcase_to_verify_functionality_of_Analytical_Visualization_MiniChart_Properties(String browser) throws Exception
	{
 
	    test =extent.createTest("TestCase_24485 :Web_Testcase to verify functionality of <Analytical Visualization  MiniChart_Properties>");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
        
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TestCase_MiniChart_Bar_Edit']");
		log.driver.findElement(By.xpath("//span[text()='TestCase_MiniChart_Bar_Edit']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='TestCase_MiniChart_Bar_Edit'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='TestCase_MiniChart_Bar_Edit'])[2]")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img");
		List<WebElement> imgvalueoftable = log.driver.findElements(By.xpath("//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img"));
		for (WebElement ele : imgvalueoftable) 
		{
			
			Assert.assertEquals(ele.getAttribute("style"),"width: 94px; height: 17px;");
		}
		
		System.out.println("anyaltical visulization_minichart applied successfully to table");
		test.info("anyaltical visulization_minichart applied successfully to table");

		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10," (//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img)[1]");
		ui.rightClick(" (//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img)[1]");
		Thread.sleep(1000);
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
		for(int i=0;i< Context.size()-1;i++) 
		{
			assertEquals(Context.get(i).getText(), CV.get(i));
			System.out.println(Context.get(i).getText());

		}
		Context.get(6).click();
		Thread.sleep(1000);
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit...']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit...']");
		log.driver.findElement(By.xpath("//span[text()='Edit...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Minichart 1'])[4]");
		log.driver.findElement(By.xpath("(//span[text()='Minichart 1'])[4]")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings for the Minichart']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the Minichart']")).isDisplayed(),true);
		System.out.println("Settings for the Minichart====");
		
		WebElement Chrttype=log.driver.findElement(By.xpath("//div[text()='Type']/following::div[1]/span[1]/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		a1.click(Chrttype).sendKeys("Pie", Keys.ENTER).build().perform();
		Thread.sleep(1000);
		System.out.println(log.driver.findElement(By.xpath("//div[text()='Type']/following::div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Type']/following::div[1]/span[1]/span[1]/span[1]")).getText(),"Pie");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Type'])[1]");
		log.driver.findElement(By.xpath("(//div[text()='Type'])[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//p[text()='Type'])[1]/../p[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//p[text()='Type'])[1]/../p[2]")).isDisplayed(),true);
		System.out.println(log.driver.findElement(By.xpath("(//p[text()='Type'])[1]/../p[2]")).getText());
		test.info(log.driver.findElement(By.xpath("(//p[text()='Type'])[1]/../p[2]")).getText());
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Highlight largest value']/../../../td[3]/div");
		log.driver.findElement(By.xpath("//div[text()='Highlight largest value']/../../../td[3]/div")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Highlight largest value']/../../../td[3]/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Highlight largest value']/../../../td[3]/div/input")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Color of largest value']/following::td[4]/div/div/input");
		String Largestvalue=log.driver.findElement(By.xpath("//div[text()='Color of largest value']/following::td[4]/div/div/input")).getAttribute("value");
		Assert.assertEquals(Largestvalue,"(0;147;0)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Highlight smallest value']/../../../td[3]/div");
		log.driver.findElement(By.xpath("//div[text()='Highlight smallest value']/../../../td[3]/div")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Highlight smallest value']/../../../td[3]/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Highlight smallest value']/../../../td[3]/div/input")).isSelected(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Color of smallest value']/following::td[4]/div/div/input");
		String smallestvalue=log.driver.findElement(By.xpath("//div[text()='Color of smallest value']/following::td[4]/div/div/input")).getAttribute("value");
		Assert.assertEquals(smallestvalue,"(255;0;0)");
		
		if(log.driver.findElement(By.xpath("//span[text()='Pie Settings']/../../../td[1]/a/span")).getAttribute("class").contains("plus"))
		{
			log.driver.findElement(By.xpath("//span[text()='Pie Settings']/../../../td[1]/a/span")).click();
			System.out.println("Pie settings is not expanded");
			test.info("Pie settings is not expanded");
		}else{
			
			System.out.println("Pie settings is expanded");
			test.info("Pie settings is expanded");
			
		}
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Color 2'])[1]/following::td[5]/button");
		log.driver.findElement(By.xpath("(//div[text()='Color 2'])[1]/following::td[5]/button")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select color']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Select color']")).isDisplayed());
		System.out.println("select color window displayed");
		test.info("select color window displayed");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select color']/following::td[14]");
		log.driver.findElement(By.xpath("//span[text()='Select color']/following::td[14]")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, " //td[text()='Red:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath(" //td[text()='Red:']/..//input")).getAttribute("value"), "0");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Green:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Green:']/..//input")).getAttribute("value"), "0");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Blue:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Blue:']/..//input")).getAttribute("value"), "255");
		
		System.out.println("values present in red, green and blue fields are correct");
		test.info("values present in red, green and blue fields are correct");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Actual:']/../div[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Actual:']/../div[2]")).getCssValue("background-color"),"rgba(0, 0, 255, 1)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the Minichart']")).isDisplayed(),true);
		System.out.println("Settings for the Minichart====");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='Color 2'])[1]/following::td[3]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Color 2'])[1]/following::td[3]")).getCssValue("background-color"),"rgba(0, 0, 255, 1)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		ui.multiButton("//input[@value='Finish']");	
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img");
		List<WebElement> imgsvalueoftable = log.driver.findElements(By.xpath("//div[text()='Seperator']/ancestor::div[3]/div[4]/div/div/div[3]/img"));
		for (WebElement ele : imgsvalueoftable) {
			
			Assert.assertEquals(ele.getAttribute("style"),"width: 94px; height: 17px;");
		}
		
		System.out.println("anyaltical visulization_minichart displayed successfully in table");
		test.info("anyaltical visulization_minichart displayed successfully in table");
		
		
		Thread.sleep(2000);
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
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("TestCase_Minichart_Properties");
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TestCase_Minichart_Properties']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='TestCase_Minichart_Properties']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		
		
		Actions act=new Actions(log.driver);
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='TestCase_Minichart_Properties'])[1]"))).perform();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
	
		if(log.driver.findElement(By.xpath("(//span[text()='TestCase_MiniChart_Bar_Edit'])[1]")).isDisplayed())
		{
			act.contextClick(log.driver.findElement(By.xpath("(//span[text()='TestCase_MiniChart_Bar_Edit'])[1]"))).perform();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
			Thread.sleep(2000);
		}
		else
		{
			System.out.println("TestCase_MiniChart_Bar_Edit==not available");
		}
		Thread.sleep(200);
		if(log.driver.findElement(By.xpath("(//span[text()='TESTCASE_MINICHART_NEW'])[1]")).isDisplayed())
		{
			act.contextClick(log.driver.findElement(By.xpath("(//span[text()='TESTCASE_MINICHART_NEW'])[1]"))).perform();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
			Thread.sleep(2000);
		}
		else
		{
			System.out.println("TESTCASE_MINICHART_NEW==not available");
		}
		
		
		
		log.driver.close();
		
	}
}
