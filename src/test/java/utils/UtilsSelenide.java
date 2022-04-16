package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class UtilsSelenide {
    public static Duration TIMEOUT = Duration.ofSeconds(10);

    public static SelenideElement shouldExist(By selector) {
        return $(selector).should(Condition.exist, TIMEOUT);
    }
}
