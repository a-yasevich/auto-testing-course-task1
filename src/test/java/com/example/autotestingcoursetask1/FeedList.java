package com.example.autotestingcoursetask1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FeedList {
    private final SelenideElement feedList = $x("//*[@class=\"feed-list\"]");
    private final ElementsCollection listOfPosts = $$x("//*[@class=\"feed-w\"]");
    public boolean hasFeedList() {
        return feedList.exists();
    }

    public boolean hasPosts() {
        SelenideElement firstPost = feedList.$x("//*[@class=\"feed-w\"]");
        return firstPost.exists();
    }

    public Repost doRepost() {
        if (!feedList.exists()) {
            return null;
        }

        for (SelenideElement post : listOfPosts) {
            if (post.exists()) {
                SelenideElement button = $x("//*[@class=\"widget  __compact\"]/button");
                button.click();
                SelenideElement buttonRepost = $x("//*[@data-l=\"t,now\"]");
                String text = post.text();
                String href = $x("//a[@class=\"media-link_a\"]").attr("href");
                Repost repost = new Repost(text, href);
                buttonRepost.click();
                return repost;
            }
        }
        return null;
    }

    public Repost getLastRepost() {
        ElementsCollection listOfPosts = $$x("//*[@class=\"feed-w\"]");
        for (SelenideElement post : listOfPosts) {
            if (post.exists()) {
                return new Repost(post.text(), $x("//a[@class=\"media-link_a\"]").attr("href"));
            }
        }
        return null;
    }

    public boolean isLastRepost(Repost repost) {
        if (!feedList.exists()) {
            return false;
        }
        ElementsCollection listOfPosts = $$x("//*[@class=\"feed-w\"]");
        for (SelenideElement post : listOfPosts) {
            if (post.exists()) {
                Repost postOnProfilePage = new Repost(post.text(), $x("//a[@class=\"media-link_a\"]").attr("href"));
                if (repost.equals(postOnProfilePage)) {
                    return true;
                }
            }
        }
        return false;
    }
}
