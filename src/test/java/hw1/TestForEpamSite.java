package hw1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestForEpamSite {

    private WebDriver driver;

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test
    public void homePageTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/");
        assertEquals("https://epam.github.io/JDI/index.html", driver.getCurrentUrl());

        //1 Assert Browser title
        assertEquals("Home Page", driver.getTitle());

        //2 Perform login
        driver.findElement(By.cssSelector("#user-icon")).click();
        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".fa-sign-in")).click();

        //3 Assert User name in the right-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        assertTrue(userName.isDisplayed());
        assertEquals("PITER CHAILOVSKII", userName.getText());

        //4 Assert browser title
        assertEquals("Home Page", driver.getTitle());

        List<WebElement> headerNavList = driver.findElements(By.cssSelector(".nav > li"));

        //5 Assert that there are 4 items on the header section
        assertEquals(headerNavList.size(), 4);

        //5 Assert that items on the header section are displayed
        assertTrue(headerNavList.get(0).isDisplayed());
        assertTrue(headerNavList.get(1).isDisplayed());
        assertTrue(headerNavList.get(2).isDisplayed());
        assertTrue(headerNavList.get(3).isDisplayed());

        //5 Assert that items on the header section have proper texts
        assertEquals(headerNavList.get(0).getText(), "HOME");
        assertEquals(headerNavList.get(1).getText(), "CONTACT FORM");
        assertEquals(headerNavList.get(2).getText(), "SERVICE");
        assertEquals(headerNavList.get(3).getText(), "METALS & COLORS");

        List<WebElement> imagesFromPage = driver.findElements(By.cssSelector(".benefit-icon"));

        //6 Assert that there are 4 images on the index page
        assertEquals(imagesFromPage.size(), 4);

        //6 Assert that images on the index page are displayed
        assertTrue(imagesFromPage.get(0).isDisplayed());
        assertTrue(imagesFromPage.get(1).isDisplayed());
        assertTrue(imagesFromPage.get(2).isDisplayed());
        assertTrue(imagesFromPage.get(3).isDisplayed());

        List<WebElement> textsUnderIcons = driver.findElements(By.cssSelector(".benefit-txt"));

        //7 Assert that there are 4 texts under icons on the Index page
        assertEquals(textsUnderIcons.size(), 4);

        //7 Assert that texts under icons on the index page are displayed
        assertTrue(textsUnderIcons.get(0).isDisplayed());
        assertTrue(textsUnderIcons.get(1).isDisplayed());
        assertTrue(textsUnderIcons.get(2).isDisplayed());
        assertTrue(textsUnderIcons.get(3).isDisplayed());

        //7 Assert that texts under icons on the index page have proper text
        assertEquals(textsUnderIcons.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\nEPAM project");
        assertEquals(textsUnderIcons.get(1).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(textsUnderIcons.get(2).getText(), "To be multiplatform");
        assertEquals(textsUnderIcons.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\nsome external projects),\n" +
                "wish to get more…");

        //8 Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector(".main-title"));
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement mainText = driver.findElement(By.cssSelector(".main-txt"));
        assertEquals(mainText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT " +
                "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //9 Assert a text of the sub header
        WebElement subText = driver.findElement(By.cssSelector(".text-center > a"));
        assertEquals(subText.getText(), "JDI GITHUB");

        //10 Assert that JDI GITHUB is a link and has a proper URL
        WebElement subLink = driver.findElement(By.cssSelector(".text-center > a"));
        assertEquals(subLink.getAttribute("href"), "https://github.com/epam/JDI");

        //11 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("div[name = 'navigation-sidebar']")).isDisplayed());

        //12 Assert that there is Footer
        assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());
    }


}
