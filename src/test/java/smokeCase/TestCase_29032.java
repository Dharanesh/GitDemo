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





public class TestCase_29032 extends TestUtils
{
	
	
	@Test	
	@Parameters("browser")
	public void Testcase_Splashing_Verifying_Distribute_relative_to_a_reference_value(String browser) throws Exception
	{
 
	    test =extent.createTest("TestCase_29032 : Splashing - Verifying Distribute relative to a reference value");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		
		
		log.createCubeReport("//div[text()='HR']","TestCase_29032_Splashing",false);
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Time'])[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//span[text()='Time'])[1]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Time'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Time'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='2014']");
		log.driver.findElement(By.xpath("//span[text()='2014']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='E_Type'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='E_Type'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='A']");
		log.driver.findElement(By.xpath("//span[text()='A']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Employee'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Employee'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='99110']");
		log.driver.findElement(By.xpath("//span[text()='99110']")).click();
		Thread.sleep(3000);
		/*String SelectedTime=log.driver.findElement(By.xpath("")).getAttribute("value");
		Assert.assertTrue(SelectedTime.equals("2014"));
		Thread.sleep(1000);	*/
	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Base Salary']/ancestor::div[3]/div[4]/div[1]/div/div[1])[9]");
		log.driver.findElement(By.xpath("(//div[text()='Base Salary']/ancestor::div[3]/div[4]/div[1]/div/div[1])[9]")).click();
		Thread.sleep(3000);

		ui.rightClick("(//div[text()='Base Salary']/ancestor::div[3]/div[4]/div[1]/div/div[1])[9]");
		Thread.sleep(3000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed())
			{
				System.out.println("Splashing Available");
			}
		}
		catch(Exception e)
		{
			 Actions act = new Actions(log.driver);
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='0/8'])[1]"))).perform();
		     Thread.sleep(2000);
		     System.out.println("Splashing clicked");
		}
		
		String ActSalescolmnVal=log.driver.findElement(By.xpath("(//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div/div[1])[9]")).getText();
		String ActAllFnctncolmnVal=log.driver.findElement(By.xpath("(//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div/div[1])[1]")).getText();
		
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
		for(int i=1;i< ContextMenu.size()-1;i++) 
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
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Delete values']/ancestor::td");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Delete values']/ancestor::td/input[1]")).isSelected());
		System.out.println("Delete radio button is selected by default");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Server side splashing']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Server side splashing']")).isDisplayed());
		Thread.sleep(500);
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
		
		//Validate selected Time filter  
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Reference elements']/following::table[1]/tbody/tr/td[text()='Time']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Reference elements']/following::table[1]/tbody/tr/td[text()='Time']")).isDisplayed());
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Reference elements']/following::table[1]/tbody/tr/td[text()='Time']/../td[3]");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Reference elements']/following::table[1]/tbody/tr/td[text()='Time']/../td[3]")).isDisplayed());
		Thread.sleep(500);
		
		String FilterValue=log.driver.findElement(By.xpath("//span[text()='Reference elements']/following::table[1]/tbody/tr/td[text()='Time']/../td[3]")).getText();
		assertEquals(FilterValue,"2014","Filter Selected Value Not Matching");
		
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Distribute relative to a reference value']/../..//td");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Distribute relative to a reference value']/../..//td")).isDisplayed());
		System.out.println("Distribute relative to a reference value radio button displayed");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Distribute relative to a reference value']/../..//td");
		log.driver.findElement(By.xpath("//label[text()='Distribute relative to a reference value']/../..//td")).click();
		Thread.sleep(200);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Distribute relative to a reference value']/../..//td");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Distribute relative to a reference value']/../..//input")).isSelected());
		System.out.println("Distribute relative to a reference value radio button radio button is selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Splash absolute value']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Splash absolute value']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Replace value']/../..//td");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Replace value']/../..//input")).isSelected());
		System.out.println("replace value radio button is selected");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Increase value']/../..//td");
		log.driver.findElement(By.xpath("//label[text()='Increase value']/../..//td")).click();
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Increase value']/../..//input")).isSelected());
		System.out.println("Increase value radio button is selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Change value']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Change value']")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Change value']/ancestor::div[4]/div[2]/div[1]/div[1]//span[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Change value']/ancestor::div[4]/div[2]/div[1]/div[1]//span[1]")).isDisplayed());
		
		
		
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Change value']/following::div[5]/div/div/input[1]")).isEnabled());
		System.out.println("Splash absolute value textbox is enabled");
		

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Change value']/following::div[5]/div/div/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Change value']/following::div[5]/div/div/input[1]")).clear();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Change value']/following::div[5]/div/div/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Change value']/following::div[5]/div/div/input[1]")).sendKeys("10.00");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Change value']/following::div[5]/div/div/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Change value']/following::div[5]/div/div/input[1]")).click();
		Thread.sleep(500);
		String val_expected=log.driver.findElement(By.xpath("//span[text()='Change value']/following::div[5]/div/div/input[1]")).getAttribute("value");
		System.out.println(val_expected);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Value based distribution']/../..//td");
		log.driver.findElement(By.xpath("//label[text()='Value based distribution']/../..//td")).click();
		Thread.sleep(200);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Distribute relative to a reference value']/../..//td");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Distribute relative to a reference value']/../..//td")).isDisplayed());
		System.out.println("Distribute relative to a reference value radio button displayed");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Distribute relative to a reference value']/../..//td");
		log.driver.findElement(By.xpath("//label[text()='Distribute relative to a reference value']/../..//td")).click();
		Thread.sleep(200);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Splashing']/following::textarea[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Splashing']/following::textarea[1]")).getText(),"Splash value '+10' relative to the existing value '0'.");	
		System.out.println("Splashing message displayed correctly....  " +log.driver.findElement(By.xpath("//span[text()='Splashing']/following::textarea[1]")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Splash']");
		log.driver.findElement(By.xpath("//input[@value='Splash']")).click();
		Thread.sleep(1000);
		
		
		
		String Sales = log.driver.findElement(By.xpath("(//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div/div[1])[9]")).getText();
		
		System.out.println("value displayed in table after splashing" +Sales);
		Assert.assertEquals(Sales,"10.00");
		System.out.println("Value displayed in table is :" +Sales +"Value expected was :" +"10.00");
		
		int val1 = (int) Math.round(Float.valueOf(Sales));
		System.out.println(val1);
		int val2=(int) Math.round(Float.valueOf(ActSalescolmnVal));
		System.out.println(val2);
		
        int Diff=val1-val2;
		System.out.println(Diff);
		Assert.assertEquals(Diff,(int) Math.round(Float.valueOf(val_expected)),"Not Matching with the Incremented values");
		
		String AllFunction = log.driver.findElement(By.xpath("(//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div/div[1])[1]")).getText();
		System.out.println("value displayed in table after splashing" +AllFunction);
		Assert.assertEquals(AllFunction,"10.00");
		System.out.println("Value displayed in table is :" +AllFunction +"Value expected was :" +"10.00");
		
		int valfnctn1=(int) Math.round(Float.valueOf(AllFunction));
		int valfntcn2=(int) Math.round(Float.valueOf(ActAllFnctncolmnVal));
		
        int Diff1=valfnctn1-valfntcn2;
		System.out.println(Diff1);
		Assert.assertEquals(Diff1,(int) Math.round(Float.valueOf(val_expected)),"Not Matching with the Incremented values");
		
		System.out.println(" Distribute relative to a reference value is working fine");
		
		log.driver.close();
		
		
		
		
		
		
		
	}
}
