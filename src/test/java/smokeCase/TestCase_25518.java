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

public class TestCase_25518 extends TestUtils
{
	@Test	
	@Parameters("browser")

	public void Testcase_for_implementing_Script_DDl_for_container_element_in_MDX_with_Set_expressions(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_25518: Testcase for implementing Script DDl for  container element in MDX with Set expressions");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui=new Utils(log.driver);
		
		log.createCubeReport("//div[contains(text(),'Training Sales')]","TestCase_25518",false);
		System.out.println("report created using Training Sales cube");
		test.info("report created using Training Sales cube");

		clickableClick(By.xpath("//span[text()='Dataview Designer']"));
		
		//Add Product in rows
		Assert.assertEquals(findVisible(By.xpath("//span[@class='w20_listboxitemtext'][normalize-space()='Timetype']")).getText(),"Timetype");
		System.out.println("Timetype is present in Rows"); 

		dragAndDropNew(By.xpath("//span[@class='w20_listboxitemtext'][normalize-space()='Timetype']"), By.xpath("//div[text()='Background']/following::div[3]"));
		dragAndDropNew(By.xpath("//span[@class='w20_listboxitemtext'][normalize-space()='Product']"), By.xpath("//div[text()='Rows']/following::div[5]/div"));

		Assert.assertEquals(findVisible(By.xpath("//div[text()='Rows']/following::div[5]//ul/li/div[1]/span[1]/span[2]")).getText(),"Product");
		System.out.println("Product is present in columns");
		
		//Add time in column
		dragAndDropNew(By.xpath("//span[@class='w20_listboxitemtext'][normalize-space()='Measures']"), By.xpath("//div[text()='Background']/following::div[3]"));

		clickableClick(By.xpath("//span[@class='w20_listboxitemtext'][normalize-space()='Time']"));
		clickableClick(By.xpath("//input[@id='okbutton']"));

		dragAndDropNew(By.xpath("//span[@class='w20_listboxitemtext'][normalize-space()='Time']"), By.xpath("//div[text()='Columns']/following::div[5]/div"));

		assertEquals(findVisible(By.xpath("//div[text()='Columns']/following::div[5]//ul/li/div[1]/span[1]/span[2]")).getText(), "Time");

		clickableClick(By.xpath("//div[text()='Rows']/following::div[5]//ul/li/div[1]/span[1]/span[2]"));
		assertTrue(findVisibleBool(By.xpath("//span[contains(text(),'Selection for Rows ')]")));
		
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e1.getText(), "Product");
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
		Assert.assertEquals(e4.getText(), "<Element Name>");
		System.out.println("Value present in Display displayed correctly");
		test.info("Value present in Display displayed correctly");	
		Thread.sleep(500);
		List<WebElement> AB = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for Rows')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB)
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		}
		
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

		Thread.sleep(500);
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
		
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
       try{
			for(int i=0;i<=SelectableElementvalue.size()-1;i++)
			{
				String valueofcontainerele =SelectableElementvalue.get(i).getText();
				System.out.println(valueofcontainerele);

				if(valueofcontainerele.contains("ScriptDDlMDX"))
				{
					System.out.println("ScriptDDlMDX is present");
					test.info("ScriptDDlMDX is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='ScriptDDlMDX']");
					log.driver.findElement(By.xpath("//span[text()='ScriptDDlMDX']")).click();
					Thread.sleep(500);
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Delete']");
					log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
					Thread.sleep(500);
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
        Thread.sleep(500);
        waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='New...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='New...']")).isDisplayed(),true);

		findVisible(By.xpath("//button[text()='New...']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Element']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='New Element']")).isDisplayed(),true);

		List<WebElement> ElementGrp = findAllVisible(By.xpath("//span[text()='Available element types:']/following::div[2]/div/div"));
		List<String> ElegroupValue= new ArrayList<String>();
		System.out.println("Element Group option values");
		ElegroupValue.add("Criteria DDL");
		ElegroupValue.add("Data DDL");
		ElegroupValue.add("Script DDL");
		ElegroupValue.add("Standard SDL");

		for(int i =0;i<ElementGrp.size()-1;i++)
		{
			assertEquals(ElementGrp.get(i).getText(), ElegroupValue.get(i));
			System.out.println(ElementGrp.get(i).getText());

		}
//		Thread.sleep(500);
//		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[1]")).getCssValue("background-color").contains("255, 212, 0"), "Criteria DDL got higlighted");
//		System.out.println("Criteria DDL got highlighted");
//		Thread.sleep(500);
		ElementGrp.get(2).click();
//		Thread.sleep(500);
//		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[3]")).getCssValue("background-color").contains("255, 212, 0"), "container element got higlighted");
		System.out.println("Script SDL got selected");
//		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(500);	

		Assert.assertTrue(findVisibleBool(By.xpath("//span[contains(text(),'New Script DDL')]")));
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Name']/ancestor::div[3]/div[2]/div/div/input");
	    log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).sendKeys("ScriptDDlMDX");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).isDisplayed())
			{
				log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
				Thread.sleep(500);
			}
		}catch(Exception ex)
		{
			
		}
		
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Type of Script']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Type of Script']")).isDisplayed(),true);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Type of Script']/ancestor::div[3]/div[2]/div[1]/div/div/table/tbody/tr/td/label");
		List<WebElement> Script = log.driver.findElements(By.xpath("//span[text()='Type of Script']/ancestor::div[3]/div[2]/div[1]/div/div/table/tbody/tr/td/label"));
		ArrayList<String> Scriptvalue= new ArrayList<String>();
		System.out.println("Script radio btn values");
		Scriptvalue.add("TCL Script");
		Scriptvalue.add("MDX Expression");
		for(int i =0;i<=Script.size()-1;i++) 
		{
			//String check = window_button.get(i).getText();
			assertEquals(Script.get(i).getText(), Scriptvalue.get(i));
			System.out.println(Script.get(i).getText());

		}
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='TCL Script']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='TCL Script']/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='MDX Expression']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='MDX Expression']/ancestor::td[1]/input[1]")).isSelected(),false);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='MDX Expression']");
		log.driver.findElement(By.xpath("//label[text()='MDX Expression']")).click();
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='MDX Expression']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='MDX Expression']/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(200);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Script Definition']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Script Definition']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Script Definition']/ancestor::div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/span[1]");
		WebElement elmntindrpdwn=log.driver.findElement(By.xpath("//span[text()='Script Definition']/ancestor::div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwn.getText(),"SET Expression");
		System.out.println(elmntindrpdwn.getText());
		System.out.println("SET Expression is selected in drop down");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='MDX Expression:']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='MDX Expression:']/following::textarea[2]")).isEnabled(),true);
		Actions action = new Actions(log.driver);
		action.moveToElement(log.driver.findElement(By.xpath("//span[text()='MDX Expression:']/following::textarea[2]")));
		action.click();
		action.sendKeys("Filter([Products].[Product].[Model].AllMembers,[Products].[Product].Properties( \"CarType\" ) = \"Limousine\") ");
		action.build().perform();
		Thread.sleep(500);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(500);
		try
		{
			log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
			Thread.sleep(500);	
		}
		catch(Exception e)
		{
			System.out.println("Finish btn Clicked");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt=findVisible(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		action.click(elemnt).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		//action.click(elemnt).sendKeys("Container elements", Keys.ENTER).build().perform();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			String aa = selectble_ele.get(i).getText();
			selectable.add(aa);
			if(selectable.contains("ScriptDDlMDX"))
			{
				assertTrue(true);
				
			}
			
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(500);

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));

		for(int i=1;i<23;i++)
		{
			action.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(500);
			if(elemnt1.getText().equals("ScriptDDlMDX"))
			{
				action.click(elemnt1).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(500);
				break;
			}
		}


		Assert.assertEquals(elemnt1.getText(), "ScriptDDlMDX");
		Thread.sleep(500);

		clickableClick(By.xpath("(//button[@data-title='Select all visible items'])[1]"));
		clickableClick(By.xpath("//button[@data-title='Inserts only selected items to the selection list']"));//step 23

