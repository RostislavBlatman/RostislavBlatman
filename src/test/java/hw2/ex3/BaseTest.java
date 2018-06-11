package hw2.ex3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class BaseTest {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(System.currentTimeMillis());
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
