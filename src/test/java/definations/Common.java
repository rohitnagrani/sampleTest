package definations;

import org.openqa.selenium.WebDriverException;

import operations.BrowserContext;
import util.Constants;
import util.ProfileReader;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.After;

public class Common {

    @Before
    public static void Before(Scenario scenario) {
        System.out.println("**** Starting scenario - " + scenario.getName() + " ****");
    }

    @After
    public static void After(Scenario scenario) throws WebDriverException, Exception {
        String s = String.format("**** Test Status for %s -- %s", scenario.getName(), scenario.getStatus() + " ****");
        System.out.println(s);
        if (scenario.getStatus().equalsIgnoreCase("failed")) {
            // code to take the screenshot
        }
    }

    @Given("^I am running test for \"(.*?)\" profile$")
    public void i_am_running_test_for_environment(String profileName) throws Throwable {
        profileName = System.getProperty(Constants.PROFILE, profileName);
        System.setProperty(Constants.PROFILE, profileName);
        BrowserContext.initialize(ProfileReader.getInstance().getBrowser());
    }
}
