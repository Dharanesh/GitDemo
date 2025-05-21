package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_25811 extends TestUtils
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
			
		/*waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='2014']");
		log.driver.findElement(By.xpath("//div[text()='2014']")).click();
		Thread.sleep(1000);*/
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='2015']");
		log.driver.findElement(By.xpath("//div[text()='2015']")).click();
		Thread.sleep(1000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> basevalue = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> base= new ArrayList<String>();
		System.out.println("New Report radio button option");
		//base.add("2014");
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
			System.out.println("2015 value is checked");
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
		
		ElemntName1.get(3).click();
		Thread.sleep(1000);
		Assert.assertEquals(ElemntName1.get(3).getAttribute("aria-selected"), "true");
		System.out.println(ElemntName1.get(3).getText() +"   is Selected");
		test.info(ElemntName1.get(3).getText() +"   is Selected");
		
		//check font,border ,color and alignment test
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Font'])[2]");
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Font'])[2]")).isDisplayed());
		System.out.println("font is present in data cell pane");
		test.info("font is present in data cell pane");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Border'])[2]");
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Border'])[2]")).isDisplayed());
		System.out.println("Border is present in data cell pane");
		test.info("Border is present in data cell pane");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Color'])[2]");
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Color'])[2]")).isDisplayed());
		System.out.println("color is present in data cell pane");
		test.info("color is present in data cell pane");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Alignment'])[2]");
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Alignment'])[2]")).isDisplayed());
		System.out.println("Allignment is present in data cell pane");
		test.info("Allingment is present in data cell pane");
		
		//font
		//font size
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Font size']/ancestor::td[1])[2]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Font size']/ancestor::td[1]/input[1])[2]")).isSelected());
		assertEquals(log.driver.findElement(By.xpath("(//label[text()='Font size'])[2]/ancestor::div[3]/div[2]//input[1]")).getAttribute("disabled"),"true");
		System.out.println("Font size checkbox is unchecked and textbox  is disabled");
		test.info("Font size checkbox is unchecked and textbox  is disabled");
		
		//check the font size CB
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Font size']/ancestor::td[1])[2]");
		log.driver.findElement(By.xpath("(//label[text()='Font size']/ancestor::td[1])[2]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Font size']/ancestor::td[1])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//label[text()='Font size']/ancestor::td[1]/input[1])[2]")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Font size'])[2]/ancestor::div[3]/div[2]//input[1]");
		log.driver.findElement(By.xpath("(//label[text()='Font size'])[2]/ancestor::div[3]/div[2]//input[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//label[text()='Font size'])[2]/ancestor::div[3]/div[2]//input[1]")).clear();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Font size'])[2]/ancestor::div[3]/div[2]//input[1]");
		log.driver.findElement(By.xpath("(//label[text()='Font size'])[2]/ancestor::div[3]/div[2]//input[1]")).sendKeys("20");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Font size'])[2]/ancestor::div[3]/div[2]//input[1]");
		String size = log.driver.findElement(By.xpath("(//label[text()='Font size'])[2]/ancestor::div[3]/div[2]//input[1]")).getAttribute("value");
		System.out.println(size);
		assertEquals("20", size);
		//font name
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Font name']/ancestor::td[1])[2]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Font name']/ancestor::td[1]/input[1])[2]")).isSelected());
		System.out.println("Font name checkbox is unchecked");
		test.info("Font name checkbox is unchecked");
		Thread.sleep(1000);
		//font style
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Font style']/ancestor::td[1])[2]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Font style']/ancestor::td[1]/input[1])[2]")).isSelected());
		System.out.println("Font style checkbox is unchecked");
		test.info("Font style checkbox is unchecked");
		
		//check all font style CB
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Italic']/ancestor::td[1])[2]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Bold']/ancestor::td[1]/input[1])[2]")).isEnabled());
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Underline']/ancestor::td[1])[2]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Underline']/ancestor::td[1]/input[1])[2]")).isEnabled());
		Thread.sleep(100);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Italic']/ancestor::td[1])[2]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Italic']/ancestor::td[1]/input[1])[2]")).isEnabled());
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Strikeout']/ancestor::td[1])[2]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Strikeout']/ancestor::td[1]/input[1])[2]")).isEnabled());
		
		//check font style CB
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Font style'])[2]/ancestor::td[1]");
		log.driver.findElement(By.xpath("(//label[text()='Font style'])[2]/ancestor::td[1]")).click();
		Thread.sleep(1000);
		if(log.driver.findElement(By.xpath("(//label[text()='Font style'])[2]/ancestor::td[1]/input[1]")).isSelected())
		{
			System.out.println("font style is selected");
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Font style'])[2]/ancestor::td[1]");
			Assert.assertTrue(log.driver.findElement(By.xpath("(//label[text()='Font style'])[2]/ancestor::td[1]/input[1]")).isSelected());
		}
		else
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Font style'])[2]/ancestor::td[1]");
			log.driver.findElement(By.xpath("(//label[text()='Font style'])[2]/ancestor::td[1]")).click();
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Font style'])[2]/ancestor::td[1]");
			Assert.assertTrue(log.driver.findElement(By.xpath("(//label[text()='Font style'])[2]/ancestor::td[1]/input[1]")).isSelected());
		}
		//select underline		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Underline']/ancestor::td[1])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//label[text()='Underline']/ancestor::td[1]/input[1])[2]")).isEnabled());
		Thread.sleep(200);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Underline']/ancestor::td[1])[2]");
		log.driver.findElement(By.xpath("(//label[text()='Underline']/ancestor::td[1])[2]")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Underline']/ancestor::td[1])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//label[text()='Underline']/ancestor::td[1]/input[1])[2]")).isSelected());
		
		//Border
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Style:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Style:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Default");
		System.out.println("Style is set to default");
		test.info("Style is set to default");
				
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Position:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Position:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Default");
		System.out.println("Position is set to default");
		test.info("Position is set to default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Style:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		WebElement BorderStyle=log.driver.findElement(By.xpath("(//span[text()='Style:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]"));
		//a1.click(BorderStyle).sendKeys("Thin", Keys.ENTER).build().perform();
		a1.click(BorderStyle).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(BorderStyle).sendKeys(Keys.ENTER).build().perform();
		Assert.assertEquals(BorderStyle.getText(), "Thin");
		Thread.sleep(2000);
		
		if(log.driver.findElement(By.xpath("(//span[text()='Style:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText().equals("Thin"))
		{
			assertTrue(true);
			System.out.println("Border Style option is" +log.driver.findElement(By.xpath("(//span[text()='Style:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText());
			test.info("Border Style option is" +log.driver.findElement(By.xpath("(//span[text()='Style:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText());
			System.out.println("Style option contains Thin in it.");
			test.info("Style option contains Thin in it.");
		}
		else
		{
			System.out.println("Border Style option is" +log.driver.findElement(By.xpath("(//span[text()='Style:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText());
			test.info("Border Style option is" +log.driver.findElement(By.xpath("(//span[text()='Style:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText());
		}
	
		//Alignment
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Horizontal:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Horizontal:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Default");
		System.out.println("Horizontal allignment is set to default");
		test.info("Horizontal allignment is set to default");
		
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Vertical:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Vertical:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Default");
		System.out.println("Vertical allignment is set to default");
		test.info("Vertical allignment is set to default");
				
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Word wrap:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Word wrap:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Default");
		System.out.println("Word wrap is set to default");
		test.info("word wrap is set to default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Horizontal:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		WebElement Horizontal=log.driver.findElement(By.xpath("(//span[text()='Horizontal:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]"));
		//a1.click(Horizontal).sendKeys("Left", Keys.ENTER).build().perform();
		a1.click(Horizontal).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(Horizontal).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(Horizontal).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(Horizontal).sendKeys(Keys.ENTER).build().perform();
		Assert.assertEquals(Horizontal.getText(), "Left");
		Thread.sleep(2000);
		System.out.println("values present in Horizontal Alingment dropdown are:  "+log.driver.findElement(By.xpath("(//span[text()='Horizontal:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText());
		test.info("values present in Horizontal Alingment dropdown are:  "+log.driver.findElement(By.xpath("(//span[text()='Horizontal:'])[2]/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText());
		
		//color
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//button[text()='Background'])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//button[text()='Background'])[2]")).isEnabled());
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//button[text()='Background'])[2]");
		log.driver.findElement(By.xpath("(//button[text()='Background'])[2]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select color']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Select color']")).isDisplayed());
		System.out.println("select color window displayed");
		test.info("select color window displayed");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Default color']/ancestor::td[1]");
		if(log.driver.findElement(By.xpath("//label[text()='Default color']/ancestor::td[1]/input[1]")).isSelected())
		{
			log.driver.findElement(By.xpath("//label[text()='Default color']/ancestor::td[1]")).click();
			System.out.println("Default color checkbox is selected");
		}
		else
		{
			System.out.println("Default color checkbox is not selected");
			test.info("Default color checkbox is not selected");
		}
		
		//select green color
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select color']/following::td[19]");
		log.driver.findElement(By.xpath("//span[text()='Select color']/following::td[19]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, " //td[text()='Red:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath(" //td[text()='Red:']/..//input")).getAttribute("value"), "50");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Green:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Green:']/..//input")).getAttribute("value"), "205");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Blue:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Blue:']/..//input")).getAttribute("value"), "50");
		
		System.out.println("values present in red, green and blue fields are correct");
		test.info("values present in red, green and blue fields are correct");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Actual:']/../div[2]");
		String Bar_color= log.driver.findElement(By.xpath("//div[text()='Actual:']/../div[2]")).getCssValue("background-color");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Actual:']/../div[2]")).getCssValue("background-color").contains("50, 205, 50"));
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//button[text()='Background'])[2]/span[1]");
		assertTrue(log.driver.findElement(By.xpath("(//button[text()='Background'])[2]/span[1]")).getCssValue("color").contains("50, 205, 50"));
		
		//select border color
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//button[text()='Border color'])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//button[text()='Border color'])[2]")).isEnabled());
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//button[text()='Border color'])[2]");
		log.driver.findElement(By.xpath("(//button[text()='Border color'])[2]")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select color']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Select color']")).isDisplayed());
		System.out.println("select color window displayed");
		test.info("select color window displayed");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Default color']/ancestor::td[1]");
		if(log.driver.findElement(By.xpath("//label[text()='Default color']/ancestor::td[1]/input[1]")).isSelected())
		{
			log.driver.findElement(By.xpath("//label[text()='Default color']/ancestor::td[1]")).click();
			System.out.println("Default color checkbox is selected");
		}
		else
		{
			System.out.println("Default color checkbox is not selected");
			test.info("Default color checkbox is not selected");
		}
	
		//select blue color
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select color']/following::td[14]");
		log.driver.findElement(By.xpath("//span[text()='Select color']/following::td[14]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, " //td[text()='Red:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath(" //td[text()='Red:']/..//input")).getAttribute("value"), "0");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Green:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Green:']/..//input")).getAttribute("value"), "0");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Blue:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Blue:']/..//input")).getAttribute("value"), "255");
		
		System.out.println("values present in red, green and blue fields are correct");
		test.info("values present in red, green and blue fields are correct");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Actual:']/../div[2]");
		String Border_color= log.driver.findElement(By.xpath("//div[text()='Actual:']/../div[2]")).getCssValue("background-color");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Actual:']/../div[2]")).getCssValue("background-color").contains("0, 0, 255"));
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//button[text()='Border color'])[2]/span[1]");
		assertTrue(log.driver.findElement(By.xpath("(//button[text()='Border color'])[2]/span[1]")).getCssValue("color").contains("0, 0, 255"));
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
		
		//=========Validation===================================
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div");
		Thread.sleep(1000);
		List<WebElement> mashup_header = log.driver.findElements(By.xpath("(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div"));
		System.out.println("no of columns is" +mashup_header.size());
		WebElement Mashup_Column_header = mashup_header.get(mashup_header.size()-1);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div");
		
		WebElement mshup=log.driver.findElement(By.xpath("//div[contains(text(),'MASH')]"));
		JavascriptExecutor js=(JavascriptExecutor)log.driver;
		js.executeScript("arguments[0].click();",mshup);
		Thread.sleep(100);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[contains(text(),'MASH')]");
		mshup.click();
		Thread.sleep(3000);
		
		assertTrue(mshup.getCssValue("background-color").equals(Bar_color));
		System.out.println("Mashup header backgroud color is correct i.e." +mshup.getCssValue("background-color"));
		test.info("Mashup header backgroud color is correct i.e." +mshup.getCssValue("background-color"));
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div");
		assertTrue(mshup.getCssValue("border-right-color").equals(Border_color));
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div");
		assertTrue(mshup.getCssValue("border-bottom-color").equals(Border_color));
		System.out.println("Mashup header border color is correct i.e." +mshup.getCssValue("border-bottom-color"));
		test.info("Mashup header border color is correct i.e." +mshup.getCssValue("border-bottom-color"));
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div");
		Assert.assertTrue(mshup.getAttribute("style").contains("font-size: 20pt"));
		System.out.println("font size"+mshup.getAttribute("style"));
		test.info("font size"+mshup.getAttribute("style"));
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div");
		assertTrue(mshup.getCssValue("text-decoration-line").equals("underline"));
		System.out.println("Mashup header is underlined");
		test.info("Mashup header is underlined");
		
		System.out.println("All the properties applied to header cell displayed correctly");
		test.info("All the properties applied to header cell displayed correctly");
		Thread.sleep(2000);
		
		
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
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Mashup_element_properties_check_HeaderCell");
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Mashup_element_properties_check_HeaderCell']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Mashup_element_properties_check_HeaderCell']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		
		//opn the report
		log.driver.findElement(By.xpath("(//span[text()='Mashup_element_properties_check_HeaderCell'])[1]")).click();
		Thread.sleep(3000);
		
		
		
		System.out.println("MASHUP_cellproperties is working");
		test.info("MASHUP_cellproperties is working");
		
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Mashup_element_properties_check_HeaderCell'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Mashup_element_properties_check_HeaderCell'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);

		Actions act=new Actions(log.driver);
		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='Mashup_element_properties_check_HeaderCell'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		
		log.driver.close();
		
		
		
		
	}
}
