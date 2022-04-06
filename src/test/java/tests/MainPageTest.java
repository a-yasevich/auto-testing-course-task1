package tests;

import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import utils.Repost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest extends BaseTest{

    @Test
    public void logIn() {
        assertTrue(mainPage.hasUserNameField()
                && mainPage.hasPhoto()
                && mainPage.hasUserNavBlock()
                && mainPage.hasFeedList());
        assertEquals( "", mainPage.getUserName());
    }

    @Test void addPost() {
        Repost repost = mainPage.doRepost();
        ProfilePage profilePage = mainPage.openProfilePage();
        assertTrue(profilePage.hasFeedListUser());
        assertEquals(repost, profilePage.getLastRepost());
    }
}
