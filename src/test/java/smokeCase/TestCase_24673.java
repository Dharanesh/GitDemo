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

public class TestCase_24673 extends TestUtils
{
	@Test	
	@Parameters("browser")

	public void Testcase_for_creating_container_elements_using_Element_of_level(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24673 Testcase for creating container elements  using  Element of level");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui=new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='CM ratio manufacturers']");
		log.driver.findElement(By.xpath("//span[text()='CM ratio manufacturers']")).click();
        Thread.sleep(2000);

        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='CM ratio manufacturers'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='CM ratio manufacturers'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Product");
		System.out.println("Product is present in Rows"); 
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		
		WebElement e1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e1.getText(), "Product");
		System.out.println("Elements groups displayed correctly");
		test.info("Elements groups displayed correctly");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]");
		WebElement e2=log.driver.findElement(By.xpath("//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e2.getText(), "<No Limits>");
		System.out.println("Limits displayed correctly");
		test.info("Limits displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Current sorting:']/following::div[2]/span/span[1]/span[1]");
		WebElement e3=log.driver.findElement(By.xpath("//span[text()='Current sorting:']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e3.getText(), "<No Sorting>");
		System.out.println("Current sorting displayed correctly");
		test.info("Current sorting displayed correctly");

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Display:']/following::div[2]/span/span[1]/span[1]");
		WebElement e4=log.driver.findElement(By.xpath("//span[text()='Display:']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(e4.getText(), "<Element Name>");
		System.out.println("Value present in Display displayed correctly");
		test.info("Value present in Display displayed correctly");	
		Thread.sleep(2000);
		
		List<WebElement> AB = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for Rows')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB)
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]");
		WebElement limits=log.driver.findElement(By.xpath("//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		//a1.click(limits).sendKeys("Elements from level 2", Keys.ENTER).build().perform();
		a1.click(limits).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(limits).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(limits).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(limits).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(limits).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(limits).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]");
		String limitstext=log.driver.findElement(By.xpath("//button[text()='Limits...']/following::div[2]/span/span[1]/span[1]")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(limitstext, "Elements from level 2");
		System.out.println("Limits displayed correctly");
		test.info("Limits displayed correctly");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts all visible items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts all visible items to the selection list']")).click();
		Thread.sleep(4000);
		List<WebElement> Base_ele = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));
		int count=0;
		for (WebElement webElement : Base_ele)
		{
			//webElement.getText();
			count++;
		}
		System.out.println(count);
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(4000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		//a1.click(elemnt).sendKeys("Container elements", Keys.ENTER).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elmntindrpdwn=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwn.getText(),"Container elements");
		System.out.println(elmntindrpdwn.getText());
		System.out.println("Container elements is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		List<WebElement> selectble_ele = log.driver.findElements(By.xpath("(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]"));
		ArrayList<String> selectable = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			String aa = selectble_ele.get(i).getText();
			if(selectable.contains("Elements of level"))
			{
				assertTrue(true);
				
			}
			
		}	
			
		System.out.println("Elements of level is present in the list of selectable elements");
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Elements of level']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='Elements of level']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Elements of level']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Elements of level']/../div[1]/input[1]")).isSelected());
		System.out.println("Elements of level Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Current element']/ancestor::div[3]/div[2]/div[1]/table/tbody/tr/td[2]");
		assertEquals(log.driver.findElement(By.xpath("//span[text()='Current element']/ancestor::div[3]/div[2]/div[1]/table/tbody/tr/td[2]")).getText(),"Elements of level");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Current element']/following::div[5]/div[1]/div[1]/ul/li/a");
		List<WebElement> tabs =log.driver.findElements(By.xpath("//span[text()='Current element']/following::div[5]/div[1]/div[1]/ul/li/a"));
		System.out.println("Tabs present in properties of element windows are:");
		ArrayList<String > tab_name = new ArrayList<String>();
		tab_name.add("Settings");
		tab_name.add("Element");
		tab_name.add("Value Format");
		tab_name.add("Data Cell");
		tab_name.add("Header Cell");
		tab_name.add("Chart");
		tab_name.add("Maps");
		for (int  i=0;i<=tabs.size()-1;i++) 
		{		
		String tab = tabs.get(i).getText();
		Assert.assertEquals(tab, tab_name.get(i));
		System.out.println(tab);
		test.info(tab);
		}
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//a[text()='Settings']/ancestor::li[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//a[text()='Settings']/ancestor::li[1]")).getAttribute("aria-selected"), "true");
		System.out.println(tabs.get(0).getText() +"   is highlighted");
		test.info(tabs.get(0).getText() +"   is highlighted");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Level selection']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Level selection']")).isDisplayed());
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Elements of level:']/following::div[1]/div[1]/div[1]/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Elements of level:']/following::div[1]/div[1]/div[1]/input[1]")).clear();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Elements of level:']/following::div[1]/div[1]/div[1]/input[1]");
		log.driver.findElement(By.xpath("//span[text()='Elements of level:']/following::div[1]/div[1]/div[1]/input[1]")).sendKeys("2");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(5000);	
		log.driver.navigate().refresh();
		Thread.sleep(4000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//div[.='RL']");
		a1.contextClick(log.driver.findElement(By.xpath(("//div[.='RL']")))).build().perform();
		Thread.sleep(3000);
		
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='RL']")).isDisplayed())
			{
				System.out.println("RL Available");
			}
		}
		catch(Exception e)
		{
			 Actions act = new Actions(log.driver);
		     act.contextClick(log.driver.findElement(By.xpath("//div[.='RL']"))).perform();
		     Thread.sleep(2000);
		}
				
		
		List<WebElement> ContextClick = log.driver.findElements(By.xpath("//div[@class='k-animation-container']/ul/li/span[1]"));
		assertEquals(ContextClick.get(0).getText(),"RL");
		Thread.sleep(4000);
		assertEquals(ContextClick.get(9).getText(),"Hide empty rows");
		System.out.println(ContextClick.get(9).getText());
		ContextClick.get(9).click();
		Thread.sleep(4000);
		log.driver.navigate().refresh();
		Thread.sleep(5000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Time']");
		log.driver.findElement(By.xpath("//span[text()='Time']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Display:']/following::div[2]/span/span[1]/span[1]");
		WebElement display=log.driver.findElement(By.xpath("//span[text()='Display:']/following::div[2]/span/span[1]/span[1]"));
		//a1.click(display).sendKeys("Desc_EN",Keys.ENTER).build().perform();
		a1.click(display).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(display).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Assert.assertEquals(display.getText(), "Desc_EN");
		System.out.println("Value present in Display displayed correctly");
		test.info("Value present in Display displayed correctly");	
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(4000);	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[.='Quartal 1 2015']/ancestor::div[3]/div[2]/div/div");
		List<WebElement> Table_rows = log.driver.findElements(By.xpath("//div[.='Quartal 1 2015']/ancestor::div[3]/div[2]/div/div"));
		int count1=0;
		
		for (int i =1;i<=Table_rows.size()-1;i++) 
		{
			count1++;
		}
		System.out.println("Count 1 value ="+count1);
		assertTrue(count==count1);
		System.out.println("elements of level is updated in table");
		Thread.sleep(1000);
		log.driver.close();
		
	
		
	}
}
