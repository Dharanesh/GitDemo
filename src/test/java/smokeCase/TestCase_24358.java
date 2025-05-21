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

import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24358 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Testcase_verify_creating_Title_Layout_component(String browser) throws Exception
	{
		test =extent.createTest("TestCase_24358: Testcase to verify creating a Title Layout component");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[text()='Sales']","TestCase_24358_TitleLayout",false);
		System.out.println("report created using HR cube");
		test.info("report created using HR cube");

		Actions actions = new Actions(driver);

		actions.moveToElement(findVisible(By.xpath("//span[text()='Dataview Designer']"))).click().build().perform();
//		clickableClick(By.xpath("//span[text()='Dataview Designer']"));
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Title']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Title']/../../div/span")).isDisplayed());
		System.out.println("Title layout Available");
		test.info("Title layout Available");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Title']/../../div/span");
		log.driver.findElement(By.xpath("//span[text()='Title']/../../div/span")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Title']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Title']/../../div/span")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Inserts a title into the report.']");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Inserts a title into the report.']")).isDisplayed(),"message for title displayed correctly");
		
		String button1[]= {"Next >>","Cancel","Help"};
		List<WebElement> button = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		System.out.println("The New layout Component window list button  are :=  ");
		int buttonsize = button.size();
		for(int i =0;i<=buttonsize-1;i++) 
		{
			
			assertEquals(button1[i], button.get(i).getAttribute("value"));
			System.out.println(button.get(i).getAttribute("value"));
			test.info(button.get(i).getText());
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//span[text()='New Layout Component...'])[1]/../following::div[1]/div[1]/div/div[1]/div[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='New Layout Component...'])[1]/../following::div[1]/div[1]/div/div[1]/div[1]/span[1]")).isDisplayed(), true);
		System.out.println("position in report window displayed successfully");
		test.info("position in report window displayed successfully");
		
        waits.waitUntil_Elmentis_visibilityOfElement(30,"//label[text()='Insert at top of report.']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//label[text()='Insert at top of report.']/preceding::input[1]")).isSelected(), true);
		System.out.println("Insert at top of report selected default");
		test.info("Insert at top of report selected default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Settings for the layout component']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the layout component']")).isDisplayed(), true);
		System.out.println("Settings for the layout component is Displayed");
		test.info("Settings for the layout component is Displayed");
		
		System.out.println("Tittle window texts are:");
		test.info("Tittle window texts are:");
		List<WebElement> TitleWindowList = log.driver.findElements(By.xpath("(//table[@class='prg'])[1]/tbody/tr/td[2]//div[1]"));
		
		ArrayList<String> TitleSWinText = new ArrayList<String>();
		TitleSWinText.add("Text");
		TitleSWinText.add("Style");
		TitleSWinText.add("Background");
		TitleSWinText.add("Font");
		TitleSWinText.add("Color");
	
		
		for (int i =0;i<=TitleWindowList.size()-1;i++) 
		{
			assertEquals(TitleWindowList.get(i).getText(),TitleSWinText.get(i));
			System.out.println(TitleWindowList.get(i).getText());
			test.info(TitleWindowList.get(i).getText());
		}	
		Thread.sleep(1000);
		
	   String  Text = log.driver.findElement(By.xpath("//div[text()='Text']/following::textarea[1]")).getText();
	   Assert.assertEquals(Text.trim(), "<Please supply a title>");
	   String  Style =log.driver.findElement(By.xpath("(//table[@class='prg'])[1]/tbody/tr[3]/td[3]/div/span/span/span[1]")).getText();
	   Assert.assertEquals(Style.trim(), "Transparent");
	   Thread.sleep(2000);
	   String background = (log.driver.findElement(By.xpath("//div[text()='Background']/following::input[1]")).getAttribute("value"));
	   Assert.assertEquals(background.trim(), "(128;128;128)");
	   String Font   = (log.driver.findElement(By.xpath("//div[text()='Font']/following::input[1]")).getAttribute("value"));
	   Assert.assertEquals(Font.trim(), "Arial, 11 pt");
	   String Color=(log.driver.findElement(By.xpath("//div[text()='Color']/following::input[1]")).getAttribute("value"));
	   Assert.assertEquals(Color.trim(), "(0;0;0)");
	
	   WebElement Textarea = log.driver.findElement(By.xpath("//div[text()='Text']/following::textarea[1]"));
	   Textarea.click();
	   Thread.sleep(1000);
	   Textarea.clear();
	   Thread.sleep(1000);
	   log.driver.findElement(By.xpath("//div[text()='Text']/following::textarea[1]")).sendKeys("Cockpit_10");
	   Thread.sleep(2000);
	   
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Style'])[1]");
	   log.driver.findElement(By.xpath("(//div[text()='Style'])[1]")).click();
	   Thread.sleep(500);
	   
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Style'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]");
	   WebElement Elemnt=log.driver.findElement(By.xpath("(//div[text()='Style'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]"));
	   Actions act = new Actions(log.driver);
	   act.click(Elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
	   act.click(Elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
	   act.click(Elemnt).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
	   //act.click(Elemnt).sendKeys("Text background", Keys.ENTER).build().perform();
	 
	 
	   String Style1 = findVisible(By.xpath("//span[contains(@class,'k-input')][normalize-space()='Text background']")).getText();
	   Assert.assertEquals(Style1, "Text background");
	   Thread.sleep(2000);
	   System.out.println("Selected style  is : "+Style1);
	   test.info("Selected style  is : "+Style1);
	   
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Background']/following::td[5]/button[1]");
	   log.driver.findElement(By.xpath("//div[text()='Background']/following::td[5]/button[1]")).click();
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Select color']");
	   Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Select color']")).isDisplayed());
	   System.out.println("select color window displayed");
	   test.info("select color window displayed");
		
	   waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select color']/following::td[14]");
	   log.driver.findElement(By.xpath("//span[text()='Select color']/following::td[14]")).click();
	   Thread.sleep(2000);
	  waits.waitUntil_Elmentis_visibilityOfElement(10, " //td[text()='Red:']/..//input");
	  Assert.assertEquals(log.driver.findElement(By.xpath(" //td[text()='Red:']/..//input")).getAttribute("value"), "0");
		
	  waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Green:']/..//input");
	  Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Green:']/..//input")).getAttribute("value"), "0");
		
	  waits.waitUntil_Elmentis_visibilityOfElement(10,"//td[text()='Blue:']/..//input");
	  Assert.assertEquals(log.driver.findElement(By.xpath("//td[text()='Blue:']/..//input")).getAttribute("value"), "255");
		
	  System.out.println("values present in red, green and blue fields are correct");
	  test.info("values present in red, green and blue fields are correct");
		
	  waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Actual:']/../div[2]");
	  assertTrue(log.driver.findElement(By.xpath("//div[text()='Actual:']/../div[2]")).getCssValue("background-color").contains("0, 0, 255"));
		
	  waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
	  log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
	  Thread.sleep(2000);
	  
	  waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Style'])[1]/following::td[6]");
	  assertTrue(log.driver.findElement(By.xpath("(//div[text()='Style'])[1]/following::td[6]")).getCssValue("background-color").contains("0, 0, 255"));
	   
	  waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Font']/following::td[3]/button[1]");
	  log.driver.findElement(By.xpath("//div[text()='Font']/following::td[3]/button[1]")).click();
	  Thread.sleep(2000);
	  
	  waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Font selection']");
	  Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Font selection']")).isDisplayed(),"Font Selection window not displayed");
      Thread.sleep(2000);
      
	  WebElement FontSelection=log.driver.findElement(By.xpath("//span[text()='Font:']/following::div[2]/span/span/span[1]"));
	  /*act.click(FontSelection).sendKeys("Arial Black", Keys.ENTER).build().perform();*/
	  act.click(FontSelection).sendKeys(Keys.ARROW_DOWN).build().perform();
	  act.click(FontSelection).sendKeys(Keys.ENTER).build().perform();
	  Thread.sleep(2000);
	  
	  WebElement Textarea1 = log.driver.findElement(By.xpath("//span[text()='Font size:']/following::div[2]/div[1]/input[1]"));
	  Textarea1.click();
	  Thread.sleep(2000);
	  Textarea1.clear();
	  Thread.sleep(1000);
	  log.driver.findElement(By.xpath("//span[text()='Font size:']/following::div[2]/div[1]/input[1]")).sendKeys("18");
	  Thread.sleep(1000);	
	  
	
	  waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Font style:']");
	  Assert.assertTrue(log.driver.findElement(By.xpath("//span[text()='Font style:']")).isDisplayed());
	  click(By.xpath("//label[text()='Italic']/preceding::input[1]"));
	  click(By.xpath("//label[text()='Italic']/preceding::input[1]"));
	  Thread.sleep(1000);	
	  Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Italic']/preceding::input[1]")).isSelected(),"Italic not selected");
	  System.out.println("Italic radio button is selected");
	  test.info("Italic radio button is selected");
	  
	  waits.waitUntil_Elmentis_visibilityOfElement(10,"//label[text()='Underline']");
	  log.driver.findElement(By.xpath("//label[text()='Underline']")).click();
	  Assert.assertTrue(log.driver.findElement(By.xpath("//label[text()='Underline']/preceding::input[1]")).isSelected(),"Underline not selected");
	  System.out.println("Underline checkbox is selected");
	  test.info("Underline checkbox is selected");
	 
	  //preview
	  Thread.sleep(1000);	
	  WebElement preview=log.driver.findElement(By.xpath("//span[text()='Preview']"));
	  String Previewtext=preview.getAttribute("style");
	  System.out.println(Previewtext);
	  Assert.assertTrue(Previewtext.contains("Arial Black"));
	  Assert.assertTrue(Previewtext.contains("18pt"));
	  Assert.assertTrue(Previewtext.contains("italic"));
	  Assert.assertTrue(Previewtext.contains("underline"));
	  
	  waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
	  log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
	  Thread.sleep(1000);	
	   
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
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Title Layout");
		
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
//
//		try
//		{
//			if(log.driver.findElement(By.xpath("//*[text()='TestCase_24358_TitleLayout']/following::table[2]/tbody/tr/td[1]/span[@style]")).isDisplayed())
//			{
//				System.out.println("Finish clicked");
//			}
//		}
//		catch(Exception e)
//		{
//			log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
//			Thread.sleep(3000);
//		}
	   
	   //validation
		ui.rightClick("//*[text()='Cockpit_10']");
//		clickableClick(By.xpath("//span[text()='Properties...']"));
//		List<WebElement> Title_properties = findAllPresence(By.xpath("//ul[contains(@class, 'w20_menu w20_kendo k-widget k-reset k-header k-menu k-menu-vertical k-context')]"));
		//verify options in< Title>Context  menu 
		assertEquals(findVisible(By.xpath("//ul[contains(@class, 'w20_menu w20_kendo k-widget k-reset k-header k-menu k-menu-vertical k-context')]/li[2]")).getText(), "Edit Text...");
		assertEquals(findVisible(By.xpath("//ul[contains(@class, 'w20_menu w20_kendo k-widget k-reset k-header k-menu k-menu-vertical k-context')]/li[3]")).getText(), "Properties...");
		System.out.println("Title Context Menu is shown.");
	   
		clickableClick(By.xpath("//ul[contains(@class, 'w20_menu w20_kendo k-widget k-reset k-header k-menu k-menu-vertical k-context')]/li[3]/span"));
		Thread.sleep(1000);
	    
		//property window
		WebElement Textarea11 = log.driver.findElement(By.xpath("(//div[text()='Text'])[1]/following::textarea[1]"));
	    Assert.assertEquals(Textarea11.getText(), "Cockpit_10");
	    System.out.println("Selected Text  is : "+Textarea11.getText());
		test.info("Selected Text  is : "+Textarea11.getText());
		   
	   String  Style2 =log.driver.findElement(By.xpath("(//div[text()='Style'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText();
	   Assert.assertEquals(Style2.trim(), "Text background");
	   Thread.sleep(2000);
	   System.out.println("Selected style  is : "+Style2);
	   test.info("Selected style  is : "+Style2);
	    
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Style'])[1]/following::td[6]");
	   assertTrue(log.driver.findElement(By.xpath("(//div[text()='Style'])[1]/following::td[6]")).getCssValue("background-color").contains("0, 0, 255"));
	    
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Font'])[1]/following::td[2]/div[1]/div[1]/input[1]");
	   Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Font'])[1]/following::td[2]/div[1]/div[1]/input[1]")).getAttribute("value"),"Arial Black, 18 pt");
	     
	   System.out.println("Selected font  is : Arial Black, 18 pt");
	   test.info("Selected font  is : Arial Black, 18 pt");
 
	   waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@id='okbutton']");
	   log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
	   Thread.sleep(1000);
	    
	   log.driver.close();
	    
	    
	    
	   
	}
}
