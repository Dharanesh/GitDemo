package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import action.Login_BKP;
import event.Utils;
import event.Waits;

public class TestCase_24652 extends TestUtils
{
	Login log = null;
	Waits waits =null;
	Utils Utils = null;
	Login_BKP Create_Report=null;
	event.Excelnput Excelnput=null;
	
  @Test
  @Parameters("browser")
  public void f(String browser) throws Exception
  {
	//Testcase step 1 to step 4
			// login to the application
			test =extent.createTest("TestCase_24652 for granting open/Read/execute for Training user (should not be in Administrator group) ");
			Login log = new Login();
			log.driver = log.get_Browser(browser);
			super.driver = log.login(log.driver);

			//		log.createReport(log.driver,"Sales");
			Waits waits = new Waits(log.driver);
			Utils ui = new Utils(log.driver);

			//Testcase step 5 to step 7
			waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("DisplayvalueStatusXpath"));
			String Status_Value=log.driver.findElement(By.xpath(log.getData("DisplayvalueStatusXpath"))).getText();
			System.out.println(Status_Value);
			 int value=Status_Value.indexOf("C");
			 System.out.println(value);
			String NewValue =Status_Value.substring(value);
			System.out.println(NewValue);
			System.out.println("Repository Name"+NewValue);

			waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("DisplayCurrentUserXpath"));
			String Status_Value1=log.driver.findElement(By.xpath(log.getData("DisplayCurrentUserXpath"))).getText();
			System.out.println(Status_Value1);
			
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[@title='Show Menu']");
			Assert.assertTrue(log.driver.findElement(By.xpath("//span[@title='Show Menu']")).isDisplayed());
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[@title='Show Menu']");
			log.driver.findElement(By.xpath("//span[@title='Show Menu']")).click();
			Thread.sleep(1000);
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Repository']");
			Assert.assertTrue(log.driver.findElement(By.xpath("//div[text()='Repository']")).isDisplayed());
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Repository']");
			log.driver.findElement(By.xpath("//div[text()='Repository']")).click();
			Thread.sleep(1000);
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Repository Settings']");
			Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Repository Settings']")).isDisplayed());
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Global Permissions...']");
			Assert.assertTrue(log.driver.findElement(By.xpath("//a[text()='Global Permissions...']")).isDisplayed());
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Global Permissions...']");
			log.driver.findElement(By.xpath("//a[text()='Global Permissions...']")).click();
			Thread.sleep(1000);
			
			List<WebElement> Permission_window_button = log.driver.findElements(By.xpath(log.getData("Buttons")));
			ArrayList<String> Global_per_Name_window = new ArrayList<String>();
			System.out.println("Action button in Permission window");
			Global_per_Name_window.add("Take Ownership");
			Global_per_Name_window.add("Set Ownership...");
			Global_per_Name_window.add("Effective Permissions...");
			Global_per_Name_window.add("Add Permission...");
			Global_per_Name_window.add("Add Role...");
			Global_per_Name_window.add("Remove");
			Global_per_Name_window.add("OK");
			Global_per_Name_window.add("Cancel");
			Global_per_Name_window.add("Help");

			
			assertEquals(log.driver.findElement(By.xpath("//div[@style='margin-top: 20px; margin-bottom: 10px; height:26px;']")).getText(), "Take Ownership");
			assertEquals(log.driver.findElement(By.xpath("(//div[@style='height:26px;'])[1]")).getText(), "Set Ownership...");
			assertEquals(log.driver.findElement(By.xpath("(//div[@style='height:26px;'])[2]")).getText(), "Remove");
			assertEquals(log.driver.findElement(By.xpath("//div[@style='position: absolute; right: 0px;  bottom: 0px; width:180px; height:26px;']")).getText(), "Effective Permissions...");
			assertEquals(log.driver.findElement(By.xpath("//div[@style='margin-top: 25px; margin-bottom: 10px; height:26px;']")).getText(), "Add Permission...");
			assertEquals(log.driver.findElement(By.xpath("//div[@style='margin-bottom: 30px; height:26px;']")).getText(), "Add Role...");
			List<WebElement> button = log.driver.findElements(By.xpath("//div[@class='w20_modal-footer-wrapper' ]/input[ @type='button']"));
			ArrayList<String >Buttons = new ArrayList<String>();
			Buttons.add("OK");
			Buttons.add("Cancel");
			Buttons.add("Help");
			for(int i=0;i<button.size();i++) 
			{	
				assertEquals(button.get(i).getAttribute("value"), Buttons.get(i));
				System.out.println(button.get(i).getAttribute("value"));
			}
			

			log.driver.findElement(By.xpath("//div[@style='margin-top: 20px; margin-bottom: 10px; height:26px;']")).click();
			Thread.sleep(1000);
			assertEquals(log.driver.findElement(By.id("yesbutton")).getAttribute("value"), "Yes");
			assertEquals(log.driver.findElement(By.id("nobutton")).getAttribute("value"), "No");
			log.driver.findElement(By.id("yesbutton")).click();
			Thread.sleep(3000);
			
			
			assertEquals(log.driver.findElement(By.xpath("(//tr[@class='lvitem']/td[@colspan='2'])[1]")).getText(), "Admin");
			Thread.sleep(200);
			log.driver.findElement(By.xpath("(//label[@class='k-checkbox-label'])[5]/..")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("(//div[@style='height:26px;'])[2]")).click();
			Thread.sleep(2000);
			
			log.driver.findElement(By.xpath("//div[@style='margin-top: 25px; margin-bottom: 10px; height:26px;']")).click();
			waits.waituUnitil_Element_Clickable(10,"(//input[@class='w20_modal-footer-button k-primary k-button'])[1]");
			Thread.sleep(2000);
			WebElement element1 = log.driver.findElement(By.xpath("//*[text()='Test_C10']"));
			((JavascriptExecutor)log.driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//td[text()='Test_C10']/../td[1]")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//td[text()='Read/Open/Execute Object']/../td[1]")).click();
			Thread.sleep(2000);
			assertTrue(log.driver.findElement(By.xpath("//label[text()='Grant']/../input")).isSelected());
			
			log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
			Thread.sleep(1500);
			assertEquals(log.driver.findElement(By.xpath("(//tr[@class='lvitem']/td[@colspan='2'])[1]")).getText(), "Admin");
			waits.waituUnitil_Element_Clickable(10,"//input[@value='OK']");
			log.driver.findElement(By.id("okbutton")).click();
			waits.waituUnitil_Element_Clickable(10,"//span[@title='Show Menu']");
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//span[@title='Show Menu']")).click();
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("//div[text()='Log Off']")).click();
			Thread.sleep(1000);
			waits.waituUnitil_Element_Clickable(10,"//input[@value='OK']");
			log.driver.findElement(By.id("okbutton")).click();
			Thread.sleep(5000);	
			waits.waituUnitil_Element_Clickable(20,"//*[contains(text(),'Login')]");
			log.driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
			Thread.sleep(3000);	
			log.driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).click();
			log.driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).sendKeys("Test_C10");
			log.driver.findElement(By.xpath("//input[@class='k-input server-name']")).sendKeys("localhost:10901");
			log.driver.findElement(By.xpath("//input[@type='button'][1]")).click();
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select Repository']");
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='C8 Cockpit PROFESSIONAL']");
			Thread.sleep(200);
			
			Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).isDisplayed(), true);
			log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).click();
			
			Thread.sleep(2000);
			
			log.driver.findElement(By.xpath("(//input[@type='button'][1])[1]")).click();
			Thread.sleep(5000);
			ui.rightClick("//span[text()='Manangement overview']");
			Thread.sleep(2000);
			ArrayList<String> avail = new ArrayList<String>();
			System.out.println("Action button in Permission window");
			avail.add("Open");
			avail.add("New Folder...");
			avail.add("Export...");
			avail.add("Import...");
			avail.add("Send to...");
			avail.add("Description...");
			List<WebElement> availbale=	log.driver.findElements(By.xpath("//ul/li[@class='k-item k-state-default w20_menuitem']"));
			System.out.println("==================================");
			for(int i =0;i<availbale.size();i++) 
			{
				assertEquals(avail.get(i), availbale.get(i).getText());
				System.out.println(availbale.get(i).getText());
			}
			
			log.driver.findElement(By.xpath("//span[@title='Show Menu']")).click();
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("//div[text()='Log Off']")).click();
			Thread.sleep(2000);
			waits.waituUnitil_Element_Clickable(10,"//input[@value='OK']");
			log.driver.findElement(By.id("okbutton")).click();
			Thread.sleep(2000);		
			Thread.sleep(2000);
