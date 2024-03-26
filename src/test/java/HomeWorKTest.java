import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorKTest {
    @BeforeAll
    static void beforeALL(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void githubTest(){
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $x("//span[contains(text(),'Let’s build from')]").shouldHave(text("Let’s build from here"));
    }

    @Test
    void rectanle1Test(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $x("//header[text()='A']").dragAndDrop(DragAndDropOptions.to($x("//header[text()='B']")));
        $("header",0).shouldHave(text("B"));
    }
    @Test
    void rectangle2Test(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($x("//header[text()='A']")).clickAndHold().moveToElement($x("//header[text()='B']")).release().perform();
        $("header",0).shouldHave(text("B"));
    }

}
