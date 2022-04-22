package pages;

import pages.elements.PopularGroupsList;
import utils.GroupItem;

import java.util.List;

import static com.codeborne.selenide.Selenide.refresh;

public abstract class ContentGroupsPage extends ContentPage {
    private final PopularGroupsList popularGroupsList = new PopularGroupsList();

    public abstract GroupsPageWithoutUserGroups clearGroups();

    public abstract GroupsPageWithUserGroups fillListWithJoinedGroups(List<GroupItem> groups);

    public ContentGroupsPage fillListWithPopularGroupsPresentedOnPage(int numberOfGroups, List<GroupItem> groups) {
        groups.addAll(popularGroupsList.listOfPopularGroups(numberOfGroups));
        return this;
    }

    public GroupsPageWithUserGroups joinPopularGroups(int groups) {
        popularGroupsList.joinPopularGroups(groups);
        refresh();
        return new GroupsPageWithUserGroups();
    }
}