//			log.driver.navigate().refresh();
			
			
			System.out.println("==================");
			waits.waituUnitil_Element_Clickable(20,"//*[contains(text(),'Login')]");
			log.driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
			waits.waituUnitil_Element_Clickable(20,"//input[@value='OK']");		
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).click();
			log.driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).sendKeys("Admin");
			log.driver.findElement(By.xpath("//span[text()='Password:']/following::input[1]")).sendKeys("Admin");
			log.driver.findElement(By.xpath("//input[@class='k-input server-name']")).sendKeys("Localhost:10901");
			log.driver.findElement(By.xpath("//input[@type='button'][1]")).click();
			
			
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select Repository']");
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='C8 Cockpit PROFESSIONAL']");
			Thread.sleep(200);
			
			Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).isDisplayed(), true);
			log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).click();
			
			
			
			waits.waituUnitil_Element_Clickable(10,"(//input[@type='button'][1])[1]");
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("(//input[@type='button'][1])[1]")).click();
			Thread.sleep(5000);
			waits.waituUnitil_Element_Clickable(10,"//span[@title='Show Menu']");
			log.driver.findElement(By.xpath("//span[@title='Show Menu']")).click();	
			Thread.sleep(1000);
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Repository']");
			Thread.sleep(1000);
			log.driver.findElement(By.xpath("//div[text()='Repository']")).click();
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Repository Settings']");
			Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Repository Settings']")).isDisplayed());
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Global Permissions...']");
			Assert.assertTrue(log.driver.findElement(By.xpath("//a[text()='Global Permissions...']")).isDisplayed());
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//a[text()='Global Permissions...']");
			log.driver.findElement(By.xpath("//a[text()='Global Permissions...']")).click();
			Thread.sleep(1000);

			log.driver.findElement(By.xpath("//div[@style='margin-top: 20px; margin-bottom: 10px; height:26px;']")).click();
			Thread.sleep(1000);
			assertEquals(log.driver.findElement(By.id("yesbutton")).getAttribute("value"), "Yes");
			assertEquals(log.driver.findElement(By.id("nobutton")).getAttribute("value"), "No");
			log.driver.findElement(By.id("yesbutton")).click();
			Thread.sleep(3000);
			
			assertEquals(log.driver.findElement(By.xpath("(//tr[@class='lvitem']/td[@colspan='2'])[1]")).getText(), "Admin");
			Thread.sleep(2000);
			
			log.driver.findElement(By.xpath("(//label[@class='k-checkbox-label'])[5]/..")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("(//div[@style='height:26px;'])[2]")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//div[@style='margin-top: 25px; margin-bottom: 10px; height:26px;']")).click();
			Thread.sleep(2000);
			waits.waituUnitil_Element_Clickable(10, "(//input[@id='okbutton'])[1]");
			WebElement admin = log.driver.findElement(By.xpath("(//*[text()='Admin'])[1]"));
			((JavascriptExecutor)log.driver).executeScript("arguments[0].scrollIntoView(true);", admin);
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//td[text()='Admin']/../td[1]")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//td[text()='Full Control']/../td[1]")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.id("okbutton")).click();
			Thread.sleep(100);
			log.driver.close();
			
			
			
	  	
  }
  
}
