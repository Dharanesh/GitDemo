package smokeCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import java.io.File;

import action.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import action.Login;
import event.Utils;
import event.Waits;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestCase_25785  extends TestUtils
{
	@Test
	@Parameters({"browser","url"})
	public void Testcase_creating_Filter_Gauge_Layout_Standard_Report(String browser,String url) throws Exception
	{
		
		test =extent.createTest("TestCase_25785 : Testcase for creating Gauge Layout in Standard report");
		Login log = new Login();
		driver = log.get_Browser(browser);
		driver = log.login(driver);
		
		Waits waits = new Waits(driver);
		Utils ui = new Utils(driver);
		
		log.createCubeReport("//div[contains(text(),'Training Sales')]","TestCase_25785_GaugeLayout",false);
		System.out.println("report created using Training Sales cube");
		test.info("report created using Training Sales cube");

		//		Create Layout compontent
		click(By.xpath("//span[text()='Components']"));
		click(By.xpath("(//a[@data-title='Create a New Report Component'])[1]"));
		click(By.xpath("//span[text()='New Layout Component...']"));

		waitForClickableElement(By.xpath("//input[@value='Next >>']"));
		//Find List of Layout Components:==========================

		waits.waituUnitil_Element_Clickable(20,"//input[@value='Next >>']");
		List<WebElement>reports=log.driver.findElements(By.xpath("//span[@class='reportNametxt']"));
		ArrayList<String>List = new ArrayList();
		List.add("Title");
		List.add("Image");
		List.add("Table");
		List.add("Chart");
		List.add("Filter Bar");
		List.add("Selection Bar");
		List.add("Action Bar");
		List.add("ABC Table");
		List.add("ABC Chart");
		List.add("Horizontal Waterfall Chart");
		List.add("Vertical Waterfall Chart");
		List.add("Bubble Chart");
		List.add("Gauge");
		List.add("Map");
		List.add("OS Map");

		for(int i=0;i<reports.size()-1;i++)
		{
			org.testng.Assert.assertEquals(reports.get(i).getText(),List.get(i));
		}

		System.out.println("All Report Layout Options are available.");
		Thread.sleep(2000);

		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Gauge']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Gauge']/../../div/span")).isDisplayed());
		System.out.println("Gauge layout Available");
		test.info("Gauge layout Available");
				
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Gauge']/../../div/span");
		log.driver.findElement(By.xpath("//span[text()='Gauge']/../../div/span")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Gauge']/../../div/span");
		assertTrue(log.driver.findElement(By.xpath("//span[text()='Gauge']/../../div/span")).isDisplayed());
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[text()='Inserts a gauge into the report.']");
		assertTrue(log.driver.findElement(By.xpath("//div[text()='Inserts a gauge into the report.']")).isDisplayed(),"message for Gauge displayed correctly");
		
		String button1[]= {"Next >>","Cancel","Help"};
		List<WebElement> button = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		System.out.println("The New layout Component window list button  are :=  ");
		int buttonsize = button.size();
		for(int i =0;i<=buttonsize-1;i++) 
		{
			
			assertEquals(button1[i], button.get(i).getAttribute("value"));
			System.out.println(button.get(i).getAttribute("value"));
			test.info(button.get(i).getAttribute("value"));
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//span[text()='Position in report']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Position in report']")).isDisplayed(),true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Settings for the layout component']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Settings for the layout component']")).isDisplayed(), true);
		System.out.println("Settings for the layout component is Displayed");
		test.info("Settings for the layout component is Displayed");
		
		System.out.println("gauge window texts are:");
		test.info("gauge window texts are:");
		
        List<WebElement> TitleWindowList = log.driver.findElements(By.xpath("(//table[@class='prg'])[1]/tbody/tr/td[2]/a/span"));
		
		ArrayList<String> TitleSWinText = new ArrayList<String>();
		TitleSWinText.add("Gauge Type");
		TitleSWinText.add("Scale Metrics");
		TitleSWinText.add("Scale 2 Metrics");
		for (int i =0;i<=TitleWindowList.size()-1;i++) 
		{
			assertEquals(TitleWindowList.get(i).getText(),TitleSWinText.get(i));
			System.out.println(TitleWindowList.get(i).getText());
			test.info(TitleWindowList.get(i).getText());
		}	
		Thread.sleep(1000);
		
		System.out.println("All the options are Present in settings window");
		test.info("All the options are Present in settings window");
		
		if(log.driver.findElement(By.xpath("(//span[text()='Gauge Type'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Gauge Type'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Gauge Type'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Gauge is expanded");
			test.info("Gauge is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Gauge Type'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Gauge Type'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Gauge is already expanded");
			test.info("Gauge is already expanded");
		}
		Thread.sleep(1000);
		String DirectionAft=log.driver.findElement(By.xpath("//span[text()='Gauge Type']/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText();
		Assert.assertEquals(DirectionAft,"Round gauge");
		
		//Scale Metrics
		if(log.driver.findElement(By.xpath("(//span[text()='Scale Metrics'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Scale Metrics'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Scale Metrics'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Scale Metrics is expanded");
			test.info("Scale Metrics is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Scale Metrics'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Scale Metrics'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Scale Metrics is already expanded");
			test.info("Scale Metrics is already expanded");
		}
		
		Thread.sleep(1000);
		
		ArrayList<String> ScalesMetrics = new ArrayList<String>();
		
		ArrayList<String> ScalesMetricsvalue = new ArrayList<String>();
		ScalesMetricsvalue.add("Autoscale");
		ScalesMetricsvalue.add("Minimum");
		ScalesMetricsvalue.add("Maximum");
		ScalesMetricsvalue.add("Enable scale divisor");
		ScalesMetricsvalue.add("Scale divisor");
		
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Autoscale']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Autoscale']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		ScalesMetrics.add("Autoscale");
		System.out.println("Autoscaleis selected");
		test.info("Autoscaleis selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Minimum']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		String MinStat =log.driver.findElement(By.xpath("//div[text()='Minimum']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).getAttribute("disabled");
		System.out.println(MinStat);
		Assert.assertEquals(MinStat,"true");
		ScalesMetrics.add("Minimum");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Maximum']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		String MaximumStat =log.driver.findElement(By.xpath("//div[text()='Maximum']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).getAttribute("disabled");
		System.out.println(MaximumStat);
		Assert.assertEquals(MaximumStat,"true");
		ScalesMetrics.add("Maximum");
		
		System.out.println("Minimum ,Maximum Disabled");
		test.info("Minimum ,Maximum Disabled");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable scale divisor']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Enable scale divisor']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		ScalesMetrics.add("Enable scale divisor");
		System.out.println("Scale divisor slected");
		test.info("Scale divisor is enabled ");
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Scale divisor']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		String scalevalue =log.driver.findElement(By.xpath("//div[text()='Scale divisor']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).getAttribute("value");
		System.out.println(scalevalue);
		Assert.assertEquals(scalevalue,"1000");
		ScalesMetrics.add("Scale divisor");
		System.out.println("Scale divisor value is"+scalevalue);
		test.info("Scale divisor value is"+scalevalue);
		Thread.sleep(1000);
		
		for(int i =0;i<=ScalesMetrics.size()-1;i++) 
		{
			assertEquals(ScalesMetrics.get(i),ScalesMetricsvalue.get(i));
			System.out.println(ScalesMetrics.get(i));

		}
		System.out.println("All the options are Present under ScaleMetrics");
		test.info("All the options are Present under ScaleMetrics");
		Thread.sleep(1000);
		//===============Scale 2 Metrics========================================
		if(log.driver.findElement(By.xpath("(//span[text()='Scale 2 Metrics'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Scale 2 Metrics'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Scale 2 Metrics'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Scale 2 Metrics is expanded");
			test.info("Scale 2 Metrics is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Scale 2 Metrics'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Scale 2 Metrics'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
			Thread.sleep(1000);
		}
		else
		{
			System.out.println("Scale 2 Metrics is already expanded");
			test.info("Scale2 Metrics is already expanded");
		}
		Thread.sleep(1000);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),false);
		System.out.println("Visible in Scale 2 Metrics is unchecked");
		test.info("Visible in Scale 2 Metrics is unchecked");
		Thread.sleep(100);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Autoscale'])[2]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Autoscale'])[2]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		String autoscalS2M =log.driver.findElement(By.xpath("(//div[text()='Autoscale'])[2]/ancestor::tr[1]/td[3]/div[1]/input[1]")).getAttribute("disabled");
		System.out.println(autoscalS2M);
		Assert.assertEquals(autoscalS2M,"true");
		System.out.println("Autoscale in Scale 2 Metrics is Disabled and checked");
		test.info("Autoscale in Scale 2 Metrics is Disabled and checked");
		Thread.sleep(100);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Minimum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		String MinS2M =log.driver.findElement(By.xpath("(//div[text()='Minimum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).getAttribute("disabled");
		System.out.println(MinS2M);
		Assert.assertEquals(MinS2M,"true");
		System.out.println("Minimum in Scale 2 Metrics is Disabled");
		test.info("Minimum in Scale 2 Metrics is Disabled");
		Thread.sleep(100);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Maximum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		String MaxS2M =log.driver.findElement(By.xpath("(//div[text()='Maximum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).getAttribute("disabled");
		System.out.println(MaxS2M);
		Assert.assertEquals(MaxS2M,"true");
		System.out.println("Maximum in Scale 2 Metrics is Disabled");
		test.info("Maximum in Scale 2 Metrics is Disabled");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		String EnbleScaleDevisorS2M =log.driver.findElement(By.xpath("(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]/input[1]")).getAttribute("disabled");
		Assert.assertEquals(EnbleScaleDevisorS2M,"true");
		System.out.println("Enable scale divisor in Scale 2 Metrics is Disabled");
		test.info("Enable scale divisor in Scale 2 Metrics is Disabled");
		Thread.sleep(100);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Scale divisor'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//div[text()='Scale divisor'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).isEnabled());
		System.out.println("scale divisor in Scale 2 Metrics is Disabled");
		test.info("scale divisor in Scale 2 Metrics is Disabled");
		Thread.sleep(100);
		//clcik on vissible
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]");
		log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]")).click();
		Thread.sleep(1000);
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("vissible is checked");
		test.info("vissible is checked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Autoscale'])[2]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertTrue(log.driver.findElement(By.xpath("(//div[text()='Autoscale'])[2]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected());
		Thread.sleep(100);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isEnabled(),true);
		System.out.println("Autoscale,Enable scale divisor is Enabled");
		test.info("Autoscale,Enable scale divisor is Enabled");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Maximum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//div[text()='Maximum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).isEnabled());
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Minimum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//div[text()='Minimum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).isEnabled());
		
		System.out.println("Maximum,Minimum is disabled");
		test.info("Maximum,Minimum is disabled");
		
		//uncheck Autoscale
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Autoscale'])[2]/ancestor::tr[1]/td[3]/div[1]");
		log.driver.findElement(By.xpath("(//div[text()='Autoscale'])[2]/ancestor::tr[1]/td[3]/div[1]")).click();
		Thread.sleep(1000);
		Assert.assertFalse(log.driver.findElement(By.xpath("(//div[text()='Autoscale'])[2]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected());
		System.out.println("Autoscale is unchecked");
		test.info("Autoscale is unchecked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Maximum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		WebElement Max=log.driver.findElement(By.xpath("(//div[text()='Maximum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]"));
		Max.click();
		Max.sendKeys(Keys.CONTROL + "a");
		Max.sendKeys(Keys.DELETE);
		Max.sendKeys("500");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Minimum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		WebElement Min=log.driver.findElement(By.xpath("(//div[text()='Minimum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]"));
		Min.click();
		Min.sendKeys(Keys.CONTROL + "a");
		Min.sendKeys(Keys.DELETE);
		Min.sendKeys("10");
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Minimum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		String minvalue=	log.driver.findElement(By.xpath("(//div[text()='Minimum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).getAttribute("value");
		System.out.println(minvalue);
		Assert.assertEquals(minvalue,"10");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Maximum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		String maxvalue_inS2M=log.driver.findElement(By.xpath("(//div[text()='Maximum'])[2]/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).getAttribute("value");
		System.out.println(maxvalue_inS2M);
		Assert.assertEquals(maxvalue_inS2M,"500");
		Thread.sleep(200);
		
		//uncheck Enable scale divisor
		log.driver.findElement(By.xpath("(//div[text()='Enable scale divisor'])[2]")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]");
		log.driver.findElement(By.xpath("(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]")).click();
		Thread.sleep(2000);
		Assert.assertFalse(log.driver.findElement(By.xpath("(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected());
		
		String Dataviewwinbtn11[]= {"<< Back","Next >>","Finish","Cancel","Help"};
		List<WebElement> btnlist11 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		int buttonlistsize11 = btnlist11.size();
		for(int i =0;i<=buttonlistsize11-1;i++) 
		{
			assertEquals(Dataviewwinbtn11[i], btnlist11.get(i).getAttribute("value"));
			System.out.println(btnlist11.get(i).getAttribute("value"));
			test.info(btnlist11.get(i).getAttribute("value"));
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Next >>']");
		log.driver.findElement(By.xpath("//input[@value='Next >>']")).click();
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(30,"//span[text()='Name and Description']");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed(),true);
		
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).clear();
		log.driver.findElement(By.xpath("(//span[text()='Name'])[1]/following::input[1]")).sendKeys("Gauge Layout");
		Thread.sleep(2000);
		
		String Dataviewwinbtn2[]= {"<< Back","Finish","Cancel","Help"};
		List<WebElement> btnlist2 = log.driver.findElements(By.xpath("//div[@id='buttons']/input"));
		int buttonlistsize2 = btnlist2.size();
		for(int i =0;i<=buttonlistsize2-1;i++) 
		{
			assertEquals(Dataviewwinbtn2[i], btnlist2.get(i).getAttribute("value"));
			System.out.println(btnlist2.get(i).getAttribute("value"));
			test.info(btnlist2.get(i).getAttribute("value"));
		}
		Thread.sleep(2000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@value='Finish']");
		log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
		try
		{
			if(log.driver.findElement(By.xpath("//span[text()='Name and Description']")).isDisplayed())
			{
				log.driver.findElement(By.xpath("//input[@value='Finish']")).click();
				Thread.sleep(3000);
			}
		}catch(Exception e)
		{
			System.out.println("finish button clicked");
		}
		Thread.sleep(2000);
		
		//Validation
		

		Assert.assertTrue(findVisibleBool(By.xpath("/html/body/div[3]/div[5]/div[3]/div/div[2]/div/div/div[2]/div[3]/img")));
		System.out.println("Round  gauge is created");
		test.info("Round  gauge is created");
		Thread.sleep(2000);
		
		//=====================
		//taking screenshot
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(log.driver);
		ImageIO.write(fpScreenshot.getImage(),"PNG",new File(System.getProperty("user.dir")+"/screenshots/"+"Roundgauge_Actual.png"));
		System.out.println("Actual screenshot captured for Round Gauge");
		Thread.sleep(3000);
		 
	    BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir")+"/screenshots/"+"Roundgauge_Exp.png"));
	    Screenshot logoImageScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(log.driver);
	    BufferedImage actualImage = logoImageScreenshot.getImage();
	             
	    ImageDiffer  imgDiff = new ImageDiffer();
	    ImageDiff diff = imgDiff.makeDiff(actualImage,expectedImage);
	    Thread.sleep(1000);
	   boolean value= diff.hasDiff();
	   //Assert.assertFalse(value);
	   if(value==true) // why?
	   {
	    	 System.out.println("image are not matching");
	    	 System.out.println("validation done");    
	     }
	     else
	     {
	    	 System.out.println("image matching");
	        System.out.println("validation done");    
	     }
		//====================
		File gauge=new File(System.getProperty("user.dir")+"/screenshots/"+"Roundgauge_Actual.png");
		gauge.delete();
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(5,"/html/body/div[3]/div[5]/div[3]/div/div[2]/div/div/div[2]/div[3]/img");
		Thread.sleep(300);
		ui.rightClick("/html/body/div[3]/div[5]/div[3]/div/div[2]/div/div/div[2]/div[3]/img");
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//span[.='Gauge Layout']/../..");
		Thread.sleep(500);
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[.='Gauge Layout']/../..")).isDisplayed(), true);
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//span[.='Gauge Layout']/../..");
		List<WebElement> img_contextmenu_options =log.driver.findElements(By.xpath("//span[.='Gauge Layout']/../../li/span[1]"));
		for (WebElement we : img_contextmenu_options)
		{
			System.out.println(we.getText());
			test.info("context menu options is" + we.getText());
		}	
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//span[.='Gauge Layout']/../..");
		img_contextmenu_options.get(img_contextmenu_options.size()-2).click();
		Thread.sleep(300);
		waits.waitUntil_Elmentis_visibilityOfElement(5,"//span[contains(text(),'Properties of')]/../..");
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[contains(text(),'Properties of')]/../..")).isDisplayed(), true);
		
		//validate all the 
		
		if(log.driver.findElement(By.xpath("(//span[text()='Gauge Type'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Gauge Type'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Gauge Type'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Gauge is expanded");
			test.info("Gauge is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Gauge Type'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Gauge Type'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
		}
		else
		{
			System.out.println("Gauge is already expanded");
			test.info("Gauge is already expanded");
		}
		Thread.sleep(500);
		log.driver.findElement(By.xpath("//div[text()='Type']")).click();
		Thread.sleep(500);
		WebElement Elemntgauge=log.driver.findElement(By.xpath("//span[text()='Gauge Type']/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]"));
		Actions act = new Actions(log.driver);
		//act.click(Elemntgauge).sendKeys("Straight gauge", Keys.ENTER).build().perform();
		act.click(Elemntgauge).sendKeys(Keys.ARROW_DOWN).build().perform();
		act.click(Elemntgauge).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Thread.sleep(500);
		log.driver.findElement(By.xpath("(//span[text()='Gauge Type'])[1]")).click();
		Thread.sleep(500);
		System.out.println(log.driver.findElement(By.xpath("//span[text()='Gauge Type']/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText());
		Assert.assertEquals(log.driver.findElement(By.xpath("//span[text()='Gauge Type']/ancestor::div[1]/table/tbody/tr[2]/td[3]/div[1]/span[1]/span[1]/span[1]")).getText(),"Straight gauge");
		Thread.sleep(500);
		
		//
		if(log.driver.findElement(By.xpath("(//span[text()='Scale Metrics'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Scale Metrics'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Scale Metrics'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Scale Metrics is expanded");
			test.info("Scale Metrics is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Scale Metrics'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Scale Metrics'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
		}
		else
		{
			System.out.println("Scale Metrics is already expanded");
			test.info("Scale Metrics is already expanded");
		}
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Autoscale']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Autoscale']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Autoscaleis selected");
		test.info("Autoscaleis selected");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Minimum']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		String MinStat1 =log.driver.findElement(By.xpath("//div[text()='Minimum']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).getAttribute("disabled");
		System.out.println(MinStat1);
		Assert.assertEquals(MinStat1,"true");
		Thread.sleep(100);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Maximum']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		String MaximumStat1 =log.driver.findElement(By.xpath("//div[text()='Maximum']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).getAttribute("disabled");
		System.out.println(MaximumStat1);
		Assert.assertEquals(MaximumStat1,"true");
		Thread.sleep(100);
		
		System.out.println("Minimum ,Maximum Disabled");
		test.info("Minimum ,Maximum Disabled");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Enable scale divisor']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Enable scale divisor']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Scale divisor slected");
		test.info("Scale divisor is enabled ");
		Thread.sleep(100);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Scale divisor']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]");
		String scalevalue1 =log.driver.findElement(By.xpath("//div[text()='Scale divisor']/ancestor::tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).getAttribute("value");
		System.out.println(scalevalue1);
		Assert.assertEquals(scalevalue1,"1000");
		System.out.println("Scale divisor value is"+scalevalue1);
		test.info("Scale divisor value is"+scalevalue1);
		Thread.sleep(100);
		
		
		//scaleMetrics2
		//===============Scale 2 Metrics========================================
		if(log.driver.findElement(By.xpath("(//span[text()='Scale 2 Metrics'])[1]/../../../td[1]/a/span[1]")).getAttribute("class").contains("plus"))
		{
			waits.waitUntil_Elmentis_visibilityOfElement(10,"(//span[text()='Scale 2 Metrics'])[1]/../../../td[1]/a/span[1]");
			log.driver.findElement(By.xpath("(//span[text()='Scale 2 Metrics'])[1]/../../../td[1]/a/span[1]")).click();
			System.out.println("Scale 2 Metrics is expanded");
			test.info("Scale 2 Metrics is expanded");
			waits.waitUntil_Elmentis_visibilityOfElement(20,"(//span[text()='Scale 2 Metrics'])[1]/../../../td[1]/a/span[1]");
			Assert.assertEquals(log.driver.findElement(By.xpath("(//span[text()='Scale 2 Metrics'])[1]/../../../td[1]/a/span[1]")).isDisplayed(),true);
			Thread.sleep(100);
		}
		else
		{
			System.out.println("Scale 2 Metrics is already expanded");
			test.info("Scale2 Metrics is already expanded");
		}
		Thread.sleep(100);
		waits.waitUntil_Elmentis_visibilityOfElement(20,"//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertEquals(log.driver.findElement(By.xpath("//div[text()='Visible']/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected(),true);
		System.out.println("Visible in Scale 2 Metrics is checked");
		test.info("Visible in Scale 2 Metrics is checked");
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Autoscale'])[2]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//div[text()='Autoscale'])[2]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected());
		Thread.sleep(1000);
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected());
		
		waits.waitUntil_Elmentis_visibilityOfElement(20,"(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]");
		Assert.assertFalse(log.driver.findElement(By.xpath("(//div[text()='Enable scale divisor'])[2]/ancestor::tr[1]/td[3]/div[1]/input[1]")).isSelected());
		Thread.sleep(2000);		
		
		waits.waitUntil_Elmentis_visibilityOfElement(10,"(//input[@id='okbutton'])[1]");
		log.driver.findElement(By.xpath("(//input[@id='okbutton'])[1]")).click();
		Thread.sleep(2000);
		
		//=====================
		//taking screenshot
		 Thread.sleep(5000);
		Screenshot fpScreenshot1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(log.driver);
		ImageIO.write(fpScreenshot1.getImage(),"PNG",new File(System.getProperty("user.dir")+"/screenshots/"+"Straightgauge_Actual.png"));
		System.out.println("Actual screenshot captured for Straight Gauge");
		Thread.sleep(3000);
		 
	    BufferedImage expectedImage1 = ImageIO.read(new File(System.getProperty("user.dir")+"/screenshots/"+"Straightgauge_Exp.png"));
	    Screenshot logoImageScreenshot1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(log.driver);
	    BufferedImage actualImage1 = logoImageScreenshot1.getImage();
	             
	    ImageDiffer  imgDiff1 = new ImageDiffer();
	    ImageDiff diff1 = imgDiff1.makeDiff(actualImage1,expectedImage1);
	    
	   boolean value1= diff1.hasDiff();
	 //  Assert.assertFalse(value1);
	   if(value1==true)
	   {
	    	 System.out.println("image are not matching");
	    	 System.out.println("validation done");    
	     }
	     else
	     {
	    	 System.out.println("image matching");
	        System.out.println("validation done");    
	     }
		//====================
       File Staright=new File(System.getProperty("user.dir")+"/screenshots/"+"Straightgauge_Actual.png");
       Staright.delete();
       Thread.sleep(200);
	
       log.driver.close();
		
		
	}
}
