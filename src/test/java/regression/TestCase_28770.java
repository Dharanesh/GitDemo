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

public class TestCase_28770 extends TestUtils
{
	@Test	
	@Parameters("browser")

	public void Cockpit_DataView_Olap_Functions_ClientRules_CountDDLElems(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_28770: Cockpit DataView Olap Functions for ClientRules_CountDDLElems");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[text()='A - Training Sales']","ClientRules_CountDDLElems_check",true);
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

				if(valueofcontainerele.contains("Muster - BMW Touring"))
				{
					System.out.println("Muster - BMW Touring is present");
					test.info("Muster - BMW Touring is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Muster - BMW Touring']");
					log.driver.findElement(By.xpath("//span[text()='Muster - BMW Touring']")).click();
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
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[1]")).getCssValue("background-color"), "rgb(255, 212, 0)", "Criteria DDL got higlighted");
		System.out.println("Criteria DDL got highlighted");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'New Criteria DDL')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New Criteria DDL')]")).isDisplayed(),true);
		Thread.sleep(2000);
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Name']/ancestor::div[3]/div[2]/div/div/input");
	    log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).sendKeys("Muster - BMW Touring");
	    Thread.sleep(2000);
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).isDisplayed())
			{
				waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
				log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
				Thread.sleep(2000);
			}
		}
		catch(Exception a)
		{
			System.out.println("next clicked");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Preselection of Elements']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Preselection of Elements']")).isDisplayed(),true);
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'All elements of the dimension')]/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[contains(text(),'All elements of the dimension')]/ancestor::td[1]/input[1]")).isSelected(),true);
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//tr[@class='lvitem']/td[2]/ancestor::div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]/ancestor::div[1]")).getCssValue("background-color"),"rgba(255, 255, 255, 1)");
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
		Assert.assertEquals(log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]/ancestor::div[1]")).getCssValue("background-color"),"rgba(204, 204, 204, 1)");
		System.out.println("Select hierarchy: is Disabled");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'Following elements')]/ancestor::div[3]/div[4]/div[1]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[contains(text(),'Following elements')]/ancestor::div[3]/div[4]/div[1]/div[1]")).getCssValue("background-color"),"rgba(255, 255, 255, 1)");
		System.out.println("Text Area is Enabled");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Selection...']");
		log.driver.findElement(By.xpath("//button[text()='Selection...']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Column')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Column')]")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='BMW'])[1]");
		log.driver.findElement(By.xpath("(//div[text()='BMW'])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> el = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
		
		for (int i = 0; i<el.size()-1; i++)
		{	
			Assert.assertEquals(el.get(el.size()-1).getText(), "BMW");
			
		}
		int count=el.size();
		System.out.println(count);
		System.out.println("BMW is present a the last in base elements area");
		test.info("BMW is present a the last in base elements area");
		
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
		
		selectble_ele_Count.get(selectble_ele_Count.size()-1).click();
		Thread.sleep(2000);
		
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='(* and ? are wildcards)']/ancestor::div[4]/div[4]/div[1]//td[1]");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='(* and ? are wildcards)']/ancestor::div[4]/div[4]/div[1]//td[1]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='(* and ? are wildcards)']/ancestor::div[4]/div[4]/div[1]//td[1]");
		assertEquals(log.driver.findElement(By.xpath("//span[text()='(* and ? are wildcards)']/ancestor::div[4]/div[4]/div[1]//td[1]")).getText(), "*");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='And'])[2]/../../td[1]");
		assertTrue(log.driver.findElement(By.xpath("(//label[text()='And'])[2]/../../td[1]/input")).isSelected());
		System.out.println("And is checked");
		test.info("And is checked");
		Thread.sleep(200);
		
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='N-Elements']/../..//input")).isSelected());
		System.out.println("N-Elements is checked");
		test.info("N-Elements is checked");
		
		assertTrue(log.driver.findElement(By.xpath("//label[text()='S-Elements']/../..//input")).isSelected());
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='S-Elements']");
		log.driver.findElement(By.xpath("//label[text()='S-Elements']")).click();
		Thread.sleep(200);
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='S-Elements']/../..//input")).isSelected());
		System.out.println("S-Elements is unchecked");
		test.info("S-Elements is unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='C-Elements']");
		assertTrue(log.driver.findElement(By.xpath("//label[text()='C-Elements']/../..//input")).isSelected());
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='C-Elements']");
		log.driver.findElement(By.xpath("//label[text()='C-Elements']")).click();
		Thread.sleep(200);
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='C-Elements']/../..//input")).isSelected());
		System.out.println("C-Elements is unchecked");
		test.info("C-Elements is unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='R-Elements']");
		assertTrue(log.driver.findElement(By.xpath("//label[text()='R-Elements']/../..//input")).isSelected());
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='R-Elements']");
		log.driver.findElement(By.xpath("//label[text()='R-Elements']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='R-Elements']");
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='R-Elements']/../..//input")).isSelected());
		
		System.out.println("s,c and R element is unchecked");
		test.info("s,c and R element is unchecked");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]")).isDisplayed(),true);
		Thread.sleep(200);

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]//span[1]/span[1]/span[1]");
		WebElement elemnt=log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]//span[1]/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		a1.click(elemnt).sendKeys("Unique name", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]//span[1]/span[1]/span[1]");
		WebElement elmntindrpdwn=log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]//span[1]/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwn.getText(),"Unique name");
		System.out.println(elmntindrpdwn.getText());
		System.out.println("Unique name is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).isEnabled(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).clear();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).sendKeys("*Touring*");
		String Filtervalue=log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).getAttribute("value");
		Thread.sleep(200);
		Assert.assertEquals(Filtervalue, "*Touring*");
		System.out.println("*Touring* is Entered successfully ");
		test.info("*Touring* is Entered successfully ");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Unlimited number']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Unlimited number']/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Limited to']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Limited to']/ancestor::td[1]/input[1]")).isSelected(),false);
		
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
		a1.click(elemnt1).sendKeys("Container elements", Keys.ENTER).build().perform();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele1 = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable1 = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele1.size()-1;i++) 
		{
			String aa = selectble_ele1.get(i).getText();
			selectable1.add(aa);
			if(selectable1.contains("Muster - BMW Touring"))
			{
				assertTrue(true);
				Thread.sleep(2000);
				
			}
			
		}
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Muster - BMW Touring']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='Muster - BMW Touring']/../div[1]")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Muster - BMW Touring']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Muster - BMW Touring']/../div[1]/input[1]")).isSelected());
		System.out.println("Muster - BMW Touring Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
		
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']/following::div[5]/div[5]/div/div/button");
		List<WebElement> grpEleBtn11 = log.driver.findElements(By.xpath("//span[text()='Element Groups']/following::div[5]/div[5]/div/div/button"));
		for(int i =0;i<=grpEleBtn11.size()-1;i++) 
		{
			String value1 = grpEleBtn11.get(i).getCssValue("disabled");
			System.out.println(value1);

			if(value1.contains("true"))
			{
				System.out.println(grpEleBtn11.get(i).getText());
				test.info(grpEleBtn11.get(i).getText()+"button disabled");
				Thread.sleep(1000);
			}

			else
			{
				System.out.println("Options are not greyedout");
				System.out.println(grpEleBtn11.get(i).getText());
				test.info(grpEleBtn11.get(i).getText()+"button not disabled");
				Thread.sleep(1000);
			}
		
		}
		
		Thread.sleep(1000);
		List<WebElement> AB2 = log.driver.findElements(By.xpath("//span[contains(text(),'Element Groups')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB2)
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		
		}
		
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue1 = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
       try{
			for(int i=0;i<=SelectableElementvalue1.size()-1;i++)
			{
				String valueofcontainerele =SelectableElementvalue1.get(i).getText();
				System.out.println(valueofcontainerele);

				if(valueofcontainerele.contains("CountDDLElems"))
				{
					System.out.println("CountDDLElems is present");
					test.info("CountDDLElems is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='CountDDLElems']");
					log.driver.findElement(By.xpath("//span[text()='CountDDLElems']")).click();
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
		
		log.driver.findElement(By.xpath("//span[text()='Name:']/ancestor::div[3]/div[2]//input[1]")).sendKeys("CountDDLElems");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit Client Rule']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']/following::textarea[2]")).isEnabled(),true);
		Actions action = new Actions(log.driver);
		action.moveToElement(log.driver.findElement(By.xpath("//span[text()='Edit Client Rule']/following::textarea[2]")));
		action.click();
		//string s="CountDDLElems( "A - Training Sales.[Products].[Product]","Muster - BMW Touring")"
		action.sendKeys("CountDDLElems( \"A - Training Sales.[Products].[Product]\",\"Muster - BMW Touring\" )");
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
			if(selectable.contains("CountDDLElems"))
			{
				assertTrue(true);
				System.out.println("CountDDLElems is available");
				
			}
			
		}
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='CountDDLElems']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='CountDDLElems']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='CountDDLElems']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='CountDDLElems']/../div[1]/input[1]")).isSelected());
		System.out.println("CountDDLElems Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Deselect all visible items'])[2]");
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='CountDDLElems'])[2]");
		log.driver.findElement(By.xpath("(//div[text()='CountDDLElems'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Alias:']/following::div[4]/input");
		log.driver.findElement(By.xpath("//span[text()='Alias:']/following::div[4]/input")).sendKeys("DDLElementCount");
		
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Acura'])[1]/ancestor::div[3]/div[3]/div/div");
		List<WebElement> TableColumnHdr = log.driver.findElements(By.xpath("(//div[text()='Acura'])[1]/ancestor::div[3]/div[3]/div/div"));
		for (WebElement webElement : TableColumnHdr)
		{
			if(webElement.getText().equals("Purchase price")||webElement.getText().equals("DDLElementCount"))
			{
				assertTrue(true);
			}
		}
		
		Thread.sleep(1000);
		
		System.out.println("column with the name DDLElementCount");
		test.info("column with the name DDLElementCount");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
