package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.elements.PopularGroupsList;
import pages.elements.UserGroupsList;
import utils.GroupItem;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class GroupsPage extends AbstractPage {

    private final static By USER_GROUPS_BLOCK = By.xpath("//*[@id=\"hook_Block_MyGroupsTopBlock\"]");
    private final static By GROUPS_PAGE_HEADER = By.xpath("//*[@id=\"hook_Block_LayoutHeader\"]");


    private final UserGroupsList userGroupList;
    private final PopularGroupsList popularGroupsList = new PopularGroupsList();

    public GroupsPage() {
        $(GROUPS_PAGE_HEADER).shouldBe(Condition.exist);
        userGroupList = $(USER_GROUPS_BLOCK).is(exist) ? new UserGroupsList() : null;
    }

    public GroupsPage clearGroups() {
        if (userGroupList == null) {
            return this;
        }
        userGroupList.clearGroups();
        return new GroupsPage();
    }

    public GroupsPage fillListWithJoinedGroups(List<GroupItem> groups) {
        if (userGroupList != null) {
            groups.addAll(userGroupList.userGroupsList());
        }
        return this;
    }

    public GroupsPage fillListWithPopularGroupsPresentedOnPage(int numberOfGroups, List<GroupItem> groups) {
        groups.addAll(popularGroupsList.listOfPopularGroups(numberOfGroups));
        return this;
    }

    public GroupsPage joinPopularGroups(int groups) {
        popularGroupsList.joinPopularGroups(groups);
        refresh();
        return new GroupsPage();
    }
}
