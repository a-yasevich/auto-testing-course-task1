package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GroupPage {
    private static final By GROUP_BUTTON = By.xpath("//*[@id=\"hook_Block_AltGroupMainMenu\"]//*[@data-l = \"outlandertarget,join,t,join\"]");
    private static final By LEAVE_GROUP = By.xpath("//*[@id=\"hook_Block_AltGroupMainMenu\"]//*[@class = \"dropdown_cnt __wide __show\"]");

    public static void leaveFromGroup() {
        $(GROUP_BUTTON).shouldBe(Condition.visible).click();
        $(LEAVE_GROUP).shouldBe(Condition.visible).click();
        back();
    }
}
