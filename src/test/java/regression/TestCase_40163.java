	package regression;

import static org.testng.Assert.assertEquals;

import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Excelnput;
import event.Utils;
import event.Waits;

public class TestCase_40163 extends TestUtils
{

	@Test	
	@Parameters("browser")

	public void Cockpit_DataView_Olap_Functions_ClientRules_DimPrevious(String browser) throws Exception
	{
	    test =extent.createTest("Test Case 28784: 14177 : Cockpit DataView Olap Functions for ClientRules_DimPrevious");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		log.login(log.driver);
		Waits wait = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		log.createCubeReport("//div[contains(text(),'Training Sales')]", "TestCase_28783", false);
		
//		Client rule 
		wait.waituUnitil_Element_Clickable(20, "(//span[@class='w20_listboxitemtext'])[9]");
		String text = log.driver.findElement(By.xpath("(//span[@class='w20_listboxitemtext'])[9]")).getText();
		System.out.println(text);
		Thread.sleep(2000);
		if(!text.equalsIgnoreCase("Time")) 
		{
		// remove timetype from row
				WebElement from = log.driver.findElement(By.xpath("(//span[text()='Time'])[1]"));
				WebElement to = log.driver.findElement(By.xpath("(//div[@class='k-list-scroller k-selectable'])[3]"));
				ui.dragAndDrop(from, to);
				wait.waituUnitil_Element_Clickable(20, "(//span[text()='Time'])[1]");
				
				WebElement from1 = log.driver.findElement(By.xpath("(//span[text()='Timetype'])[1]"));
				WebElement to1 = log.driver.findElement(By.xpath("(//span[@class='w20_listboxitem'])[1]"));
				ui.dragAndDrop(from1, to1);
		}
		String messure = log.driver.findElement(By.xpath("(//span[@class='w20_listboxitemtext'])[11]")).getText();
		assertEquals(messure, "Measures");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Time'])[1]")).click();
		wait.waituUnitil_Element_Clickable(20, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		wait.waitUntil_Elmentis_visibilityOfElement(20,"//span[contains(text(),'0 Items')]");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//*[text()='2012']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//*[text()='2013']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//*[text()='2014']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//*[text()='2015']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//*[text()='2016']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.id("okbutton")).click();
		wait.waituUnitil_Element_Clickable(20,"(//span[@class='w20_listboxitemtext'])[11]");
		log.driver.findElement(By.xpath("(//span[@class='w20_listboxitemtext'])[11]")).click();
		wait.waituUnitil_Element_Clickable(20, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		wait.waitUntil_Elmentis_visibilityOfElement(20,"//span[contains(text(),'0 Items')]");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//div[@class='floatbox'])[1]")).click();
		Thread.sleep(2000);
		wait.waituUnitil_Element_Clickable(20,"(//span[text()='MeasuresLevel'])[1]");
		log.driver.findElement(By.xpath("(//span[text()='MeasuresLevel'])[1]")).click();
		Thread.sleep(200);
		wait.waituUnitil_Element_Clickable(20,"(//div[text()='Sales price'])[1]");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//div[text()='Sales price'])[1]")).click();
		wait.waitUntil_Elmentis_visibilityOfElement(20,"//span[contains(text(),'1 Items')]");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		wait.waituUnitil_Element_Clickable(20, "(//span[text()='Client Rules'])[1]");
		log.driver.findElement(By.xpath("(//span[text()='Client Rules'])[1]")).click();
		wait.waituUnitil_Element_Clickable(20,"(//span[contains(text(),'Muster')])[1]");
		List<WebElement> ele = log.driver.findElements(By.xpath("(//div[@class='k-list-scroller k-selectable'])[2]/ul/li/div/span"));
		for(int i =0;i<ele.size();i++) 
		{
			Thread.sleep(5000);
			if(ele.get(i).getText().equalsIgnoreCase("DimPrevious")) 
			{
				ele.get(i).click();
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
				wait.waituUnitil_Element_Clickable(20,"//input[@id='nobutton']");
				log.driver.findElement(By.xpath("//input[@id='yesbutton']")).click();
				break;
			}
			
		}
		wait.waituUnitil_Element_Clickable(20,"//button[text()='New...']");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		wait.waituUnitil_Element_Clickable(20,"//div[text()='Global Rule']");
		log.driver.findElement(By.xpath("//div[text()='Global Rule']")).click();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		wait.waituUnitil_Element_Clickable(20,"//button[text()='Check Syntax']");
		log.driver.findElement(By.xpath("//div[@class='w20_webedit']/div/input[1]")).sendKeys("DimPrevious");
		wait.waituUnitil_Element_Clickable(20,"//button[text()='Check Syntax']");
		log.driver.findElement(By.xpath("//input[@value='<Global>']")).click();
		Thread.sleep(3000);
		Excelnput exl  = new Excelnput();
		
		Actions act = new Actions(log.driver);
		act.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB).perform();
		act.sendKeys(exl.ExcelDatainput("UAT", 4, 1)).perform();
		log.driver.findElement(By.xpath("//span[text()='Rule definition:']")).click();
		wait.waituUnitil_Element_Clickable(20,"//button[text()='Check Syntax']");
		log.driver.findElement(By.xpath("//button[text()='Check Syntax']")).click();
		wait.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='Syntax is OK!']");
		Thread.sleep(3000);
		assertEquals(log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).getAttribute("value"), "OK");
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		Thread.sleep(2000);
		wait.waituUnitil_Element_Clickable(20,"(//input[@value='OK'])[1]");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		wait.waituUnitil_Element_Clickable(20,"//span[text()='GetElement']");
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		wait.waituUnitil_Element_Clickable(20,"//button[text()='Element Groups...']/following::span[1]");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::span[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Client Rules'])[3]")).click();
		Thread.sleep(2000);
		wait.waituUnitil_Element_Clickable(20,"//div[text()='DimPrevious']");
		log.driver.findElement(By.xpath("//div[text()='DimPrevious']")).click();
		wait.waituUnitil_Element_Clickable(20,"//span[contains(text(),'2 Items')]");
		log.driver.findElement(By.cssSelector("#okbutton")).click();
		Thread.sleep(2000);
		assertEquals(log.driver.findElement(By.xpath("//div[@id='1/-1']")).getText(), "DimPrevious");
		log.driver.findElement(By.xpath("(//span[text()='Measures'])[1]")).click();
		wait.waituUnitil_Element_Clickable(20,"(//*[contains(text(),'Measures')])[1]");
		log.driver.findElement(By.xpath("(//button[@class='cw_button icon_button k-button k-button-icontext'])[4]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//*[text()='DimPrevious'])[1]/../div[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//*[text()='Properties...']")).click();
		wait.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Properties of Element']");
		Thread.sleep(200);
		log.driver.findElement(By.xpath("//span[text()='Alias:']/following::input[1]")).sendKeys("DimPreviousGloba");
		Thread.sleep(200);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		wait.waituUnitil_Element_Clickable(20,"//div[@id='1/-1']");
		assertEquals(log.driver.findElement(By.xpath("//div[@id='1/-1']")).getText(), "DimPreviousGloba");
		log.driver.quit();
//		
			
		
	
	
			

}
}