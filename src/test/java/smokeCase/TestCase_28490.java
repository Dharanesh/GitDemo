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

public class TestCase_28490 extends TestUtils
{

	@Test	
	@Parameters("browser")
	public void 
	Testcase_Splashing_Verfying_Equal_Distribution(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_28490 : Splashing - Verfying Equal distribution");
	    Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[text()='HR']","TestCase_28490_Splashing",false);
		System.out.println("report created using HR cube");
		test.info("report created using HR cube");
		
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("DataviewDesigner"));
		log.driver.findElement(By.xpath(log.getData("DataviewDesigner"))).click();
		Thread.sleep(2000);
		
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
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
		Thread.sleep(2000);
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
		Thread.sleep(3000);
		
		int row_count = log.driver.findElements(By.xpath("//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div/div[2]")).size()-1;
		System.out.println("total no of rows:" +row_count);
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div/div[2])[1]");
		log.driver.findElement(By.xpath("(//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div/div[2])[1]")).click();
		Thread.sleep(3000);
		/*ui.rightClick("(//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div/div[2])[1]");
		Thread.sleep(2000);*/

        Actions act = new Actions(log.driver);
        act.contextClick(log.driver.findElement(By.xpath("(//div[@id='1/0'])[1]"))).perform();
        Thread.sleep(2000);
		
		String ActAllFnctnCellVal=log.driver.findElement(By.xpath("(//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div/div[2])[1]")).getText();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Single Data Cell']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed(),true);
		Thread.sleep(1000);
		
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
			Assert.assertEquals(ContextMenu.get(i).getText(), CV.get(i));
			System.out.println(ContextMenu.get(i).getText());
		}
		
		ContextMenu.get(5).click();
		Thread.sleep(1000);
		System.out.println("Splashing option is present.");
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[.='Splashing']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[.='Splashing']")).isDisplayed());
		Thread.sleep(1000);

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Delete values']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Delete values']")).isDisplayed());
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Delete values']/ancestor::td");

		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Delete values']/ancestor::td/input[1]")).isSelected());
		System.out.println("Delete radio button is selected by default");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Server side splashing']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Server side splashing']")).isDisplayed());
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
		Thread.sleep(1000);

		String stat=log.driver.findElement(By.xpath("(//span[text()='Server side splashing'])[2]/ancestor::div[4]/div[2]/div[1]/img")).getAttribute("src");
		Assert.assertTrue(stat.contains("lamp_green"),"Color Of the button is not Green");
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Equal distribution']/../..//td");
		Thread.sleep(2000);
		
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Equal distribution']/../..//td")).isDisplayed());
		System.out.println("Equal distribution radio button displayed");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Equal distribution']");
		log.driver.findElement(By.xpath("//label[text()='Equal distribution']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Equal distribution']/../..//td");
		boolean stat1=log.driver.findElement(By.xpath("//label[text()='Equal distribution']/../..//input")).isSelected();
		if(stat1) 
		{
			System.out.println("Equal distribution radio button is selected");	
		}
		else
		{

			//waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Equal distribution']/../..//td");
			//log.driver.findElement(By.xpath("//label[text()='Equal distribution']/../..//td")).click();
			//Thread.sleep(200);
		}
		

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Splash absolute value']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Splash absolute value']")).isDisplayed());
		Thread.sleep(1000);
		
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Splash absolute value']/following::div[5]/div/div/input[1]")).isEnabled());
		System.out.println("Splash absolute value textbox is enabled");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Replace value']/../..//td");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Replace value']/../..//input")).isSelected());
		System.out.println("replace value radio button is selected");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Splash absolute value']/following::div[5]/div/div/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Splash absolute value']/following::div[5]/div/div/input[1]")).clear();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Splash absolute value']/following::div[5]/div/div/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Splash absolute value']/following::div[5]/div/div/input[1]")).sendKeys("900.00");
		Thread.sleep(1000);

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Splash absolute value']/following::div[5]/div/div/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Splash absolute value']/following::div[5]/div/div/input[1]")).click();
		Thread.sleep(2000);
		String val_expected=log.driver.findElement(By.xpath("//span[text()='Splash absolute value']/following::div[5]/div/div/input[1]")).getAttribute("value");

        System.out.println(val_expected);
        Thread.sleep(1000);
        
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Value based distribution']/../..//td");
		log.driver.findElement(By.xpath("//label[text()='Value based distribution']/../..//td")).click();
		Thread.sleep(2000);

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Equal distribution']/../..//td");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Equal distribution']/../..//td")).isDisplayed());
		System.out.println("Equal distribution radio button displayed");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Equal distribution']");
		log.driver.findElement(By.xpath("//label[text()='Equal distribution']")).click();
		Thread.sleep(2000);

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Splashing']/following::textarea[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Splashing']/following::textarea[1]")).getText().equals("Splash value '900' equally."));	
		System.out.println("Splashing message displayed correctly....  " +log.driver.findElement(By.xpath("//span[text()='Splashing']/following::textarea[1]")).getText());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Splash']");
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//input[@value='Splash']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div[1]/div[2]");
		String displayed = log.driver.findElement(By.xpath("//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div[1]/div[2]")).getText();
		System.out.println("value displayed in table after splashing " +displayed);
		
		Assert.assertEquals(displayed, val_expected);
		System.out.println("replace value worked fine for first element");
		//verifying N elements 
		String Finalval_table_val=displayed.replaceAll("[€,()]","");
		System.out.println("value entered after replacing aplha values: "+Finalval_table_val);
		Float table_Value= Float.parseFloat(Finalval_table_val);
		System.out.println("parsed float value is: " +table_Value);
		
		Float cal2 = table_Value/row_count;
		System.out.println("calculated val " +cal2);
		Thread.sleep(1000);
		String Comp_val = cal2.toString();
        List<WebElement> Equally_distributed = log.driver.findElements(By.xpath("//div[text()='Variable Salary']/ancestor::div[3]/div[4]/div[1]/div/div[2]"));
		
		for (int i = 1; i < Equally_distributed.size(); i++) 
		{
			Thread.sleep(500);
			System.out.println(i+" element value "+ Equally_distributed.get(i).getText());
			Assert.assertEquals(Equally_distributed.get(i).getText().contains(Comp_val.substring(0,4)), true);
		}
		System.out.println("Equal distribution statergy is working fine");		
		log.driver.close();
				
				
				
			
		

	}
}
