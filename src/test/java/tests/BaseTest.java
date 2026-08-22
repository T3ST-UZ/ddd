package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

public class BaseTest {

    protected MainPage mainPage = new MainPage();

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    static void setupConfig() {
        Configuration.browser = System.getProperty("browser", "chrome").toLowerCase();
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://sudar.su");
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.pageLoadStrategy = "eager";

        String browserVersion = System.getProperty("browserVersion");
        if (browserVersion != null && !browserVersion.isBlank()) {
            Configuration.browserVersion = browserVersion;
        }

        String remoteUrl = System.getProperty("remoteUrl");
        if (remoteUrl == null || remoteUrl.isBlank()) {
            String login = System.getProperty("remoteBrowserUrlLogin");
            String password = System.getProperty("remoteBrowserUrlPassword");
            if (login != null && password != null && !login.isBlank() && !password.isBlank()) {
                remoteUrl = "https://" + login + ":" + password + "@" +
                        System.getProperty("remoteBrowserUrl", "selenoid.autotests.cloud/wd/hub");
            }
        }

        boolean remote = remoteUrl != null && !remoteUrl.isBlank();
        Configuration.headless = !remote && Boolean.parseBoolean(System.getProperty("headless", "false"));

        if (remote) {
            Configuration.remote = remoteUrl;
            Configuration.browserCapabilities = selenoidCapabilities();
        }
    }

    private static MutableCapabilities selenoidCapabilities() {
        Map<String, Object> selenoidOptions = Map.of(
                "enableVNC", true,
                "enableVideo", true
        );
        if ("chrome".equalsIgnoreCase(Configuration.browser)) {
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
            options.setCapability("selenoid:options", selenoidOptions);
            return options;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pageLoadStrategy", "eager");
        capabilities.setCapability("selenoid:options", selenoidOptions);
        return capabilities;
    }

    @AfterEach
    void addAttachments() {
        if (!hasWebDriverStarted()) {
            return;
        }
        try {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            if (Configuration.remote != null) {
                Attach.addVideo();
            }
        } catch (Exception ignored) {
        } finally {
            closeWebDriver();
        }
    }
}
