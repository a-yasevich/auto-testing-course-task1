package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.MainPage;
import utils.User;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    static final User user = new User("", "", "");
    private static final String LOGIN_URL = "https://www.ok.ru/";
    MainPage mainPage;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        //Configuration.pageLoadTimeout = 100000;
    }

    @BeforeEach
    public void setUp() {
        open(LOGIN_URL);
        mainPage = new LoginPage().logIn(user);
    }

    @AfterEach
    public void exit() {
        mainPage.logout();
        closeWebDriver();
    }

    @AfterAll
    public static void close() {
        closeWebDriver();
    }

}
