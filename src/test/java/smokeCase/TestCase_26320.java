package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertSame;
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

public class TestCase_26320 extends TestUtils
{
	@Test	
	@Parameters("browser")
	public void Testcase_to_verify_functionality_of_Analytical_Visualization_InCell_Bar_Properties(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_26320 : Web_Testcase to verify functionality of <Analytical Visualization InCell Bar_Properties>");
	    
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TestCase_InCell_Bar_Edit']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='TestCase_InCell_Bar_Edit']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='TestCase_InCell_Bar_Edit']");
		log.driver.findElement(By.xpath("//span[text()='TestCase_InCell_Bar_Edit']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='TestCase_InCell_Bar_Edit'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='TestCase_InCell_Bar_Edit'])[2]")).isDisplayed(),true);
	try{	
		if(log.driver.findElement(By.xpath("//div[text()='Used Car']")).isDisplayed())
		{
		  System.out.println("Used car is available");	
		}
		Thread.sleep(2000);
	}catch(Exception e)
	{
		Thread.sleep(2000);
		System.out.println("used car is not available");
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("InsertAllVisibleItem"));
		log.driver.findElement(By.xpath(log.getData("InsertAllVisibleItem"))).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
	}
		
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div/div");
		int size_before= log.driver.findElements(By.xpath("//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div/div")).size();
		System.out.println("incell bar in column 2015 is present for " +size_before+ " cells");
		String bar_color= log.driver.findElements(By.xpath("//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div/div")).get(0).getCssValue("background-color");
		System.out.println("bar color for incell bar is " +bar_color);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		log.driver.findElement(By.xpath("(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		ui.rightClick("(//div[text()='2014']/ancestor::div[3]/div[4]/div/div/div[1])[1]");
		Thread.sleep(2000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='//span[.='Single Data Cell']']")).isDisplayed())
			{
				System.out.println("Single Data Cell Available");
			}
		}
		catch(Exception e)
		{
			 Actions act = new Actions(log.driver);
		     act.contextClick(log.driver.findElement(By.xpath("(//div[@id='0/0'])[1]"))).perform();
		     Thread.sleep(2000);
		}
				
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Single Data Cell']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Single Data Cell']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Analytical Visualizations']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Analytical Visualizations']");
		log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Edit...']")).isDisplayed(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Edit...']");
		log.driver.findElement(By.xpath("//span[text()='Edit...']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(text(),'In-Cell Bars')])[6]");
		log.driver.findElement(By.xpath("(//span[contains(text(),'In-Cell Bars')])[6]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings for the In Cell Bar Analysis']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the In Cell Bar Analysis']")).isDisplayed(),true);
		System.out.println("Settings for the Incellbar====");
		
       if(log.driver.findElement(By.xpath("//span[text()='Settings']/ancestor::tr[1]/td[1]/a/span")).getAttribute("class").contains("minu")){
			
    	    waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Show values']/ancestor::tr/td[3]/div");
   		    Assert.assertTrue(log.driver.findElement(By.xpath("//div[text()='Show values']/ancestor::tr/td[3]/div")).isDisplayed());
			System.out.println("Settings is expanded by default");
		}
       else
       {
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings']/ancestor::tr[1]/td[1]/a/span");
			log.driver.findElement(By.xpath("//span[text()='Settings']/ancestor::tr[1]/td[1]/a/span")).click();
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Settings']/ancestor::tr[1]/td[1]/a/span");
			Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings']/ancestor::tr[1]/td[1]/a/span")).getAttribute("class").contains("minu"),true);
			
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Show values']/ancestor::tr/td[3]/div");
			Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Show values']/ancestor::tr/td[3]/div")).isDisplayed(),true);
			System.out.println("settings got expanded");
		}
		
       waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Show values']/ancestor::tr/td[3]/div");
	   Assert.assertTrue(log.driver.findElement(By.xpath("//div[text()='Show values']/ancestor::tr/td[3]//input")).isSelected());
	   System.out.println("Show values is selected");
	   test.info("Show values is selected");
	   Thread.sleep(2000);
	   //Shortest bar
	   waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Shortest bar']");
	   log.driver.findElement(By.xpath("//div[text()='Shortest bar']")).click();
	   Thread.sleep(2000);
	   
	   WebElement Shortest_bar=log.driver.findElement(By.xpath("//div[text()='Shortest bar']/../../../td[3]/div/span[1]/span[1]/span[1]"));
	   Actions a1=new Actions(log.driver);
	  // a1.click(Shortest_bar).sendKeys("Value", Keys.ENTER).build().perform();
	   a1.click(Shortest_bar).sendKeys(Keys.ARROW_DOWN).build().perform();
	   a1.click(Shortest_bar).sendKeys(Keys.ENTER).build().perform();
	   Thread.sleep(2000);
	
       System.out.println(log.driver.findElement(By.xpath("//div[text()='Shortest bar']/../../../td[3]/div/span[1]/span[1]/span[1]")).getText());
	   Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Shortest bar']/../../../td[3]/div/span[1]/span[1]/span[1]")).getText(),"Value");
	 
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Shortest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]");
	   Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Shortest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]")).isEnabled(),true);
		
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Shortest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]");
	   String Shortestvalue=log.driver.findElement(By.xpath("//div[text()='Shortest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]")).getAttribute("value");
	   Assert.assertEquals(Shortestvalue,"0.00");
	   
	   
	   //longest bar
	   waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Longest bar']");
	   log.driver.findElement(By.xpath("//div[text()='Longest bar']")).click();
	   Thread.sleep(2000);
	   
	   WebElement Longest_bar=log.driver.findElement(By.xpath("//div[text()='Longest bar']/../../../td[3]/div/span[1]/span[1]/span[1]"));
	  // a1.click(Longest_bar).sendKeys("Value", Keys.ENTER).build().perform();
	   a1.click(Longest_bar).sendKeys(Keys.ARROW_DOWN).build().perform();
	   a1.click(Longest_bar).sendKeys(Keys.ENTER).build().perform();
	   Thread.sleep(2000);
       System.out.println(log.driver.findElement(By.xpath("//div[text()='Longest bar']/../../../td[3]/div/span[1]/span[1]/span[1]")).getText());
	   Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Longest bar']/../../../td[3]/div/span[1]/span[1]/span[1]")).getText(),"Value");
	 
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Longest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]");
	   Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Longest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]")).isEnabled(),true);
		
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Longest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]");
	   String Largestvalue=log.driver.findElement(By.xpath("//div[text()='Longest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]")).getAttribute("value");
	   Assert.assertEquals(Largestvalue,"0.00");
	   
	   waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Shortest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]");
	   log.driver.findElement(By.xpath("//div[text()='Shortest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Shortest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]");
		WebElement Shortestbarval=log.driver.findElement(By.xpath("//div[text()='Shortest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]"));
		Shortestbarval.click();
		Shortestbarval.sendKeys(Keys.CONTROL + "a");
		Shortestbarval.sendKeys(Keys.DELETE);
		Shortestbarval.sendKeys("1027536.70");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Longest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]");
		WebElement lonestbarval=log.driver.findElement(By.xpath("//div[text()='Longest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]"));
		lonestbarval.click();
		lonestbarval.sendKeys(Keys.CONTROL + "a");
		lonestbarval.sendKeys(Keys.DELETE);
		lonestbarval.sendKeys("141506048.39");
		
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Shortest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Shortest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]")).getAttribute("value"), "1027536.70");
		
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Longest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Longest bar value']/../../../td[3]//td[1]/div[1]/div[1]/input[1]")).getAttribute("value"), "141506048.39");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Longest bar value']");
		log.driver.findElement(By.xpath("//div[text()='Longest bar value']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Name and Description']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed(),true);
		
//		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
//		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("");
		
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
		Thread.sleep(2000);

		try
		{
		  if(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed())
		  {
			  waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
			  log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
			  Thread.sleep(2000);

		  }
		}catch(Exception e)
		{
			
		}
//		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div/div");
		System.out.println("no of cells for which incell bars are displayed in column 2015 after properties edit for longest and shortest value are :  "+log.driver.findElements(By.xpath("//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div/div")).size());
		assertSame(log.driver.findElements(By.xpath("//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div/div")).size(),size_before);
		System.out.println("longest and shortest properties changed applied successfully");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div/div");
		assertEquals(bar_color, log.driver.findElements(By.xpath("//div[text()='All Categories']/ancestor::div[4]/div/div[4]/div/div/div/div")).get(0).getCssValue("background-color"));
		System.out.println("properties changes applied succesfully");
	  
		
		log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).click();
		Thread.sleep(3000);
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Save changes?')]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Yes']");
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
		
		Actions act1=new Actions(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='TestCase_InCell_Bar_Edit'])[1]/ancestor::div[1]/span[1]");
		log.driver.findElement(By.xpath("(//span[text()='TestCase_InCell_Bar_Edit'])[1]/ancestor::div[1]/span[1]")).click();
		Thread.sleep(3000);
		
		act1.contextClick(log.driver.findElement(By.xpath("(//span[text()='TestCase_InCell_Bar_Edit'])[1]"))).perform();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
		Thread.sleep(2000);
	
        log.driver.close();
	   
		
	}
}
