package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractPage {
    private static final String BASE_URL = "https://www.ok.ru/";
    private final SelenideElement userNavBlock = $x("//*[@id=\"hook_Block_SideNavigation\"]");
    private final SelenideElement userCardMini = $x("//div[@class=\"ucard-mini toolbar_ucard js-toolbar-menu\"]");

    public boolean hasUserNavBlock() {
        return userNavBlock.exists();
    }

    public void logout() {
        userCardMini.click();
        $x("//a[@data-l=\"t,logout\"]").click();
        $x("//input[@data-l=\"t,logout\"]").click();
    }

    public GroupPage openGroupPage(String link) {
        open(BASE_URL + link);
        return new GroupPage();
    }
}
