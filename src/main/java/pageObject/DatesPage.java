package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class DatesPage {
    @FindBy(css = "div:nth-child(2) > div > a:nth-child(1)")
    private SelenideElement leftSlider;
    @FindBy(css = "div:nth-child(2) > div > a:nth-child(1) > span")
    private SelenideElement leftSliderSpan;
    @FindBy(css = "a:nth-child(3)")
    private SelenideElement rightSlider;
    @FindBy(css = "a:nth-child(3) > span")
    private SelenideElement rightSliderSpan;
    @FindBy(css = "div .uui-slider")
    private SelenideElement sliderRoad;
    @FindBy(css = ".info-panel-body-log > .info-panel-section")
    private SelenideElement logRows;

    public void openDatesPage() {
        open("https://epam.github.io/JDI/dates.html");
    }

    public void setSliderPosition(int leftSliderPosition, int rightSliderPosition) {

        int sliderRoadSize = sliderRoad.getSize().width;

        int rightSliderCurrentPosition = Integer.parseInt(rightSliderSpan.getText());
        int leftSliderCurrentPosition = Integer.parseInt(leftSliderSpan.getText());

        if (leftSliderPosition >= rightSliderCurrentPosition) {

            int xOffsetRight = ((rightSliderPosition - rightSliderCurrentPosition - 1) * sliderRoadSize / 100);
            Selenide.actions().dragAndDropBy(rightSlider, xOffsetRight, 0).perform();

            int xOffsetLeft = ((leftSliderPosition - leftSliderCurrentPosition - 1) * sliderRoadSize / 100);
            Selenide.actions().dragAndDropBy(leftSlider, xOffsetLeft, 0).perform();


        } else {

            Integer xOffsetLeft = ((leftSliderPosition - leftSliderCurrentPosition - 1) * sliderRoadSize / 100);
            Selenide.actions().dragAndDropBy(leftSlider, xOffsetLeft, 0).perform();

            Integer xOffsetRight = ((rightSliderPosition - rightSliderCurrentPosition - 1) * sliderRoadSize / 100);
            Selenide.actions().dragAndDropBy(rightSlider, xOffsetRight, 0).perform();

        }

    }

    public void checkLogRowsForSliders(String text) {
        logRows.shouldHave(text(text));
    }


}
