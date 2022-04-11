package pages;

import pages.elements.PopularGroupsList;
import utils.GroupItem;

import java.util.List;

import static com.codeborne.selenide.Selenide.refresh;

public abstract class AbstractGroupsPage {
    private final PopularGroupsList popularGroupsList = new PopularGroupsList();

    public abstract EmptyGroups clearGroups();

    public abstract NonEmptyGroups fillListWithJoinedGroups(List<GroupItem> groups);

    public AbstractGroupsPage fillListWithPopularGroupsPresentedOnPage(int numberOfGroups, List<GroupItem> groups) {
        groups.addAll(popularGroupsList.listOfPopularGroups(numberOfGroups));
        return this;
    }

    public NonEmptyGroups joinPopularGroups(int groups) {
        popularGroupsList.joinPopularGroups(groups);
        refresh();
        return new NonEmptyGroups();
    }
}
