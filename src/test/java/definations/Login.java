package definations;

import cucumber.api.java.en.And;

import operations.BrowserContext;
import operations.HomeOperations;
import operations.LoginOperations;
import util.DataHolder;
import util.ProfileReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Login definitions for glue
 */
public class Login {

    private LoginOperations loginOps = null;
    private HomeOperations homeOps = null;

    public Login() throws Exception {
        loginOps = new LoginOperations();
        homeOps = new HomeOperations();
    }

    @Given("^I am on the \"(.*?)\" page of 4shared$")
    public void i_am_on_the_specified_page_of_4shared(String pageRequested) throws Throwable {
        if (pageRequested.equals("login")) {
            String loginPage = ProfileReader.getInstance().getUrl();
            DataHolder.LOGIN_PAGE = loginPage;
            BrowserContext.getBrowserDriverInstance().get(DataHolder.LOGIN_PAGE);
        } else {
            throw new Exception("Unknown page requested...");
        }
    }

    @Given("^I successfully login to 4shared with \\\"(.*?)\\\" and \\\"(.*?)\\\"$")
    public void i_successfullylogin_to__4shared(String userID, String pass) throws Throwable {
        String loginPage = ProfileReader.getInstance().getUrl();
        DataHolder.LOGIN_PAGE = loginPage;
        BrowserContext.getBrowserDriverInstance().get(DataHolder.LOGIN_PAGE);
        loginOps.clickLogInButton();
        loginOps.enterLoginDetails(userID, pass);
        loginOps.clickSignInButton();
        homeOps.verifyUserIsOnHomePage();
    }

}
