package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class Homework4Base {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.screenshots = false;
    }

}
