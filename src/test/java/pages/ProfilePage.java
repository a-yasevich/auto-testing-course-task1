package pages;

import pages.elements.FeedList;
import utils.Repost;

public class ProfilePage extends AbstractPage{
    private final FeedList feedList = new FeedList();

    public boolean hasFeedListUser() {
        return feedList.hasFeedList();
    }


    public Repost getLastRepost() {
        return feedList.getLastRepost();
    }

}