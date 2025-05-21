package action;

import event.Excelnput;
import event.Utils;
import event.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static action.ThreadLocalWebDriverFactory.getDriverSafe;
import static action.ThreadLocalWebDriverFactory.setDriver;

public class Login extends TestUtils
{
	//public WebDriver driver;
	//Waits waits = new Waits(driver);
	
	String PackageLoc = System.getProperty("user.dir");
	
    //@Parameters("browserName")
	public WebDriver get_Browser(String browser) {
		// TODO: remove this function, use set driver instead

		setDriver(browser);

		builder = new Actions(getDriverSafe());
		
//		if (browser.equalsIgnoreCase("chrome"))
//		{
//		  //System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Report\\drivers\\chromedriver.exe");
//		  System.setProperty("webdriver.chrome.driver", PackageLoc+"\\src\\main\\resources\\drivers\\chromedriver.exe");
//		  driver = new ChromeDriver();
//		  driver.manage().window().maximize();
//		}
//
//		else if  (browser.equalsIgnoreCase("firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver", PackageLoc+"\\src\\main\\resources\\drivers\\geckodriver.exe");
//			 driver = new FirefoxDriver();
//			 driver.manage().window().maximize();
//		}
//		else if  (browser.equalsIgnoreCase("edge"))
//		{
//			  System.setProperty("webdriver.edge.driver", PackageLoc+"\\src\\main\\resources\\drivers\\msedgedriver.exe");
////			 System.setProperty("webdriver.edge.driver", PackageLoc+"\\drivers\\MicrosoftWebDriver.exe");
//			 driver = new EdgeDriver();
//			 driver.manage().window().maximize();
//		}


		return getDriverSafe();
	}
	
