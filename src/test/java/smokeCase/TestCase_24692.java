package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import action.TestUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24692 extends TestUtils {
	@Test
	@Parameters("browser")
	public void Testcase_for_Changing_ownerShip_to_different_user(String browser) throws Exception
	{
		//Testcase step 1 to step 4
		// login to the application
		test =extent.createTest("TestCase_24692 for Creating Standard report with table Layout component");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);

		//		log.createReport(log.driver,"Sales");
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		log.createCubeReport("//div[contains(text(),'Training Sales')]","TestCase_2462",false);
		String text = log.driver.findElement(By.xpath("//span[@id='tab_close_btn']")).getText();
		assertEquals(text, "TestCase_2462");
		boolean checc =log.driver.findElement(By.xpath("//div[@data-widgetname='cw_grid']/div")).isDisplayed();
		boolean checc1 =log.driver.findElement(By.xpath("//span[@class='k-widget k-dropdowntree cwDropDown']")).isDisplayed();
		assertTrue(checc);
		assertTrue(checc1);
		log.driver.close();

}
}