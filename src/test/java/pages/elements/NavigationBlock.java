package pages.elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.MessagePage;

import static com.codeborne.selenide.Selenide.$;

public class NavigationBlock {
    private final static By MESSAGE_BUTTON = By.xpath("//li[@data-l=\"t,messages\"]");
    private final static By DISCUSSIONS_BUTTON = By.xpath("//li[@data-l=\"t,discussions\"]");
    private final static By NOTIFICATIONS_BUTTON = By.xpath("//li[@data-l=\"t,notifications\"]");
    private final static By GUESTS_BUTTON = By.xpath("//li[@data-l=\"t,guests\"]");
    private final static By MARKS_BUTTON = By.xpath("//li[@data-l=\"t,marks\"]");
    private final static By VIDEO_BUTTON = By.xpath("//li[@data-l=\"t,video\"]");
    private final static By MUSIC_BUTTON = By.xpath("//li[@data-l=\"t,music\"]");


    public void check() {
        $(MESSAGE_BUTTON).should(Condition.exist).should(Condition.visible);
        $(DISCUSSIONS_BUTTON).should(Condition.exist).should(Condition.visible);
        $(NOTIFICATIONS_BUTTON).should(Condition.exist).should(Condition.visible);
        $(GUESTS_BUTTON).should(Condition.exist).should(Condition.visible);
        $(MARKS_BUTTON).should(Condition.exist).should(Condition.visible);
        $(VIDEO_BUTTON).should(Condition.exist).should(Condition.visible);
        $(MUSIC_BUTTON).should(Condition.exist).should(Condition.visible);
    }

    public MessagePage openMessagePage() {
        $(MESSAGE_BUTTON).should(Condition.exist).should(Condition.visible).click();
        return new MessagePage();
    }

}
