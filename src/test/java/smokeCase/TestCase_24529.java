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

public class TestCase_24529 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Testcase_for_creating_ABC_table_Layout_in_standard_report(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_24529: Testcase for creating ABC table Layout in standard report");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[contains(text(),'Training Sales')]","TestCase_24529_ABC_tableLayout",false);
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
		String type[] = {"Title","Image","Table","Chart","Filter Bar","Selection Bar","Action Bar","ABC Table","ABC Chart","Horizontal Waterfall Chart","Vertical Waterfall Chart","Bubble Chart","Gauge","Map", "OS Map"};
		System.out.println("The  component layout window contains  below list" );
		test.info("The  component layout window contains  below list");
		for(int i = 0;i<compontType.size();i++) 
		{
			Assert.assertEquals(type[i], compontType.get(i).getText());
			System.out.println(compontType.get(i).getText());	
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='ABC Table']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='ABC Table']/../../div/span")).isDisplayed());
		System.out.println("ABC Table layout Available");
		test.info("ABC Table layout Available");
				
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='ABC Table']/../../div/span");
		log.driver.findElement(By.xpath("//span[text()='ABC Table']/../../div/span")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='ABC Table']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='ABC Table']/../../div/span")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Inserts an ABC classification table into the report.']");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Inserts an ABC classification table into the report.']")).isDisplayed(),"message for ABC Table displayed correctly");
		
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
		// /html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]
		Assert.assertEquals(log.driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).isSelected(),false);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='DataView Assignment']/following::div[6]/div/div[1]");
		log.driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();
		Assert.assertEquals(log.driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).isSelected(),true);
