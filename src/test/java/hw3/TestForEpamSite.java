package hw3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.HomePage;

import static enums.Users.PITER_CHAILOVSKII;

public class TestForEpamSite {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = PageFactory.initElements(driver, HomePage.class);

    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test
    public void homePageTest() {

        homePage.open(driver);

        //1 Assert Browser title
        homePage.checkHomePageTitle(driver);

        //2 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //3 Assert User name in the right-top side of screen that user is loggined
        homePage.checkUserName(PITER_CHAILOVSKII);

        //4 Assert browser title
        homePage.checkHomePageTitle(driver);

        //5 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkItemsHeaderSection();

        homePage.checkImagesOnIndexPage();

        //7 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkTextsUnderImages();

        //8 Assert a text of the main header
        homePage.checkTextsOnMainHeader();

        //9 Assert a text of the sub header
        homePage.checkTextOnSubHeader();

        //10 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkSubHeaderLink();

        //11 Assert that there is Left Section
        homePage.checkLeftSection();

        //12 Assert that there is Footer
        homePage.checkFooter();
    }


}