	public WebDriver login(WebDriver driver) throws Exception
	{
		Waits waits = new Waits(driver);

		//driver.get("http://192.168.92.24/Cockpit10");
		driver.get("http://192.168.225.123/Cockpit10");
		//new code ###########start#############
		//C10 Cockpit:=====
		Assert.assertTrue(findVisibleBool(By.xpath("//span[text()='Log On C8 Server']")));
		
		try {
			//C10 Cockpit:=====
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@class='k-input server-name']");
			driver.findElement(By.xpath("//input[@class='k-input server-name']")).click();
		}
		catch(Exception e) {
			driver.navigate().refresh();
			System.out.println("page got refereshed");
			System.out.println("logon window is not displayed Properly");
		}
		//new code ################end###################
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[@class='w20_combobox']/span/span/span[1]");
		String Value = driver.findElement(By.xpath("//div[@class='w20_combobox']/span/span/span[1]")).getText();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[@class='w20_combobox']/span/span/span[1]");
		Assert.assertEquals(Value,"Normal");
		System.out.println(Value);
		System.out.println("Autentication is set to normal ");
		
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@type='button']");
		List<WebElement> LoginBtn= driver.findElements(By.xpath("//input[@type='button']"));
		
		//List<WebElement> LoginBtn1= driver.findElement(By.xpath("//input[@type='button']")).getAttribute("value");
		
		ArrayList<String> btn_win = new ArrayList<String>();
		btn_win.add("OK");
		btn_win.add("Cancel");
		btn_win.add("Help");
		
		System.out.println("Login Button size is:->"+LoginBtn.size());

		for(int i =0;i<LoginBtn.size()-1;i++) {
		  Assert.assertEquals(LoginBtn.get(i).getAttribute("value"),btn_win.get(i));
		  System.out.println(LoginBtn.get(i).getAttribute("value") +" "+btn_win.get(i));
		}
		
		System.out.println("Actions Button in C10 log on server is Present");
		
		//No Symbols Available in C10:==============
		//waits.waitUntil_Elmentis_visibilityOfElement(10, "//img[@src='./images/logon32.gif']");
		
		Excelnput ExcelData  = new Excelnput();
		System.out.println(ExcelData.ExcelDatainput("Standard_SDL_Container",1,1));
		
		//Enter Valid userName and input details:=============================
		/*driver.findElement(By.xpath("//input[@id='w_187']")).click();
		driver.findElement(By.xpath("//input[@id='w_187']")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,1));
		driver.findElement(By.xpath("//input[@id='w_188']")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,2));
		driver.findElement(By.xpath("//input[@class='k-input server-name']")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,3));
		driver.findElement(By.xpath("//input[@type='button'][1]")).click();*/
		
		
		driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).click();
		driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,1));

		driver.findElement(By.xpath("//span[text()='Password:']/following::input[1]")).click();
		driver.findElement(By.xpath("//span[text()='Password:']/following::input[1]")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,2));
        //driver.findElement(By.xpath("//input[@class='k-input server-name']")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,3));
		driver.findElement(By.xpath("//input[@class='k-input server-name']")).sendKeys("localhost:10901");
		driver.findElement(By.xpath("//input[@type='button'][1]")).click();
		
		//Wait till Repository Availability and select professional:====================
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select Repository']");
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='C8 Cockpit PROFESSIONAL']");
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).isDisplayed(), true);
		driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).click();
		
		//Language field:====================
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[@class='k-input'])[1]");
		String ValueLang = driver.findElement(By.xpath("(//span[@class='k-input'])[1]")).getText();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[@class='k-input'])[1]");
		System.out.println(ValueLang);
		
		//Language set done:================
		Assert.assertEquals(ValueLang, "<neutral>");
		System.out.println("Language is set to neutral ");
		
		
		//Ok Button Presence check:===========
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[@class='w20_modal-footer-wrapper'])[1]/input[1]");
		
		List<WebElement> RepBtn = driver.findElements(By.xpath("(//div[@class='w20_modal-footer-wrapper'])[1]/input"));
		ArrayList<String> Repbtn_win = new ArrayList<String>();
		Repbtn_win.add("OK");
		Repbtn_win.add("Cancel");
		Repbtn_win.add("Help");
		
		for(int i =0;i<RepBtn.size()-1;i++) {
			Assert.assertEquals(RepBtn.get(i).getAttribute("value"), Repbtn_win.get(i));
			System.out.println(RepBtn.get(i).getText());
		}

		System.out.println(" Actions Button in repository window is Present");
		
		
		//Validate ok Button availability and click Ok Button:=========================
		waitForVisibilityOfElement(By.xpath("(//input[@id='okbutton'])[1]"));
		Assert.assertEquals(findVisible(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).getCssValue("font-weight"), "400", "Repository got highlighted");

//		implicitWaitSeconds(5);

		clickableClick(By.xpath("(//input[@id='okbutton'])[1]"));

		waitForAjax();

		//After Login Image Validate:==================
