package regression;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.RenderingHints.Key;
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

public class TestCase_38263 extends TestUtils
{
	
	@Test	
	@Parameters("browser")

	public void  Cockpit_Navigator_functionality_LocalExport(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_28825 :  12742    TestCase for Cockpit Navigator functionality - Local Export");
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
      
      log.driver.findElement(By.xpath("//span[text()='Local Export']")).click();
      Thread.sleep(1000);
      log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
      Thread.sleep(1000);
      wait.waitUntil_Elmentis_visibilityOfElement(20,"//*[contains(text(),'local export')]");
      log.driver.findElement(By.xpath("//div[contains(text(),'All Reports')]")).click();
      Thread.sleep(2000);
      log.driver.findElement(By.cssSelector("#okbutton")).click();
      wait.waitUntil_Elmentis_visibilityOfElement(20,"//span[contains(text(),'Name and Description')]");
      log.driver.findElement(By.xpath("(//input[@type='input'])[1]")).sendKeys("Local_Export_Click");
      Actions act = new Actions(log.driver);
      act.sendKeys(Keys.TAB).perform();    		  
      log.driver.findElement(By.cssSelector("#nextbutton")).click();
      wait.waituUnitil_Element_Clickable(20,"//button[@data-title='Add report(s) and/or folder(s)']");
      log.driver.findElement(By.xpath("//button[@data-title='Add report(s) and/or folder(s)']")).click();
      wait.waituUnitil_Element_Clickable(20,"//input[@id='okbutton']");
      log.driver.findElement(By.xpath("//div[text()='Sales by country']/../div[1]")).click();
      Thread.sleep(200);
      log.driver.findElement(By.cssSelector("#okbutton")).click();
      wait.waituUnitil_Element_Clickable(20,"//td[text()='Sales by country']");
      log.driver.findElement(By.cssSelector("#nextbutton")).click();
      wait.waituUnitil_Element_Clickable(20,"//input[@id='nextbutton']");
      log.driver.findElement(By.xpath("//span[text()='PDF']")).click();
      Thread.sleep(200);
      log.driver.findElement(By.cssSelector("#nextbutton")).click();
      wait.waituUnitil_Element_Clickable(20,"//input[@id='nextbutton']");
      assertEquals(log.driver.findElement(By.xpath("(//input[@type='input'])[1]")).getAttribute("value"), "Local_Export_Click");
      log.driver.findElement(By.cssSelector("#nextbutton")).click();
      wait.waituUnitil_Element_Clickable(20,"//span[text()='Iteration Settings']");
      ArrayList<String> tab = new ArrayList<>();
      tab.add("No iteration");
      tab.add("Iterate within each report using selected filter elements");
      tab.add("Iterate across all reports for each selected dimension element");
      
      List<WebElement> display = log.driver.findElements(By.xpath("//label[@class='k-radio-label']"));
      for(int  i =0;i<=display.size()-1;i++) 
      {
    	  assertEquals(display.get(i).getText(), tab.get(i));

      }
      
     boolean status = log.driver.findElement(By.xpath("//label[text()='No iteration']/../input")).isSelected();
     assertTrue(status);
     log.driver.findElement(By.cssSelector("#nextbutton")).click();
     wait.waituUnitil_Element_Clickable(20,"//input[@id='finishbutton']");
     log.driver.findElement(By.xpath("//input[@id='finishbutton']")).click();
     Thread.sleep(3000);
     act.contextClick(log.driver.findElement(By.xpath("//span[text()='Local_Export_Click']"))).perform();
     wait.waituUnitil_Element_Clickable(20,"//span[text()='Delete']");
     log.driver.findElement(By.xpath("//span[text()='Delete']")).click();
     wait.waituUnitil_Element_Clickable(20,"//input[@id='nobutton']");
     log.driver.findElement(By.xpath("//input[@id='yesbutton']")).click();
     Thread.sleep(2000);
     log.driver.quit();
     
//     List<WebElement> repots = log.driver.findElements(By.xpath("//span[@class='w20_treehover']"));
//     for (int i =0;i<=reports.size()-1;i++) 
//     {
//    	 System.out.println(reports.get(i).getText());
//    	 System.out.println("Chceking");
//     }
//     
//       
//      
//      
      

	}
}
