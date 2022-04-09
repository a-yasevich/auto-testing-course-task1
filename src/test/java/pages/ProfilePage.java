package pages;

import pages.elements.FeedList;
import utils.FeedItem;

public class ProfilePage extends AbstractPage {
    private final FeedList feedList = new FeedList();

    public boolean hasFeedListUser() {
        return feedList.hasFeedList();
    }

    public FeedItem getLastFeed() {
        return feedList.getLastRepost();
    }

}
