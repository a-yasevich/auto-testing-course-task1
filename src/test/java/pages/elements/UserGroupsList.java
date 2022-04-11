package pages.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.GroupPage;
import utils.GroupItem;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UserGroupsList {
    private final static By GROUPS_LIST = By.xpath("//*[@id=\"listBlockPanelUserGroupsSectionBlock\"]//*[@class = \"group-vitrine-card_name\"]");
    private final static String GROUPS_TOP_BLOCK = "//*[@id=\"hook_Block_MyGroupsTopBlock\"]";
    private final static By USER_GROUPS_LIST_MINIMALISTIC = By.xpath(GROUPS_TOP_BLOCK + "//*[@data-group-id]");
    private final static By USER_GROUPS_COUNT = By.xpath(GROUPS_TOP_BLOCK + "//*[@class = \"portlet_h_count\"]");
    private final static By ALL_GROUPS = By.xpath(GROUPS_TOP_BLOCK + "//*[@class = \"portlet_h_name_t\"]/a");

    public List<GroupItem> userGroupsList() {
        int joinedGroups = joinedGroupsCount();
        $(ALL_GROUPS).shouldBe(visible).click();
        List<GroupItem> userGroupsList = new ArrayList<>(joinedGroups);
        ElementsCollection elements = $$(GROUPS_LIST);
        for (int i = 0; i < joinedGroups; i++) {
            SelenideElement group = elements.get(i);
            String link = group.attr("href");
            String name = group.text();
            userGroupsList.add(new GroupItem(name, link));
        }
        return userGroupsList;
    }

    public void clearGroups() {
        ElementsCollection userGroupsList = $$(USER_GROUPS_LIST_MINIMALISTIC);
        int joinedGroups = joinedGroupsCount();
        for (int i = 0; i < joinedGroups; i++) {
            userGroupsList
                    .first()
                    .shouldBe(visible)
                    .click();
            GroupPage.leaveFromGroup();
        }
    }

    public int joinedGroupsCount() {
        return Integer.parseInt($(USER_GROUPS_COUNT).shouldBe(visible).text());
    }
}
