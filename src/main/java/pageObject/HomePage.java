package pageObject;

import enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static enums.TextsOfHeaderSectionItems.*;
import static enums.TextsOnMainHeader.*;
import static enums.TextsUnderImages.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    @FindBy(css = ".profile-photo")
    private WebElement userIcon;

    @FindBy(css = "#Name")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".fa-sign-in")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo span")
    private WebElement userName;

    @FindBy(css = ".nav > li")
    private List<WebElement> headerNavList;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> imagesFromPage;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textsUnderIcons;

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(css = ".text-center > a")
    private WebElement subText;

    @FindBy(css = "div[name = 'navigation-sidebar']")
    private WebElement navSidebar;

    @FindBy(css = "footer")
    private WebElement footer;


    public void open(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void login(Users user) {
        userIcon.click();
        loginInput.sendKeys(user.login);
        passwordInput.sendKeys(user.password);
        submitButton.click();
    }

    public void checkHomePageTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkUserName(Users user) {
        assertTrue(userName.isDisplayed());
        assertEquals(user.name, userName.getText());
    }

    public void checkItemsHeaderSection() {
        assertEquals(headerNavList.size(), 4);

        for (WebElement webElement : headerNavList) {
            assertTrue(webElement.isDisplayed());
        }
        assertEquals(headerNavList.get(0).getText(), HOME.text);
        assertEquals(headerNavList.get(1).getText(), CONTACT_FORM.text);
        assertEquals(headerNavList.get(2).getText(), SERVICE.text);
        assertEquals(headerNavList.get(3).getText(), METALS_COLORS.text);
    }

    public void checkImagesOnIndexPage() {

        assertEquals(imagesFromPage.size(), 4);

        for (WebElement element : imagesFromPage) {
            assertTrue(element.isDisplayed());
        }

    }

    public void checkTextsUnderImages() {

        assertEquals(textsUnderIcons.size(), 4);

        for (WebElement element : textsUnderIcons) {
            assertTrue(element.isDisplayed());
        }

        assertEquals(textsUnderIcons.get(0).getText(), ICON_PRACTISE.text);
        assertEquals(textsUnderIcons.get(1).getText(), ICON_CUSTOM.text);
        assertEquals(textsUnderIcons.get(2).getText(), ICON_MULTI.text);
        assertEquals(textsUnderIcons.get(3).getText(), ICON_BASE.text);
    }

    public void checkTextsOnMainHeader() {

        assertEquals(mainTitle.getText(), MAIN_TITLE.text);

        assertEquals(mainText.getText(), MAIN_TXT.text);
    }

    public void checkTextOnSubHeader() {
        assertEquals(subText.getText(), TEXT_CENTER.text);
    }

    public void checkSubHeaderLink() {
        assertEquals(subText.getAttribute("href"), TEXT_CENTER_LINK.text);
    }

    public void checkLeftSection() {
        assertTrue(navSidebar.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }
}
