package pages;

import pages.elements.FeedList;
import utils.FeedItem;

public class ProfilePage extends ContentPage {
    private final FeedList feedList = new FeedList();

    public void hasFeedListUser() {
        feedList.hasFeedList();
    }

    public FeedItem getLastFeed() {
        return feedList.getLastRepost();
    }

    @Override
    public ProfilePage check() {
        hasFeedListUser();
        return this;
    }
}
