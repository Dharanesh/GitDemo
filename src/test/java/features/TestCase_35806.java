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

public class TestCase_35806 extends TestUtils
{
	@Test
	@Parameters("browser")
	public void Filter_LL_Value_By_Entry_Enter_LAST_element_into_filter_from_the_list(String browser) throws Exception
	{
		test =extent.createTest("TestCase_35806: Filter_LL_Value By Entry_Enter LAST element into filter from the list");
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

		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//span[text()='Product'])[1]");
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Product'])[1]")).isDisplayed());
		action.contextClick(log.driver.findElement(By.xpath(("(//span[text()='Product'])[1]")))).build().perform();
		Thread.sleep(2000);

		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Enable selection by drop-down menu')]/span[1]")).getAttribute("class").contains("checkbox-checked"));
	    waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[contains(text(),'Enable selection by drop-down menu')]/span[1]");
	    System.out.println("Enable selection by drop-down menu Checkbox is Checked");
	    
	    try
		{
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[contains(text(),'Enable value entry')]");
			assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Enable value entry')]/span[1]")).isDisplayed(),true);
			Thread.sleep(1000);	
			assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Enable value entry')]/span[1]")).isSelected(),true);
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[contains(text(),'Enable value entry')]/span[1]");
			System.out.println("Enable Enable value entry Checkbox is Checked");
		}
		catch(Exception e)
		{
			System.out.println("Enable Enable value entry Checkbox is UnChecked==Check it");	
			waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[contains(text(),'Enable value entry')]");
			log.driver.findElement(By.xpath("//span[contains(text(),'Enable value entry')]")).click();
	        Thread.sleep(2000);
	        System.out.println("Enable Enable value entry Checkbox is Checked");
		}
		
	    //======================
	    String val = log.driver.findElement(By.xpath("(//div[text()='Sales'])[1]/ancestor::div[3]/div[4]/div/div[1]/div[1]")).getText();
		Assert.assertTrue(val.contains("€4,487,283.40"));
		
	    //=======================
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Product'])[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div/span/span/span")).isDisplayed());
		System.out.println("filter dropdown icon is Enabled");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div/span/span/span");
		log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div/span/span/span")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[@class='cw_filter_header']/input)[1]/ancestor::div[2]/div[2]//li//span[2]");
		List<WebElement> NoOfFilterSrchElmt = log.driver.findElements(By.xpath("(//div[@class='cw_filter_header']/input)[1]/ancestor::div[2]/div[2]//li//span[2]"));
		int counttab1=0;
		for(int i=0;i<=NoOfFilterSrchElmt.size()-1;i++)
		{
			String string=NoOfFilterSrchElmt.get(i).getText();
			//System.out.println("String is=== "+string);
			//test.info("String is=== "+string);
			//Thread.sleep(1000);
			counttab1++;
		
		}
		System.out.println("List of elements for the filter Searched in Filter search ====="+counttab1);
		test.info("List of elements for the filter Searched in Filter search ====="+counttab1);
		Thread.sleep(1000);
		
		String string=NoOfFilterSrchElmt.get(0).getText();
		System.out.println("String is=== "+string);
		test.info("String is=== "+string);
		Thread.sleep(1000);
		Assert.assertTrue(NoOfFilterSrchElmt.get(0).getAttribute("class").contains("k-state-selected"));
		System.out.println("keyboard control is on the first element =="+NoOfFilterSrchElmt.get(0).getText());
		test.info("keyboard control is on the first element== "+NoOfFilterSrchElmt.get(0).getText());
		Thread.sleep(1000);
	
		NoOfFilterSrchElmt.get(NoOfFilterSrchElmt.size()-1).click();
		Thread.sleep(1000);
		
		String val1 = log.driver.findElement(By.xpath("(//div[text()='Sales'])[1]/ancestor::div[3]/div[4]/div/div[1]/div[1]")).getText();
		System.out.println(val1);
		Assert.assertTrue(val1.equals("€259,907.05"));
				
				
		String filterselval = log.driver.findElement(By.xpath("(//span[text()='Product'])[1]/ancestor::div[3]/div[2]/div[1]/div/span/span/input")).getAttribute("value");
		System.out.println(filterselval);
		Assert.assertTrue(filterselval.equals("Volvo"));		
		System.out.println("currently Selected element is===="+filterselval);
		test.info("currently Selected element is===="+filterselval);
		
		
		log.driver.close();
		
		
	}
}
