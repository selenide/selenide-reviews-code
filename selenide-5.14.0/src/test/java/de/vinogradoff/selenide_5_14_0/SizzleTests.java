package de.vinogradoff.selenide_5_14_0;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SizzleTests {

  @Test
  void sizzleUsage() {
    open("https://the-internet.herokuapp.com/inputs");
    Configuration.selectorMode = SelectorMode.Sizzle;
    System.out.println($$(":header"));
    System.out.println($$(":contains(input)"));
  }

  @Test
  void sizzleBug() {
    open("http://todomvc4tasj.herokuapp.com");
    Configuration.selectorMode = SelectorMode.Sizzle;
    System.out.println($$(":header"));
  }
}
