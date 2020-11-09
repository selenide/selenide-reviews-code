package de.vinogradoff.selenide_5_15_0;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class HrefTests {

    @Test
    void hrefTest() {
        Selenide.open("https://the-internet.herokuapp.com/");
        //$("li a").shouldHave(attribute("href","https://the-internet.herokuapp.com/abtest"));
        //$("li a").shouldHave(href("/abtest"));
    }
}
