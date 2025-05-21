package smokeCase;

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


public class TestCase_24667 extends TestUtils
{
	
		@Test	
		@Parameters("browser")
		public void Testcase_for_Denying_navigate_Dimension_for_sale_by_country_report(String browser) throws Exception
		{
		    test =extent.createTest("TestCase_24667 : Testcase for Denying navigate Dimension for sale by country report");
		    
			Login log = new Login();
			log.driver = log.get_Browser(browser);
			super.driver = log.login(log.driver);
			Waits waits = new Waits(log.driver);
			Utils ui = new Utils(log.driver);
			
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
			Thread.sleep(2000);
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Add Permission...']");
			log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).click();
			Thread.sleep(1000);
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Permission']/../..");
			assertTrue(log.driver.findElement(By.xpath("//span[text()='New Permission']/../..")).isDisplayed());
			
			log.driver.findElement(By.xpath("//td[contains(text(),'Full Control')]/preceding::td[2]")).click();
			Thread.sleep(200);
	
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Training User']/../td[1]");
			log.driver.findElement(By.xpath("//td[text()='Training User']/../td[1]")).click();
			Thread.sleep(200);
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
			log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
			Thread.sleep(2000);
		//open sales by country 
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Sales by country']");
		ui.rightClick("//span[text()='Sales by country']");
		Thread.sleep(2000);
        waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Report']/../../..");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[@class='k-animation-container ui-draggable ui-draggable-handle']")).isDisplayed(),true);
		Thread.sleep(100);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Report']/../../li/span[1]");
		List<WebElement> report_contextmenu_options =log.driver.findElements(By.xpath("//span[.='Report']/../../li/span[1]"));
		ArrayList<String > contextmenu_btn = new ArrayList<String>();
		contextmenu_btn.add("Open");
		contextmenu_btn.add("Add to Favorite Folder");
		contextmenu_btn.add("Duplicate");
		contextmenu_btn.add("Rename");
		contextmenu_btn.add("Delete");
		contextmenu_btn.add("Move...");
		contextmenu_btn.add("Export...");
		contextmenu_btn.add("Import...");
		contextmenu_btn.add("Send to...");
		contextmenu_btn.add("Language Terms...");
		contextmenu_btn.add("Description...");
		contextmenu_btn.add("Properties...");
		contextmenu_btn.add("Permissions...");
		contextmenu_btn.add("Information...");
		
