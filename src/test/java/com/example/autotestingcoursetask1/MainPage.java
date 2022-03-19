package com.example.autotestingcoursetask1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement photo = $x("//*[@name = \"photo\"]");
    private final SelenideElement userNavBlock = $x("//*[@id=\"hook_Block_SideNavigation\"]");
    private final SelenideElement userNameField = $x("//*[@class=\"nav-side __navigation __user-main\"]//*[@class=\"tico ellip\"]");
    private final SelenideElement feedList = $x("//*[@id=\"hook_Block_MainFeedsContent\"]");
    //private final SelenideElement firstPost = $x("//*[@id=\"hook_Loader_6294288737\"]/*[@class =\"feed-list\"]/*[@class = \"feed-w\"]");

    public boolean assertUserName(String userName) {
        System.out.println(userNameField.text());
        return userNameField.text().equals(userName);
    }

    public boolean containsUniqueElements() {
        return userNameField.exists() && userNavBlock.exists() && photo.exists() && feedList.exists();
    }

    public Repost doRepost() {
        return null;
    }

    public void openUserPage() {
        userNameField.click();
    }
}
