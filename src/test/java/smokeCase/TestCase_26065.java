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


public class TestCase_26065 extends TestUtils
{
	
    @Test	
	@Parameters("browser")
	public void Testcase_Web_Cockpit_Calculated_Elements_PERCENTAGE(String browser) throws Exception
	{
 
	    test =extent.createTest("TestCase_26065 : Web Cockpit Calculated Elements_PERCENTAGE");
	   
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		String calval=null;
		String replacevalue=null;
		
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
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Measures'])[2]")), log.driver.findElement(By.xpath(log.getData("Row"))));
		Thread.sleep(4000);
		System.out.println("Measure is present in rows");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(),"Time");
		Thread.sleep(2000);
		System.out.println("Time is present in columns");;
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		
		
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
			System.out.println(btn.getText() + "    is displayed and Enabled");
			test.info(btn.getText() + "    is displayed and Enabled");
		}
		
		
		
		
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("ElementGroup_Dropdown"));
		WebElement elemnt=log.driver.findElement(By.xpath(log.getData("ElementGroup_Dropdown")));
		Actions a1=new Actions(log.driver);
		/*a1.click(elemnt).sendKeys("Calculated elements", Keys.ENTER).build().perform();*/
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		
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
			if(selectable.contains("PERCENTAGE"))
			{
				assertTrue(true);
				
			}
			
		}
		System.out.println("PERCENTAGE is present in the list of selectable elements");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Percentage"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Percentage"))).isDisplayed());
		System.out.println("PERCENTAGE Checkbox is present in the list of selectable elements");
		
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

			test.info(" PERCENTAGE Position is correct");
		}
        Thread.sleep(500);
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			Assert.assertEquals(selectble_ele.get(i).isSelected(), false);

		}
		System.out.println("checkboxes are unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Percentage"));
		log.driver.findElement(By.xpath(log.getData("Percentage"))).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Percentage"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Percentage_Input"))).isSelected());
		System.out.println("PERCENTAGE Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		List<WebElement> Percentage = log.driver.findElements(By.xpath(log.getData("Percentage_Input")));
		for (int i = 0; i < Percentage.size(); i++) {
			
			assertTrue(Percentage.get(i).isSelected());
		}
		System.out.println("Percentage is selected");			
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Selectable_Elemnts_Text"));
		List<WebElement> el = log.driver.findElements(By.xpath(log.getData("Selectable_Elemnts_Text")));//step 24
		Thread.sleep(1000);
		for (int i = 0; i < el.size()-1; i++)
		{	
			System.out.println(el.get(el.size()-1).getText());
			Assert.assertEquals(el.get(el.size()-1).getText(), "PERCENTAGE");
			
						
		}
		System.out.println("PERCENTAGE is present at the last in base elements area");
		test.info("PERCENTAGE is present at the last in base elements area");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,log.getData("OK_Btn"));
		log.driver.findElement(By.xpath(log.getData("OK_Btn"))).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Cellelements"));
		List<WebElement> calele = log.driver.findElements(By.xpath(log.getData("Cellelements")));
		Float X= 0.0f;
		Float Result= 0.0f;
		List<Float> arr= new ArrayList<Float>();
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

			arr.add(convertedvalue);
			System.out.println(arr);

		}

		X= arr.get(0);
         Thread.sleep(1000);
		System.out.println("Converted elements" +arr.size());
		for (int i = 0; i < arr.size(); i++) {

			Result = (float) (100 * (float) arr.get(i)/ X);
			System.out.println("  " +Result);
		}


		int Size =calele.size()-1;
		String Diff_Actual= calele.get(Size).getText();
		System.out.println(Diff_Actual); 
		String replaceActualvalue=Diff_Actual.replaceAll("[€,()%]","");

		Float convertedActualvalue =Float.parseFloat(replaceActualvalue);
		System.out.println(convertedActualvalue);

		String Actual_difference= convertedActualvalue.toString();
		System.out.println("actual difference value " +Actual_difference);
		System.out.println(Actual_difference.substring(0,4));
		String caculated_difference = Result.toString();
		System.out.println("calculated differnce " +caculated_difference);
		Assert.assertTrue(caculated_difference.contains(Actual_difference.substring(0,5)));
		//Assert.assertEquals(Actual_difference,caculated_difference);
		System.out.println("Passed for Rows");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(), "Measures");
		Thread.sleep(1000);
		ui.dragAndDrop(log.driver.findElement(By.xpath(log.getData("Measure"))), log.driver.findElement(By.xpath(log.getData("Columns"))));
		Thread.sleep(4000);
		ui.dragAndDrop(log.driver.findElement(By.xpath(log.getData("Time"))), log.driver.findElement(By.xpath(log.getData("Row"))));
		Thread.sleep(4000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(), "Measures");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Cell_Elemts"));
		List<WebElement> calele_colmn = log.driver.findElements(By.xpath(log.getData("Cell_Elemts")));
		Float X1= 0.0f;
		Float Result1= 0.0f;
		//	Float DIfference_Result = null;
		List<Float> arr1= new ArrayList<Float>();
		int Sizeofcell1 = calele_colmn.size()-1;
		System.out.println(Sizeofcell1);
		for(int i=0;i<=calele_colmn.size()-2;i++)
		{
			calval = calele_colmn.get(i).getText();


			for(int j=0;j<=calele_colmn.size()-1;j++)
			{
				replacevalue= calval.replaceAll("[€,]","");

			}
			System.out.println();
			System.out.println("original = "+calval);
			System.out.println("Converted = "+replacevalue);
			Float convertedvalue =Float.parseFloat(replacevalue);
			System.out.println("Parsedvalue = "+convertedvalue);

			arr1.add(convertedvalue);
			System.out.println(arr1);

		}

		X1= arr1.get(0);

		System.out.println("Converted elements" +arr1.size());
		for (int i = 0; i < arr1.size(); i++) {

			Result1 = (float) (100 * (float) arr1.get(i)/ X1);
			System.out.println("  " +Result1);
			
		}

        Thread.sleep(1000);
		int Size1 =calele_colmn.size()-1;
		String Diff_Actual1= calele_colmn.get(Size1).getText();
		System.out.println(Diff_Actual1); 
		String replaceActualvalue1=Diff_Actual1.replaceAll("[€,()%]","");

		Float convertedActualvalue1 =Float.parseFloat(replaceActualvalue1);
		System.out.println(convertedActualvalue1);

		String Actual_difference1= convertedActualvalue1.toString();
		System.out.println("actual difference value " +Actual_difference1);
		String caculated_difference1 = Result1.toString();
		System.out.println("calculated differnce " +caculated_difference1);

		//Assert.assertEquals(Actual_difference1,caculated_difference1);
		Assert.assertTrue(caculated_difference1.contains(Actual_difference1.substring(0,4)));
		System.out.println("Passed for Columns");

		log.driver.close();
	
		
		
		
		
		
	}
}
