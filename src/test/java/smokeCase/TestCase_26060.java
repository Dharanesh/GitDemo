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



public class TestCase_26060 extends TestUtils
{
	@Test	
	@Parameters("browser")
	public void Testcase_Web_Cockpit_Calculated_Elements_MAXIMUM(String browser) throws Exception
	{
 
	    test =extent.createTest("TestCase_26060 : Web Cockpit Calculated Elements_MAXIMUM");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		String RowCelval;
		String RowReplaceVal = null;
		String calval_column =null;
		String replacevalue_Column = null;
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("SalesByCountry"));
		log.driver.findElement(By.xpath(log.getData("SalesByCountry"))).click();
        Thread.sleep(1000);
        waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("SalesByCountry_Header"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("SalesByCountry_Header"))).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("DataviewDesigner"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("DataviewDesigner"))).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Customer");
		System.out.println("Customer is present in Rows");
		
		ui.dragAndDrop(log.driver.findElement(By.xpath(log.getData("Customer"))), log.driver.findElement(By.xpath(log.getData("Background"))));
		Thread.sleep(4000);
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Category'])[2]")), log.driver.findElement(By.xpath(log.getData("Row"))));
		Thread.sleep(4000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Category");
		System.out.println("Category is present in rows");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Properties']");
		log.driver.findElement(By.xpath("//span[text()='Properties']")).click();
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Properties']")).isDisplayed(),true);
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(),"Time");
		Thread.sleep(2000);
		System.out.println("Time is present in columns");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		
		
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e1.getText(), "Category");
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
		Assert.assertEquals(e4.getText(), "Desc_EN");
		System.out.println("Value present in Display displayed correctly");
		test.info("Value present in Display displayed correctly");
		
		List<WebElement> AB = log.driver.findElements(By.xpath(log.getData("Selection_Element_Window_Btns")));
		for (WebElement btn : AB) 
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getText() + "    is displayed and Enabled");
			test.info(btn.getText() + "    is displayed and Enabled");
		}
	
		Thread.sleep(1000);
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("AllCategoryCB"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("AllCategory_Input_CB"))).isSelected());
		System.out.println("All Categories Checkbox is Selected in the list of base elements area");
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("InsertAllVisibleItem"));
		log.driver.findElement(By.xpath(log.getData("InsertAllVisibleItem"))).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("ElementGroup_Dropdown"));
		WebElement elemnt=log.driver.findElement(By.xpath(log.getData("ElementGroup_Dropdown")));
		Actions a1=new Actions(log.driver);
		/*a1.click(elemnt).sendKeys("Calculated elements", Keys.ENTER).build().perform();*/
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("ElementGroup_Dropdown"));
		WebElement elmntindrpdwn=log.driver.findElement(By.xpath(log.getData("ElementGroup_Dropdown")));
		Assert.assertEquals(elmntindrpdwn.getText(),"Calculated elements");
		System.out.println(elmntindrpdwn.getText());
		System.out.println("Calculated elements is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Selectable_Elemnts"));
		List<WebElement> selectble_ele = log.driver.findElements(By.xpath(log.getData("Selectable_Elemnts")));
		ArrayList<String> selectable = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			String aa = selectble_ele.get(i).getText();
			selectable.add(aa);
			if(selectable.contains("MAXIMUM"))
			{
				assertTrue(true);
				
			}
			
		}
			
		System.out.println("MAXIMUM is present in the list of selectable elements");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MAXIMUM']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='MAXIMUM']/../div[1]")).isDisplayed());
		System.out.println("MAXIMUM Checkbox is present in the list of selectable elements");
        
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
		type.add("MAXIMUM");
		type.add("DEVIATION (X-Y)");
		type.add("DEVIATION % (X-Y)/Y");
		type.add("DEVIATION % (X-Y)/|Y|");
		type.add("DEVIATION (Y-X)");
		type.add("DEVIATION % (Y-X)/X");
		type.add("DEVIATION % (Y-X)/|X|");
		type.add("QUOTIENT (X/Y)");
		type.add("QUOTIENT (Y/X)");
		type.add("PERCENTAGE");
		type.add("PERCENTAGE STACKED");
		type.add("RANK ASCENDING");
		type.add("RANK DESCENDING");
		type.add("ELEMENTCOUNT");
		type.add("MEDIAN");
		type.add("VARIANCE");
		type.add("STANDARD DEVIATION");
		
		System.out.println("ELements present in Selectable area are:  ");
		for(int i =0;i<=25;i++) 
		{
			Assert.assertEquals(selectble_ele.get(i).getText(),type.get(i));
			System.out.println(selectble_ele.get(i).getText());

			test.info(" MAXIMUM Position is correct");
		}

		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			Assert.assertEquals(selectble_ele.get(i).isSelected(), false);

		}
		System.out.println("checkboxes are unchecked");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MAXIMUM']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='MAXIMUM']/../div[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MAXIMUM']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='MAXIMUM']/../div[1]/input[1]")).isSelected());
		System.out.println("MAXIMUM Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		
		List<WebElement> Percentage = log.driver.findElements(By.xpath("//div[text()='MAXIMUM']/../div[1]/input"));
		for (int i = 0; i < Percentage.size(); i++) {
			
			assertTrue(Percentage.get(i).isSelected());
		}
		System.out.println("MAXIMUM is selected");			
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> el = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
			
		Assert.assertEquals(el.get(el.size()-1).getText(), "MAXIMUM");
						
		
		System.out.println("MAXIMUM is present at the last in base elements area");
		test.info("MAXIMUM is present at the last in base elements area");
        
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Quarter 1 2015']/following::div[6]/div/div[1]");
		List<WebElement> NoOfRows = log.driver.findElements(By.xpath("//div[text()='Quarter 1 2015']/following::div[6]/div/div[1]"));		
        Thread.sleep(2000);
		List<Float> Convertedvalue = new  ArrayList<Float>();
		
		for(int i=0;i<=NoOfRows.size()-2;i++)
		{
			RowCelval = NoOfRows.get(i).getText();
			 
			 for(int j=0;j<=NoOfRows.size()-1;j++)
			 {
				 RowReplaceVal= RowCelval.replaceAll("[€,]","");
			 }
			 System.out.println("Actual row value = "+RowCelval);
			 System.out.println("Converted row value= "+RowReplaceVal);
			 Float convertedrowvalue =Float.parseFloat(RowReplaceVal);
			 System.out.println("Parsedvalue = "+convertedrowvalue);
			 Convertedvalue.add(convertedrowvalue);
		}
		
		for(int k=0;k<=Convertedvalue.size()-1;k++)
		{
			System.out.println("Convertedvalue"+Convertedvalue.get(k));
		}
	  Thread.sleep(2000);
		Float minvalue_Actual = Convertedvalue.get(0);
		for(int i=1;i <=Convertedvalue.size()-1;i++)
		{
		    if(Convertedvalue.get(i) > minvalue_Actual)
		    {
		    	minvalue_Actual = Convertedvalue.get(i);
		    }
		   
		 }
		
		System.out.println("MAXIMUM"+minvalue_Actual);
		
		int Size =NoOfRows.size()-1;
		String MAX_Actual_1= NoOfRows.get(Size).getText();
		System.out.println(MAX_Actual_1); 
		String replaceActualvalue_1=MAX_Actual_1.replaceAll("[€,]","");
		
		Float convertedActualvalue_1 =Float.parseFloat(replaceActualvalue_1);
		System.out.println("MAXIMUM Actual"+convertedActualvalue_1);
		
		Assert.assertEquals(convertedActualvalue_1,minvalue_Actual);
		System.out.println("Passed for rows");
		
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(),"Time");
		Thread.sleep(2000);
	    System.out.println("Time is present in columns");	
					
	    waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Columns_Value"));
	    log.driver.findElement(By.xpath(log.getData("Columns_Value"))).click();
	    waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Dimension_Header"));
	    assertTrue(log.driver.findElement(By.xpath(log.getData("Columns_Dimension_Header"))).isDisplayed());
			
		WebElement e11=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e11.getText(), "Time");
		System.out.println("Elements groups displayed correctly");
		test.info("Elements groups displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Limits_Dropdown_Value"));
		WebElement e21=log.driver.findElement(By.xpath(log.getData("Limits_Dropdown_Value")));
		Assert.assertEquals(e21.getText(), "<No Limits>");
		System.out.println("Limits displayed correctly");
		test.info("Limits displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("CurrentSorting_Dropdown_Value"));
		WebElement e31=log.driver.findElement(By.xpath(log.getData("CurrentSorting_Dropdown_Value")));
		Assert.assertEquals(e31.getText(), "<No Sorting>");
		System.out.println("Current sorting displayed correctly");
		test.info("Current sorting displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Display_Dropdown_Value"));
		WebElement e41=log.driver.findElement(By.xpath(log.getData("Display_Dropdown_Value")));
		Assert.assertEquals(e41.getText(), "Desc_EN");
		System.out.println("Value present in Display displayed correctly");
		test.info("Value present in Display displayed correctly");		
		
		List<WebElement> AB1 = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for Rows')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB1) {
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		}
		Thread.sleep(1000);			
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("ElementGroup_Dropdown"));
		WebElement elemnt1=log.driver.findElement(By.xpath(log.getData("ElementGroup_Dropdown")));
		/*a1.click(elemnt1).sendKeys("Calculated elements", Keys.ENTER).build().perform();*/
		a1.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("ElementGroup_Dropdown"));
		WebElement elmntindrpdwn1=log.driver.findElement(By.xpath(log.getData("ElementGroup_Dropdown")));
		Assert.assertEquals(elmntindrpdwn1.getText(),"Calculated elements");
		System.out.println(elmntindrpdwn1.getText());
		System.out.println("Calculated elements is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Selectable_Elemnts"));
		List<WebElement> selectble_ele1 = log.driver.findElements(By.xpath(log.getData("Selectable_Elemnts")));
		ArrayList<String> selectable1 = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele1.size()-1;i++) 
		{
			String aa = selectble_ele1.get(i).getText();
			selectable1.add(aa);
			if(selectable1.contains("MAXIMUM"))
			{
				assertTrue(true);
				
			}
			
		}		
			
		System.out.println("MAXIMUM is present in the list of selectable elements");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MAXIMUM']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='MAXIMUM']/../div[1]")).isDisplayed());
		System.out.println("MAXIMUM Checkbox is present in the list of selectable elements");
        
		ArrayList<String > type1 = new ArrayList<String>();
		type1.add("-SEPARATOR-");
		type1.add("FORMULA");
		type1.add("MASHUP");
		type1.add("SUM");
		type1.add("DIFFERENCE");
		type1.add("PRODUCT");
		type1.add("PRODUCT (X*Y)");
		type1.add("AVERAGE");
		type1.add("MINIMUM");
		type1.add("MAXIMUM");
		type1.add("DEVIATION (X-Y)");
		type1.add("DEVIATION % (X-Y)/Y");
		type1.add("DEVIATION % (X-Y)/|Y|");
		type1.add("DEVIATION (Y-X)");
		type1.add("DEVIATION % (Y-X)/X");
		type1.add("DEVIATION % (Y-X)/|X|");
		type1.add("QUOTIENT (X/Y)");
		type1.add("QUOTIENT (Y/X)");
		type1.add("PERCENTAGE");
		type1.add("PERCENTAGE STACKED");
		type1.add("RANK ASCENDING");
		type1.add("RANK DESCENDING");
		type1.add("ELEMENTCOUNT");
		type1.add("MEDIAN");
		type1.add("VARIANCE");
		type1.add("STANDARD DEVIATION");
		
		System.out.println("ELements present in Selectable area are:  ");
		for(int i =0;i<=25;i++) 
		{
			Assert.assertEquals(selectble_ele1.get(i).getText(),type1.get(i));
			System.out.println(selectble_ele1.get(i).getText());

			test.info(" MAXIMUM Position is correct");
		}

		for (int i =0;i<=selectble_ele1.size()-1;i++) 
		{
			Assert.assertEquals(selectble_ele1.get(i).isSelected(), false);

		}
		System.out.println("checkboxes are unchecked");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MAXIMUM']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='MAXIMUM']/../div[1]")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MAXIMUM']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='MAXIMUM']/../div[1]/input[1]")).isSelected());
		System.out.println("MAXIMUM Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(2000);
		List<WebElement> Product = log.driver.findElements(By.xpath("//div[text()='MAXIMUM']/../div[1]/input"));
		for (int i = 0; i < Product.size(); i++) {
			
			assertTrue(Product.get(i).isSelected());
		}
		System.out.println("MAXIMUM is selected");			
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> el1 = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
		
		Assert.assertEquals(el1.get(el1.size()-1).getText(), "MAXIMUM");
		
		System.out.println("MAXIMUM is present at the last in base elements area");
		test.info("MAXIMUM is present at the last in base elements area");
        
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Quarter 1 2015']/following::div[8]/div");
		List<WebElement> NOOfColumn = log.driver.findElements(By.xpath("//div[text()='Quarter 1 2015']/following::div[8]/div"));

		int Sizeofcell_1 = NOOfColumn.size()-1;
		List<Float> Convertedvalue_1 = new  ArrayList<Float>();
	
		for(int i=0;i<=NOOfColumn.size()-2;i++)
		{
			calval_column = NOOfColumn.get(i).getText();
	
		 
		 for(int j=0;j<=NOOfColumn.size()-1;j++)
		 {
			 replacevalue_Column= calval_column.replaceAll("[€,]","");
		 }
		 
		System.out.println("Actual column value = "+calval_column);
		System.out.println("Converted column value= "+replacevalue_Column);
		Float convertedcolumnvalue =Float.parseFloat(replacevalue_Column);
		System.out.println("Parsedvalue = "+convertedcolumnvalue);
		Convertedvalue_1.add(convertedcolumnvalue);
	}
	
	Thread.sleep(2000);
	for(int k=0;k<=Convertedvalue_1.size()-1;k++)
	{
		System.out.println("Converted column value"+Convertedvalue_1.get(k));
	}

	Float Minvalue = Convertedvalue_1.get(0);
	for(int i=1;i <=Convertedvalue_1.size()-1;i++)
	{
	    if(Convertedvalue_1.get(i) > Minvalue)
	    {
	    	Minvalue = Convertedvalue_1.get(i);
	    }
	    
	}
	
       System.out.println("MAXIMUM"+Minvalue);
	  
		//last row value
		int Size_1 =NOOfColumn.size()-1;
		String MIN_Actual= NOOfColumn.get(Size_1).getText();
		System.out.println(MIN_Actual); 
		String replaceActualvalue=MIN_Actual.replaceAll("[€,]","");
		
		Float convertedActualvalue =Float.parseFloat(replaceActualvalue);
		System.out.println(convertedActualvalue);
		Assert.assertEquals(convertedActualvalue, Minvalue);
		
	    System.out.println("Passed for columns");
	    log.driver.close();
	}
}
