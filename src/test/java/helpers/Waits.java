package helpers;

import config.ReadBrowserConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;


public class Waits {
    WebDriver driver;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> presenceOfAllElementsLocatedBy(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(ReadBrowserConfig.getExpectedWait()))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

    }

    public WebElement presenceOfElementLocatedBy(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(ReadBrowserConfig.getExpectedWait()))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
