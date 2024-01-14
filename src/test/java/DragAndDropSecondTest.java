import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropSecondTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void dragAndDropTest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").$(byTagAndText("header", "A")).shouldBe(visible);
        $("#column-b").$(byTagAndText("header", "B")).shouldBe(visible);
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-a").$(byTagAndText("header", "B")).shouldBe(visible);
        $("#column-b").$(byTagAndText("header", "A")).shouldBe(visible);
    }
}
