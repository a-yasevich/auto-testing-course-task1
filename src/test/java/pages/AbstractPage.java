package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractPage {
    private static final String BASE_URL = "https://ok.ru";
    private final SelenideElement userNavBlock = $x("//*[@id=\"hook_Block_SideNavigation\"]");
    private final SelenideElement userCardMini = $x("//div[@class=\"ucard-mini toolbar_ucard js-toolbar-menu\"]");

    private final static By USER_NAVIGATION_BLOCK = By.xpath("//*[@id=\"hook_Block_SideNavigation\"]");
    private final static By USER_MINI_CARD = By.xpath("//div[@class=\"ucard-mini toolbar_ucard js-toolbar-menu\"]");
    private final static By LOGOUT_LINK = By.xpath("//a[@data-l=\"t,logout\"]");
    private final static By LOGOUT_BUTTON = By.xpath("//input[@data-l=\"t,logout\"]");

    public boolean hasUserNavBlock() {
        return $(USER_NAVIGATION_BLOCK).exists();
    }

    public void check() {
        $(USER_NAVIGATION_BLOCK).should(Condition.exist)
                .shouldBe(Condition.visible);
    }

    public void logout() {
        $(USER_MINI_CARD).click();
        $(LOGOUT_LINK).click();
        $(LOGOUT_BUTTON).click();
    }

    public GroupPage openGroupPage(String link) {
        String fullLink = BASE_URL + link;
        open(fullLink);
        return new GroupPage(fullLink);
    }
}
