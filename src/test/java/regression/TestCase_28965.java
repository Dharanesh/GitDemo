package regression;

import static org.testng.Assert.assertTrue;

import java.util.List;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_28965 extends TestUtils
{
	@Test	
	@Parameters("browser")
	public void Testcase_to_verify_ClientRules_priority_check_with_Collision_handling(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_28965 : 14453 : Cockpit Client Rules priority check with Collision handling");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Client Rules priority check']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Client Rules priority check']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Client Rules priority check']");
		log.driver.findElement(By.xpath("//span[text()='Client Rules priority check']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Client Rules priority check'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Client Rules priority check'])[2]")).isDisplayed(),true);
		
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SumOfSDL Exoten']/ancestor::div[4]/div/div[4]/div/div[10]/div");
		List<WebElement> value = log.driver.findElements(By.xpath("//div[text()='SumOfSDL Exoten']/ancestor::div[4]/div/div[4]/div/div[10]/div"));;
		
		for(int i =0;i<=value.size()-1;i++)
		{
			String aa = value.get(i).getText();
			System.out.println(aa);
		}
		
		assertTrue(value.get(value.size()-1).getText().isEmpty());
		System.out.println("The table has one empty cell");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Deselect all visible items'])[2]");
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='SumOfSDL Exoten'])[1]");
		log.driver.findElement(By.xpath("(//div[text()='SumOfSDL Exoten'])[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Collision']/../../../td[1]/a/span");
		if(log.driver.findElement(By.xpath("//span[text()='Collision']/../../../td[1]/a/span")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Collision']/../../../td[1]/a/span");
			log.driver.findElement(By.xpath("//span[text()='Collision']/../../../td[1]/a/span")).click();
			System.out.println("Priority button got expanded");
			test.info("Priority button got expanded");
		}else{
			System.out.println("Priority button expanded by default");
			test.info("Priority button expanded by default");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]/input")).isSelected(), true);
		System.out.println("No calculation at collision with rule elements checkbox is selected by default");
		test.info("No calculation at collision with rule elements checkbox is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]/input")).isSelected(), false);
		System.out.println("No calculation at collision with rule elements checkbox is deselected");
		test.info("No calculation at collision with rule elements checkbox is deselected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(), "Time");
		System.out.println("Time is added in Columns");
		test.info("Time is added in Columns");
		
		log.driver.findElement(By.xpath(log.getData("Columns_Value"))).click();
		Thread.sleep(2000);
	    waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Dimension_Header"));
	    assertTrue(log.driver.findElement(By.xpath(log.getData("Columns_Dimension_Header"))).isDisplayed());
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Deselect all visible items'])[2]");
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Q1+Q2 Exoten'])[2]");
		log.driver.findElement(By.xpath("(//div[text()='Q1+Q2 Exoten'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Collision']/../../../td[1]/a/span");
		if(log.driver.findElement(By.xpath("//span[text()='Collision']/../../../td[1]/a/span")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Collision']/../../../td[1]/a/span");
			log.driver.findElement(By.xpath("//span[text()='Collision']/../../../td[1]/a/span")).click();
			System.out.println("Priority button got expanded");
			test.info("Priority button got expanded");
		}else{
			System.out.println("Priority button expanded by default");
			test.info("Priority button expanded by default");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]/input")).isSelected(), true);
		System.out.println("No calculation at collision with rule elements checkbox is selected by default");
		test.info("No calculation at collision with rule elements checkbox is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='No calculation at collision with rule elements']/../../../td[3]/div[1]/input")).isSelected(), false);
		System.out.println("No calculation at collision with rule elements checkbox is deselected");
		test.info("No calculation at collision with rule elements checkbox is deselected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed())
			{
				waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
				log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
				Thread.sleep(2000);
			}
			
		}catch(Exception e)
		{
			
		}
		
		//change priority
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Deselect all visible items'])[2]");
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='SumOfSDL Exoten'])[1]");
		log.driver.findElement(By.xpath("(//div[text()='SumOfSDL Exoten'])[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), true);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys(Keys.BACK_SPACE);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys("2");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(), "Time");
		System.out.println("Time is added in Columns");
		test.info("Time is added in Columns");
		
		log.driver.findElement(By.xpath(log.getData("Columns_Value"))).click();
		Thread.sleep(2000);
	    waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Dimension_Header"));
	    assertTrue(log.driver.findElement(By.xpath(log.getData("Columns_Dimension_Header"))).isDisplayed());
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"(//button[@data-title='Deselect all visible items'])[2]");
 		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
 		Thread.sleep(1000);
 		
 		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Q1+Q2 Exoten'])[2]");
 		log.driver.findElement(By.xpath("(//div[text()='Q1+Q2 Exoten'])[2]")).click();
 		Thread.sleep(1000);
 		
 		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
 		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
 		Thread.sleep(1000);
 		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
 		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
 		
 		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), true);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys(Keys.BACK_SPACE);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys("1");
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed())
			{
				waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
				log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
				Thread.sleep(2000);
			}
			
		}catch(Exception e)
		{
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
