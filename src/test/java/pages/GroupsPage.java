package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import pages.elements.AllMyGroups;
import utils.GroupItem;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GroupsPage extends AbstractPage {

    private final static By SEARCH_GROUP_FIELD = By.xpath("//*[@id=\"hook_Block_UserGroupSearch2QueryBlock\"]//input");
    private final static By JOIN_GROUP_BUTTON = By.xpath("//*[@id=\"userGroupsSearchResultList\"]//*[@data-l = \"t,join\"]");
    private final static By POPULAR_GROUPS_LIST = By.xpath("//*[@id=\"hook_Loader_PopularGroupsListBlockLoader\"]//*[@class = \"o group-name-link\"]");
    private final static By JOIN_POPULAR_GROUP_BUTTONS = By.xpath("//*[@id=\"hook_Loader_PopularGroupsListBlockLoader\"]//*[@data-l = \"t,join\"]");
    private final static By USER_GROUPS_LIST_MINIMALISTIC = By.xpath("//*[@id=\"hook_Block_MyGroupsTopBlock\"]//*[@data-group-id]");
    private final static By USER_GROUPS_COUNT = By.xpath("//*[@id=\"hook_Block_MyGroupsTopBlock\"]//*[@class = \"portlet_h_count\"]");
    private final static By USER_GROUPS_BLOCK = By.xpath("//*[@id=\"hook_Block_MyGroupsTopBlock\"]");
    private final static By ALL_GROUPS = By.xpath("//*[@id=\"hook_Block_MyGroupsTopBlock\"]//*[@class = \"portlet_h_name_t\"]/a");


    private final AllMyGroups allMyGroups = new AllMyGroups();

    public GroupsPage findGroup(String groupName) {
        $(SEARCH_GROUP_FIELD)
                .shouldBe(visible)
                .setValue(groupName)
                .pressEnter();
        return this;
    }

    public GroupsPage clearGroups() {
        ElementsCollection userGroupsList = $$(USER_GROUPS_LIST_MINIMALISTIC);
        int joinedGroups = joinedGroupsCount();
        for (int i = 0; i < joinedGroups; i++) {
            userGroupsList
                    .first()
                    .shouldBe(visible)
                    .click();
            GroupPage.leaveFromGroup();
        }
        return this;
    }

    public GroupsPage fillListWithJoinedGroups(List<GroupItem> groups) {
        refresh();
        int joinedGroups = joinedGroupsCount();
        $(ALL_GROUPS).shouldBe(visible).click();
        groups.addAll(allMyGroups.userGroupsList(joinedGroups));
        return this;
    }

    public int joinedGroupsCount() {
        $(USER_GROUPS_BLOCK).shouldBe(Condition.exist);
        if ($(USER_GROUPS_COUNT).is(not(exist))) {
            return 0;
        }
        return Integer.parseInt($(USER_GROUPS_COUNT).shouldBe(visible).text());
    }

    public GroupsPage joinGroup() {
        $(JOIN_GROUP_BUTTON).shouldBe(visible).click();
        return this;
    }

    public GroupsPage fillListWithPopularGroupsPresentedOnPage(int numberOfGroups, List<GroupItem> groups) {
        ElementsCollection popularGroups = $$(POPULAR_GROUPS_LIST);
        for (int i = 0; i < numberOfGroups; i++) {
            String link = popularGroups.get(i).attr("href");
            String name = popularGroups.get(i).attr("title");
            groups.add(new GroupItem(name, link));
        }

        return this;
    }

    public GroupsPage joinPopularGroups(int groups) {
        ElementsCollection joinButtons = $$(JOIN_POPULAR_GROUP_BUTTONS);
        for (int i = 0; i < groups; i++) {
            joinButtons.get(i).scrollIntoView(false).shouldBe(visible).click();
        }
        return this;
    }
}
