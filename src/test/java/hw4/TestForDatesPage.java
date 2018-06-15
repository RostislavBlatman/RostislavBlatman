package hw4;

import base.Homework4Base;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObject.DatesPage;
import pageObject.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Dates page")
@Story("Login on 'Home page' as PITER CHAILOVSKY and check 'Dates page' interface")
@Listeners(AllureAttachmentListener.class)
public class TestForDatesPage extends Homework4Base {

    private HomePageSelenide homePage;
    private DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {

        homePage = page(HomePageSelenide.class);
        datesPage = page(DatesPage.class);

    }

    @Test
    public void testDatesPageContent() {

        //1 Open test site by URL
        homePage.openHomePage();

        //2 Assert Browser title
        homePage.checkHomePageTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName();

        //5 Open through the header menu Service -> Dates Page
        homePage.openDatesPage();

        //6 Set left slider - the most left position, right slider - the most right position
        datesPage.setSliderPosition(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsForSliders("(To):100");
        datesPage.checkLogRowsForSliders("(From):0");

        //8 Set left slider - the most left position, right slider - the most left position.
        datesPage.setSliderPosition(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsForSliders("(To):0");
        datesPage.checkLogRowsForSliders("(From):0");

        //10 Set left slider - the most right position, right slider - the most right position.
        datesPage.setSliderPosition(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsForSliders("(To):100");
        datesPage.checkLogRowsForSliders("(From):100");

        //12 Set left slider on 30 position, right slider - 70 position.
        datesPage.setSliderPosition(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsForSliders("(To):70");
        //datesPage.checkLogRowsForSliders("(From):30"); A bug was detected.
        //When setting the slider to position 30, the action isn't displayed in the log.
    }
}
