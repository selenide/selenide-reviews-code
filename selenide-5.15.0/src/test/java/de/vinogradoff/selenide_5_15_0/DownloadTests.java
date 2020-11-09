package de.vinogradoff.selenide_5_15_0;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.files.FileFilters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.DownloadOptions.using;
import static com.codeborne.selenide.FileDownloadMode.*;
import static com.codeborne.selenide.Selenide.*;

public class DownloadTests {

    @Test
    void downloadExternalLink() throws FileNotFoundException {
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = HTTPGET;
        open("https://jsfiddle.net/qL2csxn3/15");
        switchTo().frame("result");
        File text = $("#external-download").download(using(PROXY));

        Assertions.assertEquals("some-file.txt", text.getName());
        Assertions.assertEquals(0, text.length());

    }

    @Test
    void downloadJS() throws FileNotFoundException {
        open("https://jsfiddle.net/qL2csxn3/15");
        switchTo().frame("result");
        File text = $("#js-download").download(using(FOLDER));
        Assertions.assertEquals("hello.txt", text.getName());
        Assertions.assertEquals(11, text.length());

    }

    @Test
    void downloadMultipleFiles() throws FileNotFoundException {
        Configuration.proxyEnabled = true;
        open("https://jsfiddle.net/vngr/b2s74tjp/10/");
        switchTo().frame("result");
        File text = $("#two-downloads").download(using(PROXY)
                .withTimeout(6000).withFilter(FileFilters.withName("hello_world.txt")));
        Assertions.assertEquals("hello_world.txt", text.getName());
        Assertions.assertEquals(6, text.length());

    }
}
