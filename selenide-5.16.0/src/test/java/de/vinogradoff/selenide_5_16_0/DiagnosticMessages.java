package de.vinogradoff.selenide_5_16_0;

import com.codeborne.selenide.*;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith(TextReportExtension.class)
public class DiagnosticMessages {

  @BeforeAll
  static void init(){
    SelenideLogger.addListener("allure", new AllureSelenide());
    Configuration.timeout=1000;
  }

  @Test
  void and_not(){
    open("https://jsfiddle.net/vngr/yros3fbu/3/");
    switchTo().frame("result");

    $("#example").shouldHave(text("Hello"), cssClass("big"));
    $("#example").shouldHave(text("Hello"))
            .shouldHave(cssClass("big"));

    $("#example").shouldHave(and("and-condition",text("Hello"), cssClass("big")));
    $("#example").shouldHave(not(text("Hello")));
    $("#example").shouldNotHave(text("abrakadabra"));
    $("#example").shouldHave(or("or-condition", text("abrakadabra"), cssClass("big")));
  }

  @Test
  void nested_locators(){
    open("https://jsfiddle.net/vngr/yros3fbu/7/");
    switchTo().frame("result");
    $(byId("container")).$(byText("abc")).$("div").shouldBe(visible);
  }

  @Test
  void ownTextCondition(){
    open("https://jsfiddle.net/vngr/yros3fbu/10/");
    switchTo().frame("result");
    $("#text").shouldHave(ownText("text"));
  }

  @Test
  void uploadFiles(){
    open("https://jsfiddle.net/vngr/yros3fbu/15/");
    switchTo().frame("result");
    $("input").uploadFile(new File("not-existing.html"));
  }

  @Test
  void clickOptions() {
    open("https://jsfiddle.net/vngr/yros3fbu/7/");
    switchTo().frame("result");
    $("div").click(ClickOptions.usingJavaScript().offset(5,20));

  }

}
