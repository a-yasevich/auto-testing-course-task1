package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest{

    @Test
    public void logIn() {
        assertAll("Main page has its distinctive traits",
                () -> assertTrue(mainPage.hasUserNameField(), "There is no name field"),
                () -> assertTrue(mainPage.hasPhoto(), "There is no photo block"),
                () -> assertTrue(mainPage.hasFeedList(), "There is no feed list")
        );
        assertEquals(user.getName(), mainPage.getUserName(), "Wrong user");
    }

}
