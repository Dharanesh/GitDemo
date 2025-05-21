package action;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import event.ConfigData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import event.Excelnput;
import event.Utils;
import event.Waits;

abstract public class Login_BKP extends TestUtils
{
	//public WebDriver driver;
	//Waits waits = new Waits(driver);
	
//	String PackageLoc=System.getProperty("user.dir");
	
    //@Parameters("browserName")
//	public WebDriver get_Browser(String browser) {
//
//
//		if (browser.equalsIgnoreCase("Chrome"))
//		{
//		  //System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Report\\drivers\\chromedriver.exe");
//		  System.setProperty("webdriver.chrome.driver", PackageLoc+"\\drivers\\chromedriver.exe");
//		  ChromeOptions options = new ChromeOptions();
//
//		  options.addArguments("--lang=de-DE");
//		  driver.set(ChromeDriver(options);
//		  driver.manage().window().maximize();
//		}
//
//		else if  (browser.equalsIgnoreCase("firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver", "D:\\Automation\\Report\\drivers\\geckodriver.exe");
//			 driver = new FirefoxDriver();
//		}
//
//
//		return driver;
//
//
//	}
	
	public WebDriver login(WebDriver driver) throws Exception
	{
		
	
		Utils ui = new Utils(driver);
		Waits waits = new Waits(driver);
		Thread.sleep(1000);
		driver.get("http://localhost/Cockpit10");
		Thread.sleep(3000);
		//driver.get("http://192.168.103.77/C8cockpit");
		
		
		Excelnput ExcelData  = new Excelnput();
		
//		driver.findElement(By.id("w_212")).sendKeys("Admin");
		driver.findElement(By.xpath("//span[text()='Benutzername:']/following::input[1]")).click();
		driver.findElement(By.xpath("//span[text()='Benutzername:']/following::input[1]")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,1));
		driver.findElement(By.xpath("//span[text()='Passwort:']/following::input[1]")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,2));
		driver.findElement(By.id("okbutton")).click();
		Thread.sleep(2000);
		//return driver;
		
