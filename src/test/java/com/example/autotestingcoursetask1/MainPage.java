package com.example.autotestingcoursetask1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends AbstractPage {
    private final SelenideElement photo = $x("//*[@name = \"photo\"]");
    private final SelenideElement userNameField = $x("//*[@class=\"nav-side __navigation __user-main\"]//*[@class=\"tico ellip\"]");
    private final SelenideElement page = $x("//a[@data-l=\"t,userPage\"]");
    private final FeedList feedList = new FeedList();

    public String getUserName() {
        return userNameField.text();
    }

    public boolean hasPhoto() {
        return photo.exists();
    }

    public boolean hasUserNameField() {
        return userNameField.exists();
    }

    public boolean hasFeedList() {
        return feedList.hasFeedList();
    }

    public Repost doRepost() {
        return feedList.doRepost();
    }

    public ProfilePage openProfilePage() {
        $x("//*[@id=\"hook_Block_Navigation\"]/div/div/a[1]").click();
        //new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.elementToBeClickable($x("//*[@id=\"hook_Block_Navigation\"]/div/div/a[1]").shouldBe(Condition.visible))).click();
        return new ProfilePage();
    }
}
