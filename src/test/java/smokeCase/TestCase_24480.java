package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import action.TestUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.Analytical_Visualization;
import action.BaseTest;
import action.Login;
import event.Utils;
import event.Waits;

public class TestCase_24480 extends TestUtils {
	
	@Test()
	@Parameters("browser")
	public void Web_Testcase_verify_functionality_Analytical_Visualization_Gradient_Edit(String browser) throws Exception
	{
		
		test =extent.createTest("TestCase_24480_verify_functionality_Analytical_Visualization_Gradient_Edit");
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
//		Open Gradient report
		waits.waituUnitil_Element_Clickable(20,"//span[text()='Eigene Berichte']");
		log.driver.findElement(By.xpath("//span[text()='Eigene Berichte']")).click();
		Thread.sleep(500);
		
		log.driver.findElement(By.xpath("(//span[@class='k-icon k-i-expand'])[1]")).click();
		Thread.sleep(2000);
		
		log.driver.findElement(By.xpath("//span[text()='Gradient_Report']")).click();
		waits.waituUnitil_Element_Clickable(30,"//span[@id='tab_close_btn']");
		Thread.sleep(2000);
		ui.rightClick("//div[@id='0/0']");
		waits.waituUnitil_Element_Clickable(20,"//span[text()='Start Write Mode']");
		ArrayList<String> optable = new ArrayList();
		optable.add("Single Data Cell");
		optable.add("Start Write Mode");
		optable.add("Copy");
		optable.add("Copy (value formatted)");
		optable.add("Paste");
		optable.add("Splashing...");
		optable.add("Planning");
		optable.add("Define Subview...");
		optable.add("Analytical Visualizations");
		optable.add("Edit Table...");
		optable.add("Table Properties...");
		optable.add("Information...");
		
		List<WebElement> option= log.driver.findElements(By.xpath("(//ul[@data-role='contextmenu'])[3]/li/span"));
		for(int i=0;i<=option.size()-1;i++) 
		{
			assertEquals(optable.get(i), option.get(i).getText());
		}
		log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).click();
		Thread.sleep(2000);
		ArrayList<String> optable1  = new ArrayList();
		optable1.add("Assign...");
		optable1.add("Copy of...");
		optable1.add("New...");
		optable1.add("Edit Assignment");
		optable1.add("Remove Assignment");
		optable1.add("Edit...");
		optable1.add("Delete");
		
		List<WebElement> opt = log.driver.findElements(By.xpath("(//div[@class='k-animation-container'])[2]/ul/li"));
		for(int  i =0;i<=opt.size()-1;i++) 
		{
			assertEquals(optable1.get(i),opt.get(i).getText());
		}
		log.driver.findElement(By.xpath("//span[text()='Edit Assignment']")).click();
		Thread.sleep(5000);
		log.driver.findElement(By.xpath("(//span[text()='Gradient Analysis 1: column 1'])[1]")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Apply']");
		assertEquals(log.driver.findElement(By.xpath("//span[@class='k-window-title']")).getText(), "Assignment of the Analytical Visualization [DataView: Sales]");
		assertEquals(log.driver.findElement(By.xpath("(//li[@class='k-item k-state-default k-first k-tab-on-top k-state-active'])[1]")).getText(), "Allocation(target)");
		assertTrue(log.driver.findElement(By.xpath("(//label[text()='Based on index'])[1]/../input")).isSelected());
		assertEquals(log.driver.findElement(By.xpath("((//*[text()='Element level:'])[1]/following::span[@class='k-input'])[1]")).getText(), "(all levels)");

		
		String button11[]= {"OK","Apply","Cancel","Help"};
		List<WebElement> buttonlist = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		System.out.println("The New layout Component window list button  are :=  ");
		int buttonsize1 = buttonlist.size();
		for(int i =0;i<=buttonsize1-1;i++) 
		{
			
			assertEquals(button11[i], buttonlist.get(i).getAttribute("value"));
			
		
		}
		log.driver.findElement(By.xpath("(//span[@class ='k-widget k-dropdown w20_kendo cwDropDown'])[1]")).click();
		Thread.sleep(1000);
		log.driver.findElement(By.xpath("(//*[text()='Elements of level 1'])[1]")).click();
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//a[text()='Data area(source)']")).click();	
		waits.waituUnitil_Element_Clickable(20,"//*[text()='Ignore empty values']");
		log.driver.findElement(By.xpath("(//span[@class ='k-widget k-dropdown w20_kendo cwDropDown'])[3]")).click();
		Thread.sleep(3000);
		log.driver.findElement(By.xpath("(//*[text()='Elements of level 1'])[3]")).click();
		Thread.sleep(500);
		assertEquals(log.driver.findElement(By.xpath("((//*[text()='Element level:'])[1]/following::span[@class='k-input'])[3]")).getText(), "Elements of level 1");
		log.driver.findElement(By.id("okbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//div[@id='0/0']");
		ui.rightClick("//div[@id='0/0']");
		waits.waituUnitil_Element_Clickable(20,"//span[text()='Start Write Mode']");
		
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Analytical Visualizations']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("//span[text()='Edit...']")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//span[text()='Gradient Analysis 1'])[3]")).click();
		waits.waituUnitil_Element_Clickable(20,"//input[@value='Finish']");
		log.driver.findElement(By.xpath("//div[text()='Mode']/following::span[1]")).click();
		Thread.sleep(2000);
		log.driver.findElement(By.xpath("(//*[text()='Mininum and Maximum only'])[1]")).click();
		assertEquals(log.driver.findElement(By.xpath("//div[text()='Mode']/following::span[1]")).getText(), "Mininum and Maximum only");
		log.driver.findElement(By.id("finishbutton")).click();
		waits.waituUnitil_Element_Clickable(20,"//div[@id='0/0']");
		Thread.sleep(5000);
		assertEquals((log.driver.findElement(By.id("0/0")).getCssValue("background-color")),"rgba(0, 0, 255, 1)");
		assertEquals((log.driver.findElement(By.id("0/4")).getCssValue("background-color")),"rgba(255, 0, 0, 1)");
		log.driver.quit();

		
		
	
		

}}
