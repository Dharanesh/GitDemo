package smokeCase;

import static org.testng.Assert.assertEquals;

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

public class TestCase_24530 extends TestUtils
{
	@Test	
	@Parameters("browser")

	//Web_Testcase to verify functionality of Analytical Visualization  MiniChart_Bar_New
	public void Testcase_Cockpit10_Analytical_Viz_Minichart_New(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24530 for creating ABC Chart Layout in standard report");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		log.createCubeReport("//div[contains(text(),'Training Sales')]", "TestCase_24527", false);

		implicitWaitSeconds(2);
		click(By.xpath("//span[text()='Components']"));
		click(By.xpath("(//a[@data-title='Create a New Report Component'])[1]"));
		click(By.xpath("//span[text()='New Layout Component...']"));

		waitForClickableElement(By.xpath("//input[@value='Next >>']"));
		List<WebElement>reports=findAll(By.xpath("//span[@class='reportNametxt']"));

		List<String>List = new ArrayList();
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
		
		for(int i=0;i<reports.size()-1;i++)
		{
			Assert.assertEquals(reports.get(i).getText(),List.get(i));
		}
		String tile = log.driver.findElement(By.xpath("//div[@class='reportLitile cursor k-state-selected' and @aria-selected='true']")).getText();
		Thread.sleep(1000);
		Assert.assertEquals(tile, "Title");
		String textpresent = log.driver.findElement(By.xpath("//div[@class='w20_newwiz_description']")).getText();
		Assert.assertEquals(textpresent, "Inserts a title into the report.");
		log.driver.findElement(By.xpath("//span[text()='ABC Chart']")).click();
		Thread.sleep(1000);
		String map = log.driver.findElement(By.xpath("//div[@class='reportLitile cursor k-state-selected' and @aria-selected='true']")).getText();
		Thread.sleep(1000);
		Assert.assertEquals(map, "ABC Chart");
		assertEquals("Inserts an ABC classification chart into the report.", log.driver.findElement(By.xpath("//div[@class='w20_newwiz_description']")).getText());

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

		List<WebElement>settingList = log.driver.findElements(By.xpath("//*[@id='prevbutton']/preceding::td[@class='prgcat']/a/span"));
		ArrayList<String> slist  = new ArrayList();
		slist.add("Classification");
		slist.add("ABC Classification Chart");
		slist.add("Datapoint Labels");
		slist.add("Datapoint Guidelines");
		
		for (int i=0;i<=settingList.size()-1;i++)
		{
			
			assertEquals(slist.get(i), settingList.get(i).getText());
		}
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
		assertEquals("Name and Description", log.driver.findElement(By.xpath("(//span[@class='w20_statictext'])[1]")).getText());
		log.driver.findElement(By.id("finishbutton")).click();
		
		waits.waituUnitil_Element_Clickable(30,"//li[@class='k-item k-state-default k-first k-last k-tab-on-top k-state-active']/span[@class='k-link']");
		Thread.sleep(2000);
		Assert.assertTrue(log.driver.findElement(By.xpath("(//img[@class='w20_image '])[2]")).isDisplayed());
		Utils ui = new Utils(log.driver);
		ui.rightClick("(//img[@class='w20_image '])[2]");
		Thread.sleep(500);
		List<WebElement> li = log.driver.findElements(By.xpath("(//ul[@data-role='contextmenu'])[3]/li/span"));
		ArrayList<String>lilist = new ArrayList();
		lilist.add("Chart Area");
		lilist.add("Set Classification Column...");
		lilist.add("Classification Properties...");
		lilist.add("Define Subview...");
		lilist.add("Annotations");
		lilist.add("Guide Lines");
		lilist.add("Chart Area Properties...");
		lilist.add("Chart Properties...");
		lilist.add("Information...");
		for (int i =0;i<=li.size()-1;i++)
		{
			assertEquals(li.get(i).getText(),lilist.get(i));
		}
		log.driver.findElement(By.xpath("//span[text()='Chart Properties...']")).click();
		waits.waituUnitil_Element_Clickable(20, "//input[@value='OK']");
		assertEquals("Properties of 'ABC Classification Chart 1'", log.driver.findElement(By.xpath("//span[@class='k-window-title']")).getText());
		
		
}
}