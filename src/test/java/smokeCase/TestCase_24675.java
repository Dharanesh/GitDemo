package smokeCase;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.Login;
import event.Utils;
import event.Waits;
import junit.framework.Assert;

public class TestCase_24675 extends TestUtils
{

  @Test
  @Parameters("browser")
  public void Testcase_for_creating_Bubble_ChartLayout_in_standard_report(String browser) throws Exception  
  {
	    test =extent.createTest("TestCase_24675 : Testcase for creating Bubble Chart Layout in standard report");
	    Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);

		Waits waits = new Waits(log.driver);
		Utils Utils = new Utils(log.driver);
	  
	  	System.out.println("Test Case 24675: Testcase for creating Bubble Chart Layout in standard report===================");
	  	
	  	log.createCubeReport("//div[text()='Sales']","Testcase_24675",false);
		System.out.println("report created using Training Sales cube");
		test.info("report created using Training Sales cube");

		waitForVisibilityOfElement(By.xpath("//span[text()='Components']"));

		//		Create Layout compontent
		click(By.xpath("//span[text()='Components']"));
		click(By.xpath("(//a[@data-title='Create a New Report Component'])[1]"));
		click(By.xpath("//span[text()='New Layout Component...']"));

		waitForClickableElement(By.xpath("//input[@value='Next >>']"));
		//Find List of Layout Components:==========================

		waits.waituUnitil_Element_Clickable(20,"//input[@value='Next >>']");
		List<WebElement>reports=log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
		ArrayList<String>List = new ArrayList();
		List.add("Title");
		List.add("Image");
		List.add("Table");
		List.add("Chart");
		List.add("Filter Bar");
		List.add("Selection Bar");
		List.add("Action Bar");
		List.add("ABC Table");
		List.add("ABC Chart");
		List.add("Horizontal Waterfall Chart");
		List.add("Vertical Waterfall Chart");
		List.add("Bubble Chart");
		List.add("Gauge");
		List.add("Map");
		List.add("OS Map");

		for(int i=0;i<reports.size()-1;i++)
		{
		  org.testng.Assert.assertEquals(reports.get(i).getText(),List.get(i));
		}

		System.out.println("All Report Layout Options are available.");
		Thread.sleep(2000);
		
		//Check Default Text on Layout:============
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Inserts a title into the report.']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Default Layout Text is displaying now.");
		
