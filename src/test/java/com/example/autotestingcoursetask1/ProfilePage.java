package com.example.autotestingcoursetask1;

public class ProfilePage extends AbstractPage{
    private final FeedList feedList = new FeedList();

    public boolean hasFeedListUser() {
        return feedList.hasFeedList();
    }

    public boolean hasRepost(Repost repost) {
        return feedList.isLastRepost(repost);
    }

    public Repost getLastRepost() {
        return feedList.getLastRepost();
    }

}
