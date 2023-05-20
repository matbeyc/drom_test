package pages;

import config.ReadEnvConfig;
import pages.elements.CarCard;
import pages.elements.FilterElement;
import pages.elements.Header;
import helpers.Waits;
import helpers.XpathGenerator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.selectors.CarCardSelectors.DynamicCarCardSelectors;
import pages.selectors.MainPageSelectors.ConstantMainPageSelectors;
import pages.selectors.MainPageSelectors.DynamicMainPageSelectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPage extends BasePage {
    private final static String baseUrl = ReadEnvConfig.getBaseUrl();


    private final Header headerElement = new Header();
    private final FilterElement filter = new FilterElement();

    public Header getHeaderElement() {
        return headerElement;
    }

    public FilterElement getFilterElement() {
        return filter;
    }


    public void open() {
        driver.get(baseUrl);
    }


    public void openWithFilter(String additionalParams) {
        driver.get(baseUrl + additionalParams);
    }


    public void allCarsShouldNotBeSold() {
        List<WebElement> allCarCards = getAllCarCardsFromThePage();
        for (WebElement carCard : allCarCards) {
            Boolean isCarSold = new CarCard(carCard).isCarSold();
            Assertions.assertFalse(isCarSold);
        }
    }

    public void allCarsShouldBeMoreOrEqualThan(Integer minYear) {
        List<WebElement> allCarCards = getAllCarCardsFromThePage();
        for (WebElement carCard : allCarCards) {
            Integer carYear = new CarCard(carCard).getCarYear();
            Assertions.assertTrue(carYear >= minYear);
        }
    }

    public void allCarsShouldHaveMileage() {
        List<WebElement> allCarCards = getAllCarCardsFromThePage();
        for (WebElement carCard : allCarCards) {
            String mileage = new CarCard(carCard).getMileage();
            Assertions.assertNotNull(mileage);
        }
    }

    public void goToRandomNonFavoriteCarPage() {
        List<CarCard> carCards = getAllNonFavoriteCarCardsFromThePage();
        getRandomCarCard(carCards).goToCarPage();
    }

    private CarCard getRandomCarCard(List<CarCard> carCards) {
        Random random = new Random();
        return carCards.get(random.nextInt(carCards.size()));
    }

    private List<CarCard> getAllNonFavoriteCarCardsFromThePage() {
        List<CarCard> carCards = new ArrayList<>();
        List<WebElement> nonFavoriteCars = getAllCarCardFromThePageByInnerXpath(DynamicCarCardSelectors.ADD_TO_FAVORITE_BUTTON_INNER);
        for (WebElement car : nonFavoriteCars) {
            carCards.add(new CarCard(car));
        }
        return carCards;
    }

    private List<WebElement> getAllCarCardsFromThePage() {
        return new Waits(driver).presenceOfAllElementsLocatedBy(ConstantMainPageSelectors.CAR_CARD_SELECTOR);
    }

    private List<WebElement> getAllCarCardFromThePageByInnerXpath(String innerXpath) {
        String baseElementCarCardXpath = XpathGenerator.createXpathForCarCardBaseElement(innerXpath);
        return new Waits(driver).presenceOfAllElementsLocatedBy(By.xpath(baseElementCarCardXpath));
    }

    public void changePaginationPage(String numberPage) {
        String pageXpath = XpathGenerator.createXpathForPagination(DynamicMainPageSelectors.PAGINATION_PAGE_SELECTOR_RAW, numberPage);
        WebElement paginationPage = driver.findElement(By.xpath(pageXpath));
        paginationPage.click();
    }
}
