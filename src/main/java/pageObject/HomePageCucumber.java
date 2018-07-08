package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class HomePageCucumber {
    @FindBy(css = "title")
    private SelenideElement title;
    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;
    @FindBy(css = "#Name")
    private SelenideElement loginInput;
    @FindBy(css = "#Password")
    private SelenideElement passwordInput;
    @FindBy(css = ".fa-sign-in")
    private SelenideElement submitButton;
    @FindBy(css = ".profile-photo span")
    private SelenideElement userName;
    @FindBy(css = ".nav > li")
    private ElementsCollection headerNavList;
    @FindBy(css = ".benefit-icon")
    private ElementsCollection imagesFromPage;
    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsUnderIcons;
    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;
    @FindBy(css = ".main-txt")
    private SelenideElement mainText;
    @FindBy(css = ".text-center > a")
    private SelenideElement subText;
    @FindBy(css = "div[name = 'navigation-sidebar']")
    private SelenideElement navSidebar;
    @FindBy(css = "footer")
    private SelenideElement footer;
    @FindBy(css = ".nav .dropdown-toggle")
    private SelenideElement headerServiceDropdown;
    @FindBy(css = ".nav .dropdown-menu > li > a")
    private ElementsCollection headerServiceMenu;
    @FindBy(css = ".fa-caret-down")
    private SelenideElement leftServiceDropdown;
    @FindBy(css = ".wrapper .sub > li > a")
    private ElementsCollection leftServiceMenu;
    @FindBy(css = ".nav a[href = 'different-elements.html']")
    private SelenideElement difElements;
    @FindBy(css = ".nav a[href = 'dates.html']")
    private SelenideElement dates;
    @FindBy(css = ".nav [href='user-table.html']")
    private SelenideElement userTableInHeader;

    public HomePageCucumber() {
        Selenide.page(this);
    }

    @Given("I am on the Home Page")
    public void openHomePage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @When("I login as user (.+)")
    public void login(String users) {
        Users user = Users.valueOf(users);
        userIcon.click();
        loginInput.sendKeys(user.login);
        passwordInput.sendKeys(user.password);
        submitButton.click();
    }

    @Then("Home Page is the browser title")
    public void checkHomePageTitle() {
        title.shouldHave(attribute("text", "Home Page"));
    }

    @Then("(.+) name is displayed on the header")
    public void checkUserName(String users) {
        userName.shouldBe(visible);
        Users user = Users.valueOf(users);
        userIcon.shouldHave(text(user.name));
    }

    @Then("Home Page contains 4 pictures, 4 texts under them and 2 texts above")
    public void checkInterface() {
        imagesFromPage.shouldHaveSize(4);
        for (SelenideElement image : imagesFromPage) {
            image.shouldBe(visible);
        }
        textsUnderIcons.shouldHaveSize(4);
        for (SelenideElement text : textsUnderIcons) {
            text.shouldBe(visible);
        }
        mainText.shouldBe(visible);
        subText.shouldBe(visible);
    }

    @Then("Service subcategory in the header drop down contains all needed options")
    public void checkHeaderServiceDropdown() {
        headerServiceDropdown.click();
        headerServiceMenu.shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "USER TABLE",
                "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
        for (SelenideElement element : headerServiceMenu) {
            element.shouldBe(visible);
        }
    }

    @Then("Service subcategory in the left section drop down contains all needed options")
    public void checkLeftServiceDropdown() {
        leftServiceDropdown.click();
        leftServiceMenu.shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE", "USER TABLE",
                "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
        for (SelenideElement element : leftServiceMenu) {
            element.shouldBe(visible);
        }

    }

    @When("I open the Different Elements Page")
    public void openDifferentElements() {
        headerServiceDropdown.click();
        difElements.click();
    }

    @When("I'm on the DatesPage")
    public void openDatesPage() {
        headerServiceDropdown.click();
        dates.click();
    }

    @When("I open the Users Table Page")
    public void openUserTablePage() {
        headerServiceDropdown.click();
        userTableInHeader.click();
    }
}
