package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;


public class GroupsPageFactory {
    private final static By USER_GROUPS_BLOCK = By.xpath("//*[@id=\"hook_Block_MyGroupsTopBlock\"]");
    private final static By GROUPS_PAGE_HEADER = By.xpath("//*[@id=\"hook_Block_LayoutHeader\"]");

    public AbstractGroupsPage get() {
        if (isUserGroupsListPresent()) {
            return new NonEmptyGroups();
        } else {
            return new EmptyGroups();
        }
    }

    private boolean isUserGroupsListPresent() {
        $(GROUPS_PAGE_HEADER).shouldBe(Condition.exist);
        return $(USER_GROUPS_BLOCK).is(exist);
    }
}
