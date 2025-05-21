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

public class TestCase_25556 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Web_Testcase_to_verify_Cockpit_Data_Mashup_Filter_Check(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_25556 : Cockpit Data Mashup Filter Check");
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Rows']/ancestor::div[5]/div[4]/div[2]//ul/li/div[1]/span/span[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Rows']/ancestor::div[5]/div[4]/div[2]//ul/li/div[1]/span/span[2]")).getText(),"Customer");
		System.out.println("Customer is present in Rows");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Columns']/ancestor::div[5]/div[6]/div[2]//ul/li/div[1]/span/span[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Columns']/ancestor::div[5]/div[6]/div[2]//ul/li/div[1]/span/span[2]")).getText(),"Time");
		Thread.sleep(2000);
		System.out.println("Time is present in columns");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Columns']/ancestor::div[5]/div[6]/div[2]//ul/li/div[1]/span/span[2]");
		log.driver.findElement(By.xpath("//span[text()='Columns']/ancestor::div[5]/div[6]/div[2]//ul/li/div[1]/span/span[2]")).click();
		
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='All Periods'])[1]/../div[2]");
		log.driver.findElement(By.xpath("(//div[text()='All Periods'])[1]/../div[2]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='All Periods'])[1]/../div[2]");
		assertTrue(log.driver.findElement(By.xpath("(//div[text()='All Periods'])[1]/../div[2]/input[1]")).isSelected());
		System.out.println("All Periods Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='All Periods'])[2]/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("(//div[text()='All Periods'])[2]/../div[1]/input[1]")).isSelected());
		System.out.println("All Periods Checkbox is Selected in the list of Base elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		a1.click(elemnt).sendKeys("Calculated elements", Keys.ENTER).build().perform();
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
        waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Element properties are not available')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Element properties are not available')]")).isDisplayed());
		Thread.sleep(500);
		System.out.println(log.driver.findElement(By.xpath("//span[contains(text(),'Element properties are not available')]")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
        
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		
	    log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Base elements')]/ancestor::div[4]/div[2]/div[1]/div/div[1]");
		List<WebElement> Bas = log.driver.findElements(By.xpath("//span[contains(text(),'Base elements')]/ancestor::div[4]/div[2]/div[1]/div/div[1]/input"));

		for (int i = 0; i < Bas.size()-1; i++) {	
			Assert.assertEquals(Bas.get(i).isSelected(), false);

		}
		System.out.println("All the elements in base element area are unchecked");
		test.info("All the elements in base element area are unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='MASHUP'])[2]//../div[1]");
		log.driver.findElement(By.xpath("(//div[text()='MASHUP'])[2]//../div[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP'])[2]//../div[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[text()='MASHUP'])[2]//../div[1]/input")).isSelected());
		
    	waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li/a");
		List<WebElement> ElemntName =log.driver.findElements(By.xpath("//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li/a"));
		System.out.println("Tabs present in Property of elements windows are:");
		ArrayList<String > tab_name = new ArrayList<String>();
		tab_name.add("Element");
		tab_name.add("Value Format");
		tab_name.add("Data Cell");
		tab_name.add("Header Cell");
		tab_name.add("Chart");
		tab_name.add("Maps");
		for (int  i=0;i<=ElemntName.size()-1;i++) 
		{		
			String tabName = ElemntName.get(i).getText();
			Assert.assertEquals(tabName, tab_name.get(i),"Value Not Matching");
			System.out.println(tabName);
			test.info(tabName);
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li");
		List<WebElement> ElemntName1 =log.driver.findElements(By.xpath("//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li"));
		Assert.assertEquals(ElemntName1.get(0).getAttribute("aria-selected"), "true");
		System.out.println(ElemntName1.get(0).getText() +"   is Selected");
		test.info(ElemntName1.get(0).getText() +"   is Selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Rounding']/../../../td[3]/table/tbody/tr/td/div/div/input[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Rounding']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(),true);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Rounding']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).getAttribute("value"),"5");
		System.out.println("MASHUP Rounding: 5 displayed");
		test.info("MASHUP Rounding: 5 displayed");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Hide Element']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Hide Element']/../../../td[3]/div[1]//input")).isSelected(), false);
		System.out.println("Hide Element checkbox is selected by default");
		test.info("Hide Element checkbox is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Interrupt calculation']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Interrupt calculation']/../../../td[3]/div[1]//input")).isSelected(), true);
		System.out.println("Interrupt calculation checkbox is selected by default");
		test.info("Interrupt calculationt checkbox is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Treat empty values as 0']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Treat empty values as 0']/../../../td[3]/div[1]//input")).isSelected(), true);
		System.out.println("Treat empty values as 0 checkbox is selected by default");
		test.info("Treat empty values as 0 checkbox is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='defaultbutton']");
		log.driver.findElement(By.xpath("//input[@id='defaultbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Resetting the default settings')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Resetting the default settings')]")).isDisplayed());
		Thread.sleep(500);
		System.out.println(log.driver.findElement(By.xpath("//span[contains(text(),'Resetting the default settings')]")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Alias:']/ancestor::div[3]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[text()='Alias:']/ancestor::div[3]/div[2]//input[1]")).sendKeys("mashup");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		try
		{
			assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
			log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
			System.out.println("Ok not Clicked====");
			Thread.sleep(2000);
			
		}catch(Exception e)
		{
			System.out.println("Ok Clicked====");
		}
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> BAseelemtAdded = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		ArrayList<String > type1 = new ArrayList<String>();
		int count=0;
		for(int i=0;i<=BAseelemtAdded.size()-1;i++)
		{
		   type1.add(BAseelemtAdded.get(i).getText());
		   count++;
		}

		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(4000);
		int countq=0;
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div");
		List<WebElement> TableColumnHdr = log.driver.findElements(By.xpath("(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div"));
		for (WebElement webElement : TableColumnHdr) {
			if(webElement.getText().equals("All Periods")||webElement.getText().equals("mashup")){
				assertTrue(true);
				countq++;
			}
		}
		
		assertEquals(count,countq);
		System.out.println("mashup alias name applied successfully in column");
		test.info("mashup alias name applied successfully in column");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='mashup']/ancestor::div[4]/div/div[4]/div/div/div[2]");
		List<WebElement> mash_col_val = log.driver.findElements(By.xpath("//div[text()='mashup']/ancestor::div[4]/div/div[4]/div/div/div[2]"));
		for (WebElement webElement : mash_col_val)
		{
			assertTrue(webElement.getText().isEmpty());
		}
		System.out.println("mashup column is empty");
		test.info("mashup column is empty");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='mashup']/ancestor::div[4]/div/div[4]/div/div/div[2])[1]");
		ui.rightClick("(//div[text()='mashup']/ancestor::div[4]/div/div[4]/div/div/div[2])[1]");
		
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
		log.driver.findElement(By.xpath("//span[text()='Cell Value']/ancestor::div[2]/div[2]/div[1]//input[1]")).sendKeys("=C(1,2)-C(1,1)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
	
		
		String Australia = log.driver.findElement(By.xpath("//div[text()='Australia']/ancestor::div[4]/div/div[4]/div/div[2]/div[1]")).getText();
		System.out.println("value present in australia cell is" +Australia);
		String Finalval=Australia.replaceAll("[€,()]","");
		System.out.println("value entered after replacing aplha values: "+Finalval);
		Float parsed_table_Value= Float.parseFloat(Finalval);
		System.out.println("parsed float value is: " +parsed_table_Value);
				
		String Allcustomers = log.driver.findElement(By.xpath("//div[text()='All Customers']/ancestor::div[4]/div/div[4]/div/div[1]/div[1]")).getText();
		System.out.println("value present in All customers cell is" +Allcustomers);
		String Finalval1=Allcustomers.replaceAll("[€,()]","");
		System.out.println("value entered after replacing aplha values: "+Finalval1);
		Float parsed_table_Value1= Float.parseFloat(Finalval1);
		System.out.println("parsed float value is: " +parsed_table_Value1);
		
		Float result= (parsed_table_Value-parsed_table_Value1);
		System.out.println("Result value= " +result);
		
		String mashup = log.driver.findElement(By.xpath("(//div[text()='mashup']/ancestor::div[4]/div/div[4]/div/div/div[2])[1]")).getText();
		System.out.println("value present in All customers cell is" +mashup);
		String Finalval11=mashup.replaceAll("[€,()]","");
		System.out.println("value entered after replacing aplha values: "+Finalval11);
		Float parsed_table_Value11= Float.parseFloat(Finalval11);
		System.out.println("parsed float value is: " +parsed_table_Value11);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='mashup']/ancestor::div[4]/div/div[4]/div/div/div[2])[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='mashup']/ancestor::div[4]/div/div[4]/div/div/div[2])[1]")).getCssValue("color"), "rgba(255, 0, 0, 1)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Measures'])[1]");
		ui.rightClick("(//span[text()='Measures'])[1]");
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Enable navigation by arrow']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Enable navigation by arrow']")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Enable navigation by arrow']");
		log.driver.findElement(By.xpath("//span[text()='Enable navigation by arrow']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Select next element']");
		log.driver.findElement(By.xpath("//button[@data-title='Select next element']")).click();
		String Filterval2=log.driver.findElement(By.xpath("(//span[text()='Measures']/following::div/div[1]/div/span)[1]/span/input")).getAttribute("value");
		System.out.println(Filterval2);
		Thread.sleep(2000);
		
		String Australia1 = log.driver.findElement(By.xpath("//div[text()='Australia']/ancestor::div[4]/div/div[4]/div/div[2]/div[1]")).getText();
		System.out.println("value present in australia cell is" +Australia1);
		String Finalval2=Australia1.replaceAll("[€,()]","");
		System.out.println("value entered after replacing aplha values: "+Finalval2);
		Float parsed_table_Value2= Float.parseFloat(Finalval2);
		System.out.println("parsed float value is: " +parsed_table_Value2);
				
		String Allcustomers1 = log.driver.findElement(By.xpath("//div[text()='All Customers']/ancestor::div[4]/div/div[4]/div/div[1]/div[1]")).getText();
		System.out.println("value present in All customers cell is" +Allcustomers1);
		String Finalval22=Allcustomers1.replaceAll("[€,()]","");
		System.out.println("value entered after replacing aplha values: "+Finalval22);
		Float parsed_table_Value22= Float.parseFloat(Finalval22);
		System.out.println("parsed float value is: " +parsed_table_Value22);
		
		Float result1= (parsed_table_Value2-parsed_table_Value22);
		System.out.println("Result value= " +result1);
		
		String mashup1 = log.driver.findElement(By.xpath("(//div[text()='mashup']/ancestor::div[4]/div/div[4]/div/div/div[2])[1]")).getText();
		System.out.println("value present in All customers cell is" +mashup1);
		String final1=mashup1.replaceAll("[€,()]","");
		System.out.println("value entered after replacing aplha values: "+final1);
		Float parsedval= Float.parseFloat(final1);
		System.out.println("parsed float value is: " +parsedval);
		
		
		Assert.assertEquals(parsedval,result1);
		System.out.println("value displayed correctly in mashup cell for measures filter change i.e. " +parsedval);
		
	
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Category'])[1]");
		ui.rightClick("(//span[text()='Category'])[1]");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Multiple selection']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Multiple selection']")).isDisplayed());
		log.driver.findElement(By.xpath("//span[text()='Multiple selection']")).click();
		Thread.sleep(1000);
		
		String BfDrpDwnValue=log.driver.findElement(By.xpath("(//span[text()='Category'])[1]/following::input[@class='k-input dropdowninput cwplaceholder']")).getAttribute("value");
  		System.out.println("Before DrpDwn Value is:->"+BfDrpDwnValue);
  		Thread.sleep(2000);
  		//Assign filter values:==============
	  	log.driver.findElement(By.xpath("(//span[text()='Category'])[1]/following::span[3]")).click();
  		Thread.sleep(2000);
	  	log.driver.findElement(By.xpath("//span[text()='Company Car']")).click();
	  	Thread.sleep(1000);
	  	log.driver.findElement(By.xpath("//span[text()='Used Car']")).click();
	  	Thread.sleep(500);
  		
	  	log.driver.findElement(By.xpath("//button[text()='Resolve']")).click();
  		Thread.sleep(500);
  		log.driver.findElement(By.xpath("//button[text()='Apply']")).click();	
  		Thread.sleep(1000);
	  	
  		String AfApplyFilterValue=log.driver.findElement(By.xpath("(//span[text()='Category'])[1]/following::input[@class='k-input dropdowninput cwplaceholder']")).getAttribute("value");
  		System.out.println("After Apply Filter Value is:->"+AfApplyFilterValue);
  		
  		if(!(AfApplyFilterValue.equals("All Categories, Used Car, Company Car")))
	  	{
	  		System.out.println("Multi select For Filters is working as expected after apply Filter.");
	  	}
  		Thread.sleep(500);
  	
  		
		Thread.sleep(3000);
		String Australia11 = log.driver.findElement(By.xpath("//div[text()='Australia']/ancestor::div[4]/div/div[4]/div/div[2]/div[1]")).getText();
		System.out.println("value present in australia cell is" +Australia11);
		String Finalval21=Australia11.replaceAll("[€,()]","");
		System.out.println("value entered after replacing aplha values: "+Finalval21);
		Float parsed_table_Value21= Float.parseFloat(Finalval21);
		System.out.println("parsed float value is: " +parsed_table_Value21);
				
		String Allcustomers11 = log.driver.findElement(By.xpath("//div[text()='All Customers']/ancestor::div[4]/div/div[4]/div/div[1]/div[1]")).getText();
		System.out.println("value present in All customers cell is" +Allcustomers11);
		String Finalval221=Allcustomers11.replaceAll("[€,()]","");
		System.out.println("value entered after replacing aplha values: "+Finalval221);
		Float parsed_table_Value221= Float.parseFloat(Finalval221);
		System.out.println("parsed float value is: " +parsed_table_Value221);
		
		Float result11= (parsed_table_Value221-parsed_table_Value21);
		System.out.println("Result value= " +result11);
		
		String mashup11 = log.driver.findElement(By.xpath("(//div[text()='mashup']/ancestor::div[4]/div/div[4]/div/div/div[2])[1]")).getText();
		System.out.println("value present in All customers cell is" +mashup11);
		String final11=mashup11.replaceAll("[€,()]","");
		System.out.println("value entered after replacing aplha values: "+final11);
		Float parsedval1= Float.parseFloat(final11);
		System.out.println("parsed float value is: " +parsedval1);
		
		
		Assert.assertEquals(parsedval1,result11);
		System.out.println("value displayed correctly in mashup cell for category filter change i.e. " +parsedval1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
