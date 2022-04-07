package tests;

import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import utils.Repost;

import static org.junit.jupiter.api.Assertions.*;

public class FeedTest extends BaseTest {

    @Test
    public void logIn() {
        assertAll("Main page has its distinctive traits",
                () -> assertTrue(mainPage.hasUserNameField(), "There is no name field"),
                () -> assertTrue(mainPage.hasPhoto(), "There is no photo block"),
                () -> assertTrue(mainPage.hasFeedList(), "There is no feed list")
        );
        assertEquals(user.getName(), mainPage.getUserName(), "Wrong user");
    }

    @Test
    void addPost() {
        Repost repost = mainPage.doRepost();
        ProfilePage profilePage = mainPage.openProfilePage();
        assertTrue(profilePage.hasFeedListUser());
        assertEquals(repost, profilePage.getLastRepost());
    }
}
