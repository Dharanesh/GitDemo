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

public class TestCase_25384 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Web_Testcase_to_verify_Filters_DimensionBased_AutomaticFilters_Value_Entry_by_element_name(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_25384 : Web_Testcase to verify <Filters: Dimension Based Automatic Filters _Value Entry_by element name>");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		log.createCubeReport("//div[text()='Sales']","TestCase_25384",false);
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
		System.out.println("Iterable in General Settings is unchecked");
		test.info("Iterable in General Setting is checked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable selection by drop-down menu']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Enable selection by drop-down menu']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Enable selection by drop-down menu in Element Selection is unchecked");
		test.info("Enable selection by drop-down menu in Element Selection is checked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable value entry']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Enable value entry']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),false);
		System.out.println("Enable selection by drop-down menu in Element Selection is unchecked");
		test.info("Enable selection by drop-down menu in Element Selection is unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable value entry']/ancestor::tr[1]/td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Enable value entry']/ancestor::tr[1]/td[3]/div[1]")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable value entry']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Enable value entry']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Enable Enable value entry in Element Selection is checked");
		test.info("Enable Enable value entry menu in Element Selection is checked");
		
		WebElement navigation=log.driver.findElement(By.xpath("(//div[text()='Value entry mode'])[1]/ancestor::tr[1]/td[3]/div[1]/span[1]/span[1]/span[1]"));
		Actions act = new Actions(log.driver);
		if(navigation.getText().equals("By element name"))
		{
			System.out.println("By siblings is selected default in Value entry mode");
			test.info("By siblings is selected default in Value entry mode");
		}else
		{
			act.click(navigation).sendKeys("By element name", Keys.ENTER).build().perform();
			Thread.sleep(500);
			Assert.assertEquals(navigation.getText(),"By element name");
			System.out.println("By element name is selected  in Value entry mode");
			test.info("By element name is selected  in Value entry mode");
		}
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//button[@data-title='Expand to multi line']");
		log.driver.findElement(By.xpath("//button[@data-title='Expand to multi line']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Time'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Time'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='2015']");
		log.driver.findElement(By.xpath("//span[text()='2015']")).click();
		Thread.sleep(1000);
		String Filterval=log.driver.findElement(By.xpath("(//span[text()='Time']/following::div/div[1]/div/span)[1]/span/input")).getAttribute("value");
		System.out.println(Filterval);
		assertEquals(Filterval,"2015");
		System.out.println("2015 === Selected filter value");
		test.info("2015 === Selected filter value");

		String value_2015=log.driver.findElement(By.xpath("//div[text()='Purchase price']/ancestor::div[3]/div[4]/div[1]/div[1]/div[1]")).getText();
		System.out.println(value_2015);
		Thread.sleep(3000);
		Assert.assertTrue(value_2015.contains("179,231,928.53"));
		test.info("Cell value is:  "+value_2015);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Time'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='Time'])[1]/ancestor::div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='2014']");
		log.driver.findElement(By.xpath("//span[text()='2014']")).click();
		Thread.sleep(1000);
		String Filterval1=log.driver.findElement(By.xpath("(//span[text()='Time']/following::div/div[1]/div/span)[1]/span/input")).getAttribute("value");
		System.out.println(Filterval1);
		assertEquals(Filterval1,"2014");
		System.out.println("2014 === Selected filter value");
		test.info("2014 === Selected filter value");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Purchase price']/ancestor::div[3]/div[4]/div[1]/div[1]/div[1]");
		String value_2014=log.driver.findElement(By.xpath("//div[text()='Purchase price']/ancestor::div[3]/div[4]/div[1]/div[1]/div[1]")).getText();
		Thread.sleep(500);
		Assert.assertTrue(value_2014.contains("144,470,151.99"));
		test.info("Cell value is:  "+value_2014);
		//SaveAS
		
		log.driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
