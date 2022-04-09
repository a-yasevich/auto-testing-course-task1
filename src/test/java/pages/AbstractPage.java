package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public abstract class AbstractPage {
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
}
