package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupAdditionTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"/vkedu", "/technopolis", "/v.v..putin"})
    public void userIsMemberOfJoinedGroup(String link) {
        MainPage nowPage = mainPage
                .openGroupsPage()
                .clearGroups()
                .openGroupPage(link)
                .joinGroup()
                .goToFirstMember();
        assertAll("Main page has its distinctive traits",
                () -> assertTrue(nowPage.hasUserNameField(), "There is no name field"),
                () -> assertTrue(nowPage.hasPhoto(), "There is no photo block"),
                () -> assertTrue(nowPage.hasFeedList(), "There is no feed list")
        );
        assertEquals(user.getName(), mainPage.getUserName(), "Wrong user");

    }
}
