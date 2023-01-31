package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.elements.NavigationBlock;

import static com.codeborne.selenide.Selenide.$;

abstract class ContentPage implements Page {
    protected static final String BASE_URL = "https://ok.ru";
    private final static By USER_MINI_CARD = By.xpath("//div[@class=\"ucard-mini toolbar_ucard js-toolbar-menu\"]");
    private final static By LOGOUT_LINK = By.xpath("//a[@data-l=\"t,logout\"]");
    private final static By LOGOUT_BUTTON = By.xpath("//input[@data-l=\"t,logout\"]");

    protected final static NavigationBlock navigationBlock= new NavigationBlock();

    protected ContentPage() {
        navigationBlock.check();
        $(USER_MINI_CARD).should(Condition.exist)
                .shouldBe(Condition.visible);
    }

    public void logout() {
        $(USER_MINI_CARD).should(Condition.exist).shouldBe(Condition.visible).click();
        $(LOGOUT_LINK).should(Condition.exist).shouldBe(Condition.visible).click();
        $(LOGOUT_BUTTON).should(Condition.exist).shouldBe(Condition.visible).click();
    }

}
