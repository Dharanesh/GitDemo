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




public class TestCase_25883 extends TestUtils
{
	@Test	
	@Parameters("browser")
	public void Testcase_Web_Cockpit_Calculated_Elements_PRODUCT_XY(String browser) throws Exception
	{
 
	    test =extent.createTest("TestCase_25883 : Web Cockpit Calculated Elements_PRODUCT(X*Y)");
	    
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,log.getData("Row_Value"));
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
			
	
		Thread.sleep(1000);
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("AllCategoryCB"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("AllCategory_Input_CB"))).isSelected());
		System.out.println("All Categories Checkbox is Selected in the list of base elements area");
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts all visible items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
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
			if(selectable.contains("PRODUCT (X*Y)"))
			{
				assertTrue(true);
				
			}
			
		}
		Thread.sleep(1000);
		System.out.println("PRODUCT (X*Y) is present in the list of selectable elements");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT (X*Y)']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='PRODUCT (X*Y)']/../div[1]")).isDisplayed());
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
		
		Thread.sleep(500);
		System.out.println("ELements present in Selectable area are:  ");
		for(int i =0;i<=8;i++) 
		{
			Assert.assertEquals(selectble_ele.get(i).getText(),type.get(i));
			System.out.println(selectble_ele.get(i).getText());

			test.info(" PRODUCT (X*Y) Position is correct");
		}

		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			Assert.assertEquals(selectble_ele.get(i).isSelected(), false);

		}
		System.out.println("checkboxes are unchecked");
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT (X*Y)']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='PRODUCT (X*Y)']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT (X*Y)']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='PRODUCT (X*Y)']/../div[1]/input[1]")).isSelected());
		System.out.println("PRODUCT (X*Y) Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		List<WebElement> Percentage = log.driver.findElements(By.xpath("//div[text()='PRODUCT (X*Y)']/../div[1]/input"));
		for (int i = 0; i < Percentage.size(); i++) 
		{
			
			assertTrue(Percentage.get(i).isSelected());
		}
		System.out.println("PRODUCT (X*Y) is selected");			
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> el = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
		
		Thread.sleep(500);
		Assert.assertEquals(el.get(el.size()-1).getText(), "PRODUCT (X*Y)");
		
		System.out.println("PRODUCT (X*Y) is present at the last in base elements area");
		test.info("PRODUCT (X*Y) is present at the last in base elements area");
        
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Quarter 1 2015']/following::div[6]/div/div[1]");
		List<WebElement> NoOfRow = log.driver.findElements(By.xpath("//div[text()='Quarter 1 2015']/following::div[6]/div/div[1]"));
		Float product =1.0f;
		int Sizeofcell = NoOfRow.size()-1;
		System.out.println(Sizeofcell);
	
	
		for(int i=3;i<=NoOfRow.size()-2;i++)
		{
			 RowCelval = NoOfRow.get(i).getText();
		
			 
			 for(int j=0;j<=NoOfRow.size()-1;j++)
			 {
				 RowReplaceVal= RowCelval.replaceAll("[€,]","");
			
			 }
			 System.out.println();
			 System.out.println("Actual row Value = "+RowCelval);
			 System.out.println("Converted row Value= "+RowReplaceVal);
			 Float convertedRowCelvalue =Float.parseFloat(RowReplaceVal);
			 System.out.println("Parsedvalue row value = "+convertedRowCelvalue);
			 
			 product= product*convertedRowCelvalue;
			 System.out.println("Product = "+product);	 
		}
		
        Thread.sleep(1000);
		int Size =NoOfRow.size()-1;
		String Product_Actual= NoOfRow.get(Size).getText();
		System.out.println(Product_Actual); 
		String ReplaceActualvalue=Product_Actual.replaceAll("[€,]","");
		System.out.println("final column value ="+ReplaceActualvalue);
		
		Float convertedActualvalue =Float.parseFloat(ReplaceActualvalue);
		System.out.println(convertedActualvalue);
		String value1=product.toString();
	    String value2=	 convertedActualvalue.toString();
	
		Assert.assertTrue(value1.contains(value2.substring(0, 7)));
		System.out.println(value2.substring(0, 7));
		System.out.println("Passed for rows");
	
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
	    Thread.sleep(500);	
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
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele1 = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable1 = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele1.size()-1;i++) 
		{
			String aa = selectble_ele1.get(i).getText();
			selectable1.add(aa);
			if(selectable1.contains("PRODUCT (X*Y)"))
			{
				assertTrue(true);
				
			}
			
		}	
			
		System.out.println("PRODUCT (X*Y) is present in the list of selectable elements");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT (X*Y)']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='PRODUCT (X*Y)']/../div[1]")).isDisplayed());
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
		Thread.sleep(500);
		
		System.out.println("ELements present in Selectable area are:  ");
		for(int i =0;i<=8;i++) 
		{
			Assert.assertEquals(selectble_ele1.get(i).getText(),type1.get(i));
			System.out.println(selectble_ele1.get(i).getText());

			test.info(" PRODUCT (X*Y) Position is correct");
		}
      Thread.sleep(1000);
		for (int i =0;i<=selectble_ele1.size()-1;i++) 
		{
			Assert.assertEquals(selectble_ele1.get(i).isSelected(), false);

		}
		System.out.println("checkboxes are unchecked");
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT (X*Y)']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='PRODUCT (X*Y)']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PRODUCT (X*Y)']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='PRODUCT (X*Y)']/../div[1]/input[1]")).isSelected());
		System.out.println("PRODUCT (X*Y) Checkbox is Selected in the list of selectable elements");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		
		List<WebElement> Product = log.driver.findElements(By.xpath("//div[text()='PRODUCT (X*Y)']/../div[1]/input"));
		for (int i = 0; i < Product.size(); i++) {
			
			assertTrue(Product.get(i).isSelected());
		}
		System.out.println("PRODUCT (X*Y) is selected");			
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> el1 = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
		
	
		Assert.assertEquals(el1.get(el1.size()-1).getText(), "PRODUCT (X*Y)");
		
		System.out.println("PRODUCT (X*Y) is present at the last in base elements area");
		test.info("PRODUCT (X*Y) is present at the last in base elements area");
        
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Quarter 1 2015']/following::div[8]/div");
		List<WebElement> NoOfcolmn = log.driver.findElements(By.xpath("//div[text()='Quarter 1 2015']/following::div[8]/div"));
	    Float Product1 =1.0f;
	    int Sizeofcell_1 = NoOfcolmn.size()-1;
	    System.out.println(Sizeofcell_1);
		for(int i=2;i<=NoOfcolmn.size()-2;i++)
		{
		 calval_column = NoOfcolmn.get(i).getText();
		
		 for(int j=0;j<=NoOfcolmn.size()-1;j++)
		 {
			 replacevalue_Column= calval_column.replaceAll("[€,]","");
		
		 }
		 System.out.println("Actual column value = "+calval_column);
		 System.out.println("Converted column value= "+replacevalue_Column);
		 Float convertedvalue =Float.parseFloat(replacevalue_Column);
		 System.out.println("Parsedvalue coulmn value= "+convertedvalue);
			 
		 Product1= Product1*convertedvalue;
	     System.out.println("Product = "+Product1);
			 
		}
		

		String Actual_1= NoOfcolmn.get(Sizeofcell_1).getText();
		System.out.println(Actual_1); 
		String replaceActualvalue_1=Actual_1.replaceAll("[€,]","");
		System.out.println("replacement column value= "+replaceActualvalue_1);
		
		Float convertedActualvalue_1 =Float.parseFloat(replaceActualvalue_1);
		System.out.println("Converted column value="+convertedActualvalue_1);
		
		 
		String value1_column=Product1.toString();
	    String value2_column=convertedActualvalue_1.toString();
			
		
	    Assert.assertTrue(value1_column.contains(value2_column.substring(0, 7)));
	    System.out.println(value2_column.substring(0, 7));
	    System.out.println("Passed for columns");
        log.driver.close();
		
		
	}
}
