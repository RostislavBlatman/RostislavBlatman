package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class DifferentElements {

    private SelenideElement title = $("title");
    private ElementsCollection checkboxes = $$(".label-checkbox");
    private ElementsCollection radios = $$(".label-radio");
    private SelenideElement dropdown = $("div.colors > select");
    private ElementsCollection buttons = $$("div.main-content .uui-button");
    private SelenideElement leftSection = $("div[name='navigation-sidebar']");
    private SelenideElement rightSection = $("div[name='log-sidebar']");
    private SelenideElement checkboxWater = $(".label-checkbox:nth-child(1)");
    private SelenideElement checkboxWind = $(".label-checkbox:nth-child(3)");
    private SelenideElement lastLog = $(".panel-body-list.logs li:nth-child(1)");
    private SelenideElement radioSelen = $(".label-radio:nth-child(4)");
    private SelenideElement dropdownColors = $("div.colors");
    private SelenideElement dropdownColorYellow = $(".colors option:nth-child(4)");

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
