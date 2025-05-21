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

public class TestCase_25574 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Web_Testcase_to_verify_Cockpit_Data_Mashup_Error_Message(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_25574 : Cockpit Data Mashup Error Message");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Sales by country']");
		log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
        Thread.sleep(1000);
        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Sales by country'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Customer");
		System.out.println("Customer is present in Rows");
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(),"Time");
		Thread.sleep(2000);
		System.out.println("Time is present in columns");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Columns_Value"));
		log.driver.findElement(By.xpath(log.getData("Columns_Value"))).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
        
		
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e1.getText(), "Time");
		System.out.println("Elements groups displayed correctly");
		test.info("Elements groups displayed correctly");

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
		Assert.assertEquals(e4.getText(), "Desc_EN");
		System.out.println("Value present in Display displayed correctly");
		test.info("Value present in Display displayed correctly");

		List<WebElement> AB = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for Rows')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB) {
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getText() + "    is displayed and Enabled");
			test.info(btn.getText() + "    is displayed and Enabled");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Base elements with containers (0 Items)']");
		
		String basevalueempty=log.driver.findElement(By.xpath("//span[text()='Base elements with containers (0 Items)']")).getText();
		Assert.assertEquals(basevalueempty, "Base elements with containers (0 Items)");
		Thread.sleep(2000);
		
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

		for(int i=0;i<=basevalue.size()-1;i++) 
		{
			assertEquals(basevalue.get(i).getText(), base.get(i));
			System.out.println(basevalue.get(i).getText());

		}
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]");
		List<WebElement> basevalueaftupdate = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]/input[1]"));
		for(int i=0;i<=basevalueaftupdate.size()-1;i++) 
		{
			Assert.assertTrue(basevalueaftupdate.get(i).isSelected());
			System.out.println("2014 and 2015 value is checked");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		//a1.click(elemnt).sendKeys("Calculated elements", Keys.ENTER).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ENTER).build().perform();
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
        System.out.println(count);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(4000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div");
		List<WebElement> TableColumnHdr = log.driver.findElements(By.xpath("(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div"));
	
		int countq=TableColumnHdr.size()-1;
		assertEquals(count,countq);
		System.out.println("mashup alias name applied successfully in column");
		test.info("mashup alias name applied successfully in column");
		
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3]");
		List<WebElement> mash_col_val = log.driver.findElements(By.xpath("//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3]"));
		for (WebElement webElement : mash_col_val)
		{
			assertTrue(webElement.getText().isEmpty());
		}
		System.out.println("mashup column is empty");
		test.info("mashup column is empty");
		Thread.sleep(1000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
		log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
		ui.rightClick("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
		
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
		log.driver.findElement(By.xpath("//span[text()='Cell Value']/ancestor::div[2]/div[2]/div[1]//input[1]")).sendKeys("=E5");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
		String errorMsg=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]")).getText();
		System.out.println(errorMsg);
		Thread.sleep(1000);
		Assert.assertEquals("#ERR: formula error: \"Index range error in element reference\"",errorMsg);
		
		//cell error
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[3]");
		log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[3]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[3]");
		ui.rightClick("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[3]");	
		
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
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='2/2'])[1]"))).perform();
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
		log.driver.findElement(By.xpath("//span[text()='Cell Value']/ancestor::div[2]/div[2]/div[1]//input[1]")).sendKeys("=c(4,3)");
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[3]");
		String Cellvalue=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[3]")).getText();
		System.out.println(Cellvalue);
		Thread.sleep(3000);
		Assert.assertEquals("#ERR: formula error: \"Function error 'c': Column index out of range\"",Cellvalue);
		
		Thread.sleep(1000);
		//getcellvalue with cube error
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/following::div/div/div[3])[6]");
		log.driver.findElement(By.xpath("(//div[text()='MASHUP']/following::div/div/div[3])[6]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/following::div/div/div[3])[6]");
		ui.rightClick("(//div[text()='MASHUP']/following::div/div/div[3])[6]");	
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
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='2/5'])[1]"))).perform();
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
		log.driver.findElement(By.xpath("//span[text()='Cell Value']/ancestor::div[2]/div[2]/div[1]//input[1]")).sendKeys("=getcellvalue(2,3,\"HR\")");
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[6]");
		String salesvalue=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[6]")).getText();
		System.out.println(salesvalue);
		Thread.sleep(2000);
		Assert.assertEquals("#ERR: formula error: \"Referenced dataview 'HR' not found\"",salesvalue);
		
		//working function
		//getcellvalue with cube error
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[5]");
		log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[5]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[5]");
		ui.rightClick("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[5]");
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
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='2/4'])[1]"))).perform();
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[5]");
		String Normalvalue=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[5]")).getText();
		System.out.println(Normalvalue);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[1])[5]");
		String Normalvalue1=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[1])[5]")).getText();
		System.out.println(Normalvalue1);
		
		Thread.sleep(1000);
	    Assert.assertEquals(Normalvalue,Normalvalue1);
		
		
		//getcellvalue error
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]")).click();
		Thread.sleep(2000);
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		ui.rightClick("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");	
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
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='2/1'])[1]"))).perform();
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
		log.driver.findElement(By.xpath("//span[text()='Cell Value']/ancestor::div[2]/div[2]/div[1]//input[1]")).sendKeys("=getcellvalue(3,13)");
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		String AusCellvalue=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]")).getText();
		System.out.println(AusCellvalue);
		Thread.sleep(1000);
		Assert.assertEquals("#ERR: formula error: \"Function error 'getcellvalue': Row index out of range\"",AusCellvalue);
		//save the report
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
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Cockpit_DataMashup_Errormsg_ check");
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Cockpit_DataMashup_Errormsg_ check']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cockpit_DataMashup_Errormsg_ check']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		
		//opn the report
		log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Errormsg_ check'])[1]")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[3]");
		String Cellvalue1=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[3]")).getText();
		System.out.println(Cellvalue1);
		Thread.sleep(1000);
		Assert.assertEquals("#ERR: formula error: \"Function error 'c': Column index out of range\"",Cellvalue1);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		String AusCellvalue1=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]")).getText();
		System.out.println(AusCellvalue1);
		Thread.sleep(1000);
		Assert.assertEquals("#ERR: formula error: \"Function error 'getcellvalue': Row index out of range\"",AusCellvalue1);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[1])[5]");
		String Normalvalue2=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[1])[5]")).getText();
		System.out.println(Normalvalue2);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[5]");
		String NormalvalueE1_1=log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[5]")).getText();
		System.out.println(NormalvalueE1_1);
		
		Thread.sleep(1000);
		Assert.assertEquals(Normalvalue1,NormalvalueE1_1);
		
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Cockpit_DataMashup_Errormsg_ check'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Errormsg_ check'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);

		Actions act=new Actions(log.driver);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Cockpit_DataMashup_Errormsg_ check'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		
		
		log.driver.close();
		
		
		
		
		
		
		
		
	}
}
