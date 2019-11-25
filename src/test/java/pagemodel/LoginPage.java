package pagemodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import operations.BrowserContext;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Login Page Model
 */
public class LoginPage {

    private WebDriver driver = null;

    public LoginPage() throws Exception {
        this.driver = BrowserContext.getBrowserDriverInstance();
    }

    public WebElement getEmail() {
//		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(windowHandles.get(1));
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        return driver.findElement(By.id("login"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("button.head-elem.small-button.hidden-xs"));
    }

    public WebElement getPassword() {
        //ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        //driver.switchTo().window(windowHandles.get(1));
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        return driver.findElement(By.id("password"));
    }

    public WebElement clickSignInButton() {
        return driver.findElement(By.cssSelector("button.big-button.b-w.jsLogIn"));
    }

    public WebElement getGoogleSignInOption() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.className("sign-in-text")));
        return driver.findElement(By.className("sign-in-text"));
    }
}
