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
    MainPage mainPage;
    private static final String LOGIN_URL = "https://www.ok.ru/";
    static final User user = new User("", "", "");

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open(LOGIN_URL);
        LoginPage page = new LoginPage();
        mainPage = page.doLogIn(user);
    }

    @AfterEach
    public void exit() {
        mainPage.logout();
    }

    @AfterAll
    public static void close() {
        closeWindow();
        closeWebDriver();
    }

}