//		List<WebElement> Base_ele = findAllVisible(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div"));
		int count = Integer.parseInt(findVisible(By.xpath("//span[contains(text(), 'Base elements with containers')]")).getText().replaceAll("[^\\d.]", ""));
//		for (WebElement webElement : Base_ele)
//		{
//			//webElement.getText();
//			count++;
//		}
//		System.out.println(count);
//		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt_Container=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		//action.click(elemnt_Container).sendKeys("Container elements", Keys.ENTER).build().perform();
		for(int i=1;i<23;i++)
		{
			action.click(elemnt_Container).sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(100);
			if(elemnt_Container.getText().equals("Container elements"))
			{
				action.click(elemnt_Container).sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(500);
				break;
			}
		}
		
		Assert.assertEquals(elemnt_Container.getText(), "Container elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='ScriptDDlMDX']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='ScriptDDlMDX']/../div[1]")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='ScriptDDlMDX']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='ScriptDDlMDX']/../div[1]/input[1]")).isSelected());
		System.out.println("ScriptDDlMDX Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='User defined...']");
		log.driver.findElement(By.xpath("//button[text()='User defined...']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='Edit User-Defined Element Display']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit User-Defined Element Display']")).isDisplayed(),true);
		
		action.moveToElement(log.driver.findElement(By.xpath("//span[text()='User-defined display string:']/ancestor::div[3]/div[3]/div[1]/div[1]/textarea[1]")));
		action.click();
		action.sendKeys("({{CarType}}) - {{E}}");
		action.build().perform();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(500);	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(500);	
		try
		{
			log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
			Thread.sleep(500);	
		}
		catch(Exception e)
		{
			System.out.println("OK btn Clicked");
		}
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='(Limousine) - TSX']");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='(Limousine) - TSX']")).isDisplayed());
		/*action.contextClick(log.driver.findElement(By.xpath(("//div[text()='(Limousine) - TSX']")))).build().perform();
		Thread.sleep(500);*/
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[.='(Limousine) - TSX']");
		log.driver.findElement(By.xpath("//div[text()='(Limousine) - TSX']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[.='(Limousine) - TSX']");
		action.contextClick(log.driver.findElement(By.xpath(("//div[.='(Limousine) - TSX']")))).build().perform();
		Thread.sleep(500);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='(Limousine) - TSX']")).isDisplayed())
			{
				System.out.println("(Limousine) - TSX'] Available");
			}
		}
		catch(Exception e)
		{
			 Actions act = new Actions(log.driver);
		     act.contextClick(log.driver.findElement(By.xpath("//div[@id='-1/1']"))).perform();
		     Thread.sleep(500);
		}
		
		Thread.sleep(500);
		List<WebElement> ContextClick = log.driver.findElements(By.xpath("//div[@class='k-animation-container']/ul/li/span[1]"));
		assertEquals(ContextClick.get(0).getText(),"(Limousine) - TSX");
		Thread.sleep(500);
		assertEquals(ContextClick.get(9).getText(),"Hide empty rows");
		System.out.println(ContextClick.get(9).getText());
		ContextClick.get(9).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[.='All Periods']/ancestor::div[3]/div[2]/div/div");
		List<WebElement> rowvaluetab = findAllVisible(By.xpath("//div[.='All Periods']/ancestor::div[3]/div[2]/div/div"));
		int counttab=0;
		for(int i=0;i<rowvaluetab.size()-1;i++)
		{
			//System.out.println(rowvaluetab.get(i).getText());
			counttab++;
		}
		System.out.println("valueoftab"+counttab);
		
		if(count==counttab)
		{
			System.out.println(" values of the tab is matching with script ddl value");
		}
		else
		{
			System.out.println("not Matching");
			
		}
