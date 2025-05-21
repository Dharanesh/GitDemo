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

public class TestCase_25812 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Web_Testcase_to_verify_Cockpit_Data_Mashup_Functionality_Table_Cell_Properties(String browser) throws Exception
	{	
		test =extent.createTest("TestCase_25812 : Cockpit Data Mashup Functionality Table Cell Properties(Cell tab)");
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
			System.out.println("2014,2015 value is checked");
		}
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
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
		log.driver.findElement(By.xpath("//span[text()='Cell Value']/ancestor::div[2]/div[2]/div[1]//input[1]")).sendKeys("=C(2,3)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
		String first_column_Val = log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]")).getText();
		System.out.println(first_column_Val);
		String int_val=first_column_Val.replaceAll("[€,.]", "");
		int int_vale=  Integer.parseInt(int_val)+10000;
		System.out.println("value after aggregation is " +int_vale);
		

		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
		log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
		ui.rightClick("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[1]");
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
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='2/0'])[1]"))).perform();
		     Thread.sleep(2000);
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Single Data Cell']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell properties...']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cell properties...']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell properties...']");
		log.driver.findElement(By.xpath("//span[text()='Cell properties...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell properties']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cell properties']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell properties']/following::div[5]/div[2]/div/div/div/ul/li/a");
		List<WebElement> ElemntName =log.driver.findElements(By.xpath("//span[text()='Cell properties']/following::div[5]/div[2]/div/div/div/ul/li/a"));
		System.out.println("Tabs present in Property of elements windows are:");
		ArrayList<String > tab_name = new ArrayList<String>();
		tab_name.add("Cell");
		tab_name.add("Value Format");
		tab_name.add("Data");
		
		for (int  i=0;i<=ElemntName.size()-1;i++) 
		{		
			String tabName = ElemntName.get(i).getText();
			Assert.assertEquals(tabName, tab_name.get(i),"Value Not Matching");
			System.out.println(tabName);
			test.info(tabName);
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell properties']/following::div[5]/div[2]/div/div/div/ul/li");
		List<WebElement> ElemntName1 =log.driver.findElements(By.xpath("//span[text()='Cell properties']/following::div[5]/div[2]/div/div/div/ul/li"));
		Assert.assertEquals(ElemntName1.get(0).getAttribute("aria-selected"), "true");
		System.out.println(ElemntName1.get(0).getText() +"   is Selected");
		test.info(ElemntName1.get(0).getText() +"   is Selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
		if(log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
			log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).click();
			System.out.println("Priority button got expanded");
			test.info("Priority button got expanded");
		}else{
			System.out.println("Priority button expanded by default");
			test.info("Priority button expanded by default");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), true);
		System.out.println("Automatic Priority checkbox is selected by default");
		test.info("Automatic Priority checkbox is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), false);
		System.out.println("explicit priority text box is disabled by default");
		test.info("explicit priority text box is disabled by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]/div[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), false);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), true);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys(Keys.BACK_SPACE);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys("2");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		try
		{
		  waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Cell properties']");
		  Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cell properties']")).isDisplayed());
		  waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		  log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		  Thread.sleep(2000);
		}
		catch(Exception e)
		{
		  System.out.println("Ok is clicked");	
		}
		
		Thread.sleep(2000);
		//second column
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		ui.rightClick("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='//span[.='Cell properties...']")).isDisplayed())
			{
				System.out.println("Cell properties Available");
			}
		}
		catch(Exception e)
		{
			 Actions act = new Actions(log.driver);
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='2/1'])[1]"))).perform();
		     Thread.sleep(2000);
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell properties...']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cell properties...']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell properties...']");
		log.driver.findElement(By.xpath("//span[text()='Cell properties...']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell properties']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cell properties']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell properties']/following::div[5]/div[2]/div/div/div/ul/li/a");
		List<WebElement> ElemntName11=log.driver.findElements(By.xpath("//span[text()='Cell properties']/following::div[5]/div[2]/div/div/div/ul/li/a"));
		System.out.println("Tabs present in Property of elements windows are:");
		ArrayList<String > tab_name1 = new ArrayList<String>();
		tab_name1.add("Cell");
		tab_name1.add("Value Format");
		tab_name1.add("Data");
		
		for (int  i=0;i<=ElemntName11.size()-1;i++) 
		{		
			String tabName1 = ElemntName11.get(i).getText();
			Assert.assertEquals(tabName1, tab_name1.get(i),"Value Not Matching");
			System.out.println(tabName1);
			test.info(tabName1);
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Cell properties']/following::div[5]/div[2]/div/div/div/ul/li");
		List<WebElement> ElemntName111 =log.driver.findElements(By.xpath("//span[text()='Cell properties']/following::div[5]/div[2]/div/div/div/ul/li"));
		Assert.assertEquals(ElemntName111.get(0).getAttribute("aria-selected"), "true");
		System.out.println(ElemntName111.get(0).getText() +"   is Selected");
		test.info(ElemntName111.get(0).getText() +"   is Selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
		if(log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
			log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).click();
			System.out.println("Priority button got expanded");
			test.info("Priority button got expanded");
		}else{
			System.out.println("Priority button expanded by default");
			test.info("Priority button expanded by default");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), true);
		System.out.println("Automatic Priority checkbox is selected by default");
		test.info("Automatic Priority checkbox is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), false);
		System.out.println("explicit priority text box is disabled by default");
		test.info("explicit priority text box is disabled by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]/div[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), false);
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).getAttribute("value"), "1");
		System.out.println("The explicit priority vaue is =  "+log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).getAttribute("value"));
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		try
		{
		  waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Cell properties']");
		  Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cell properties']")).isDisplayed());
		  waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		  log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		  Thread.sleep(2000);
		}
		catch(Exception e)
		{
		  System.out.println("Ok is clicked");	
		}
		
		Thread.sleep(2000);
		
		
		//write in second column
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		ui.rightClick("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='//span[.='Cell properties...']")).isDisplayed())
			{
				System.out.println("Cell properties Available");
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
		log.driver.findElement(By.xpath("//span[text()='Cell Value']/ancestor::div[2]/div[2]/div[1]//input[1]")).sendKeys("=C(3,1)+100");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		String Second_Column_Val = log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]")).getText();
		System.out.println(Second_Column_Val);
		String sec_val=Second_Column_Val.replaceAll("[€,.]", "");
		int Final_val1=  Integer.parseInt(sec_val);
		System.out.println("value after aggregation is " +Final_val1);
		Assert.assertEquals(Final_val1, int_vale);
		
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
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("MASHUP_cellproperties_CellTab");
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='MASHUP_cellproperties_CellTab']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='MASHUP_cellproperties_CellTab']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		
		//opn the report
		log.driver.findElement(By.xpath("(//span[text()='MASHUP_cellproperties_CellTab'])[1]")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]");
		String Second_Column_Val_validate = log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[3])[2]")).getText();
		System.out.println(Second_Column_Val_validate);
		
		Assert.assertEquals(Second_Column_Val_validate,Second_Column_Val);
		Thread.sleep(1000);
		
		System.out.println("MASHUP_cellproperties is working");
		test.info("MASHUP_cellproperties is working");
		
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='MASHUP_cellproperties_CellTab'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='MASHUP_cellproperties_CellTab'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);

		Actions act=new Actions(log.driver);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='MASHUP_cellproperties_CellTab'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		
		log.driver.close();
		
		
	}
}
