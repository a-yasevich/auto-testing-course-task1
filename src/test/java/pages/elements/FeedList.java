package pages.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.FeedItem;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FeedList {
    private final SelenideElement feedList = $x("//*[@class=\"feed-list\"]");
    private final ElementsCollection listOfPosts = $$x("//*[@class=\"feed-w\"]");

    public boolean hasFeedList() {
        return feedList.exists();
    }

    public FeedItem doRepost() {
        SelenideElement firstPost = listOfPosts.first();
        SelenideElement button = $x("//*[@class=\"widget  __compact\"]/button");
        button.click();
        SelenideElement buttonRepost = $x("//*[@data-l=\"t,now\"]");
        FeedItem feedItem = new FeedItem(firstPost.text(), $x("//a[@class=\"media-text_a\"]").attr("href"));
        buttonRepost.scrollIntoView(false).click();
        return feedItem;
    }

    public FeedItem getLastRepost() {
        SelenideElement firstPost = listOfPosts.first();
        return new FeedItem(firstPost.text(), $x("//a[@class=\"media-text_a\"]").attr("href"));
    }

}
