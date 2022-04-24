package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.GroupsPage;
import utils.GroupItem;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.collection.HasSameItemsAsListMatcher.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


public class PopularGroupsAdditionTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    public void addGroupsFromListOfPopularsTest(int groupsToAdd) {
        GroupsPage groupsPage = mainPage.openGroupsPage().check()
                .clearGroups().check();
        List<GroupItem> presentedOnPage = groupsPage.popularGroupsPresentedOnPage(groupsToAdd);
        List<GroupItem> joined = groupsPage.joinPopularGroups(groupsToAdd).joinedGroups();
        assertEquals(presentedOnPage.size(), joined.size(), "Number of groups doesn't match");
        assertThat("Lists should contain same groups", joined, hasSameItemsAsList(presentedOnPage));
    }
}
