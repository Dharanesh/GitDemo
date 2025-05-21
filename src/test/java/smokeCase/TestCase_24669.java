
package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

public class TestCase_24669 extends TestUtils
{
	@Test	
	@Parameters("browser")
	public void Testcase_to_verifying_assigned_permission_for_particular_user_for_sales_by_country_report_in_Effective_permission_window(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24669 : Testcase to verifying assigned permission for particular user for sales by country report  in Effective permission window");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);

		Assert.assertTrue(findVisibleBool(By.xpath("//span[@title='Show Menu']")));
		clickableClick(By.xpath("//span[@title='Show Menu']"));
		
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
		
		Thread.sleep(2000);
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
		//waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
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

		log.driver.findElement(By.xpath("//span[.='Report']/../../li/span[text()='Permissions...']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Permissions for')])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[2]")).isDisplayed());
		System.out.println(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[3]/span")).getText());
		test.info(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[3]/span")).getText());
		
			
		//verifying actions button on permissions for sales by country window
	    List<WebElement> action_buttons =log.driver.findElements(By.xpath("//div[@class='linebox32']/following::button"));
		System.out.println("Permission for sales by country report window have below mentioned buttons");
		ArrayList<String > action_btn = new ArrayList<String>();
		action_btn.add("Take Ownership");
		action_btn.add("Set Ownership...");
		action_btn.add("Effective Permissions...");
		action_btn.add("Add Permission...");
		action_btn.add("Add Role...");
		action_btn.add("Remove");
			
		for (int  i=0; i < 5 ;i++)
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
		assertTrue(findVisibleBool(By.xpath("(//div[contains(.,'Permissions for')])[2]")));
		System.out.println("Permission for sales  by country window displayed.");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//tr[@class='lvitem'])[1]/td[2]");
		Assert.assertEquals(findVisible(By.xpath("(//tr[@class='lvitem'])[1]/td[2]")).getText(),"Sales by country");
		System.out.println("Name is sales by country");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//tr[@class='lvitem'])[1]/td[3]");
		Assert.assertEquals(findVisible(By.xpath("(//tr[@class='lvitem'])[1]/td[3]")).getText(),"Admin");
		System.out.println(findVisible(By.xpath("(//tr[@class='lvitem'])[1]/td[3]")).getText());
		System.out.println("Owner is Admin");
		
		boolean stat=isSelectedBool(By.xpath("//label[text()='Disable inheritance of parent roles and permissions']/preceding::input[1]"));
		if(stat)
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
		
		for (int i = 0; i < CB_list.size()-1; i++) {
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
		
		log.driver.findElement(By.xpath("//td[contains(text(),'Create Action')]/preceding::td[2]")).click();
		Thread.sleep(2000);//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[contains(text(),'Create Action')]/preceding::td[2]");
		assertTrue(log.driver.findElement(By.xpath("//td[contains(text(),'Create Action')]/preceding::td[2]/input")).isSelected());
		
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
		String value=log.driver.findElement(By.xpath("//td[contains(text(),'Create Action')]/preceding::td[2]/span")).getAttribute("class");//step 25
		assertTrue(value.contains(Deny));
		System.out.println(" Create Action permission is denied for user Training");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Sales by country']");
		//waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		ui.rightClick("//span[text()='Sales by country']");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[.='Report']/../../li/span[text()='Permissions...']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Permissions for')])[2]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[2]")).isDisplayed());
		
		//=======Effective permission==============================================
		log.driver.findElement(By.xpath(".//button[text()='Effective Permissions...']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(.,'Effective Permissions for')])[1]");
		assertTrue(log.driver.findElement(By.xpath("(//span[contains(.,'Effective Permissions for')])[1]")).isDisplayed());
		System.out.println("effective permissions window displayed");
		test.info("effective permissions window displayed");
		
		assertTrue(log.driver.findElement(By.xpath("(//span[.='Current selected user or group:'])[1]")).isDisplayed());
		System.out.println("current selected group field displayed successfully.");
		test.info("current selected group field displayed successfully.");
		assertTrue(log.driver.findElement(By.xpath("(//span[.='Permissions:'])[1]")).isDisplayed());
		System.out.println("permissions field displayed");
		test.info("permissions field displayed");
		
		log.driver.findElement(By.xpath("(//span[.='Current selected user or group:'])[1]/ancestor::div[3]/div[2]/div[2]/button[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Select User']/../..");
		assertTrue(log.driver.findElement(By.xpath("//span[.='Select User']/../..")).isDisplayed());
		System.out.println("select user window displayed successfully.");
		test.info("select user window displayed successfully.");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Trainingsuser']/preceding::td[1]");
		assertTrue(log.driver.findElement(By.xpath("//td[text()='Trainingsuser']/preceding::td[1]")).isDisplayed());
		System.out.println("Training user is present in the list");
		test.info("Training user is present in the list");
		
		log.driver.findElement(By.xpath("//td[text()='Trainingsuser']/preceding::td[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//td[text()='Trainingsuser']/preceding::td[1]");
		assertEquals(findVisible(By.xpath("//td[text()='Trainingsuser']/preceding::td[1]")).getCssValue("font-weight"), "700");
		System.out.println("Training user is highlighted");
		test.info("Training user is highlighted");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(.,'Effective Permissions for')])[1]");
		assertTrue(log.driver.findElement(By.xpath("(//span[contains(.,'Effective Permissions for')])[1]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[.='Current selected user or group:'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/table/tbody/tr/td[2]");
		assertEquals(log.driver.findElement(By.xpath("(//span[.='Current selected user or group:'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/table/tbody/tr/td[2]")).getText(), "Training");
		System.out.println("Current user is changed to Training");
		test.info("Current user is changed to Training");
		
		String Grant="permission-cw";
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//td[contains(text(),'Full Control')])[1]/../td[1]/span");
		String Getatributevalue=log.driver.findElement(By.xpath("(//td[contains(text(),'Full Control')])[1]/../td[1]/span")).getAttribute("class");
		assertTrue(Getatributevalue.contains(Grant));
		System.out.println("full control is granted for user Training");
		test.info("full control is granted for user Training");
		String Denystat="permission-deny-cw";
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//td[contains(text(),'Create Action')])[1]/../td[1]/span");
		String statvalue=log.driver.findElement(By.xpath("(//td[contains(text(),'Create Action')])[1]/../td[1]/span")).getAttribute("class");
		assertTrue(statvalue.contains(Denystat));
		System.out.println("Create action is denied for user Training displayed correctly");
		test.info("Create action is denied for user Training displayed correctly");
		
		//checking effective permissions for Admin user
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[.='Current selected user or group:'])[1]/ancestor::div[3]/div[2]/div[2]/button[1]");
		log.driver.findElement(By.xpath("(//span[.='Current selected user or group:'])[1]/ancestor::div[3]/div[2]/div[2]/button[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Select User']/../..");
		assertTrue(log.driver.findElement(By.xpath("//span[.='Select User']/../..")).isDisplayed());
		System.out.println("select user window displayed");
		test.info("select user window displayed");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Pre-defined administrator']/preceding::td[1]");
		assertTrue(log.driver.findElement(By.xpath("//td[text()='Pre-defined administrator']/preceding::td[1]")).isDisplayed());
		System.out.println("Admin user is present in the list");
		test.info("Admin user is present in the list");
		
		log.driver.findElement(By.xpath("//td[text()='Pre-defined administrator']/preceding::td[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//td[text()='Pre-defined administrator']/preceding::td[1]");
		assertEquals(log.driver.findElement(By.xpath("//td[text()='Pre-defined administrator']/preceding::td[1]")).getCssValue("font-weight"), "700");
		System.out.println("Admin user is highlighted");
		test.info("Admin user is highlighted");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(.,'Effective Permissions for')])[1]");
		assertTrue(log.driver.findElement(By.xpath("(//span[contains(.,'Effective Permissions for')])[1]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[.='Current selected user or group:'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/table/tbody/tr/td[2]");
		assertEquals(log.driver.findElement(By.xpath("(//span[.='Current selected user or group:'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/table/tbody/tr/td[2]")).getText(), "Admin");
		System.out.println("Current user is changed to Admin");
		test.info("Current user is changed to Admin");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//td[contains(text(),'Full Control')])[1]/../td[1]/span");
		String value3=log.driver.findElement(By.xpath("(//td[contains(text(),'Full Control')])[1]/../td[1]/span")).getAttribute("class");
		assertTrue(value3.contains(Grant));
		System.out.println("full control is granted for user Training");
		test.info("full control is granted for user Training");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//td[contains(text(),'Create Action')])[1]/../td[1]/span");
		String value4=log.driver.findElement(By.xpath("(//td[contains(text(),'Create Action')])[1]/../td[1]/span")).getAttribute("class");
		assertTrue(value4.contains(Grant));
		System.out.println("Create action is granted for user Admin displayed correctly");
		test.info("Create action is granted for user Admin displayed correctly");
		
		log.driver.findElement(By.xpath("//input[@value='Close']")).click();
		
		System.out.println("Testcase 24669 passed");
		
		log.driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
