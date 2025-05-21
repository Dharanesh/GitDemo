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


public class TestCase_25651 extends TestUtils
{
	
	@Test	
	@Parameters("browser")
	public void Testcase_Web_Cockpit_Calculated_Elements_SUM(String browser) throws Exception
	{
 
	    test =extent.createTest("TestCase_25651 : Web Cockpit Calculated Elements_SUM");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		String calval=null;
		String replacevalue=null;
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("InsertAllVisibleItem"));
		log.driver.findElement(By.xpath(log.getData("InsertAllVisibleItem"))).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("DeselectallVisibleItem"));
		log.driver.findElement(By.xpath(log.getData("DeselectallVisibleItem"))).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("AllCategoryCB"));
		log.driver.findElement(By.xpath(log.getData("AllCategoryCB"))).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("AllCategoryCB"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("AllCategory_Input_CB"))).isSelected());
		System.out.println("All Categories Checkbox is Selected in the list of selectable elements");
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("RemovesOnlySelected_Item"));
		log.driver.findElement(By.xpath(log.getData("RemovesOnlySelected_Item"))).click();
		Thread.sleep(1000);
				
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("ElementGroup_Dropdown"));
		WebElement elemnt=log.driver.findElement(By.xpath(log.getData("ElementGroup_Dropdown")));
		Actions a1=new Actions(log.driver);
		/*a1.click(elemnt).sendKeys("Calculated elements", Keys.ENTER).build().perform();*/
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ENTER).build().perform();
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
			if(selectable.contains("SUM"))
			{
				assertTrue(true);
				
			}
			
		}
			
		System.out.println("SUM is present in the list of selectable elements");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SUM']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='SUM']/../div[1]")).isDisplayed());
		System.out.println("SUM Checkbox is present in the list of selectable elements");
        
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

			test.info(" SUM Position is correct");
		}
        Thread.sleep(1000);
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			Assert.assertEquals(selectble_ele.get(i).isSelected(), false);

		}
		System.out.println("checkboxes are unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SUM']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='SUM']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SUM']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='SUM']/../div[1]/input[1]")).isSelected());
		System.out.println("SUM Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		List<WebElement> Percentage = log.driver.findElements(By.xpath("//div[text()='SUM']/../div[1]/input"));
		for (int i = 0; i < Percentage.size(); i++) {
			
			assertTrue(Percentage.get(i).isSelected());
		}
		System.out.println("SUM is selected");			
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> el = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
		
			
		Assert.assertEquals(el.get(el.size()-1).getText(), "SUM");
		
		System.out.println("SUM is present a the last in Selected elements area");
		test.info("SUM is present a the last in Selected elements area");
        
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);	
			
		//checking the Sum in column
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Quarter 1 2015']/following::div[6]/div/div[1]");
		List<WebElement> calele = log.driver.findElements(By.xpath("//div[text()='Quarter 1 2015']/following::div[6]/div/div[1]"));
		Float sum =0.0f;
		int Sizeofcell = calele.size()-1;
		System.out.println(Sizeofcell);
		for(int i=0;i<=calele.size()-2;i++)
		{
			 calval = calele.get(i).getText();
			 
			 for(int j=0;j<=calele.size()-1;j++)
			 {
			 replacevalue= calval.replaceAll("[€,]","");
			 }
			 System.out.println();
			 System.out.println("original = "+calval);
			 System.out.println("Converted = "+replacevalue);
			 Float convertedvalue =Float.parseFloat(replacevalue);
			 System.out.println("Parsedvalue = "+convertedvalue);
			 sum= sum+convertedvalue;
			 System.out.println("Sum = "+sum);
			 
		}
	Thread.sleep(1000);
	int Size =calele.size()-1;
	String Avg_Actual= calele.get(Size).getText();
	System.out.println(Avg_Actual); 
	String replaceActualvalue=Avg_Actual.replaceAll("[€,]","");
		
    Float convertedActualvalue =Float.parseFloat(replaceActualvalue);
    System.out.println(convertedActualvalue);
	
    String valueConverted =convertedActualvalue.toString();
    String SumConverted=sum.toString();
    Assert.assertTrue(valueConverted.contains(SumConverted.substring(0, 4)));
    System.out.println("Passed for rows");	 

	Thread.sleep(1000);
	
	waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
	Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(),"Time");
	Thread.sleep(2000);
    System.out.println("Time is present in columns");	
				
    waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Columns_Value"));
    log.driver.findElement(By.xpath(log.getData("Columns_Value"))).click();
    Thread.sleep(2000);
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
			if(selectable1.contains("SUM"))
			{
				assertTrue(true);
				
			}
			
		}
	System.out.println("SUM is present in the list of selectable elements");
	Thread.sleep(2000);
	waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SUM']/../div[1]");
	assertTrue(log.driver.findElement(By.xpath("//div[text()='SUM']/../div[1]")).isDisplayed());
	System.out.println("SUM Checkbox is present in the list of selectable elements");
    
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
	
	
	System.out.println("ELements present in Selectable area are:  ");
	for(int i =0;i<=8;i++) 
	{
		Assert.assertEquals(selectble_ele1.get(i).getText(),type1.get(i));
		System.out.println(selectble_ele1.get(i).getText());

		test.info(" SUM Position is correct");
	}

	for (int i =0;i<=selectble_ele1.size()-1;i++) 
	{
		Assert.assertEquals(selectble_ele1.get(i).isSelected(), false);

	}
	System.out.println("checkboxes are unchecked");
	Thread.sleep(1000);
	waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SUM']/../div[1]");
	log.driver.findElement(By.xpath("//div[text()='SUM']/../div[1]")).click();
	waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SUM']/../div[1]");
	assertTrue(log.driver.findElement(By.xpath("//div[text()='SUM']/../div[1]/input[1]")).isSelected());
	System.out.println("SUM Checkbox is Selected in the list of selectable elements");
	
	waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
	log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
	waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
	
	List<WebElement> Sum = log.driver.findElements(By.xpath("//div[text()='SUM']/../div[1]/input"));
	for (int i = 0; i < Sum.size(); i++) {
		
		assertTrue(Sum.get(i).isSelected());
	}
	System.out.println("SUM is selected");			
	Thread.sleep(1000);
	waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
	List<WebElement> el1 = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
	
	
	Assert.assertEquals(el1.get(el1.size()-1).getText(), "SUM");
	
	System.out.println("DIFFERENCE is present a the last in Selected elements area");
	test.info("DIFFERENCE is present a the last in Selected elements area");
    
	waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
	log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
	Thread.sleep(2000);	
	
	
	waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Quarter 1 2015']/following::div[8]/div");
	List<WebElement> calele_colmn = log.driver.findElements(By.xpath("//div[text()='Quarter 1 2015']/following::div[8]/div"));
	Float sum_1 =0.0f;
	int Sizeofcell_1 = calele_colmn.size()-1;
	System.out.println(Sizeofcell_1);
	for(int i=0;i<=calele_colmn.size()-2;i++)
	{
		 calval_column = calele_colmn.get(i).getText();
		 
		 for(int j=0;j<=calele_colmn.size()-1;j++)
		 {
			 replacevalue_Column= calval_column.replaceAll("[€,]","");
		
		 }
		 System.out.println();
		 System.out.println("original = "+calval_column);
		 System.out.println("Converted = "+replacevalue_Column);
		 Float convertedvalue =Float.parseFloat(replacevalue_Column);
		 System.out.println("Parsedvalue = "+convertedvalue);
		 
		 sum_1= sum_1+convertedvalue;
		 System.out.println("Sum = "+sum_1);
	 
	}
	Thread.sleep(1000);
	String Avg_Actual_1= calele_colmn.get(Sizeofcell_1).getText();
	System.out.println(Avg_Actual_1); 
	String replaceActualvalue_1=Avg_Actual_1.replaceAll("[€,]","");
	
	Float convertedActualvalue_1 =Float.parseFloat(replaceActualvalue_1);
	System.out.println(convertedActualvalue_1);
	
	String valueConverted_1 =convertedActualvalue_1.toString();
	String SumConverted_1=sum_1.toString();
	 
	Assert.assertTrue(valueConverted_1.contains(SumConverted_1.substring(0, 4)));
    System.out.println("Passed for Column");
	
	log.driver.close();
	
	
	
			
	}
}
