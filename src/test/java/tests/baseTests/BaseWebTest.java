package tests.baseTests;

import helpers.ConfigureBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BaseWebTest {
    WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        webDriver = ConfigureBrowser.getWebDriver();
        BasePage.setDriver(webDriver);

    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
