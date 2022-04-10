package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.GroupItem;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.collection.HasSameItemsAsListMatcher.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class PopularGroupsAdditionTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(ints = {3})
    public void addGroups(int groups) {
        List<GroupItem> actual = new ArrayList<>();
        List<GroupItem> joined = new ArrayList<>();
        mainPage.openGroupsPage()
                .clearGroups()
                .fillListWithPopularGroupsPresentedOnPage(groups, actual)
                .joinPopularGroups(groups)
                .fillListWithJoinedGroups(joined);
        System.out.println(joined);
        System.out.println(actual);
        assertEquals(joined.size(), actual.size(), "Number of groups doesn't match");
        assertThat(joined, hasSameItemsAsList(actual));
    }
}
