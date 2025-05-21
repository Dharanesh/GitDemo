package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24532 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Testcase_for_creating_Horizontal_waterfall_Layout_in_standard_report(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_24532 : Testcase for creating Horizontal waterfall Layout in standard report");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[contains(text(),'Training Sales')]","TestCase_24532_Horizontal_waterfall_Layout",false);
		System.out.println("report created using Training Sales cube");
		test.info("report created using Training Sales cube");

		click(By.xpath("//span[text()='Components']"));
		click(By.xpath("(//a[@data-title='Create a New Report Component'])[1]"));
		click(By.xpath("//span[text()='New Layout Component...']"));

		List<WebElement> reports = findAll(By.xpath("//span[@class='reportNametxt']"));

		List<String> list = new ArrayList<>();
		list.add("Title");
		list.add("Image");
		list.add("Table");
		list.add("Chart");
		list.add("Filter Bar");
		list.add("Selection Bar");
		list.add("Action Bar");
		list.add("ABC Table");
		list.add("ABC Chart");
		list.add("Horizontal Waterfall Chart");
		list.add("Vertical Waterfall Chart");
		list.add("Bubble Chart");
		list.add("Gauge");
		list.add("Map");
		list.add("OS Map");

		for (int i = 0; i < reports.size() - 1; ++i) {
			Assert.assertEquals(reports.get(i).getText(), list.get(i));
			test.info(list.get(i));
		}

		test.info("The  component layout window contains above list");

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Horizontal Waterfall Chart']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Horizontal Waterfall Chart']/../../div/span")).isDisplayed());
		System.out.println("Horizontal Waterfall  Chart layout Available");
		test.info("Horizontal Waterfall Chart layout Available");
				
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Horizontal Waterfall Chart']/../../div/span");
		log.driver.findElement(By.xpath("//span[text()='Horizontal Waterfall Chart']/../../div/span")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Horizontal Waterfall Chart']/../../div/span");
		assertTrue(findVisible(By.xpath("//span[text()='Horizontal Waterfall Chart']/../../div/span")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Inserts a horizontal waterfall chart into the report.']");
		assertTrue(findVisible(By.xpath("//div[text()='Inserts a horizontal waterfall chart into the report.']")).isDisplayed(),"message for Horizontal Waterfall Chart displayed correctly");
		
		String button1[]= {"Next >>","Cancel","Help"};
		List<WebElement> button = findAllVisible(By.xpath("//div[@id='buttons']/input"));
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
		junit.framework.Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='DataView Assignment']/following::div[6]/div/div[1]/div/input")).isSelected(),false);
		log.driver.findElement(By.xpath("//span[text()='DataView Assignment']/following::div[6]/div/div[1]/div/input")).click();
		junit.framework.Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='DataView Assignment']/following::div[6]/div/div[1]/div/input")).isSelected(),true);
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
		ArrayList<String>settingMenu  = new ArrayList();
		settingMenu.add("Horizontal Waterfall Chart");
		settingMenu.add("Chart Area");
		settingMenu.add("Datapoint Labels");
	
		for (int i =0;i<WindowList.size()-1;i++) 
		{
			assertEquals(WindowList.get(i).getText(),settingMenu.get(i));
			System.out.println(WindowList.get(i).getText());
			test.info(WindowList.get(i).getText());
		}
		
		System.out.println("All the options are Present in settings window");
		test.info("All the options are Present in settings window");
		
		if(log.driver.findElement(By.xpath("(//span[text()='Horizontal Waterfall Chart'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Horizontal Waterfall Chart'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Horizontal Waterfall Chart'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Horizontal Waterfall type is expanded");
			test.info("Horizontal Waterfall type is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Horizontal Waterfall Chart'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Horizontal Waterfall Chart'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
		}
		else
		{
			System.out.println("Horizontal Waterfall type is already expanded");
			test.info("Horizontal Waterfall type is already expanded");
		}
		
		WebElement Elemntgauge = findVisible(By.xpath("//div[text()='Series from']/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]"));
		Actions act = new Actions(log.driver);
		//act.click(Elemntgauge).sendKeys("Rows", Keys.ENTER).build().perform();
		act.click(Elemntgauge).sendKeys(Keys.ARROW_DOWN).build().perform();
		act.click(Elemntgauge).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//div[text()='Series from']")).click();
		System.out.println(log.driver.findElement(By.xpath("//div[text()='Series from']/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Series from']/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText(),"Rows");
		Thread.sleep(500);
        test.info(" Row is selected for Series");       
		
		//Chart Area
        if(log.driver.findElement(By.xpath(" (//span[text()='Chart Area'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10," (//span[text()='Chart Area'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath(" (//span[text()='Chart Area'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Chart area is expanded");
			test.info("Chart Area is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Chart Area'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Chart Area'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
		}
		else
		{
			System.out.println("Chart area is already expanded");
			test.info("Chart area is already expanded");
		}
        waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]");
    	log.driver.findElement(By.xpath("//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]")).click();
    	waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Chart Area Property Enable 3D is Change");
		test.info("Chart Area Property  Enable 3Dis Change");
		
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
		
	    if(findVisible(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected())
	    {
	    	waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]"); 
			Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
			test.info("Datapoint Lable Property is Changed ");
	    }
	    else
	    {
	    	waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]"); 
			log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]")).click();
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]"); 
			Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
			test.info("Datapoint Lable Property is Changed ");
	    }
		 
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
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Horizontal Waterfall Chart");
		
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
		Thread.sleep(2000);
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed())
			{
				waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
				log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Finish clicked");
		}
		
		
		Thread.sleep(2000);		
		//validate Horizontal chart
		findVisible(By.xpath("/html/body/div[3]/div[5]/div[3]/div/div/div/div/div[2]/div[3]/img"));
		Thread.sleep(300);
		ui.rightClick("/html/body/div[3]/div[5]/div[3]/div/div/div/div/div[2]/div[3]/img");
		Thread.sleep(300);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Chart Properties...']");
		log.driver.findElement(By.xpath("//span[text()='Chart Properties...']")).click();
		
		Thread.sleep(300);
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//span[contains(text(),'Properties of')]/../..");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Properties of')]/../..")).isDisplayed(), true);
		
		if(log.driver.findElement(By.xpath("(//span[text()='Horizontal Waterfall Chart'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Horizontal Waterfall Chart'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Horizontal Waterfall Chart'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Horizontal Waterfall type is expanded");
			test.info("Horizontal Waterfall type is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Horizontal Waterfall Chart'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(findVisible(By.xpath("(//span[text()='Horizontal Waterfall Chart'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
		}
		else
		{
			System.out.println("Horizontal Waterfall type is already expanded");
			test.info("Horizontal Waterfall type is already expanded");
		}
		
		findVisible(By.xpath("//div[text()='Series from']")).click();
		System.out.println(findVisible(By.xpath("(//div[text()='Series from'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(findVisible(By.xpath("(//div[text()='Series from'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText(),"Rows");
		Thread.sleep(1000);
        test.info(" Row is selected for Series");
		
      //Chart Area
        if(findVisible(By.xpath(" (//span[text()='Chart Area'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waitForVisibilityOfElement(By.xpath(" (//span[text()='Chart Area'])[1]/../../../td[1]/a/span[1]"));
			findVisible(By.xpath(" (//span[text()='Chart Area'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Chart area is expanded");
			test.info("Chart Area is expanded");
			Thread.sleep(2000);
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Chart Area'])[1]/../../../td[1]/a/span[1]");
			Assert.assertTrue(findVisible(By.xpath("(//span[text()='Chart Area'])[1]/../../../td[1]/a/span[1]")).isDisplayed());
		}
		else
		{
			System.out.println("Chart area is already expanded");
			test.info("Chart area is already expanded");
		}
  
    	waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Enable 3D']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Chart Area Property Enable 3D is selected");
		test.info("Chart Area Property  Enable 3D is selected");
		
		//datapoint Lables
		Thread.sleep(2000);
	    if(log.driver.findElement(By.xpath("(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		 {
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Datapoint Labels'])[1]/../../../td[1]/a/span[1]")).click();
			Thread.sleep(2000);
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
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		test.info("Datapoint Lable Property vissible is selected ");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
	}
}
