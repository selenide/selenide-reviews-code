package de.vinogradoff.selenide_5_15_0;

import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertsExtension.class)
public class OwnTextTests {
/*
    @Test
    void ownTextTest(){
        Configuration.assertionMode= AssertionMode.SOFT;
        open("https://jsfiddle.net/aewu68xj/");
        switchTo().frame("result");
        Configuration.timeout=1000;
        $("#div1").shouldHave(exactTextCaseSensitive("Price 50$"));
        $("#div2").shouldHave(exactTextCaseSensitive("Price 50$"));
        $("#div3").shouldHave(exactTextCaseSensitive("Price 50$"));
        $("#div1").shouldHave(exactOwnText("Price"));
        $("#div2").shouldHave(exactOwnText("Price $"));
        $("#div3").shouldHave(exactOwnText("$"));
        $("#div1").shouldHave(ownText("Price 50$"));
        $("#div2").shouldHave(ownText("x"));
        $("#div3").shouldHave(ownText("Price"));



    }*/
}
