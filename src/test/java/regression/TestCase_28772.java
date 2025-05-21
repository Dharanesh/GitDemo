package regression;

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

public class TestCase_28772 extends TestUtils
{
	@Test	
	@Parameters("browser")
	public void Cockpit_DataView_Olap_Functions_ClientRules_CountSubsetElems(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_28772: Cockpit DataView Olap Functions for ClientRules_CountSubsetElems");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[text()='A - Training Sales']","ClientRules_CountSubsetElems_check",true);
		System.out.println("report created using A - Training Sales cube");
		test.info("report created using A - Training Sales cube");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("DataviewDesigner"));
		log.driver.findElement(By.xpath(log.getData("DataviewDesigner"))).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("DataviewDesigner"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("DataviewDesigner"))).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Timetype");
		System.out.println("Timetype is present in Rows");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(),"Measures");
		Thread.sleep(2000);		
		System.out.println("Measures is present in columns");
		
		//dragdrop timetype to background and time to row
		ui.dragAndDrop(log.driver.findElement(By.xpath(log.getData("Timetype"))), log.driver.findElement(By.xpath(log.getData("Background"))));
		Thread.sleep(4000);
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Product'])[1]")), log.driver.findElement(By.xpath(log.getData("Row"))));
		Thread.sleep(4000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		Thread.sleep(2000);
		
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e1.getText(), "Product");
		System.out.println("Elements groups displayed correctly");
		test.info("Elements groups displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Limits_Dropdown_Value"));
		WebElement e2=log.driver.findElement(By.xpath(log.getData("Limits_Dropdown_Value")));
		Assert.assertEquals(e2.getText(), "<No Limits>");
		System.out.println("Limits displayed correctly");
		test.info("Limits displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("CurrentSorting_Dropdown_Value"));
		WebElement e3=log.driver.findElement(By.xpath(log.getData("CurrentSorting_Dropdown_Value")));
		Assert.assertEquals(e3.getText(), "<No Sorting>");
		System.out.println("Current sorting displayed correctly");
		test.info("Current sorting displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Display_Dropdown_Value"));
		WebElement e4=log.driver.findElement(By.xpath(log.getData("Display_Dropdown_Value")));
		Assert.assertEquals(e4.getText(), "<Element Name>");
		System.out.println("Value present in Display displayed correctly");
		test.info("Value present in Display displayed correctly");
		
		List<WebElement> AB = log.driver.findElements(By.xpath(log.getData("Selection_Element_Window_Btns")));
		for (WebElement btn : AB) 
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		}
		
		
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Aston Martin'])[1]/../div[2]");
		log.driver.findElement(By.xpath("(//div[text()='Aston Martin'])[1]/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Cadillac'])[1]/../div[2]");
		log.driver.findElement(By.xpath("(//div[text()='Cadillac'])[1]/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Ferrari'])[1]/../div[2]");
		log.driver.findElement(By.xpath("//div[text()='Ferrari']/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Jaguar'])[1]/../div[2]");
		log.driver.findElement(By.xpath("//div[text()='Jaguar']/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Lamborghini'])[1]/../div[2]");
		log.driver.findElement(By.xpath("(//div[text()='Lamborghini'])[1]/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Lincoln'])[1]/../div[2]");
		log.driver.findElement(By.xpath("(//div[text()='Lincoln'])[1]/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Lotus'])[1]/../div[2]");
		log.driver.findElement(By.xpath("(//div[text()='Lotus'])[1]/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Maserati'])[1]/../div[2]");
		log.driver.findElement(By.xpath("(//div[text()='Maserati'])[1]/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Porsche'])[1]/../div[2]");
		log.driver.findElement(By.xpath("(//div[text()='Porsche'])[1]/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Rolls-Royce'])[1]/../div[2]");
		log.driver.findElement(By.xpath("(//div[text()='Rolls-Royce'])[1]/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div/div[2]");
		List<WebElement> Beforeselectble_ele_Count = log.driver.findElements(By.xpath("(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div/div[2]"));//step 24
		int count=Beforeselectble_ele_Count.size();
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
		
		//column add client rule
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Measures']");
		log.driver.findElement(By.xpath("//span[text()='Measures']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Purchase price']");
		log.driver.findElement(By.xpath("//div[text()='Purchase price']")).click();
		Thread.sleep(1000);
				
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='All groups/elements available']/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='All groups/elements available']/../../td[1]/input[@type='checkbox']")).isSelected(),true);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Groups']/ancestor::div[4]/div[2]/div[1]/div[1]/ul/li/div[1]/span[1]/span[2]");
		List<WebElement> Group1 = log.driver.findElements(By.xpath("//span[text()='Groups']/ancestor::div[4]/div[2]/div[1]/div[1]/ul/li/div[1]/span[1]/span[2]"));
		ArrayList<String> groupValue1= new ArrayList<String>();
		System.out.println("Group option values");
		groupValue1.add("Dimensiontree");
		groupValue1.add("Calculated elements");
		groupValue1.add("Container elements");
		groupValue1.add("Client Rules");

		for(int i =0;i<=Group1.size()-1;i++) 
		{
			assertEquals(Group1.get(i).getText(), groupValue1.get(i));
			System.out.println(Group1.get(i).getText());
		}

		test.info(" All 4 options are Present in group ");
		System.out.println("All 4 options are Present in group ");

		Thread.sleep(1000);
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Container elements'])[1]/ancestor::li[1]")).getCssValue("background-color"), "rgba(255, 212, 0, 1)", "container element got higlighted");
		System.out.println("Container Element got highlighted");
		test.info("Container Element got highlighted");
		
		Group1.get(Group1.size()-1).click();
		Thread.sleep(1000);
		
				
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue1 = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
       try{
			for(int i=0;i<=SelectableElementvalue1.size()-1;i++)
			{
				String valueofcontainerele =SelectableElementvalue1.get(i).getText();
				System.out.println(valueofcontainerele);

				if(valueofcontainerele.contains("CountSubsetElems"))
				{
					System.out.println("CountSubsetElems is present");
					test.info("CountSubsetElems is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='CountSubsetElems']");
					log.driver.findElement(By.xpath("//span[text()='CountSubsetElems']")).click();
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
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='New...']");
		log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Element']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='New Element']")).isDisplayed(),true);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Available element types:']/following::div[2]/div/div[1]");
		List<WebElement> ElementGrp1 = log.driver.findElements(By.xpath("//span[text()='Available element types:']/following::div[2]/div/div[1]"));
		ArrayList<String> ElegroupValue1= new ArrayList<String>();
		System.out.println("Element Group option values");
		ElegroupValue1.add("Dimension Rule");
		ElegroupValue1.add("Global Rule");
		Thread.sleep(1000);
		
		for(int i =0;i<=ElementGrp1.size()-1;i++) 
		{
			assertEquals(ElementGrp1.get(i).getText(), ElegroupValue1.get(i));
			System.out.println(ElementGrp1.get(i).getText());

		}
		Thread.sleep(1000);
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[1]")).getCssValue("background-color"), "rgba(255, 212, 0, 1)", "Criteria DDL got higlighted");
		System.out.println("Dimension Rule got highlighted");
		Thread.sleep(500);
		ElementGrp1.get(1).click();
		Thread.sleep(1000);
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[2]")).getCssValue("background-color"), "rgba(255, 212, 0, 1)", "container element got higlighted");
		System.out.println("Global Rule  got highlighted");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Client Rule']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath("//span[text()='Name:']/ancestor::div[3]/div[2]//input[1]")).sendKeys("CountSubsetElems");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Client Rule']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']/following::textarea[2]")).isEnabled(),true);
		Actions action=new Actions(log.driver);
		action.moveToElement(log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']/following::textarea[2]")));
		action.click();
		//string s="CountSubsetElems( "A - Training Sales.[Products].[Product]","Product.Manufacturer")"
		action.sendKeys("CountSubsetElems( \"A - Training Sales.[Products].[Product]\",\"Product.Manufacturer\" )");
		action.build().perform();
		Thread.sleep(2000);
	
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//button[text()='Check Syntax']");
		log.driver.findElement(By.xpath("//button[text()='Check Syntax']")).click();
		Thread.sleep(2000);
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Syntax is OK!']")).isDisplayed())
			{
				System.out.println("syntex found right");
			}
		}
		catch(Exception a)
		{
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//button[text()='Check Syntax']");
			log.driver.findElement(By.xpath("//button[text()='Check Syntax']")).click();
			Thread.sleep(2000);
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Syntax is OK!']");
			Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Syntax is OK!']")).isDisplayed());
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']")).isDisplayed())
			{
				waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
				log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
				Thread.sleep(2000);
			}
		}
		catch(Exception a)
		{
			System.out.println("ok clicked");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt11=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		action.click(elemnt11).sendKeys("Client Rules", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			String aa = selectble_ele.get(i).getText();
			selectable.add(aa);
			if(selectable.contains("CountSubsetElems"))
			{
				assertTrue(true);
				System.out.println("CountSubsetElems is available");
				
			}
			
		}
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='CountSubsetElems']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='CountSubsetElems']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='CountSubsetElems']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='CountSubsetElems']/../div[1]/input[1]")).isSelected());
		System.out.println("CountSubsetElems Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Deselect all visible items'])[2]");
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='CountSubsetElems'])[2]");
		log.driver.findElement(By.xpath("(//div[text()='CountSubsetElems'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Alias:']/following::div[4]/input");
		log.driver.findElement(By.xpath("//span[text()='Alias:']/following::div[4]/input")).sendKeys("SubsetElementCount");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed())
			{
				waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
				log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
				Thread.sleep(2000);
			}
		}
		catch(Exception a)
		{
			System.out.println("ok clicked");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
				
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Aston Martin'])[1]/ancestor::div[3]/div[3]/div/div");
		List<WebElement> TableColumnHdr = log.driver.findElements(By.xpath("(//div[text()='Aston Martin'])[1]/ancestor::div[3]/div[3]/div/div"));
		for (WebElement webElement : TableColumnHdr)
		{
			if(webElement.getText().equals("Purchase price")||webElement.getText().equals("SubsetElementCount"))
			{
				assertTrue(true);
			}
		}
		
		Thread.sleep(1000);
		
		System.out.println("column with the name SubsetElementCount");
		test.info("column with the name SubsetElementCount");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Aston Martin']/ancestor::div[4]/div/div[4]/div/div/div[2]");
		List<WebElement> CountVal = log.driver.findElements(By.xpath("//div[text()='Aston Martin']/ancestor::div[4]/div/div[4]/div/div/div[2]"));
		for (WebElement webElement : CountVal)
		{
			if(webElement.getText().equals("49.0"))
			{
				assertTrue(true);
			}
		}
		
		Thread.sleep(1000);
		
		log.driver.close();
		
		
	}
}
