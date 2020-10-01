package de.vinogradoff.selenide_5_14_0;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;


public class SafariTests {

  @Test
  void safari() {
    Configuration.browser = "safari";
    Selenide.open("http://google.com");

  }
}
