package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    public void logIn() {
        mainPage.check();
        assertEquals(user.getName(), mainPage.getUserName(), "Wrong user");
    }

}
