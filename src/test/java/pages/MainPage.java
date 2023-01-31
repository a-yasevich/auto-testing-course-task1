package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.elements.FeedList;
import utils.FeedItem;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends ContentPage {
    private final static By PHOTO = By.xpath("//*[@name = \"photo\"]");
    private final static By USER_NAME_FIELD = By.xpath("//*[@class=\"nav-side __navigation __user-main\"]//*[@class=\"tico ellip\"]");
    private final static By PAGE = By.xpath("//*[@class=\"nav-side __navigation __user-main\"]//*[@class=\"tico ellip\"]");
    private final static By GROUPS_PAGE = By.xpath("//*[@id=\"hook_Block_Navigation\"]//*[@data-l = \"t,userAltGroup\"]");

    private final FeedList feedList = new FeedList();

    public String getUserName() {
        return $(USER_NAME_FIELD).shouldBe(visible).text();
    }

    @Override
    public MainPage check() {
        feedList.hasFeedList();
        $(PHOTO).should(Condition.exist);
        $(USER_NAME_FIELD).should(Condition.exist).shouldBe(Condition.visible);
        return this;
    }

    public FeedItem doRepost() {
        feedList.hasFeedList();
        return feedList.doRepost();
    }

    public ProfilePage openProfilePage() {
        $(PAGE).scrollIntoView(false).click();
        return new ProfilePage();
    }

    public GroupsPage openGroupsPage() {
        $(GROUPS_PAGE).scrollIntoView(false)
                .shouldBe(visible)
                .click();
        return new GroupsPage();
    }

    public MessagePage openMessagePage() {
        return navigationBlock.openMessagePage();
    }
}
