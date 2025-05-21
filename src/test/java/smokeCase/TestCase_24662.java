package smokeCase;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24662 extends TestUtils
{	@Test	
	@Parameters("browser")
	//Test case for  denying Action bar creating for training user for sale by country report
	public void Testcase_Denying_Action_Bar_Creating_For_TrainingUser_For_Sale_By_Country_Report(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24662 for denying Action bar creating for training user for sale by country report");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);


		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		
		waitForVisibilityOfElement(By.xpath("//span[@title='Show Menu']"));
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[@title='Show Menu']")).isDisplayed());
		waitForVisibilityOfElement(By.xpath("//span[@title='Show Menu']"));
		log.driver.findElement(By.xpath("//span[@title='Show Menu']")).click();
		Thread.sleep(1000);
		
		waitForVisibilityOfElement(By.xpath("//div[text()='Repository']"));
		Assert.assertTrue(log.driver.findElement(By.xpath("//div[text()='Repository']")).isDisplayed());
		waitForVisibilityOfElement(By.xpath("//div[text()='Repository']"));
		log.driver.findElement(By.xpath("//div[text()='Repository']")).click();
		Thread.sleep(1000);
		
		waitForVisibilityOfElement(By.xpath("//span[text()='Repository Settings']"));
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Repository Settings']")).isDisplayed());
		
		waitForVisibilityOfElement(By.xpath("//a[text()='Global Permissions...']"));
		Assert.assertTrue(log.driver.findElement(By.xpath("//a[text()='Global Permissions...']")).isDisplayed());
		waitForVisibilityOfElement(By.xpath("//a[text()='Global Permissions...']"));
		log.driver.findElement(By.xpath("//a[text()='Global Permissions...']")).click();
		Thread.sleep(1000);
		
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).click();
		Thread.sleep(1000);
		
		waitForVisibilityOfElement(By.xpath("//span[text()='New Permission']/../.."));
		assertTrue(log.driver.findElement(By.xpath("//span[text()='New Permission']/../..")).isDisplayed());
		
		log.driver.findElement(By.xpath("//td[contains(text(),'Full Control')]/preceding::td[2]")).click();
		Thread.sleep(200);
		
		waitForVisibilityOfElement(By.xpath("//td[text()='Training User']/../td[1]"));
		log.driver.findElement(By.xpath("//td[text()='Training User']/../td[1]")).click();
		Thread.sleep(200);
		
		waitForVisibilityOfElement(By.xpath("(//input[@id='okbutton'])[1]"));
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		//open sales by country 
		waitForVisibilityOfElement(By.xpath("//span[text()='Sales by country']"));
		//waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		ui.rightClick("//span[text()='Sales by country']");
		Thread.sleep(2000);
        waitForVisibilityOfElement(By.xpath("(//span[text()='Report'])[3]"));
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Report'])[3]")).isDisplayed(),true);
		Thread.sleep(100);
	
		waitForVisibilityOfElement(By.xpath("(//span[text()='Report'])[3]/../.."));
		List<WebElement> report_contextmenu_options =log.driver.findElements(By.xpath("(//span[text()='Report'])[3]/../.."));
		ArrayList<String > contextmenu_btn = new ArrayList<String>();
		contextmenu_btn.add("Open");
		contextmenu_btn.add("Add to Favorite Folder");
		contextmenu_btn.add("Duplicate");
		contextmenu_btn.add("Rename");
		contextmenu_btn.add("Delete");
		contextmenu_btn.add("Move...");
		contextmenu_btn.add("Export...");
		contextmenu_btn.add("Send to...");
		contextmenu_btn.add("Language Terms...");
		contextmenu_btn.add("Description...");
		contextmenu_btn.add("Properties...");
		contextmenu_btn.add("Permissions...");
		System.out.println("Report context menu options are : ");
		Thread.sleep(5000);
		for (WebElement we : report_contextmenu_options)
		{
			report_contextmenu_options.contains(contextmenu_btn);
			System.out.println(we.getText());
			test.info(we.getText());
		}
//		report_contextmenu_options.get(report_contextmenu_options.size() - 1).click();
		log.driver.findElement(By.xpath("//span[.='Report']/../../li/span[text()='Permissions...']")).click();
		waitForVisibilityOfElement(By.xpath("(//div[contains(.,'Permissions for')])[2]"));
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
			
		for (int  i=0;i<action_btn.size()-1;i++)
		{
		String btns = action_buttons.get(i).getText();
		Assert.assertEquals(btns, action_btn.get(i));
		System.out.println(btns);
		}
		
		log.driver.findElement(By.xpath(".//button[text()='Take Ownership']")).click();//step 9
		waitForVisibilityOfElement(By.xpath("//span[text()='Taking ownership cannot be undone.']"));
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Taking ownership cannot be undone.']")).isDisplayed(), "Popup displayed");
		List<WebElement> warng_msg_btns = log.driver.findElements(By.xpath("//span[text()='Taking ownership cannot be undone.']/ancestor::div[4]/div[2]/div/input"));
		Assert.assertEquals(warng_msg_btns.get(0).getAttribute("value"),"Yes");
		Assert.assertEquals(warng_msg_btns.get(1).getAttribute("value"),"No");
		
		
		warng_msg_btns.get(0).click();//step 10
		waitForVisibilityOfElement(By.xpath("(//div[contains(.,'Permissions for')])[2]"));
		assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[2]")).isDisplayed());
		System.out.println("Permission for sales  by country window displayed.");
		
		waitForVisibilityOfElement(By.xpath("(//tr[@class='lvitem'])[1]/td[2]"));
		Assert.assertEquals(log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[2]")).getText(),"Sales by country");
		System.out.println("Name is sales by country");
		waitForVisibilityOfElement(By.xpath("(//tr[@class='lvitem'])[1]/td[3]"));
		Assert.assertEquals(log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[3]")).getText(),"Admin");
		System.out.println(log.driver.findElement(By.xpath("(//tr[@class='lvitem'])[1]/td[3]")).getText());
		System.out.println("Owner is Admin");
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
		waitForVisibilityOfElement(By.xpath("//span[text()='New Permission']/../.."));
		assertTrue(log.driver.findElement(By.xpath("//span[text()='New Permission']/../..")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Available rights:']")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Available users and groups:']")).isDisplayed());
		
		assertTrue(log.driver.findElement(By.xpath("//label[.='Grant']/../../td")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//label[.='Deny']/../../td")).isDisplayed());
		assertTrue(log.driver.findElement(By.xpath("//label[.='Grant']/../../td/input")).isSelected());
		Thread.sleep(5000);
		
		log.driver.findElement(By.xpath("//td[contains(text(),'Full Control')]/preceding::td[2]")).click();
		Thread.sleep(200);
		waitForVisibilityOfElement(By.xpath("//td[contains(text(),'Full Control')]/preceding::td[2]"));
		assertTrue(log.driver.findElement(By.xpath("//td[contains(text(),'Full Control')]/preceding::td[2]/input")).isSelected());
		
		waitForVisibilityOfElement(By.xpath("(//td[text()='Training'])[1]/../td[1]"));
		log.driver.findElement(By.xpath("(//td[text()='Training'])[1]/../td[1]")).click();
		Thread.sleep(200);
		waitForVisibilityOfElement(By.xpath("(//td[text()='Training'])[1]/../td[1]"));
		assertTrue(log.driver.findElement(By.xpath("(//td[text()='Training'])[1]/../td[1]/input")).isSelected());
		
		waitForVisibilityOfElement(By.xpath("(//input[@id='okbutton'])[1]"));
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		waitForVisibilityOfElement(By.xpath("(//div[contains(.,'Permissions for')])[2]"));
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[2]")).isDisplayed());
		
		waitForVisibilityOfElement(By.xpath("//button[text()='Add Permission...']"));
		log.driver.findElement(By.xpath("//button[text()='Add Permission...']")).click();
		Thread.sleep(2000);//step 22
		waitForVisibilityOfElement(By.xpath("//span[text()='New Permission']/../.."));
		assertTrue(log.driver.findElement(By.xpath("//span[text()='New Permission']/../..")).isDisplayed());
		
		log.driver.findElement(By.xpath("//td[contains(text(),'Create Action')]/preceding::td[2]")).click();
		Thread.sleep(2000);//step 23
		waitForVisibilityOfElement(By.xpath("//td[contains(text(),'Create Action')]/preceding::td[2]"));
		assertTrue(log.driver.findElement(By.xpath("//td[contains(text(),'Create Action')]/preceding::td[2]/input")).isSelected());
		
		waitForVisibilityOfElement(By.xpath("(//td[text()='Training'])[1]/../td[1]"));
		log.driver.findElement(By.xpath("(//td[text()='Training'])[1]/../td[1]")).click();
		Thread.sleep(200);
		waitForVisibilityOfElement(By.xpath("(//td[text()='Training'])[1]/../td[1]"));
		assertTrue(log.driver.findElement(By.xpath("(//td[text()='Training'])[1]/../td[1]/input")).isSelected());//24
		
		log.driver.findElement(By.xpath("//label[.='Deny']/../../td")).click();//step 25
		waitForVisibilityOfElement(By.xpath("//label[.='Deny']/../../td"));
		assertTrue(log.driver.findElement(By.xpath("//label[.='Deny']/../../td/input")).isSelected());
		
		waitForVisibilityOfElement(By.xpath("(//input[@id='okbutton'])[1]"));
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		waitForVisibilityOfElement(By.xpath("(//div[contains(.,'Permissions for')])[2]"));
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[contains(.,'Permissions for')])[2]")).isDisplayed());
	
		String Deny="deny";
		String value=log.driver.findElement(By.xpath("//td[contains(text(),'Create Action')]/preceding::td[2]/span")).getAttribute("class");//step 25
		assertTrue(value.contains(Deny));
		System.out.println(" Create Action permission is denied for user Training");
		
		waitForVisibilityOfElement(By.xpath("//input[@id='okbutton']"));
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		//reconnecting as Training user
		waitForVisibilityOfElement(By.xpath("//span[@title='Show Menu']"));
		Assert.assertTrue(log.driver.findElement(By.xpath("//span[@title='Show Menu']")).isDisplayed());
		waitForVisibilityOfElement(By.xpath("//span[@title='Show Menu']"));
		log.driver.findElement(By.xpath("//span[@title='Show Menu']")).click();
		Thread.sleep(1000);
		
		waitForVisibilityOfElement(By.xpath("//div[text()='Connect to Server']"));
		Assert.assertTrue(log.driver.findElement(By.xpath("//div[text()='Connect to Server']")).isDisplayed());
		waitForVisibilityOfElement(By.xpath("//div[text()='Connect to Server']"));
		log.driver.findElement(By.xpath("//div[text()='Connect to Server']")).click();
		Thread.sleep(1000);
		
		waitForVisibilityOfElement(By.xpath("//span[text()='Log On C8 Server']"));
	    assertTrue(log.driver.findElement(By.xpath("//span[text()='Log On C8 Server']")).isDisplayed());
		
	    log.driver.findElement(By.xpath("//span[text()='User Name:']/following::div[3]/input")).sendKeys("Training");
	    waitForVisibilityOfElement(By.xpath("//input[@placeholder='Enter or Select Sever...']"));
	    log.driver.findElement(By.xpath("//input[@placeholder='Enter or Select Sever...']")).sendKeys("localhost:10901");
	    log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		
		waitForVisibilityOfElement(By.xpath( "//span[text()='Select Repository']"));

		waitForVisibilityOfElement(By.xpath( "//span[text()='C8 Cockpit PROFESSIONAL']"));
		Thread.sleep(200);
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).isDisplayed(), true);
		log.driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).click();
		
		waitForVisibilityOfElement(By.xpath( "(//input[@id='okbutton'])[1]"));
		Thread.sleep(200);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[@class='k-link' and text()='Welcome']/span")).click();
		Thread.sleep(2000);
		System.out.println("Login Sucessfully");
		//open sales by country 
	    waitForVisibilityOfElement(By.xpath("//span[text()='Sales by country']"));
	    log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
		Thread.sleep(3000);
		waitForVisibilityOfElement(By.xpath("(//span[text()='Sales by country'])[2]"));
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[2]")).isDisplayed(),true);
		Thread.sleep(1000);
		
		
		log.driver.findElement(By.xpath("//span[text()='Components']")).click();
		Thread.sleep(1000);
		waitForVisibilityOfElement(By.xpath("(//a[@data-title='Create a New Report Component'])[1]"));
		log.driver.findElement(By.xpath("(//a[@data-title='Create a New Report Component'])[1]")).click();
		Thread.sleep(100);
		waitForVisibilityOfElement(By.xpath("//span[text()='New Layout Component...']"));
		log.driver.findElement(By.xpath("//span[text()='New Layout Component...']")).click();	
		Thread.sleep(100);
		waitForVisibilityOfElement(By.xpath("//span[text()='New Layout Component']"));
		
       //Verify list of options  displayed 
		List<WebElement>compontType = log.driver.findElements(By.xpath("//div[text()='Please select a layout component type']/../div[2]/div/div/div[2]/div[1]/span[1]"));
		int typesize = compontType.size();
		String type[] = {"Title","Image","Table","Chart","Filter Bar","Selection Bar","Action Bar","ABC Table","ABC Chart","Horizontal Waterfall Chart","Vertical Waterfall Chart","Bubble Chart","Gauge","Map", "OS Map"};
		System.out.println("The  component layout window contains  below list" );
		test.info("The  component layout window contains  below list");
		for(int i = 0;i<compontType.size();i++) 
		{
			Assert.assertEquals(type[i], compontType.get(i).getText());
			System.out.println(compontType.get(i).getText());	
		}
		waitForVisibilityOfElement(By.xpath("//span[text()='Action Bar']/../../div/span"));
		log.driver.findElement(By.xpath("//span[text()='Action Bar']/../../div/span")).click();
		waitForVisibilityOfElement(By.xpath("//span[text()='Action Bar']/../../div/span"));
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Action Bar']/../../div/span")).isDisplayed());
		waitForVisibilityOfElement(By.xpath("//div[text()='Inserts an action bar into the report.']"));
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Inserts an action bar into the report.']")).isDisplayed());
		
		waitForVisibilityOfElement(By.xpath("//input[@value='Next >>']"));
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		if(log.driver.findElement(By.xpath("//span[text()='Create or assign actions for the Action Bar']")).isDisplayed()){
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='Create or assign actions for the Action Bar']");
		System.out.println("next got clicked");
		
		}else
		{
			Thread.sleep(2000);
			log.driver.findElement(By.xpath("//span[text()='Create or assign actions for the Action Bar']")).click();
			waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='Create or assign actions for the Action Bar']");
			assertEquals(log.driver.findElement(By.xpath("//span[text()='Create or assign actions for the Action Bar']")).isDisplayed(),true);
			System.out.println("Settings for components window displayed correctly");
		}
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='Define Actions']");
		Thread.sleep(2000);
		assertEquals(log.driver.findElement(By.xpath("//span[text()='Define Actions']")).isDisplayed(),true);
		System.out.println("Define Actions window displayed correctly");
		
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//button[text()='Assign...']");
		
		try{
		assertTrue(log.driver.findElement(By.xpath("//button[text()='New...']")).isDisplayed());
		System.out.println(" Permission for Creating action is NOT denied for user Training");
		test.info(" Permission for Creating action is NOT denied for user Training");
		}
		catch(Exception e){
		System.out.println(" Permission for Creating action is denied for user Training");
		test.info(" Permission for Creating action is denied for user Training");
		}
		log.driver.findElement(By.xpath("//input[@value='Cancel']")).click();
		Thread.sleep(1000);
		waitForVisibilityOfElement(By.xpath("(//span[text()='Sales by country'])[2]"));
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Sales by country'])[2]")).isDisplayed(),true);
		Thread.sleep(100);
		
		System.out.println("reverted back to main window");
		
		log.driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
