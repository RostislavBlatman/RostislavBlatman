package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DifferentElementsAllure {
    @FindBy(css = "title")
    private SelenideElement title;
    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;
    @FindBy(css = ".label-radio")
    private ElementsCollection radios;
    @FindBy(css = "div.colors > select")
    private SelenideElement dropdown;
    @FindBy(css = "div.main-content .uui-button")
    private ElementsCollection buttons;
    @FindBy(css = "div[name='navigation-sidebar']")
    private SelenideElement leftSection;
    @FindBy(css = "div[name='log-sidebar']")
    private SelenideElement rightSection;
    @FindBy(css = ".label-checkbox:nth-child(1)")
    private SelenideElement checkboxWater;
    @FindBy(css = ".label-checkbox:nth-child(3)")
    private SelenideElement checkboxWind;
    @FindBy(css = ".panel-body-list.logs li:nth-child(1)")
    private SelenideElement lastLog;
    @FindBy(css = ".label-radio:nth-child(4)")
    private SelenideElement radioSelen;
    @FindBy(css = "div.colors")
    private SelenideElement dropdownColors;
    @FindBy(css = ".colors option:nth-child(4)")
    private SelenideElement dropdownColorYellow;

    @Step("Open page")
    public void openDifferentElements() {
        open("https://epam.github.io/JDI/different-elements.html");
    }

    @Step("Check title")
    public void checkDifElementsPageTitle() {
        title.shouldHave(attribute("text", "Different Element "));
    }

    @Step("Check Interface on Different Elements page")
    public void checkInterfaceDifElements() {
        checkboxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        dropdown.shouldBe(visible);
    }

    @Step("Check left section")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step("Check right section")
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @Step("Check select checkboxes 'water' and 'wind'")
    public void checkSelectCheckboxes() {
        checkboxWater.click();
        lastLog.shouldHave(text("Water"));
        checkboxWind.click();
        lastLog.shouldHave(text("Wind"));
    }

    @Step("Check checkbox log")
    public void checkCheckboxLog(int logIndex, String checkbox, String status) {
        $(String.format(".panel-body-list.logs li:nth-child(%d)", logIndex))
                .shouldHave(text(checkbox), text(status));
    }

    @Step("Check select radio")
    public void checkSelectRadio() {
        radioSelen.click();
        lastLog.shouldHave(text("Selen"));
    }

    @Step("Check radio log")
    public void checkRadioLog(String radio) {
        lastLog.shouldHave(text(radio));
    }

    @Step("Check select color")
    public void checkSelectColor() {
        dropdownColors.click();
        dropdownColorYellow.click();
        lastLog.shouldHave(text("Colors: value changed to Yellow"));
    }

    @Step("Check color log")
    public void checkColorLog(String color) {
        lastLog.shouldHave(text(color));
    }

}
