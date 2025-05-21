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



public class TestCase_25882  extends TestUtils
{
	
	@Test	
	@Parameters("browser")
	public void Testcase_Web_Cockpit_Calculated_Elements_PRODUCT(String browser) throws Exception
	{
 
	    test =extent.createTest("TestCase_25882 : Web Cockpit Calculated Elements_PRODUCT");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		String RowCellVal=null;
		String replacevalue=null;
		String ColumnValue =null;
		String replacevalue_Column = null;
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("SalesByCountry"));
		log.driver.findElement(By.xpath(log.getData("SalesByCountry"))).click();
        Thread.sleep(2000);
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
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Properties']")).isDisplayed(),true);
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
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
	

		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("AllCategoryCB"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("AllCategory_Input_CB"))).isSelected());
		System.out.println("All Categories Checkbox is Selected in the list of Selected elements area");
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes only selected items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes only selected items from the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Used Car']");
		log.driver.findElement(By.xpath("//div[text()='Used Car']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='New Car']");
		log.driver.findElement(By.xpath("//div[text()='New Car']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Company Car']");
		log.driver.findElement(By.xpath("//div[text()='Company Car']")).click();
		Thread.sleep(2000);
	
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
			if(selectable.contains("PRODUCT"))
			{
				assertTrue(true);
				
			}
			
		}	
			
		System.out.println("PRODUCT is present in the list of selectable elements");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='PRODUCT']/../div[1]")).isDisplayed());
		System.out.println("PRODUCT Checkbox is present in the list of selectable elements");
        
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

			test.info(" PRODUCT Position is correct");
		}
        Thread.sleep(2000);
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			Assert.assertEquals(selectble_ele.get(i).isSelected(), false);

		}
		System.out.println("checkboxes are unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='PRODUCT']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='PRODUCT']/../div[1]/input[1]")).isSelected());
		System.out.println("PRODUCT Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(2000);
		List<WebElement> Percentage = log.driver.findElements(By.xpath("//div[text()='PRODUCT']/../div[1]/input"));
		for (int i = 0; i < Percentage.size(); i++) {
			
			assertTrue(Percentage.get(i).isSelected());
		}
		System.out.println("PRODUCT is selected");			
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> el = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
		
		Assert.assertEquals(el.get(el.size()-1).getText(), "PRODUCT");
						
		
		System.out.println("PRODUCT is present at the last in Selected elements area");
		test.info("PRODUCT is present at the last in Selected elements area");
        
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Quarter 1 2015']/following::div[6]/div/div[1]");
		List<WebElement> NoOfRows = log.driver.findElements(By.xpath("//div[text()='Quarter 1 2015']/following::div[6]/div/div[1]"));
		Float Product =1.0f;
		System.out.println("Total no of rows========="+NoOfRows.size());
		for(int i=0;i<=NoOfRows.size()-2;i++)
		{
			RowCellVal = NoOfRows.get(i).getText();
		
			 for(int j=0;j<=NoOfRows.size()-1;j++)
			 {
			 replacevalue= RowCellVal.replaceAll("[€,]","");
			
			 }
			 System.out.println();
			 System.out.println("original Cell Value= "+RowCellVal);
			 System.out.println("Replcaed Cell Value = "+replacevalue);
			 
			 Float convertedvalue =Float.parseFloat(replacevalue);
			 System.out.println("Parsed Cell Value = "+convertedvalue);
			 
			 Product= Product*convertedvalue;
			 System.out.println("Product = "+Product);
			 
		}
		
		int Size =NoOfRows.size()-1;
		String ActualProductValue= NoOfRows.get(Size).getText();
		System.out.println(ActualProductValue); 
		String replaceActualvalue=ActualProductValue.replaceAll("[€,]","");
		System.out.println("Replaced Actual Product Value ="+replaceActualvalue);
		
		Float convertedActualvalue =Float.parseFloat(replaceActualvalue);
		System.out.println(convertedActualvalue);
		String value1=Product.toString();
		String value2=convertedActualvalue.toString();
		
		Assert.assertTrue(value1.contains(value2.substring(0, 7)));
		System.out.println(value2.substring(0, 7));
		System.out.println("Passed for Rows");	
		
		
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
		Thread.sleep(2000);
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
			if(selectable1.contains("PRODUCT"))
			{
				assertTrue(true);
				
			}
			
		}
		System.out.println("PRODUCT is present in the list of selectable elements");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='PRODUCT']/../div[1]")).isDisplayed());
		System.out.println("PRODUCT Checkbox is present in the list of selectable elements");
	    
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
		
		Thread.sleep(2000);
		System.out.println("ELements present in Selectable area are:  ");
		for(int i =0;i<=8;i++) 
		{
			Assert.assertEquals(selectble_ele1.get(i).getText(),type1.get(i));
			System.out.println(selectble_ele1.get(i).getText());

			test.info("PRODUCT Position is correct");
		}

		for (int i =0;i<=selectble_ele1.size()-1;i++) 
		{
			Assert.assertEquals(selectble_ele1.get(i).isSelected(), false);

		}
		System.out.println("checkboxes are unchecked");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='PRODUCT']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='PRODUCT']/../div[1]/input[1]")).isSelected());
		System.out.println("PRODUCT Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		
		List<WebElement> Sum = log.driver.findElements(By.xpath("//div[text()='PRODUCT']/../div[1]/input"));
		for (int i = 0; i < Sum.size(); i++) {
			
			assertTrue(Sum.get(i).isSelected());
		}
		System.out.println("PRODUCT is selected");			
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> el1 = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
			
		Assert.assertEquals(el1.get(el1.size()-1).getText(), "PRODUCT");
						
		System.out.println("PRODUCT is present a the last in Selected elements area");
		test.info("PRODUCT is present a the last in Selected elements area");
	    
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Quarter 1 2015']/following::div[8]/div");
		List<WebElement> NoOfColumn = log.driver.findElements(By.xpath("//div[text()='Quarter 1 2015']/following::div[8]/div"));
		Float Product_1 =1.0f;
		int ColumnSIze = NoOfColumn.size()-1;
		System.out.println(ColumnSIze);
		for(int i=0;i<=NoOfColumn.size()-2;i++)
		{
			 ColumnValue = NoOfColumn.get(i).getText();
			 
			 for(int j=0;j<=NoOfColumn.size()-1;j++)
			 {
				 replacevalue_Column= ColumnValue.replaceAll("[€,]","");
			
			 }
			 System.out.println("Actual Column Value = "+ColumnValue);
			 System.out.println("Converted Column Value = "+replacevalue_Column);
			 Float ConvertedColumnValue =Float.parseFloat(replacevalue_Column);
			 System.out.println("Parsedvalue = "+ConvertedColumnValue);
			 
			 Product_1= Product_1*ConvertedColumnValue;
			 System.out.println("Product = "+Product_1);
		
		}
		Thread.sleep(1000);
		String Avg_Actual_1= NoOfColumn.get(ColumnSIze).getText();
		System.out.println(Avg_Actual_1); 
		String replaceActualvalue_1=Avg_Actual_1.replaceAll("[€,]","");
		System.out.println("replacement = "+replaceActualvalue_1);
		
		Float convertedActualvalue_1 =Float.parseFloat(replaceActualvalue_1);
		System.out.println("COnverted="+convertedActualvalue_1);
		
		String value1_row=Product_1.toString();
	    String value2_row=convertedActualvalue_1.toString();
			
		Assert.assertTrue(value1_row.contains(value2_row.substring(0, 7)));
		System.out.println(value2_row.substring(0, 7));
	    System.out.println("Passed For Column");
		
		log.driver.close();
		
		
		
	}
}
