package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MessagePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest extends BaseTest{

    @ParameterizedTest
    @CsvSource(value = {"Спутник, Хааай Восссааап мен?"})
    void sendMessage(String username, String message) {
        MessagePage messagePage = mainPage.openMessagePage().check();
        messagePage.sendMessage(username, message);

        assertEquals(messagePage.getLastMessage(username), message, "Cообщения не совпадают");
    }
}
