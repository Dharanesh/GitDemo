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

public class TestCase_29033 extends TestUtils
{
	
    @Test	
	@Parameters("browser")
	public void Testcase_Splashing_Verifying_Distribution_of_base_Values(String browser) throws Exception
	{
 
	    test =extent.createTest("TestCase_29033 : Splashing_Verifying_Distribution_of_base_Values");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);

		
		
		log.createCubeReport("//div[text()='HR']","TestCase_29033_Splashing",false);
		System.out.println("report created using HR cube");
		test.info("report created using HR cube");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("DataviewDesigner"));
		log.driver.findElement(By.xpath(log.getData("DataviewDesigner"))).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("DataviewDesigner"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("DataviewDesigner"))).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Function");
		System.out.println("Function is present in Rows");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(),"Measures");
		Thread.sleep(2000);		
		System.out.println("Measures is present in columns");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Measures']");
		log.driver.findElement(By.xpath("//span[text()='Measures']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		
	
		//Add all measure var  	HR_Values , HR_HDC
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		System.out.println(log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]")).getText());
		assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]")).getText(), "HR_Values");
		System.out.println("HR_Values is selected in drop down");
		
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
		Thread.sleep(1000);
		
		a1.click(e1).sendKeys(Keys.ARROW_UP).build().perform();
		a1.click(e1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		System.out.println(log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]")).getText());
		assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]")).getText(), "HR_HDC");
		System.out.println("HR_HDC is selected in drop down");
		
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		//=============================================================
		//1
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='E_Type'])[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//span[text()='E_Type'])[1]")).isDisplayed());
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='E_Type'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='E_Type'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='A']");
		log.driver.findElement(By.xpath("//span[text()='A']")).click();
		Thread.sleep(2000);
		
		System.out.println("E_Type is selected as A");
		
		//2
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Employee'])[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//span[text()='Employee'])[1]")).isDisplayed());
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Employee'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Employee'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='99110']/preceding::span[1]");
		log.driver.findElement(By.xpath("//span[text()='99110']/preceding::span[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='9912']");
		log.driver.findElement(By.xpath("//span[text()='9912']")).click();
		Thread.sleep(2000);
	
		System.out.println("Employee selected 9912");
		
		//3
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Time'])[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//span[text()='Time'])[1]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Time'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Time'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='2015']/preceding::span[1]");
		log.driver.findElement(By.xpath("//span[text()='2015']/preceding::span[1]")).click();
		Thread.sleep(2000);
				
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Q1 2015']/preceding::span[1]");
		log.driver.findElement(By.xpath("//span[text()='Q1 2015']/preceding::span[1]")).click();
		Thread.sleep(2000);			
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='1 2015']");
		log.driver.findElement(By.xpath("//span[text()='1 2015']")).click();
		Thread.sleep(2000);	
		System.out.println("Time selected is 1 2015");
		
		//=============================================================
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Base Salary']/ancestor::div[4]/div/div[4]/div/div/div[1])[1]");
		log.driver.findElement(By.xpath("(//div[text()='Base Salary']/ancestor::div[4]/div/div[4]/div/div/div[1])[1]")).click();
		Thread.sleep(2000);	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Base Salary']/ancestor::div[4]/div/div[4]/div/div/div[1])[1]");
		ui.rightClick("(//div[text()='Base Salary']/ancestor::div[4]/div/div[4]/div/div/div[1])[1]");
		Thread.sleep(2000);	
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[.='Splashing...']")).isDisplayed())
			{
				System.out.println("Splashing Available");
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
		
		List<WebElement> ContextMenu = log.driver.findElements(By.xpath("//span[text()='Single Data Cell']/../../li/span[1]"));
		ArrayList<String> CV= new ArrayList<String>();
		System.out.println("Single Data cell context menu options are:");
		test.info("Single Data cell context menu options are:");
		
		CV.add("Single Data Cell");
		CV.add("Start Write Mode");
		CV.add("Copy");
		CV.add("Copy (value formatted)");
		CV.add("Paste");
		CV.add("Splashing...");
		CV.add("Planning");
		CV.add("Define Subview...");
		CV.add("Analytical Visualizations");
		CV.add("Edit Table...");
		CV.add("Table Properties...");
		for(int i=1;i<ContextMenu.size()-1;i++) 
		{
			assertEquals(ContextMenu.get(i).getText(), CV.get(i));
			System.out.println(ContextMenu.get(i).getText());
		}
		
		ContextMenu.get(5).click();
		Thread.sleep(1000);
		System.out.println("Splashing option is present.");
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[.='Splashing']");
		assertTrue(log.driver.findElement(By.xpath("//span[.='Splashing']")).isDisplayed());
		Thread.sleep(1000);
				
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Delete values']");
		assertTrue(log.driver.findElement(By.xpath("//label[text()='Delete values']")).isDisplayed());
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Delete values']/ancestor::td");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Delete values']/ancestor::td/input[1]")).isSelected());
		System.out.println("Delete radio button is selected by default");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Server side splashing']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Server side splashing']")).isDisplayed());
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Activated']/ancestor::td[1]");
		if(log.driver.findElement(By.xpath("//label[text()='Activated']/ancestor::td[1]/input[1]")).isSelected())
		{
			
			System.out.println("Activated checkbox is selected by default");
		}
		else
		{
			System.out.println("Activated checkbox is not selected by default");
		}
		
		String stat=log.driver.findElement(By.xpath("(//span[text()='Server side splashing'])[2]/ancestor::div[4]/div[2]/div[1]/img")).getAttribute("src");
		assertTrue(stat.contains("lamp_green"),"Color Of the button is not Green");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Distribution of base values']/../..");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Distribution of base values']/../..//td")).isDisplayed());
		System.out.println("distirbution of base value radio button displayed");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Distribution of base values']/../..//td");
		log.driver.findElement(By.xpath("//label[text()='Distribution of base values']/../..//td")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Distribution of base values']/../..//td");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Distribution of base values']/../..//input")).isSelected());
		System.out.println("distirbution of base value radio button radio button is selected");
		//========================
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Replace value']/../..//td");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Replace value']/../..//td/input")).isSelected());
		System.out.println("replace value radio button is selected");
		
	
		//========================
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Fixed value']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Fixed value']/following::div[5]/div/div/input[1]")).isEnabled());
		System.out.println("Fixed value textbox is enabled");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Fixed value']/following::div[5]/div/div/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Fixed value']/following::div[5]/div/div/input[1]")).clear();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Fixed value']/following::div[5]/div/div/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Fixed value']/following::div[5]/div/div/input[1]")).sendKeys("10.00");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Fixed value']/following::div[5]/div/div/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Fixed value']/following::div[5]/div/div/input[1]")).click();
		Thread.sleep(500);
		String val_expected=log.driver.findElement(By.xpath("//span[text()='Fixed value']/following::div[5]/div/div/input[1]")).getAttribute("value");
		System.out.println(val_expected);
		   	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Value based distribution']/../..//td");
		log.driver.findElement(By.xpath("//label[text()='Value based distribution']/../..//td")).click();
		Thread.sleep(200);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Distribution of base values']/../..//td");
		log.driver.findElement(By.xpath("//label[text()='Distribution of base values']/../..//td")).click();
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Splashing']/following::textarea[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Splashing']/following::textarea[1]")).getText().equals("Splash the fixed value '10' on to all base elements."));	
		System.out.println("Splashing message displayed correctly....  " +log.driver.findElement(By.xpath("//span[text()='Splashing']/following::textarea[1]")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Splash']");
		log.driver.findElement(By.xpath("//input[@value='Splash']")).click();
		Thread.sleep(1000);
		
	
		String displayed = log.driver.findElement(By.xpath("//div[text()='IT']/ancestor::div[3]/div[4]/div/div[2]/div[1]")).getText();
		System.out.println("value displayed in table after splashing  " +displayed);
		Assert.assertEquals(displayed,val_expected);
		System.out.println("Value displayed in table is :" +displayed +"Value expected was :" +val_expected);
		
		System.out.println("Distribution base value is working fine");
		
		log.driver.close();
				
		
		
	}
}
