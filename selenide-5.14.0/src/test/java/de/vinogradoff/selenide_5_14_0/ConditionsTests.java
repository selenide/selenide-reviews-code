package de.vinogradoff.selenide_5_14_0;

import com.codeborne.selenide.*;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith(SoftAssertsExtension.class)
public class ConditionsTests {

  @Test
  void collectionCondition() {
    Configuration.assertionMode = AssertionMode.SOFT;
    open("http://amazon.com");
    $$("#nav-xshop a").shouldHave(itemWithText("Gift Cards"));
    $$("#nav-xshop a").shouldHave(itemWithText("Gift cards"));
    $$("#nav-xshop a").shouldHave(itemWithText("Gift"));

  }
}

