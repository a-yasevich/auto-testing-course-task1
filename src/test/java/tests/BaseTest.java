package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.MainPage;
import utils.User;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    MainPage mainPage;
    private static final User user = new User("+79062180245", "Test12345", "Артем Ясевич");

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("https://www.ok.ru/");
        LoginPage page = new LoginPage();
        mainPage = page.doLogIn(user);
    }

    @AfterEach
    public void closeDriver() {
        Selenide.closeWebDriver();
    }

}
