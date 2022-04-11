package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MessagePage {
    private static final By LIST_DIALOGS = By.xpath("//div[@class=\"messenger_side\"]");
    private static final By MSG_INPUT = By.xpath("//msg-input[@data-tsid=\"write_msg_input\"]");
    private static final By MSG_BUTTON = By.xpath("//msg-button[@data-l=\"t,sendButton\"]");
    private static final By MSG_MESSAGE = By.xpath("//msg-message[@data-tsid=\"message_root\"]");
    private static final By LIST_MESSAGES = By.xpath("//div[@class=\"group\"]");
    private static final By SPUTNIK_DIALOG = By.xpath("//a[@href=\"/messages/c82629024153782\"]");

    public void check() {
        $(LIST_DIALOGS).should(Condition.exist).shouldBe(Condition.visible);
        $(SPUTNIK_DIALOG).should(Condition.exist);
    }

    public void sendMessageToSpuntnik(String message) {
       // $(SPUTNIK_DIALOG).should(Condition.exist).scrollIntoView(false).click();
        $(SPUTNIK_DIALOG).should(Condition.exist).click();

        $(MSG_INPUT).should(Condition.exist).shouldBe(Condition.visible).click();
        $(MSG_INPUT).sendKeys(message);
        $(MSG_BUTTON).should(Condition.exist).shouldBe(Condition.visible).click();
    }

    public String getLastMessageUserToSpuntik() {
        ElementsCollection listOfGroupMessages = $$(LIST_MESSAGES);
        if (listOfGroupMessages.isEmpty()) {
            return null;
        }
        SelenideElement lastGroup = listOfGroupMessages.last();
        ElementsCollection messages = lastGroup.$$(MSG_MESSAGE);
        SelenideElement lastUserMessage = messages.last(2).first();
        return  lastUserMessage.$x("//msg-parsed-text[@data-tsid=\"message_text\"]").getText();
    }
}
