package regression;

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

public class TestCase_28827 extends TestUtils
{

	@Test	
	@Parameters("browser")

	public void TestCase_for_Cockpit_Navigator_functionality_Folder_Permissions(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24483: TestCase for Cockpit Navigator functionality - Folder Permissions");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Departments']/ancestor::div[1]/span[2]");
		log.driver.findElement(By.xpath("//span[text()='Departments']/ancestor::div[1]/span[2]")).click();
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Departments']/ancestor::div[1]/span[2]");
		assertTrue(log.driver.findElement(By.xpath(log.getData("DepartmentCB"))).isSelected());
	
	    //Right click on department folder
		ui.rightClick(log.getData("Department"));
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("FolderHeader"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("FolderHeader"))).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Folder_Contextmenu_List"));
		List<WebElement> report_contextmenu_options =log.driver.findElements(By.xpath(log.getData("Folder_Contextmenu_List")));
		ArrayList<String > contextmenu_btn = new ArrayList<String>();
		contextmenu_btn.add("Open");
		contextmenu_btn.add("New Folder...");
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
		
		System.out.println("Folder context menu options are : ");
		Thread.sleep(5000);
		for (WebElement we : report_contextmenu_options)
		{
			report_contextmenu_options.contains(contextmenu_btn);
			System.out.println(we.getText());
			test.info(we.getText());
		}

		log.driver.findElement(By.xpath("//span[.='Folder']/../../li/span[text()='Permissions...']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Permissions for')])[2]");
		
		String Header=log.driver.findElement(By.xpath("(//span[contains(.,'Permissions for')])[1]")).getText();
		assertEquals(Header, "Permissions for 'Departments'");
		System.out.println("Permissions for folder dialog window displayed");
		test.info("Permissions for folder dialog window displayed");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("SelectedObjects"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("SelectedObjects"))).isDisplayed());
		
		//Verify selected folder name
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("NamePermissionvalueXpath"));
		String foldername=log.driver.findElement(By.xpath(log.getData("NamePermissionvalueXpath"))).getText();
		assertEquals(foldername,"Departments");
		System.out.println("Selected Folder========" +foldername);
		test.info("Selected Folder======" +foldername);
		
		//validate the owner of trh folder
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("OwnerPermissionvalueXpath"));
		String folderowner=log.driver.findElement(By.xpath(log.getData("OwnerPermissionvalueXpath"))).getText();
		assertEquals(folderowner,"Admin");
		System.out.println("Selected Owner========" +folderowner);
		test.info("Selected Owner==========" +folderowner);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(.,'Permission')]/following::button");
	    List<WebElement> action_buttons =log.driver.findElements(By.xpath("//span[contains(.,'Permission')]/following::button"));
		System.out.println("Permission for sales by country report window have below mentioned buttons");
		ArrayList<String > action_btn = new ArrayList<String>();
		action_btn.add("Take Ownership");
		action_btn.add("Set Ownership...");
		action_btn.add("Effective Permissions...");
		action_btn.add("Add Permission...");
		action_btn.add("Add Role...");
		action_btn.add("Remove");
			
		for (int  i=0;i<action_buttons.size()-1;i++) 
		{
		String btns = action_buttons.get(i).getText();
		Assert.assertEquals(btns, action_btn.get(i)," All Buttons are available");
		System.out.println(btns);
		}

		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("EffectivePermission"));
		log.driver.findElement(By.xpath(log.getData("EffectivePermission"))).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("EffectivePermissionwindow"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("EffectivePermissionwindow"))).isDisplayed());
		System.out.println("effective permissions window displayed successfully.");
		test.info("effective permissions window displayed successfully.");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("current_selected_user_TextXpath"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("current_selected_user_TextXpath"))).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//tr[@class='lvitem'])[1]/td[2]");
		String SelectedUser=log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[2]")).getText();
		assertEquals(SelectedUser,"Admin");
		System.out.println("Current Selected User========" +SelectedUser);
		test.info("Current Selected User==========" +SelectedUser);
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("PermissionsField_xpath"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("PermissionsField_xpath"))).isDisplayed());
		System.out.println("permissions field displayed successfully.");
		test.info("permissions field displayed successfully.");		
		
		//List of permission
		System.out.println("List Of permission available:");	
	    test.info("List Of permission available:");
		List<WebElement>  ListOfPermission=log.driver.findElements(By.xpath("(//table[@class='lv '])[2]/tbody/tr/td[2]"));
		for (int  i=0;i<=ListOfPermission.size()-1;i++) 
		{
			String Val=ListOfPermission.get(i).getText();
		    System.out.println(Val);	
		    test.info(Val);
		    
		}
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[.='Current selected user or group:'])[1]/ancestor::div[3]/div[2]//button");
		log.driver.findElement(By.xpath("(//span[.='Current selected user or group:'])[1]/ancestor::div[3]/div[2]//button")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select User']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Select User']")).isDisplayed());
		System.out.println("select user window displayed successfully.");
		test.info("select user window displayed successfully.");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Training']/ancestor::tr[1]/td[.='Trainingsuser']");
		assertTrue(log.driver.findElement(By.xpath("//td[text()='Training']/ancestor::tr[1]/td[.='Trainingsuser']")).isDisplayed());
		System.out.println("Training user is present in the list");
		test.info("Training user is present in the list");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//td[text()='Training']/ancestor::tr[1]/td[.='Trainingsuser']");
		log.driver.findElement(By.xpath("//td[text()='Training']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//td[text()='Training']");
		Thread.sleep(2000);
		
		assertEquals(log.driver.findElement(By.xpath("//td[text()='Training']/ancestor::tr[1]/td[.='Trainingsuser']")).getCssValue("font-weight"), "700");
		System.out.println("Training user is highlighted");
		test.info("Training user is highlighted");
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
	    log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
	    Thread.sleep(2000);
	    waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("EffectivePermissionwindow"));
	    assertTrue(log.driver.findElement(By.xpath(log.getData("EffectivePermissionwindow"))).isDisplayed());
	   
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"(//tr[@class='lvitem'])[1]/td[2]");
		String SelectedUser1=log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[2]")).getText();
		assertEquals(SelectedUser1,"Training");
		System.out.println("Current Selected User========" +SelectedUser1);
		test.info("Current Selected User==========" +SelectedUser1);
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Close']");
	    log.driver.findElement(By.xpath("//input[@value='Close']")).click();
	    Thread.sleep(2000);
	   
	    waits.waitUntil_Elmentis_visibilityOfElement(10, "Set Ownership...']");
	    log.driver.findElement(By.xpath(".//button[text()='Set Ownership...']")).click();
	    Thread.sleep(2000);
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select User']");
	   assertTrue(log.driver.findElement(By.xpath("//span[text()='Select User']")).isDisplayed());
	   System.out.println("select user window displayed successfully.");
	   test.info("select user window displayed successfully.");	
	
	   waits.waitUntil_Elmentis_visibilityOfElement(10, "(//td[text()='Training'])[1]");
	   log.driver.findElement(By.xpath("(//td[text()='Training'])[1]")).click();
	   Thread.sleep(1000);
	   waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
	   log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
	   Thread.sleep(2000);
		
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
		Assert.assertEquals(log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[2]")).getText(),"Departments");
		System.out.println("Name is Departments");
		test.info("Name is Departments");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//tr[@class='lvitem'])[1]/td[3]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[3]")).getText(),"Trainings");
		System.out.println(log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[3]")).getText());
		System.out.println("Owner is Training");
		test.info("Owner is Training");
		
		log.driver.findElement(By.xpath(".//button[text()='Take Ownership']")).click();//step 9
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Taking ownership cannot be undone.']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Taking ownership cannot be undone.']")).isDisplayed(), "Popup displayed");
		List<WebElement> warng_msg_btns1 = log.driver.findElements(By.xpath("//span[text()='Taking ownership cannot be undone.']/ancestor::div[4]/div[2]/div/input"));
		Assert.assertEquals(warng_msg_btns1.get(0).getAttribute("value"),"Yes");
		Assert.assertEquals(warng_msg_btns1.get(1).getAttribute("value"),"No");
		
		
		warng_msg_btns1.get(0).click();//step 10
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[contains(.,'Permissions for')])[2]");
		assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[2]")).isDisplayed());
		System.out.println("Permission for sales  by country window displayed.");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//tr[@class='lvitem'])[1]/td[3]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[3]")).getText(),"Admin");
		System.out.println(log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[3]")).getText());
		System.out.println("Owner is Admin");
		
		log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Permission']/../..");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='New Permission']/../..")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Available rights:']")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Available users and groups:']")).isDisplayed());
		
		assertTrue(log.driver.findElement(By.xpath("//label[.='Grant']/../../td")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//label[.='Deny']/../../td")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//label[.='Grant']/../../td/input")).isSelected());
		Thread.sleep(5000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='cancelbutton']");
	    log.driver.findElement(By.xpath("//input[@id='cancelbutton']")).click();
	    Thread.sleep(2000);
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Add Role...']");
	    log.driver.findElement(By.xpath("//button[text()='Add Role...']")).click();
	    Thread.sleep(2000);
	    assertTrue(log.driver.findElement(By.xpath("//span[.='Select Role']")).isDisplayed());
		System.out.println("Add Role window displayed");
		test.info("Add Role window displayed");
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//a[.='Roles']/ancestor::tr[1]/th[1]");
		log.driver.findElement(By.xpath("//a[.='Roles']/ancestor::tr[1]/th[1]")).click();
		assertTrue(log.driver.findElement(By.xpath("//a[.='Roles']/ancestor::tr[1]/th[1]/input")).isSelected());
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
	    
		boolean stat=log.driver.findElement(By.xpath("//label[text()='Disable inheritance of parent roles and permissions']/preceding::input[1]")).isSelected();
		if(stat)
		{
			System.out.println("Selected");
		}
		else
		{
			log.driver.findElement(By.xpath("//label[text()='Disable inheritance of parent roles and permissions']")).click();
			System.out.println("Disable inheritance of parent roles and permissions Selected");
		}
		Thread.sleep(2000);
		
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
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Remove']");
		log.driver.findElement(By.xpath("//button[text()='Remove']")).click();
		Thread.sleep(2000);
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
	    
	    System.out.println("Roled were removed");
		test.info("Roled were removed");
		
		log.driver.close();
		
	}
}
