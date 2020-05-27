package test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.FeedPage;
import pages.LoginPage;
import pages.MyDiaryPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    LoginPage loginPage;
    FeedPage feedPage;
    MyDiaryPage myDiaryPage;

    @BeforeMethod
    public void setupBrowser() {
        Configuration.startMaximized = true;
        Configuration.browser = "FIREFOX";
        Configuration.timeout = 20000;
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        myDiaryPage = new MyDiaryPage();
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        getWebDriver().quit();
    }
}
