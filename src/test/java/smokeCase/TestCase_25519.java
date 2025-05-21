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

public class TestCase_25519 extends TestUtils
{
	@Test	
	@Parameters("browser")

	public void Testcase_for_Cockpit_Container_Elements_Data_DDL(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_25519: Testcase for Cockpit Container Elements-Data DDL");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui=new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Manufacturer_Ranking']");
		log.driver.findElement(By.xpath("//span[text()='Manufacturer_Ranking']")).click();
        Thread.sleep(1000);

        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Manufacturer_Ranking'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Manufacturer_Ranking'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Product");
		System.out.println("Product is present in Rows");
		test.info("Product is present in Rows");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(), "Category");
		System.out.println("Category is present in Columns");
		test.info("Category is present in Columns");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e1.getText(), "Product");
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
		Assert.assertEquals(e4.getText(), "<Element Name>");
		System.out.println("Value present in Display displayed correctly");
		test.info("Value present in Display displayed correctly");	
		Thread.sleep(1000);
		List<WebElement> AB = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for Rows')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB)
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='All groups/elements available']/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='All groups/elements available']/../../td[1]/input[@type='checkbox']")).isSelected(),true);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Groups']/ancestor::div[4]/div[2]/div[1]/div[1]/ul/li/div[1]/span[1]/span[2]");
		List<WebElement> Group = log.driver.findElements(By.xpath("//span[text()='Groups']/ancestor::div[4]/div[2]/div[1]/div[1]/ul/li/div[1]/span[1]/span[2]"));
		ArrayList<String> groupValue= new ArrayList<String>();
		System.out.println("Group option values");
		groupValue.add("Dimensiontree");
		groupValue.add("Calculated elements");
		groupValue.add("Container elements");
		groupValue.add("Client Rules");

		for(int i =0;i<=Group.size()-1;i++) 
		{
			assertEquals(Group.get(i).getText(), groupValue.get(i));
			System.out.println(Group.get(i).getText());
		}

		test.info(" All 4 options are Present in group ");
		System.out.println("All 4 options are Present in group ");

		Thread.sleep(1000);
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Container elements'])[1]/ancestor::li[1]")).getCssValue("background-color").contains("255, 212, 0"), "container element got higlighted");
		System.out.println("Container Element got highlighted");
		test.info("Container Element got highlighted");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']/following::div[5]/div[5]/div/div/button");
		List<WebElement> grpEleBtn1 = log.driver.findElements(By.xpath("//span[text()='Element Groups']/following::div[5]/div[5]/div/div/button"));
		for(int i =0;i<=grpEleBtn1.size()-1;i++) 
		{
			String value1 = grpEleBtn1.get(i).getCssValue("disabled");
			System.out.println(value1);

			if(value1.contains("true"))
			{
				System.out.println(grpEleBtn1.get(i).getText());
				test.info(grpEleBtn1.get(i).getText()+"button disabled");
			}

			else
			{
				System.out.println("Options are not greyedout");
				System.out.println(grpEleBtn1.get(i).getText());
				test.info(grpEleBtn1.get(i).getText()+"button not disabled");
			}
		
		}
		List<WebElement> AB1 = log.driver.findElements(By.xpath("//span[contains(text(),'Element Groups')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB1)
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		
		}
		Thread.sleep(1000);
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
       try{
			for(int i=0;i<=SelectableElementvalue.size()-1;i++)
			{
				String valueofcontainerele =SelectableElementvalue.get(i).getText();
				System.out.println(valueofcontainerele);

				if(valueofcontainerele.contains("DataDDL"))
				{
					System.out.println("DataDDL is present");
					test.info("DataDDL is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='DataDDL']");
					log.driver.findElement(By.xpath("//span[text()='DataDDL']")).click();
					Thread.sleep(1000);
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Delete']");
					log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
					Thread.sleep(1000);
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Yes']");
					log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
					System.out.println("deletion done");
					break;
				}
				else
				{
					System.out.println("not found");
				}
				
			}
			
		}
		
		catch(Exception e)
		{
		System.out.println("creating new container element");
		}
        Thread.sleep(1000);
        waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='New...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='New...']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='New...']");
		log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Element']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='New Element']")).isDisplayed(),true);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Available element types:']/following::div[2]/div/div[1]");
		List<WebElement> ElementGrp = log.driver.findElements(By.xpath("//span[text()='Available element types:']/following::div[2]/div/div[1]"));
		ArrayList<String> ElegroupValue= new ArrayList<String>();
		System.out.println("Element Group option values");
		ElegroupValue.add("Criteria DDL");
		ElegroupValue.add("Data DDL");
		ElegroupValue.add("Script DDL");
		ElegroupValue.add("Standard SDL");

		for(int i =0;i<=ElementGrp.size()-1;i++) 
		{
			assertEquals(ElementGrp.get(i).getText(), ElegroupValue.get(i));
			System.out.println(ElementGrp.get(i).getText());

		}
		Thread.sleep(1000);
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[1]")).getCssValue("background-color").contains("255, 212, 0"), "Criteria DDL got higlighted");
		System.out.println("Criteria DDL got highlighted");
		Thread.sleep(500);
		ElementGrp.get(1).click();
		Thread.sleep(1000);
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[2]")).getCssValue("background-color").contains("255, 212, 0"), "Data ddl got higlighted");
		System.out.println("Data DDL Element got highlighted");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'New Data DDL')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New Data DDL')]")).isDisplayed(),true);
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Name']/ancestor::div[3]/div[2]/div/div/input");
	    log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).sendKeys("DataDDL");
	    Thread.sleep(500);
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);	
		
		try{
			if(log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).isDisplayed())
			{
				waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
				log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
				Thread.sleep(2000);	
			}
			
		}catch(Exception ex)
		{
			
		}
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Preselection of Elements']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Preselection of Elements']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'All elements of the dimension')]/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[contains(text(),'All elements of the dimension')]/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//tr[@class='lvitem']/td[2]/ancestor::div[1]");
		assertTrue(log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]/ancestor::div[1]")).getCssValue("background-color").contains("255, 255, 255"));
		System.out.println("Select hierarchy: is Enabled");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//tr[@class='lvitem']/td[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]")).getText(),"Product");
		System.out.println("Select hierarchy: is"+log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'Following elements')]/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[contains(text(),'Following elements')]/ancestor::td[1]/input[1]")).isSelected(),false);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'Following elements')]/ancestor::td[1]");
		log.driver.findElement(By.xpath("//label[contains(text(),'Following elements')]/ancestor::td[1]")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'Following elements')]/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[contains(text(),'Following elements')]/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//tr[@class='lvitem']/td[2]/ancestor::div[1]");
		assertTrue(log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]/ancestor::div[1]")).getCssValue("background-color").contains("204, 204, 204"));
		System.out.println("Select hierarchy: is Disabled");
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'Following elements')]/ancestor::div[3]/div[4]/div[1]/div[1]");
		assertTrue(log.driver.findElement(By.xpath("//label[contains(text(),'Following elements')]/ancestor::div[3]/div[4]/div[1]/div[1]")).getCssValue("background-color").contains("255, 255, 255"));
		System.out.println("Text Area is Enabled");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Selection...']");
		log.driver.findElement(By.xpath("//button[text()='Selection...']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Column')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Column')]")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions action=new Actions(log.driver);
		action.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		action.click(elemnt).sendKeys(Keys.ENTER).build().perform();
		//action.click(elemnt).sendKeys("Container elements", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elmntindrpdwn=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwn.getText(),"Container elements");
		System.out.println(elmntindrpdwn.getText());
		System.out.println("Container elements is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			String aa = selectble_ele.get(i).getText();
			if(selectable.contains("Elements of level"))
			{
				assertTrue(true);
				
			}
			
		}	
			
		System.out.println("Elements of level is present in the list of selectable elements");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Elements of level']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='Elements of level']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Elements of level']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Elements of level']/../div[1]/input[1]")).isSelected());
		System.out.println("Elements of level Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Current element']/ancestor::div[3]/div[2]/div[1]/table/tbody/tr/td[2]");
		assertEquals(log.driver.findElement(By.xpath("//span[text()='Current element']/ancestor::div[3]/div[2]/div[1]/table/tbody/tr/td[2]")).getText(),"Elements of level");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Current element']/following::div[5]/div[1]/div[1]/ul/li/a");
		List<WebElement> tabs =log.driver.findElements(By.xpath("//span[text()='Current element']/following::div[5]/div[1]/div[1]/ul/li/a"));
		System.out.println("Tabs present in properties of element windows are:");
		ArrayList<String > tab_name = new ArrayList<String>();
		tab_name.add("Settings");
		tab_name.add("Element");
		tab_name.add("Value Format");
		tab_name.add("Data Cell");
		tab_name.add("Header Cell");
		tab_name.add("Chart");
		tab_name.add("Maps");
		for (int  i=0;i<=tabs.size()-1;i++) 
		{		
		String tab = tabs.get(i).getText();
		Assert.assertEquals(tab, tab_name.get(i));
		System.out.println(tab);
		test.info(tab);
		}
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//a[text()='Settings']/ancestor::li[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Settings']/ancestor::li[1]")).getAttribute("aria-selected"), "true");
		System.out.println(tabs.get(0).getText() +"   is highlighted");
		test.info(tabs.get(0).getText() +"   is highlighted");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Level selection']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Level selection']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Elements of level:']/following::div[1]/div[1]/div[1]/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Elements of level:']/following::div[1]/div[1]/div[1]/input[1]")).clear();
		log.driver.findElement(By.xpath("//span[text()='Elements of level:']/following::div[1]/div[1]/div[1]/input[1]")).sendKeys("1");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Column')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Column')]")).isDisplayed(),true);
		
		List<WebElement> EmltLevel = log.driver.findElements(By.xpath("//div[text()='Elements of level']/../div[1]/input"));
		for (int i = 0; i < EmltLevel.size(); i++) 
		{
			assertTrue(EmltLevel.get(i).isSelected());
		}
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Preselection of Elements']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Preselection of Elements']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Cube Selection']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Cube Selection']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Limitation of the data area']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Limitation of the data area']")).isDisplayed(),true);
		//Measure
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Measures']/ancestor::div[1]/div[4]/button[1]");
		log.driver.findElement(By.xpath("//div[text()='Measures']/ancestor::div[1]/div[4]/button[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Select element for value range')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Select element for value range')]")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Select element for value range')]/following::span[3]/span[1]");
		WebElement elemntMsr=log.driver.findElement(By.xpath("//span[contains(text(),'Select element for value range')]/following::span[3]/span[1]"));
		//action.click(elemntMsr).sendKeys("MeasuresLevel (Subset-Dimlevel)", Keys.ENTER).build().perform();
		action.click(elemntMsr).sendKeys(Keys.ARROW_DOWN).build().perform();
		action.click(elemntMsr).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
//		Assert.assertEquals(elemntMsr.getText(),"MeasuresLevel (Subset-Dimlevel)");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Margin2']");
		log.driver.findElement(By.xpath("//div[text()='Margin2']")).click();
		Thread.sleep(2000);
		//TimeType
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Timetype']/ancestor::div[1]/div[4]/button[1]");
		log.driver.findElement(By.xpath("//div[text()='Timetype']/ancestor::div[1]/div[4]/button[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Select element for value range')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Select element for value range')]")).isDisplayed(),true);
				
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Select element for value range')]/following::span[3]/span[1]");
		WebElement elemntTimetype=log.driver.findElement(By.xpath("//span[contains(text(),'Select element for value range')]/following::span[3]/span[1]"));
		//action.click(elemntTimetype).sendKeys("Timetype", Keys.ENTER).build().perform();
		
		Assert.assertEquals(elemntTimetype.getText(),"Timetype");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Single Periods']");
		log.driver.findElement(By.xpath("//div[text()='Single Periods']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Value Comparison and Settings')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Value Comparison and Settings')]")).isDisplayed(),true);
		Thread.sleep(200);
		WebElement Oprtr=log.driver.findElement(By.xpath("//span[contains(text(),'Value comparison')]/ancestor::div[3]/div[2]/div[1]/div[1]/div[1]/span/span/span[1]"));
		assertEquals(Oprtr.getText(), "<>");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Value comparison')]/ancestor::div[3]/div[2]/div[1]/div[2]/div/div/input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Value comparison')]/ancestor::div[3]/div[2]/div[1]/div[2]/div/div/input[1]")).sendKeys("0.00");;
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Accept C elements and R elements']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Accept C elements and R elements']/ancestor::td[1]/input[1]")).isSelected(),false);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Accept C elements and R elements']/ancestor::td[1]");
		log.driver.findElement(By.xpath("//label[text()='Accept C elements and R elements']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Accept C elements and R elements']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Accept C elements and R elements']/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Sorting and Limiting')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Sorting and Limiting')]")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Sorting']/ancestor::div[3]/div/div/div/table/tbody/tr/td/label");
		List<WebElement> RadioBtn = log.driver.findElements(By.xpath("//span[text()='Sorting']/ancestor::div[3]/div/div/div/table/tbody/tr/td/label"));
		int k;	
		for (int i =0;i<=RadioBtn.size()-1;i++) 
		{
			k=i+1;
			String Text = RadioBtn.get(i).getText();
			System.out.println(Text);
			if(Text.contains("Unsorted"))
			{
				Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sorting']/ancestor::div[3]/div/div/div/table/tbody/tr/td/label/ancestor::td[1]/input)["+k+"]")).isSelected(),true);
				System.out.println(Text+"  is selected");
			}
			else
			{
				
				Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sorting']/ancestor::div[3]/div/div/div/table/tbody/tr/td/label/ancestor::td[1]/input)["+k+"]")).isSelected(),false);
				System.out.println(Text+"  is not selected");
			}
		}
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Unlimited number']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Unlimited number']/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Limited to']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Limited to']/ancestor::td[1]/input[1]")).isSelected(),false);
		log.driver.findElement(By.xpath("//label[text()='Limited to']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Limited to']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Limited to']/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Limited to']/ancestor::div[3]/div[2]/div[1]/div[1]/input[1]");
		log.driver.findElement(By.xpath("//label[text()='Limited to']/ancestor::div[3]/div[2]/div[1]/div[1]/input[1]")).sendKeys("10");
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed())
			{
				waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
				log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
				Thread.sleep(2000);
			}
		}
		catch(Exception ex)
		{
			
		}
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		action.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		action.click(elemnt1).sendKeys(Keys.ENTER).build().perform();
		//action.click(elemnt1).sendKeys("Container elements", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Assert.assertEquals(elemnt1.getText(), "Container elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele1 = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable1 = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele1.size()-1;i++) 
		{
			String aa = selectble_ele1.get(i).getText();
			selectable1.add(aa);
			if(selectable1.contains("DataDDL"))
			{
				assertTrue(true);
				
			}
			
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt2=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		//action.click(elemnt2).sendKeys("DataDDL", Keys.ENTER).build().perform();
		for(int i=1;i<=10;i++)
		{
			action.click(elemnt2).sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(1000);
			if(elemnt2.getText().equals("DataDDL"))
			{
				action.click(elemnt2).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				break;
			}
		}
		
		Assert.assertEquals(elemnt2.getText(), "DataDDL");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Select all visible items'])[1]");
		log.driver.findElement(By.xpath("(//button[@data-title='Select all visible items'])[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		Thread.sleep(3000);
		
		List<WebElement> Base_ele = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		int count=0;
		for (WebElement webElement : Base_ele)
		{
			//webElement.getText();
			count++;
		}
		System.out.println(count);
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt_Container=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		//action.click(elemnt_Container).sendKeys(Keys.ARROW_DOWN).build().perform();
		//action.click(elemnt_Container).sendKeys(Keys.ENTER).build().perform();
		//action.click(elemnt_Container).sendKeys("Container elements", Keys.ENTER).build().perform();
		for(int i=1;i<=10;i++)
		{
			action.click(elemnt_Container).sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(1000);
			if(elemnt_Container.getText().equals("Container elements"))
			{
				action.click(elemnt_Container).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				break;
			}
		}
		Assert.assertEquals(elemnt_Container.getText(), "Container elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='DataDDL']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='DataDDL']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='DataDDL']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='DataDDL']/../div[1]/input[1]")).isSelected());
		System.out.println("DataDDL Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[.='All Categories']/ancestor::div[3]/div[2]/div/div");
		List<WebElement> rowvaluetab = log.driver.findElements(By.xpath("//div[.='All Categories']/ancestor::div[3]/div[2]/div/div"));
		int counttab=1;
		for(int i=0;i<=rowvaluetab.size()-1;i++)
		{
			//System.out.println(rowvaluetab.get(i).getText());
			counttab++;
		}
		System.out.println("valueoftab"+counttab);
		
		if(count==counttab)
		{
			System.out.println(" values of the tab is matching with Data ddl value");
		}
		else
		{
			System.out.println("not Matching");
			
		}
		Assert.assertTrue(Base_ele.retainAll(rowvaluetab));
		System.out.println(" values of the tab is matching with Data ddl value");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[@id='tab_close_btn']");
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='No']");
		log.driver.findElement(By.xpath("//input[@value='No']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Manufacturer_Ranking']");
		log.driver.findElement(By.xpath("//span[text()='Manufacturer_Ranking']")).click();
        Thread.sleep(1000);

        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Manufacturer_Ranking'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Manufacturer_Ranking'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue1 = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
       try{
			for(int i=0;i<=SelectableElementvalue1.size()-1;i++)
			{
				String valueofcontainerele =SelectableElementvalue1.get(i).getText();
				System.out.println(valueofcontainerele);

				if(valueofcontainerele.contains("DataDDL"))
				{
					System.out.println("DataDDL is present");
					test.info("DataDDL is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='DataDDL']");
					log.driver.findElement(By.xpath("//span[text()='DataDDL']")).click();
					Thread.sleep(1000);
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Delete']");
					log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
					Thread.sleep(1000);
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Yes']");
					log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
					System.out.println("deletion done");
					break;
				}
				else
				{
					System.out.println("not found");
				}
				
			}
			
		}
		
		catch(Exception e)
		{
		System.out.println("Don't create container element");
		}
        Thread.sleep(1000);
		
    	waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		log.driver.close();
		
		
		
	}

}
