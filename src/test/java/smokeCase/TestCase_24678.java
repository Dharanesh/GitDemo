package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24678 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Testcase_for_creating_Actionbar_jump_action_Static_Layout_in_Stanadard_Report(String browser) throws Exception
	{
		
		test = extent.createTest("TestCase_24678 : Testcase for creating Action bar (jump action -Static) Layout in Stanadard Report");
		Login log = new Login();
		driver = log.get_Browser(browser);
		driver = log.login(driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[contains(text(),'Training Sales')]","TestCase_24532_jumpaction_Static_Layout",false);
		System.out.println("report created using Training Sales cube");
		test.info("report created using Training Sales cube");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Components']");
		click(By.xpath("//span[text()='Components']"));
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//a[@data-title='Create a New Report Component'])[1]");
		log.driver.findElement(By.xpath("(//a[@data-title='Create a New Report Component'])[1]")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Layout Component...']");
		log.driver.findElement(By.xpath("//span[text()='New Layout Component...']")).click();	
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Layout Component']");
		
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Action Bar']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Action Bar']/../../div/span")).isDisplayed());
		System.out.println("Action Bar layout Available");
		test.info("Action Bar layout Available");
				
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Action Bar']/../../div/span");
		log.driver.findElement(By.xpath("//span[text()='Action Bar']/../../div/span")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Action Bar']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Action Bar']/../../div/span")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Inserts an action bar into the report.']");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Inserts an action bar into the report.']")).isDisplayed(),"message for action bar  displayed correctly");
		
		String button1[]= {"Next >>","Cancel","Help"};
		List<WebElement> button = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		System.out.println("The New layout Component window list button  are :=  ");
		int buttonsize = button.size();
		for(int i =0;i<=buttonsize-1;i++) 
		{
			
			assertEquals(button1[i], button.get(i).getAttribute("value"));
			System.out.println(button.get(i).getAttribute("value"));
			test.info(button.get(i).getAttribute("value"));
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//span[text()='New Layout Component...'])[1]/../following::div[1]/div[1]/div/div[1]/div[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='New Layout Component...'])[1]/../following::div[1]/div[1]/div/div[1]/div[1]/span[1]")).getText(),"Define Actions");
		System.out.println("Define Actions window displayed successfully");
		test.info("Define Actions displayed successfully");
		
		String Dataviewwinbtn1[]= {"New...","Assign...","Remove"};
		List<WebElement> btnlist1 = log.driver.findElements(By.xpath("//div[@id='IDDIVBUTTONS']/div/button[1]"));
		System.out.println("DataView Assignment window list button  are :=  ");
		int buttonlistsize1 = btnlist1.size();
		for(int i =0;i<=buttonlistsize1-3;i++) 
		{
			assertEquals(Dataviewwinbtn1[i], btnlist1.get(i).getText());
			System.out.println(btnlist1.get(i).getText());
			test.info(btnlist1.get(i).getText());
		}
		
		String Dataviewwinbtn[]= {"Next >>","Finish","Cancel","Help"};
		List<WebElement> btnlist = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		int buttonlistsize = btnlist.size();
		for(int i =0;i<=buttonlistsize-1;i++) 
		{
			assertEquals(Dataviewwinbtn[i], btnlist.get(i).getAttribute("value"));
			System.out.println(btnlist.get(i).getAttribute("value"));
			test.info(btnlist.get(i).getAttribute("value"));
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Define Actions later']");
		assertEquals(log.driver.findElement(By.xpath("//*[text()='Define Actions later']/preceding::input[1]")).isSelected(),false);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Define Actions later']");
        log.driver.findElement(By.xpath("//*[text()='Define Actions later']")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Define Actions later']");
		assertEquals(log.driver.findElement(By.xpath("//*[text()='Define Actions later']/preceding::input[1]")).isSelected(),true);
		
		List<WebElement> checkBoxStat =log.driver.findElements(By.xpath("//*[text()='Define Actions']/following::div[4]/div[2]/div/button[1]"));
		for(int i=0;i<=checkBoxStat.size()-1;i++) 
		{
			boolean a =checkBoxStat.get(i).isEnabled();
			assertFalse(a);
			
		}
		System.out.println("After checked the checkbox Define Actions later 4 buttons are disabled");
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Define Actions later']");
        log.driver.findElement(By.xpath("//*[text()='Define Actions later']")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Define Actions later']");
		assertEquals(log.driver.findElement(By.xpath("//*[text()='Define Actions later']/preceding::input[1]")).isSelected(),false);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//*[text()='Define Actions']/following::div[4]/div[2]/div/button[1])[1]");
        log.driver.findElement(By.xpath("(//*[text()='Define Actions']/following::div[4]/div[2]/div/button[1])[1]")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='New Action']");
		System.out.println("Action widnow appear");
		Thread.sleep(500);
		
		List<WebElement>compontType1 = log.driver.findElements(By.xpath("//span[text()='New Action']/following::div[7]/div[2]/div/div[1]/div[2]/div[1]/span[1]"));
		String type1[] = {"Jump Action","Import Job Action","URL Link Action","Filter Action","Export Action","Export Call Action","Animated Action"};
		System.out.println("The  component layout window contains  below list" );
		test.info("The  component layout window contains  below list");
		for(int i = 0;i<compontType1.size();i++) 
		{
			Assert.assertEquals(type1[i], compontType1.get(i).getText());
			System.out.println(compontType1.get(i).getText());
			test.info(compontType1.get(i).getText());
		}	
		Thread.sleep(500);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Jump Action']/ancestor::div[4]")).isDisplayed(), true);
		System.out.println("Jump Action opition is by defalut is selected");
		test.info("Jump Action opition is by defalut is selected");
		
		String Selectiontext  = log.driver.findElement(By.xpath("//span[text()='New Action']/following::div[7]/div[3]")).getText();
		System.out.println(Selectiontext);
		test.info(Selectiontext);
		assertEquals(Selectiontext, "Creates a new jump action to open another report and optionally transfer the current report's dimension context.");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Jump Target']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Jump Target']")).isDisplayed(), true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Static jump to:']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//*[text()='Static jump to:']/preceding::input[1]")).isSelected(), true);
		System.out.println("Static jump to is selected by default");
		test.info("Static jump to is selected by default");
		
		
		ArrayList<String> jump_target = new ArrayList<String>();
		jump_target.add("Static jump to:");
		jump_target.add("Jump back to calling report if report is called by a jump action");
		jump_target.add("Jump to previous report in the folder of this report");
		jump_target.add("Jump to next report in the folder of this report");
		jump_target.add("Dynamic jump to:");
		
		List<WebElement>staitc =  log.driver.findElements(By.xpath("//span[text()='Jump Target']/following::table/tbody/tr/td/label"));
		for (int i =0;i<staitc.size()-2;i++) 
		{
			assertEquals(jump_target.get(i),staitc.get(i).getText());
			System.out.println(staitc.get(i).getText());
		}
		
		List<WebElement> DisabledBtn= log.driver.findElements(By.xpath("//span[text()='Jump Target']/following::div[3]/div[7]/div/div[2]/div[1]/div/button[1]"));
		for (int i =0;i<DisabledBtn.size()-1;i++) 
		{
			System.out.println(DisabledBtn.get(i).getText());
			assertFalse(DisabledBtn.get(i).isEnabled());
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Static jump to:']/following::div[2]/div[2]/button[1]");
		log.driver.findElement(By.xpath("//label[text()='Static jump to:']/following::div[2]/div[2]/button[1]")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[.='Please specify the target report of the jump action']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[.='Please specify the target report of the jump action']")).isDisplayed(),true);
	
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//body[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]");
		log.driver.findElement(By.xpath("//body[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(500);
		String SelectedReport = findVisible(By.xpath("//label[text()='Static jump to:']/following::div[2]/div[1]/div[1]/div[1]/input[1]")).getAttribute("value");
		assertEquals(SelectedReport,"Sales by country");
		
		String JmptrgtBtn[]= {"Next >>","Cancel","Help"};
		List<WebElement> Jmptrgtbtnlist = findAllVisible(By.xpath("//div[@id='buttons']/input"));
		for(int i =0;i<=2;i++) 
		{
			assertEquals(JmptrgtBtn[i], Jmptrgtbtnlist.get(i).getAttribute("value"));
			System.out.println(Jmptrgtbtnlist.get(i).getAttribute("value"));
			test.info(Jmptrgtbtnlist.get(i).getAttribute("value"));
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='Context Transfer']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Context Transfer']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='Action Properties']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Action Properties']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Name and Description']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Jump Action");
		
		String Dataviewwinbtn2[]= {"<< Back","Finish","Cancel","Help"};
		List<WebElement> btnlist2 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		int buttonlistsize2 = btnlist2.size();
		for(int i =0;i<=3;i++) 
		{
			assertEquals(Dataviewwinbtn2[i], btnlist2.get(i).getAttribute("value"));
			System.out.println(btnlist2.get(i).getAttribute("value"));
			test.info(btnlist2.get(i).getAttribute("value"));
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(500);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed())
			{
				log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
				Thread.sleep(500);
			}
		}
		catch(Exception e)
		{
			System.out.println("Finish clicked");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//span[text()='New Layout Component...'])[1]/../following::div[1]/div[1]/div/div[1]/div[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='New Layout Component...'])[1]/../following::div[1]/div[1]/div/div[1]/div[1]/span[1]")).getText(),"Define Actions");
		System.out.println("Define Actions window displayed successfully");
		test.info("Define Actions displayed successfully");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Define Actions']/following::div[6]/div/div[1]/div[1]/input");
		log.driver.findElement(By.xpath("//span[text()='Define Actions']/following::div[6]/div/div[1]/div[1]/input")).click();
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Define Actions']/following::div[6]/div/div[1]/div[1]/input")).isSelected(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Define Actions']/following::div[6]/div/div[1]/div[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Define Actions']/following::div[6]/div/div[1]/div[2]")).getText(),"Jump Action");
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Position in report']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Position in report']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Settings for the layout component']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the layout component']")).isDisplayed(), true);
		System.out.println("Settings for the layout component is Displayed");
		test.info("Settings for the layout component is Displayed");
		
		System.out.println("Settings window texts are:");
		test.info("Settings window texts are:");
		List<WebElement> WindowList = log.driver.findElements(By.xpath("(//table[@class='prg'])[1]/tbody/tr/td[2]/a/span"));
		ArrayList<String>settingMenu  = new ArrayList<String>();
		settingMenu.add("Buttons");
		settingMenu.add("Image");
		settingMenu.add("Button Arrangement");
	
		for (int i =0;i<WindowList.size()-1;i++) 
		{
			assertEquals(WindowList.get(i).getText(),settingMenu.get(i));
			System.out.println(WindowList.get(i).getText());
			test.info(WindowList.get(i).getText());
		}
		
		System.out.println("All the options are Present in settings window");
		test.info("All the options are Present in settings window");
		Thread.sleep(500);
		WebElement WidthMode=log.driver.findElement(By.xpath("(//div[text()='Width Mode'])[1]/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]"));
		Actions act = new Actions(log.driver);
		//act.click(WidthMode).sendKeys("Equal to the widest button", Keys.ENTER).build().perform();
		act.click(WidthMode).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
//		act.click(WidthMode).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(500);
		
		log.driver.findElement(By.xpath("//div[text()='Width Mode']")).click();
		Thread.sleep(500);
		System.out.println(log.driver.findElement(By.xpath("(//div[text()='Width Mode'])[1]/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Width Mode'])[1]/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText(),"Equal to the widest button");
		Thread.sleep(500);
        test.info(" Equal to the widest button is selected for Series");
		
        if(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected())
	    {
	    	waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]"); 
			Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
			test.info("Image Property is Changed ");
	    }
	    else
	    {
	    	waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]"); 
			log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]")).click();
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]"); 
			Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
			test.info("Image Property is Changed ");
	    }
		
//    	WebElement Arrangement=findVisible(By.xpath("(//div[text()='Arrangement'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]"));

		//act.click(Arrangement).sendKeys("Arrange vertically", Keys.ENTER).build().perform();

		try {
			act.click(findVisible(By.xpath("(//div[text()='Arrangement'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		}
		catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}

		implicitWaitSeconds(2);
		
		Assert.assertEquals(findVisible(By.xpath("(//div[text()='Arrangement'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText(),"Arrange vertically");
		
		clickableClick(By.xpath("//div[text()='Arrangement']"));
		System.out.println(log.driver.findElement(By.xpath("(//div[text()='Arrangement'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Arrangement'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText(),"Arrange vertically");
		Thread.sleep(500);
        test.info("Arrange vertically is selected for Series");
		
        String Dataviewwinbtn11[]= {"<< Back","Next >>","Finish","Cancel","Help"};
		List<WebElement> btnlist11 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		int buttonlistsize11 = btnlist11.size();
		for(int i =0;i<=buttonlistsize11-1;i++) 
		{
			assertEquals(Dataviewwinbtn11[i], btnlist11.get(i).getAttribute("value"));
			System.out.println(btnlist11.get(i).getAttribute("value"));
			test.info(btnlist11.get(i).getAttribute("value"));
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Name and Description']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Action Bar Layout");
		
		String finishwindow[]= {"<< Back","Finish","Cancel","Help"};
		List<WebElement> finishwindwbtnlist2 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		int buttonlistfnshwindw= finishwindwbtnlist2.size();
		for(int i =0;i<=buttonlistfnshwindw-1;i++) 
		{
			assertEquals(finishwindow[i], finishwindwbtnlist2.get(i).getAttribute("value"));
			System.out.println(finishwindwbtnlist2.get(i).getAttribute("value"));
			test.info(finishwindwbtnlist2.get(i).getAttribute("value"));
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(500);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed())
			{
				log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
				Thread.sleep(500);
			}
		}catch(Exception e)
		{
			
		}
//
//
//		 //Save as the report:=============
//		 log.driver.findElement(By.xpath("(//span[text()='Save'])[2]/following::span[1]")).click();
//		 Thread.sleep(500);
//		 //Click Down and do Save As:====================
//		 log.driver.findElement(By.xpath("(//span[text()='Save As'])[2]")).click();
//		 Thread.sleep(500);
//		 Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Save report']")).isDisplayed());
//		 Thread.sleep(500);
//		 System.out.println("Save Report as window is displaying now.");
//
//		//click folder:========
//		log.driver.findElement(By.xpath("//div[text()='All Reports']")).click();
//		Thread.sleep(500);
//		//Click Ok Button:============
//		log.driver.findElement(By.xpath("//input[@value='OK']")).click();
//		Thread.sleep(500);
//
//		try
//		{
//			log.driver.findElement(By.xpath("//span[contains(text(),'A report named')]")).isDisplayed();
//			log.driver.findElement(By.xpath("//input[@value='OK']")).click();
//			System.out.println("popup appeared");
//		}
//		catch(Exception e)
//		{
//		System.out.println("saves as completed without popup");
//		Thread.sleep(500);
//		}
//		Thread.sleep(500);
//		//===================================
//		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[@id='tab_close_btn']");
//		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
//		Thread.sleep(500);


		waitForVisibilityOfElement(By.xpath("//button[@data-title='Jump Action']"));
		clickableClick(By.xpath("//button[@data-title='Jump Action']"));

		Assert.assertTrue(findVisibleBool(By.xpath("//button[@data-title='Jump Action']")));
		Thread.sleep(500);
		
		ArrayList<String> ActionContextClickbtn = new ArrayList<String>();
		ActionContextClickbtn.add("Jump Action");
		ActionContextClickbtn.add("New Action...");
		ActionContextClickbtn.add("Edit Action...");
		ActionContextClickbtn.add("Action Properties...");
		ActionContextClickbtn.add("Action Bar Properties...");
		ActionContextClickbtn.add("Information...");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//font[text()='Jump Action']");
		ui.rightClick("//font[text()='Jump Action']");
		Thread.sleep(500);

		List<WebElement>JumpAction=log.driver.findElements(By.xpath("//span[text()='Jump Action']/ancestor::ul[1]/li/span[1]"));
		for (int i =0;i<JumpAction.size()-1;i++) 
		{
            assertEquals(JumpAction.get(i).getText(),ActionContextClickbtn.get(i));
			System.out.println(JumpAction.get(i).getText());
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Action Bar Properties...']");
		log.driver.findElement(By.xpath("//*[text()='Action Bar Properties...']")).click();
		Thread.sleep(500);
		
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//span[contains(text(),'Properties of')]/../..");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Properties of')]/../..")).isDisplayed(), true);
		
		log.driver.findElement(By.xpath("//div[text()='Width Mode']")).click();
		Thread.sleep(500);
		System.out.println(log.driver.findElement(By.xpath("(//div[text()='Width Mode'])[1]/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Width Mode'])[1]/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText(),"Equal to the widest button");
		Thread.sleep(500);
        test.info(" Equal to the widest button is selected for Series");
		
        log.driver.findElement(By.xpath("//div[text()='Arrangement']")).click();
		System.out.println(log.driver.findElement(By.xpath("(//div[text()='Arrangement'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Arrangement'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText(),"Arrange vertically");
		Thread.sleep(500);
        test.info("Arrange vertically is selected for Series");
		
        waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]"); 
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		test.info("Image Property is Changed ");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(500);
		
//		log.driver.findElement(By.xpath("//span[text()='Navigator']")).click();
//		Thread.sleep(500);
//		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
//		Thread.sleep(500);
//
//		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='New ReportTestCase_24532_jumpaction_Static_Layout'])[1]/ancestor::div[1]/span[1]");
//		log.driver.findElement(By.xpath("(//span[text()='New ReportTestCase_24532_jumpaction_Static_Layout'])[1]/ancestor::div[1]/span[1]")).click();
//		Thread.sleep(500);
//		act.contextClick(log.driver.findElement(By.xpath("(//span[text()='New ReportTestCase_24532_jumpaction_Static_Layout'])[1]"))).perform();
//		Thread.sleep(500);
//		log.driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
//		Thread.sleep(500);
//		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
//		Thread.sleep(500);
//
//		log.driver.close();
		
		
		
}
}
