package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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

public class TestCase_25529 extends TestUtils {
	@Parameters("browser")
	public void Testcase_for_creatingContainerelement_SDl_Aggregation(String browser) throws Exception
	{

		test =extent.createTest("TestCase_25529_Testcase for creating Container element SDl - Aggregation");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui=new Utils(log.driver);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='CM ratio manufacturers']");
		log.driver.findElement(By.xpath("//span[text()='CM ratio manufacturers']")).click();
        Thread.sleep(1000);

        waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='CM ratio manufacturers'])[2]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='CM ratio manufacturers'])[2]")).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Dataview Designer']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Dataview Designer']")).isDisplayed(),true);
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Product");
		System.out.println("Product is present in Rows");
		test.info("Product is present in Rows");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
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
		Thread.sleep(1000);
		List<WebElement> AB = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for Rows')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : AB)
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isEnabled(),true);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Element Groups...']");
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
       try{
			for(int i=0;i<=SelectableElementvalue.size()-1;i++)
			{
				String valueofcontainerele =SelectableElementvalue.get(i).getText();
				System.out.println(valueofcontainerele);

				if(valueofcontainerele.contains("Limousines SDl"))
				{
					System.out.println("Limousines SDl is present");
					test.info("Limousines SDl is present");
					
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Limousines SDl']");
					log.driver.findElement(By.xpath("//span[text()='Limousines SDl']")).click();
					Thread.sleep(1000);
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Delete']");
					log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
					Thread.sleep(1000);
					waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Yes']");
					log.driver.findElement(By.xpath("//input[@value='Yes']")).click();
					System.out.println("deletion done");
					break;
				}
				else
				{
					System.out.println("not found");
				}
				
			}
			
		}
		
		catch(Exception e)
		{
		System.out.println("Create new container element");
		}
        Thread.sleep(1000);
		
		
        waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='New...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='New...']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='New...']");
		log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='New Element']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='New Element']")).isDisplayed(),true);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Available element types:']/following::div[2]/div/div[1]");
		List<WebElement> ElementGrp = log.driver.findElements(By.xpath("//span[text()='Available element types:']/following::div[2]/div/div[1]"));
		ArrayList<String> ElegroupValue= new ArrayList<String>();
		System.out.println("Element Group option values");
		ElegroupValue.add("Criteria DDL");
		ElegroupValue.add("Data DDL");
		ElegroupValue.add("Script DDL");
		ElegroupValue.add("Standard SDL");

		for(int i =0;i<=ElementGrp.size()-1;i++) 
		{
			assertEquals(ElementGrp.get(i).getText(), ElegroupValue.get(i));
			System.out.println(ElementGrp.get(i).getText());

		}
		Thread.sleep(1000);
		assertTrue(log.driver.findElement(By.xpath("(//span[text()='Available element types:']/following::div[2]/div/div[1])[1]")).getCssValue("background-color").contains("255, 212, 0"), "Criteria DDL not got higlighted");
		System.out.println("Criteria DDL got highlighted");
	
		Thread.sleep(500);
		ElementGrp.get(3).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'New SDL')]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'New SDL')]")).isDisplayed(),true);
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[.='Name']/ancestor::div[3]/div[2]/div/div/input");
	    log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).sendKeys("Limousines SDl");
	    Thread.sleep(500);
	    
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		try
		{
			if(log.driver.findElement(By.xpath("//span[.='Name']/ancestor::div[3]/div[2]/div/div/input")).isDisplayed())
			{
		       log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		       Thread.sleep(2000);
			}
		}catch(Exception ex)
		{
			
		}
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Selection']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Selection']")).isDisplayed(),true);
        
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Selection...']");
		log.driver.findElement(By.xpath("//button[text()='Selection...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Acura']/../div[2]");
		log.driver.findElement(By.xpath("//div[text()='Acura']/../div[2]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Alfa Romeo']/../div[2]");
		log.driver.findElement(By.xpath("//div[text()='Alfa Romeo']/../div[2]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Bentley']/../div[2]");
		log.driver.findElement(By.xpath("//div[text()='Bentley']/../div[2]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Cadillac']/../div[2]");
		log.driver.findElement(By.xpath("//div[text()='Cadillac']/../div[2]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Daewoo']/../div[2]");
		log.driver.findElement(By.xpath("//div[text()='Daewoo']/../div[2]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
        
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div/div[2]");
		List<WebElement> Beforeselectble_ele_Count = log.driver.findElements(By.xpath("(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div/div[2]"));//step 24
		int count=Beforeselectble_ele_Count.size();
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Element Selection')]/ancestor::div[3]/div[2]//div[1]/div[1]//div[1]/div/div");
		List<WebElement> selectble_ele_Count = log.driver.findElements(By.xpath("//span[contains(text(),'Element Selection')]/ancestor::div[3]/div[2]//div[1]/div[1]//div[1]/div/div"));
		int ElemCount=selectble_ele_Count.size();
		assertEquals(count,ElemCount);
		System.out.println(ElemCount+"No of element selected");
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Selection']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Selection']")).isDisplayed(),true);
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Activate aggregation'])[1]/../../td[1]");
		assertFalse(log.driver.findElement(By.xpath("(//label[text()='Activate aggregation'])[1]/../../td[1]/input")).isSelected());
		System.out.println("Activate aggregation is unchecked");
		test.info("Activate aggregation is unchecked");
		Thread.sleep(200);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Activate aggregation'])[1]");
		log.driver.findElement(By.xpath("(//label[text()='Activate aggregation'])[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//label[text()='Activate aggregation'])[1]/../../td[1]");
		assertTrue(log.driver.findElement(By.xpath("(//label[text()='Activate aggregation'])[1]/../../td[1]/input")).isSelected());
		System.out.println("Activate aggregation is checked");
		test.info("Activate aggregation is checked");
		Thread.sleep(200);
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
        
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]");
		List<WebElement>SelectableElementvalue1 = log.driver.findElements(By.xpath("//span[text()='Elements']/ancestor::div[3]/div[4]/div[1]/div[1]/ul/li/div/span[1]/span[2]"));	
		
        
		for(int i=0;i<=SelectableElementvalue1.size()-1;i++)
		{
			String valueofcontainerele1 =SelectableElementvalue1.get(i).getText();
			System.out.println(valueofcontainerele1);
			Thread.sleep(1000);
			if(valueofcontainerele1.contains("Limousines SDl"))
			{
				System.out.println("Limousines SDl is present");
				test.info("Limousines SDl is present");
				
				waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Limousines SDl']");
				log.driver.findElement(By.xpath("//span[text()='Limousines SDl']")).click();
				Thread.sleep(1000);
				waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[text()='Edit...']");
				log.driver.findElement(By.xpath("//button[text()='Edit...']")).click();
				Thread.sleep(1000);
				break;
			}
			else
			{
				System.out.println("not found");
			}
			
		}
		
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Aggregation']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Aggregation']")).isDisplayed(),true);

        
		Thread.sleep(1000);
		List<WebElement> RadioBtn = log.driver.findElements(By.xpath("//span[text()='Aggregation']/ancestor::div[3]/div/div/div//label"));
		int k1;	
		for (int i =0;i<=RadioBtn.size()-1;i++) 
		{
			k1=i+1;
			String Text = RadioBtn.get(i).getText();
			System.out.println(Text);
			if(Text.contains("Activate aggregation")||Text.contains("Automatic")||Text.contains("Don't show source elements"))
			{
				Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Aggregation']/ancestor::div[3]/div/div/div//label/ancestor::td[1]/input[1])["+k1+"]")).isSelected(),true);
				System.out.println(Text+"  is selected");
				Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Aggregation']/ancestor::div[3]/div/div/div//label/ancestor::td[1]/input[1])["+k1+"]")).isEnabled(),true);
				System.out.println(Text+"  is Enabled");
				
			}
			else
			{
				
				Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Aggregation']/ancestor::div[3]/div/div/div//label/ancestor::td[1]/input[1])["+k1+"]")).isSelected(),false);
				System.out.println(Text+"  is not selected");
				Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Aggregation']/ancestor::div[3]/div/div/div//label/ancestor::td[1]/input[1])["+k1+"]")).isEnabled(),true);
				System.out.println(Text+"  is Enabled");
			}
		}
		Thread.sleep(1000);
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Element Groups']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Element Groups']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
	    waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt3=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions action=new Actions(log.driver);
		//action.click(elemnt3).sendKeys("Container elements", Keys.ENTER).build().perform();
		action.click(elemnt3).sendKeys(Keys.ARROW_DOWN).build().perform();
		action.click(elemnt3).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		//waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[.='Selectable elements:']/..)[1]/ancestor::div[4]/div[2]/div[1]/div/div[2]");
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[4]/div/div/div[2]");
		List<WebElement> selectble_ele1 = log.driver.findElements(By.xpath("(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[4]/div/div/div[2]"));
		ArrayList<String> selectable1 = new ArrayList<String>();
		
		for (int i =0;i<=selectble_ele1.size()-1;i++) 
		{
			String aa = selectble_ele1.get(i).getText();
			selectable1.add(aa);
			if(selectable1.contains("Limousines SDl"))
			{
				assertTrue(true);
				
			}
			
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Limousines SDl']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='Limousines SDl']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Limousines SDl']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Limousines SDl']/../div[1]/input[1]")).isSelected());
		System.out.println("Limousines SDl Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(3000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Quartal 1 2015']/ancestor::div[3]/div[2]//div[1]/div");
		List<WebElement> rowvaluetab = log.driver.findElements(By.xpath("//div[text()='Quartal 1 2015']/ancestor::div[3]/div[2]//div[1]/div"));
		
		for(int i=0;i<=rowvaluetab.size()-1;i++)
		{
			
			String aa = rowvaluetab.get(i).getText();
             System.out.println(aa);
			if(aa.contains("Limousines SDl"))
			{
				assertTrue(true);
				
			}

			
		}
		
		System.out.println("table  contains one row  with   Limousines  SDL");
		test.info("table  contains one row  with   Limousines  SDL");
		
		log.driver.close();
		
		

	}
}
