package tests.baseTests;

import helpers.ConfigureBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BaseMobileTest {
    WebDriver mobileDriver;

    @BeforeEach
    public void setUp() {
        mobileDriver = ConfigureBrowser.getMobileDriver();
        BasePage.setDriver(mobileDriver);

    }

    @AfterEach
    public void tearDown() {
        mobileDriver.quit();
    }
}
