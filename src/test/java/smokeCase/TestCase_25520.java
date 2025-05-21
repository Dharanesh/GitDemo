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

public class TestCase_25520 extends TestUtils
{
	@Test
	@Parameters("browser")
	//Testcase  for creating criteria DDl for  "CM ratio manufacturerss" report
	public void Testcase_for_Creating_Criteria_DDL_for_Contribution_margin_exotics(String browser) throws Exception
	{
		test =extent.createTest("TestCase_25520: Testcase_for_Creating_Criteria_DDL_for_Contribution_margin_exotics");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui=new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='CM ratio manufacturers']");
		log.driver.findElement(By.xpath("//span[text()='CM ratio manufacturers']")).click();
        Thread.sleep(1000);

        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='CM ratio manufacturers'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='CM ratio manufacturers'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(), "Time");
		System.out.println("Time is present in Columns");
		test.info("Time is present in Columns");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Columns_Value"));
		log.driver.findElement(By.xpath(log.getData("Columns_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e1.getText(), "Time");
		System.out.println("Elements groups displayed correctly");
		test.info("Elements groups displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]");
		WebElement e2=log.driver.findElement(By.xpath("//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e2.getText(), "<No Limits>");
		System.out.println("Limits displayed correctly");
		test.info("Limits displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Current sorting:']/following::div[2]/span/span[1]/span[1]");
		WebElement e3=log.driver.findElement(By.xpath("//span[text()='Current sorting:']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e3.getText(), "<No Sorting>");
		System.out.println("Current sorting displayed correctly");
		test.info("Current sorting displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Display:']/following::div[2]/span/span[1]/span[1]");
		WebElement e4=log.driver.findElement(By.xpath("//span[text()='Display:']/following::div[2]/span/span[1]/span[1]"));
		System.out.println("Value present in Display displayed correctly"+e4.getText());
		test.info("Value present in Display displayed correctly"+e4.getText());	
		Thread.sleep(1000);
		List<WebElement> AB = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for Rows')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB)
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		}
		
        waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='2015']");
		log.driver.findElement(By.xpath("//div[text()='2015']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> basevalue = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> base= new ArrayList<String>();
		System.out.println("New Report radio button option");
		base.add("2015");

		for(int i=0;i<=basevalue.size()-1;i++) 
		{
			assertEquals(basevalue.get(i).getText(), base.get(i));
			System.out.println(basevalue.get(i).getText());

		}
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]");
		List<WebElement> basevalueaftupdate = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[1]/input[1]"));
		for(int i=0;i<=basevalueaftupdate.size()-1;i++) 
		{
			Assert.assertTrue(basevalueaftupdate.get(i).isSelected());
			System.out.println("2015 value is checked");
		}
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='CM ratio manufacturers'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='CM ratio manufacturers'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Acura'])[1]/ancestor::div[3]/div[3]/div/div");
		List<WebElement> TableColumnHdr = log.driver.findElements(By.xpath("(//div[text()='Acura'])[1]/ancestor::div[3]/div[3]/div/div"));
		if(TableColumnHdr.contains("2015"))
		{
			assertTrue(true);
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Product");
		System.out.println("Product is present in Rows");
		test.info("Product is present in Rows");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='All groups/elements available']/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='All groups/elements available']/../../td[1]/input[@type='checkbox']")).isSelected(),true);
		Thread.sleep(1000);
		
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
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Container elements'])[1]/ancestor::li[1]")).getCssValue("background-color").contains("255, 212, 0"), "container element got higlighted");
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
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
       try{
			for(int i=0;i<=SelectableElementvalue.size()-1;i++)
			{
				String valueofcontainerele =SelectableElementvalue.get(i).getText();
				System.out.println(valueofcontainerele);

				if(valueofcontainerele.contains("CriteriaDDL"))
				{
					System.out.println("CriteriaDDL is present");
					test.info("CriteriaDDL is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='CriteriaDDL']");
					log.driver.findElement(By.xpath("//span[text()='CriteriaDDL']")).click();
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
		System.out.println("Create new container element");
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
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[1]")).getCssValue("background-color").contains("255, 212, 0"), "Criteria DDL got higlighted");
		System.out.println("Criteria DDL got highlighted");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'New Criteria DDL')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New Criteria DDL')]")).isDisplayed(),true);
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Name']/ancestor::div[3]/div[2]/div/div/input");
	    log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).sendKeys("CriteriaDDL");
	    Thread.sleep(500);
	    
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
			 
		}catch(Exception ex)
		{
			
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Preselection of Elements']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Preselection of Elements']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[contains(text(),'All elements of the dimension')]/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[contains(text(),'All elements of the dimension')]/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//tr[@class='lvitem']/td[2]/ancestor::div[1]");
		assertTrue(log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]/ancestor::div[1]")).getCssValue("background-color").contains("255, 255, 255"));
		System.out.println("Select hierarchy: is Enabled");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//tr[@class='lvitem']/td[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]")).getText(),"Product");
		System.out.println("Select hierarchy: is"+log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
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
		for(int i=1;i<=10;i++)
		{
			a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(1000);
			if(elemnt.getText().equals("CarType"))
			{
				a1.click(elemnt).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				break;
			}
		}
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]//span[1]/span[1]/span[1]");
		WebElement elmntindrpdwn=log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]//span[1]/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwn.getText(),"CarType");
		System.out.println(elmntindrpdwn.getText());
		System.out.println("CarType is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).isEnabled(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).clear();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]");
		log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).sendKeys("Limousine");
		String Filtervalue=log.driver.findElement(By.xpath("//span[contains(text(),'Element Criteria')]/ancestor::div[3]/div[2]/div[1]/div[2]/div[2]//input[1]")).getAttribute("value");
		Thread.sleep(200);
		Assert.assertEquals(Filtervalue, "Limousine");
		System.out.println("Limousine is Entered successfully ");
		test.info("Limousine is Entered successfully ");
		
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
		a1.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ENTER).build().perform();
		//a1.click(elemnt1).sendKeys("Container elements", Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Assert.assertEquals(elemnt1.getText(), "Container elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele1 = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable1 = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele1.size()-1;i++) 
		{
			String aa = selectble_ele1.get(i).getText();
			selectable1.add(aa);
			if(selectable1.contains("CriteriaDDL"))
			{
				assertTrue(true);
				
			}
			
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt2=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		//a1.click(elemnt2).sendKeys("CriteriaDDL", Keys.ENTER).build().perform();
		for(int i=1;i<=10;i++)
		{
			a1.click(elemnt2).sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(1000);
			if(elemnt2.getText().equals("CriteriaDDL"))
			{
				a1.click(elemnt2).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				break;
			}
		}
		
		
		Assert.assertEquals(elemnt2.getText(), "CriteriaDDL");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Select all visible items'])[1]");
		log.driver.findElement(By.xpath("(//button[@data-title='Select all visible items'])[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		Thread.sleep(3000);
		
		List<WebElement> Base_ele = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		int count=0;
		for (WebElement webElement : Base_ele)
		{
			//webElement.getText();
			count++;
		}
		System.out.println(count);
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt_Container=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		
		//a1.click(elemnt_Container).sendKeys("Container elements", Keys.ENTER).build().perform();
		for(int i=1;i<=10;i++)
		{
			a1.click(elemnt_Container).sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(1000);
			if(elemnt_Container.getText().equals("Container elements"))
			{
				a1.click(elemnt_Container).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				break;
			}
		}
		
		Assert.assertEquals(elemnt_Container.getText(), "Container elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='CriteriaDDL']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='CriteriaDDL']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='CriteriaDDL']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='CriteriaDDL']/../div[1]/input[1]")).isSelected());
		System.out.println("CriteriaDDL Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[.='RSX']/ancestor::div[3]/div[2]/div/div");
		List<WebElement> rowvaluetab = log.driver.findElements(By.xpath("//div[.='RSX']/ancestor::div[3]/div[2]/div/div"));
		int counttab=1;
		for(int i=0;i<=rowvaluetab.size()-1;i++)
		{
			//System.out.println(rowvaluetab.get(i).getText());
			counttab++;
		}
		System.out.println("valueoftab"+counttab);
		
		if(count==counttab)
		{
			System.out.println(" values of the tab is matching with Criteria ddl value");
		}
		else
		{
			System.out.println("not Matching");
			
		}
		
		
		//===========================
		Assert.assertTrue(Base_ele.retainAll(rowvaluetab));
		System.out.println(" values of the tab is matching with Data ddl value");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[@id='tab_close_btn']");
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='No']");
		log.driver.findElement(By.xpath("//input[@value='No']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Manufacturer_Ranking']");
		log.driver.findElement(By.xpath("//span[text()='Manufacturer_Ranking']")).click();
        Thread.sleep(1000);

        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Manufacturer_Ranking'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Manufacturer_Ranking'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue1 = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
       try{
			for(int i=0;i<=SelectableElementvalue1.size()-1;i++)
			{
				String valueofcontainerele =SelectableElementvalue1.get(i).getText();
				System.out.println(valueofcontainerele);

				if(valueofcontainerele.contains("CriteriaDDL"))
				{
					System.out.println("CriteriaDDL is present");
					test.info("CriteriaDDL is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='CriteriaDDL']");
					log.driver.findElement(By.xpath("//span[text()='CriteriaDDL']")).click();
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
		System.out.println("Don't create container element");
		}
        Thread.sleep(1000);
		
    	waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		log.driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
	}

}
