package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24522 extends TestUtils
{
	@Test	
	@Parameters("browser")

	//Web_Testcase to verify functionality of Analytical Visualization  MiniChart_Bar_New
	public void Testcase_Cockpit10_Analytical_Viz_Minichart_New(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24522 to verify Table Layout component in Standard Report with enabled   'Define DataViews later'");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		log.createCubeReport("//div[contains(text(),'Training Sales')]", "TestCase_24527", false);

		List<WebElement> Mlist = log.driver.findElements(By.xpath("//ul[@class='w20_toolbar_mainlist']/li/span[2]"));
		ArrayList<String> list = new  ArrayList();
		list.add("New");
		list.add("Open");
		list.add("Save");
		list.add("Filter");
		list.add("Refresh");
		list.add("Presentation");
		list.add("Print");
		list.add("Layout");
		list.add("Export");
		for(int i =0;i<=list.size()-1;i++) 
		{
			assertEquals(Mlist.get(i).getText(), list.get(i));
		}
		log.driver.findElement(By.xpath("//span[text()='Components']")).click();
		Thread.sleep(5000);
		waits.waituUnitil_Element_Clickable(20,"//div[text()='Layout Components']");
		Utils ui = new Utils(log.driver);
		ui.rightClick("(//div[text()='TestCase_24527'])[1]");
		Thread.sleep(500);
		List<WebElement> tlist = log.driver.findElements(By.xpath("(//ul[@role='menubar'])[3]/li/span"));
		ArrayList<String> tlist1 = new ArrayList();
		tlist1.add("TestCase_24527");
		tlist1.add("Paste");
		tlist1.add("New Layout Component...");
		tlist1.add("New DataView...");
		tlist1.add("New User-defined Filter...");
		tlist1.add("New Action...");
		tlist1.add("New Analytical Visualization...");
		tlist1.add("Edit Report Properties...");
		tlist1.add("Properties...");
		for(int i=0;i<=tlist.size()-1;i++) 
		{
			assertEquals(tlist.get(i).getText(), tlist1.get(i));
		}
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='New Layout Component...']")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Next >>']");
		List<WebElement>reports=log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
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
		log.driver.findElement(By.id("okbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Next >>']");
		assertEquals("DataView Assignment", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		
		List<WebElement> but = log.driver.findElements(By.xpath("//button[@class='cw_button w20_button w20_kendo k-button']"));
		ArrayList<String> bu = new ArrayList();
		bu.add("New...");
		bu.add("Assign...");
		bu.add("Remove");
		for(int i=0;i<=2;i++) 
		{
			assertEquals(bu.get(i), but.get(i).getText());
			assertTrue(but.get(i).isEnabled());
			
		}
		log.driver.findElement(By.xpath("//label[text()='Define DataViews later']")).click();
		Thread.sleep(500);
		List<WebElement> dis= log.driver.findElements(By.xpath("//div[@id='IDDIVBUTTONS']/div/button[@disabled='disabled']"));
		for (int  i =0;i<=dis.size()-1;i++) 
		{
			assertTrue(dis.get(i).isDisplayed());
		}
	log.driver.findElement(By.id("nextbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Next >>']");
		assertEquals("Position in report", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		log.driver.findElement(By.id("nextbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Next >>']");
		assertEquals("Settings for the layout component", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		Thread.sleep(2000);
	
		log.driver.findElement(By.xpath("//div[text()='Autofit']/../../../td[3]/div")).click();
		Thread.sleep(2000);
		assertTrue(log.driver.findElement(By.xpath("(//td[@class='prgit'])[2]")).isEnabled());
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//div[text()='Show row headers']/../../../td[3]/div")).click();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//div[text()='Show column headers']/../../../td[3]/div")).click();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//div[text()='Show gridlines']/../../../td[3]/div")).click();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("(//span[@class='w20_dialogtitleicon k-icon sf-icon-minu-cw w20_property_category w20_aligner'])[1]")).click();
	
		List<WebElement> buttons4 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		ArrayList<String> buttonList4= new  ArrayList();
		buttonList4.add("<< Back");
		buttonList4.add("Next >>");
		buttonList4.add("Finish");
		buttonList4.add("Cancel");
		buttonList4.add("Help");
		for (int  i =0;i<=buttons4.size()-1;i++) 
		{
			
			assertEquals(buttons4.get(i).getAttribute("value"), buttonList4.get(i));
		}
		log.driver.findElement(By.id("nextbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
		assertEquals("Formatting for planning/value entry", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		assertEquals("Highlight changed cells:", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[3]")).getText());
		assertEquals("Highlight cells with holding:", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[4]")).getText());
		log.driver.findElement(By.xpath("(//button[text()='Edit ...'])[1]")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Default']");
		assertEquals("Properties of Column",log.driver.findElement(By.xpath("(//span[@class='k-window-title'])[1]")).getText());
		List<WebElement> def = log.driver.findElements(By.xpath("//span[text()='Alignment']/following::span[@class='k-dropdown-wrap k-state-default']/span[1]"));
		for(int  i =0;i<=3;i++) 
		{
			assertEquals("Default", def.get(i).getText());
		}
		log.driver.findElement(By.id("okbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
		
		log.driver.findElement(By.xpath("(//button[text()='Edit ...'])[2]")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Default']");
		
		
		List<WebElement> def1 = log.driver.findElements(By.xpath("//span[text()='Alignment']/following::span[@class='k-dropdown-wrap k-state-default']/span[1]"));
		for(int  i =0;i<=2;i++) 
		{
			assertEquals("Default", def1.get(i).getText());
		}
		log.driver.findElement(By.id("okbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
		
		
		List<WebElement> buttons41 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		ArrayList<String> buttonList41= new  ArrayList();
		buttonList41.add("<< Back");
		buttonList41.add("Next >>");
		buttonList41.add("Finish");
		buttonList41.add("Cancel");
		buttonList41.add("Help");
		for (int  i =0;i<=buttons4.size()-1;i++) 
		{
			
			assertEquals(buttons41.get(i).getAttribute("value"), buttonList41.get(i));
		}
		log.driver.findElement(By.id("nextbutton")).click();
		
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
		assertEquals("Name and Description", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		log.driver.findElement(By.id("finishbutton")).click();
		waits.waituUnitil_Element_Clickable(30,"//li[@class='k-item k-state-default k-first k-last k-tab-on-top k-state-active']/span[@class='k-link']");
		Thread.sleep(2000);
		assertTrue(log.driver.findElement(By.xpath("(//div[@class='cwcell  gcnn gdar'])[3]")).isDisplayed());
		assertEquals("Invalid or no updated data!", log.driver.findElement(By.xpath("(//div[@class='cwcell  gcnn gdar'])[3]")).getText());
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//div[text()='DataViews']/../div[1]")).click();
		Thread.sleep(500);
		WebElement from = log.driver.findElement(By.xpath("//div[text()='A - Training Sales']"));
		WebElement to = log.driver.findElement(By.xpath("(//div[text()='Table 2'])[1]"));
		ui.dragAndDrop(from, to);
		Thread.sleep(3000);
		String value = log.driver.findElement(By.xpath("(//div[@class='w20_grid_datapart']/div/div)[1]")).getText();
		String value1 = log.driver.findElement(By.xpath("(//div[@class='w20_grid_datapart']/div/div)[2]")).getText();
		assertEquals(value, value1);
		
		ui.rightClick("(//div[@class='w20_grid_datapart']/div/div)[2]");
		
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//span[text()='Table Properties...']")).click();
		waits.waituUnitil_Element_Clickable(20, "//input[@value='OK']");
		assertEquals("Properties of 'Table 2'", log.driver.findElement(By.xpath("//span[@class='k-window-title']")).getText());
		log.driver.close();
		


}
}