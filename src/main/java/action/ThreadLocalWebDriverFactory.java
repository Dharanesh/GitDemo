package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ThreadLocalWebDriverFactory {

    private static final ThreadLocal<WebDriver> driverSafe = new ThreadLocal<WebDriver>();
    private static final String PackageLoc = System.getProperty("user.dir");

    public static void setDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", PackageLoc+"\\src\\main\\resources\\drivers\\chromedriver.exe");
            driverSafe.set(new ChromeDriver());
            driverSafe.get().manage().window().maximize();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", PackageLoc+"\\src\\main\\resources\\drivers\\geckodriver.exe");
            driverSafe.set(new FirefoxDriver());
        }
        else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", PackageLoc+"\\src\\main\\resources\\drivers\\msedgedriver.exe");
            driverSafe.set(new EdgeDriver());
            driverSafe.get().manage().window().maximize();
        }
        else {
            System.out.println("");
        }
    }

    public static WebDriver getDriverSafe() {
        return driverSafe.get();
    }

    public static void closeBrowserSafe() {
        driverSafe.get().quit();
        driverSafe.remove();
    }
}
