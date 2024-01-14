import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void selectEnterpriseTest() {

        open("https://github.com/");
        $$(".HeaderMenu-link").filterBy(text("Solutions")).first().hover();
        $$(".HeaderMenu-dropdown-link").filterBy(text("Enterprise")).first().click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform.")).shouldHave(visible);
    }
}