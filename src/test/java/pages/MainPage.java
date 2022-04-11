package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.elements.FeedList;
import utils.FeedItem;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends AbstractPage {
    private final static By PHOTO = By.xpath("//*[@name = \"photo\"]");
    private final static By USER_NAME_FIELD = By.xpath("//*[@class=\"nav-side __navigation __user-main\"]//*[@class=\"tico ellip\"]");
    private final static By PAGE = By.xpath("//*[@class=\"nav-side __navigation __user-main\"]//*[@class=\"tico ellip\"]");
    private final static By GROUPS_PAGE = By.xpath("//*[@id=\"hook_Block_Navigation\"]//*[@data-l = \"t,userAltGroup\"]");

    private final FeedList feedList = new FeedList();

    public String getUserName() {
        return $(USER_NAME_FIELD).shouldBe(visible).text();
    }

    @Override
    public void check() {
        super.check();
        feedList.hasFeedList();
        $(PHOTO).should(Condition.exist);
        $(USER_NAME_FIELD).should(Condition.exist).shouldBe(Condition.visible);
    }

    public FeedItem doRepost() {
        feedList.hasFeedList();
        return feedList.doRepost();
    }

    public ProfilePage openProfilePage() {
        $(PAGE).scrollIntoView(false).click();
        return new ProfilePage();
    }

    public AbstractGroupsPage openGroupsPage() {
        try {
            System.out.println("Openening groups");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(GROUPS_PAGE).scrollIntoView(false)
                .shouldBe(visible)
                .click();
        try {
            System.out.println("Groups opened");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new GroupsPageFactory().get();
    }
}
