package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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

import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24527 extends TestUtils
{
	@Test	
	@Parameters("browser")

	//Web_Testcase to verify functionality of Analytical Visualization  MiniChart_Bar_New
	public void Testcase_Cockpit10_Analytical_Viz_Minichart_New(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24527 for creating Selection bar Layout component in standard report");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		log.createCubeReport("//div[contains(text(),'Training Sales')]", "TestCase_24527", false);

		//		Create Layout compontent
		click(By.xpath("//span[text()='Components']"));
		click(By.xpath("(//a[@data-title='Create a New Report Component'])[1]"));
		click(By.xpath("//span[text()='New Layout Component...']"));

		waitForClickableElement(By.xpath("//input[@value='Next >>']"));

		List<WebElement>reports=log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
		ArrayList<String>List = new ArrayList<>();
		List.add("Title");
		List.add("Image");
		List.add("Table");
		List.add("Chart");
		List.add("Filter Bar");
		List.add("Selection Bar");
		List.add("Action Bar");
		List.add("ABC Table");
		List.add("ABC Chart");
		List.add("Horizontal Waterfall Chart");
		List.add("Vertical Waterfall Chart");
		List.add("Bubble Chart");
		List.add("Gauge");
		List.add("Map");
		List.add("OS Map");
		
		for(int i=0;i<=reports.size()-1;i++)
		{
			Assert.assertEquals(reports.get(i).getText(),List.get(i));
		}

		String tile = log.driver.findElement(By.xpath("//div[@class='reportLitile cursor k-state-selected' and @aria-selected='true']")).getText();
		Assert.assertEquals(tile, "Title");		
		String textpresent = log.driver.findElement(By.xpath("//div[@class='w20_newwiz_description']")).getText();
		Assert.assertEquals(textpresent, "Inserts a title into the report.");
		clickableClick(By.xpath("//span[text()='Selection Bar']"));

		String selc = log.driver.findElement(By.xpath("//div[@class='reportLitile cursor k-state-selected' and @aria-selected='true']")).getText();
		Thread.sleep(1000);
		Assert.assertEquals(selc, "Selection Bar");	
		assertEquals("Inserts a selection bar into the report.", log.driver.findElement(By.xpath("//div[@class='w20_newwiz_description']")).getText());
		
		List<WebElement> buttons = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		ArrayList<String> buttonList = new  ArrayList<>();
		buttonList.add("Next >>");
		buttonList.add("Cancel");
		buttonList.add("Help");
		for (int  i =0;i<=buttons.size()-1;i++) 
		{
			
			assertEquals(buttons.get(i).getAttribute("value"), buttonList.get(i));
		}

		clickableClick(By.xpath("//input[@id='okbutton']"));

		waitForClickableElement(By.xpath("//input[@value='Next >>']"));

		assertEquals(findVisible(By.xpath("//span[text()='Filter Assignment']")).getText(), "Filter Assignment");
		assertEquals(findVisible(By.xpath("//button[text()='New Filter...']")).getText(), "New Filter...");
		assertEquals(findVisible(By.xpath("//button[text()='More...']")).getText(), "More...");
		
		assertFalse(log.driver.findElement(By.xpath("(//label[@class='k-checkbox-label']/../input)[1]")).isSelected());
		Thread.sleep(500);
		clickableClick(By.xpath("//*[text()='Assign filter later.']"))
		;
		Thread.sleep(500);
		assertTrue(log.driver.findElement(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button k-state-disabled'])[1]")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button k-state-disabled'])[2]")).isDisplayed());
		clickableClick(By.xpath("//*[text()='Assign filter later.']"));

		Thread.sleep(500);
		assertEquals(findVisible(By.xpath("//button[text()='New Filter...']")).getText(), "New Filter...");
		assertEquals(findVisible(By.xpath("//button[text()='More...']")).getText(), "More...");
		clickableClick((By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button'])[1]")));

		waits.waituUnitil_Element_Clickable(20,"(//input[@value='Next >>'])[1]");
//		assertEquals(findVisible(By.xpath("(//span[text()='New Filter']")).getText(), "New Filter");

		ArrayList<String> bu = new ArrayList<>();
		bu.add("Dimension-based Filter");
		bu.add("Query-based Filter");
		bu.add("Static Filter");

		List<WebElement> butt  = log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
		for (int i =0;i<=butt.size()-1;i++) 
		{
			assertEquals(bu.get(i), butt.get(i).getText());
		}

		waitForVisibilityOfElement(By.xpath("//span[text()='Dimension-based Filter']/../../../../../div[@aria-selected='true']"));
		assertEquals(findVisible(By.xpath("//div[@class='w20_newwiz_description']")).getText(),"Creates a new dimension-based filter.");

		clickableClick(By.id("okbutton"));
		waits.waituUnitil_Element_Clickable(20,"(//input[@value='Next >>'])[1]");
		assertEquals(findVisible(By.xpath("//span[text()='Dimension of user-defined filter']")).getText(), "Dimension of user-defined filter");
		
		
		click(By.xpath("(//div[@class='w20_treeitemcollapsed'])[1]"));
		waits.waituUnitil_Element_Clickable(20,"(//span[@class='k-icon k-i-collapse'])[1]");
		//Select Sales cube and click next:=============
	   // driver.findElement(By.xpath("//div[text()='Sales']")).click();
		click(By.xpath("//div[contains(text(),'Training Sales')]"));
		waits.waituUnitil_Element_Clickable(20,"//div[@class='w20_treeitemcontent w20_treeitem_active']");
		click(By.xpath("//div[contains(text(),'Training Sales')]/../div/a"));
		Thread.sleep(1000);
		waitForClickableElement(By.xpath("//div[text()='Measures']"));
		clickableClick(By.xpath("(//span[@class='w20_dialogtitleicon k-icon sf-icon-measures-cw'])[1]"));
		clickableClick(By.xpath("(//input[@value='Next >>'])[1]"));
		waits.waituUnitil_Element_Clickable(20,"(//input[@value='Next >>'])[1]");

		assertEquals(findVisible(By.xpath("//span[text()='Element groups for filter selection']")).getText(), "Element groups for filter selection");
		assertTrue(log.driver.findElement(By.xpath("//label[text()='All global element groups']/../input")).isSelected());
		assertTrue(log.driver.findElement(By.xpath("//label[text()='User-defined selection']/../input")).isSelected());

		List<WebElement> dis = log.driver.findElements(By.xpath("//div[@class='w20_treeitemmarker']/input[@disabled='disabled']"));

		for (int i =0;i<dis.size()-1;i++)
		{
			assertFalse(dis.get(i).isEnabled());
		}

		System.out.println("======================");
		click(By.xpath("//label[text()='All global element groups']"));

		List<WebElement> tick  = findAllVisible(By.xpath("//div[@class='area']/div//div/input"));

		for(int  i =0;i<tick.size()-1;i++)
		{
			assertFalse(tick.get(i).isSelected());
		}

		click(By.xpath("//button[text()='Select all']"));
		Thread.sleep(1000);
		List<WebElement> tick1  = findAllVisible(By.xpath("//div[@class='area']/div//div/input"));

		for(int  i =0;i < tick1.size()-1;i++)
		{
			assertTrue(tick1.get(i).isSelected());
		}
		click(By.xpath("//button[text()='Select none']"));

		waitForElementNotSelected(findVisible(By.xpath("//div[@class='area']/div//div/input[1]")));

		List<WebElement> tick2  = findAllVisible(By.xpath("//div[@class='area']/div//div/input"));
		for(int i = 0;i < tick2.size() - 1; i++)
		{
			assertFalse(tick2.get(i).isSelected());
		}

		clickableClick(By.id("nextbutton"));
		waitForClickableElement(By.xpath("//input[@value='Next >>']"));
		assertEquals(findVisible(By.xpath("//span[text()='User-defined selection']")).getText(), "User-defined selection");
		waitForVisibilityOfElements(By.xpath("(//input[@class='k-textbox  w20_webedit_left ' and @disabled='disabled'])[1]"));
		assertEquals(findVisible(By.xpath("(//input[@class='k-textbox  w20_webedit_left ' and @disabled='disabled'])[1]")).getAttribute("value"), "A - Training Sales.Measures");

		clickableClick(By.xpath("//button[text()='Elements...']"));
		waitForClickableElement(By.xpath("//input[@value='OK']"));
		assertEquals("Selection for source of dimension based filter (Dimension 'Measures')", log.driver.findElement(By.xpath("(//div[@class='k-window-titlebar k-header'])[1]/span")).getText());

		clickableClick(By.xpath("//button[@data-title='Inserts all visible items to the selection list']"));
		waitForElementSelected(findVisible(By.xpath("(//div[text()='Repairs']/span/parent::div/parent::div/div/input)[2]")));
		//assertEquals(findVisible(By.xpath("(//div[text()='Repairs']/span/parent::div/parent::div/div/input)[2]")).getText(), "Repairs");

		clickableClick(By.id("okbutton"));
		waitForClickableElement(By.xpath("//input[@value='Next >>']"));
		assertEquals(findVisible(By.xpath("//span[text()='User-defined selection']")).getText(), "User-defined selection");

		List<WebElement> buttons4 = findAllVisible(By.xpath("//div[contains(text(), 'Repairs')]/parent::div/parent::div"));
		ArrayList<String> buttonList4= new  ArrayList<>();
		buttonList4.add("Purchase price");
		buttonList4.add("Repairs");
		buttonList4.add("Units purchased");

		for (int  i =0;i<buttons4.size()-1;i++)
		{
			assertEquals(buttons4.get(i).getText(), buttonList4.get(i));
		}

		clickableClick(By.xpath("//input[@value='Next >>']"));
		assertEquals(findVisible(By.xpath("//span[text()='Properties']")).getText(), "Properties");

		waitForClickableElement(By.xpath("//input[@value='Next >>']"));
		clickableClick(By.xpath("//input[@value='Next >>']"));

		waitForClickableElement(By.xpath("//input[@value='Next >>']"));
		assertEquals(findVisible(By.xpath("//span[text()='Name and Description']")).getText(), "Name and Description");

		findVisible(By.xpath("//div[@class='w20_webedit']/input")).clear();
		findVisible(By.xpath("//div[@class='w20_webedit']/input")).sendKeys("Demo");
		findVisible(By.xpath("//div[@class='w20_webedit']/textarea")).sendKeys("Demo");

		Actions act = new Actions(log.driver);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();

		waits.waituUnitil_Element_Clickable(20,"//input[@value='Next >>']");
		Thread.sleep(500);
		assertEquals("Demo",log.driver.findElement(By.xpath("//tr[@class='lvitem']/td[2]")).getText());
		Thread.sleep(1000);

		log.driver.findElement(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button k-button-icontext'])[1]")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='No']");
		assertEquals("Delete the already assigned new filter?",log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		List<WebElement> but = log.driver.findElements(By.xpath("//div[@class='w20_modal-footer']/div/input"));
		ArrayList<String> bulist = new ArrayList<>();
		bulist.add("Yes");
		bulist.add("No");
		bulist.add("Cancel");
		for (int i =0;i<=but.size()-1;i++)
		{
			assertEquals(bulist.get(i),but.get(i).getAttribute("value"));
		}

		clickableClick(By.id("cancelbutton"));
		waitForClickableElement(By.xpath("//input[@value='Next >>']"));

		clickableClick(By.id("nextbutton"));
		waitForClickableElement(By.xpath("//input[@value='Next >>']"));
		assertEquals(findVisible(By.xpath("//span[text()='Position in report']")).getText(), "Position in report");

		clickableClick(By.id("nextbutton"));
		waitForClickableElement(By.xpath("//input[@value='Next >>']"));
		assertEquals(findVisible(By.xpath("//span[text()='Settings for the layout component']")).getText(), "Settings for the layout component");

		clickableClick(By.id("nextbutton"));
		waitForClickableElement(By.xpath("//input[@value='Finish']"));
		assertEquals(findVisible(By.xpath("//span[text()='Name and Description']")).getText(), "Name and Description");

		findVisible(By.xpath("//div[@class='w20_webedit']/div/input")).clear();
		findVisible(By.xpath("//div[@class='w20_webedit']/div/input")).sendKeys("Automation");
		Thread.sleep(200);
		findVisible(By.xpath("//div[@class='w20_webedit']/div/textarea")).clear();
		findVisible(By.xpath("//div[@class='w20_webedit']/div/textarea")).sendKeys("Automation_Demo");
		act.sendKeys(Keys.TAB).perform();

		clickableClick(By.id("finishbutton"));

//		waitForVisibilityOfElement(By.xpath("//table[@id='checkboxSelections']/tbody/tr/td[2]/span"));
		List<WebElement> reo  = findAllVisible(By.xpath("//table[@id='checkboxSelections']/tbody/tr/td[2]/span"));

		ArrayList<String> reolist = new ArrayList<>();
		reolist.add("Purchase price");
		reolist.add("Repairs");
		reolist.add("Units purchased");

		for (int i=0;i<=reo.size()-1;i++)
		{
			assertEquals(reo.get(i).getText(), reolist.get(i));
		}
		Thread.sleep(1000);
		Utils ui  = new Utils(driver);
		ui.rightClick("//span[text()='Purchase price']");
		Thread.sleep(500);
			
		List<WebElement> li = findAllVisible(By.xpath("//ul[@data-role='contextmenu' and @class='w20_menu w20_kendo " +
				"k-widget k-reset k-header k-menu k-menu-vertical k-context-menu k-popup k-group ui-draggable ui-draggable-handle k-state-border-down k-state-border-up']"));

		ArrayList<String>lilist = new ArrayList<>();
		lilist.add("Demo");
		lilist.add("Edit Filter...");
		lilist.add("Filter Properties...");
		lilist.add("Selection Bar Properties...");
		lilist.add("Information...");

		for (int i =0;i<li.size()-1;i++)
		{
			assertEquals(li.get(i).getText(),lilist.get(i));
		}

		clickableClick(By.xpath("//span[text()='Selection Bar Properties...']"));
		waitForClickableElement(By.xpath("//input[@value='OK']"));
		assertEquals(findVisible(By.xpath("//span[contains(text(), 'Properties of')]")).getText(), "Properties of 'Automation'");
	}
}
