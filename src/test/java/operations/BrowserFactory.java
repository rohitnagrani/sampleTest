package operations;

import util.Constants;
import util.ProfileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Browser Factory class will return the instance of the WebDriver based on the
 * browserName.
 */
public class BrowserFactory {

    private static WebDriver driver = null;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static WebDriver getWebDriverInstance(String launchBrowser) throws Exception {
        if (launchBrowser == null || launchBrowser.length() == 0) {
            throw new Exception("Please provide the launch browser name...");
        }


        if (launchBrowser.equalsIgnoreCase(Constants.CHROME)) {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("implicitWait", "15000")),
                TimeUnit.MILLISECONDS);


        return driver;
    }
}
