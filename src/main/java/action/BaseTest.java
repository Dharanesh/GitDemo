package action;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import event.ConfigData;
import event.Excelnput;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static action.ThreadLocalWebDriverFactory.closeBrowserSafe;

public abstract class BaseTest extends ConfigData {

    /** Leave these as static otherwise suites won't run properly */
    static public ExtentHtmlReporter htmlReporter;
    static public ExtentReports extent;
    static public ExtentTest test;
    static public Logger logger;
    static public WebDriver driver;
    static public Actions builder;

    private final String projectRoot = System.getProperty("user.dir");

    @BeforeTest
    @Parameters({"browser", "testType", "environment"})
    public void setup(String browser, String testType, String environment) throws Exception {

        File reportDir = new File(projectRoot + File.separator + "extent_reports");

        // is needed?
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        String timeStamp = new SimpleDateFormat(" dd-MMMM-yyyy HH-mm").format(new Date());

        Excelnput excelData = new Excelnput();
        htmlReporter = new ExtentHtmlReporter(reportDir + File.separator +
                excelData.ExcelDatainput("Standard_SDL_Container", 1, 12) + "_" + timeStamp + ".html");

        //htmlReporter = new ExtentHtmlReporter("./Report/Build/"+ExcelData.ExcelDatainput("Standard_SDL_Container",1,12)+"{ " +timeStamp+" }"+".html");
        // htmlReporter = new ExtentHtmlReporter("http://192.168.103.39//Automation//test.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment ", environment);
        extent.setSystemInfo("Browser ", browser);

        htmlReporter.config().setDocumentTitle(testType.replaceAll("_", " ").toUpperCase());
        htmlReporter.config().setReportName(testType.replaceAll(" ", "_").toLowerCase());
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

/*	public static String getScreenshot(WebDriver driver) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("C:\\Users\\I_CRA\\Desktop\\Extra\\Report\\Report\\Screenshot\\"  + dateName+ ".png");

		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}*/

    public abstract void logout();

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            //			 String temp = getScreenshot(driver);

            test.fail(MarkupHelper.createLabel(result.getName() + "Test case has Failed", ExtentColor.RED));
            test.fail(result.getThrowable());
            //			 test.fail("Screen Shot below " +test.addScreenCaptureFromPath(temp));

		/*	 String temp = getScreenshot(driver);
			 test.fail(MarkupHelper.createLabel(result.getName()+"Test case failed", ExtentColor.RED));
		//			 test.fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			test.fail(test.addScreenCaptureFromPath(temp));*/
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(MarkupHelper.createLabel(result.getName() + "Test case is Passed", ExtentColor.GREEN));
        } else {
            test.skip(MarkupHelper.createLabel(result.getName() + "Test case is Skipped", ExtentColor.YELLOW));
            test.skip(result.getThrowable());
        }
    }


    @AfterMethod(alwaysRun = true, dependsOnMethods = "getResult")
    public void tearDown() {
        System.out.println("Tear down method is being run...");
//        logout();
        extent.flush();
        closeBrowserSafe();
        System.out.println("Tearing down is finished.");
    }
}