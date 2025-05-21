package regression;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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

public class TestCase_28964 extends TestUtils
{
	@Test	
	@Parameters("browser")
	public void Cockpit_DataView_ClientRules_prioritycheck(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_28770: Cockpit_DataView_ClientRules_prioritycheck");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[text()='A - Training Sales']","ClientRules_SumOfSDL Exoten_check",true);
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		Thread.sleep(1000);
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
		Group.get(Group.size()-2).click();
		Thread.sleep(2000);
			
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
				Thread.sleep(1000);
			}

			else
			{
				System.out.println("Options are not greyedout");
				System.out.println(grpEleBtn1.get(i).getText());
				test.info(grpEleBtn1.get(i).getText()+"button not disabled");
				Thread.sleep(1000);
			}
		
		}
		
		Thread.sleep(1000);
		List<WebElement> AB1 = log.driver.findElements(By.xpath("//span[contains(text(),'Element Groups')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB1)
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		
		}
		
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
       try{
			for(int i=0;i<=SelectableElementvalue.size()-1;i++)
			{
				String valueofcontainerele =SelectableElementvalue.get(i).getText();
				System.out.println(valueofcontainerele);

				if(valueofcontainerele.contains("Exoten"))
				{
					System.out.println("Exoten is present");
					test.info("Exoten is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Exoten']");
					log.driver.findElement(By.xpath("//span[text()='Exoten']")).click();
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
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[1]")).getCssValue("background-color"), "rgba(255, 212, 0, 1)", "Criteria DDL got higlighted");
		System.out.println("Criteria DDL got highlighted");
		Thread.sleep(500);
		
		ElementGrp.get(ElementGrp.size()-1).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'New SDL')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New SDL')]")).isDisplayed(),true);
		Thread.sleep(2000);
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Name']/ancestor::div[3]/div[2]/div/div/input");
	    log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).sendKeys("Exoten");
	    Thread.sleep(2000);
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		try
		{
		  if(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed())
		  {
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
			log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
			Thread.sleep(2000);  
		  }
			  
		}catch(Exception e)
		{
			System.out.println("next clicked");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Selection']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Selection']")).isDisplayed(),true);
        
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Selection...']");
		log.driver.findElement(By.xpath("//button[text()='Selection...']")).click();
		
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
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Element Selection')]/ancestor::div[3]/div[2]//div[1]/div[1]//div[1]/div/div");
		List<WebElement> selectble_ele_Count = log.driver.findElements(By.xpath("//span[contains(text(),'Element Selection')]/ancestor::div[3]/div[2]//div[1]/div[1]//div[1]/div/div"));
		int ElemCount=selectble_ele_Count.size();
		assertEquals(count,ElemCount);
		System.out.println(ElemCount+"No of element selected");
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Selection']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Selection']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Activate aggregation'])[1]/../../td[1]");
		assertFalse(log.driver.findElement(By.xpath("(//label[text()='Activate aggregation'])[1]/../../td[1]/input")).isSelected());
		System.out.println("Activate aggregation is unchecked");
		test.info("Activate aggregation is unchecked");
		Thread.sleep(200);
		
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
		WebElement elemnt1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions action=new Actions(log.driver);
		action.click(elemnt1).sendKeys("Container elements", Keys.ENTER).build().perform();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele1 = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable1 = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele1.size()-1;i++) 
		{
			String aa = selectble_ele1.get(i).getText();
			selectable1.add(aa);
			if(selectable1.contains("Exoten"))
			{
				assertTrue(true);
				Thread.sleep(2000);
				
			}
			
		}
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Exoten']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='Exoten']/../div[1]")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Exoten']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Exoten']/../div[1]/input[1]")).isSelected());
		System.out.println("Exoten Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(2000);
		
		//client rule
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

				if(valueofcontainerele.contains("SumOfSDL Exoten"))
				{
					System.out.println("SumOfSDL Exoten is present");
					test.info("SumOfSDL Exoten is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='SumOfSDL Exoten']");
					log.driver.findElement(By.xpath("//span[text()='SumOfSDL Exoten']")).click();
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
		
		log.driver.findElement(By.xpath("//span[text()='Name:']/ancestor::div[3]/div[2]//input[1]")).sendKeys("SumOfSDL Exoten");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Client Rule']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']/following::textarea[2]")).isEnabled(),true);
		action.moveToElement(log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']/following::textarea[2]")));
		action.click();
		//string s="SumOfSDL( "A  - Training Sales.[Products].[Product]" , "Exoten")"
		action.sendKeys("SumOfSDL( \"A - Training Sales.[Products].[Product]\",\"Exoten\" )");
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
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
			if(selectable.contains("SumOfSDL Exoten"))
			{
				assertTrue(true);
				System.out.println("SumOfSDL Exoten is available");
				
			}
			
		}
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SumOfSDL Exoten']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='SumOfSDL Exoten']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SumOfSDL Exoten']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='SumOfSDL Exoten']/../div[1]/input[1]")).isSelected());
		System.out.println("SumOfSDL Exoten Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Deselect all visible items'])[2]");
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='SumOfSDL Exoten'])[2]");
		log.driver.findElement(By.xpath("(//div[text()='SumOfSDL Exoten'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
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
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys("1");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		//time column
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Measures'])[1]")), log.driver.findElement(By.xpath(log.getData("Background"))));
		Thread.sleep(2000);

		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Time'])[1]")), log.driver.findElement(By.xpath(log.getData("Columns"))));
		Thread.sleep(5000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(), "Time");

		System.out.println("Time is added in Columns");
		test.info("Time is added in Columns");
		
		log.driver.findElement(By.xpath(log.getData("Columns_Value"))).click();
		Thread.sleep(2000);
	    waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Dimension_Header"));
	    assertTrue(log.driver.findElement(By.xpath(log.getData("Columns_Dimension_Header"))).isDisplayed());
		
	    log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014'])[1]/ancestor::div[1]/div[1]//span[1]");
		log.driver.findElement(By.xpath("(//div[text()='2014'])[1]/ancestor::div[1]/div[1]//span[1]")).click();
		Thread.sleep(1000);
				
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Q1 2014'])[1]");
		log.driver.findElement(By.xpath("(//div[text()='Q1 2014'])[1]")).click();
		Thread.sleep(1000);	
				
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Q2 2014'])[1]");
		log.driver.findElement(By.xpath("(//div[text()='Q2 2014'])[1]")).click();
		Thread.sleep(1000);
		
		//add client rule
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='All groups/elements available']/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='All groups/elements available']/../../td[1]/input[@type='checkbox']")).isSelected(),true);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Groups']/ancestor::div[4]/div[2]/div[1]/div[1]/ul/li/div[1]/span[1]/span[2]");
		List<WebElement> Group11 = log.driver.findElements(By.xpath("//span[text()='Groups']/ancestor::div[4]/div[2]/div[1]/div[1]/ul/li/div[1]/span[1]/span[2]"));
		ArrayList<String> groupValue11= new ArrayList<String>();
		System.out.println("Group option values");
		groupValue11.add("Dimensiontree");
		groupValue11.add("Calculated elements");
		groupValue11.add("Container elements");
		groupValue11.add("Client Rules");

		for(int i =0;i<=Group11.size()-1;i++) 
		{
			assertEquals(Group11.get(i).getText(), groupValue11.get(i));
			System.out.println(Group11.get(i).getText());
		}

		test.info(" All 4 options are Present in group ");
		System.out.println("All 4 options are Present in group ");

		Thread.sleep(1000);
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Container elements'])[1]/ancestor::li[1]")).getCssValue("background-color"), "rgba(255, 212, 0, 1)", "container element got higlighted");
		System.out.println("Container Element got highlighted");
		test.info("Container Element got highlighted");
		
		Group11.get(Group11.size()-1).click();
		Thread.sleep(1000);
		
				
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue11 = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
       try{
			for(int i=0;i<=SelectableElementvalue11.size()-1;i++)
			{
				String valueofcontainerele =SelectableElementvalue11.get(i).getText();
				System.out.println(valueofcontainerele);

				if(valueofcontainerele.contains("Q1+Q2 Exoten"))
				{
					System.out.println("Q1+Q2 Exoten is present");
					test.info("Q1+Q2 Exoten is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Q1+Q2 Exoten']");
					log.driver.findElement(By.xpath("//span[text()='Q1+Q2 Exoten']")).click();
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
		List<WebElement> ElementGrp11 = log.driver.findElements(By.xpath("//span[text()='Available element types:']/following::div[2]/div/div[1]"));
		ArrayList<String> ElegroupValue11= new ArrayList<String>();
		System.out.println("Element Group option values");
		ElegroupValue11.add("Dimension Rule");
		ElegroupValue11.add("Global Rule");
		Thread.sleep(1000);
		
		for(int i =0;i<=ElementGrp11.size()-1;i++) 
		{
			assertEquals(ElementGrp11.get(i).getText(), ElegroupValue11.get(i));
			System.out.println(ElementGrp11.get(i).getText());

		}
		Thread.sleep(1000);
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[1]")).getCssValue("background-color"), "rgba(255, 212, 0, 1)", "Criteria DDL got higlighted");
		System.out.println("Dimension Rule got highlighted");
		Thread.sleep(500);
		ElementGrp11.get(1).click();
		Thread.sleep(1000);
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[2]")).getCssValue("background-color"), "rgba(255, 212, 0, 1)", "container element got higlighted");
		System.out.println("Global Rule  got highlighted");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Client Rule']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath("//span[text()='Name:']/ancestor::div[3]/div[2]//input[1]")).sendKeys("Q1+Q2 Exoten");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Client Rule']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']/following::textarea[2]")).isEnabled(),true);
		action.moveToElement(log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']/following::textarea[2]")));
		action.click();
		//string s="SumOfElems( "A -  Training Sales.[Time].[Time]","Q1 2014","Q2 2014"  )"
		action.sendKeys("SumOfElems( \"A - Training Sales.[Time].[Time]\",\"Q1 2014\",\"Q2 2014\" )");
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
		WebElement elemnt111=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		action.click(elemnt111).sendKeys("Client Rules", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele11 = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable11 = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele11.size()-1;i++) 
		{
			String aa = selectble_ele11.get(i).getText();
			selectable11.add(aa);
			if(selectable11.contains("Q1+Q2 Exoten"))
			{
				assertTrue(true);
				System.out.println("Q1+Q2 Exoten is available");
				
			}
			
		}
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Q1+Q2 Exoten']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='Q1+Q2 Exoten']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Q1+Q2 Exoten']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Q1+Q2 Exoten']/../div[1]/input[1]")).isSelected());
		System.out.println("Q1+Q2 Exoten Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Deselect all visible items'])[2]");
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Q1+Q2 Exoten'])[2]");
		log.driver.findElement(By.xpath("(//div[text()='Q1+Q2 Exoten'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed())
			{
				waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
				log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
				Thread.sleep(2000);
			}
			
		}catch(Exception e)
		{
			
		}
		
		//save the report
		 log.driver.findElement(By.xpath("//span[text()='Save']/following::span[1]")).click();
		 Thread.sleep(2000);
		 //Click Down and do Save As:====================
		 log.driver.findElement(By.xpath("//span[text()='Save As']")).click();
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Save Report window is displaying now.");
		
		 //Change Name:===========
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		 waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Name'])[1]/following::input[1]");
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Client Rules priority check");
		 Thread.sleep(500);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(1000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(1000);
		
		try
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'A report named')]")).isDisplayed();
			log.driver.findElement(By.xpath("//input[@value='OK']")).click();
			System.out.println("popup appeared");
		}
		catch(Exception e)
		{
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Client Rules priority check']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Client Rules priority check']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		
		
		
		log.driver.close();
		
	}
}
				
	