package regression;

import action.TestUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.BaseTest;
import action.Login;
import event.Waits;

public class TestCase_29013 extends TestUtils
{
	@Test	
	@Parameters("browser")

	public void Testcase_Cockpit10_Analytical_Viz_Minichart_New(String browser) throws Exception
	{
	    test =extent.createTest("TestCase_24483 for verifying functionality of Analytical Visualization MiniChart_Bar_New");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		log.login(log.driver);
		Waits waits = new Waits(log.driver);
		
		
	}
}
