package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.apache.pdfbox.debugger.ui.Tree;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Waits;

public class TestCase_25527 extends TestUtils {
	@Test

	@Parameters("browser")
	public void Testcase_for_creatingScript_DDL_MDXExpressionusingWith_Member_for_Breakeven_analysis_by_quartersreport(String browser) throws Exception
	{

		// login to the application
		test =extent.createTest("TestCase_25527_Testcase  for creating Script DDL- MDX Expression using With Member for  Breakeven analysis by quartersreport");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		event.Utils ui = new event.Utils(log.driver);
		
		waits.waituUnitil_Element_Clickable(20,"//span[text()='Eigene Berichte']");
		log.driver.findElement(By.xpath("//span[text()='Eigene Berichte']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Breakeven analysis by quarters'])[1]");
		log.driver.findElement(By.xpath("(//span[text()='Breakeven analysis by quarters'])[1]")).click();		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Breakeven analysis by quarters'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Breakeven analysis by quarters'])[2]")).isDisplayed(),true);
		waits.waituUnitil_Element_Clickable(10, "//span[text()='Time']");
		String Columnvalue=log.driver.findElement(By.xpath("//span[text()='Time']")).getText();
		Assert.assertEquals(Columnvalue, "Time");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Time']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns')]")).isDisplayed(),true);
		waits.waituUnitil_Element_Clickable(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		waits.waituUnitil_Element_Clickable(10, "//div[text()='2015']");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//div[text()='2015']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[@class='w20_treeview'])[2]/div/div[2]");
		String basevalue=log.driver.findElement(By.xpath("(//div[@class='w20_treeview'])[2]/div/div[2]")).getText();
		Assert.assertEquals(basevalue, "2015");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		
		
		waits.waituUnitil_Element_Clickable(10,"//span[text()='Measures']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Measures']")).isDisplayed(),true);
		String Rowvalue=log.driver.findElement(By.xpath("//span[text()='Measures']")).getText();
		Assert.assertEquals(Rowvalue, "Measures");
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//span[text()='Measures']")).click();
		waits.waituUnitil_Element_Clickable(10,"//button[text()='Element Groups...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		Thread.sleep(2000);		
		List<WebElement>cont = log.driver.findElements(By.xpath("(//div[@class='k-list-scroller k-selectable'])[2]/ul/li/div/span/span[2]"));
		for (int z =0;z<=cont.size()-1;z++) 
		{
			System.out.println(cont.get(z).getText());
			if(cont.get(z).getText().equals("Unit/Sales Script"))
			{
				System.out.println(cont.get(z).getText());
				System.out.println("INside =============================");
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//span[text()='Unit/Sales Script']")).click();
				Thread.sleep(2000);
				waits.waituUnitil_Element_Clickable(20,"//button[text()='Delete']");
				log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
				waits.waituUnitil_Element_Clickable(20,"//input[@id='yesbutton']");
				log.driver.findElement(By.xpath("//input[@id='yesbutton']")).click();
				break;
			}
//			
				
			}
		
			waits.waituUnitil_Element_Clickable(20,"//button[text()='New...']");
			Thread.sleep(2000);	
			log.driver.findElement(By.xpath("//button[text()='New...']")).click();
			List<WebElement>ele = log.driver.findElements(By.xpath("(//div[@class='w20_treeview'])[1]/div/div"));
			ArrayList<String> elem = new ArrayList();
			elem.add("Criteria DDL");
			elem.add("Data DDL");
			elem.add("Script DDL");
			elem.add("Standard SDL");
			for (int j =0;j<=ele.size()-1;j++) 
			{
				assertEquals(ele.get(j).getText(), elem.get(j));
				
			}
			log.driver.findElement(By.xpath("//div[text()='Script DDL']")).click();
			Thread.sleep(500);
			log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
			waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
			log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("Unit/Sales Script");
			Thread.sleep(1000);
			Actions act = new Actions(log.driver);
			act.sendKeys(Keys.TAB).perform();
			Thread.sleep(1000);
			List<WebElement>button = log.driver.findElements(By.xpath("(//div[@id='buttons'])[1]/input"));
			ArrayList<String> but = new ArrayList();
			but.add("Next >>");
			but.add("Cancel");
			but.add("Help");
			for(int i =0;i<=button.size()-1;i++) 
			{
				assertEquals(but.get(i), button.get(i).getAttribute("value"));
			}
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("(//input[@value='Next >>'])[1]")).click();
			waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
			assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New Script DDL')]/following::tbody[1]/tr/td/label")).getText(), "TCL Script");
			assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New Script DDL')]/following::tbody[2]/tr/td/label")).getText(), "MDX Expression");
			assertTrue(log.driver.findElement(By.xpath("//label[text()='TCL Script']/../input")).isSelected());
			log.driver.findElement(By.xpath("//label[text()='MDX Expression']/../label")).click();
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("(//input[@value='Next >>'])[1]")).click();
			waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
			Thread.sleep(3000);
			assertEquals(log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]")).getText(),"SET Expression");
			log.driver.findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[1]/span[1]")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//*[text()='WITH MEMBER']")).click();
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("//label[text()='Optional Alias:']")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//label[text()='Optional Alias:']/following::input[1]")).sendKeys("salesvalue");

			Thread.sleep(1000);
			act.sendKeys(Keys.TAB).perform();
			Thread.sleep(1000);
			act.sendKeys("[Measures].[Sales]/[Measures].[Units sold]").perform();
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("//span[contains(text(),'Only when')]")).click();
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
			waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
			waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("(//span[text()='B - Training Purchase'])[1]")).click();
			Thread.sleep(3000);
			log.driver.findElement(By.xpath("(//*[text()='Container elements'])[3]")).click();
			waits.waituUnitil_Element_Clickable(20, "//div[text()='Unit/Sales Script']");
			Thread.sleep(3000);
			log.driver.findElement(By.xpath("//div[text()='Unit/Sales Script']")).click();
			Thread.sleep(2000);
			assertEquals(log.driver.findElement(By.xpath("(//div[@class='w20_treeview'])[2]/div/div[2]")).getText(), "Unit/Sales Script");
			Thread.sleep(1000);
			log.driver.findElement(By.id("okbutton")).click();
			Thread.sleep(2000);
			assertEquals(log.driver.findElement(By.id("-1/0")).getText(),"salesvalue");
			log.driver.close();
}
}