//		waitForVisibilityOfElement(By.xpath("//img[@src='image.aspx?svid=0&id=1_1']"));
//		waitForVisibilityOfElement(By.xpath("//body[@class='ajaxLoading']"));
//		clickableClick(By.xpath("//span[@id='tab_close_btn']"));
//		waitForInvisibilityOfElement(By.xpath("//span[@id='tab_close_btn']"));
		System.out.println("Login Successfully");

		// TODO
		//Not Available:============
		//waits.waituUnitil_Element_InvisiblityofElement(10,"//*[@title='Show DataView Designer']");
		
		//Doubt need to work:============
		//waits.waituUnitil_Element_InvisiblityofElement(10,"//span[text()='Navigator']");
		
		return driver;
	}

	public WebDriver login(WebDriver driver, String url) throws Exception
	{
		Waits waits = new Waits(driver);
		driver.get("http://"+url+"/Cockpit10");
		//driver.get("http://192.168.92.24/Cockpit10");
		//driver.get("http://192.168.103.39/cockpit10");
		//new code ###########start#############
		//C10 Cockpit:=====
		Assert.assertTrue(findVisibleBool(By.xpath("//span[text()='Log On C8 Server']")));

		try {
			//C10 Cockpit:=====
			waits.waitUntil_Elmentis_visibilityOfElement(10,"//input[@class='k-input server-name']");
			driver.findElement(By.xpath("//input[@class='k-input server-name']")).click();
		}
		catch(Exception e) {
			driver.navigate().refresh();
			System.out.println("page got refereshed");
			System.out.println("logon window is not displayed Properly");
		}
		//new code ################end###################
		waits.waitUntil_Elmentis_visibilityOfElement(10,"//div[@class='w20_combobox']/span/span/span[1]");
		String Value = driver.findElement(By.xpath("//div[@class='w20_combobox']/span/span/span[1]")).getText();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[@class='w20_combobox']/span/span/span[1]");
		Assert.assertEquals(Value,"Normal");
		System.out.println(Value);
		System.out.println("Autentication is set to normal ");

		waits.waitUntil_Elmentis_visibilityOfElement(10, "//input[@type='button']");
		List<WebElement> LoginBtn= driver.findElements(By.xpath("//input[@type='button']"));

		//List<WebElement> LoginBtn1= driver.findElement(By.xpath("//input[@type='button']")).getAttribute("value");

		ArrayList<String> btn_win = new ArrayList<String>();
		btn_win.add("OK");
		btn_win.add("Cancel");
		btn_win.add("Help");

		System.out.println("Login Button size is:->"+LoginBtn.size());

		for(int i =0;i<LoginBtn.size()-1;i++) {
			Assert.assertEquals(LoginBtn.get(i).getAttribute("value"),btn_win.get(i));
			System.out.println(LoginBtn.get(i).getAttribute("value") +" "+btn_win.get(i));
		}

		System.out.println("Actions Button in C10 log on server is Present");

		//No Symbols Available in C10:==============
		//waits.waitUntil_Elmentis_visibilityOfElement(10, "//img[@src='./images/logon32.gif']");

		Excelnput ExcelData  = new Excelnput();
		System.out.println(ExcelData.ExcelDatainput("Standard_SDL_Container",1,1));

		//Enter Valid userName and input details:=============================
		/*driver.findElement(By.xpath("//input[@id='w_187']")).click();
		driver.findElement(By.xpath("//input[@id='w_187']")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,1));
		driver.findElement(By.xpath("//input[@id='w_188']")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,2));
		driver.findElement(By.xpath("//input[@class='k-input server-name']")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,3));
		driver.findElement(By.xpath("//input[@type='button'][1]")).click();*/


		driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).click();
		driver.findElement(By.xpath("//span[text()='User Name:']/following::input[1]")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,1));

		driver.findElement(By.xpath("//span[text()='Password:']/following::input[1]")).click();
		driver.findElement(By.xpath("//span[text()='Password:']/following::input[1]")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,2));
		//driver.findElement(By.xpath("//input[@class='k-input server-name']")).sendKeys(ExcelData.ExcelDatainput("Standard_SDL_Container",1,3));
		driver.findElement(By.xpath("//input[@class='k-input server-name']")).sendKeys("localhost:10901");
		driver.findElement(By.xpath("//input[@type='button'][1]")).click();

		//Wait till Repository Availability and select professional:====================
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='Select Repository']");
		waits.waitUntil_Elmentis_visibilityOfElement(10, "//span[text()='C8 Cockpit PROFESSIONAL']");

		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).isDisplayed(), true);
		driver.findElement(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).click();

		//Language field:====================
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[@class='k-input'])[1]");
		String ValueLang = driver.findElement(By.xpath("(//span[@class='k-input'])[1]")).getText();
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//span[@class='k-input'])[1]");
		System.out.println(ValueLang);

		//Language set done:================
		Assert.assertEquals(ValueLang, "<neutral>");
		System.out.println("Language is set to neutral ");


		//Ok Button Presence check:===========
		waits.waitUntil_Elmentis_visibilityOfElement(10, "(//div[@class='w20_modal-footer-wrapper'])[1]/input[1]");

		List<WebElement> RepBtn = driver.findElements(By.xpath("(//div[@class='w20_modal-footer-wrapper'])[1]/input"));
		ArrayList<String> Repbtn_win = new ArrayList<String>();
		Repbtn_win.add("OK");
		Repbtn_win.add("Cancel");
		Repbtn_win.add("Help");

		for(int i =0;i<RepBtn.size()-1;i++) {
			Assert.assertEquals(RepBtn.get(i).getAttribute("value"), Repbtn_win.get(i));
			System.out.println(RepBtn.get(i).getText());
		}

		System.out.println(" Actions Button in repository window is Present");


		//Validate ok Button availability and click Ok Button:=========================
