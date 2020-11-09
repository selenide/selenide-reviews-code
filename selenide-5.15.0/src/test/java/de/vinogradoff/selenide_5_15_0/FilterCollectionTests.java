package de.vinogradoff.selenide_5_15_0;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith(TextReportExtension.class)
public class FilterCollectionTests {

    @Test
    void testFilters() {
        open("https://jsfiddle.net/qLgz9woy/2/");
        switchTo().frame("result");
        ElementsCollection texts = $$("div").filter(visible);
        for (int i = 0; i < 30; i++) {
            texts.get(i).shouldBe(text("Some"));
        }
    }

    @Test
    void testUnfiltered() {
        open("https://jsfiddle.net/qLgz9woy/2/");
        switchTo().frame("result");
        ElementsCollection texts = $$("div");//.filter(Condition.visible);
        for (int i = 0; i < 10; i++) {
            texts.get(i).shouldBe(text("Some"));
        }
    }

    @Test
    void testFiltersWithSnapshot() {
        open("https://jsfiddle.net/qLgz9woy/2/");
        switchTo().frame("result");
        ElementsCollection texts = $$("div").filter(visible).snapshot();
        for (int i = 0; i < 50; i++) {
            texts.get(i).shouldBe(text("Some"));
        }
    }
}
