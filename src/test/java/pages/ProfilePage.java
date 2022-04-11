package pages;

import pages.elements.FeedList;
import utils.FeedItem;

public class ProfilePage extends AbstractPage {
    private final FeedList feedList = new FeedList();

    public void hasFeedListUser() {
        feedList.hasFeedList();
    }

    public FeedItem getLastFeed() {
        return feedList.getLastRepost();
    }

}