//
//		implicitWaitSeconds(5);
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		waitForVisibilityOfElement(By.xpath("(//input[@id='okbutton'])[1]"));
		Assert.assertEquals(findVisible(By.xpath("//span[text()='C8 Cockpit PROFESSIONAL']")).getCssValue("font-weight"), "400", "Repository got highlighted");

//		implicitWaitSeconds(3)

		clickableClick(By.xpath("(//input[@id='okbutton'])[1]"));

		waitForAjax();

		//After Login Image Validate:==================
//		waitForVisibilityOfElement(By.xpath("//img[@src='image.aspx?svid=0&id=1_1']"));
//		waitForVisibilityOfElement(By.xpath("//body[@class='ajaxLoading']"));
//		clickableClick(By.xpath("//span[@id='tab_close_btn']"));
//		waitForInvisibilityOfElement(By.xpath("//span[@id='tab_close_btn']"));
		System.out.println("Login Successfully");

		// TODO
		//Not Available:============
		//waits.waituUnitil_Element_InvisiblityofElement(10,"//*[@title='Show DataView Designer']");

		//Doubt need to work:============
		//waits.waituUnitil_Element_InvisiblityofElement(10,"//span[text()='Navigator']");

		return driver;
	}

	public void createCubeReport(String CubeType, String ReportName, boolean ValueCheckBox) {
		//Create Report:==============
//		waitForVisibilityOfElement(By.xpath("(//span[text()='New'])[2]"));
//		clickableClick(By.xpath("(//span[text()='New'])[2]"));
		clickableClick(By.xpath("//body[1]/div[3]/div[4]/ul[1]/li[1]/ul[1]/li[1]/span[1]"));

		//Wait for new report window open:=================
		waitForVisibilityOfElement(By.xpath("//span[text()='New Report']"));

		//Select Standard Report and click next:==============
		clickableClick(By.xpath("//span[text()='Standard Report']"));
		clickableClick(By.xpath("//input[@value='Next >>']"));

		//Select Cube Window Verify:===========
		Assert.assertTrue(findVisibleBool(By.xpath("//span[text()='Select Cube']")));

		//Click Expand Button of PantaraCube:===========
		clickableClick(By.xpath("(//div[@class='w20_treeitemcollapsed'])[1]"));
		//Select Sales cube and click next:=============
		clickableClick(By.xpath(CubeType));
		clickableClick(By.xpath("//input[@value='Next >>']"));
		//Dimension window selection validate:================
		findVisible(By.xpath("//input[@value='Next >>']"));
		Assert.assertTrue(findVisibleBool(By.xpath("//span[text()='Dimension Selection']")));
		//Report Layout window validate and click next:=============
		clickableClick(By.xpath("//input[@value='Next >>']"));
		findVisible(By.xpath("//input[@value='Next >>']"));
		Assert.assertTrue(findVisibleBool(By.xpath("//span[text()='Report Layout']")));

		//select Table option:===========
		clickableClick(By.xpath("//label[text()='Table only']"));
		clickableClick(By.xpath("//input[@value='Next >>']"));

		//Filter Components:==============================
		Assert.assertTrue(findVisibleBool(By.xpath("//span[text()='Filter Components']")));


		boolean stat = isSelectedBool(By.xpath("//label[text()='Display filter bar']/preceding::input[1]"));
		System.out.println("Check box value is:->" + ValueCheckBox);

		if (stat == ValueCheckBox) {
			System.out.println("Check box is selected , Need to uncheck.");
			clickableClick(By.xpath("//label[text()='Display filter bar']"));
		}
		else {
			System.out.println("Check box is not selected.");
		}

		clickableClick(By.xpath("//input[@value='Next >>']"));

		//What's next window if display then click next:=============
		try {
			Assert.assertTrue(findVisibleBool(By.xpath("//span[contains(text(),'What')]")));

			System.out.println("Whats Next Window is displaying now.");
			clickableClick(By.xpath("//input[@value='Next >>']"));

		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Whats Next Window is not displaying.");
		}

		//Finish Window:============
		Assert.assertTrue(findVisibleBool(By.xpath("//span[text()='Name and Description']")));
		clickableClick(By.xpath("//span[text()='Name']/following::input[1]"));

		findVisible(By.xpath("//span[text()='Name']/following::input[1]")).clear();
		findVisible(By.xpath("//span[text()='Name']/following::input[1]")).sendKeys(ReportName);
		clickableClick(By.xpath("//span[text()='Description']/following::textarea[1]"));

		//Click Finish:====================
		clickableClick(By.xpath("//input[@value='Finish']"));

		waitForInvisibilityOfElement(By.xpath("//input[@value='Finish']"));

//		pageLoadWaitSeconds(10);

		waitForAjax();
	}

	public void deleteReport(String ReportName) throws InterruptedException {
		Utils ui = new Utils(driver);
		clickableClick(By.id(getData("close_reprt_id")));

		try {
			waitForVisibilityOfElement(By.xpath(getData("yes")));
			clickableClick(By.xpath(getData("yes")));
		}
		catch (Exception e) {
			// TODO: handle exception
			ui.rightClick("//*[text()='" + ReportName + "']");
			waitForVisibilityOfElement(By.xpath("//span[text()='Delete']"));
			clickableClick(By.xpath("//span[text()='Delete']"));
			waitForVisibilityOfElement(By.id(getData("yes")));
			clickableClick(By.id(getData("yes")));
		}

	}

