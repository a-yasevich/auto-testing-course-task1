package pages;

import com.codeborne.selenide.SelenideElement;
import utils.User;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;

public class LoginPage {
    private final SelenideElement loginField = $x("//*[@id=\"field_email\"]");
    private final SelenideElement passwordField = $x("//*[@id=\"field_password\"]");
    private final SelenideElement loginButton = $x("//*[@class=\"login-form-actions\"]/input");

    public MainPage doLogIn(User user) {
        refresh();
        loginField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
        return new MainPage();
    }
}
