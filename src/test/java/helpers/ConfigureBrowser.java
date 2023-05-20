package helpers;

import config.ReadBrowserConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ConfigureBrowser {
    static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ReadBrowserConfig.getPageLoadTimeout()));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadBrowserConfig.getImplicitlyWaits()));
        return webDriver;
    }

    public static WebDriver getMobileDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ReadBrowserConfig.getPageLoadTimeout()));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadBrowserConfig.getImplicitlyWaits()));
        return webDriver;
    }
}
