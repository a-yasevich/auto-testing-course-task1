package com.example.autotestingcoursetask1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public abstract class AbstractPage {
    private final SelenideElement userNavBlock = $x("//*[@id=\"hook_Block_SideNavigation\"]");

    public boolean hasUserNavBlock() {
        return userNavBlock.exists();
    }
}
