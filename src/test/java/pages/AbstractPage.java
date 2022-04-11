package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.elements.NavigationBlock;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractPage {
    private static final String BASE_URL = "https://ok.ru";
    private final static By USER_MINI_CARD = By.xpath("//div[@class=\"ucard-mini toolbar_ucard js-toolbar-menu\"]");
    private final static By LOGOUT_LINK = By.xpath("//a[@data-l=\"t,logout\"]");
    private final static By LOGOUT_BUTTON = By.xpath("//input[@data-l=\"t,logout\"]");

    protected final static NavigationBlock navigationBlock= new NavigationBlock();

    public void check() {
        navigationBlock.check();
        $(USER_MINI_CARD).should(Condition.exist)
                .shouldBe(Condition.visible);
    }

    public void logout() {
        $(USER_MINI_CARD).should(Condition.exist).shouldBe(Condition.visible).click();
        $(LOGOUT_LINK).should(Condition.exist).shouldBe(Condition.visible).click();
        $(LOGOUT_BUTTON).should(Condition.exist).shouldBe(Condition.visible).click();
    }

    public GroupPage openGroupPage(String link) {
        String fullLink = BASE_URL + link;
        open(fullLink);
        return new GroupPage(fullLink);
    }
}
