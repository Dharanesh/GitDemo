package smokeCase;

import static org.testng.Assert.assertEquals;

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

public class TestCase_25787 extends TestUtils
{
	@Test	
	@Parameters("browser")

	//Web_Testcase to verify functionality of Analytical Visualization  MiniChart_Bar_New
	public void Testcase_Cockpit10_Analytical_Viz_Minichart_New(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_25787_ for creating Map Layout in standard report");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		log.createCubeReport("//div[contains(text(),'Training Sales')]", "TestCase_25787", false);

		waitForVisibilityOfElement(By.xpath("//span[text()='Components']"));
		
//		Create Layout compontent
		click(By.xpath("//span[text()='Components']"));
		click(By.xpath("(//a[@data-title='Create a New Report Component'])[1]"));
		click(By.xpath("//span[text()='New Layout Component...']"));

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
		log.driver.findElement(By.xpath("//span[text()='Map']")).click();
		String map = log.driver.findElement(By.xpath("//div[@class='reportLitile cursor k-state-selected' and @aria-selected='true']")).getText();
		Thread.sleep(1000);
		Assert.assertEquals(map, "Map");	
		
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
		List<WebElement>confMap = log.driver.findElements(By.xpath("//div[@class='w20_label']/span"));
		ArrayList<String> confi = new ArrayList();
		confi.add("Background shape set selection");
		confi.add("DataView:");
		confi.add("Display Mode:");	
		confi.add("Assigned shape set:");
		confi.add("Properties");
		for (int  i =0;i<confMap.size()-1;i++)
		{
		assertEquals(confMap.get(i).getText(),confi.get(i));
		}
		Thread.sleep(3000);
		assertEquals("(none)", log.driver.findElement(By.xpath("(//span[@class='k-widget k-dropdown w20_kendo cwDropDown']/span)[1]")).getText());
		assertEquals("A - Training Sales", log.driver.findElement(By.xpath("(//span[@class='k-widget k-dropdown w20_kendo cwDropDown']/span)[2]")).getText());
		assertEquals("Show element-bound shapes", log.driver.findElement(By.xpath("(//span[@class='k-widget k-dropdown w20_kendo cwDropDown']/span)[3]")).getText());
		Thread.sleep(3000);
		assertEquals(findVisible(By.xpath("(//span[@class='k-widget k-dropdown w20_kendo cwDropDown']/span)[4]")).getText(), "Region and Zone");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button' and  @aria-disabled='false'])[1]")).isDisplayed());
		Assert.assertTrue(log.driver.findElement(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button k-state-disabled' and  @aria-disabled='true'])[1]")).isDisplayed());
		Assert.assertTrue(log.driver.findElement(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button k-state-disabled' and  @aria-disabled='true'])[2]")).isDisplayed());
		
		Assert.assertFalse(log.driver.findElement(By.xpath("//*[text()='ABC classification']/../input")).isSelected()); 
		Assert.assertTrue(log.driver.findElement(By.xpath("//*[text()='Show all shapes of shape set']/../input")).isSelected()); 
		Assert.assertFalse(log.driver.findElement(By.xpath("//*[text()='Assign DataViews and shape sets later']/../input")).isSelected());
		log.driver.findElement(By.xpath("//*[text()='Shape Properties ...']")).click();
		waits.waituUnitil_Element_Clickable(20, "//input[@value='OK']");
		assertEquals("Format", log.driver.findElement(By.xpath("(//div[@class='k-window-titlebar k-header'])[1]")).getText());
		Thread.sleep(500);

		log.driver.findElement(By.id("okbutton")).click();
		assertEquals(findVisible(By.xpath("//span[text()='Configure map component']")).getText(), "Configure map component");

		log.driver.findElement( By.id("nextbutton")).click();
		assertEquals(findVisible(By.xpath("//span[text()='Position in report']")).getText(), "Position in report");

		click( By.id("nextbutton"));
		assertEquals(findVisible(By.xpath("//span[text()='Settings for the layout component']")).getText(), "Settings for the layout component");

		List<WebElement>settingList = log.driver.findElements(By.xpath("//*[@id='prevbutton']/preceding::td[@class='prgcat']/a/span"));
		ArrayList<String> slist  = new ArrayList();
		slist.add("Viewport");
		slist.add("Zoom Bar");
		slist.add("Legend");
		slist.add("Distance Scale");
		slist.add("Pan Control");
		slist.add("General Settings");
		slist.add("Margins");
		slist.add("Border");
		slist.add("Layout");
		for (int i=0;i<=settingList.size()-1;i++)
		{
			
			assertEquals(slist.get(i), settingList.get(i).getText());
		}
		
		log.driver.findElement( By.id("nextbutton")).click();
		waits.waituUnitil_Element_Clickable(20, "//input[@value='Finish']");
		
		List<WebElement> buttons4 = waitForVisibilityOfElements(By.xpath("//div[@id='buttons']/input"));
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
//		waits.waituUnitil_Element_Clickable(30,"//li[@class='k-item k-state-default k-first k-last k-tab-on-top k-state-active']/span[@class='k-link']");
//		Thread.sleep(2000);
		Assert.assertTrue(findVisibleBool(By.xpath("//parent::div[@class='w20_contentpane w20_kendo w20_layoutcomp']//img[@class='w20_image ']")));
		Utils ui = new Utils(driver);
		ui.rightClick("//parent::div[@class='w20_contentpane w20_kendo w20_layoutcomp']//img[@class='w20_image ']");
//		waitForPresenceOfElement(By.xpath("//span[text()='Map Properties...']/ancestor::ul"));
//		List<WebElement> li = findAllPresence(By.xpath("/html[1]/body[1]/div[28]/ul[1]"));
		List<WebElement> li = findAllPresence(By.xpath("//ul[contains(@class, 'w20_menu w20_kendo k-widget k-reset k-header k-menu k-menu-vertical k-context-menu k-popup k-group')]"));

		List<String> lilist = new ArrayList();
		lilist.add("Map 1");
		lilist.add("DataView: A - Training Sales");
		lilist.add("New Assignment...");
		lilist.add("Set Background Shape Set...");
		lilist.add("Viewport");
		lilist.add("Map Properties...");
		lilist.add("Information...");

		for (int i = 0; i < li.size() - 1;i++) {
			assertEquals(li.get(i).getText(),lilist.get(i));
		}

		clickableClick(By.xpath("//span[text()='Map Properties...']"));
		waits.waituUnitil_Element_Clickable(20, "//input[@value='OK']");
		assertEquals("Properties of 'Map 1'", log.driver.findElement(By.xpath("//span[@class='k-window-title']")).getText());
	}
}