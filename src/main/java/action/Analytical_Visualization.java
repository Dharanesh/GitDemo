package action;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import event.ConfigData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import event.Utils;
import event.Waits;

public class Analytical_Visualization  extends ConfigData {
	
	
	public void Analytical_visulization_Gradient_new(WebDriver driver) throws InterruptedException 
	{
		Waits waits = new Waits(driver);
		Utils ui  = new Utils(driver);
		driver.findElement(By.xpath("//table[@class='cwMenuBarClient']/tbody/tr/td[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(20, "//*[text()='New...']");
		driver.findElement(By.xpath("//*[text()='Save As...']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(20, getData("save_Report_pop_up"));
		driver.findElement(By.xpath("//div[text()='Save report']/following::input[2]")).clear();
		driver.findElement(By.xpath("//div[text()='Save report']/following::input[2]")).sendKeys("Gradient_New");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Name']/following::div[@class='tv']/input[@value='1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(getData("ok"))).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(getData("dataView"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//*[text()='DataViews'])[1]");
		Thread.sleep(2000);
		ui.dragAndDrop(driver.findElement(By.xpath("//a[text()='Time']")), driver.findElement(By.xpath("//*[text()='Measures']")));
		Thread.sleep(2000);
		ui.dragAndDrop(driver.findElement(By.xpath("//*[text()='Measures']")), driver.findElement(By.xpath(getData("backgroud_filiter"))));
		Thread.sleep(500);
//		 Test Step 15 to 	25
		driver.findElement(By.xpath("//a[text()='Time']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Element Groups...']");
		ArrayList<String> BtnList = new ArrayList<String>();
		BtnList.add("Element Groups...");
		BtnList.add("Limits...");
		BtnList.add("User defined...");
		BtnList.add("Properties...");
		BtnList.add("Formula Editor");
		BtnList.add("OK");
		BtnList.add("Cancel");
		BtnList.add("Help");
		List<WebElement> btnlist = driver.findElements(By.xpath("//img[@src='./images/elements.gif']/following::span[@class='btn']"));
		System.out.println("The Available Button on Selection for Column window are");
		for (int i=0;i<btnlist.size();i++) 
		{
			assertEquals(BtnList.get(i), btnlist.get(i).getText());
			System.out.println(btnlist.get(i).getText());
			
		}
	Thread.sleep(1000);
	assertTrue(driver.findElement(By.xpath("//*[@src='images/btmoverall.gif']")).isDisplayed());
	System.out.println("Inserts all visible items to the selection list is enabled");
	assertTrue(driver.findElement(By.xpath("//*[@src='images/btmoveright.gif']")).isDisplayed());
	System.out.println("Inserts only selected items to the selection list is enabled");
	assertTrue(driver.findElement(By.xpath("//*[@src='images/btmoveleft.gif']")).isDisplayed());
	System.out.println("Removes only selected items from the selection list is enabled");
	assertTrue(driver.findElement(By.xpath("//*[@src='images/btmovelall.gif']")).isDisplayed());
	System.out.println("Removes all items from the selection list is enabled ");
	driver.findElement(By.xpath("(//a[text()='All Periods'])[2]/../input[@type='checkbox']")).click();
	Thread.sleep(200);
	driver.findElement(By.xpath("//*[@src='images/btmoveleft.gif']")).click();
	Thread.sleep(200);
	List<WebElement> input = driver.findElements(By.xpath("//a[text()='All Periods']/following::input"));
		for (int i =1;i<input.size();i++) 
		{
			input.get(i).click();
		}
		driver.findElement(By.xpath("//*[@src='images/btmoveright.gif']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath(getData("ClickOK"))).click();
		Thread.sleep(200);
//		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Single Period']");
		driver.findElement(By.xpath(getData("ShowComponentManager"))).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//*[text()='Components'])[1]");
		ui.rightClick("//*[text()='Analytical Visualizations']");
		Thread.sleep(200);
		// Test step 26 to 
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='New Analytical Visualization...']");
		ArrayList<String> w = new ArrayList<String>();
		w.add("Paste");
		w.add("New Analytical Visualization...");
		Thread.sleep(2000);
		System.out.println("available options are ");

		driver.findElement(By.xpath("//*[text()='New Analytical Visualization...']")).click();
		Thread.sleep(1000);
		List<WebElement>compontType = driver.findElements(By.xpath(getData("layout_component_types")));
		int typesize = compontType.size();
		String type[] = {"Threshold","Gradient","In Cell Bar","Minichart","Trendline"};
		System.out.println("The  component layout window contains  below list" );
//		test.info("The  New Analytical Visualization window contains  below list");
		for(int i = 0;i<compontType.size();i++) 
		{
			
			Assert.assertEquals(type[i], compontType.get(i).getText());
			System.out.println(compontType.get(i).getText());
//			.info(compontType.get(i).getText());
		}	
		Thread.sleep(2000);
//		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Threshold']/../../td/input")).isSelected(), true);
//		test.info("***************************************************");
		
		System.out.println("***************************************************");
		System.out.println("Threshold opition is by defalut is selected");
//		test.info("Threshold opition is by defalut is selected");
		
		
	
		String text  = driver.findElement(By.xpath(getData("Insert_Message"))).getText();
		System.out.println(text);
//		test.info(text);
		assertEquals(text, "Creates a new threshold analysis.");
		
		
		driver.findElement(By.xpath("//*[text()='Gradient']/../../td/input")).click();
		Thread.sleep(1000);
		String text1  = driver.findElement(By.xpath(getData("Insert_Message"))).getText();
		
		System.out.println(text1);
//		test.info(text1);
		System.out.println("Selected chart option ");
//		test.info("Selected chart option ");
		assertEquals(text1, "Creates a new gradient analysis.");
		
		

		
//		checck cancel,help & next button in the window
		String button1[]= {"Next >>","Cancel","Help"};
		List<WebElement> button = driver.findElements(By.xpath(getData("Buttons")));
		System.out.println("The New layout Component window list button  are :=  ");
//		test.info("The New layout Component window list button  are :=  ");
		int buttonsize = button.size();
		for(int i =0;i<=buttonsize-1;i++) 
		{
			
			assertEquals(button1[i], button.get(i).getText());
			System.out.println(button.get(i).getText());
//			test.info(button.get(i).getText());
		}

		button.get(0).click();
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Gradient Analysis']");
		System.out.println("The available options in Gradient Analysis windows are ");
		List<WebElement> tex =driver.findElements(By.xpath("//img[@src='images/analysegradient32.gif']/following::div[@class='static']"));
		for (WebElement webElement : tex) {
			System.out.println(webElement.getText());
			
		}
		assertFalse(driver.findElement(By.xpath("//*[text()='Assign layout component later']")).isSelected());
		System.out.println("Assign layout component later is uncehecked");
		driver.findElement(By.xpath("//*[text()='Target assignment:']/following::span[1]")).click();
		Thread.sleep(2000);
//		waits.waitUntil_Elmentis_visibilityOfElement(20,"//*[text()='Assignment of the Analytical Visualization  [DataView: A - Training Sales]']");
		assertTrue(driver.findElement(By.xpath("//*[text()='Based on index']/preceding::input[1]")).isEnabled());
		System.out.println("Based on index is selected By default");
		String drop = ui.getSelectedStringValue("//*[text()='Element level:']/following::select");
		assertEquals(drop, "(all levels)");
		System.out.println("by default 'Element level'  set to '(all levels)' in drop-down list");
		Thread.sleep(200);
		System.out.println("The availble buttons are ");
		List<WebElement> whoe = driver.findElements(By.xpath("//*[text()='Element level:']/following::span"));
		for (WebElement webElement : whoe) {
			System.out.println(webElement.getText());
			
		}
		driver.findElement(By.xpath("(//div[@id='0/-1' and text()='2013'])[2]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[text()='Data area(source)']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='1/-1' and text()='2014'])[2]")).click();
		
		String drop1 = ui.getSelectedStringValue("//*[text()='Element level:']/following::select[1]");
		assertEquals(drop1, "(all levels)");
		System.out.println("by default 'Element level'  set to '(all levels)' in drop-down list");
		Thread.sleep(200);
		String drop2 = ui.getSelectedStringValue("//*[text()='Element level:']/following::select[2]");
		assertEquals(drop2, "No Aggregation");
		System.out.println("by default 'Element level'  set to 'No Aggregation' in drop-down list");		
		List<WebElement> whoe1 = driver.findElements(By.xpath("//*[text()='Element level:']/following::span"));
		for (WebElement webElement : whoe1) 
		{
			System.out.println(webElement.getText());
			
		}
		
		driver.findElement(By.xpath(getData("ClickOK"))).click();
		Thread.sleep(200);
		driver.findElement(By.xpath(getData("finish"))).click();
		Thread.sleep(1000);
		String aaa= driver.findElement(By.xpath("//div[@id='0/0']")).getCssValue("background-color");
		System.out.println(aaa);
		assertEquals("rgba(0, 0, 255, 1)", aaa);

	}

}
