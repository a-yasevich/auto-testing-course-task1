package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pages.MessagePage;

import static com.codeborne.selenide.Selenide.refresh;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest extends BaseTest{

    private static final String MESSAGE = "Привет";

    @Test
    void sendMessage() {
        MessagePage messagePage = mainPage.openMessagePage();
        messagePage.check();
        messagePage.sendMessageToSpuntnik(MESSAGE);
        refresh();
        assertEquals(messagePage.getLastMessageUserToSpuntik(), MESSAGE, "Cообщения не совпадают");
    }
}
