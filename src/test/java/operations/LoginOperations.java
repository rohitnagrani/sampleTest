package operations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagemodel.LoginPage;
import util.DataHolder;
import util.Constants;


/**
 * Perform operations for login
 */
public class LoginOperations {

    private LoginPage loginPage = null;
    private HomeOperations homeOps = null;

    public LoginOperations() throws Exception {
        loginPage = new LoginPage();
        homeOps = new HomeOperations();
    }

    public void enterLoginDetails(String userID, String pass) {

        loginPage.getEmail().sendKeys(userID);
        loginPage.getPassword().sendKeys(pass);

    }

    public void clickLogInButton() {
        loginPage.getLoginButton().click();

    }

    public void clickSignInButton() {
        loginPage.clickSignInButton().click();

    }

}
