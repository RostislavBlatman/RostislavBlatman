package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Users;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePageSelenide {

    private SelenideElement title = $("title");
    private SelenideElement userIcon = $(".profile-photo");
    private SelenideElement loginInput = $("#Name");
    private SelenideElement passwordInput = $("#Password");
    private SelenideElement submitButton = $(".fa-sign-in");
    private SelenideElement userName = $(".profile-photo span");
    private ElementsCollection headerNavList = $$(".nav > li");
    private ElementsCollection imagesFromPage = $$(".benefit-icon");
    private ElementsCollection textsUnderIcons = $$(".benefit-txt");
    private SelenideElement mainTitle = $(".main-title");
    private SelenideElement mainText = $(".main-txt");
    private SelenideElement subText = $(".text-center > a");
    private SelenideElement navSidebar = $("div[name = 'navigation-sidebar']");
    private SelenideElement footer = $("footer");
    private SelenideElement headerServiceDropdown = $(".nav .dropdown-toggle");
    private ElementsCollection headerServiceMenu = $$(".nav .dropdown-menu > li > a");
    private SelenideElement leftServiceDropdown = $(".fa-caret-down");
    private ElementsCollection leftServiceMenu = $$(".wrapper .sub > li > a");
    private SelenideElement difElements = $(".nav a[href = 'different-elements.html']");
    private SelenideElement dates = $(".nav a[href = 'dates.html']");

    public void openHomePage() {
        open("https://epam.github.io/JDI/index.html");
    }


    public void login(Users user) {
        userIcon.click();
        loginInput.sendKeys(user.login);
        passwordInput.sendKeys(user.password);
        submitButton.click();
    }

    public void checkHomePageTitle() {
        title.shouldHave(attribute("text", "Home Page"));
    }

    public void checkUserName() {
        userName.shouldBe(visible);
    }

    public void checkInterface() {
        imagesFromPage.shouldHaveSize(4);
        for (SelenideElement image : imagesFromPage) {
            image.shouldBe(visible);
        }
        textsUnderIcons.shouldHaveSize(4);
        for (SelenideElement text : textsUnderIcons){
            text.shouldBe(visible);
        }
        mainText.shouldBe(visible);
        subText.shouldBe(visible);
    }

    public void checkHeaderServiceDropdown(){
        headerServiceDropdown.click();
        headerServiceMenu.shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE","USER TABLE",
                "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
        for(SelenideElement element : headerServiceMenu){
            element.shouldBe(visible);
        }
    }

    public void checkLeftServiceDropdown(){
        leftServiceDropdown.click();
        leftServiceMenu.shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE","USER TABLE",
                "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
        for(SelenideElement element : leftServiceMenu){
            element.shouldBe(visible);
        }

    }

    public void openDifferentElements(){
        headerServiceDropdown.click();
        difElements.click();
    }

    public void openDatesPage(){
        headerServiceDropdown.click();
        dates.click();
    }
}
