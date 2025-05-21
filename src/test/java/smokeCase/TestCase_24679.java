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

public class TestCase_24679 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Testcase_verify_creating_Image_Layout_component(String browser) throws Exception
	{
		test =extent.createTest("TestCase_24679: Testcase for creating Image Layout in Layout component");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[text()='Sales']","TestCase_24529_ImageLayout",false);
		System.out.println("report created using Sales cube");
		test.info("report created using Sales cube");
		
        waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		click(By.xpath("//span[text()='Dataview Designer']"));
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
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Image']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Image']/../../div/span")).isDisplayed());
		System.out.println("Title layout Available");
		test.info("Title layout Available");
				
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Image']/../../div/span");
		log.driver.findElement(By.xpath("//span[text()='Image']/../../div/span")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Image']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Image']/../../div/span")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Inserts an image into the report.']");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Inserts an image into the report.']")).isDisplayed(),"message for Image displayed correctly");
		
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
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Position in report']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Position in report']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Settings for the layout component']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the layout component']")).isDisplayed(), true);
		System.out.println("Settings for the layout component is Displayed");
		test.info("Settings for the layout component is Displayed");
		
		List<WebElement> title = log.driver.findElements(By.xpath("(//table[@class='prg'])[1]/tbody/tr/td[2]//div[1]"));
		ArrayList<String> titlebox = new ArrayList<String>();
		
		for (int i =0;i<=title.size()-1;i++) 
		{
			String aa = title.get(i).getText();
			titlebox.add(aa);
			System.out.println(titlebox);			
		}	
		waits.waitUntil_Elmentis_visibilityOfElement(25,"(//div[text()='Sizing'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]" );
		String Sizing=log.driver.findElement(By.xpath("(//div[text()='Sizing'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText();
		Assert.assertEquals(Sizing,"Full image mode");
		System.out.println("Full image mode is displayed by default.");
		test.info("Full image mode is displayed by default.");
			
		waits.waitUntil_Elmentis_visibilityOfElement(25,"(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]");
		//verifying size in % is disabled by default.
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]")).isEnabled(), false);
		System.out.println("size in % is disabled by default.");
		test.info("size in % is disabled by default.");
		
		waits.waitUntil_Elmentis_visibilityOfElement(25,"(//div[text()='Name'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td[2]/button[1]");
		log.driver.findElement(By.xpath("(//div[text()='Name'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td[2]/button[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[.='Image Manager']/..");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[.='Image Manager']/..")).isDisplayed(),true,"Image Manager window is displayed.");
		System.out.println("Image manager window is displayed.");
		
		String ImgManager_buttons[]= {"Add...","Rename...","Delete","Save...","OK","Cancel","Help"};
		List<WebElement> buttons = log.driver.findElements(By.xpath("//div[.='Image Manager']/.././div[2]/div[1]/div[1]/div[3]/div/button"));
		System.out.println("Image Manager window buttons are :=  ");
		int button_size = buttons.size();
		for(int i =0;i<=button_size-1;i++) 
		{
			
			assertEquals(ImgManager_buttons[i], buttons.get(i).getText());
			System.out.println(buttons.get(i).getText());
		}
		
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[text()='Cubeware_logo_160x42']");
		log.driver.findElement(By.xpath("//span[text()='Cubeware_logo_160x42']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Image Manager']/following::div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/img");
		Assert.assertEquals(log.driver.findElement(By.xpath("//*[text()='Image Manager']/following::div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/img")).isDisplayed(),true,"Image is displayed in preview.");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Image Manager']/following::div[4]/div[2]/div[1]/div[2]/div[1]/span[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//*[text()='Image Manager']/following::div[4]/div[2]/div[1]/div[2]/div[1]/span[1]")).getText(),"Cubeware_logo_160x42","Image name not matching in preview.");
		System.out.println("Image manager window is displayed.");
		test.info("Image manager window is displayed.");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		String Name=log.driver.findElement(By.xpath("(//div[text()='Name'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td[1]/div[1]/div[1]/input[1]")).getAttribute("value");
		Assert.assertEquals(Name,"Cubeware_logo_160x42");
		System.out.println(Name);
		test.info(Name);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Sizing'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]");
	    WebElement Elemnt=log.driver.findElement(By.xpath("(//div[text()='Sizing'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]"));
		Actions act = new Actions(log.driver);
		act.click(Elemnt).sendKeys(Keys.ARROW_UP).build().perform();
		act.click(Elemnt).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		/*act.click(Elemnt).sendKeys("Explicit", Keys.ENTER).build().perform();*/
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(25,"(//div[text()='Sizing'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]" );
		String Sizing1=log.driver.findElement(By.xpath("(//div[text()='Sizing'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText();
		Assert.assertEquals(Sizing1,"Explicit");
		System.out.println("Explicit is selected as sizing");
		test.info("Explicit is selected as sizing");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(25,"(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]")).isEnabled(), true);
		System.out.println("size in % is enabled");
		test.info("size in % is enabled");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(5,"(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]");
		log.driver.findElement(By.xpath("(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]")).sendKeys(Keys.BACK_SPACE);
		log.driver.findElement(By.xpath("(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]")).sendKeys(Keys.BACK_SPACE);
		log.driver.findElement(By.xpath("(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]")).sendKeys(Keys.BACK_SPACE);
		waits.waitUntil_Elmentis_visibilityOfElement(5,"(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]");
		log.driver.findElement(By.xpath("(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]")).sendKeys("200");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]");
		String entered_value= log.driver.findElement(By.xpath("(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]")).getAttribute("value");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		try
		{
			if(log.driver.findElement(By.xpath("(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]")).isDisplayed())
			{
				waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
				log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
				Thread.sleep(2000);
			}
			
		}catch(Exception ex)
		{
			
		}
		
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Name and Description']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Image Layout");
		Thread.sleep(1000);
		
		String Dataviewwinbtn2[]= {"<< Back","Finish","Cancel","Help"};
		List<WebElement> btnlist2 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		int buttonlistsize2 = btnlist2.size();
		for(int i =0;i<=buttonlistsize2-1;i++) 
		{
			assertEquals(Dataviewwinbtn2[i], btnlist2.get(i).getAttribute("value"));
			System.out.println(btnlist2.get(i).getAttribute("value"));
			test.info(btnlist2.get(i).getAttribute("value"));
		}
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(3000);
		
		try
		{
			if(log.driver.findElement(By.xpath("(//*[.='TestCase_24529_ImageLayout']/following::div/img)[2]")).isDisplayed())
			{
				System.out.println("Finish clicked");
			}
		}
		catch(Exception e)
		{
			log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
			Thread.sleep(3000);
		}
        
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//img[@class='w20_image ' and @width='160']");
		Assert.assertTrue(log.driver.findElement(By.xpath("//img[@class='w20_image ' and @width='160']")).isDisplayed());
		System.out.println("Image created successfully");
		test.info("Image created successfully");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//img[@class='w20_image ' and @width='160']");
		Thread.sleep(300);
		ui.rightClick("//img[@class='w20_image ' and @width='160']");
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[.='Select Image...']/../..");
		Thread.sleep(500);
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[.='Select Image...']/../..")).isDisplayed(), true);
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//span[.='Select Image...']/../..");
		List<WebElement> img_contextmenu_options =log.driver.findElements(By.xpath("//span[.='Select Image...']/../../li/span[1]"));
		for (WebElement we : img_contextmenu_options)
		{
			System.out.println(we.getText());
			test.info("context menu options is" + we.getText());
		}	
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//span[.='Select Image...']/../..");
		img_contextmenu_options.get(img_contextmenu_options.size()-1).click();
		Thread.sleep(300);
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//span[contains(text(),'Properties of')]/../..");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Properties of')]/../..")).isDisplayed(), true);
		
		//validate on image prop window
		String Nameinprop=log.driver.findElement(By.xpath("(//div[text()='Name'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td[1]/div[1]/div[1]/input[1]")).getAttribute("value");
		Assert.assertEquals(Nameinprop,"Cubeware_logo_160x42");
		System.out.println("Image Name is matching with selected image===="+Nameinprop);
		test.info("Image Name is matching with selected image===="+Nameinprop);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(25,"(//div[text()='Sizing'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]");
		String Sizinginprop=log.driver.findElement(By.xpath("(//div[text()='Sizing'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText();
		Assert.assertEquals(Sizinginprop,"Explicit");
		System.out.println("Explicit is selected as sizing");
		test.info("Explicit is selected as sizing");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]");
		String Actualsizevalue= log.driver.findElement(By.xpath("(//div[text()='Size in %'])[1]/ancestor::tr[1]/td[3]/table/tbody/tr/td/div[1]/div/input[1]")).getAttribute("value");
		Assert.assertEquals(Actualsizevalue,entered_value);
		System.out.println("Size in % is "+Actualsizevalue);
		test.info("Size in % is "+Actualsizevalue);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		log.driver.close();
		
		
		
		
		
		
		
		
		
		
		
	}
}
