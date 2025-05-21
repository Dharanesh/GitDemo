package features;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

public class TestCase_35672 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Filter_LL_verify_text_showing_result_for_after_a_search_is_been_done_ENG(String browser) throws Exception
	{
		test =extent.createTest("TestCase_35672: Filter_LL_verify text showing result for ----after a search is been done (ENG)");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		Actions action = new Actions(log.driver);
		
		log.createCubeReport("//div[text()='A - Training Sales']","TestCase_35672",false);
		System.out.println("report created using Training Sales cube");
		test.info("report created using Training Sales cube");
		
		//check for Enable selection by drop-down menu
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//span[text()='Product'])[1]");
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Product'])[1]")).isDisplayed());
		action.contextClick(log.driver.findElement(By.xpath(("(//span[text()='Product'])[1]")))).build().perform();
		Thread.sleep(2000);
		
		List<WebElement> ContextClick = log.driver.findElements(By.xpath("//div[@class='k-animation-container']/ul/li/span[1]"));
		assertEquals(ContextClick.get(0).getText(),"Product");
		Thread.sleep(2000);
		
		try
		{
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[contains(text(),'Enable selection by drop-down menu')]");
			assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Enable selection by drop-down menu')]/span[1]")).isDisplayed(),true);
			Thread.sleep(1000);	
			assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Enable selection by drop-down menu')]/span[1]")).getAttribute("class").contains("checkbox-checked"));
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[contains(text(),'Enable selection by drop-down menu')]/span[1]");
			System.out.println("Enable selection by drop-down menu Checkbox is Checked");
			test.info("Enable selection by drop-down menu Checkbox is Checked");
		}
		catch(Exception e)
		{
			System.out.println("Enable selection by drop-down menu Checkbox is UnChecked==Check it");	
			test.info("Enable selection by drop-down menu Checkbox is UnChecked==Check it");	
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[contains(text(),'Enable selection by drop-down menu')]");
			log.driver.findElement(By.xpath("//span[contains(text(),'Enable selection by drop-down menu')]")).click();
	        Thread.sleep(2000);
	        
		}
		
		
		
		try
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Product'])[1]");
			Assert.assertTrue(log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div/span/span/span")).isDisplayed());
			System.out.println("filter dropdown icon is========Enabled");
				
			waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div/span/span/span");
			log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div/span/span/span")).click();
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			waits.waitUntil_Elmentis_visibilityOfElement(30,"(//span[text()='TestCase_35672'])[1]");
			log.driver.findElement(By.xpath("(//span[text()='TestCase_35672'])[1]")).click();
	        Thread.sleep(2000);
			waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Product'])[1]");
			Assert.assertTrue(log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div/span/span/span")).isDisplayed());
			System.out.println("filter dropdown icon is Enabled");
				
			waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div/span/span/span");
			log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div/span/span/span")).click();
			Thread.sleep(2000);
		}
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[@class='cw_filter_header']/input)[3]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]")).isEnabled());
		System.out.println("filter Search is Enabled");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]")).getAttribute("placeholder").contains("Type here to search..."));
		
		log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]")).sendKeys("Audi");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[@class='cw_filter_header']/input)[3]/../../div[@class='searchinfo']");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]/../../div[@class='searchinfo']")).getText().contains("Showing results for 'Audi'"));
		System.out.println(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]/../../div[@class='searchinfo']")).getText());
		Thread.sleep(200);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[@class='cw_filter_header']/input)[3]/ancestor::div[2]/div[3]//li/div/span");
		List<WebElement> NoOfFilterSrchElmt = log.driver.findElements(By.xpath("(//div[@class='cw_filter_header']/input)[3]/ancestor::div[2]/div[3]//li/div/span"));
		int counttab1=0;
		for(int i=0;i<=NoOfFilterSrchElmt.size()-1;i++)
		{
			System.out.println(NoOfFilterSrchElmt.get(i).getText());
			counttab1++;
			if(NoOfFilterSrchElmt.get(i).getText().equals("Audi"))
			{
				//NoOfFilterSrchElmt.get(i).click();
				assertTrue(true);
				Thread.sleep(1000);
	  	    }
		}
		System.out.println("List of elements for the filter Searched in Filter search ====="+counttab1);
		
		log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]")).click();
		log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]")).clear();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
			
		log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]")).sendKeys("ABCD");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[@class='cw_filter_header']/input)[3]/../../div[@class='searchinfo']");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]/../../div[@class='searchinfo']")).getText().contains("Showing results for 'ABCD'"));
		System.out.println(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]/../../div[@class='searchinfo']")).getText());
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[@class='cw_filter_header']/input)[3]/../../div[@class='searchinfo']/../div[4]/div[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]/../../div[@class='searchinfo']/../div[4]/div[1]")).getText().contains("NO DATA FOUND"));
		System.out.println(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[3]/../../div[@class='searchinfo']/../div[4]/div[1]")).getText());
		
		log.driver.close();
		
		
	}
}
