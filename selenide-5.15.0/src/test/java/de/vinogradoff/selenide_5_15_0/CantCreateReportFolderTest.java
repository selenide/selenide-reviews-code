package de.vinogradoff.selenide_5_15_0;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class CantCreateReportFolderTest {
    @Test
    void reportFolderTest() {
        Configuration.reportsFolder = "\0:)";
        open("http://google.com");
    }
}
