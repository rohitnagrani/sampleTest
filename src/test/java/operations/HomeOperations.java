package operations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagemodel.HomePage;
import util.DataHolder;
import util.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeOperations {

    private HomePage homePage = null;
    private int folderCount, newFolderCount = 0;

    public HomeOperations() throws Exception {
        homePage = new HomePage();
    }

    public void verifyUserIsOnHomePage() throws Exception {
        homePage.verifyUserIsOnHomePage();
        homePage.verifyHomePageUrl();

    }

    public void createNewFolder() throws Exception {
        folderCount = homePage.getFolderCount();
        homePage.createFolder();
    }

    public void verifyNewFolderCreation() throws Exception {
        newFolderCount = homePage.getFolderCount();
        boolean folder = (((newFolderCount - folderCount) == 1) ? true : false);
        Assert.assertTrue(folder);
    }

    public void uploadFiles() throws Exception {
        homePage.getFolder().click();
        String projectDirectory = System.getProperty("user.dir");
        String image01Path = projectDirectory + File.separator + "uploadFiles" + File.separator + "Blue.png";
        String image02Path = projectDirectory + File.separator + "uploadFiles" + File.separator + "Red.png";

        homePage.selectUploadOption().sendKeys(image01Path);
        homePage.waitForUpload(Constants.FIRST_FILE);
        homePage.selectUploadOption().sendKeys(image02Path);
        homePage.waitForUpload(Constants.SECOND_FILE);
    }

    public void verifyUploadedFiles() throws Exception {
        homePage.verifyBothFilesAreUploaded();
    }
}