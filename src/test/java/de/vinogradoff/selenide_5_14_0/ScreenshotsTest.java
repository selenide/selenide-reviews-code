package de.vinogradoff.selenide_5_14_0;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;

import java.util.Base64;

import static com.codeborne.selenide.Selenide.*;

public class ScreenshotsTest {

  @Test
  void switchBug() {
    open("https://jsfiddle.net/qL2csxn3/15");
    switchTo().frame("result123");
  }

  @Test
  void screenshots() {
    open("http://google.com");
    String base64 = screenshot(OutputType.BASE64);
    byte[] bytes = screenshot(OutputType.BYTES);

    String base64_converted = Base64.getEncoder().encodeToString(bytes);

    Assertions.assertEquals(base64.length(), base64_converted.length());
  }

  @Test
  void multiBrowser_screenshots() {
    SelenideDriver chrome = new SelenideDriver(new SelenideConfig().browser("firefox"));
    SelenideDriver firefox = new SelenideDriver(new SelenideConfig().browser("chrome"));
    chrome.open("http://google.com/ncr");
    firefox.open("http://google.com/ncr");
    chrome.screenshot("screen.png");
    byte[] bytes = firefox.screenshot(OutputType.BYTES);
  }
}
