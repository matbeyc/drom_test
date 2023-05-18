package pages;

import config.ReadConfig;
import elements.CarCard;
import elements.Header;
import helpers.XpathGenerator;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selectors.CarCardSelectors;
import selectors.MainPageSelectors;
import selectors.MainPageSelectors.ConstantMainPageSelectors;
import selectors.MainPageSelectors.DynamicMainPageSelectors;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPage extends BasePage {
    private final static String baseUrl = ReadConfig.getBaseUrl();


    private final Header headerElement = new Header();

    public Header getHeaderElement() {
        return headerElement;
    }


    public void open() {
        driver.get(baseUrl);
    }


    public void openWithFilter(String additionalParams) {
        driver.get(baseUrl + additionalParams);
    }


    public void allCarsShouldNotBeSold() {
        for (WebElement carCard : getAllCarCardsFromThePage()) {
            Boolean isCarSold = new CarCard(carCard).isCarSold();
            Assertions.assertFalse(isCarSold);
        }
    }

    public void allCarsShouldBeMoreOrEqualThan(Integer minYear) {
        for (WebElement carCard : getAllCarCardsFromThePage()) {
            Integer carYear = new CarCard(carCard).getCarYear();
            Assertions.assertTrue(carYear >= minYear);
        }
    }

    public void allCarsShouldHaveMileage() {
        for (WebElement carCard : getAllCarCardsFromThePage()) {
            String mileage = new CarCard(carCard).getMileage();
            Assertions.assertNotNull(mileage);
        }
    }

    public void addToFavoriteRandomCar() {
        Random random = new Random();
        List<CarCard> nonFavoriteCars = getNonFavoriteCarsFromThePage();
        int randomCardNumber = random.nextInt(nonFavoriteCars.size());
        nonFavoriteCars.get(randomCardNumber).addCarToFavorite();
    }

    private List<CarCard> getNonFavoriteCarsFromThePage() {
        List<CarCard> nonFavoriteCars = new ArrayList<>();
        List<WebElement> allCardsFromThePage = getAllCarCardsFromThePage();
        for (WebElement carCardElement : allCardsFromThePage) {
            CarCard carCard = new CarCard(carCardElement);
            if (!carCard.isCarInFavorite()) {
                nonFavoriteCars.add(carCard);
            }
        }
        System.out.println("getNonFavoriteCarsFromThePage");
        System.out.println(nonFavoriteCars.size());
        return nonFavoriteCars;
    }


    private List<WebElement> getAllCarCardsFromThePage() {
        List<WebElement> carCardElements = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(ConstantMainPageSelectors.CAR_CARD_SELECTOR));
        System.out.println("getAllCarCardsFromThePage");
        System.out.println(carCardElements.size());
        return carCardElements;
    }


    public void changePaginationPage(String numberPage) {
        String pageXpath = XpathGenerator.createXpath(DynamicMainPageSelectors.PAGINATION_PAGE_SELECTOR_RAW, numberPage);
        WebElement paginationPage = driver.findElement(By.xpath(pageXpath));
        paginationPage.click();
    }
}
