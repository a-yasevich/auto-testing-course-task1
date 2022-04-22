package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;


public class GroupsPageFactory {
    private final static By USER_GROUPS_BLOCK = By.xpath("//*[@id=\"hook_Block_MyGroupsTopBlock\"]");
    private final static By GROUPS_PAGE_HEADER = By.xpath("//*[@id=\"hook_Block_LayoutHeader\"]");

    public ContentGroupsPage get() {
        if (isUserGroupsListPresent()) {
            return new GroupsPageWithUserGroups();
        } else {
            return new GroupsPageWithoutUserGroups();
        }
    }

    private boolean isUserGroupsListPresent() {
        $(GROUPS_PAGE_HEADER).shouldBe(Condition.exist);
        return $(USER_GROUPS_BLOCK).is(exist);
    }
}
