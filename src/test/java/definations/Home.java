package definations;

import cucumber.api.java.en.When;
import operations.HomeOperations;
import cucumber.api.java.en.Then;

public class Home {

    private Login login = null;
    private HomeOperations homeOps = null;

    public Home() throws Exception {
        login = new Login();
        homeOps = new HomeOperations();
    }

    @Then("^I am on homepage of 4shared$")
    public void i_am_on_home_page() throws Throwable {
        homeOps.verifyUserIsOnHomePage();
    }

    @When("^I click on new folder option$")
    public void i_create_a_new_folder() throws Throwable {
        homeOps.createNewFolder();
    }

    @Then("^A new folder is created$")
    public void a_new_folder_is_created() throws Throwable {
        homeOps.verifyNewFolderCreation();
    }

    @When("^I upload files in the folder created$")
    public void i_upload_files_in_the_folder_created() throws Throwable {
        homeOps.uploadFiles();
    }

    @Then("^files are uploaded$")
    public void files_are_uploaded() throws Throwable {
        homeOps.verifyUploadedFiles();
    }
}
