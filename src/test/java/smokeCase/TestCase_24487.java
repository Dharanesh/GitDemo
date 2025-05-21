package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24487  extends TestUtils {
	
	@Test()
	@Parameters("browser")
	public void Web_Testcase_verify_functionality_Analytical_Visualization_Gradient_Edit(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_24487_Web_Testcase to verify PDF Export for functionality of <Analytical Visualization Minichart_Bar_New>");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
//		Open Gradient report
		waits.waituUnitil_Element_Clickable(20,"//span[text()='Eigene Berichte']");
		log.driver.findElement(By.xpath("//span[text()='Eigene Berichte']")).click();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("(//span[@class='k-icon k-i-expand'])[1]")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//span[text()='MiniChart_Bar_New']")).click();
		waits.waituUnitil_Element_Clickable(30,"//span[@id='tab_close_btn']");
		
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Export'])[2]")).click();
		List<WebElement> all   =log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
		ArrayList<String> format = new ArrayList();
		format.add("Excel");
		format.add("PowerPoint");
		format.add("PDF");
		format.add("PDF+");
		format.add("One Page");
		format.add("Image file");
		format.add("CSV format");
		format.add("HTML format");
		format.add("XML export");
		format.add("Excel (VBS)");
		format.add("Word (VBS)");
		format.add("PowerPoint (VBS)");
		for (int i =0;i<=all.size()-1;i++) 
		{
//			System.out.println(all.get(i).getText());
			assertEquals(format.get(i),all.get(i).getText());
		}
		Thread.sleep(2000);
		List<WebElement> all1   =log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
		ArrayList<String> te=new ArrayList();
		te.add("Export report(s) to Microsoft Excel.");
		te.add("Export report(s) to Microsoft PowerPoint.");
		te.add("Export report(s) into PDF documents.");
		te.add("Export report(s) into PDF documents.");
		te.add("Export report(s) into one-page PDF document");
		te.add("Export report(s) as image files.");
		te.add("Export the data contained in report(s) into CSV files.");
		te.add("Export report(s) into HTML files via XML.");
		te.add("Export report(s) into XML files using templates.");
		te.add("Export report(s) into a Microsoft Office Excel via XML and VB-Script.");
		te.add("Export report(s) to Microsoft Word via XML and VB-Script.");
		te.add("Export report(s) into a Microsoft PowerPoint via XML and VB-Script.");
		Thread.sleep(3000);
		int j =1;
		for (int i =0;i<=all1.size()-1;i++) 
		{
			
			log.driver.findElement(By.xpath("(//span[@class='reportNametxt'])["+j+"]")).click();
			Thread.sleep(1000);
			assertEquals(te.get(i), log.driver.findElement(By.xpath("//div[@class='w20_newwiz_description exportMargin']/span")).getText());
			j++;
		}
		String button11[]= {"Next >>","Finish","Cancel","Help"};
		List<WebElement> buttonlist = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		System.out.println("The New layout Component window list button  are :=  ");
		int buttonsize1 = buttonlist.size();
		for(int i =0;i<=buttonsize1-1;i++) 
		{
			
			assertEquals(button11[i], buttonlist.get(i).getAttribute("value"));
			System.out.println(buttonlist.get(i).getAttribute("value"));
		
		}
		log.driver.findElement(By.xpath("//span[text()='PDF']")).click();
		log.driver.findElement(By.id("nextbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@id='prevbutton']");
		assertEquals(log.driver.findElement(By.xpath("(//div[@class='w20_webedit']/input)[1]")).getAttribute("value"), "MiniChart_Bar_New");
		assertFalse((log.driver.findElement(By.xpath("//label[text()='Zip file:']/..")).isSelected()));
		

        String Dataviewwinbtn11[]= {"<< Back","Next >>","Finish","Cancel","Help"};
		List<WebElement> btnlist11 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		int buttonlistsize11 = btnlist11.size();
		for(int i =0;i<=buttonlistsize11-1;i++) 
		{
			assertEquals(Dataviewwinbtn11[i], btnlist11.get(i).getAttribute("value"));
			System.out.println(btnlist11.get(i).getAttribute("value"));
			test.info(btnlist11.get(i).getAttribute("value"));
		}
		 log.driver.findElement(By.xpath("(//input[@type='input' and @disabled='disabled'])[1]")).isDisplayed();
		 log.driver.findElement(By.id("nextbutton")).click();
		 waits.waituUnitil_Element_Clickable(20,"//input[@id='nextbutton']");
		 assertEquals(log.driver.findElement(By.xpath("//span[text()='Iteration Settings']")).getText(),"Iteration Settings");
		 assertEquals(log.driver.findElement(By.xpath("(//div[@class='w20_radiobutton'])[1]")).getText(), "No iteration");
		 assertEquals(log.driver.findElement(By.xpath("(//div[@class='w20_radiobutton'])[2]")).getText(), "Iterate within each report using selected filter elements");
		 assertTrue(log.driver.findElement(By.xpath("//label[text()='No iteration']/../input")).isSelected());
		 assertEquals(log.driver.findElement(By.xpath("(//div[@class='w20_radiobutton']/table/tbody/tr/td/label)[1]")).getText(), "No iteration");
		 assertEquals(log.driver.findElement(By.xpath("(//div[@class='w20_radiobutton']/table/tbody/tr/td/label)[2]")).getText(), "Iterate within each report using selected filter elements");
		 log.driver.findElement(By.id("nextbutton")).click();
		 assertTrue(log.driver.findElement(By.xpath("(//*[text()='Output to a single file']/following::div[@class='w20_checkbox']/label)[1]")).isEnabled());
		 assertTrue(log.driver.findElement(By.xpath("(//*[text()='Export even if no data']/following::div[@class='w20_checkbox']/label)[1]")).isEnabled());

			
			List<WebElement> buttons4 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
			ArrayList<String> buttonList4= new  ArrayList();
			buttonList4.add("<< Back");
			buttonList4.add("Finish");
			buttonList4.add("Cancel");
			buttonList4.add("Help");
			for (int  i =0;i<=buttons4.size()-1;i++) 
			{
				
				assertEquals(buttons4.get(i).getAttribute("value"), buttonList4.get(i));
			}
			log.driver.findElement(By.id("finishbutton")).click();
			waits.waituUnitil_Element_Clickable(20,"//button[text()='Start export...']");
			assertEquals(log.driver.findElement(By.xpath("(//input[@data-role='button'])[1]")).getAttribute("value"), "Close");
			assertEquals(log.driver.findElement(By.xpath("(//input[@data-role='button'])[2]")).getAttribute("value"), "Help");
			log.driver.findElement(By.xpath("//button[text()='Start export...']")).click();
			Thread.sleep(5000);
			assertEquals(log.driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr[1]/td[3]")).getText(), "Executing export 'MiniChart_Bar_New'");
			assertEquals(log.driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr[2]/td[3]")).getText(), "Export report 'MiniChart_Bar_New'");
			assertEquals(log.driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr[3]/td[3]")).getText(), "Export finished successfully");
			waits.waituUnitil_Element_Clickable(20,"//button[text()='Download']");
			log.driver.findElement(By.xpath("//button[text()='Download']")).click();
			log.driver.quit();

			
			

}}
