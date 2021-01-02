package de.vinogradoff.selenide_5_16_0;

import com.codeborne.selenide.*;
import com.codeborne.selenide.files.FileFilters;
import org.junit.jupiter.api.*;

import java.io.*;

import static com.codeborne.selenide.FileDownloadMode.*;
import static com.codeborne.selenide.Selenide.*;

public class DownloadTests {

  @Test
  void downloadMultipleFiles() throws FileNotFoundException {
    open("https://jsfiddle.net/vngr/kt9qhx26/");
    switchTo().frame("result");
    File text = $("#two-downloads").download(
            DownloadOptions.using(FOLDER).withFilter(FileFilters.withName("test.txt")));
    Assertions.assertEquals("test.txt", text.getName());
    Assertions.assertEquals(12, text.length());

  }

  @Test
  void downloadJS() throws FileNotFoundException {
    open("https://jsfiddle.net/vngr/s7uqygfx/1/");
    switchTo().frame("result");
    File text = $("#js-download").download(DownloadOptions.using(FOLDER));
    Assertions.assertEquals("12_12_2020.txt", text.getName());
    Assertions.assertEquals(11, text.length());

  }
}
