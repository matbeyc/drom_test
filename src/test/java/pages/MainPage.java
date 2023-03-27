package pages;

import config.Urls;
import elements.CarCard;
import elements.Header;
import helpers.XpathGenerator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import selectors.MainPageSelectors.ConstantMainPageSelectors;
import selectors.MainPageSelectors.DynamicMainPageSelectors;

import java.util.List;

public class MainPage extends BasePage {
    String baseUrl = Urls.AUTO_MAIN_PAGE;

    public MainPage() {

        PageFactory.initElements(driver, this);

    }

    public void open() {
        driver.get(this.baseUrl);
    }

    public void openWithFilter(String additionalParams) {
        driver.get(this.baseUrl + additionalParams);
    }

    public Header getHeaderElement() {
        WebElement headerElement = driver.findElement(ConstantMainPageSelectors.HEADER_SELECTOR);
        return new Header(headerElement);
    }


    public void allCarsShouldNotBeSold() {
        List<WebElement> carCardElements = driver.findElements(ConstantMainPageSelectors.CAR_CARD_SELECTOR);
        for (WebElement carCard : carCardElements) {
            Boolean isCarSold = new CarCard(carCard).isCarSold();
            Assertions.assertFalse(isCarSold);
        }
    }

    public void allCarsShouldBeMoreOrEqualThan(Integer minYear) {
        List<WebElement> carCardElements = driver.findElements(ConstantMainPageSelectors.CAR_CARD_SELECTOR);
        for (WebElement carCard : carCardElements) {
            Integer carYear = new CarCard(carCard).getCarYear();
            Assertions.assertTrue(carYear >= minYear);
        }
    }

    public void allCarsShouldHaveMileage() {
        List<WebElement> carCardElements = driver.findElements(ConstantMainPageSelectors.CAR_CARD_SELECTOR);
        for (WebElement carCard : carCardElements) {
            String mileage = new CarCard(carCard).getMileage();
            Assertions.assertNotNull(mileage);
        }
    }


    public void changePaginationPage(String numberPage) {
        String pageXpath = XpathGenerator.createXpath(DynamicMainPageSelectors.PAGINATION_PAGE_SELECTOR_RAW, numberPage);
        WebElement paginationPage = driver.findElement(By.xpath(pageXpath));
        paginationPage.click();
    }
}
