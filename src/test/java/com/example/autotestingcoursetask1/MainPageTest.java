package com.example.autotestingcoursetask1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage;
    LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("https://www.ok.ru/");
    }

    @Test
    public void logIn() {
        loginPage.enterLoginAndPass("+79062180245", "Pass12345");
        mainPage = loginPage.doLogIn();
        assertTrue(mainPage.containsUniqueElements());
        assertTrue(mainPage.assertUserName("Артем Ясевич"));
    }
}
