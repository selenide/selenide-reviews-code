package de.vinogradoff.selenide_5_14_0;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import java.io.*;

import static com.codeborne.selenide.Selenide.*;

public class DownloadTests {

  @Test
  void downloadLink() throws FileNotFoundException {
    open("http://the-internet.herokuapp.com/download");
    File text = $(By.linkText("some-file.txt")).download();
    Assertions.assertEquals(text.getName(), "some-file.txt");
    Assertions.assertEquals(text.length(), 307);
  }

  @Test
  void downloadExternalLink() throws FileNotFoundException {
    Configuration.proxyEnabled = true;
    Configuration.fileDownload = FileDownloadMode.PROXY;
    open("https://jsfiddle.net/qL2csxn3/15");
    switchTo().frame("result");
    File text = $("#external-download").download();

    Assertions.assertEquals(text.getName(), "some-file.txt");
    Assertions.assertEquals(text.length(), 307);

  }

  @Test
  void downloadJS() throws FileNotFoundException {
    Configuration.fileDownload = FileDownloadMode.FOLDER;
    open("https://jsfiddle.net/qL2csxn3/15");
    switchTo().frame("result");
    File text = $("#js-download").download();

    Assertions.assertEquals(text.getName(), "hello.txt");
    Assertions.assertEquals(text.length(), 11);

  }

  @Test
  void downloadLinkSelenoid() throws FileNotFoundException {
    Configuration.remote = "http://localhost:4444/wd/hub";
    MutableCapabilities caps = new MutableCapabilities();
    caps.setCapability("enableVNC", true);
    Configuration.browserCapabilities = caps;

    open("http://the-internet.herokuapp.com/download");
    File text = $(By.linkText("some-file.txt")).download();
    Assertions.assertEquals(text.getName(), "some-file.txt");
    Assertions.assertEquals(text.length(), 307);
  }

  @Test
  void downloadExternalLinkSelenoid() throws FileNotFoundException {
    Configuration.remote = "http://localhost:4444/wd/hub";
    MutableCapabilities caps = new MutableCapabilities();
    caps.setCapability("enableVNC", true);
    Configuration.browserCapabilities = caps;

    Configuration.proxyHost = "192.168.178.27"; // host (JVM) where the tests are running - not Selenoid IP

    Configuration.proxyEnabled = true;
    Configuration.fileDownload = FileDownloadMode.PROXY;
    open("https://jsfiddle.net/qL2csxn3/15");
    switchTo().frame("result");
    File text = $("#external-download").download();

    Assertions.assertEquals(text.getName(), "some-file.txt");
    Assertions.assertEquals(text.length(), 307);

  }

  @Test
  void downloadJSSelenoid() throws FileNotFoundException {
    Configuration.remote = "http://localhost:4444/wd/hub";
    MutableCapabilities caps = new MutableCapabilities();
    caps.setCapability("enableVNC", true);
    Configuration.browserCapabilities = caps;

    Configuration.fileDownload = FileDownloadMode.FOLDER;
    open("https://jsfiddle.net/qL2csxn3/15");
    switchTo().frame("result");
    File text = $("#js-download").download();

    Assertions.assertEquals(text.getName(), "hello.txt");
    Assertions.assertEquals(text.length(), 11);

  }

  @Test
  void downloadEdge() throws Exception {
    String username = "workshops1nCnsA";
    String automate_key = "o6CppH6zGxGnDzKH8shj";
    Configuration.remote = "https://" + username + ":" + automate_key + "@hub-cloud.browserstack.com/wd/hub";
    MutableCapabilities caps = new MutableCapabilities();
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "10");
    caps.setCapability("browser", "Edge");
    Configuration.browserCapabilities = caps;
    open("http://the-internet.herokuapp.com/download");
    File text = $(By.linkText("some-file.txt")).download();
    Assertions.assertEquals(text.getName(), "some-file.txt");
    Assertions.assertEquals(text.length(), 307);


  }

  @Test
  void downloadEdgeProxy() throws Exception {
    String username = "workshops1nCnsA";
    String automate_key = "o6CppH6zGxGnDzKH8shj";
    Configuration.remote = "https://" + username + ":" + automate_key + "@hub-cloud.browserstack.com/wd/hub";
    MutableCapabilities caps = new MutableCapabilities();
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "10");
    caps.setCapability("browser", "Edge");
    caps.setCapability("browserstack.local", "true");
    Configuration.browserCapabilities = caps;
    Configuration.proxyHost = "192.168.178.27"; // host (JVM) where the tests are running - not Selenoid IP
    Configuration.proxyPort = 12345;

    Configuration.proxyEnabled = true;
    Configuration.fileDownload = FileDownloadMode.PROXY;
    open("https://jsfiddle.net/qL2csxn3/15");
    switchTo().frame("result");
    File text = $("#external-download").download();

    Assertions.assertEquals(text.getName(), "some-file.txt");
    Assertions.assertEquals(text.length(), 307);


  }
}
