package pages;

import config.Urls;
import elements.CarCard;
import helpers.XpathGenerator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import selectors.MainPageSelectors.ConstantMainPageSelectors;
import selectors.MainPageSelectors.DynamicMainPageSelectors;

import java.util.List;

public class MainPage extends BasePage {


    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(Urls.AUTO_MAIN_PAGE);
    }

    public void openWithFilter(String additionalParams) {
        driver.get("https://auto.drom.ru/toyota/camry/?maxprobeg=1");
    }


    public void allCarsShouldNotBeSold() {
        List<WebElement> carCardElements = driver.findElements(ConstantMainPageSelectors.CAR_CARD_SELECTOR);
        for (WebElement carCard : carCardElements) {
            Boolean isCarSold = new CarCard(carCard).isCarSold();
            Assertions.assertFalse(isCarSold);
        }
    }


    public void changePaginationPage(String numberPage) {
        String pageXpath = XpathGenerator.createXpath(DynamicMainPageSelectors.PAGINATION_PAGE_SELECTOR_RAW, numberPage);
        WebElement paginationPage = driver.findElement(By.xpath(pageXpath));
        paginationPage.click();
    }
}
