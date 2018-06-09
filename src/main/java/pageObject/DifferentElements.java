package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DifferentElements {
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

    public void openDifferentElements() {
        open("https://epam.github.io/JDI/different-elements.html");
    }

    public void checkDifElementsPageTitle() {
        title.shouldHave(attribute("text", "Different Element "));
    }

    public void checkInterfaceDifElements() {
        checkboxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        dropdown.shouldBe(visible);

    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    public void checkSelectCheckboxes() {
        checkboxWater.click();
        lastLog.shouldHave(text("Water"));
        checkboxWind.click();
        lastLog.shouldHave(text("Wind"));
    }

    public void checkCheckboxLog(int logIndex, String checkbox, String status) {
        $(String.format(".panel-body-list.logs li:nth-child(%d)", logIndex))
                .shouldHave(text(checkbox), text(status));
    }

    public void checkSelectRadio() {
        radioSelen.click();
        lastLog.shouldHave(text("Selen"));
    }

    public void checkRadioLog(String radio) {
        lastLog.shouldHave(text(radio));
    }

    public void checkSelectColor() {
        dropdownColors.click();
        dropdownColorYellow.click();
        lastLog.shouldHave(text("Colors: value changed to Yellow"));
    }

    public void checkColorLog(String color) {
        lastLog.shouldHave(text(color));
    }

}
