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

public class TestCase_24359 extends TestUtils
{
	@Test	
	@Parameters("browser")

	//Web_Testcase to verify functionality of Analytical Visualization  MiniChart_Bar_New
	public void Testcase_Cockpit10_Analytical_Viz_Minichart_New(String browser) throws Exception
	{
	    test = extent.createTest("TestCase_24359 for creating Selection bar Layout component in standard report");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		log.createCubeReport("//div[contains(text(),'Training Sales')]", "TestCase_24359", false);

		click(By.xpath("//span[text()='Components']"));
		click(By.xpath("(//a[@data-title='Create a New Report Component'])[1]"));
		click(By.xpath("//span[text()='New Layout Component...']"));

		List<WebElement> reports = findAll(By.xpath("//span[@class='reportNametxt']"));

		List<String> list = new ArrayList<>();
		list.add("Title");
		list.add("Image");
		list.add("Table");
		list.add("Chart");
		list.add("Filter Bar");
		list.add("Selection Bar");
		list.add("Action Bar");
		list.add("ABC Table");
		list.add("ABC Chart");
		list.add("Horizontal Waterfall Chart");
		list.add("Vertical Waterfall Chart");
		list.add("Bubble Chart");
		list.add("Gauge");
		list.add("Map");
		list.add("OS Map");

		for (int i = 0; i < reports.size() - 1; ++i) {
			Assert.assertEquals(reports.get(i).getText(), list.get(i));
		}

		By infoBox = By.xpath("//div[@class='w20_newwiz_description']");

		By title = By.xpath("//div[@class='reportLitile cursor k-state-selected']");
		click(title);
		Assert.assertEquals(find(title).getText(), "Title");
		waitForTextInElement(infoBox, "Inserts a title into the report.");
		Assert.assertEquals(find(infoBox).getText(), "Inserts a title into the report.");

		By chartButton = By.xpath("//span[text()='Chart']");
		click(chartButton);
		Assert.assertEquals(find(chartButton).getText(), "Chart");
		waitForTextInElement(infoBox, "Inserts a chart into the report.");
		Assert.assertEquals(find(infoBox).getText(), "Inserts a chart into the report.");

		List<WebElement> buttons = findAll(By.xpath("//div[@id='buttons']/input"));

		List<String> buttonList = new ArrayList<>();
		buttonList.add("Next >>");
		buttonList.add("Cancel");
		buttonList.add("Help");

		for (int i = 0; i <= buttons.size() - 1; i++) {
			Assert.assertEquals(buttons.get(i).getAttribute("value"), buttonList.get(i));
		}

		clickableClick(By.xpath("//input[@value='Next >>']"));
		//waitForVisibilityOfElement(By.xpath("//span[contains(text(),'DataView Assignment')]"), 30);
		Assert.assertEquals(findVisible(By.xpath("//span[contains(text(),'DataView Assignment')]")).getText(), "DataView Assignment");
		Assert.assertEquals(find(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button'])[1]")).getText(), "New...");
		Assert.assertEquals(find(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button'])[2]")).getText(), "Assign...");
		Assert.assertEquals(find(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button'])[3]")).getText(), "Remove");

		clickableClick(By.xpath("(//button[@class='cw_button w20_button w20_kendo k-button'])[1]"));
		Assert.assertEquals(findVisible(By.xpath("//div[@class='w20_newwiz_title']")).getText(), "Please select a DataView type");

		List<WebElement> cubeList = findAll(By.xpath("//span[@class='reportNametxt']"));

		List<String> cubeListStrings = new ArrayList<>();
		cubeListStrings.add("Cube DataView");
		cubeListStrings.add("SQL DataView");
		cubeListStrings.add("MDX DataView");

		for (int i = 0; i < cubeList.size() - 1; ++i) {
			Assert.assertEquals(cubeList.get(i).getText(), cubeListStrings.get(i));
		}

		Assert.assertEquals(find(By.xpath("//div[@class='w20_newwiz_description']")).getText(), "Creates a new Cube DataView.");
		Assert.assertEquals(find(By.xpath("//span[contains(text(),'Cube DataView')]")).getText(), "Cube DataView");

		clickableClick(By.xpath("//input[@value='Next >>']"));
		Assert.assertEquals(findVisible(By.xpath("//span[contains(text(),'Select Cube')]")).getText(), "Select Cube");

		clickableClick(By.xpath("//input[@value='Next >>']"));

		waitForVisibilityOfElement(By.xpath("//input[@value='OK']"));

		Assert.assertEquals(find(By.xpath("//span[contains(text(),'Please select a cube!')]")).getText(), "Please select a cube!");
//		Assert.assertTrue(findVisibleBool(By.xpath("(//span[text()='Please select a cube!']")));
		clickableClick(By.xpath("//input[@value='OK']"));

		click(By.xpath("(//div[@class='w20_treeitemcollapsed'])[1]"));

		Assert.assertTrue(findVisibleBool(By.xpath("//span[text()='Dimension Selection']")));

		clickableClick(By.xpath("//input[@value='Next >>']"));

		//clickableClick(By.xpath("//input[@value='Finish']"));
//		Assert.assertEquals(findVisible(By.xpath("(//span[@class='w20_statictext'])[1]")).getText(), "Dimension Selection");

		List<WebElement> useList = findAll(By.xpath("//div[@class='w20_radiobutton']/table/tbody/tr/td/label"));

		List<String> useListString = new  ArrayList<>();
		useListString.add("Use all dimensions of cube");
		useListString.add("Use only selected dimensions");

		for(int i = 0; i < useList.size() - 1; ++i) {
			Assert.assertEquals(useList.get(i).getText(), useListString.get(i));
		}

		Assert.assertTrue(log.driver.findElement(By.xpath("//*[text()='Use all dimensions of cube']/../input")).isSelected());
		Assert.assertEquals("Cube Dimensions", log.driver.findElement(By.xpath("(//div[@class='w20_label']/table/tbody/tr/td/span)[1]")).getText());
		Assert.assertEquals("Selected Dimensions", log.driver.findElement(By.xpath("(//div[@class='w20_label']/table/tbody/tr/td/span)[2]")).getText());
		log.driver.findElement(By.xpath("//label[text()='Use only selected dimensions']")).click();
		Thread.sleep(2000);
		List<WebElement > box=log.driver.findElements(By.xpath("//div[@style='display:table-cell; vertical-align:middle;']/div/button[@aria-disabled='false']"));
		for(int i=0;i<=box.size()-1;i++)
		{
			assertTrue(box.get(i).isDisplayed());

		}

		Thread.sleep(20000);

		// -------------------------------------------

		clickableClick(By.xpath("//input[@value='Next >>']"));
		Assert.assertEquals(findVisible(By.xpath("//span[contains(text(),'Position in report')]")).getText(), "Position in report");

		clickableClick(By.xpath("//input[@value='Next >>']"));
		List<WebElement> settingsComponents = new ArrayList<>();
		settingsComponents.add(findVisible(By.xpath("//span[contains(text(),'Chart Type')]")));
		settingsComponents.add(find(By.xpath("//span[contains(text(),'Chart Area (3D Settings)')]")));
		settingsComponents.add(find(By.xpath("//span[contains(text(),'Y Axis')]")));
		settingsComponents.add(find(By.xpath("//span[contains(text(),'Datapoints')]")));
		settingsComponents.add(find(By.xpath("//span[contains(text(),'Datapoint Label')]")));

		List<String> settingsComponentsStrings = new ArrayList<>();
		settingsComponentsStrings.add("Chart Type");
		settingsComponentsStrings.add("Chart Area (3D Settings)");
		settingsComponentsStrings.add("Y Axis");
		settingsComponentsStrings.add("Datapoints");
		settingsComponentsStrings.add("Datapoint Label");

		for (int i = 0; i < settingsComponents.size() - 1; ++i) {
			Assert.assertEquals(settingsComponents.get(i).getText(), settingsComponentsStrings.get(i));
		}

//		clickableClick(By.xpath("//input[@value='Next >>']"));
//		Assert.assertEquals(find(By.xpath("//div[@class='w20_newwiz_title']")).getText(), "Please select a DataView type");
//
//		List<String > cubeList = new ArrayList<>();
//		cubeList.add("Cube DataView");
//		cubeList.add("SQL DataView");
//		cubeList.add("MDX DataView");
//
//		List<WebElement> cubes = log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
//		for(int i =0;i<=cubes.size()-1;i++)
//		{
//			Assert.assertEquals(cubes.get(i).getText(), cubeList.get(i));
//
//		}
//		Assert.assertEquals("Creates a new Cube DataView.", log.driver.findElement(By.xpath("//div[@class='w20_newwiz_description']")).getText());
//		Assert.assertEquals("Cube DataView", log.driver.findElement(By.xpath("(//div[@class='reportLitile cursor k-state-selected' and @aria-selected='true']/div/div/div/span)[2]")).getText());
//		log.driver.findElement(By.id("okbutton")).click();
//		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
//		Assert.assertEquals("Select Cube", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
//
//		log.driver.findElement(By.id("nextbutton")).click();
//		waits.waituUnitil_Element_Clickable(20,"//input[@value='OK']");
//		Assert.assertEquals("Please select a cube!", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
//		log.driver.findElement(By.id("okbutton")).click();
//		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
//		log.driver.findElement(By.xpath("(//div[@class='w20_treeitemcollapsed'])[1]")).click();
//		Thread.sleep(500);
//		log.driver.findElement(By.xpath("//div[contains(text(),'Training Sales')]")).click();
//		log.driver.findElement(By.id("nextbutton")).click();
//		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
//		Assert.assertEquals("Dimension Selection", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
//		List<WebElement> use = log.driver.findElements(By.xpath("//div[@class='w20_radiobutton']/table/tbody/tr/td/label"));
//		ArrayList<String > uselist = new  ArrayList<>();
//		uselist.add("Use all dimensions of cube");
//		uselist.add("Use only selected dimensions");
//		for(int i =0;i<=use.size()-1;i++)
//		{
//			Assert.assertEquals(use.get(i).getText(), uselist.get(i));
//
//		}
//		Assert.assertTrue(log.driver.findElement(By.xpath("//*[text()='Use all dimensions of cube']/../input")).isSelected());
//		Assert.assertEquals("Cube Dimensions", log.driver.findElement(By.xpath("(//div[@class='w20_label']/table/tbody/tr/td/span)[1]")).getText());
//		Assert.assertEquals("Selected Dimensions", log.driver.findElement(By.xpath("(//div[@class='w20_label']/table/tbody/tr/td/span)[2]")).getText());
//		log.driver.findElement(By.xpath("//label[text()='Use only selected dimensions']")).click();
//		Thread.sleep(2000);
//		List<WebElement > box=log.driver.findElements(By.xpath("//div[@style='display:table-cell; vertical-align:middle;']/div/button[@aria-disabled='false']"));
//		for(int i=0;i<=box.size()-1;i++)
//		{
//			assertTrue(box.get(i).isDisplayed());
//
//		}
		log.driver.findElement(By.xpath("//label[text()='Use all dimensions of cube']")).click();
		Thread.sleep(500);
		log.driver.findElement(By.id("nextbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
		Assert.assertEquals("Settings for the DataView", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		Assert.assertEquals("Settings", log.driver.findElement(By.xpath("(//div[@class='w20_property_control_grid']/table/tbody/tr/td[2]/a/span)[1]")).getText());
		Assert.assertEquals("Formatting", log.driver.findElement(By.xpath("(//div[@class='w20_property_control_grid']/table/tbody/tr/td[2]/a/span)[2]")).getText());
		log.driver.findElement(By.xpath("//div[text()='Hide empty columns']/../../../td[3]/div")).click();
		Thread.sleep(200);
		log.driver.findElement(By.xpath("//div[text()='Highlight consolidated elements']/../../../td[3]/div")).click();
		log.driver.findElement(By.id("nextbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
		Assert.	assertEquals("Name and Description", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//div[@class='w20_webedit']/input")).clear();
		log.driver.findElement(By.xpath("//div[@class='w20_webedit']/input")).sendKeys("Automation");
		Actions act = new Actions(log.driver);
		act.sendKeys(Keys.TAB).perform();
		log.driver.findElement(By.id("finishbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Next >>']");
		Assert.assertEquals("DataView Assignment", log.driver.findElement(By.xpath("//div[@class='w20_wizard_title']/span")).getText());
		Thread.sleep(500);
		Assert.assertEquals("Automation", log.driver.findElement(By.xpath("(//div[@class='w20_treeview']/div[2]/div[2])[1]")).getText());
		List<WebElement>buto = log.driver.findElements(By.xpath("//div[@id='IDDIVBUTTONS']/div/button[@aria-disabled='false']"));
		for(int i=0;i<=buto.size()-1;i++)
		{
			Assert.assertTrue(buto.get(i).isDisplayed());
		}
		log.driver.findElement(By.xpath("(//div[text()='Automation']/../div)[1]")).click();
		log.driver.findElement(By.xpath("//div[@id='IDDIVBUTTONS']/div[4]")).click();
		Thread.sleep(500);
		Assert.assertEquals("Automation", log.driver.findElement(By.xpath("(//div[@class='w20_treeview']/div[1]/div[2])[1]")).getText());
		log.driver.findElement(By.xpath("//div[@id='IDDIVBUTTONS']/div[5]")).click();
		Thread.sleep(500);
		Assert.assertEquals("Automation", log.driver.findElement(By.xpath("(//div[@class='w20_treeview']/div[2]/div[2])[1]")).getText());
		log.driver.findElement(By.xpath("//button[text()='Remove']")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='No']");
		Assert.assertEquals("Do you want to totally delete the selected DataView (yes) or only unassign the DataView from the Layout Component (no)?",log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());



		List<WebElement> buttons1 = log.driver.findElements(By.xpath("//div[@data-title='Cockpit']/div[2]/div/input"));
		ArrayList<String> buttonList1 = new  ArrayList<>();
		buttonList1.add("Yes");
		buttonList1.add("No");
		buttonList1.add("Cancel");
		for (int  i =0;i<=buttons1.size()-1;i++)
		{

			Assert.assertEquals(buttons1.get(i).getAttribute("value"), buttonList1.get(i));
		}

		log.driver.findElement(By.id("yesbutton")).click();
		Thread.sleep(500);
		List<WebElement> sixe = log.driver.findElements(By.xpath("//div[@id='IDDIVLISTVIEW']/div/div"));
		Assert.assertEquals(1, sixe.size());
		log.driver.findElement(By.id("nextbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
		Assert.assertEquals("Position in report", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		log.driver.findElement(By.id("nextbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
		Assert.assertEquals("Settings for the layout component", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());

		List<WebElement> setting = log.driver.findElements(By.xpath("(//div[@class='w20_property_control_grid'])[1]/table/tbody/tr/td[2]/a/span"));
		ArrayList<String> setting1 = new  ArrayList<>();
		setting1.add("Chart Type");
		setting1.add("Chart Area (3D Settings)");
		setting1.add("Y Axis");
		setting1.add("Datapoints");
		setting1.add("Datapoint Labels");
		for (int  i =0;i<=buttons1.size()-1;i++)
		{

			Assert.assertEquals(setting.get(i).getText(), setting1.get(i));
		}
		log.driver.findElement(By.xpath("//*[text()='Chart Area (3D Settings)']/../../../td[1]")).click();
		log.driver.findElement(By.xpath("//div[text()='Enable 3D']/../../../td[3]/div")).click();
		log.driver.findElement(By.id("nextbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
		Assert.assertEquals("Name and Description", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//div[@class='w20_webedit']/input")).clear();
		log.driver.findElement(By.xpath("//div[@class='w20_webedit']/input")).sendKeys("Automation");
//		Actions act = new Actions(log.driver);
		act.sendKeys(Keys.TAB).perform();
		log.driver.findElement(By.id("finishbutton")).click();
		waits.waituUnitil_Element_Clickable(30,"//li[@class='k-item k-state-default k-first k-last k-tab-on-top k-state-active']/span[@class='k-link']");
		Thread.sleep(5000);
		Assert.assertTrue(log.driver.findElement(By.xpath("//div[@class='w20_contentpane w20_kendo w20_layoutcomp']")).isDisplayed());
		Thread.sleep(7000);
		Assert.assertEquals("Automation",log.driver.findElement(By.xpath("(//div[@class='w20_treeitemcontent  w20_treeitem_active'])[1]")).getText());

		Thread.sleep(2000);
		Utils ui = new Utils(log.driver);
		ui.rightClick("(//div[@class='w20_treeitemcontent  w20_treeitem_active'])[1]");
		Thread.sleep(500);
		List<WebElement> li = log.driver.findElements(By.xpath("(//ul[@data-role='contextmenu'])[3]/li/span"));
		ArrayList<String>lilist = new ArrayList<>();
		lilist.add("Automation");
		lilist.add("Copy");
		lilist.add("Paste");
		lilist.add("Edit...");
		lilist.add("New Annotation...");
		lilist.add("New Guide Line...");
		lilist.add("Duplicate");
		lilist.add("Rename");
		lilist.add("Delete");
		lilist.add("Properties...");
		
		for (int i =0;i<=li.size()-1;i++)
		{

			Assert.assertEquals(li.get(i).getText(),lilist.get(i));
		}
		log.driver.findElement(By.xpath("//span[text()='Properties...']")).click();
		waits.waituUnitil_Element_Clickable(20, "//input[@value='OK']");
		Assert.assertEquals("Properties of 'Automation'", log.driver.findElement(By.xpath("//span[@class='k-window-title']")).getText());
		log.driver.findElement(By.xpath("((//table[@class='prg'])[1]/tbody/tr[4]/td/a/span)[1]")).click();
		waits.waituUnitil_Element_Clickable(20, "//*[text()='Enable 3D']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//div[text()='Enable 3D']/../../../td[3]/div/input")).isSelected());
		log.driver.close();
		
		
		
	}

}
