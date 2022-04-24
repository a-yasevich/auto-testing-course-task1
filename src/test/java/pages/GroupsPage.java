package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.elements.PopularGroupsList;
import pages.elements.UserGroupsList;
import utils.GroupItem;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class GroupsPage extends ContentPage {
    private final static By USER_GROUPS_BLOCK = By.xpath("//*[@id=\"hook_Block_MyGroupsTopBlock\"]");
    private final static By GROUPS_PAGE_HEADER = By.xpath("//*[@id=\"hook_Block_LayoutHeader\"]");

    private final PopularGroupsList popularGroupsList = new PopularGroupsList();
    private final UserGroupsList userGroupsList;

    @Override
    public GroupsPage check() {
        $(GROUPS_PAGE_HEADER).should(Condition.exist);
        return this;
    }

    protected GroupsPage() {
        userGroupsList = $(USER_GROUPS_BLOCK).is(exist) ? new UserGroupsList() : null;
    }

    public GroupPage openGroupPage(String link) {
        String fullLink = BASE_URL + link;
        open(fullLink);
        return new GroupPage(fullLink);
    }

    public GroupsPage clearGroups() {
        if (userGroupsList != null) {
            userGroupsList.clearGroups();
        }
        return new GroupsPage();
    }

    public List<GroupItem> joinedGroups() {
        return userGroupsList == null ? Collections.emptyList() : userGroupsList.userGroupsList();
    }

    public List<GroupItem> popularGroupsPresentedOnPage(int numberOfGroups) {
        return popularGroupsList.listOfPopularGroups(numberOfGroups);
    }

    public GroupsPage joinPopularGroups(int groups) {
        popularGroupsList.joinPopularGroups(groups);
        refresh();
        return new GroupsPage();
    }
}
