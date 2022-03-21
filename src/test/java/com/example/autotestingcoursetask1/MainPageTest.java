package com.example.autotestingcoursetask1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    MainPage mainPage;
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage;
    AbstractPage nowPage;

    private static final String LOGIN = "NO";
    private static final String PASSWORD = "NO";

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("https://www.ok.ru/");
        loginPage.enterLoginAndPass(LOGIN, PASSWORD);
        mainPage = loginPage.doLogIn();
        nowPage = mainPage;
    }

    @AfterEach
    public void exit() {
        nowPage.logout();
    }

    @Test
    public void logIn() {
        assertTrue(mainPage.hasUserNameField()
                && mainPage.hasPhoto()
                && mainPage.hasUserNavBlock()
                && mainPage.hasFeedList());
        assertEquals( "", mainPage.getUserName());
    }

    @Test void addPost() {
        Repost repost = mainPage.doRepost();
        profilePage = mainPage.openProfilePage();
        nowPage = profilePage;
        assertTrue(profilePage.hasFeedListUser());
        assertEquals(repost, profilePage.getLastRepost());
    }
}
