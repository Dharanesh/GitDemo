package features;

import static action.ThreadLocalWebDriverFactory.setDriver;
import static org.testng.Assert.assertEquals;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login_BKP;
import event.Utils;
import event.Waits;

public class TestCase_36748 extends TestUtils
{
	Login_BKP log = null;
	Waits waits =null;
	Utils Utils = null;
	Login_BKP Create_Report=null;
	event.Excelnput Excelnput=null;
	
  @Test
  @Parameters("browser")
  public void f(String browser) throws Exception
  {
	  //Precondition:-Template is null with report and add dependent Local export permission:=================
	   System.out.println("36748---Testcase started........");
	  	//login to the application:==========
	   test =extent.createTest("TestCase_36748: Testcase to verify creating a Title Layout component");
	  	log = new Login_BKP() {};
	  	setDriver(browser);
		log.login(log.driver);
		Thread.sleep(5000);
	 	log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
	  	Thread.sleep(10000);
		waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Utils.rightClick("//input[@class='k-input dropdowninput']");
	  	Thread.sleep(5000);
	  	try {
	  		System.out.println("Under try");
	  		log.driver.findElement(By.xpath("//span[text()=' DropDown-Menü erlauben']")).click();
		  	Thread.sleep(2000);
		  	log.driver.findElement(By.xpath("//input[@class='k-input dropdowninput']")).click();
		  	Thread.sleep(2000);
		  	String a = log.driver.findElement(By.xpath("(//input[@placeholder='Geben Sie hier ihre Suche ein...'])[1]")).getAttribute("placeholder");
		  	assertEquals(a, "Geben Sie hier ihre Suche ein...");
	  	}
	  	catch (Exception e) {
			// TODO: handle exception
	  		Thread.sleep(2000);
	  		System.out.println("Under catch");
	  		Actions act =new Actions(log.driver);
	  		act.sendKeys(Keys.ESCAPE).perform();
		}
	  	System.out.println("out");
	  	log.driver.close();
	  	
	  	
}
}