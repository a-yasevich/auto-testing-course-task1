package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class AbstractPage {

    private final static By USER_NAVIGATION_BLOCK = By.xpath("//*[@id=\"hook_Block_SideNavigation\"]");
    private final static By USER_MINI_CARD = By.xpath("//div[@class=\"ucard-mini toolbar_ucard js-toolbar-menu\"]");
    private final static By LOGOUT_LINK = By.xpath("//a[@data-l=\"t,logout\"]");
    private final static By LOGOUT_BUTTON = By.xpath("//input[@data-l=\"t,logout\"]");

    public boolean hasUserNavBlock() {
        return $(USER_NAVIGATION_BLOCK).exists();
    }

    public void logout() {
        $(USER_MINI_CARD).click();
        $(LOGOUT_LINK).click();
        $(LOGOUT_BUTTON).click();
    }
}
