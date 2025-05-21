package smokeCase;

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


public class TestCase_25650 extends TestUtils
	{
	

	@Test	
	@Parameters("browser")
	public void Testcase_Web_Cockpit_Calculated_Elements_Priority_Check(String browser) throws Exception
	{
 
	    test =extent.createTest("TestCase_25650 : Web Cockpit Calculated elements priority check");
	
		Login log = new Login();
		log.driver = log.get_Browser(browser);
		super.driver = log.login(log.driver);
		Waits waits = new Waits(log.driver);
		Utils ui = new Utils(log.driver);
		
	
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("SalesByCountry"));
		log.driver.findElement(By.xpath(log.getData("SalesByCountry"))).click();
        Thread.sleep(2000);
        waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("SalesByCountry_Header"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("SalesByCountry_Header"))).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("DataviewDesigner"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("DataviewDesigner"))).isDisplayed(),true);
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Value"));
		Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Row_Value"))).getText(),"Customer");
		System.out.println("Customer is present in Rows");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, log.getData("Row_Value"));
		log.driver.findElement(By.xpath(log.getData("Row_Value"))).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Row_Dimension_Header"));
		assertTrue(log.driver.findElement(By.xpath(log.getData("Row_Dimension_Header"))).isDisplayed());
		
		List<WebElement> AB = log.driver.findElements(By.xpath(log.getData("Selection_Element_Window_Btns")));
		for (WebElement btn : AB) 
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getText() + "    is displayed and Enabled");
			test.info(btn.getText() + "    is displayed and Enabled");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='All Customers'])[2]/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("(//div[text()='All Customers'])[2]/../div[1]")).isDisplayed());
		System.out.println("All Categories Checkbox is Selected in the list of base elements area");
		log.driver.findElement(By.xpath("(//div[text()='All Customers'])[2]/../div[1]")).click();
		Thread.sleep(2000);
        
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div/div[2]");

		List<WebElement> selectble_ele = log.driver.findElements(By.xpath("(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div/div[2]"));
		for (int i =0;i<=selectble_ele.size()-1;i++) 
		{
			int k=i+1;
			if(selectble_ele.get(i).getText().equals("Australia")||selectble_ele.get(i).getText().equals("Austria")||selectble_ele.get(i).getText().equals("Canada" ))
			{
				System.out.println("Value Matched"); 
			}
			else
			{
				log.driver.findElement(By.xpath("(//span[contains(text(),'Selection for Rows')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div["+k+"]/div[1]")).click();
				assertTrue(log.driver.findElement(By.xpath("(//span[contains(text(),'Selection for Rows')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div["+k+"]/div[1]/input")).isSelected());
				System.out.println("Checkbox checked for element" +selectble_ele.get(i).getText());
				test.info("Checkbox checked for element" +selectble_ele.get(i).getText());
			}

		}
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes only selected items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes only selected items from the selection list']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div/div[2]");
		List<WebElement> ele = log.driver.findElements(By.xpath("(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div/div[2]"));

		for (int i = 0; i < ele.size(); i++) {	
			Thread.sleep(100);
			System.out.println("Element present in base element with containers pane is  "+ele.get(i).getText());
			test.info("Element present in base element with containers pane is  "+ele.get(i).getText());		
		}

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Actions a1=new Actions(log.driver);
		/*a1.click(elemnt).sendKeys("Calculated elements", Keys.ENTER).build().perform();*/
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elmntindrpdwn=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		Assert.assertEquals(elmntindrpdwn.getText(),"Calculated elements");
		System.out.println(elmntindrpdwn.getText());
		System.out.println("Calculated elements is selected in drop down");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[4]/div/div/div[2]");
		List<WebElement> SelectCalcElemnt = log.driver.findElements(By.xpath("(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[4]/div/div/div[2]"));
		ArrayList<String> selectable = new ArrayList<String>();
		
		for (int i =0;i<=SelectCalcElemnt.size()-1;i++) 
		{
			String aa = SelectCalcElemnt.get(i).getText();
			selectable.add(aa);
			if(selectable.contains("SUM"))
			{
				assertTrue(true);
				
			}
			
		}	
			
		System.out.println("SUM is present in the list of selectable elements");
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SUM']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='SUM']/../div[1]")).isDisplayed());
		System.out.println("SUM Checkbox is present in the list of selectable elements");
        
		ArrayList<String > type = new ArrayList<String>();
		type.add("-SEPARATOR-");
		type.add("FORMULA");
		type.add("MASHUP");
		type.add("SUM");
		type.add("DIFFERENCE");
		type.add("PRODUCT");
		type.add("PRODUCT (X*Y)");
		type.add("AVERAGE");
		type.add("MINIMUM");
		
		
		System.out.println("ELements present in Selectable area are:  ");
		for(int i =0;i<=8;i++) 
		{
			Assert.assertEquals(SelectCalcElemnt.get(i).getText(),type.get(i));
			System.out.println(SelectCalcElemnt.get(i).getText());

			test.info(" SUM Position is correct");
		}
		Thread.sleep(1000);
		for (int i =0;i<=SelectCalcElemnt.size()-1;i++) 
		{
			Assert.assertEquals(SelectCalcElemnt.get(i).isSelected(), false);

		}
		System.out.println("checkboxes are unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SUM']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='SUM']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='SUM']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='SUM']/../div[1]/input[1]")).isSelected());
		System.out.println("SUM Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		
		List<WebElement> SUM = log.driver.findElements(By.xpath("//div[text()='SUM']/../div[1]/input"));
		for (int i = 0; i < SUM.size(); i++) 
		{
			assertTrue(SUM.get(i).isSelected());
		}
		System.out.println("SUM is selected");			
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div/div[2]");
		List<WebElement> el = log.driver.findElements(By.xpath("(//span[contains(text(),'Selection for')]/ancestor::div[2]/div[2]//div[@class='heightauto'])[6]/div/div/div[2]"));//step 24
			
		Assert.assertEquals(el.get(el.size()-1).getText(), "SUM");
		
		System.out.println("SUM is present a the last in base elements area");
		test.info("SUM is present a the last in base elements area");
		
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'Base elements')]/ancestor::div[4]/div[2]/div[1]/div/div[1]");
		List<WebElement> Bas = log.driver.findElements(By.xpath("//span[contains(text(),'Base elements')]/ancestor::div[4]/div[2]/div[1]/div/div[1]/input"));

		for (int i = 0; i < Bas.size()-1; i++) {	
			Assert.assertEquals(Bas.get(i).isSelected(), false);

		}
		System.out.println("All the elements in base element area are unchecked");
		test.info("All the elements in base element area are unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='SUM'])[2]//../div[1]");
		log.driver.findElement(By.xpath("(//div[text()='SUM'])[2]//../div[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='SUM'])[2]//../div[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[text()='SUM'])[2]//../div[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li/a");
		List<WebElement> ElemntName =log.driver.findElements(By.xpath("//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li/a"));
		System.out.println("Tabs present in Property of elements windows are:");
		ArrayList<String > tab_name = new ArrayList<String>();
		tab_name.add("Element");
		tab_name.add("Value Format");
		tab_name.add("Data Cell");
		tab_name.add("Header Cell");
		tab_name.add("Chart");
		tab_name.add("Maps");
		for (int  i=0;i<=ElemntName.size()-1;i++) 
		{		
			String tabName = ElemntName.get(i).getText();
			Assert.assertEquals(tabName, tab_name.get(i),"Value Not Matching");
			System.out.println(tabName);
			test.info(tabName);
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li");
		List<WebElement> ElemntName1 =log.driver.findElements(By.xpath("//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li"));
		Assert.assertEquals(ElemntName1.get(0).getAttribute("aria-selected"), "true");
		System.out.println(ElemntName1.get(0).getText() +"   is Selected");
		test.info(ElemntName1.get(0).getText() +"   is Selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
		if(log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
			log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).click();
			System.out.println("Priority button got expanded");
			test.info("Priority button got expanded");
		}else{
			System.out.println("Priority button expanded by default");
			test.info("Priority button expanded by default");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), true);
		System.out.println("Automatic Priority checkbox is selected by default");
		test.info("Automatic Priority checkbox is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), false);
		System.out.println("explicit priority text box is disabled by default");
		test.info("explicit priority text box is disabled by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]/div[1]")).click();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), false);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), true);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys(Keys.BACK_SPACE);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys("2");
		
		List<WebElement> Btns = log.driver.findElements(By.xpath("//span[contains(text(),'Properties of Element')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : Btns)
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		}
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Default']");
		Btns.get(3).click();
		Btns.get(3).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Resetting the default settings of this page to default is not possible.']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Resetting the default settings of this page to default is not possible.']")).getText(),"Resetting the default settings of this page to default is not possible.");

		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//input[@id='helpbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='helpbutton'])[1]")).click();
		Thread.sleep(2000);
		
		String WindowHandle = log.driver.getWindowHandle();
		//Switch to child window
		for(String winHandle : log.driver.getWindowHandles())
		{
			log.driver.switchTo().window(winHandle);
		}

		// Perform the actions on child window
		System.out.println("window title is " +log.driver.getTitle());
		test.info("window title is " +log.driver.getTitle());
		if(log.driver.getCurrentUrl().contains("help"))
		{
			assertTrue(true);
			System.out.println("Help window displayed ");
			test.info("Help window displayed ");

		}else{
			System.out.println("window url does not contain Help in it");
			test.info("window url does not contain Help in it");
		}

		//Close the new window if that window no more required
		log.driver.close();
		System.out.println("Help window closed ");
		test.info("Help window closed ");
		
		//Control to parent Window
		log.driver.switchTo().window(WindowHandle);
		System.out.println("Switch control to parent window");
		test.info("Switch control to parent window");
		Thread.sleep(500);
	
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//input[@id='cancelbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='cancelbutton'])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='SUM'])[2]//../div[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[text()='SUM'])[2]//../div[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li");
		List<WebElement> ElemntName11 =log.driver.findElements(By.xpath("//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li"));
		Assert.assertEquals(ElemntName11.get(0).getAttribute("aria-selected"), "true");
		System.out.println(ElemntName11.get(0).getText() +"   is Selected");
		test.info(ElemntName11.get(0).getText() +"   is Selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
		if(log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
			log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).click();
			System.out.println("Priority button got expanded");
			test.info("Priority button got expanded");
		}else{
			System.out.println("Priority button expanded by default");
			test.info("Priority button expanded by default");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), true);
		System.out.println("Automatic Priority checkbox is selected by default");
		test.info("Automatic Priority checkbox is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), false);
		System.out.println("explicit priority text box is disabled by default");
		test.info("explicit priority text box is disabled by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]/div[1]")).click();

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), false);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), true);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys(Keys.BACK_SPACE);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys("2");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Properties of Element')]/ancestor::div[2]/div[2]/div[2]/div[1]/input");
		List<WebElement> btn_Items  = log.driver.findElements(By.xpath("//span[contains(text(),'Properties of Element')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		btn_Items.get(0).click();
		btn_Items.get(0).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Rows ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Rows ')]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		
		if(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText().equals("Measures")){
			Thread.sleep(1000);
			log.driver.findElement(By.xpath(log.getData("Columns_Value"))).click();
			Thread.sleep(2000);
			waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Dimension_Header"));
			assertTrue(log.driver.findElement(By.xpath(log.getData("Columns_Dimension_Header"))).isDisplayed());

		}else
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
			ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Time'])[1]")), log.driver.findElement(By.xpath(log.getData("Background"))));
			Thread.sleep(2000);

			ui.dragAndDrop(log.driver.findElement(By.xpath("(//span[text()='Measures'])[2]")), log.driver.findElement(By.xpath(log.getData("Columns"))));
			Thread.sleep(5000);
			waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Value"));
			Assert.assertEquals(log.driver.findElement(By.xpath(log.getData("Columns_Value"))).getText(), "Measures");

			System.out.println("Measure is added in Columns");
			test.info("Measure is added in Columns");
			
			log.driver.findElement(By.xpath(log.getData("Columns_Value"))).click();
			Thread.sleep(2000);
		    waits.waitUntil_Elmentis_visibilityOfElement(10,log.getData("Columns_Dimension_Header"));
		    assertTrue(log.driver.findElement(By.xpath(log.getData("Columns_Dimension_Header"))).isDisplayed());
		
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Removes all items from the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Removes all items from the selection list']")).click();
		Thread.sleep(1000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement salesprice=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		/*a1.click(salesprice).sendKeys("B - Training Sales", Keys.ENTER).build().perform();*/
		a1.click(salesprice).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(salesprice).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Sales price']");
		log.driver.findElement(By.xpath("//div[text()='Sales price']")).click();
		Thread.sleep(1000);
	
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]");
		WebElement elemnt1=log.driver.findElement(By.xpath("//button[text()='Element Groups...']/following::div[2]/span/span[1]/span[1]"));
		/*a1.click(elemnt1).sendKeys("Calculated elements", Keys.ENTER).build().perform();*/
		a1.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ARROW_DOWN).build().perform();
		a1.click(elemnt1).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PERCENTAGE']/../div[1]");
		log.driver.findElement(By.xpath("//div[text()='PERCENTAGE']/../div[1]")).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='PERCENTAGE']/../div[1]");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='PERCENTAGE']/../div[1]/input[1]")).isSelected());
		System.out.println("PERCENTAGE Checkbox is Selected in the list of selectable elements");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[@data-title='Inserts only selected items to the selection list']");
		log.driver.findElement(By.xpath("//button[@data-title='Inserts only selected items to the selection list']")).click();//step 23
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//button[@data-title='Inserts only selected items to the selection list']");
		Thread.sleep(1000);
		List<WebElement> Percentage = log.driver.findElements(By.xpath("//div[text()='PERCENTAGE']/../div[1]/input"));
		for (int i = 0; i < Percentage.size(); i++) 
		{
			
			assertTrue(Percentage.get(i).isSelected());
		}
		System.out.println("Percentage is selected");			
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]");
		List<WebElement> baseelmt = log.driver.findElements(By.xpath("//span[contains(text(),'Selection for')]/following::div[5]/div[1]/div[4]/div[3]/div[2]/div[1]/div/div[2]"));//step 24
		
		Assert.assertEquals(baseelmt.get(baseelmt.size()-1).getText(), "PERCENTAGE");
		
		System.out.println("PERCENTAGE is present a the last in base elements area");
		test.info("PERCENTAGE is present a the last in base elements area");
		
		log.driver.findElement(By.xpath("(//button[@data-title='Deselect all visible items'])[2]")).click();
		Thread.sleep(500);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[text()='PERCENTAGE'])[2]//../div[1]");
		log.driver.findElement(By.xpath("(//div[text()='PERCENTAGE'])[2]//../div[1]")).click();

		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='PERCENTAGE'])[2]//../div[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[text()='PERCENTAGE'])[2]//../div[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li/a");
		List<WebElement> ElemntNameCol =log.driver.findElements(By.xpath("//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li/a"));
		System.out.println("Tabs present in Property of elements windows are:");
		ArrayList<String > Window_ElemntName = new ArrayList<String>();
		Window_ElemntName.add("Element");
		Window_ElemntName.add("Value Format");
		Window_ElemntName.add("Data Cell");
		Window_ElemntName.add("Header Cell");
		Window_ElemntName.add("Chart");
		Window_ElemntName.add("Maps");
		for (int  i=0;i<=ElemntNameCol.size()-1;i++) 
		{		
			String ElemttabName = ElemntNameCol.get(i).getText();
			Assert.assertEquals(ElemttabName, Window_ElemntName.get(i),"Value Not Matching");
			System.out.println(ElemttabName);
			test.info(ElemttabName);
		}
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li");
		List<WebElement> Elemntwindow =log.driver.findElements(By.xpath("//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li"));
		Assert.assertEquals(Elemntwindow.get(0).getAttribute("aria-selected"), "true");
		System.out.println(Elemntwindow.get(0).getText() +"   is Selected");
		test.info(Elemntwindow.get(0).getText() +"   is Selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
		if(log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
			log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).click();
			System.out.println("Priority button got expanded");
			test.info("Priority button got expanded");
		}else{
			System.out.println("Priority button expanded by default");
			test.info("Priority button expanded by default");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), true);
		System.out.println("Automatic Priority checkbox is selected by default");
		test.info("Automatic Priority checkbox is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), false);
		System.out.println("explicit priority text box is disabled by default");
		test.info("explicit priority text box is disabled by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]/div[1]")).click();

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), false);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), true);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys(Keys.BACK_SPACE);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys("2");
		/**
		 * Validate Window Btns
		 */
		List<WebElement> ForColmnBtns = log.driver.findElements(By.xpath("//span[contains(text(),'Properties of Element')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		for (WebElement btn : ForColmnBtns)
		{
			Thread.sleep(100);
			assertTrue(btn.isEnabled());
			System.out.println(btn.getAttribute("value") + "    is displayed and Enabled");
			test.info(btn.getAttribute("value") + "    is displayed and Enabled");
		}
		
		/**
		 * Validate Default Button And Validate
		 */
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@value='Default']");
		ForColmnBtns.get(3).click();
		ForColmnBtns.get(3).click();
		Thread.sleep(500);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Resetting the default settings of this page to default is not possible.']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Resetting the default settings of this page to default is not possible.']")).getText(),"Resetting the default settings of this page to default is not possible.");

		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		/**
		 * Click on Help
		 */
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//input[@id='helpbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='helpbutton'])[1]")).click();
		Thread.sleep(2000);
		
		//Switch to child window
		for(String winHandle : log.driver.getWindowHandles())
		{
			log.driver.switchTo().window(winHandle);
		}

		// Perform the actions on child window
		System.out.println("window title is " +log.driver.getTitle());
		test.info("window title is " +log.driver.getTitle());
		if(log.driver.getCurrentUrl().contains("help"))
		{
			assertTrue(true);
			System.out.println("Help window displayed ");
			test.info("Help window displayed ");

		}else{
			System.out.println("window url does not contain Help in it");
			test.info("window url does not contain Help in it");
		}

		//Close the new window if that window no more required
		log.driver.close();
		System.out.println("Help window closed ");
		test.info("Help window closed ");
		
		//Control to parent Window
		log.driver.switchTo().window(WindowHandle);
		System.out.println("Switch control to parent window");
		test.info("Switch control to parent window");
		Thread.sleep(500);
		/**
		 * 
		 */
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"(//input[@id='cancelbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='cancelbutton'])[1]")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='PERCENTAGE'])[2]//../div[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[text()='PERCENTAGE'])[2]//../div[1]/input")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//button[text()='Properties...']");
		log.driver.findElement(By.xpath("//button[text()='Properties...']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Properties of Element']")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li");
		List<WebElement> ElemntTabName =log.driver.findElements(By.xpath("//span[text()='Properties of Element']/following::div[5]/div[2]/div/div/div/ul/li"));
		Assert.assertEquals(ElemntTabName.get(0).getAttribute("aria-selected"), "true");
		System.out.println(ElemntTabName.get(0).getText() +"   is Selected");
		test.info(ElemntTabName.get(0).getText() +"   is Selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
		if(log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Priority']/../../../td[1]/a/span");
			log.driver.findElement(By.xpath("//span[text()='Priority']/../../../td[1]/a/span")).click();
			System.out.println("Priority button got expanded");
			test.info("Priority button got expanded");
		}else{
			System.out.println("Priority button expanded by default");
			test.info("Priority button expanded by default");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), true);
		System.out.println("Automatic Priority checkbox is selected by default");
		test.info("Automatic Priority checkbox is selected by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), false);
		System.out.println("explicit priority text box is disabled by default");
		test.info("explicit priority text box is disabled by default");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]/div[1]")).click();

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Automatic priority']/../../../td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Automatic priority']/../../../td[3]//input")).isSelected(), false);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).isEnabled(), true);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys(Keys.BACK_SPACE);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div");
		log.driver.findElement(By.xpath("//div[text()='Explicit priority']/../../../td[3]/table/tbody/tr/td/div/div/input[1]")).sendKeys("2");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Properties of Element')]/ancestor::div[2]/div[2]/div[2]/div[1]/input");
		List<WebElement> btn_ItemsCol  = log.driver.findElements(By.xpath("//span[contains(text(),'Properties of Element')]/ancestor::div[2]/div[2]/div[2]/div[1]/input"));
		btn_ItemsCol.get(0).click();
		btn_ItemsCol.get(0).click();
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[contains(text(),'Selection for Columns ')]");
		assertTrue(log.driver.findElement(By.xpath("//span[contains(text(),'Selection for Columns ')]")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//input[@id='okbutton']");
		log.driver.findElement(By.xpath("//input[@id='okbutton']")).click();
		Thread.sleep(2000);
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div");
		List<WebElement> TableColumnHdr = log.driver.findElements(By.xpath("(//div[text()='Australia'])[1]/ancestor::div[3]/div[3]/div/div"));
		for (WebElement webElement : TableColumnHdr) {
			if(webElement.getText().equals("Sales price")||webElement.getText().equals("PERCENTAGE")){
				assertTrue(true);
			}
		}
		System.out.println("Priority check is woking as expected");
        test.info("Priority check is woking as expected");
		log.driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
      }
	}
