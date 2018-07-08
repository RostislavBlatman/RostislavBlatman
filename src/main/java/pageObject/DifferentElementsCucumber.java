package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DifferentElementsCucumber {
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

    public DifferentElementsCucumber() {
        Selenide.page(this);
    }

    @Then("Different Elements is the browser title")
    public void checkDifElementsPageTitle() {
        title.shouldHave(attribute("text", "Different Element "));
    }

    @Then("Interface on Different elements page contains all needed elements")
    public void checkInterfaceDifElements() {
        checkboxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        dropdown.shouldBe(visible);
    }

    @Then("There is Left Section")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Then("There is Right Section")
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @When("I select checkbox: (.+)")
    public void checkSelectCheckboxes(String checkBoxes) {
        String xPath = "//label[contains(.,'" + checkBoxes + "')]";
        SelenideElement checkBox = $x(xPath);
        checkBox.click();
    }

    @Then("There is a log row number (.+) for checkbox (.+). State (.+)")
    public void checkCheckboxLog(String logIndex, String checkbox, String status) {
        $(String.format(".panel-body-list.logs li:nth-child(%d)", Integer.parseInt(logIndex)))
                .shouldHave(text(checkbox), text(status));
    }

    @When("I select radio: (.+)")
    public void checkSelectRadio(String radioButton) {
        String xPath = "//label[contains(.,'" + radioButton + "')]";
        SelenideElement radio = $x(xPath);
        radio.click();
    }

    @Then("There is a log for radio (.+)")
    public void checkRadioLog(String radio) {
        lastLog.shouldHave(text(radio));
    }

    @When("I select in dropdown: (.+)")
    public void checkSelectColor(String color) {
        dropdownColors.click();
        String xPath = "//select/option[text()='" + color + "']";
        SelenideElement colorButton = $x(xPath);
        colorButton.click();
    }

    @Then("There is a log for color (.+)")
    public void checkColorLog(String color) {
        lastLog.shouldHave(text(color));
    }

}