//		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='DataView Assignment']/following::div[6]/div/div[1]/input")).isSelected(),false);
//		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='DataView Assignment']/following::div[6]/div/div[1]");
//		log.driver.findElement(By.xpath("//span[text()='DataView Assignment']/following::div[6]/div/div[1]")).click();
//		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='DataView Assignment']/following::div[6]/div/div[1]/input")).isSelected(),true);
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
		List<WebElement> TitleWindowList = log.driver.findElements(By.xpath("(//table[@class='prg'])[1]/tbody/tr/td[2]/a/span"));
		
		ArrayList<String> TitleSWinText = new ArrayList<String>();
		TitleSWinText.add("Classification");
		TitleSWinText.add("Position");
		TitleSWinText.add("Rows");
		TitleSWinText.add("Columns");
		TitleSWinText.add("Data Area");
		for (int i =0;i<=TitleWindowList.size()-1;i++) 
		{
			assertEquals(TitleWindowList.get(i).getText(),TitleSWinText.get(i));
			System.out.println(TitleWindowList.get(i).getText());
			test.info(TitleWindowList.get(i).getText());
		}	
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Autofit']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Autofit']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),false);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Autofit']/ancestor::tr[1]/td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Autofit']/ancestor::tr[1]/td[3]/div[1]")).click();
		Thread.sleep(1000);
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Autofit']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Horizontal alignment'])[1]/ancestor::tr[1]/td[3]/div/span/span/span[1]");
	    WebElement Elemnt=log.driver.findElement(By.xpath("(//div[text()='Horizontal alignment'])[1]/ancestor::tr[1]/td[3]/div/span/span/span[1]"));
		Actions act = new Actions(log.driver);
		/*act.click(Elemnt).sendKeys("Left", Keys.ENTER).build().perform();*/
		act.click(Elemnt).sendKeys(Keys.ARROW_UP).build().perform();
		act.click(Elemnt).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		Assert.assertEquals(Elemnt.getText(),"Left");
		
		System.out.println("Horizontal alignment is selected as Left");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Show row headers']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Show row headers']/ancestor::tr[1]/td[3]/div[1]")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Show row headers']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Show row headers']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Wordwrap in row header']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Wordwrap in row header']/ancestor::tr[1]/td[3]/div[1]")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Wordwrap in row header']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Wordwrap in row header']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),false);
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Show column headers']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Show column headers']/ancestor::tr[1]/td[3]/div[1]")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Show column headers']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Show column headers']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Wordwrap in column header']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Wordwrap in column header']/ancestor::tr[1]/td[3]/div[1]")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Wordwrap in column header']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Wordwrap in column header']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),false);
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Show gridlines']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Show gridlines']/ancestor::tr[1]/td[3]/div[1]")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[text()='Show gridlines']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Show gridlines']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		
		String Dataviewwinbtn11[]= {"<< Back","Next >>","Finish","Cancel","Help"};
		List<WebElement> btnlist11 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		int buttonlistsize11 = btnlist11.size();
		for(int i =0;i<=buttonlistsize11-1;i++) 
		{
			assertEquals(Dataviewwinbtn11[i], btnlist11.get(i).getAttribute("value"));
			System.out.println(btnlist11.get(i).getAttribute("value"));
			test.info(btnlist11.get(i).getAttribute("value"));
		}
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Name and Description']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("ABC Table Layout");
		
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
			if(log.driver.findElement(By.xpath("(//div[text()='Single Period'])[2]")).isDisplayed())
			{
				System.out.println("Finish clicked");
			}
		}
		catch(Exception e)
		{
			log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
			Thread.sleep(3000);
		}
		
		
		//Validate
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Single Period'])[2]");
		ui.rightClick("(//div[text()='Single Period'])[2]");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Table Properties...']");
		log.driver.findElement(By.xpath("//*[text()='Table Properties...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(30, "//span[contains(.,'Properties of')]");
		String chek1 = log.driver.findElement(By.xpath("//span[contains(.,'Properties of')]")).getText();
		assertEquals(chek1,"Properties of 'ABC Table Layout'");
		
		//Auofit
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//div[text()='Autofit'])[1]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Autofit'])[1]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Atuofit Is checked");
		test.info("Atuofit Is checked");
		
		//Horizontal allignment
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Horizontal alignment'])[1]/ancestor::tr[1]/td[3]/div/span/span/span[1]");
	    WebElement Elemnt1=log.driver.findElement(By.xpath("(//div[text()='Horizontal alignment'])[1]/ancestor::tr[1]/td[3]/div/span/span/span[1]"));
		Thread.sleep(1000);
		Assert.assertEquals(Elemnt1.getText(),"Left");
		System.out.println("Horizontal alignment is selected as Left");
	
		if(log.driver.findElement(By.xpath("(//span[text()='Rows'])[1]/../../../td[1]/a /span")).getAttribute("class").contains("plus"))
		{
			log.driver.findElement(By.xpath("(//span[text()='Rows'])[1]/../../../td[1]/a /span")).click();
			System.out.println("Row is not expanded");
			test.info("Row is not expanded");
		}
		else
		{
			System.out.println("Row is expanded");
			test.info("Row is expanded");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//div[text()='Show row headers'])[1]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Show row headers'])[1]/ancestor::tr[1]/td[3]/div[1]")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//div[text()='Show row headers'])[1]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Show row headers'])[1]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Show row headers  is Selected");
		test.info("Show row headers  is Selected");
		
		Thread.sleep(3000);
		if(log.driver.findElement(By.xpath("(//span[text()='Columns'])[1]/../../../td[1]/a /span")).getAttribute("class").contains("plus"))
		{
			log.driver.findElement(By.xpath("(//span[text()='Columns'])[1]/../../../td[1]/a /span")).click();
			System.out.println("Column is not expanded");
			test.info("Column is not expanded");
		}
		else
		{
			System.out.println("Column is expanded");
			test.info("Column is expanded");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//div[text()='Show column headers'])[1]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Show column headers'])[1]/ancestor::tr[1]/td[3]/div[1]")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//div[text()='Show column headers'])[1]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Show column headers'])[1]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Show column headers is Selected");
		test.info("Show column headers is Selected");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//div[text()='Show gridlines'])[1]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Show gridlines'])[1]/ancestor::tr[1]/td[3]/div[1]")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//div[text()='Show gridlines'])[1]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Show gridlines'])[1]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Show gridlines is Selected");
		test.info("Show gridlines is Selected");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		log.driver.close();
		
		
	}
}
