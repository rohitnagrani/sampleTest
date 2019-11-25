package pagemodel;

import operations.BrowserContext;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Constants;

import java.util.List;

/**
 * Page Model for Home Page
 */
public class HomePage {

    private WebDriver driver = null;
    private String emptyTableSelector = "#jsFilesTable";
    private String tableSelector = "#jsFilesTable > tbody";

    public HomePage() throws Exception {
        this.driver = BrowserContext.getBrowserDriverInstance();
    }

    public void verifyUserIsOnHomePage() throws Exception {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("mainbar")));

    }

    public void verifyHomePageUrl() throws Exception {
        boolean correctUrl = driver.getCurrentUrl().contains("https://www.4shared.com/account/home.jsp");
        Assert.assertTrue("Wrong Page visited", correctUrl);
    }

    public int getFolderCount() throws Exception {
        WebElement table = driver.findElement(By.cssSelector(emptyTableSelector));
        List<WebElement> totalRows = table.findElements(By.tagName("tbody"));
        if (totalRows.size() > 0) {
            table = driver.findElement(By.cssSelector(tableSelector));
            totalRows = table.findElements(By.tagName("tr"));
            return (totalRows.size());
        } else {
            return totalRows.size();
        }
    }

    public void createFolder() throws Exception {
        driver.findElement(By.cssSelector(".menuNewfolder")).click();
        driver.findElement(By.cssSelector(".menuNewfolder")).click();
        driver.navigate().refresh();
    }

    public void closeBrowser() throws Exception {
        BrowserContext.getBrowserDriverInstance().quit();

    }

    public WebElement getFolder() throws Exception {
        WebElement table = driver.findElement(By.cssSelector(tableSelector));
        List<WebElement> totalRows = table.findElements(By.tagName("tr"));
        String folderSelector = tableSelector + ">:nth-child(" + totalRows.size() + ")>:nth-child(2)>span";
        return driver.findElement(By.cssSelector(folderSelector));
    }

    public WebElement selectUploadOption() throws Exception {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.className("navArrow")));
        return driver.findElement(By.id("tfid1"));
    }

    public void waitForUpload(int num) throws Exception {
        String cssUploadedPic = emptyTableSelector + ">:nth-child(" + num + ")";
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssUploadedPic)));

    }

    public void verifyBothFilesAreUploaded() throws Exception {
        List<WebElement> totalRows = driver.findElements(By.cssSelector("div[id*=\"ml_file\"]"));
        boolean uploadStatus = ((totalRows.size() == Constants.TWO) ? true : false);
        Assert.assertTrue("Issue is file upload", uploadStatus);

        BrowserContext.getBrowserDriverInstance().quit();
    }
}
