package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import utils.GroupItem;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class GroupPage extends ContentPage {
    private static final By GROUP_BUTTON = By.xpath("//*[@id=\"hook_Block_AltGroupMainMenu\"]//*[@data-l = \"outlandertarget,join,t,join\"]");
    private static final By LEAVE_GROUP = By.xpath("//*[@id=\"hook_Block_AltGroupMainMenu\"]//*[@class = \"dropdown_cnt __wide __show\"]");
    private static final By GROUP_MEMBER = By.xpath("//*[@id=\"hook_Block_AltGroupMainMembersRB\"]//*[@class = \"caption center\"]//a");
    private static final By GROUP_NAME = By.xpath("//*[@id=\"hook_Block_AltGroupInfo\"]//h1");
    private final String link;

    public GroupPage(String link) {
        this.link = link;
    }

    @Override
    public GroupPage check() {
        $(GROUP_NAME).should(exist);
        return this;
    }

    public static void leaveFromGroup() {
        $(GROUP_BUTTON).shouldBe(Condition.visible).click();
        $(LEAVE_GROUP).shouldBe(Condition.visible).click();
    }

    public MainPage goToFirstMember() {
        refresh();
        $(GROUP_MEMBER).scrollIntoView(false)
                .shouldBe(Condition.visible)
                .click();
        return new MainPage();
    }

    public GroupPage joinGroup() {
        $(GROUP_BUTTON).shouldBe(Condition.visible).click();
        return this;
    }

    public GroupItem getGroupItem() {
        String name = $(GROUP_NAME).text();
        return new GroupItem(name, link);
    }

}
