package features;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

public class TestCase_35809 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Filter_LL_Search_bar_entry_Enter_valid_input_ending_with_wildcard(String browser) throws Exception
	{
		test =extent.createTest("TestCase_35809: Filter_LL_Search bar entry_Enter valid input starting with *(wildcard)");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		Actions action = new Actions(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Analysis of countries/quarters']");
		log.driver.findElement(By.xpath("//span[text()='Analysis of countries/quarters']")).click();
        Thread.sleep(2000);
        
        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Analysis of countries/quarters'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Analysis of countries/quarters'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		System.out.println("Report opened");
		test.info("Report opened");
		
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
		
		
	    
	    waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Product'])[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("((//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div//span)[3]")).isDisplayed());
		System.out.println("filter dropdown icon is Enabled");
		test.info("filter dropdown icon is Enabled");	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "((//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div//span)[3]");
		log.driver.findElement(By.xpath("((//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div//span)[3]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[@class='cw_filter_header']/input)[1]/ancestor::div[2]/div[2]//li/div/span[2]");
		List<WebElement> CountOfFilterSrchElmt = log.driver.findElements(By.xpath("(//div[@class='cw_filter_header']/input)[1]/ancestor::div[2]/div[2]//li/div/span[2]"));
		int counttab=0;
		for(int i=0;i<=CountOfFilterSrchElmt.size()-1;i++)
		{
			//System.out.println(CountOfFilterSrchElmt.get(i).getText());
			counttab++;
		}
		System.out.println("List of elements for the filter displayed in the drop down context menu====="+counttab);
	    test.info("List of elements for the filter displayed in the drop down context menu====="+counttab);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[@class='cw_filter_header']/input)[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[1]")).isEnabled());
		System.out.println("filter Search is Enabled");
		test.info("filter Search is Enabled");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[1]")).getAttribute("placeholder").contains("Type here to search..."));

		
		log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[1]")).sendKeys("*A");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[@class='cw_filter_header']/input)[1]/../../div[@class='searchinfo']");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[1]/../../div[@class='searchinfo']")).getText().contains("Showing results for"));
		System.out.println(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[1]/../../div[@class='searchinfo']")).getText());
		test.info(log.driver.findElement(By.xpath("(//div[@class='cw_filter_header']/input)[1]/../../div[@class='searchinfo']")).getText());
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[@class='cw_filter_header']/input)[1]/ancestor::div[2]/div[3]//li/div/span");
		List<WebElement> NoOfFilterSrchElmt1 = log.driver.findElements(By.xpath("(//div[@class='cw_filter_header']/input)[1]/ancestor::div[2]/div[3]//li/div/span"));
		int count=0;
		for(int i=0;i<=NoOfFilterSrchElmt1.size()-1;i++)
		{
			String string=NoOfFilterSrchElmt1.get(i).getText();
			System.out.println("String is=== "+string);
			test.info("String is=== "+string);
		
			if(string.length()>0)
			{
				int length=string.length();
				char LastChar=string.charAt(length-1);
				if(LastChar==Character.toUpperCase('A')||LastChar==Character.toLowerCase('A'))
				{
					System.out.println("String Ends with Char=== "+LastChar);
					test.info("String Ends with Char=== "+LastChar);	
				}
				
			}
		
			count++;
		
		}
		System.out.println("List of elements for the filter Searched in Filter search ====="+count);
		test.info("List of elements for the filter Searched in Filter search ====="+count);
		
		
			
		
	}
}
