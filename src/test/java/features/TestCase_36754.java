package features;

import action.TestUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import action.Login_BKP;
import event.Utils;
import event.Waits;

public class TestCase_36754 extends TestUtils
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
	   System.out.println("36754--Testcase started........");
	  	//login to the application:================
	  	test =extent.createTest("Test Case 35677: Filter_LL_ Verify when filter are arranged \"stacked\" (filter bar property).");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	
	  	waits = new Waits(log.driver);
	  	Utils = new Utils(log.driver);
	  	Excelnput=new event.Excelnput();
	  	Utils.waitForElement("");
	  	
	  	log.driver.findElement(By.xpath("//span[text()='Welcome']")).click();
	  	Utils.waitForElement("");
	  	
	  	System.out.println("Test Case 35677: Filter_LL_ Verify when filter are arranged \"stacked\" (filter bar property).===================");
	  	Utils.waitForElement("");
	  	Thread.sleep(3000); 
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
  }
}
