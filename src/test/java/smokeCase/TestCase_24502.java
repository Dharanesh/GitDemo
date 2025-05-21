package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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

public class TestCase_24502 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Testcase_creating_Filter_Bar_Layout_Standard_Report(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_24502 : Testcase creating Filter Bar Layout Standard Report");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[contains(text(),'Training Sales')]","TestCase_24502_FilterLayout",true);
		System.out.println("report created using Training Sales cube");
		test.info("report created using Training Sales cube");
		
        waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
		Thread.sleep(1000);
		
		log.driver.findElement(By.xpath("//span[text()='Components']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//a[@data-title='Create a New Report Component'])[1]");
		log.driver.findElement(By.xpath("(//a[@data-title='Create a New Report Component'])[1]")).click();
		Thread.sleep(100);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Layout Component...']");
		log.driver.findElement(By.xpath("//span[text()='New Layout Component...']")).click();	
		Thread.sleep(100);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Layout Component']");
		
       //Verify list of options  displayed 
		List<WebElement>compontType = log.driver.findElements(By.xpath("//div[text()='Please select a layout component type']/../div[2]/div/div/div[2]/div[1]/span[1]"));
		int typesize = compontType.size();
		String[] type = {"Title","Image","Table","Chart","Filter Bar","Selection Bar","Action Bar","ABC Table","ABC Chart","Horizontal Waterfall Chart","Vertical Waterfall Chart","Bubble Chart","Gauge","Map", "OS Map"};
		System.out.println("The  component layout window contains  below list" );
		test.info("The  component layout window contains  below list");

//		System.out.println(type.length);
//		System.out.println(typesize);

		for(int i = 0;i<compontType.size();i++)
		{
			Assert.assertEquals(type[i], compontType.get(i).getText());
			System.out.println(compontType.get(i).getText());	
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Filter Bar']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Filter Bar']/../../div/span")).isDisplayed());
		System.out.println("Filter Bar layout Available");
		test.info("Filter Bar layout Available");
				
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Filter Bar']/../../div/span");
		log.driver.findElement(By.xpath("//span[text()='Filter Bar']/../../div/span")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Filter Bar']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Filter Bar']/../../div/span")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Inserts a filter bar into the report.']");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Inserts a filter bar into the report.']")).isDisplayed(),"message for title displayed correctly");
		
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Assignments for Filter Bar']");
		System.out.println("After click on Next button Assignments for Filter Bar window for appear");
		test.info("After click on Next button Assignments for Filter Bar window for appear");
		
		ArrayList<String>dataview_Buttons_Page = new ArrayList<String>();
		dataview_Buttons_Page.add("Assign...");
		dataview_Buttons_Page.add("Remove");
		
		List<WebElement> dataview_buttons = log.driver.findElements(By.xpath("//*[text()='Assignments for Filter Bar']/following::div[4]/div[2]/div/button[1]"));
		System.out.println("Below mentions button are available in dataveiw page");
		for(int i = 1;i<dataview_buttons.size()-2;i++) 
		{
		assertEquals(dataview_Buttons_Page.get(i),dataview_buttons.get(i).getText());
		String buttons  = dataview_buttons.get(i).getText();
		System.out.println(buttons);
		test.info(buttons);

		}
		Thread.sleep(2000);
		String button11[]= {"Next >>","Finish","Cancel","Help"};
		List<WebElement> buttonlist = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		System.out.println("The New layout Component window list button  are :=  ");
		int buttonsize1 = buttonlist.size();
		for(int i =0;i<=buttonsize1-1;i++) 
		{
			
			assertEquals(button11[i], buttonlist.get(i).getAttribute("value"));
			System.out.println(buttonlist.get(i).getAttribute("value"));
			test.info(buttonlist.get(i).getAttribute("value"));
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Assign DataViews and/or Filters later']");
		assertEquals(log.driver.findElement(By.xpath("//*[text()='Assign DataViews and/or Filters later']/preceding::input[1]")).isSelected(),false);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Assign DataViews and/or Filters later']");
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Assign DataViews and/or Filters later']");
        log.driver.findElement(By.xpath("//*[text()='Assign DataViews and/or Filters later']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Assign DataViews and/or Filters later']");
		assertEquals(log.driver.findElement(By.xpath("//*[text()='Assign DataViews and/or Filters later']/preceding::input[1]")).isSelected(),true);
		
		List<WebElement> checkBoxStat =log.driver.findElements(By.xpath("//*[text()='Assignments for Filter Bar']/following::div[4]/div[2]/div/button[1]"));
		for(int i=0;i<=checkBoxStat.size()-1;i++) 
		{
			boolean a =checkBoxStat.get(i).isEnabled();
			assertFalse(a);
			
		}
		System.out.println("After checked the checkbox Assign DataViews and/or Filters later 4 buttons are disabled");
		
		log.driver.findElement(By.xpath("//*[text()='Assign DataViews and/or Filters later']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Assign DataViews and/or Filters later']");
		assertEquals(log.driver.findElement(By.xpath("//*[text()='Assign DataViews and/or Filters later']/preceding::input[1]")).isSelected(),false);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Assignments for Filter Bar']");		
		log.driver.findElement(By.xpath("//*[text()='Assign...']")).click();
		
		System.out.println("Please Select a report component window displayed");
		test.info("Please Select a report component window displayed ");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//*[text()='Please select a report component:'])[1]/following::div[8]/div/div[2]");
		List<WebElement> repot = log.driver.findElements(By.xpath("(//*[text()='Please select a report component:'])[1]/following::div[8]/div/div[2]"));
      
		ArrayList<String> reportcompt = new ArrayList<String>();
		ArrayList<String> FilterAdd=new ArrayList<String>();
		reportcompt.add("DataViews");
		reportcompt.add("Automatic Filters");
		//reportcompt.add("User-defined Filters");
		System.out.println("The available options are = ");
		for(int i =0;i<repot.size()-2;i++) 
		{
			
			assertEquals(reportcompt.get(i),repot.get(i).getText());
			
			System.out.println(repot.get(i).getText());
		}
		
		if(log.driver.findElement(By.xpath("(//div[text()='DataViews'])[1]/preceding::div[1]/a/span[1]")).isDisplayed())
		{
			log.driver.findElement(By.xpath("(//div[text()='DataViews'])[1]/preceding::div[1]/a/span[1]")).click();
			System.out.println("Dataview is expanded");
			test.info("Dataview is expanded");
			//validate the list items
			waits.waitUntil_Elmentis_visibilityOfElement(40,"(//div[text()='A - Training Sales'])[1]");
			System.out.println(log.driver.findElement(By.xpath("(//div[text()='A - Training Sales'])[1]")).getText());
			log.driver.findElement(By.xpath("(//div[text()='A - Training Sales'])[1]/preceding::div[1]")).click();
			assertTrue(log.driver.findElement(By.xpath("(//div[text()='A - Training Sales'])[1]/preceding::div[1]/input[1]")).isSelected());
			Thread.sleep(1000);
			
		}
		else
		{
			System.out.println("Dataview is already expanded");
			test.info("Dataview is already expanded");
		}

		if(log.driver.findElement(By.xpath("(//div[text()='Automatic Filters'])[1]/preceding::div[1]/a/span[1]")).isDisplayed())
		{
//			log.driver.findElement(By.xpath("(//div[text()='Automatic Filters'])[1]/preceding::div[1]/a/span[1]")).click();
			Thread.sleep(1000);
			System.out.println("Automatic Filters is expanded");
			test.info("Automatic Filters is expanded");


			// right path: "(//*[text()='Please select a report component:'])[1]/following::div[8]//div[text()='Automatic Filters']"
			
			List<WebElement> repot1 = log.driver.findElements(By.xpath("(//*[text()='Please select a report component:'])[1]/following::div[8]/div/div[2]"));



			for(int i=0;i<repot1.size()-1;i++)
			{
				int k;
				if(repot1.get(i).getText().equals("Automatic Filters"))
				{
					
					System.out.println(repot1.get(i).getText());
					for(k=i+2;k<=repot1.size();k++)
					{
						String Value=log.driver.findElement(By.xpath("(//*[text()='Please select a report component:'])[1]/following::div[8]/div["+k+"]/div[2]")).getText();
						System.out.println(Value);
						FilterAdd.add(Value);
						Thread.sleep(2000);
						log.driver.findElement(By.xpath("(//*[text()='Please select a report component:'])[1]/following::div[8]/div["+k+"]/div[1]")).click();
						assertEquals(log.driver.findElement(By.xpath("(//*[text()='Please select a report component:'])[1]/following::div[8]/div["+k+"]/div[1]/input[1]")).isSelected(),true);
						System.out.println("Checkbox checked");
					}
					break;
				}		
			}
		}
		else
		{
			System.out.println("Automatic filter is already expanded");
			test.info("Automatic filter is already expanded");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Assignments for Filter Bar']");
		System.out.println("After click on ok button Assignments for Filter Bar window for appear");
		test.info("After click on ok button Assignments for Filter Bar window for appear");
		
		System.out.println("List of selected dataview and filter optios are ");	
		List<WebElement> availtext = log.driver.findElements(By.xpath("//*[@id='IDDIVLISTVIEW']/div[1]/div/div[2]"));
		for(int  i =0;i<=availtext.size()-1;i++)
		{
		
			System.out.println(availtext.get(i).getText());
			Thread.sleep(100);
		
		}
		Thread.sleep(200);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Position in report']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Position in report']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Insert at top of report.']");
		log.driver.findElement(By.xpath("//label[text()='Insert at top of report.']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Insert at top of report.']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Insert at top of report.']/preceding::input[1]")).isSelected(), true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Settings for the layout component']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the layout component']")).isDisplayed(), true);
		System.out.println("Settings for the layout component is Displayed");
		test.info("Settings for the layout component is Displayed");
		
		System.out.println("Settings for the layou window texts are:");
		test.info("Settings for the layou window texts are:");
		List<WebElement> PropWindowList = log.driver.findElements(By.xpath("(//table[@class='prg'])[1]/tbody/tr/td[2]/a/span[1]"));
		
		ArrayList<String> propWinText = new ArrayList<String>();
	    propWinText.add("General Settings");
		
		for (int i =0;i<PropWindowList.size()-1;i++) 
		{
			assertEquals(PropWindowList.get(i).getText(),propWinText.get(i));
			System.out.println(PropWindowList.get(i).getText());
			test.info(PropWindowList.get(i).getText());
		}	
		Thread.sleep(1000);
		
		ArrayList<String> GeneralS = new ArrayList<String>();
		GeneralS.add("Show filter symbol");
		GeneralS.add("Filter arrangement");
		
		System.out.println("In General Setting Window available option are ");
		test.info("In General Setting Window available option are:");
		List<WebElement > Genral = log.driver.findElements(By.xpath("(//table[@class='prg'])[1]/tbody/tr/td[2]//div[1]"));
		for (int i=0;i<=Genral.size()-1;i++) 
		{
			if(i==0) 
			{
				String ShowFilterSymbl= Genral.get(i).getText();
				assertEquals(GeneralS.get(i), ShowFilterSymbl);
				System.out.print(ShowFilterSymbl);
				test.info(ShowFilterSymbl);
				boolean CheckboxStat = log.driver.findElement(By.xpath("(//*[text()='Show filter symbol'])[1]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected();
				
				assertFalse(CheckboxStat);
				System.out.println("Checkbox is unchecked");
				
			}
			else if(i==1) 
			{
				String FilterArrngmnt = Genral.get(i).getText();
				assertEquals(GeneralS.get(i), FilterArrngmnt);
				System.out.print(FilterArrngmnt);
				test.info(FilterArrngmnt);
				
				WebElement FilterArrngmntStat=log.driver.findElement(By.xpath("(//div[text()='Filter arrangement'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]"));
				Assert.assertEquals(FilterArrngmntStat.getText(),"In rows");
				System.out.println("The Selected value of Filter arrangement is "+FilterArrngmntStat.getText());
				test.info("The Selected value of Filter arrangement is "+FilterArrngmntStat.getText());
				
				
			}		
		
		}
		
		
		
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Name and Description']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Filter Layout");
		
		String Dataviewwinbtn2[]= {"<< Back","Finish","Cancel","Help"};
		List<WebElement> btnlist2 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		int buttonlistsize2 = btnlist2.size();
		for(int i =0;i<=buttonlistsize2-1;i++) 
		{
			assertEquals(Dataviewwinbtn2[i], btnlist2.get(i).getAttribute("value"));
			System.out.println(btnlist2.get(i).getAttribute("value"));
			test.info(btnlist2.get(i).getAttribute("value"));
		}
		Thread.sleep(500);
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
		//====validate the filters added============
		
//		waits.waitUntil_Elmentis_visibilityOfElement(30,"//button[@data-title='Expand to multi line']");
//		log.driver.findElement(By.xpath("//button[@data-title='Expand to multi line']")).click();
//		Thread.sleep(2000);
		
		List<WebElement> Filters = log.driver.findElements(By.xpath("//div[@class='ellipsisText']"));

//		System.out.println(FilterAdd.size());
//		System.out.println(Filters.size());

//		for(int i =0;i<=Filters.size()-1;i++)
//		{
//			Boolean Status=FilterAdd.get(i).contains(Filters.get(i).getText());
//			assertTrue(Status);
//			System.out.println(Filters.get(i).getText());
//			test.info(Filters.get(i).getText());
//		}
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[@class='ellipsisText'])[1]/span[1]");
		log.driver.findElement(By.xpath("(//div[@class='ellipsisText'])[1]/span[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[@class='ellipsisText'])[1]/span[1]");
		ui.rightClick("(//div[@class='ellipsisText'])[1]/span[1]");
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//div[@class='k-animation-container']/ul/li/span[1]")).isDisplayed())
			{
				System.out.println("Navigate Available");
			}
		}
		catch(Exception e)
		{
			 Actions act = new Actions(log.driver);
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@class='ellipsisText'])[1]/span[1]"))).perform();
		     Thread.sleep(2000);
		}
		
		System.out.println(" options available under SalesOrg  context menu");
		ArrayList<String> salorglist1 = new ArrayList<String>();
		salorglist1.add("Salesorg");
		salorglist1.add("Element Display Width...");
		salorglist1.add("Select Elements...");
		salorglist1.add("Multiple selection");
		salorglist1.add("Enable selection by dialog");
		salorglist1.add("Enable selection by drop-down menu");
		salorglist1.add("Enable navigation by arrow");		
		salorglist1.add("Enable value entry");
		salorglist1.add("Filter Properties...");
		salorglist1.add("Filter Bar Properties...");
		salorglist1.add("Information...");
		List<WebElement> saleorg = log.driver.findElements(By.xpath("//div[@class='k-animation-container']/ul/li/span[1]"));
		for(int i=0;i<=saleorg.size()-1;i++) 
		{
			assertEquals(saleorg.get(i).getText(),salorglist1.get(i));
			Thread.sleep(500);
			System.out.println(saleorg.get(i).getText());
			test.info(saleorg.get(i).getText());			
		}
		System.out.println("*******************************************");
		Thread.sleep(500);
//		log.driver.findElement(By.xpath("(//span[text()='Salesorg'])[3]/ancestor::ul/li[12]/span[1]")).click();
		saleorg.get(9).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30, "//span[contains(.,'Properties of')]");
		String chek1 = log.driver.findElement(By.xpath("//span[contains(.,'Properties of')]")).getText();
		assertEquals(chek1,"Properties of 'Filter Layout'");
		
		boolean CheckboxStat = log.driver.findElement(By.xpath("(//*[text()='Show filter symbol'])[1]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected();
		assertFalse(CheckboxStat);
		System.out.println("Show filter symbol Checkbox is unchecked");
		
		WebElement FilterArrngmntStat=log.driver.findElement(By.xpath("(//div[text()='Filter arrangement'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]"));
		Assert.assertEquals(FilterArrngmntStat.getText(),"In rows");
		System.out.println("The Selected value of Filter arrangement is "+FilterArrngmntStat.getText());
		test.info("The Selected value of Filter arrangement is "+FilterArrngmntStat.getText());
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		System.out.println("TestCase_24502====Pass");
		test.info("TestCase_24502====Pass");
		log.driver.close();
		
		
		
		
	}
}
