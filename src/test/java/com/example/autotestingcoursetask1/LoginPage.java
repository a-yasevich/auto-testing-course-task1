package com.example.autotestingcoursetask1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;

public class LoginPage {
    private final SelenideElement loginField = $x("//*[@id=\"field_email\"]");
    private final SelenideElement passwordField = $x("//*[@id=\"field_password\"]");
    private final SelenideElement loginButton = $x("//*[@class=\"login-form-actions\"]/input");

    public void enterLoginAndPass(String login, String password) {
        refresh();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
    }

    public MainPage doLogIn() {
        loginButton.click();
        return new MainPage();
    }
}
