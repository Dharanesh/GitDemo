package features;

import static org.testng.Assert.assertEquals;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import action.Login_BKP;
import event.Utils;
import event.Waits;

public class TestCase_36743 extends TestUtils
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
	  System.out.println("36743--Testcase started........");
	  	//login to the application:================
	  	test =extent.createTest("35668_Filter_LL_Verify Search field present having place holder: \"Type here to search....\"(ENG)");
	  	log = new Login();
	  	log.driver = log.get_Browser(browser);
	  	log.login(log.driver);
	  	Thread.sleep(5000);
	  	log.driver.findElement(By.xpath("//span[text()='Sales by country']")).click();
	  	Thread.sleep(10000);
		Utils = new Utils(log.driver);

		
	  	try {
	  		Utils.rightClick("(//input[@class='k-input dropdowninput'])[2]");
		Thread.sleep(1000);
		System.out.println(log.driver.findElement(By.xpath("(//span[@class='k-icon k-i-checkbox-checked'])[3]")).isDisplayed());
		Actions act =new Actions(log.driver);
  		act.sendKeys(Keys.ESCAPE).perform();
  		Thread.sleep(1000);
  		log.driver.findElement(By.xpath("(//input[@class='k-input dropdowninput'])[2]")).click();
		Thread.sleep(2000);
		String a= log.driver.findElement(By.xpath("(//input[contains(@id,'filterSearch')])[2]")).getAttribute("title");
		System.out.println(a);
		assertEquals(a, "This search is wildcard supported and can show up to 50 results.");
	  	}
	  	catch (Exception e) {
			// TODO: handle exception
	  		Thread.sleep(2000);
	  		System.out.println("Under catch");
	  		Utils.rightClick("(//input[@class='k-input dropdowninput'])[2]");
	  		Thread.sleep(1000);
  			log.driver.findElement(By.xpath("//span[text()='Enable selection by drop-down menu']]")).click();
  			Thread.sleep(1000);
	  		Actions act =new Actions(log.driver);
	  		act.sendKeys(Keys.ESCAPE).perform();
	  		log.driver.findElement(By.xpath("(//input[@class='k-input dropdowninput'])[2]")).click();
		Thread.sleep(2000);
		String a= log.driver.findElement(By.xpath("(//input[contains(@id,'filterSearch')])[2]")).getAttribute("title");
		System.out.println(a);
		assertEquals(a, "This search is wildcard supported and can show up to 50 results.");
		}

	  	Thread.sleep(2000);
//	  	String a = log.driver.findElement(By.xpath("(//input[@placeholder='Geben Sie hier ihre Suche ein...'])[1]")).getAttribute("title");
//	  	assertEquals(a, "Diese Suche unterstützt Wildcards. Es können bis zu 50 Ergebnisse angezeigt werden.","String not  match");
//	  	log.driver.close();

}
}