//	public void createReport(WebDriver driver,String cube) throws InterruptedException
//
//	{
//
//		Waits waits = new Waits(driver);
//
//		driver.findElement(By.xpath("//img[@src='./images/new32.gif']")).click();
//		Thread.sleep(1000);
//		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[@class='cwFloatingPaneTitleText']");
////		WebDriverWait wait  =  new WebDriverWait(driver,10);
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cwFloatingPaneTitleText']")));
//
//		driver.findElement(By.xpath("//*[text()='Next >>']")).click();
//		Thread.sleep(1000);
//
////		WebDriverWait wait2  =  new WebDriverWait(driver,10);
////		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Select Cube']")));
//		waits.waitUntil_Elmentis_visibilityOfElement(10, "//*[text()='Select Cube']");
//		Thread.sleep(1000);
//
//
//		// Expand Pandra
//		driver.findElement(By.xpath("//a[.='Pantara AS2008']/../a")).click();
////		Wait for expand
//
//		waits.waitUntil_Elmentis_visibilityOfElement(10, "//img[@src='./images/controls/trc_m.gif']");
//
////		click on Traning Sale
//		WebElement cubes = driver.findElement(By.xpath("//a[text()='"+cube+"']/../input"));
//		cubes.click();
////		Check if cube is selected or not
//		boolean check = cubes.isSelected();
//		Assert.assertTrue(check);
//
//		driver.findElement(By.xpath("//*[text()='Next >>']")).click();
//		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[@class='cwFloatingPaneTitleText' and text()='New Report']");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[text()='Finish']")).click();
//		waits.waitUntil_Elmentis_visibilityOfElement(10, "//img[@src='./images/controls/mdi_cl.gif']");
//		System.out.println("Report created sucessfully");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//img[@src='./images/component_mngr32.gif']")).click();
//		waits.waitUntil_Elmentis_visibilityOfElement(10, "//div[@lable='Components']");
//
//	}

