package de.vinogradoff.selenide_5_15_0;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class ClickOptionsTests {

    @Test
    void clickOptions() {
        open("https://jsfiddle.net/sungq8m5");
        switchTo().frame("result");
        ///Configuration.clickViaJs=true;
        //$(".b1").click(usingJavaScript().offsetY(500));
        $("#txt").shouldHave(exactText("button1"));
    }
}
