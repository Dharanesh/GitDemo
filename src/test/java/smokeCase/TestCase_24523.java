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

import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24523  extends TestUtils
{
	@Test	
	@Parameters("browser")

	//Web_Testcase to verify functionality of Analytical Visualization  MiniChart_Bar_New
	public void Testcase_Cockpit10_Analytical_Viz_Minichart_New(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24523 for creating Selection bar Layout component in standard report");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);

		clickableClick(By.xpath("//span[text()='Sales by country']"));

		click(By.xpath("//span[text()='Components']"));
		click(By.xpath("(//a[@data-title='Create a New Report Component'])[1]"));
		click(By.xpath("//span[text()='New Layout Component...']"));

		waitForClickableElement(By.xpath("//input[@value='Next >>']"));
		List<WebElement>reports=findAll(By.xpath("//span[@class='reportNametxt']"));
		ArrayList<String>List = new ArrayList();
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
		Thread.sleep(1000);
		Assert.assertEquals(tile, "Title");		
		String textpresent = log.driver.findElement(By.xpath("//div[@class='w20_newwiz_description']")).getText();
		Assert.assertEquals(textpresent, "Inserts a title into the report.");
		log.driver.findElement(By.xpath("//span[text()='Table']")).click();
		Thread.sleep(1000);
		String map = log.driver.findElement(By.xpath("//div[@class='reportLitile cursor k-state-selected' and @aria-selected='true']")).getText();
		Thread.sleep(1000);
		Assert.assertEquals(map, "Table");	
		assertEquals("Inserts a table into the report.", log.driver.findElement(By.xpath("//div[@class='w20_newwiz_description']")).getText());
		
		List<WebElement> buttons = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		ArrayList<String> buttonList = new  ArrayList();
		buttonList.add("Next >>");
		buttonList.add("Cancel");
		buttonList.add("Help");
		for (int  i =0;i<=buttons.size()-1;i++) 
		{
			
			assertEquals(buttons.get(i).getAttribute("value"), buttonList.get(i));
		}

		clickableClick(By.xpath("//input[@value='Next >>']"));

		assertEquals("DataView Assignment", findVisible(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		assertEquals("New...", log.driver.findElement(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button'])[1]")).getText());
		assertEquals("Assign...", log.driver.findElement(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button'])[2]")).getText());
		assertEquals("Remove", log.driver.findElement(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button'])[3]")).getText());
		log.driver.findElement(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button'])[2]")).click();

		assertEquals(findVisible(By.xpath("//span[text()='Please select a report component:']")).getText(), "Please select a report component:");
		clickableClick(By.xpath("//input[@value='OK']"));

		assertEquals(findVisible(By.xpath("//span[text()='DataView Assignment']")).getText(), "DataView Assignment");
		clickableClick(By.xpath("//input[@value='Next >>']"));

		assertEquals(findVisible(By.xpath("//span[text()='Position in report']")).getText(), "Position in report");
		clickableClick(By.xpath("//input[@value='Next >>']"));

		assertEquals(findVisible(By.xpath("//span[text()='Settings for the layout component']")).getText(), "Settings for the layout component");
		log.driver.findElement(By.xpath("//div[text()='Autofit']/../../../td[3]/div")).click();
		Thread.sleep(500);
		assertTrue(log.driver.findElement(By.xpath("(//td[@class='prgit'])[2]")).isEnabled());
		Thread.sleep(500);	
		log.driver.findElement(By.xpath("(//span[@class='w20_dialogtitleicon k-icon sf-icon-minu-cw w20_property_category w20_aligner'])[1]")).click();

//		List<WebElement> tablist = log.driver.findElements(By.xpath("//tr[@class='w20_property_category']/td[2]/a/span"));

		List<By> tablist = new ArrayList<>();
		tablist.add(By.xpath("//span[contains(text(),'Position')]"));
		tablist.add(By.xpath("//span[contains(text(),'Rows')]"));
		tablist.add(By.xpath("//span[contains(text(),'Columns')]"));
		tablist.add(By.xpath("//span[contains(text(),'Data Area')]"));

		List<String> tab = new ArrayList();
		tab.add("Position");
		tab.add("Rows");
		tab.add("Columns");
		tab.add("Data Area");

		for(int i = 0; i < tab.size() - 1; i++) {
			assertEquals(waitForVisibilityOfElement(tablist.get(i)).getText(), tab.get(i));
		}

		clickableClick(By.xpath("//input[@value='Next >>']"));
		assertEquals(findVisible(By.xpath("//span[contains(text(),'Formatting for planning/value entry')]")).getText(), "Formatting for planning/value entry");

		clickableClick(By.xpath("//input[@value='Next >>']"));
		assertEquals(findVisible(By.xpath("//span[contains(text(),'Name and Description')]")).getText(), "Name and Description");

		List<WebElement> buttons41 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		ArrayList<String> buttonList41 = new ArrayList();
		buttonList41.add("<< Back");
		buttonList41.add("Finish");
		buttonList41.add("Cancel");
		buttonList41.add("Help");

		for (int i = 0; i < buttons41.size() - 1; i++) {
			assertEquals(buttons41.get(i).getAttribute("value"), buttonList41.get(i));
		}

		Thread.sleep(500);
		log.driver.findElement(By.xpath("//div[@class='w20_webedit']/input")).clear();
		log.driver.findElement(By.xpath("//div[@class='w20_webedit']/input")).sendKeys("Automation");
		Actions act = new Actions(log.driver);
		act.sendKeys(Keys.TAB).perform();

		clickableClick(By.xpath("//input[@value='Finish']"));

		waitForClickableElement(By.xpath("(//div[@id='-1/-1'])[2]"));
		Thread.sleep(2000);
		Utils ui =  new Utils(log.driver);
		ui.rightClick("(//div[@id='-1/-1'])[2]");
		Thread.sleep(500);
		List<WebElement> li = log.driver.findElements(By.xpath("(//ul[@data-role='contextmenu'])[3]/li/span"));
		ArrayList<String> lilist = new ArrayList();
		lilist.add("Complete Table");
		lilist.add("Start Write Mode");
		lilist.add("Transpose");
		lilist.add("Define Subview...");
		lilist.add("Analytical Visualizations");
		lilist.add("Edit Table...");
		lilist.add("Table Properties...");
		lilist.add("Information...");
		
		for (int i =0;i<=li.size()-1;i++)
		{
			
			assertEquals(li.get(i).getText(),lilist.get(i));
		}
		click(By.xpath("//span[text()='Table Properties...']"));
		waits.waituUnitil_Element_Clickable(20, "//input[@value='OK']");
		assertEquals("Properties of 'Automation'", log.driver.findElement(By.xpath("//span[@class='k-window-title']")).getText());
		assertTrue(log.driver.findElement(By.xpath("(//div[text()='Autofit']/../../../td[3]/div)[1]/input")).isSelected());
		
		log.driver.close() ;
		 
		
}

	
}
