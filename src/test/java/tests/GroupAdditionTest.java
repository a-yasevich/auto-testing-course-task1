package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.GroupPage;
import utils.GroupItem;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.matchers.collection.HasSameItemsAsListMatcher.*;

public class GroupAdditionTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"/vkedu", "/technopolis", "/v.v..putin"})
    public void userIsMemberOfJoinedGroup(String link) {
        GroupPage groupPage = mainPage
                .openGroupsPage()
                .clearGroups()
                .openGroupPage(link)
                .joinGroup();
        GroupItem group = groupPage.getGroupItem();
        List<GroupItem> joinedGroups = new ArrayList<>();
        mainPage = groupPage.goToFirstMember();
        assertAll("Main page has its distinctive traits",
                () -> assertTrue(mainPage.hasUserNameField(), "There is no name field"),
                () -> assertTrue(mainPage.hasPhoto(), "There is no photo block"),
                () -> assertTrue(mainPage.hasFeedList(), "There is no feed list")
        );
        assertEquals(user.getName(), mainPage.getUserName(), "Wrong user");
        mainPage.
                openGroupsPage().
                fillListWithJoinedGroups(joinedGroups);
        assertThat(List.of(group), hasSameItemsAsList(joinedGroups));


    }
}