//		Assert.assertTrue(Base_ele.retainAll(rowvaluetab));
		Assert.assertTrue(count==counttab);
		System.out.println(" values of the tab is matching with script ddl value");
		
		//save the report
		 log.driver.findElement(By.xpath("(//span[text()='Save'])[2]/following::span[1]")).click();
		 Thread.sleep(500);
		 //Click Down and do Save As:====================
		 log.driver.findElement(By.xpath("(//span[text()='Save As'])[2]")).click();
		 Thread.sleep(500);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report']")).isDisplayed());
		 Thread.sleep(500);
		 System.out.println("Save Report as window is displaying now.");
		
		 //Change Name:===========
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		 waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Name'])[1]/following::input[1]");
		 Thread.sleep(500);
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Script_DDl_for_Container_MDX_element");
		 Thread.sleep(500);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(500);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(500);
		
		try
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'A report named')]")).isDisplayed();
			log.driver.findElement(By.xpath("//input[@value='OK']")).click();
			System.out.println("popup appeared");
		}
		catch(Exception e)
		{
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Script_DDl_for_Container_MDX_element']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Script_DDl_for_Container_MDX_element']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}
		
		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Script_DDl_for_Container_MDX_element'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Script_DDl_for_Container_MDX_element'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(500);
	
		action.contextClick(log.driver.findElement(By.xpath("(//span[text()='Script_DDl_for_Container_MDX_element'])[1]"))).perform();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(500);
	}
}