//		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[@class='cwFloatingPaneTitleText' and text()='Select Repository']");
//		WebDriverWait wait1 = new WebDriverWait(driver, 10);
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@src='./images/env.gif'])[2]")));
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[contains(text(),'C8 Cockpit PROFESSIONAL')]");
		
		driver.findElement(By.xpath("//span[contains(text(),'C8 Cockpit PROFESSIONAL')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='OK'])[1]")).click();

		
	return driver;
	}
	






	public void createReport(WebDriver driver,String cube) throws InterruptedException
	
	{
		
		Waits waits = new Waits(driver);
		
		driver.findElement(By.xpath("//img[@src='./images/new32.gif']")).click();
		Thread.sleep(2000);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[@class='cwFloatingPaneTitleText']");
//		WebDriverWait wait  =  new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cwFloatingPaneTitleText']")));
		
		driver.findElement(By.xpath("//*[text()='Next >>']")).click();
		Thread.sleep(2000);
		
//		WebDriverWait wait2  =  new WebDriverWait(driver,10);
//		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Select Cube']")));
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//*[text()='Select Cube']");
		Thread.sleep(2000);

		
		// Expand Pandra
		driver.findElement(By.xpath("//a[.='Pantara AS2008']/../a")).click();
//		Wait for expand
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//img[@src='./images/controls/trc_m.gif']");
		
//		click on Traning Sale		
		WebElement cubes = driver.findElement(By.xpath("//a[text()='"+cube+"']/../input"));
		cubes.click();
//		Check if cube is selected or not 
		boolean check = cubes.isSelected();
		assertTrue(check);
		
		driver.findElement(By.xpath("//*[text()='Next >>']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[@class='cwFloatingPaneTitleText' and text()='New Report']");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Finish']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//img[@src='./images/controls/mdi_cl.gif']");
		System.out.println("Report created sucessfully");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='./images/component_mngr32.gif']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[@lable='Components']");
		
	}
	


	public void deleteReport(String ReportName) throws InterruptedException 
	{	Utils ui = new Utils(driver);
		Thread.sleep(200);
		driver.findElement(By.xpath(getData("close_reprtXpath"))).click();
		Thread.sleep(600);
		try {
		driver.findElement(By.xpath(getData("yes"))).click();
		Thread.sleep(2000);
		}
		catch (Exception e) {
			// TODO: handle exception
			Thread.sleep(2000);}
		ui.rightClick("//*[text()='"+ReportName+"']");
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[text()='Report']/following::td[text()='Delete']")).click();
		Thread.sleep(600);
		driver.findElement(By.xpath(getData("yes"))).click();
		Thread.sleep(1000);
		driver.close();
		
		
	}

	public  void create_emptyReport() throws InterruptedException
	{
		Waits waits = new Waits(driver);
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//img[@src='./images/new32.gif']");
		driver.findElement(By.xpath("//img[@src='./images/new32.gif']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[text()='New Report']");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='New Report']")).isDisplayed(), true);
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Empty Report']/../../td[1]/input");
		driver.findElement(By.xpath("//span[text()='Empty Report']/../../td[1]/input")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//*[text()='Next >>']");
		driver.findElement(By.xpath("//*[text()='Next >>']")).click();
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//*[text()='Next >>']");
		driver.findElement(By.xpath("//*[text()='Next >>']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Finish']")).click();
		System.out.println("Empty report is created");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='./images/component_mngr32.gif']")).click();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[@lable='Components']");
	}


	public  void CreateStandrdReport(String ExcelsheetName,int Row,int Column,String SelectCubeXpath,String ReportLayoutXpath,boolean Layout)throws InterruptedException,NoSuchElementException
	{
		ConfigData web = new ConfigData();
		
		try
		  { 
		   ValidationPropertyUtil R9P=new ValidationPropertyUtil();
		   Utils Utils=new Utils(driver);
		   
		   //Create Report Button Validation:===========================
		   Assert.assertEquals(driver.findElement(By.xpath(web.getData("CreateNewReport"))).isDisplayed(),true);
		   Utils.waitForElement("");
		   Actions ActCreate=new Actions(driver);
		   ActCreate.doubleClick(driver.findElement(web.getObjectLocator("NewReportBtnXpath"))).perform();
		   try
		   {
			   Assert.assertEquals(driver.findElement(By.xpath(web.getData("NewreportHeaderXpath"))).isDisplayed(),true);
			   System.out.println("New Report window opened.");
		   }
		   catch(Exception e)
		   {
			   driver.findElement(web.getObjectLocator("NewReportBtnXpath")).click();
			   //Utils.waitForElement("");
			   Thread.sleep(3000);
		   }
		   Utils.waitForElement("");
		   Assert.assertEquals(driver.findElement(By.xpath(web.getData("NewreportHeaderXpath"))).isDisplayed(),true);
		   System.out.println("New Report window opened.");
		   
		   //By default Standard Report will be selected:===============
		   String ActStandrdReportMsg=driver.findElement(web.getObjectLocator("SelectReportMethodMsgXpath")).getText();
		   if(ActStandrdReportMsg.contains(R9P.ExptSelectReportMsgXpath))
		   {
			   //Standard Report Message Validation:=================================
			   System.out.println("Standard Report is selected for New report..");
			   Utils.waitForElement("");
			   driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
			   Utils.waitForElement("");
			   try
				{
					Assert.assertEquals(driver.findElement(By.xpath(web.getData("PantaraDBTextXpath"))).isDisplayed(),true);
					System.out.println("Cube Selection window is displaying.");
				}
				catch(Exception e2)
				{
					System.out.println("Cube Selection window is not displaying need to click Next again.");
					driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
					Utils.waitForElement("");
				}
			   
			   //select Cube Window and checking error message without select cube:==========================
			   String ActualDBName=driver.findElement(web.getObjectLocator("PantaraDBTextXpath")).getText();
			   Assert.assertEquals(ActualDBName,R9P.ExpectedDBName,R9P.DBErrorMsg);
			   Utils.waitForElement("");
			   Actions act=new Actions(driver);
			   act.doubleClick(driver.findElement(By.xpath(web.getData("PantaraDBExtend")))).perform();
			   try
				{
					Assert.assertEquals(driver.findElement(By.xpath(web.getData(SelectCubeXpath))).isDisplayed(),true);
				}
				catch(Exception e1)
				{
					System.out.println("PantaraDBExtend is not cliked 1st time need to click 2nd time.");
					Utils.waitForElement("");
					driver.findElement(By.xpath(web.getData("PantaraDBExtend"))).click();
					Utils.waitForElement("");
					//System.out.println("PantaraDBExtend is cliked 1st time.");
				}
				Utils.waitForElement("");
				//Cube Selection:===========================
				Assert.assertEquals(driver.findElement(By.xpath(web.getData(SelectCubeXpath))).isDisplayed(),true);
				System.out.println("Required cube name is displaying now.");
				Utils.waitForElement("");
				act.doubleClick(driver.findElement(By.xpath(web.getData(SelectCubeXpath)))).perform();
				Utils.waitForElement("");
				try
				{
					Assert.assertEquals(driver.findElement(By.xpath(web.getData(SelectCubeXpath))).isSelected(),true);
				}
				catch(Exception e1)
				{
					System.out.println("CubeName is not cliked 1st time need to click 2nd time.");
					Utils.waitForElement("");
					driver.findElement(By.xpath(web.getData(SelectCubeXpath))).click();
					Utils.waitForElement("");
					
				}
			   driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
			   Utils.waitForElement("");
			   //Dimension selection window validation:==============================
			   try
				{
					Assert.assertEquals(driver.findElement(By.xpath(web.getData("ReportDimensionSelcWindowHeaderXpath"))).isDisplayed(),true);
				}
				catch(Exception e2)
				{
					System.out.println("Next is clicking 2nd time.");
					driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
					Utils.waitForElement("");
				}
				Utils.waitForElement("");
				Assert.assertEquals(driver.findElement(By.xpath(web.getData("ReportDimensionSelcWindowHeaderXpath"))).isDisplayed(),true);
				System.out.println("Dimension selection window opened.");
				Utils.waitForElement("");
				driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
				Utils.waitForElement("");
				//Report Layout window Validation:============================
				Assert.assertEquals(driver.findElement(By.xpath(web.getData("ReportLayoutWindowHeaderXpath"))).isDisplayed(),true);
				System.out.println("Layout selection window opened.");
				Utils.waitForElement("");
				driver.findElement(web.getObjectLocator(ReportLayoutXpath)).click();
				Utils.waitForElement("");
				driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
				Utils.waitForElement("");
				//Filter component Window validation:==============================
				try
				{
				   if(driver.findElement(web.getObjectLocator("ReportFilterComponentTextXpath")).isDisplayed())
				   {
					   System.out.println("Report Filter Components window is opened..");
					   if(Layout)
					   {
						   System.out.println("User want to uncheck display filter..");
						   driver.findElement(web.getObjectLocator("DisplayFilterBarXpath")).click();
						   Utils.waitForElement("");
					   }
					   else
					   {
						   System.out.println("User don't want to uncheck display filter..");
					   }
				   }
			   }
			   catch(Exception e)
			   {
				   System.out.println("Report Filter Components window is not opened..");
			   }
			   driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
			   Utils.waitForElement("");
			   //What's next page validation:============================
			   try
				{
					Assert.assertEquals(driver.findElement(By.xpath(web.getData("WhatsNxtPageHeaderXpath"))).isDisplayed(),true);
					System.out.println("Whats next page is displaying.");
					driver.findElement(By.xpath(web.getData("next"))).click();
					Utils.waitForElement("");
				}
				catch(Exception e)
				{
					System.out.println("Whats next page is not displaying.");
				}
			   
			    //Name And Description validation:===========================
				//Utils.waitUntil_Textpresent(10, "nameAnddescription", "Name and Description");
				Utils.waitForElement("");
			    driver.findElement(web.getObjectLocator("NewReportInputXpath")).clear();
			    Utils.waitForElement("");
			    Excelnput Excelnput=new Excelnput();
			    driver.findElement(web.getObjectLocator("NewReportInputXpath")).sendKeys(Excelnput.ExcelDatainput(ExcelsheetName,Row,Column));
			    Utils.waitForElement("");
			    driver.findElement(web.getObjectLocator("FinishBtnXpath")).click();
			    Utils.waitForElement("");
			    //After create validation:=====================
				String ReportName=Excelnput.ExcelDatainput(ExcelsheetName,Row,Column);
				System.out.println("Report Name "+ReportName);
				Assert.assertEquals(driver.findElement(By.xpath("//a[text()='"+ReportName+"']/following::td[1]/a[1]/img[1]")).isDisplayed(),true);
				Utils.waitForElement("");
			    System.out.println("New Standard Report is created properly.");
			    Reporter.log("New Standard Report is created properly.");
		   	}
		   	else
		   	{
			   System.out.println("Standard Report is not selected for New report..");
		   	}
		   
		    }
		   catch(Exception e)
		    {
			   e.printStackTrace();
			   System.out.println("Report not created properly.");
			   Reporter.log("Report not created properly.");
		    }
	}


	
	
//	public void ()
//	
//	{
//		
//		
//		
//	}

	

	
}
