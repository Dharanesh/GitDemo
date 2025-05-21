package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24489 extends TestUtils
{
	@Test	
	@Parameters("browser")
	public void Testcase_to_verify_functionality_of_Analytical_Visualization_Threshold_New(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24489 : Web_Testcase to verify functionality of <Analytical Visualization Threshold_New>");
	   
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Sales by country']");
		log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
        Thread.sleep(1000);

        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Sales by country'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Time']");
		log.driver.findElement(By.xpath("//span[text()='Time']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed(),true);
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Removes all items from the selection list']");
		
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);;
		
		/*waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Base elements with containers (0 Items)']");
	
		String basevalueempty=driver.findElement(By.xpath("//span[text()='Base elements with containers (0 Items)']")).getText();
		Assert.assertEquals(basevalueempty, "Base elements with containers (0 Items)");
		Thread.sleep(2000);*/
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='2014']");
		log.driver.findElement(By.xpath("//div[text()='2014']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='2015']");
		log.driver.findElement(By.xpath("//div[text()='2015']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");

		List<WebElement> basevalue = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> base= new ArrayList<String>();
		System.out.println("New Report radio button option");
		base.add("2014");
		base.add("2015");

		for(int i=0;i<basevalue.size()-1;i++)
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
			System.out.println("2014 and 2015 value is checked");
		}
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		Actions a1=new Actions(log.driver);
		a1.contextClick(log.driver.findElement(By.xpath(("//div[text()='2014']")))).build().perform();
		Thread.sleep(1000);
		a1.moveToElement(log.driver.findElement(By.xpath(("//span[text()='Analytical Visualizations']")))).build().perform();
		Thread.sleep(200);
		a1.click(log.driver.findElement(By.xpath(("//span[text()='New...']")))).build().perform();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Analytical Visualization']");
		System.out.println("Create new Analytical visualization");
		//Threshold
		
	    log.driver.findElement(By.xpath("//span[text()='Threshold']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()='Creates a new threshold analysis.']")).isDisplayed();
		System.out.println("Creates a new threshold analysis. is selected");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Creates a new threshold analysis.']")).isDisplayed(),true);
		Thread.sleep(200);
		System.out.println("Creates a new threshold analysis.");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the Threshold Analysis']")).isDisplayed(),true);
		System.out.println("Settings for the Threshold Analysis====");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Settings for the Threshold Analysis']/ancestor::div[3]/div[2]/div[1]//button");
		List<WebElement> Buttons = log.driver.findElements(By.xpath("//span[text()='Settings for the Threshold Analysis']/ancestor::div[3]/div[2]/div[1]//button"));
		ArrayList<String> button = new ArrayList<String>();
		button.add("...");
		button.add("Add");
		button.add("Delete");
		Thread.sleep(200);
		System.out.println("Action button on settings for threshold analysis window are");
		test.info("Action button on settings for threshold analysis window are");
		
		assertEquals(Buttons.get(3).getText(), button.get(0));
		System.out.println(Buttons.get(3).getText());
		test.info(Buttons.get(3).getText());
		Thread.sleep(200);
		
		assertEquals(Buttons.get(6).getText(), button.get(1));
		System.out.println(Buttons.get(6).getText());
		test.info(Buttons.get(6).getText());
		
		assertEquals(Buttons.get(7).getText(), button.get(2));
		System.out.println(Buttons.get(7).getText());
		test.info(Buttons.get(7).getText());
		Thread.sleep(200);
		
		assertTrue(Buttons.get(4).getAttribute("data-title").contains("Move selected condition up"));
		assertTrue(Buttons.get(5).getAttribute("data-title").contains("Move selected condition down"));
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings for the Threshold Analysis']/ancestor::div[6]//input[@role='button']");
		List<WebElement> Buttons1 = log.driver.findElements(By.xpath("//span[text()='Settings for the Threshold Analysis']/ancestor::div[6]//input[@role='button']"));
		ArrayList<String> button1 = new ArrayList<String>();
		button1.add("Next >>");
		button1.add("Finish");
		button1.add("Cancel");
		button1.add("Help");
		System.out.println("Action button on settings for Threshold Analysis window are");
		test.info("Action button on settings for Threshold Analysis window are");
		for(int i =0;i<=button1.size()-1;i++) 
		{
			assertEquals(Buttons1.get(i).getAttribute("value"), button1.get(i));
			System.out.println(Buttons1.get(i).getAttribute("value"));
			test.info(Buttons1.get(i).getText());
		}
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Value (unformatted value or string)']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Value (unformatted value or string)']/ancestor::td[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Percental']/ancestor::td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Percental']/ancestor::td[1]/input[1]")).isSelected(),false);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[@class='lgcb'])[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[@class='lgcb'])[1]/span[1]/span[1]/span[1]")).getText(),"!=");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[@class='lged']/div/input[1]");
		List<WebElement> Value = log.driver.findElements(By.xpath("//div[@class='lged']/div/input[1]"));
		for (WebElement we : Value) 
		{
			assertTrue(we.getAttribute("value").equals("0.0"));
			
		}
		
		System.out.println("Default value in VALUE text field is correct");
		test.info("Default value in VALUE text field is correct");
		
		Buttons.get(3).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Format']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Format']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Format']/../../div[2]/div/div/div/div[1]/ul[1]/li/a");
		List<WebElement> tabs =log.driver.findElements(By.xpath("//span[text()='Format']/../../div[2]/div/div/div/div[1]/ul[1]/li/a"));
		System.out.println("Tabs present in Format windows are:");
		ArrayList<String > tab_name = new ArrayList<String>();
		tab_name.add("Data Cell");
		tab_name.add("Image");
		tab_name.add("Chart");
		tab_name.add("Map");
		for (int  i=0;i<=tabs.size()-1;i++) 
		{		
		String tab = tabs.get(i).getText();
		Assert.assertEquals(tab, tab_name.get(i));
		System.out.println(tab);
		test.info(tab);
		}
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Format']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Data Cell']/ancestor::li[1]")).getAttribute("aria-selected"), "true");
		System.out.println(tabs.get(0).getText() +"   is highlighted");
		test.info(tabs.get(0).getText() +"   is highlighted");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Font']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Font']")).isDisplayed());
		System.out.println("font is present in data cell pane");
		test.info("font is present in data cell pane");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Border']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Border']")).isDisplayed());
		System.out.println("Border is present in data cell pane");
		test.info("Border is present in data cell pane");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Color']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Color']")).isDisplayed());
		System.out.println("color is present in data cell pane");
		test.info("color is present in data cell pane");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Alignment']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Alignment']")).isDisplayed());
		System.out.println("Allignment is present in data cell pane");
		test.info("Allingment is present in data cell pane");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Style:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Style:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Default");
		System.out.println("Style is set to default");
		test.info("Style is set to default");
		
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Position:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Position:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Default");
		System.out.println("Position is set to default");
		test.info("Position is set to default");
		
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Horizontal:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Horizontal:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Default");
		System.out.println("Horizontal allignment is set to default");
		test.info("Horizontal allignment is set to default");
		
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Vertical:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Vertical:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Default");
		System.out.println("Vertical allignment is set to default");
		test.info("Vertical allignment is set to default");
				
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Word wrap:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Word wrap:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Default");
		System.out.println("Word wrap is set to default");
		test.info("word wrap is set to default");
		
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Writeable:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Writeable:']/ancestor::div[3]/div[2]/div[1]/span[1]/span[1]/span[1]")).getText(), "Default");
		System.out.println("Writeable is set to default");
		test.info("writeable is set to default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Font name']/ancestor::td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='Font name']/ancestor::td[1]/input[1]")).isSelected());
		System.out.println("Font name checkbox is unchecked");
		test.info("Font name checkbox is unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Font size']/ancestor::td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='Font size']/ancestor::td[1]/input[1]")).isSelected());
		System.out.println("Font size checkbox is unchecked");
		test.info("Font size checkbox is unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Font style']/ancestor::td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='Font style']/ancestor::td[1]/input[1]")).isSelected());
		System.out.println("Font style checkbox is unchecked");
		test.info("Font style checkbox is unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Bold']/ancestor::td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='Bold']/ancestor::td[1]/input[1]")).isEnabled());
		System.out.println("Bold CB is grayed out");
		test.info("Bold CB is grayed out");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Underline']/ancestor::td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='Underline']/ancestor::td[1]/input[1]")).isEnabled());
		System.out.println("Underline CB is grayed out");
		test.info("Underline CB is grayed out");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Italic']/ancestor::td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='Italic']/ancestor::td[1]/input[1]")).isEnabled());
		System.out.println("Italic CB is grayed out");
		test.info("Italic CB is grayed out");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Strikeout']/ancestor::td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("//label[text()='Strikeout']/ancestor::td[1]/input[1]")).isEnabled());
		System.out.println("Strikeout CB is grayed out");
		test.info("Strikeout CB is grayed out");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Text color']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//button[text()='Text color']")).isEnabled());
		System.out.println("textcolor button is enabled");
		test.info("textcolor button is enabled");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Text color']");
		log.driver.findElement(By.xpath("//button[text()='Text color']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select color']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Select color']")).isDisplayed());
		System.out.println("select color window displayed");
		test.info("select color window displayed");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//label[text()='Default color']/ancestor::td[1]");
		if(log.driver.findElement(By.xpath("//label[text()='Default color']/ancestor::td[1]/input[1]")).isSelected())
		{
			log.driver.findElement(By.xpath("//label[text()='Default color']/ancestor::td[1]")).click();
			System.out.println("Default color checkbox is selected");
		}
		else
		{
			System.out.println("Default color checkbox is not selected");
			test.info("Default color checkbox is not selected");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select color']/following::td[19]");
		log.driver.findElement(By.xpath("//span[text()='Select color']/following::td[19]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, " //td[text()='Red:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath(" //td[text()='Red:']/..//input")).getAttribute("value"), "50");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Green:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Green:']/..//input")).getAttribute("value"), "205");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Blue:']/..//input");
		Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Blue:']/..//input")).getAttribute("value"), "50");
		
		System.out.println("values present in red, green and blue fields are correct");
		test.info("values present in red, green and blue fields are correct");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Actual:']/../div[2]");
		String Bar_color= log.driver.findElement(By.xpath("//div[text()='Actual:']/../div[2]")).getCssValue("background-color");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Actual:']/../div[2]")).getCssValue("background-color").contains("50, 205, 50"));
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Text color']/span[1]");
		assertTrue(log.driver.findElement(By.xpath("//button[text()='Text color']/span[1]")).getCssValue("color").contains("50, 205, 50"));
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Format']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Format']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the Threshold Analysis']")).isDisplayed(),true);
		System.out.println("Settings for the Threshold Analysis====");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Value']/ancestor::div[3]/div[4]/div/div");
		int rows = log.driver.findElements(By.xpath("//div[text()='Value']/ancestor::div[3]/div[4]/div/div")).size();
		System.out.println("number of rows present in Settings for Threshold Analysis window is  " +rows);
		test.info("number of rows present in Settings for Threshold Analysis window is  " +rows);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Value']/ancestor::div[3]/div[4]/div/div/div[10]");
		log.driver.findElement(By.xpath("//div[text()='Value']/ancestor::div[3]/div[4]/div/div/div[10]")).getText().equals("Text color set, Chart: <standard values>, Map: <standard values>");
		System.out.println("Format settings for first condition are  " +log.driver.findElement(By.xpath("//div[text()='Value']/ancestor::div[3]/div[4]/div/div/div[10]")).getText());
		test.info("Format settings for first condition are  " +log.driver.findElement(By.xpath("//div[text()='Value']/ancestor::div[3]/div[4]/div/div/div[10]")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings for the Threshold Analysis']");
		log.driver.findElement(By.xpath("//button[text()='Add']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Value']/ancestor::div[3]/div[4]/div/div");
		System.out.println(log.driver.findElements(By.xpath("//div[text()='Value']/ancestor::div[3]/div[4]/div/div")).size());
		int count= 2;
		Thread.sleep(500);
		Assert.assertEquals(log.driver.findElements(By.xpath("//div[text()='Value']/ancestor::div[3]/div[4]/div/div")).size(), count);
		System.out.println("number of rows present in Settings for Threshold Analysis window is  " +log.driver.findElements(By.xpath("//div[text()='Value']/ancestor::div[3]/div[4]/div/div")).size());
		test.info("number of rows present in Settings for Threshold Analysis window is  " +log.driver.findElements(By.xpath("//div[text()='Value']/ancestor::div[3]/div[4]/div/div")).size());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[2]");
		log.driver.findElement(By.xpath("(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[2]")).getText().equals("<standard values>, Chart: <standard values>, Map: <standard values>");
		System.out.println("Format settings for second condition are  " +log.driver.findElement(By.xpath("(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[2]")).getText());
		test.info("Format settings for second condition are  " +log.driver.findElement(By.xpath("(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[2]")).getText());		
		
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Value']/ancestor::div[3]/div[2]/div/div/div");
		assertTrue(log.driver.findElements(By.xpath("//div[text()='Value']/ancestor::div[3]/div[2]/div/div//input[1]")).get(1).isSelected());		
		
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Move selected condition up']");
		log.driver.findElement(By.xpath("//button[@data-title='Move selected condition up']")).click();
		
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[1]");
		log.driver.findElement(By.xpath("(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[1]")).getText().equals("<standard values>, Chart: <standard values>, Map: <standard values>");
		System.out.println("Format settings for first condition are  " +log.driver.findElement(By.xpath("(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[1]")).getText());
		test.info("Format settings for first condition are  " +log.driver.findElement(By.xpath("(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[1]")).getText());
		System.out.println("second row moved to first place");
		test.info("second row moved to first place");
		
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Value']/ancestor::div[3]/div[2]/div/div/div");
		assertTrue(log.driver.findElements(By.xpath("//div[text()='Value']/ancestor::div[3]/div[2]/div/div//input[1]")).get(0).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Move selected condition up']");
		log.driver.findElement(By.xpath("//button[@data-title='Move selected condition up']")).click();
		
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[2]");
		log.driver.findElement(By.xpath("(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[2]")).getText().equals("<standard values>, Chart: <standard values>, Map: <standard values>");
		System.out.println("Format settings for first condition are  " +log.driver.findElement(By.xpath("(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[2]")).getText());
		test.info("Format settings for first condition are  " +log.driver.findElement(By.xpath("(//div[text()='Format']/ancestor::div[3]/div[4]/div/div/div[10])[2]")).getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Value']/ancestor::div[3]/div[2]/div/div/div)[2]");
		log.driver.findElement(By.xpath("(//div[text()='Value']/ancestor::div[3]/div[2]/div/div/div)[2]")).click();
		assertTrue(log.driver.findElements(By.xpath("(//div[text()='Value']/ancestor::div[3]/div[2]/div/div//input[1])")).get(1).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Delete']");
		log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
		System.out.println("clicked Delete button");
		test.info("clicked Delete button");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Value']/ancestor::div[3]/div[4]/div/div");
		System.out.println("no of rows are" +log.driver.findElements(By.xpath("//div[text()='Value']/ancestor::div[3]/div[4]/div/div")).size());
		int count1= 1;
		Assert.assertEquals(log.driver.findElements(By.xpath("//div[text()='Value']/ancestor::div[3]/div[4]/div/div")).size(), count1);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();

		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Name'])[1]/following::input[1]");
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Threshold Analysis");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(1000);
		try
		{
			log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
			Thread.sleep(1000);	
		}
		catch(Exception e)
		{
			System.out.println("Finish btn Clicked");
		}
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Assignment of the Analytical Visualization  [DataView: Sales]']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Assignment of the Analytical Visualization  [DataView: Sales]']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Allocation(target)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Allocation(target)']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).isDisplayed(),true);
		
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[1]")).click();
		Thread.sleep(1000);
		try {
		if(log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[1]")).isEnabled()) {
			Thread.sleep(500);
			assertTrue(log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[1]")).isEnabled());
			System.out.println("2014 got selected in traget");
			
		}
		}catch(Exception e) {
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("//*[text()='Allocation(target)']/following::div[text()='2014']")).click();
			Thread.sleep(500);
			assertTrue(log.driver.findElement(By.xpath("(//*[text()='Allocation(target)']/following::div[text()='2014'])[1]")).isEnabled());
			System.out.println("2014 got selected in second time");
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Data area(source)']");
		log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Element level:'])[2]/following::div[1]/div[1]/span/span/span[1]");
		String ElementLevel1src= log.driver.findElement(By.xpath("(//span[text()='Element level:'])[2]/following::div[1]/div[1]/span/span/span[1]")).getText();
		Assert.assertEquals(ElementLevel1src,"(all levels)");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//label[text()='Based on index'])[2]/../../td[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//label[text()='Based on index'])[2]/../../td[1]/input")).isSelected(),true);
		System.out.println("Based on index is selected default in source window");
		test.info("Based on index is selected default in source window");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//label[text()='Based on element'])[2]/../../td[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//label[text()='Based on element'])[2]/../../td[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//button[text()='Delete selection']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Delete selection']")).isEnabled(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/../../..)[2]/div[3]/div/div[@span='0']");
		log.driver.findElements(By.xpath("(//div[text()='2014']/../../..)[2]/div[3]/div/div[@span='0']")).get(0).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(4000);
		
		List<WebElement> verifications = log.driver.findElements(By.xpath("//div[text()='2014']/ancestor::div[4]/div/div[4]/div/div/div[1]"));
		 for (WebElement web : verifications)
		 {
			 assertTrue(web.getCssValue("color").equals(Bar_color));
		 }
		 System.out.println("AV_Threshold applied correctly");
		 test.info("AV_Threshold applied correctly");
		 
		 //Save the report Threshold Analysis
		//Save as the report:=============
		 /*log.driver.findElement(By.xpath("(//span[text()='Save'])[2]/following::span[1]")).click();
		 Thread.sleep(2000);
		 //Click Down and do Save As:====================
		 log.driver.findElement(By.xpath("(//span[text()='Save As'])[2]")).click();
		 Thread.sleep(2000);
		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report as']")).isDisplayed());
		 Thread.sleep(1000);
		 System.out.println("Save Report as window is displaying now.");
		
		 //Change Name:===========
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		 waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Name'])[1]/following::input[1]");
		 Thread.sleep(1000);
		 log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Threshold_New");
		 Thread.sleep(500);
		
		//click folder:========
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		Thread.sleep(1000);
		//Click Ok Button:============
		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
		Thread.sleep(1000);
		
		try
		{
			log.driver.findElement(By.xpath("//span[contains(text(),'A report named')]")).isDisplayed();
			log.driver.findElement(By.xpath("//input[@value='OK']")).click();
			System.out.println("popup appeared");
		}
		catch(Exception e)
		{
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Threshold_New']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Threshold_New']")).isDisplayed());
		System.out.println("saves as completed without popup");
		}*/
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 log.driver.close();
		
		
	}
}
