package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.FeedItem;

import static com.codeborne.selenide.Selenide.*;

public class FeedList {
    private final static By FEED_LIST = By.xpath("//*[@class=\"feed-list\"]");
    private final ElementsCollection listOfPosts = $$x("//*[@class=\"feed-w\"]");

    public void hasFeedList() {
        $(FEED_LIST).should(Condition.exist).shouldBe(Condition.visible);
    }

    public FeedItem doRepost() {
        SelenideElement firstPost = listOfPosts.first();
        SelenideElement buttonRepost = $x("//*[@class=\"widget  __compact\"]/button");
        buttonRepost.click();
        SelenideElement buttonDoRepostNow = $x("//*[@data-l=\"t,now\"]");
        FeedItem feedItem = new FeedItem(firstPost.text(), $x("//a[@class=\"media-text_a\"]").attr("href"));
        buttonDoRepostNow.scrollIntoView(false).click();
        return feedItem;
    }

    public FeedItem getLastRepost() {
        SelenideElement firstPost = listOfPosts.first();
        return new FeedItem(firstPost.text(), $x("//a[@class=\"media-text_a\"]").attr("href"));
    }

}
