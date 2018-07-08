package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.VipUsers;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;

public class UserTablePageCucumber {

    @FindBy(css = ("title"))
    private SelenideElement title;
    @FindBy(css = (".support-title"))
    private SelenideElement supportTitle;
    @FindBy(css = ("#user-table"))
    private SelenideElement userTable;
    @FindBy(css = "td select")
    private List<SelenideElement> roleDropdown;
    @FindBy(css = "td a")
    private List<SelenideElement> userLink;
    @FindBy(css = "[type ='checkbox']")
    private List<SelenideElement> vipCheckbox;
    @FindBy(css = ".user-descr span")
    private List<SelenideElement> usersDescription;
    @FindBy(css = ("tr"))
    private List<SelenideElement> tableRows;
    @FindBy(css = ".logs li")
    private List<SelenideElement> logRows;

    public UserTablePageCucumber() {
        Selenide.page(this);
    }

    @Then("Users Table Page is Active")
    public void checkUserTablePageTitle() {
        title.shouldHave(attribute("text", "User Table"));
    }

    @Then("User Table Page's interface contains correct elements")
    public void checkInterface() {
        supportTitle.shouldBe(visible);
        userTable.shouldBe(visible);
    }

    @When("I check Number and User columns of Users table")
    public void checkTableNumberAndUserColumns() {
        for (int i = 1; i < tableRows.size(); i++) {
            tableRows.get(i).find(By.xpath("td[1]")).shouldBe(visible);
            tableRows.get(i).find(By.xpath("td[3]")).shouldBe(visible);
        }
    }

    @Then("User table contain correct values for numbers and users")
    public void checkUserTableValues(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(userLink.get(i).getText(), list.get(i).get("User"));
            assertEquals(String.valueOf(i + 1), list.get(i).get("Number"));
        }


    }

    @When("I check Description column of Users table")
    public void checkDescriptionColumn() {
        for (int i = 1; i < tableRows.size(); i++) {
            tableRows.get(i).find(By.xpath("td[4]")).shouldBe(visible);
        }
    }

    @Then("All cells of 'Description' column contains text")
    public void checkUserTableDescriptionValues(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(usersDescription.get(i).getText(), list.get(i).get("Description"));
        }
    }

    @When("I set 'vip' status to (.+)")
    public void setVipStatusCheckbox(String users) {
        VipUsers user = VipUsers.valueOf(users);
        vipCheckbox.get(user.number).click();
    }

    @Then("'Log' section shows a log row in format: (.+): condition changed to (.+)")
    public void checkLogRow(String fieldName, String status) {
        logRows.get(0).shouldHave(text(fieldName + ": condition changed to " + status));
    }

    @When("I click on dropdown in column Type for user (.+)")
    public void roleDropdownClick(String users) {
        VipUsers user = VipUsers.valueOf(users);
        roleDropdown.get(user.number).click();
    }

    @Then("droplist contains values")
    public void roleDropdownContains(List<String> options) {
        for (int i = 1; i < options.size(); i++) {
            assertEquals(roleDropdown.get(i - 1).getText(), options.get(i));
        }
    }


}
