package tests;

import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import utils.FeedItem;

import static org.junit.jupiter.api.Assertions.*;

public class FeedTest extends BaseTest {

    @Test
    void addPost() {
        FeedItem feedItem = mainPage.doRepost();
        ProfilePage profilePage = mainPage.openProfilePage();
        profilePage.hasFeedListUser();
        assertEquals(feedItem, profilePage.getLastFeed());
    }

}
