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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import action.Login_BKP;
import event.Utils;
import event.Waits;
import junit.framework.Assert;

public class TestCase_25528  extends TestUtils
{
	Login log = null;
	Waits waits =null;
	Utils Utils = null;
	Login_BKP Create_Report=null;
	event.Excelnput Excelnput=null;
	
  @Test
  @Parameters("browser")
  public void f(String browser) throws Exception 
  {
	  	System.out.println("25528---Testcase started........");
  		//login to the application:==========
	  	test =extent.createTest("Test Case 25528:");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	super.driver = log.login(log.driver);

	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
//	  	Utils.waitForElement("");

//	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
//	  	Utils.waitForElement("");
		System.out.println("Test Case 25528: Testcase for creating Standard SDl Container elemets in \"CM ratio manufacturers\"===================");
//	  	Utils.waitForElement("");
//	  	Thread.sleep(3000);
	  
	  	//Verify Navigator window on the Left side:=======
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Navigator']")).isDisplayed());
//		Thread.sleep(2000);
		Assert.assertEquals(true,log.driver.findElement(By.xpath("//span[text()='Navigator']/following::div[1]")).isDisplayed());
//		Thread.sleep(2000);
	    System.out.println("Navigator window is displaying now.");
	    
	    //Verify the Status bar :==================================
	    Assert.assertEquals(true,log.driver.findElement(By.xpath("(//span[text()='<neutral>'])[1]")).isDisplayed());
//		Thread.sleep(2000);
		System.out.println("Neutral language is displaying now on button of report.");
	  	
	  	//Try to open CM ratio manufacturers Report:=====================
		waits.waituUnitil_Element_Clickable(20,"//span[text()='Eigene Berichte']");
		log.driver.findElement(By.xpath("//span[text()='Eigene Berichte']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='CM ratio manufacturers']")).click();
//	  	Utils.waitForElement("");
		Thread.sleep(2000);
//		Thread.sleep(5000);
		
		//Take Count After open:===========
	  	List<WebElement> ReportCount=log.driver.findElements(By.xpath("//span[text()='CM ratio manufacturers']"));
	  	
	  	System.out.println("list of report is:->"+ReportCount.size());
	  	try
	  	{
	  		if(ReportCount.size()>2)
	  		{
	  			System.out.println("Required Report is opened now");
	  		}
	  		
	  	}catch(Exception e)
	  	{
	  			System.out.println("Need to click again.");
	  			log.driver.findElement(By.xpath("//span[text()='CM ratio manufacturers']")).click();
	  			Utils.waitForElement("");
	  	}
	  	
	  	waits.waituUnitil_Element_Clickable(10, "//span[text()='Product']");
		String Columnvalue=log.driver.findElement(By.xpath("//span[text()='Product']")).getText();
		Assert.assertEquals(Columnvalue, "Product");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Product']")).click();
		
		waits.waituUnitil_Element_Clickable(10,"//button[text()='Element Groups...']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath("//button[text()='Element Groups...']")).click();
		Thread.sleep(2000);	
		
		List<WebElement>cont = log.driver.findElements(By.xpath("(//div[@class='k-list-scroller k-selectable'])[2]/ul/li/div/span/span[2]"));
		for (int z =0;z<=cont.size()-1;z++) 
		{
			System.out.println(cont.get(z).getText());
			if(cont.get(z).getText().equals("CarTypeStdDDl"))
			{
				System.out.println(cont.get(z).getText());
				System.out.println("INside =============================");
				Thread.sleep(2000);
				log.driver.findElement(By.xpath("//span[text()='CarTypeStdDDl']")).click();
				Thread.sleep(2000);
				waits.waituUnitil_Element_Clickable(20,"//button[text()='Delete']");
				log.driver.findElement(By.xpath("//button[text()='Delete']")).click();
				waits.waituUnitil_Element_Clickable(20,"//input[@id='yesbutton']");
				log.driver.findElement(By.xpath("//input[@id='yesbutton']")).click();
				break;
			}
	  	
		}
		
		waits.waituUnitil_Element_Clickable(20,"//button[text()='New...']");
		Thread.sleep(2000);	
		log.driver.findElement(By.xpath("//button[text()='New...']")).click();
		List<WebElement>ele = log.driver.findElements(By.xpath("(//div[@class='w20_treeview'])[1]/div/div"));
		ArrayList<String> elem = new ArrayList();
		elem.add("Criteria DDL");
		elem.add("Data DDL");
		elem.add("Script DDL");
		elem.add("Standard SDL");
		for (int j =0;j<=ele.size()-1;j++) 
		{
			assertEquals(ele.get(j).getText(), elem.get(j));
			
		}
		log.driver.findElement(By.xpath("//div[text()='Standard SDL']")).click();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys("CarTypeStdDDl");
		Thread.sleep(1000);
		Actions act = new Actions(log.driver);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		
		List<WebElement>button = log.driver.findElements(By.xpath("(//div[@id='buttons'])[1]/input"));
		ArrayList<String> but = new ArrayList();
		but.add("Next >>");
		but.add("Cancel");
		but.add("Help");
		for(int i =0;i<=button.size()-1;i++) 
		{
			assertEquals(but.get(i), button.get(i).getAttribute("value"));
		}
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@value='Next >>'])[1]")).click();
		waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");	
		waits.waituUnitil_Element_Clickable(20,"//button[text()='Selection...']");
		log.driver.findElement(By.xpath("//button[text()='Selection...']")).click();
		waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//div[text()='Cadillac'])[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='Ferrari'])[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='Jaguar'])[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='Lamborghini'])[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='Lincoln'])[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='Lotus'])[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='Maserati'])[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='Porsche'])[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//div[text()='Rolls-Royce'])[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();
		waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//input[@id='nextbutton'])[1]")).click();
		waits.waituUnitil_Element_Clickable(20,"(//input[@id='finishbutton'])[1]");
		log.driver.findElement(By.xpath("//label[text()='Activate aggregation']")).click();
		Thread.sleep(2000);
		assertTrue(log.driver.findElement(By.xpath("//label[text()='Optional Alias:']/../input")).isEnabled());
		assertTrue(log.driver.findElement(By.xpath("//label[text()='Activate aggregation']/../input")).isEnabled());
		assertTrue(log.driver.findElement(By.xpath("//label[text()='Explicit parent element:']/../input")).isEnabled());
		log.driver.findElement(By.xpath("//label[text()='Activate aggregation']")).click();
		Thread.sleep(2000);
		assertFalse(log.driver.findElement(By.xpath("//label[text()='Optional Alias:']/../input")).isEnabled());
		assertTrue(log.driver.findElement(By.xpath("//label[text()='Activate aggregation']/../input")).isEnabled());
		assertFalse(log.driver.findElement(By.xpath("//label[text()='Explicit parent element:']/../input")).isEnabled());
		log.driver.findElement(By.xpath("(//input[@id='finishbutton'])[1]")).click();
		waits.waituUnitil_Element_Clickable(20,"(//input[@id='helpbutton'])[1]");
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//span[text()='Product'])[1]")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("(//*[text()='Container elements'])[3]")).click();
		waits.waituUnitil_Element_Clickable(20, "//div[text()='CarTypeStdDDl']");
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("//div[text()='CarTypeStdDDl']")).click();
		Thread.sleep(2000);
		assertEquals(log.driver.findElement(By.xpath("(//div[@class='w20_treeview'])[2]/div/div[2]")).getText(), "CarTypeStdDDl");
		Thread.sleep(1000);
		log.driver.findElement(By.id("okbutton")).click();
		Thread.sleep(2000);
		int j=0;
		ArrayList<String> ca = new ArrayList(); 
		ca.add("Cadillac");
		ca.add("Ferrari");
		ca.add("Jaguar");
		ca.add("Lamborghini");
		ca.add("Lincoln");
		ca.add("Lotus");
		ca.add("Maserati");
		ca.add("Porsche");
		ca.add("Rolls-Royce");
		List<WebElement> cars = log.driver.findElements(By.xpath("((//*[text()='Category'])[1]/following::div[@class='w20_contentpane w20_kendo'])[3]/div[@id]"));
		for (int i =0;i<=cars.size()-1;i++) 
		{
			assertEquals(cars.get(i).getText(),ca.get(i));
			
		}
		log.driver.close();
		

	  	
	  	
	  	
	  	
	  	
	  	

  }}
