package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.FeedItem;

import static com.codeborne.selenide.Selenide.*;

public class FeedList {
    private final static By FEED_LIST = By.xpath("//*[@class=\"feed-list\"]");
    private final static ElementsCollection LIST_OF_POSTS = $$x("//*[@class=\"feed-w\"]");
    private final static By BUTTON_REPOST = By.xpath("//*[@class=\"widget  __compact\"]/button");
    private final static By BUTTON_DO_REPOST_NOW = By.xpath("//*[@data-l=\"t,now\"]");
    private final static By LINK_POST = By.xpath("//a[@class=\"media-text_a\"]");

    public void hasFeedList() {
        $(FEED_LIST).should(Condition.exist).shouldBe(Condition.visible);
    }

    public FeedItem doRepost() {
        SelenideElement firstPost = LIST_OF_POSTS.first();
        $(BUTTON_REPOST).should(Condition.exist).shouldBe(Condition.visible).click();
        FeedItem feedItem = new FeedItem(firstPost.text(),
                $(LINK_POST).should(Condition.exist).shouldBe(Condition.visible).attr("href"));
        $(BUTTON_DO_REPOST_NOW).scrollIntoView(false).click();
        return feedItem;
    }

    public FeedItem getLastRepost() {
        SelenideElement firstPost = LIST_OF_POSTS.first();
        return new FeedItem(firstPost.text(), $(LINK_POST).attr("href"));
    }

}
