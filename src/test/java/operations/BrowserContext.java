package operations;

import util.Constants;
import util.ProfileReader;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Browser Context class is to hold the instance of browser driver.
 */
public class BrowserContext {

    private static WebDriver driver = null;

    private BrowserContext() {
    }

    public static void initialize(String launchBrowser) throws Exception {
        if (driver == null) {
            initWebDrivers();
            driver = BrowserFactory.getWebDriverInstance(launchBrowser);
        }
    }

    public static WebDriver getBrowserDriverInstance() throws Exception {
        if (driver == null) {
            throw new Exception("Call initialize meathod to initialize the instance first...");
        }
        return driver;
    }

    public static void setBrowserDriverInstance(WebDriver d) {
        driver = d;
    }


    private static void initWebDrivers() throws IOException {
        String chromeDriverProperty = "webdriver.chrome.driver";
        String driverDirPath = "drivers" + File.separator + "mac";
        if (System.getProperty(chromeDriverProperty) == null || System.getProperty(chromeDriverProperty).length() == 0) {
            if (ProfileReader.getInstance().getOS().equalsIgnoreCase(Constants.OS_MAC)) {
                System.setProperty(chromeDriverProperty, driverDirPath + File.separator + "chromedriver");
            }
        }

    }
}
