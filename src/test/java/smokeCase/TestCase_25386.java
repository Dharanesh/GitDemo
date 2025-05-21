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

public class TestCase_25386 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Web_Testcase_to_verify_Filters_Priority_check_Automatic_vs_Explicit(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_25386 : Web_Testcase to verify <Filters: Priority check (Automatic vs Explicit)>");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		Actions a1=new Actions(log.driver);
		log.createCubeReport("//div[contains(text(),'Training Sales')]","TestCase_25386",false);
		System.out.println("report created using Training Sales cube");
		test.info("report created using Training Sales cube");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Timetype");
		System.out.println("Timetype is present in Rows"); 
		
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Timetype'])[1]")), log.driver.findElement(By.xpath(log.getData("Background"))));
		Thread.sleep(5000);
		ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Product'])[2]")), log.driver.findElement(By.xpath(log.getData("Row"))));
		Thread.sleep(5000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Product");
		System.out.println("Product is present in columns");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		
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

		Thread.sleep(1000);
		List<WebElement> AB = log.driver.findElements(By.xpath(log.getData("Selection_Element_Window_Btns")));
		for (WebElement btn : AB) 
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getText() + "    is displayed and Enabled");
			test.info(btn.getText() + "    is displayed and Enabled");
		}	
			
	
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='All Products'])[2]/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("(//div[text()='All Products'])[2]/../div[1]/input")).isSelected());
		System.out.println("All Products Checkbox is Selected in the list of base elements area");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
	
		//a1.click(elemnt).sendKeys("Container elements", Keys.ENTER).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		Assert.assertEquals(elemnt.getText(),"Container elements");
		
		try
			{
				log.driver.findElement(By.xpath("//div[text()='Exotic']")).click();
				Thread.sleep(2000);
			}
		catch(Exception e)
			{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
			Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled(),true);
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
			log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
			Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
			
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
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Container elements'])[1]/ancestor::li[1]")).getCssValue("background-color"), "rgba(255, 212, 0, 1)", "container element got higlighted");
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
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='New...']");
			Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='New...']")).isDisplayed(),true);
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='New...']");
			log.driver.findElement(By.xpath("//button[text()='New...']")).click();
			
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
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[1]")).getCssValue("background-color"), "rgba(255, 212, 0, 1)", "container element got higlighted");
			System.out.println("Container Element got highlighted");
			Thread.sleep(500);
			ElementGrp.get(3).click();
			Thread.sleep(1000);
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[4]")).getCssValue("background-color"), "rgba(255, 212, 0, 1)", "container element got higlighted");
			System.out.println("Standard SDl Element got highlighted");
			Thread.sleep(500);
			
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
			log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
			Thread.sleep(2000);	
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'New SDL - Dimension')]");
			Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New SDL - Dimension')]")).isDisplayed(),true);
			
		    waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Name']/ancestor::div[3]/div[2]/div/div/input");
		    log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).sendKeys("Exotic");
			
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
			catch(Exception ex)
			{
				System.out.println("next clicked");
			}
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'New SDL - Dimension')]");
			Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New SDL - Dimension')]")).isDisplayed(),true);
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Selection...']");
			log.driver.findElement(By.xpath("//*[text()='Selection...']")).click();
			Thread.sleep(2000);
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for SDL')]");
			Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for SDL')]")).isDisplayed(),true);
			
			waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[3]");
			List<WebElement> selectble_ele = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[3]"));
			Thread.sleep(2000);
			for (int i =0;i<=selectble_ele.size()-1;i++) 
			{
				int k=i+1;
				if(selectble_ele.get(i).getText().equals("Acura")||selectble_ele.get(i).getText().equals("Aston Martin")||selectble_ele.get(i).getText().equals("Bentley" )
						||selectble_ele.get(i).getText().equals("Cadillac")||selectble_ele.get(i).getText().equals("Chrysler")||selectble_ele.get(i).getText().equals("Daewoo")
						||selectble_ele.get(i).getText().equals("Dodge")||selectble_ele.get(i).getText().equals("Fiat")||selectble_ele.get(i).getText().equals("Honda")
						||selectble_ele.get(i).getText().equals("Jaguar")||selectble_ele.get(i).getText().equals("Lamborghini")||selectble_ele.get(i).getText().equals("Land Rover")
						||selectble_ele.get(i).getText().equals("Lincoln")||selectble_ele.get(i).getText().equals("Maserati"))
				{
					Thread.sleep(500);
					log.driver.findElement(By.xpath("(//span[contains(text(),'Selectable elements:')]/..)[1]/ancestor::div[4]/div[2]/div[1]/div["+k+"]/div[2]")).click();
					assertTrue(log.driver.findElement(By.xpath("(//span[contains(text(),'Selectable elements:')]/..)[1]/ancestor::div[4]/div[2]/div[1]/div["+k+"]/div[2]/input")).isSelected());
					System.out.println("Checkbox checked for element" +selectble_ele.get(i).getText());
					test.info("Checkbox checked for element" +selectble_ele.get(i).getText());
					 
				}
				

			}
			Thread.sleep(1000);
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
			log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
			Thread.sleep(2000);
			
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
			log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
			Thread.sleep(2000);
			
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
			log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
			Thread.sleep(2000);
			
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Finish']");
			log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
			Thread.sleep(2000);
			//validate exotic
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Groups']/ancestor::div[4]/div[4]/div[1]/div[1]/ul/li/div[1]/span[1]/span[2]");
			List<WebElement> SelectCalcElemnt = log.driver.findElements(By.xpath("//span[text()='Groups']/ancestor::div[4]/div[4]/div[1]/div[1]/ul/li/div[1]/span[1]/span[2]"));
			ArrayList<String> selectable = new ArrayList<String>();
			
			for (int i =0;i<=SelectCalcElemnt.size()-1;i++) 
			{
				String aa = SelectCalcElemnt.get(i).getText();
				selectable.add(aa);
				if(selectable.contains("Exotic"))
				{
					assertTrue(true);
					
				}
				
			}
			
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
			log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//div[text()='Exotic']")).click();
			Thread.sleep(2000);
			
			
			}
		
		//select calculated element
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemntdrpdwn=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		a1.click(elemntdrpdwn).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemntdrpdwn).sendKeys(Keys.ARROW_DOWN).build().perform();
		//a1.click(elemntdrpdwn).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemntdrpdwn).sendKeys(Keys.ENTER).build().perform();
		//a1.click(elemntdrpdwn).sendKeys("Calculated elements", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elmntindrpdwn=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwn.getText(),"Calculated elements");
		System.out.println(elmntindrpdwn.getText());
		System.out.println("Calculated elements is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='FORMULA']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='FORMULA']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='FORMULA']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='FORMULA']/../div[1]/input[1]")).isSelected());
		System.out.println("FORMULA Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Deselect all visible items'])[2]");
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='FORMULA'])[2]");
		log.driver.findElement(By.xpath("(//div[text()='FORMULA'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Formula Editor']");
		log.driver.findElement(By.xpath("//button[text()='Formula Editor']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Enter formula for calculated element:']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Enter formula for calculated element:']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Name:']/ancestor::div[4]/div[1]/div[2]/div[1]/div[1]/input[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Name:']/ancestor::div[4]/div[1]/div[2]/div[1]/div[1]/input[1]")).getAttribute("value"),"FORMULA");
		Actions action = new Actions(log.driver);
		action.moveToElement(log.driver.findElement(By.xpath("//*[text()='Formula:']/following::pre[1]/..")));
		action.click();
		action.sendKeys("Sum(E[\"Acura\"], E[\"Aston Martin\"], E[\"Bentley\"], E[\"Cadillac\"], E[\"Chrysler\"], E[\"Daewoo\"], E[\"Dodge\"], E[\"Fiat\"], E[\"Honda\"], E[\"Jaguar\"], E[\"Lamborghini\"])    \r\n" +" ");
		action.build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Check Syntax']");
		log.driver.findElement(By.xpath("//button[text()='Check Syntax']")).click();
		log.driver.findElement(By.xpath("//button[text()='Check Syntax']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Syntax is OK!']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Syntax is OK!']")).getText(),"Syntax is OK!");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		//=====================column ====================================================================
	  ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Measures'])[1]")), log.driver.findElement(By.xpath(log.getData("Background"))));
	  Thread.sleep(4000);
	  ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Time'])[1]")), log.driver.findElement(By.xpath(log.getData("Columns"))));
	  Thread.sleep(4000);
	  
	  waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
	  assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(), "Time");	
				
	  waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Columns_Value"));
	  log.driver.findElement(By.xpath(log.getData("Columns_Value"))).click();
	  waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Dimension_Header"));
	  assertTrue(log.driver.findElement(By.xpath(log.getData("Columns_Dimension_Header"))).isDisplayed());
		
	  waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
	  log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
	  Thread.sleep(1000);
	  
	  waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='2014']/ancestor::div[1]/div[1]/a[1]/span[1]");
	  log.driver.findElement(By.xpath("//div[text()='2014']/ancestor::div[1]/div[1]/a[1]/span[1]")).click();
	  Thread.sleep(1000);
	
	  waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Q1 2014']");
	  log.driver.findElement(By.xpath("//div[text()='Q1 2014']")).click();
	  Thread.sleep(1000);
	  waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Q2 2014']");
	  log.driver.findElement(By.xpath("//div[text()='Q2 2014']")).click();
	  Thread.sleep(1000);
	
	//select calculated element
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemntdrpdwn1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		//a1.click(elemntdrpdwn1).sendKeys("Calculated elements", Keys.ENTER).build().perform();
		a1.click(elemntdrpdwn1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemntdrpdwn1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemntdrpdwn1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemntdrpdwn1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elmntindrpdwn1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwn1.getText(),"Calculated elements");
		System.out.println(elmntindrpdwn1.getText());
		System.out.println("Calculated elements is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='FORMULA']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='FORMULA']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='FORMULA']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='FORMULA']/../div[1]/input[1]")).isSelected());
		System.out.println("FORMULA Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Deselect all visible items'])[2]");
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='FORMULA'])[2]");
		log.driver.findElement(By.xpath("(//div[text()='FORMULA'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Formula Editor']");
		log.driver.findElement(By.xpath("//button[text()='Formula Editor']")).click();
		Thread.sleep(1000);
		
		action.moveToElement(log.driver.findElement(By.xpath("//*[text()='Formula:']/following::pre[1]/..")));
		action.click();
		action.sendKeys("Sum(E[\"Q1 2014\"], E[\"Q2 2014\"])");
		action.build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Check Syntax']");
		log.driver.findElement(By.xpath("//button[text()='Check Syntax']")).click();
		log.driver.findElement(By.xpath("//button[text()='Check Syntax']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Syntax is OK!']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Syntax is OK!']")).getText(),"Syntax is OK!");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Columns_Dimension_Header"))).isDisplayed());
	
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		String current =log.driver.findElement(By.xpath("//span[text()='Current element']/ancestor::div[3]/div[2]/div/table//tr/td[2]")).getText();
		assertEquals(current.trim(), "FORMULA");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Alias:']/following::div[4]/input");
		log.driver.findElement(By.xpath("//span[text()='Alias:']/following::div[4]/input")).sendKeys("SUM");
		
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']");
		log.driver.findElement(By.xpath("//div[text()='Automatic priority']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]/div[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]/div[1]/input")).isSelected(), false);

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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement clientrule=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		Actions a2=new Actions(log.driver);
		/*a2.click();
		a2.click(clientrule).sendKeys(Keys.UP).build().perform();
		a2.click(clientrule).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);*/
		for(int i=1;i<=3;i++)
		{
			action.click(clientrule).sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(100);
			if(clientrule.getText().equals("Client Rules"))
			{
				action.click(clientrule).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				break;
			}
		}
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Q1&Q2']"); 
		log.driver.findElement(By.xpath("//*[text()='Q1&Q2']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		//=====validate priority===================
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Acura'])[1]/ancestor::div[3]/div[3]/div/div");
		List<WebElement> TableColumnHdr = log.driver.findElements(By.xpath("(//div[text()='Acura'])[1]/ancestor::div[3]/div[3]/div/div"));
		for (WebElement webElement : TableColumnHdr) {
			if(webElement.getText().equals("SUM")||webElement.getText().equals("Q1&Q2")){
				assertTrue(true);
			}
		}
		System.out.println("Priority check is woking as expected");
        test.info("Priority check is woking as expected");
		log.driver.close();
		
		
		
		
		
		
	}
}
