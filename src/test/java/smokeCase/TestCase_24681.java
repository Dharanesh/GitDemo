package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24681 extends TestUtils {
	@Test
	@Parameters("browser")
	public void Testcase_for_Changing_ownerShip_to_different_user(String browser) throws Exception
	{
		//Testcase step 1 to step 4
		// login to the application
		test =extent.createTest("TestCase_24681 for Creating Standard report with table Layout component");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);

		//		log.createReport(log.driver,"Sales");
			Waits waits = new Waits(log.driver);
			Utils ui = new Utils(log.driver);
			java.util.List<WebElement> menu=log.driver.findElements(By.xpath("//ul[@class='w20_toolbar_mainlist']/li[@id]"));
			ArrayList<String> menulist = new ArrayList();
			menulist.add("New");
			menulist.add("Open");
			menulist.add("Save");
			menulist.add("Filter");
			menulist.add("Refresh");
			menulist.add("Presentation");
			menulist.add("Print");
			menulist.add("Layout");
			menulist.add("Export");
			for (int  i =0;i<=menu.size()-1;i++) 
			{
				assertEquals(menulist.get(i),menu.get(i).getText());
			}
			menu.get(0).click();
			List<WebElement>reports =log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
			ArrayList<String> reportList  = new ArrayList();
			reportList.add("Standard Report");
			reportList.add("ABC Classification");
			reportList.add("Empty Report");
			reportList.add("Relational Report");
			reportList.add("MDX Report");
			reportList.add("Entry Report");
			reportList.add("Report from a Template");
			reportList.add("Local Export");
			for (int i =0;i<=reports.size()-1;i++) 
			{
				assertEquals(reportList.get(i), reports.get(i).getText());
			}
			Thread.sleep(500);
			assertTrue(log.driver.findElement(By.xpath("//span[text()='Standard Report']/../../../../../div[@class='reportLitile cursor k-state-selected' and @aria-selected='true']")).isDisplayed());
			Thread.sleep(500);
			log.driver.findElement(By.xpath("//span[text()='ABC Classification']")).click();
			List<WebElement> buttons = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
			ArrayList<String> buttonList = new  ArrayList();
			buttonList.add("Next >>");
			buttonList.add("Cancel");
			buttonList.add("Help");
			for (int  i =0;i<=buttons.size()-1;i++) 
			{
				
				assertEquals(buttons.get(i).getAttribute("value"), buttonList.get(i));
			}
				buttons.get(0).click();
				waits.waituUnitil_Element_Clickable(20,"//input[@id='finishbutton']");
				Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Select Cube']")).isDisplayed());
				Thread.sleep(500);
				log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
				assertTrue(log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).isDisplayed());
				log.driver.findElement(By.id("okbutton")).click();
				waits.waituUnitil_Element_Clickable(20,"//input[@id='finishbutton']");
				log.driver.findElement(By.xpath("(//div[@class='w20_treeitemcollapsed'])[1]")).click();
				Thread.sleep(1000);
				log.driver.findElement(By.xpath("//div[contains(text(),'Training Sales')]")).click();
				log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
				waits.waituUnitil_Element_Clickable(20,"//input[@id='finishbutton']");
				Thread.sleep(1000);
				List<WebElement> buttons1 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
				ArrayList<String> buttonList1 = new  ArrayList();
				buttonList1.add("<< Back");
				buttonList1.add("Next >>");
				buttonList1.add("Finish");
				buttonList1.add("Cancel");
				buttonList1.add("Help");
				for (int  i =0;i<=buttons1.size()-1;i++) 
				{
					
					assertEquals(buttons1.get(i).getAttribute("value"), buttonList1.get(i));
				}
					Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Dimension Selection']")).isDisplayed());
					assertEquals("Use all dimensions of cube", log.driver.findElement(By.xpath("(//input[@type='radio']/following::label)[1]")).getText());
					assertEquals("Use only selected dimensions", log.driver.findElement(By.xpath("(//input[@type='radio']/following::label)[2]")).getText());
					assertTrue((log.driver.findElement(By.xpath("(//input[@type='radio'])[1]")).isSelected()));
					
					

				
					List<WebElement> buttons2 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
					ArrayList<String> buttonList2= new  ArrayList();
					buttonList2.add("<< Back");
					buttonList2.add("Next >>");
					buttonList2.add("Finish");
					buttonList2.add("Cancel");
					buttonList2.add("Help");
					for (int  i =0;i<=buttons2.size()-1;i++) 
					{
						
						assertEquals(buttons2.get(i).getAttribute("value"), buttonList2.get(i));
					}
						log.driver.findElement(By.id("nextbutton")).click();
						waits.waituUnitil_Element_Clickable(20,"//input[@id='finishbutton']");
						Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Report Layout']")).isDisplayed());
						List<WebElement>reportLayouot=log.driver.findElements(By.xpath("//span[text()='Report Layout']/following::label[@class='k-radio-label']"));
						ArrayList<String>rlayout = new ArrayList();
						rlayout.add("Table only");
						rlayout.add("Chart only");
						rlayout.add("Table and chart tiled vertically");
						rlayout.add("Table and chart tiled horizontally");
						for (int i =0;i<=reportLayouot.size()-1;i++) 
						{
							assertEquals(rlayout.get(i),reportLayouot.get(i).getText());
						}
						assertTrue(log.driver.findElement(By.xpath("//label[text()='Table and chart tiled vertically']/../input")).isSelected());
						Thread.sleep(5000);
						//assertEquals("http://192.168.103.39/Cockpit10/images/wiz_view_abc_vertically.gif", log.driver.findElement(By.xpath("//div[@class='w20_contentpane w20_kendo']/img")).getAttribute("src"));
						Thread.sleep(1000);
						log.driver.findElement(By.xpath("(//div[@class='w20_radiobutton'])[4]")).click();
						Thread.sleep(1000);
						System.out.println(log.driver.findElement(By.xpath("//div[@class='w20_contentpane w20_kendo']/img")).getAttribute("src"));
						//assertEquals("http://192.168.103.39/Cockpit10/images/wiz_view_abc_horizontally.gif", log.driver.findElement(By.xpath("//div[@class='w20_contentpane w20_kendo']/img")).getAttribute("src"));
						System.out.println(log.driver.findElement(By.xpath("//div[@class='w20_contentpane w20_kendo']/img")).getAttribute("src"));
						log.driver.findElement(By.id("nextbutton")).click();
						waits.waituUnitil_Element_Clickable(20,"//input[@id='finishbutton']");
						Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Filter Components']")).isDisplayed());
						assertEquals("Display filter bar", log.driver.findElement(By.xpath("(//input[@type='checkbox']/following::label)[1]")).getText());
						assertEquals("Display selection bar", log.driver.findElement(By.xpath("(//input[@type='checkbox']/following::label)[2]")).getText());
						assertTrue(log.driver.findElement(By.xpath("//label[text()='Display filter bar']/../input[@type='checkbox']")).isSelected());
						List<WebElement>gray= log.driver.findElements(By.xpath("//label[text()='Display filter bar']/following::input[@disabled='disabled']/following::label[@class='k-radio-label']"));
						ArrayList<String> grayout= new ArrayList();
						grayout.add("in rows");
						grayout.add("in columns");
						grayout.add("as a background dimension");
						for (int i =0;i<=gray.size()-1;i++) 
						{
							assertEquals(grayout.get(i), gray.get(i).getText());
						}
						log.driver.findElement(By.xpath("//label[text()='Display selection bar']")).click();
						Thread.sleep(200);
						List<WebElement>gray1= log.driver.findElements(By.xpath("//label[text()='Display filter bar']/following::label[@class='k-radio-label']"));
						ArrayList<String> grayout1= new ArrayList();
						grayout1.add("in rows");
						grayout1.add("in columns");
						grayout1.add("as a background dimension");
						for (int i =0;i<=gray1.size()-1;i++) 
						{
							assertEquals(grayout1.get(i), gray1.get(i).getText());
						}
						log.driver.findElement(By.xpath("//label[text()='Display selection bar']")).click();
						Thread.sleep(200);
						log.driver.findElement(By.id("nextbutton")).click();
						waits.waituUnitil_Element_Clickable(20,"//input[@id='finishbutton']");
						Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[contains(text(),'next')]")).isDisplayed());
						Thread.sleep(500);
						assertEquals("Don't show this page again", log.driver.findElement(By.xpath("//label[@class='k-checkbox-label']")).getText());

						List<WebElement> buttons3 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
						ArrayList<String> buttonList3= new  ArrayList();
						buttonList3.add("<< Back");
						buttonList3.add("Next >>");
						buttonList3.add("Finish");
						buttonList3.add("Cancel");
						buttonList3.add("Help");
						for (int  i =0;i<=buttons3.size()-1;i++) 
						{
							
							assertEquals(buttons3.get(i).getAttribute("value"), buttonList3.get(i));
						}
						log.driver.findElement(By.id("nextbutton")).click();
						waits.waituUnitil_Element_Clickable(20,"//input[@id='finishbutton']");
						Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed());
						log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).clear();
						log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("ABC Classification Report");
						log.driver.findElement(By.xpath("//textarea[@class='k-textbox w20_webedit']")).sendKeys("ABC Classification Report");
						List<WebElement> buttons4 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
						ArrayList<String> buttonList4= new  ArrayList();
						buttonList4.add("<< Back");
						buttonList4.add("Finish");
						buttonList4.add("Cancel");
						buttonList4.add("Help");
						for (int  i =0;i<=buttons4.size()-1;i++) 
						{
							
							assertEquals(buttons4.get(i).getAttribute("value"), buttonList4.get(i));
						}
						Actions act  = new Actions(log.driver);
						act.sendKeys(Keys.TAB).perform();
						log.driver.findElement(By.id("finishbutton")).click();
						waits.waituUnitil_Element_Clickable(30,"//li[@class='k-item k-state-default k-first k-last k-tab-on-top k-state-active']/span[@class='k-link']");
						Thread.sleep(5000);
						assertEquals("ABC Classification Report", log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).getText());
						boolean checc =log.driver.findElement(By.xpath("//div[@data-widgetname='cw_grid']/div")).isDisplayed();
						boolean checc1 =log.driver.findElement(By.xpath("//span[@class='k-widget k-dropdowntree cwDropDown']")).isDisplayed();
						boolean checc2 =log.driver.findElement(By.xpath("(//img[@class='w20_image '])[2]")).isDisplayed();
						assertTrue(checc);
						assertTrue(checc1);
						assertTrue(checc2 );
						Thread.sleep(500);
						log.driver.close();

	
	
	}						
}