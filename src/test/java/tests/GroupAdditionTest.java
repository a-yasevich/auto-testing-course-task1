package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.GroupPage;
import utils.GroupItem;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.qatools.matchers.collection.HasSameItemsAsListMatcher.hasSameItemsAsList;

public class GroupAdditionTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"/vkedu", "/technopolis", "/v.v..putin"})
    public void addGroupByLinkTest(String link) {
        GroupPage groupPage = mainPage
                .openGroupsPage()
                .clearGroups()
                .openGroupPage(link)
                .joinGroup();
        GroupItem group = groupPage.getGroupItem();
        mainPage = groupPage.goToFirstMember();
        mainPage.check();
        assertEquals(user.getName(), mainPage.getUserName(), "Wrong user");
        List<GroupItem> joinedGroups = new ArrayList<>();
        mainPage.openGroupsPage()
                .fillListWithJoinedGroups(joinedGroups);
        assertThat(List.of(group), hasSameItemsAsList(joinedGroups));


    }
}