		System.out.println("Report context menu options are : ");
		Thread.sleep(5000);
		for (WebElement we : report_contextmenu_options)
		{
			report_contextmenu_options.contains(contextmenu_btn);
			System.out.println(we.getText());
			test.info(we.getText());
		}
		report_contextmenu_options.get(report_contextmenu_options.size() - 2).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Permissions for')])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[2]")).isDisplayed());
		System.out.println(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[3]/span")).getText());
		test.info(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[3]/span")).getText());
		
			
		//verifying actions button on permissions for sales by country window
	    List<WebElement> action_buttons =log.driver.findElements(By.xpath("//span[contains(.,'Permission')]/following::button"));
		System.out.println("Permission for sales by country report window have below mentioned buttons");
		ArrayList<String > action_btn = new ArrayList<String>();
		action_btn.add("Take Ownership");
		action_btn.add("Set Ownership...");
		action_btn.add("Effective Permissions...");
		action_btn.add("Add Permission...");
		action_btn.add("Add Role...");
		action_btn.add("Remove");
		System.out.println(action_buttons.size());
		
		for (int i=0;i<action_buttons.size()-1;i++) 
		{
		String btns = action_buttons.get(i).getText();
		Assert.assertEquals(btns, action_btn.get(i)," All Buttons are available");
		System.out.println(btns);
		}
		
		log.driver.findElement(By.xpath(".//button[text()='Take Ownership']")).click();//step 9
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Taking ownership cannot be undone.']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Taking ownership cannot be undone.']")).isDisplayed(), "Popup displayed");
		List<WebElement> warng_msg_btns = log.driver.findElements(By.xpath("//span[text()='Taking ownership cannot be undone.']/ancestor::div[4]/div[2]/div/input"));
		Assert.assertEquals(warng_msg_btns.get(0).getAttribute("value"),"Yes");
		Assert.assertEquals(warng_msg_btns.get(1).getAttribute("value"),"No");
		
		
		warng_msg_btns.get(0).click();//step 10
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Permissions for')])[2]");
		assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[2]")).isDisplayed());
		System.out.println("Permission for sales  by country window displayed.");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//tr[@class='lvitem'])[1]/td[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[2]")).getText(),"Sales by country");
		System.out.println("Name is sales by country");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//tr[@class='lvitem'])[1]/td[3]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[3]")).getText(),"Admin");
		System.out.println(log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[3]")).getText());
		System.out.println("Owner is Admin");
		
		if(log.driver.findElement(By.xpath("//label[text()='Disable inheritance of parent roles and permissions']/preceding::input[1]")).isSelected())
		{
			System.out.println("Selected");
		}
		else
		{
			log.driver.findElement(By.xpath("//label[text()='Disable inheritance of parent roles and permissions']")).click();
			System.out.println("Disable inheritance of parent roles and permissions Selected");
		}
		
		List<WebElement> CB_list = log.driver.findElements(By.xpath("//span[text()='List of permissions and roles of (first) selected object:']/ancestor::div[3]/div[2]/div/table/tbody/tr/td[1]"));
		try {
			if(CB_list.isEmpty())
			{
				System.out.println("No permission present in list of permissions filed.");
			}
			}catch (Exception e) {
				System.out.println("permission field is not empty");
			}
		
		for (int i = 0; i <=CB_list.size()-1; i++) {
			CB_list.get(i).click();
			Thread.sleep(200);
			Assert.assertTrue(CB_list.get(i).isEnabled());
			
		}
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//button[text()='Remove']")).click();
		
		//Verify the field is empty------------------------------
				//--------------------------step 15 to  ----------------------
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Permission']/../..");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='New Permission']/../..")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Available rights:']")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Available users and groups:']")).isDisplayed());
		
		assertTrue(log.driver.findElement(By.xpath("//label[.='Grant']/../../td")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//label[.='Deny']/../../td")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//label[.='Grant']/../../td/input")).isSelected());
		Thread.sleep(5000);
		
		log.driver.findElement(By.xpath("//td[contains(text(),'Full Control')]/preceding::td[2]")).click();
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[contains(text(),'Full Control')]/preceding::td[2]");
		assertTrue(log.driver.findElement(By.xpath("//td[contains(text(),'Full Control')]/preceding::td[2]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Training']/../td[1]");
		log.driver.findElement(By.xpath("//td[text()='Training']/../td[1]")).click();
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Training']/../td[1]");
		assertTrue(log.driver.findElement(By.xpath("//td[text()='Training']/../td[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Permissions for')])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[2]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Add Permission...']");
		log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).click();
		Thread.sleep(2000);//step 22
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Permission']/../..");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='New Permission']/../..")).isDisplayed());
		
		log.driver.findElement(By.xpath("//td[text()='Navigate Dimension (DrillDown/RollUp)']/../td[1]")).click();
		Thread.sleep(2000);//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Navigate Dimension (DrillDown/RollUp)']/../td[1]");
		assertTrue(log.driver.findElement(By.xpath("//td[text()='Navigate Dimension (DrillDown/RollUp)']/../td[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Training']/../td[1]");
		log.driver.findElement(By.xpath("//td[text()='Training']/../td[1]")).click();
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Training']/../td[1]");
		assertTrue(log.driver.findElement(By.xpath("//td[text()='Training']/../td[1]/input")).isSelected());//24
		
		log.driver.findElement(By.xpath("//label[.='Deny']/../../td")).click();//step 25
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[.='Deny']/../../td");
		assertTrue(log.driver.findElement(By.xpath("//label[.='Deny']/../../td/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Permissions for')])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[2]")).isDisplayed());
		
		String Deny="deny";
		String value=log.driver.findElement(By.xpath("//td[contains(text(),'Navigate Dimension (DrillDown/RollUp)')]/preceding::td[2]/span")).getAttribute("class");//step 25
		assertTrue(value.contains(Deny));
		System.out.println("Navigate Dimension permission is denied for user Training");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		
	
		//reconnecting as Training user
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[@title='Show Menu']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[@title='Show Menu']")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[@title='Show Menu']");
		log.driver.findElement(By.xpath("//span[@title='Show Menu']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Connect to Server']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//div[text()='Connect to Server']")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Connect to Server']");
		log.driver.findElement(By.xpath("//div[text()='Connect to Server']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Log On C8 Server']");
	    assertTrue(log.driver.findElement(By.xpath("//span[text()='Log On C8 Server']")).isDisplayed());
		
	    log.driver.findElement(By.xpath("//span[text()='User Name:']/following::div[3]/input")).sendKeys("Training");
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@placeholder='Enter or Select Sever...']");
	    log.driver.findElement(By.xpath("//input[@placeholder='Enter or Select Sever...']")).sendKeys("localhost:10901");
	    log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select Repository']");

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='C8 Cockpit PROFESSIONAL']");
		Thread.sleep(200);
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).isDisplayed(), true);
		Thread.sleep(200);
		log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//input[@id='okbutton'])[1]");
		Thread.sleep(200);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		/*log.driver.findElement(By.xpath("//span[@class='k-link' and text()='Welcome']/span")).click();
		Thread.sleep(2000);*/
		System.out.println("Login Sucessfully");
		//open sales by country 
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Sales by country']");
	    log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
		Thread.sleep(3000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Sales by country'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[2]")).isDisplayed(),true);
		Thread.sleep(100);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[.='All Customers'])[1]");
		log.driver.findElement(By.xpath("(//div[.='All Customers'])[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[.='All Customers'])[1]");
		ui.rightClick("(//div[.='All Customers'])[1]");
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Show expansion symbol']")).isDisplayed())
			{
				System.out.println("Show expansion symbol Available");
			}
		}
		catch(Exception e)
		{
			 Actions act = new Actions(log.driver);
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='-1/0'])[1]"))).perform();
		     Thread.sleep(2000);
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='All Customers'])[1]");

		//assertTrue(log.driver.findElement(By.xpath("(//span[text()='All Customers'])[1]")).isDisplayed());
		
		log.driver.findElement(By.xpath("//span[text()='Show expansion symbol']")).click();
		Thread.sleep(1000);
		assertTrue(log.driver.findElement(By.xpath("//div[.='All Customers']/img")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//div[.='All Customers']/img")).getAttribute("src").contains("minus.gif"));
		//verify all customers expansion symbol changed from minus to plus.
		Actions actions = new Actions(log.driver);
		actions.doubleClick(log.driver.findElement(By.xpath("(//div[.='All Customers'])[1]"))).build().perform();
		Thread.sleep(2000);
		if(log.driver.findElement(By.xpath("//div[.='All Customers']/img")).getAttribute("src").contains("plus.gif"))
		{
		System.out.println("navigated to c element");
		}
		else
		{
			System.out.println("Navigate dimension is denied for user Training for Sales by Country report");
			test.info("Navigate dimension is denied for user Training for Sales by Country report");
		}
		log.driver.close();
		
		
		
		
		
		
		
	}
}
