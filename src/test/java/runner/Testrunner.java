package runner;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/resources/features",
        glue = "definations")


public class Testrunner {
    @BeforeClass
    public static void beforeClass() throws Throwable {
    }

    @AfterClass
    public static void afterClass() throws Exception {
    }
}

