package smokeCase;

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

public class TestCase_25380 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Web_Testcase_to_verify_Filters_Automatic_Filter_Properties_Visibility(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_25380 : Web_Testcase to verify <Filters: Automatic Filter Properties_Visibility>");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[text()='Sales']","TC_25380_AutomaticFilter_Properties",false);
		System.out.println("report created using Training Sales cube");
		test.info("report created using Training Sales cube");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Components']");
		log.driver.findElement(By.xpath("//span[text()='Components']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//*[text()='Automatic Filters'])[1]");
		assertTrue(log.driver.findElement(By.xpath("(//*[text()='Automatic Filters'])[1]")).isDisplayed());
		System.out.println("Automatic Filter Available");
		test.info("Automatic Filter Available");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//*[text()='Automatic Filters'])[1]/preceding::div[1]/a[1]/span[1]");
		log.driver.findElement(By.xpath("(//*[text()='Automatic Filters'])[1]/preceding::div[1]/a[1]/span[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[contains(text(),'Time.Time - [Time]')]");
		assertTrue(log.driver.findElement(By.xpath("//div[contains(text(),'Time.Time - [Time]')]")).isDisplayed());
		System.out.println("Time.Time Automatic Filter Available");
		test.info("Time.Time Filter Available");
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[contains(text(),'Time.Time - [Time]')]");
		ui.rightClick("//div[contains(text(),'Time.Time - [Time]')]");
		Thread.sleep(1000);
		
		
		ArrayList<String> filterContextClickbtn = new ArrayList<String>();
		filterContextClickbtn.add("Time.Time");
		filterContextClickbtn.add("Select Elements...");
		filterContextClickbtn.add("Properties...");
		
		List<WebElement>Timefiltr=log.driver.findElements(By.xpath("//span[text()='Time.Time']/ancestor::ul[1]/li/span[1]"));
		for (int i =0;i<Timefiltr.size()-1;i++) 
		{
            assertEquals(Timefiltr.get(i).getText(),filterContextClickbtn.get(i));
			System.out.println(Timefiltr.get(i).getText());
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Select Elements...']");
		log.driver.findElement(By.xpath("//*[text()='Select Elements...']")).click();
		Thread.sleep(500);
		
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e1.getText(), "Time");
		System.out.println("Elements groups displayed correctly");
		test.info("Elements groups displayed correctly");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]");
		WebElement e2=log.driver.findElement(By.xpath("//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e2.getText(), "<No Limits>");
		System.out.println("Limits displayed correctly");
		test.info("Limits displayed correctly");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Display:']/following::div[2]/span/span[1]/span[1]");
		WebElement e4=log.driver.findElement(By.xpath("//span[text()='Display:']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e4.getText(), "<Element Name>");
		System.out.println("Value present in Display displayed correctly");
		test.info("Value present in Display displayed correctly");	
		Thread.sleep(2000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Properties...']");
		log.driver.findElement(By.xpath("//*[text()='Properties...']")).click();
		Thread.sleep(500);
		
		
		System.out.println("Property window texts are:");
		test.info("Property window texts are:");
		List<WebElement> PropWindowList = log.driver.findElements(By.xpath("(//table[@class='prg'])[1]/tbody/tr/td[2]/a/span[1]"));
		
		ArrayList<String> propWinText = new ArrayList<String>();
	    propWinText.add("General Settings");
	    propWinText.add("Element Selection");
	    propWinText.add("Global Filter");
		
		for (int i =0;i<=PropWindowList.size()-1;i++) 
		{
			assertEquals(PropWindowList.get(i).getText(),propWinText.get(i));
			System.out.println(PropWindowList.get(i).getText());
			test.info(PropWindowList.get(i).getText());
		}	
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Visible in General Settings is checked");
		test.info("Visible in General Setting is checked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Iterable']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Iterable']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Iterable in General Settings is checked");
		test.info("Iterable in General Setting is checked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable selection by drop-down menu']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Enable selection by drop-down menu']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Enable selection by drop-down menu  is checked");
		test.info("Enable selection by drop-down menu  is checked");
		
		log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]")).click();
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),false);
		System.out.println("Visible in  General Setting is unchecked");
		test.info("Visible in  General Setting is unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//button[@data-title='Expand to multi line']");
		log.driver.findElement(By.xpath("//button[@data-title='Expand to multi line']")).click();
		Thread.sleep(2000);
		
		List<WebElement>filter = log.driver.findElements(By.xpath("(//span[text()='TC_25380_AutomaticFilter_Properties'])[1]/following::div[@class='ellipsisText']/span[1]"));
 		for(int i  =0;i<filter.size();i++)
 		{
 			if(filter.get(i).getText().equalsIgnoreCase("Time"))
 			assertTrue(false);
 	 		Thread.sleep(500);

 		}
 		System.out.println("Time filter not found");
		test.info("Time filter not found");
		
 		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[contains(text(),'Time.Time - [Time]')]");
		ui.rightClick("//div[contains(text(),'Time.Time - [Time]')]");
		Thread.sleep(1000);
 		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Select Elements...']");
		log.driver.findElement(By.xpath("//*[text()='Select Elements...']")).click();
		Thread.sleep(500);
 		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Properties...']");
		log.driver.findElement(By.xpath("//*[text()='Properties...']")).click();
		Thread.sleep(500);
 		
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),false);
		System.out.println("Visible in  General Setting is unchecked");
		test.info("Visible in  General Setting is unchecked");
		log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Visible in General Settings is checked");
		test.info("Visible in General Setting is checked");
 		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		List<WebElement>filter1 = log.driver.findElements(By.xpath("(//span[text()='TC_25380_AutomaticFilter_Properties'])[1]/following::div[@class='ellipsisText']/span[1]"));
 		for(int i  =0;i<filter1.size();i++)
 		{
 			if(filter1.get(i).getText().equalsIgnoreCase("Time"))
 			assertTrue(true);
 	 		Thread.sleep(500);

 		}
 		System.out.println("Time filter found");
		test.info("Time filter found");
		
 		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[contains(text(),'Time.Time - [Time]')]");
		ui.rightClick("//div[contains(text(),'Time.Time - [Time]')]");
		Thread.sleep(1000);
 		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//*[text()='Select Elements...']");
		log.driver.findElement(By.xpath("//*[text()='Select Elements...']")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='2014']/preceding::div[1]");
		log.driver.findElement(By.xpath("//div[text()='2014']/preceding::div[1]")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='2014']/preceding::div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='2014']/preceding::div[1]/input[1]")).isSelected(),true);
		System.out.println("2014 is Selected");
		test.info("2014 is Selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		String Filterval=log.driver.findElement(By.xpath("(//span[text()='Time']/following::div/div[1]/div/span)[1]/span/input")).getAttribute("value");
		System.out.println(Filterval);
		assertEquals(Filterval,"2014");
		System.out.println("2014 === Selected filter value");
		test.info("2014 === Selected filter value");
		
		log.driver.close();
	}
}
