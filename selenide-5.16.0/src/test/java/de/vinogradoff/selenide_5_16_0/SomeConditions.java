package de.vinogradoff.selenide_5_16_0;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class SomeConditions {

  @BeforeAll
  static void init(){
    SelenideLogger.addListener("allure", new AllureSelenide());
    Configuration.timeout=1000;
  }

  @Test
  void newCollectionConditions(){
    open("https://jsfiddle.net/vngr/yros3fbu/16/");
    switchTo().frame("result");

    //$$("div").shouldHave(CollectionCondition.exactTextsCaseSensitiveInAnyOrder("One","two","Three"));

  }

  @Test
  void hrefBug(){
    open("https://jsfiddle.net/vngr/yros3fbu/21/");
    switchTo().frame("result");

    $("a").shouldHave(Condition.href("text"));

  }
}
