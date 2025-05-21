package regression;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
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
import event.Utils;
import event.Waits;

public class TestCase_38260  extends TestUtils
{
	
	@Test	
	@Parameters("browser")

	public void  Cockpit_DataView_Olap_Functions_ClientRules_ExistDimElem(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_28822 :  12739  TestCase for Cockpit Navigator functionality - MDX Report");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		log.login(log.driver);
		Waits wait = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
// Create MDX  Reprot
		


        log.driver.findElement(By.xpath("//span[text()='New']")).click();
        Thread.sleep(1000);
       
        //Wait for new report window open:=================
      log.driver.findElement(By.xpath("//span[text()='New Report']")).isDisplayed();
      Thread.sleep(1000);
      ArrayList<String > name = new ArrayList<>();
      name.add("Standard Report");
      name.add("ABC Classification");
      name.add("Empty Report");
      name.add("Relational Report");
      name.add("MDX Report");
      name.add("Entry Report");
      name.add("Report from a Template");
      name.add("Local Export");
      
        //Select Standard Report and click next:==============
      List<WebElement> reports= log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
      for (int i =0;i<reports.size();i++) 
      {
    	 assertEquals(name.get(i),reports.get(i).getText());
      }
      
      log.driver.findElement(By.xpath("//span[text()='MDX Report']")).click();
      Thread.sleep(1000);
      log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
      Thread.sleep(1000);
      wait.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='MDX Statement']");
      log.driver.findElement(By.xpath("//span[text()='Query']")).click();
      Thread.sleep(2000);
      Actions act = new Actions(log.driver);
      act.sendKeys(Keys.TAB,Keys.TAB).perform();
      act.sendKeys("SELECT\r\n" + 
      		"    {[Measures].[Units sold]} ON COLUMNS,\r\n" + 
      		"    [Category].[Category].members ON ROWS\r\n" + 
      		"    FROM [A - Training Sales]").perform();
      Thread.sleep(1000);
      log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
      Thread.sleep(1000);
      log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
      Thread.sleep(1000);
      Thread.sleep(1000);
      log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
      Thread.sleep(1000);
      log.driver.findElement(By.xpath("(//input[@class='k-textbox w20_webedit_left'])[1]")).clear();
      
      log.driver.findElement(By.xpath("(//input[@class='k-textbox w20_webedit_left'])[1]")).sendKeys("Navigator functionality - MDX Report");
      Thread.sleep(2000);
      log.driver.findElement(By.xpath("//span[text()='Description']/following::textarea[1]")).click();
      Thread.sleep(3000);
      //Click Finish:====================
      log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
      Thread.sleep(3000);
      wait.waituUnitil_Element_Clickable(20, "//li[@id='tab0']");
      log.driver.close();
//      log.driver.findElement(By.xpath("//span[text()='Save']")).click();
//      wait.waituUnitil_Element_Clickable(20,"//div[text()='Eigene Berichte']");
//      log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
//      Thread.sleep(200);
//      log.driver.findElement(By.id("okbutton")).click();
//      wait.waituUnitil_Element_Clickable(20, "//li[@id='tab0']");
//      log.driver.navigate().refresh();
//      Thread.sleep(5000);
//      log.driver.findElement(By.id("tab_close_btn")).click();
//      Thread.sleep(2000);
	}}