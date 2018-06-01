package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.HomePage;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TextWithDataProviderTest {

    private WebDriver driver;
    private HomePage homePage;

    @AfterClass
    public void afterClass(){
        driver.close();
    }

    @DataProvider(name = "text under image",parallel = true)
    public Object[][] underText() {
        return new Object[][]{
                {0, "To include good practices\nand ideas from successful\nEPAM project"},
                {1, "To be flexible and\ncustomizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}

        };

    }

    @Test(dataProvider = "text under image")
    public void textUnderImageTest(int indexImage, String underText) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site URL
        homePage = new HomePage();
        homePage.open(driver);

        //2 Asserting 4 texts below 4 pictures on the Index Page
        List<WebElement> textsUnderIcons = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textsUnderIcons.get(indexImage).getText(), underText);

        //3 Close Browser
        driver.close();
    }

}
