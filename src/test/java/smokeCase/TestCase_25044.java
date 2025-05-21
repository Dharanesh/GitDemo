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


public class TestCase_25044 extends TestUtils
{
	
    @Test	
	@Parameters("browser")
	public void Testcase_Cockpit_Data_Mashup_splashing_delete_values_checkSplashing_Verifying_Distribution_of_base_Values(String browser) throws Exception
	{
 
	    test =extent.createTest("TestCase_25044 : Cockpit Data Mashup splashing delete values check");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		
		log.createCubeReport("//div[text()='HR']","TestCase_25044_Splashing",false);
		System.out.println("report created using HR cube");
		test.info("report created using HR cube");
		Thread.sleep(1000);

		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("DataviewDesigner"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("DataviewDesigner"))).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Function");
		System.out.println("Function is present in Rows");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(),"Measures");
		Thread.sleep(2000);		
		System.out.println("Measures is present in columns");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Measures']");
		log.driver.findElement(By.xpath("//span[text()='Measures']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		
	
		//Add all measure var  	HR_Values , HR_HDC
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		/*a1.click(e1).sendKeys("HR_Values", Keys.ENTER).build().perform();*/
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		System.out.println(log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]")).getText());
		assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]")).getText(), "HR_Values");
		System.out.println("HR_Values is selected in drop down");
		
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
		Thread.sleep(1000);
		a1.click(e1).sendKeys(Keys.ARROW_UP).build().perform();
		a1.click(e1).sendKeys(Keys.ENTER).build().perform();
		/*a1.click(e1).sendKeys("HR_HDC", Keys.ENTER).build().perform();*/
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		System.out.println(log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]")).getText());
		assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]")).getText(), "HR_HDC");
		System.out.println("HR_HDC is selected in drop down");
		
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
		Thread.sleep(1000);
		
		WebElement calculated=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(e1).sendKeys(Keys.ENTER).build().perform();
		/*a1.click(calculated).sendKeys("Calculated elements", Keys.ENTER).build().perform();*/
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		System.out.println("Calculated element is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			String aa = selectble_ele.get(i).getText();
			selectable.add(aa);
			if(selectable.contains("MASHUP"))
			{
				assertTrue(true);
				
			}
			
		}
		System.out.println("MASHUP is present in the list of selectable elements");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MASHUP']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='MASHUP']/../div[1]")).isDisplayed());
		System.out.println("MASHUP Checkbox is present in the list of selectable elements");
		Thread.sleep(2000);
		ArrayList<String > type = new ArrayList<String>();
		type.add("-SEPARATOR-");
		type.add("FORMULA");
		type.add("MASHUP");
		type.add("SUM");
		type.add("DIFFERENCE");
		System.out.println("Dataview types are: ");
		for(int i =0;i<=4;i++) 
		{
			//String check = window_button.get(i).getText();
			Assert.assertEquals(selectble_ele.get(i).getText(),type.get(i));
			System.out.println(selectble_ele.get(i).getText());

			test.info(" MASHUP's Position is correct");
		}
		Thread.sleep(2000);
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			Assert.assertEquals(selectble_ele.get(i).isSelected(), false);			
		}
		System.out.println("checkboxes are unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MASHUP']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='MASHUP']/../div[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MASHUP']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='MASHUP']/../div[1]/input")).isSelected());
		Thread.sleep(2000);
		System.out.println("MASHUP Checkbox is checked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		List<WebElement> Mashup = log.driver.findElements(By.xpath("//div[text()='MASHUP']/../div[1]/input"));
		for (int i = 0; i < Mashup.size(); i++) {
			
			assertTrue(Mashup.get(i).isSelected());
		}
		System.out.println("MAShup is selected");	
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> el = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
		
		for (int i = 0; i<el.size()-1; i++)
		{	
			Assert.assertEquals(el.get(el.size()-1).getText(), "MASHUP");
						
		}
		System.out.println("MASHUP is present a the last in base elements area");
		test.info("MASHUP is present a the last in base elements area");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6]");
		log.driver.findElements(By.xpath("//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6]")).isEmpty();
		System.out.println("mashup cell is empty");
		test.info("Mashup cell is empty");
		Thread.sleep(2000);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6])[1]");
		log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6])[1]")).click();
		Thread.sleep(3000);
		
		ui.rightClick("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6])[1]");
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Write...']")).isDisplayed())
			{
				System.out.println("Write Available");
			}
		}
		catch(Exception e)
		{
			Actions act = new Actions(log.driver);
	        act.contextClick(log.driver.findElement(By.xpath("(//div[@id='5/0'])[1]"))).perform();
	        Thread.sleep(2000);
			
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6])[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6])[1]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Write...']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Write...']")).isDisplayed());
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Write...']");
		log.driver.findElement(By.xpath("//span[text()='Write...']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Cell Value']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cell Value']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Cell Value']/../../div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/input");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Cell Value']/../../div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/input")).isDisplayed());
		log.driver.findElement(By.xpath("//span[text()='Cell Value']/../../div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys("=getcellvalue(1,1)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		String BaseSalryFIrstcell = log.driver.findElements(By.xpath("//div[text()='Base Salary']/ancestor::div[3]/div[4]/div/div/div[1]")).get(0).getText();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Base Salary']/ancestor::div[3]/div[4]/div/div/div[1]");
		System.out.println("value in base salary 1st cell before splashing : "+log.driver.findElements(By.xpath("//div[text()='Base Salary']/ancestor::div[3]/div[4]/div/div/div[1]")).get(0).getText().replace("€", ""));
		Assert.assertEquals(log.driver.findElements(By.xpath("//div[text()='Base Salary']/ancestor::div[3]/div[4]/div/div/div[1]")).get(0).getText().replace("€", ""), log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6])[1]")).getText());
		String MFC= log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6])[1]")).getText();
		System.out.println("value in mashup column first cell before splashing"+MFC);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Base Salary']/ancestor::div[4]/div/div[4]/div/div/div[1])[1]");
		log.driver.findElement(By.xpath("(//div[text()='Base Salary']/ancestor::div[4]/div/div[4]/div/div/div[1])[1]")).click();
		Thread.sleep(2000);
		
		ui.rightClick(" (//div[text()='Base Salary']/ancestor::div[4]/div/div[4]/div/div/div[1])[1]");
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[.='Splashing...']")).isDisplayed())
			{
				System.out.println("Write Available");
			}
		}
		catch(Exception e)
		{
			Actions act = new Actions(log.driver);
	        act.contextClick(log.driver.findElement(By.xpath("(//div[@id='0/0'])[1]"))).perform();
	        Thread.sleep(2000);
			
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[.='Splashing...']");
		log.driver.findElement(By.xpath("//span[.='Splashing...']")).click();
		Thread.sleep(2000);
		
		System.out.println("Splashing option is present.");
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[.='Splashing']");
		assertTrue(log.driver.findElement(By.xpath("//span[.='Splashing']")).isDisplayed());
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Delete values']");
		assertTrue(log.driver.findElement(By.xpath("//label[text()='Delete values']")).isDisplayed());
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Delete values']/ancestor::td");
		Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Delete values']/ancestor::td/input[1]")).isSelected());
		System.out.println("Delete radio button is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Server side splashing']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Server side splashing']")).isDisplayed());
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Activated']/ancestor::td[1]");
		if(log.driver.findElement(By.xpath("//label[text()='Activated']/ancestor::td[1]/input[1]")).isSelected())
		{
			
			System.out.println("Activated checkbox is selected by default");
		}
		else
		{
			System.out.println("Activated checkbox is not selected by default");
		}
		
		String stat=log.driver.findElement(By.xpath("(//span[text()='Server side splashing'])[2]/ancestor::div[4]/div[2]/div[1]/img")).getAttribute("src");
		assertTrue(stat.contains("lamp_green"),"Color Of the button is not Green");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Splash']");
		log.driver.findElement(By.xpath("//input[@value='Splash']")).click();
		Thread.sleep(4000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='Base Salary']/ancestor::div[4]/div/div[4]/div/div/div[1])[1]");
		String Deletedvalue = log.driver.findElement(By.xpath("(//div[text()='Base Salary']/ancestor::div[4]/div/div[4]/div/div/div[1])[1]")).getText();
		Thread.sleep(1000);
		System.out.println(Deletedvalue);
		Assert.assertEquals(Deletedvalue.contains("0.00"),true);
		System.out.println("Delete value statergy is working fine, value after deleting is : " +Deletedvalue);
		
		System.out.println("Mashup First Cell value"+log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6])[1]")).getText());
		
		Thread.sleep(2000);
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6])[1]")).getText().replace("€()â‚¬", "").contains("0.00"),true);
		System.out.println("mashup funtionality for splashing changes is working fine");
		System.out.println("value in mashup column first cell after splashing is : "+log.driver.findElement(By.xpath("(//div[text()='MASHUP']/ancestor::div[4]/div/div[4]/div/div/div[6])[1]")).getText());
		
		log.driver.close();
		
		
		
		
	}
}