//	public  void CreateStandrdReport(String ExcelsheetName,int Row,int Column,String SelectCubeXpath,String ReportLayoutXpath,boolean Layout)throws InterruptedException,NoSuchElementException
//	{
//		ConfigData web = new ConfigData();
//
//		try
//		  {
//		   ValidationPropertyUtil R9P=new ValidationPropertyUtil();
//		   Utils Utils=new Utils(driver);
//
//		   //Create Report Button Validation:===========================
//		   Assert.assertEquals(driver.findElement(By.xpath(web.getData("CreateNewReport"))).isDisplayed(),true);
//		   Utils.waitForElement("");
//		   Actions ActCreate=new Actions(driver);
//		   ActCreate.doubleClick(driver.findElement(web.getObjectLocator("NewReportBtnXpath"))).perform();
//		   try
//		   {
//			   Assert.assertEquals(driver.findElement(By.xpath(web.getData("NewreportHeaderXpath"))).isDisplayed(),true);
//			   System.out.println("New Report window opened.");
//		   }
//		   catch(Exception e)
//		   {
//			   driver.findElement(web.getObjectLocator("NewReportBtnXpath")).click();
//			   //Utils.waitForElement("");
//			   Thread.sleep(3000);
//		   }
//		   Utils.waitForElement("");
//		   Assert.assertEquals(driver.findElement(By.xpath(web.getData("NewreportHeaderXpath"))).isDisplayed(),true);
//		   System.out.println("New Report window opened.");
//
//		   //By default Standard Report will be selected:===============
//		   String ActStandrdReportMsg=driver.findElement(web.getObjectLocator("SelectReportMethodMsgXpath")).getText();
//		   if(ActStandrdReportMsg.contains(R9P.ExptSelectReportMsgXpath))
//		   {
//			   //Standard Report Message Validation:=================================
//			   System.out.println("Standard Report is selected for New report..");
//			   Utils.waitForElement("");
//			   driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
//			   Utils.waitForElement("");
//			   try
//				{
//					Assert.assertEquals(driver.findElement(By.xpath(web.getData("PantaraDBTextXpath"))).isDisplayed(),true);
//					System.out.println("Cube Selection window is displaying.");
//				}
//				catch(Exception e2)
//				{
//					System.out.println("Cube Selection window is not displaying need to click Next again.");
//					driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
//					Utils.waitForElement("");
//				}
//
//			   //select Cube Window and checking error message without select cube:==========================
//			   String ActualDBName=driver.findElement(web.getObjectLocator("PantaraDBTextXpath")).getText();
//			   Assert.assertEquals(ActualDBName,R9P.ExpectedDBName,R9P.DBErrorMsg);
//			   Utils.waitForElement("");
//			   Actions act=new Actions(driver);
//			   act.doubleClick(driver.findElement(By.xpath(web.getData("PantaraDBExtend")))).perform();
//			   try
//				{
//					Assert.assertEquals(driver.findElement(By.xpath(web.getData(SelectCubeXpath))).isDisplayed(),true);
//				}
//				catch(Exception e1)
//				{
//					System.out.println("PantaraDBExtend is not cliked 1st time need to click 2nd time.");
//					Utils.waitForElement("");
//					driver.findElement(By.xpath(web.getData("PantaraDBExtend"))).click();
//					Utils.waitForElement("");
//					//System.out.println("PantaraDBExtend is cliked 1st time.");
//				}
//				Utils.waitForElement("");
//				//Cube Selection:===========================
//				Assert.assertEquals(driver.findElement(By.xpath(web.getData(SelectCubeXpath))).isDisplayed(),true);
//				System.out.println("Required cube name is displaying now.");
//				Utils.waitForElement("");
//				act.doubleClick(driver.findElement(By.xpath(web.getData(SelectCubeXpath)))).perform();
//				Utils.waitForElement("");
//				try
//				{
//					Assert.assertEquals(driver.findElement(By.xpath(web.getData(SelectCubeXpath))).isSelected(),true);
//				}
//				catch(Exception e1)
//				{
//					System.out.println("CubeName is not cliked 1st time need to click 2nd time.");
//					Utils.waitForElement("");
//					driver.findElement(By.xpath(web.getData(SelectCubeXpath))).click();
//					Utils.waitForElement("");
//
//				}
//			   driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
//			   Utils.waitForElement("");
//			   //Dimension selection window validation:==============================
//			   try
//				{
//					Assert.assertEquals(driver.findElement(By.xpath(web.getData("ReportDimensionSelcWindowHeaderXpath"))).isDisplayed(),true);
//				}
//				catch(Exception e2)
//				{
//					System.out.println("Next is clicking 2nd time.");
//					driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
//					Utils.waitForElement("");
//				}
//				Utils.waitForElement("");
//				Assert.assertEquals(driver.findElement(By.xpath(web.getData("ReportDimensionSelcWindowHeaderXpath"))).isDisplayed(),true);
//				System.out.println("Dimension selection window opened.");
//				Utils.waitForElement("");
//				driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
//				Utils.waitForElement("");
//				//Report Layout window Validation:============================
//				Assert.assertEquals(driver.findElement(By.xpath(web.getData("ReportLayoutWindowHeaderXpath"))).isDisplayed(),true);
//				System.out.println("Layout selection window opened.");
//				Utils.waitForElement("");
//				driver.findElement(web.getObjectLocator(ReportLayoutXpath)).click();
//				Utils.waitForElement("");
//				driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
//				Utils.waitForElement("");
//				//Filter component Window validation:==============================
//				try
//				{
//				   if(driver.findElement(web.getObjectLocator("ReportFilterComponentTextXpath")).isDisplayed())
//				   {
//					   System.out.println("Report Filter Components window is opened..");
//					   if(Layout)
//					   {
//						   System.out.println("User want to uncheck display filter..");
//						   driver.findElement(web.getObjectLocator("DisplayFilterBarXpath")).click();
//						   Utils.waitForElement("");
//					   }
//					   else
//					   {
//						   System.out.println("User don't want to uncheck display filter..");
//					   }
//				   }
//			   }
//			   catch(Exception e)
//			   {
//				   System.out.println("Report Filter Components window is not opened..");
//			   }
//			   driver.findElement(web.getObjectLocator("NextBtnXpath")).click();
//			   Utils.waitForElement("");
//			   //What's next page validation:============================
//			   try
//				{
//					Assert.assertEquals(driver.findElement(By.xpath(web.getData("WhatsNxtPageHeaderXpath"))).isDisplayed(),true);
//					System.out.println("Whats next page is displaying.");
//					driver.findElement(By.xpath(web.getData("next"))).click();
//					Utils.waitForElement("");
//				}
//				catch(Exception e)
//				{
//					System.out.println("Whats next page is not displaying.");
//				}
//
//			    //Name And Description validation:===========================
//				//Utils.waitUntil_Textpresent(10, "nameAnddescription", "Name and Description");
//				Utils.waitForElement("");
//			    driver.findElement(web.getObjectLocator("NewReportInputXpath")).clear();
//			    Utils.waitForElement("");
//			    Excelnput Excelnput=new Excelnput();
//			    driver.findElement(web.getObjectLocator("NewReportInputXpath")).sendKeys(Excelnput.ExcelDatainput(ExcelsheetName,Row,Column));
//			    Utils.waitForElement("");
//			    driver.findElement(web.getObjectLocator("FinishBtnXpath")).click();
//			    Utils.waitForElement("");
//			    //After create validation:=====================
//				String ReportName=Excelnput.ExcelDatainput(ExcelsheetName,Row,Column);
//				System.out.println("Report Name "+ReportName);
//				Assert.assertEquals(driver.findElement(By.xpath("//a[text()='"+ReportName+"']/following::td[1]/a[1]/img[1]")).isDisplayed(),true);
//				Utils.waitForElement("");
//			    System.out.println("New Standard Report is created properly.");
//			    Reporter.log("New Standard Report is created properly.");
//		   	}
//		   	else
//		   	{
//			   System.out.println("Standard Report is not selected for New report..");
//		   	}
//
//		    }
//		   catch(Exception e)
//		    {
//			   e.printStackTrace();
//			   System.out.println("Report not created properly.");
//			   Reporter.log("Report not created properly.");
//		    }
//	}
}
