package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24690 extends TestUtils {
	@Test
	@Parameters("browser")
	public void Testcase_for_Changing_ownerShip_to_different_user(String browser) throws Exception
	{
		//Testcase step 1 to step 4
		// login to the application
		test =extent.createTest("TestCase_24690 for Creating Standard report with table Layout component");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);

		//		log.createReport(log.driver,"Sales");
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		log.createCubeReport("//div[text()='Sales']","TestCase_24690",false);
		String text = log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).getText();
		assertEquals(text, "TestCase_24690");
		boolean checc =log.driver.findElement(By.xpath("//div[@data-widgetname='cw_grid']/div")).isDisplayed();
		boolean checc1 =log.driver.findElement(By.xpath("//span[@class='k-widget k-dropdowntree cwDropDown']")).isDisplayed();
		assertTrue(checc);
		assertTrue(checc1);
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
		
		
		java.util.List<WebElement>reportList= log.driver.findElements(By.xpath("//span[@class='w20_treehover']"));
		for (int i =0;i<=reportList.size()-1;i++)
		{
			Thread.sleep(3000);
			if(reportList.get(i).getText().equalsIgnoreCase("TestCase_24690"))
			{ 
				ui.rightClick("//*[text()='TestCase_24690']");
				Thread.sleep(200);
				log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
				Thread.sleep(600);
				log.driver.findElement(By.id(getData("yes"))).click();
				Thread.sleep(1000);
			}
			else
			{
				System.out.println("Not found");
			}
		}
		Thread.sleep(2000);
		menu.get(2).click();
		waits.waituUnitil_Element_Clickable(20, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
		log.driver.findElement(By.id("okbutton")).click();
		waits.waituUnitil_Element_Clickable(20, "//span[@id='tab_close_btn']");
		Thread.sleep(1000);
		log.driver.findElement(By.id("tab_close_btn")).click();
		Thread.sleep(2000);
		WebElement element = log.driver.findElement(By.xpath("(//span[text()='TestCase_24690'])[1]"));
		((JavascriptExecutor)log.driver).executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(500); 
		element.click();
		waits.waituUnitil_Element_Clickable(20, "//span[@id='tab_close_btn']");
		String text1 = log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).getText();
		assertEquals(text1, "TestCase_24690");
		System.out.println("Done");
		log.deleteReport("TestCase_24690");
}

}
