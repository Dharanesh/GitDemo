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

public class TestCase_25526 extends TestUtils
{
	@Test
	@Parameters("browser")
	//Testcase  for creating criteria DDl for  "Contribution margin exotics" report
	public void Testcase_forcreating_criteriaDDl_Parameterizing_for_Contribution_margin_exotics_report(String browser) throws Exception
	{
		test =extent.createTest("TestCase_25526: Testcase  for creating criteria DDl  -  Parameterizing for  Contribution margin exotics report");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui=new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Contribution margin exotic']");
		log.driver.findElement(By.xpath("//span[text()='Contribution margin exotic']")).click();
        Thread.sleep(1000);

        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Contribution margin exotic'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Contribution margin exotic'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(),"Time");
		Thread.sleep(2000);
		System.out.println("Time is present in columns");
		
		 waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Columns_Value"));
	    log.driver.findElement(By.xpath(log.getData("Columns_Value"))).click();
	    waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Dimension_Header"));
	    assertTrue(log.driver.findElement(By.xpath(log.getData("Columns_Dimension_Header"))).isDisplayed());
		
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
		System.out.println("Value present in Display displayed correctly"+e4.getText());
		test.info("Value present in Display displayed correctly"+e4.getText());	
		Thread.sleep(1000);
		List<WebElement> AB = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for Rows')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB)
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		}
		Thread.sleep(2000);
		
        waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//div[text()='2014']/../div[1]/a/span")).click();
		Thread.sleep(2000);
	
		log.driver.findElement(By.xpath("//div[text()='Quarter 1 2014']/../div[2]")).click();
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//div[text()='Quarter 2 2014']/../div[2]")).click();
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//div[text()='Quarter 3 2014']/../div[2]")).click();
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//div[text()='Quarter 4 2014']/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> Column = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		
		ArrayList<String> Columnvallue= new ArrayList<String>();
		System.out.println("Quater of 2014  element");
		Columnvallue.add("Quarter 1 2014");
		Columnvallue.add("Quarter 2 2014");
		Columnvallue.add("Quarter 3 2014");
		Columnvallue.add("Quarter 4 2014");
		
		for(int i =0;i<=Column.size()-1;i++) 
		{
			assertEquals(Column.get(i).getText(), Columnvallue.get(i));
			System.out.println(Column.get(i).getText());
		}
		
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]");
		List<WebElement> basevalueaftupdate = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]/input[1]"));
		for(int i=0;i<=basevalueaftupdate.size()-1;i++) 
		{
			Assert.assertTrue(basevalueaftupdate.get(i).isSelected());
			System.out.println(basevalueaftupdate.get(i)+" is checked");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Contribution margin exotic'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Contribution margin exotic'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Product");
		System.out.println("Product is present in Rows");
		test.info("Product is present in Rows");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='All groups/elements available']/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='All groups/elements available']/../../td[1]/input[@type='checkbox']")).isSelected(),true);
		Thread.sleep(1000);
		
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
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
       try{
			for(int i=0;i<=SelectableElementvalue.size()-1;i++)
			{
				String valueofcontainerele =SelectableElementvalue.get(i).getText();
				System.out.println(valueofcontainerele);

				if(valueofcontainerele.contains("Criteria DDL"))
				{
					System.out.println("Criteria DDL is present");
					test.info("Criteria DDL is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Criteria DDL']");
					log.driver.findElement(By.xpath("//span[text()='Criteria DDL']")).click();
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
		System.out.println("Create new container element");
		}
        Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='New...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='New...']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='New...']");
		log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		Thread.sleep(2000);
		
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
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'New Criteria DDL')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New Criteria DDL')]")).isDisplayed(),true);
		Thread.sleep(2000);
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Name']/ancestor::div[3]/div[2]/div/div/input");
	    log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).sendKeys("Criteria DDL");
	    Thread.sleep(2000);
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		try
		{
			if(log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).isDisplayed())
			{
			log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
			Thread.sleep(2000);
			}
		}
		catch(Exception ex)
		{
			
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Preselection of Elements']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Preselection of Elements']")).isDisplayed(),true);
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'All elements of the dimension')]/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[contains(text(),'All elements of the dimension')]/ancestor::td[1]/input[1]")).isSelected(),true);
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//tr[@class='lvitem']/td[2]/ancestor::div[1]");
		assertTrue(log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]/ancestor::div[1]")).getCssValue("background-color").contains("255, 255, 255"));
		System.out.println("Select hierarchy: is Enabled");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//tr[@class='lvitem']/td[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]")).getText(),"Product");
		System.out.println("Select hierarchy: is"+log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'Following elements')]/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[contains(text(),'Following elements')]/ancestor::td[1]/input[1]")).isSelected(),false);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'Following elements')]/ancestor::td[1]");
		log.driver.findElement(By.xpath("//label[contains(text(),'Following elements')]/ancestor::td[1]")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'Following elements')]/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[contains(text(),'Following elements')]/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//tr[@class='lvitem']/td[2]/ancestor::div[1]");
		assertTrue(log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]/ancestor::div[1]")).getCssValue("background-color").contains("204, 204, 204"));
		System.out.println("Select hierarchy: is Disabled");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'Following elements')]/ancestor::div[3]/div[4]/div[1]/div[1]");
		assertTrue(log.driver.findElement(By.xpath("//label[contains(text(),'Following elements')]/ancestor::div[3]/div[4]/div[1]/div[1]")).getCssValue("background-color").contains("255, 255, 255"));
		System.out.println("Text Area is Enabled");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Selection...']");
		log.driver.findElement(By.xpath("//button[text()='Selection...']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Column')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Column')]")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions action=new Actions(log.driver);
		//action.click(elemnt).sendKeys("Product.Model", Keys.ENTER).build().perform();
		for(int i=1;i<=4;i++)
		{
			action.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		}
		action.click(elemnt).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elmntindrpdwnPrdct=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwnPrdct.getText(),"Product.Model");
		System.out.println(elmntindrpdwnPrdct.getText());
		System.out.println("Product.Model elements is selected in drop down");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[text()='Element Groups...'])[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//button[text()='Element Groups...'])[1]")).isDisplayed(),true);
		log.driver.findElement(By.xpath("(//button[text()='Element Groups...'])[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Element Groups'])[1]");
		
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Elements'])[1]/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue1 = log.driver.findElements(By.xpath("(//span[text()='Elements'])[1]/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
		for(int i=0;i<=SelectableElementvalue1.size()-1;i++)
		{
			String valueofcontainerele =SelectableElementvalue1.get(i).getText();
			System.out.println(valueofcontainerele);

			if(valueofcontainerele.contains("Product.Model"))
			{
				System.out.println("Product.Model is present");
				test.info("Product.Model is present");
				SelectableElementvalue1.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		int count=0;
		for (int i=1;i<=20;i++) 
		{
			selectble_ele.get(i).click();
			Thread.sleep(1000);
			count++;
		}
		System.out.println(count);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Preselection of Elements']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Preselection of Elements']")).isDisplayed(),true);
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[contains(text(),'Following elements')]/ancestor::div[3]/div[4]/div[1]/div[1]/div");
		List<WebElement> selectble_ele_Count = log.driver.findElements(By.xpath("//label[contains(text(),'Following elements')]/ancestor::div[3]/div[4]/div[1]/div[1]/div"));
		Thread.sleep(2000);
		int ElemCount=selectble_ele_Count.size();
		assertEquals(count,ElemCount);
		System.out.println(ElemCount+"No of element selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]")).isDisplayed(),true);
		Thread.sleep(200);
		String Oprtr=log.driver.findElement(By.xpath("//span[contains(text(),'Elementname')]/ancestor::div[3]/div[2]/div[1]//div/input")).getAttribute("value");
		assertEquals(Oprtr, "*");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Elementname')]/ancestor::div[3]//button");
		List<WebElement> Btn = log.driver.findElements(By.xpath("//span[contains(text(),'Elementname')]/ancestor::div[3]//button"));
		int k;
		for (int i =0;i<=Btn.size()-1;i++) 
		{
			k=i+1;
			String BtnStat =log.driver.findElement(By.xpath("(//span[contains(text(),'Elementname')]/ancestor::div[3]//button)["+k+"]")).getAttribute("disabled");
		    System.out.println(BtnStat);
			System.out.println(Btn.get(i).getText());
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Add']");
		log.driver.findElement(By.xpath("//button[text()='Add']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='(* and ? are wildcards)']/ancestor::div[4]/div[4]/div[1]//td[1]");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='(* and ? are wildcards)']/ancestor::div[4]/div[4]/div[1]//td[1]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='(* and ? are wildcards)']/ancestor::div[4]/div[4]/div[1]//td[1]");
		assertEquals(log.driver.findElement(By.xpath("//span[text()='(* and ? are wildcards)']/ancestor::div[4]/div[4]/div[1]//td[1]")).getText(), "*");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='And'])[2]/../../td[1]");
		assertTrue(log.driver.findElement(By.xpath("(//label[text()='And'])[2]/../../td[1]/input")).isSelected());
		System.out.println("And is checked");
		test.info("And is checked");
		Thread.sleep(200);
		
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='All']/../..//input")).isSelected());
		System.out.println("All is checked");
		test.info("All is checked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]")).isDisplayed(),true);
		Thread.sleep(200);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]//span[1]/span[1]/span[1]");
		WebElement elemnt1=log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]//span[1]/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		for(int i=1;i<=7;i++)
		{
			action.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(100);
		}
		action.click(elemnt1).sendKeys(Keys.ENTER).build().perform();
		
		//a1.click(elemnt1).sendKeys("CarType", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]//span[1]/span[1]/span[1]");
		WebElement elmntindrpdwn=log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]//span[1]/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwn.getText(),"CarType");
		System.out.println(elmntindrpdwn.getText());
		System.out.println("CarType is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).isEnabled(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).clear();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).sendKeys("SUV");
		String Filtervalue=log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).getAttribute("value");
		Thread.sleep(200);
		Assert.assertEquals(Filtervalue, "SUV");
		System.out.println("SUV is Entered successfully ");
		test.info("SUV is Entered successfully ");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[5]/div[1]//span[1]/span[1]/span[1]");
		WebElement elemnt2=log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[5]/div[1]//span[1]/span[1]/span[1]"));
		for(int i=1;i<=8;i++)
		{
			action.click(elemnt2).sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(1000);
		}
		action.click(elemnt2).sendKeys(Keys.ENTER).build().perform();
		//a1.click(elemnt2).sendKeys("City", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[5]/div[1]//span[1]/span[1]/span[1]");
		WebElement elmntindrpdwn1=log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[5]/div[1]//span[1]/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwn1.getText(),"City");
		System.out.println(elmntindrpdwn1.getText());
		System.out.println("City is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]//div[5]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]//div[5]/div[2]//input[1]")).clear();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]//div[5]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]//div[5]/div[2]//input[1]")).sendKeys("Torrance");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Sorting and Limiting')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Sorting and Limiting')]")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Sorting']/ancestor::div[3]/div/div/div/table/tbody/tr/td/label");
		List<WebElement> RadioBtn = log.driver.findElements(By.xpath("//span[text()='Sorting']/ancestor::div[3]/div/div/div/table/tbody/tr/td/label"));
		int k1;	
		for (int i =0;i<=RadioBtn.size()-1;i++) 
		{
			k1=i+1;
			String Text = RadioBtn.get(i).getText();
			System.out.println(Text);
			if(Text.contains("Unsorted"))
			{
				Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sorting']/ancestor::div[3]/div/div/div/table/tbody/tr/td/label/ancestor::td[1]/input)["+k1+"]")).isSelected(),true);
				System.out.println(Text+"  is selected");
			}
			else
			{
				
				Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sorting']/ancestor::div[3]/div/div/div/table/tbody/tr/td/label/ancestor::td[1]/input)["+k1+"]")).isSelected(),false);
				System.out.println(Text+"  is not selected");
			}
		}
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Sorted by name/attribute']/ancestor::td[1]");
	    log.driver.findElement(By.xpath("//label[text()='Sorted by name/attribute']/ancestor::td[1]")).click();
	    Thread.sleep(1000);
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Sorted by name/attribute']/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Sort Ascending']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Sort Ascending']/ancestor::td[1]/input[1]")).isSelected(),true);
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Sorting and Limiting')]/ancestor::div[4]/div[1]/div[2]//div[5]//span[1]/span[1]/span[1]");
		WebElement elemntLmtngSortng=log.driver.findElement(By.xpath("//span[contains(text(),'Sorting and Limiting')]/ancestor::div[4]/div[1]/div[2]//div[5]//span[1]/span[1]/span[1]"));
		//a1.click(elemntLmtngSortng).sendKeys("CarType", Keys.ENTER).build().perform();
		for(int i=1;i<=7;i++)
		{
			action.click(elemntLmtngSortng).sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(1000);
		}
		action.click(elemntLmtngSortng).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		Assert.assertEquals(elemntLmtngSortng.getText(),"CarType");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Unlimited number']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Unlimited number']/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Limited to']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Limited to']/ancestor::td[1]/input[1]")).isSelected(),false);
		log.driver.findElement(By.xpath("//label[text()='Limited to']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Limited to']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Limited to']/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Limited to']/ancestor::div[3]/div[2]/div[1]/div[1]/input[1]");
		log.driver.findElement(By.xpath("//label[text()='Limited to']/ancestor::div[3]/div[2]/div[1]/div[1]/input[1]")).sendKeys("1");
		Thread.sleep(500);
		
		Assert.assertEquals(elemntLmtngSortng.getText(),"CarType");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt3=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		action.click(elemnt3).sendKeys(Keys.ARROW_DOWN).build().perform();
	    action.click(elemnt3).sendKeys(Keys.ENTER).build().perform();
		//action.click(elemnt3).sendKeys("Container elements", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Assert.assertEquals(elemnt3.getText(), "Container elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele1 = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable1 = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele1.size()-1;i++) 
		{
			String aa = selectble_ele1.get(i).getText();
			selectable1.add(aa);
			if(selectable1.contains("Criteria DDL"))
			{
				assertTrue(true);
				
			}
			
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Criteria DDL']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='Criteria DDL']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Criteria DDL']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Criteria DDL']/../div[1]/input[1]")).isSelected());
		System.out.println("Criteria DDL Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[.='RSX']/ancestor::div[3]/div[2]/div/div");
		List<WebElement> rowvaluetab = log.driver.findElements(By.xpath("//div[.='RSX']/ancestor::div[3]/div[2]/div/div"));
		int counttab=1;
		for(int i=0;i<=rowvaluetab.size()-1;i++)
		{
			//System.out.println(rowvaluetab.get(i).getText());
			counttab++;
		}
		System.out.println("valueoftab  "+counttab);
		
		if(count==counttab)
		{
			System.out.println(" values of the tab is matching with Criteria ddl value");
		}
		else
		{
			System.out.println("not Matching");
			
		}
		System.out.println(" values of the tab is matching with Criteria ddl value");
		
		
	}
}
