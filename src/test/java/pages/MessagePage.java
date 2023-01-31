package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static utils.UtilsSelenide.TIMEOUT;
import static utils.UtilsSelenide.shouldExist;

public class MessagePage extends ContentPage {
    private static final By LIST_DIALOGS = By.xpath("//div[@class=\"messenger_side\"]");
    private static final By MSG_INPUT = By.xpath("//msg-input[@data-tsid=\"write_msg_input\"]");
    private static final By MSG_BUTTON = By.xpath("//msg-button[@data-l=\"t,sendButton\"]");
    private static final By SPUTNIK_DIALOG = By.xpath("//a[@href=\"/messages/c82629024153782\"]");
    private static final By LAST_MSG_MESSAGE = By.xpath("//msg-message-list//*[last()-1]//msg-message[@mine][last()]//msg-parsed-text");


    @Override
    public MessagePage check() {
        shouldExist(LIST_DIALOGS);
        $(SPUTNIK_DIALOG).should(Condition.exist);
        return this;
    }

    private static By selectorDialogUser(String username) {
        return By.xpath(String.format("//*[text()='%s']", username.trim()));
    }

    public void sendMessage(String username, String message) {
        shouldExist(selectorDialogUser(username)).shouldBe(Condition.visible, TIMEOUT).click();
        shouldExist(MSG_INPUT).shouldBe(Condition.visible).click();
        $(MSG_INPUT).sendKeys(message);
        shouldExist(MSG_BUTTON).shouldBe(Condition.visible).click();
    }

    public String getLastMessage(String username) {
        shouldExist(selectorDialogUser(username)).shouldBe(Condition.visible).click();
        return shouldExist(LAST_MSG_MESSAGE).shouldBe(Condition.visible).getText();
    }
}