		//Select Bubble Chart Layout and proceed:==============
		log.driver.findElement(By.xpath("//span[text()='Bubble Chart']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//div[text()='Inserts a bubble chart into the report.']")).isDisplayed());
		Thread.sleep(2000);
		System.out.println("Bubble Chart Layout Text is displaying now.");
		
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
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//span[text()='New Layout Component...'])[1]/../following::div[1]/div[1]/div/div[1]/div[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='New Layout Component...'])[1]/../following::div[1]/div[1]/div/div[1]/div[1]/span[1]")).getText(),"DataView Assignment");
		System.out.println("DataView Assignment window displayed successfully");
		test.info("DataView Assignment displayed successfully");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='DataView Assignment']/following::div[6]/div/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='DataView Assignment']/following::div[6]/div/div[1]/div/input")).isSelected(),false);
		log.driver.findElement(By.xpath("//span[text()='DataView Assignment']/following::div[6]/div/div[1]/div/input")).click();
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='DataView Assignment']/following::div[6]/div/div[1]/div/input")).isSelected(),true);
		Thread.sleep(2000);
		
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Position in report']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Position in report']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Settings for the layout component']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the layout component']")).isDisplayed(), true);
		System.out.println("Settings for the layout component is Displayed");
		test.info("Settings for the layout component is Displayed");
		
		System.out.println("Settings window texts are:");
		test.info("Settings window texts are:");
		List<WebElement> WindowList = log.driver.findElements(By.xpath("(//table[@class='prg'])[1]/tbody/tr/td[2]/a/span"));
		ArrayList<String>settingMenu  = new ArrayList<String>();
		settingMenu.add("Chart Type");
		settingMenu.add("Chart Area (3D Settings)");
		settingMenu.add("Datapoint Labels");
		settingMenu.add("Datapoint Markers");
	
		for (int i =0;i<WindowList.size()-1;i++) 
		{
			assertEquals(WindowList.get(i).getText(),settingMenu.get(i));
			System.out.println(WindowList.get(i).getText());
			test.info(WindowList.get(i).getText());
		}
		
		System.out.println("All the options are Present in settings window");
		test.info("All the options are Present in settings window");

		//Chart type
		if(log.driver.findElement(By.xpath("(//span[text()='Chart Type'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Chart Type'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Chart Type'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Chart type is expanded");
			test.info("Chart type is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Chart Type'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Chart Type'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
		}
		else
		{
			System.out.println("Chart type is already expanded");
			test.info("Chart type is already expanded");
		}

	  Actions act = new Actions(driver);

//
//	  	Select row = new Select(find(By.xpath("//span[text()='Columns' and @class='k-input']")));
//
//		row.selectByVisibleText("Rows");
//
//		Assert.assertEquals(row.getFirstSelectedOption().getText(), "Rows");

	  	try {

			act.click(findVisible(By.xpath("//span[text()='Columns' and @class='k-input']"))).sendKeys(Keys.ENTER)
					.sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ENTER).build().perform();

		}
	  	catch (StaleElementReferenceException e) {
	  		e.printStackTrace();
		}

		implicitWaitSeconds(2);
//		Thread.sleep(2000);
//		log.driver.findElement(By.xpath("//div[text()='Series from']")).click();
//		System.out.println(log.driver.findElement(By.xpath("//div[text()='Series from']/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText());
//		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Series from']/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText(),"Rows");

		Thread.sleep(500);
        test.info(" Row is selected for Series");
		
		//Chart Area
        if(log.driver.findElement(By.xpath("(//span[text()='Chart Area (3D Settings)'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Chart Area (3D Settings)'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Chart Area (3D Settings)'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("3D Chart type is expanded");
			test.info("3D Chart type is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Chart Area (3D Settings)'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Chart Area (3D Settings)'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
		}
		else
		{
			System.out.println("3D Chart type is already expanded");
			test.info("3D Chart type is already expanded");
		}
        waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]");
    	log.driver.findElement(By.xpath("//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]")).click();
    	waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Chart Area Property is Change");
		test.info("Chart Area Property is Change");
		
		//datapoint Lables
		Thread.sleep(1000);
	    if(log.driver.findElement(By.xpath("(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		 {
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Datapoint Labels is expanded");
			test.info("Datapoint Labels is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
		 }
		 else
		 {
			System.out.println("Datapoint Labels is already expanded");
		 	test.info("Datapoint Labels is already expanded");
		 }
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]"); 
		log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]")).click(); 
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]"); 
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		test.info("Datapoint Lable Property is Changed ");
		
		
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
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Name and Description']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Bubble Chart Layout");
		
		String Dataviewwinbtn2[]= {"<< Back","Finish","Cancel","Help"};
		List<WebElement> btnlist2 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		int buttonlistsize2 = btnlist2.size();
		for(int i =0;i<=buttonlistsize2-1;i++) 
		{
			assertEquals(Dataviewwinbtn2[i], btnlist2.get(i).getAttribute("value"));
			System.out.println(btnlist2.get(i).getAttribute("value"));
			test.info(btnlist2.get(i).getAttribute("value"));
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(3000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed())
			{
				log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
				Thread.sleep(3000);	
			}
		}
		catch(Exception e)
		{
			System.out.println("Finish clicked");
		}

		Thread.sleep(2000);
	  if(log.driver.findElement(By.xpath("(//div[text()='All Categories'])[1]/img[1]")).getAttribute("src").contains("plus"))
		 {
		    waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[.='All Categories'])[1]");
			log.driver.findElement(By.xpath("(//div[.='All Categories'])[1]")).click();
			Thread.sleep(1000);
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[.='All Categories'])[1]");
			Utils.rightClick("(//div[.='All Categories'])[1]");
			Thread.sleep(2000);
			
			try
			{
				if(log.driver.findElement(By.xpath("//span[text()='Navigate']")).isDisplayed())
				{
					System.out.println("Navigate Available");
				}
			}
			catch(Exception e)
			{
				// Actions act = new Actions(log.driver);
			     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='-1/0'])[1]"))).perform();
			     Thread.sleep(2000);
			}
		 
		  
		  
		  waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Navigate']");
		  log.driver.findElement(By.xpath("//span[text()='Navigate']")).click();
		  Thread.sleep(300);
		  
		  waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Expand']");
		  log.driver.findElement(By.xpath("//span[text()='Expand']")).click();
		  Thread.sleep(2000);

		  System.out.println("All category is expanded");
		  test.info("All category is expanded");
			
		 }
		 else
		 {
			System.out.println("All category is already expanded");
		 	test.info("All category is already expanded");
		 }
		
		org.testng.Assert.assertTrue(findVisibleBool(By.xpath("//parent::div[@class='w20_contentpane w20_kendo w20_layoutcomp']//img[@class='w20_image ']")));
		Utils ui = new Utils(driver);
		ui.rightClick("//parent::div[@class='w20_contentpane w20_kendo w20_layoutcomp']//img[@class='w20_image ']");
		implicitWaitSeconds(2);
		List<WebElement> BubbleChart_contextmenu_options =findAllVisible(By.xpath("//span[.='Data Label']/../../li/span[1]"));

		for (WebElement we : BubbleChart_contextmenu_options) {
			System.out.println(we.getText());
			test.info("context menu options is" + we.getText());
		}	
		Thread.sleep(1000);
		BubbleChart_contextmenu_options.get(BubbleChart_contextmenu_options.size()-2).click();
		Thread.sleep(300);
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//span[contains(text(),'Properties of')]/../..");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Properties of')]/../..")).isDisplayed(), true);
		
		//validate the properties
		//Chart type
		if(log.driver.findElement(By.xpath("(//span[text()='Chart Type'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Chart Type'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Chart Type'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Chart type is expanded");
			test.info("Chart type is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Chart Type'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Chart Type'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
		}
		else
		{
			System.out.println("Chart type is already expanded");
			test.info("Chart type is already expanded");
		}
		
		log.driver.findElement(By.xpath("//div[text()='Series from']")).click();
		System.out.println(log.driver.findElement(By.xpath("//div[text()='Series from']/ancestor::div[1]/table/tbody/tr[7]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Series from']/ancestor::div[1]/table/tbody/tr[7]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText(),"Rows");
		Thread.sleep(500);
        test.info(" Row is selected for Series");
		
      //Chart Area
        if(log.driver.findElement(By.xpath("(//span[text()='Chart Area (3D Settings)'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Chart Area (3D Settings)'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Chart Area (3D Settings)'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("3D Chart type is expanded");
			test.info("3D Chart type is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Chart Area (3D Settings)'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Chart Area (3D Settings)'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
		}
		else
		{
			System.out.println("3D Chart type is already expanded");
			test.info("3D Chart type is already expanded");
		}
        waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("3D Chart type checkbox is selected");
		test.info("3D Chart type checkbox is selected");
		
		//datapoint Lables
		Thread.sleep(1000);
	    if(log.driver.findElement(By.xpath("(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		 {
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Datapoint Labels is expanded");
			test.info("Datapoint Labels is expanded");
			Thread.sleep(2000);
			
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
			Thread.sleep(2000);
		 }
		 else
		 {
			System.out.println("Datapoint Labels is already expanded");
		 	test.info("Datapoint Labels is already expanded");
		 }
		
	    Thread.sleep(2000);
	    waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]"); 
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true); 
		test.info("Vissible checkbox is selected ");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		log.driver.close();
		
	  	
  }
  
}
