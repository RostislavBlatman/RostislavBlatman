package hw4;

import base.Homework4Base;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.DifferentElements;
import pageObject.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

public class TestForDifferentElementsPage extends Homework4Base {

    private HomePageSelenide homePage;
    private DifferentElements difElements;

    @BeforeClass
    public void beforeClass(){

        homePage = page(HomePageSelenide.class);
        difElements = page(DifferentElements.class);

    }

    @Test
    public void testDifferentPageContent() {

        //1 Open test site by URL
        homePage.openHomePage();

        //2 Assert Browser title
        homePage.checkHomePageTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserName();

        //5 Check interface on Home page, it contains all needed elements.
        homePage.checkInterface();

        //6 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkHeaderServiceDropdown();

        //7 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkLeftServiceDropdown();

        //8 Open through the header menu Service -> Different Elements Page and check page title
        homePage.openDifferentElements();
        difElements.checkDifElementsPageTitle();

        //9 Check interface on Different elements page, it contains all needed elements
        difElements.checkInterfaceDifElements();

        //10 Assert that there is Left Section
        difElements.checkLeftSection();

        //11 Assert that there is Right Section
        difElements.checkRightSection();

        //12 Select checkboxes
        difElements.checkSelectCheckboxes();

        //13 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox. 
        difElements.checkCheckboxLog(1, "Wind", "true");
        difElements.checkCheckboxLog(2, "Water", "true");

        //14 Select radio
        difElements.checkSelectRadio();

        //15 Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton. 
        difElements.checkRadioLog("metal: value changed to Selen");

        //16 Select in dropdown
        difElements.checkSelectColor();

        //17 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        difElements.checkColorLog("Yellow");

        //18 Unselect and assert checkboxes
        difElements.checkSelectCheckboxes();

        //19 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox. 
        difElements.checkCheckboxLog(1, "Wind", "false");
        difElements.checkCheckboxLog(2, "Water", "false");
    }
}
