package de.vinogradoff.selenide_5_15_0;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;

import java.io.IOException;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;


public class PageTimeoutTests {

    @Test
    void pageTimeouts() throws IOException {
        //Configuration.pageLoadTimeout = 90000;
        open("chrome://about");
        ChromeDriver driver = (ChromeDriver) WebDriverRunner.getWebDriver();
        Map settings = Map.of(
                "latency", 500,
                "download_throughput", 70000,
                "upload_throughput", 70000);

        driver.getCommandExecutor().execute(
                new Command(driver.getSessionId(),
                        "setNetworkConditions",
                        Map.of("network_conditions", settings)));


        open("http://amazon.com");
    }
}
