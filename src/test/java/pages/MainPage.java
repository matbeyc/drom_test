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


    private List<WebElement> getAllCarCardsFromThePage() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(ConstantMainPageSelectors.CAR_CARD_SELECTOR));
    }

    public void addToFavoriteRandomCar(){
        Actions actions = new Actions(driver);
        WebElement car = getRandomNonFavoriteCar();
        // Не нашел, к сожалению, других вариантов, как обойтись без костыля. Так-как всегда
        // кликает слишком рано и по итогу не добавляет в избранное, а переходит на карточку автомобиля.
        // Явные ожидания тоже не помогли. Еще как вариант переходить на карточку после клика на
        // иконку "добавить в избранное" и добавлять в избранное уже на самой странице автомобиля
        // но это тоже, я считаю, неправильно, так-как клик по кнопке "добавить в избранное" не подразумевает
        // переход на карточку автомобиля.

        // Единственное возможное рабочее решение, это найти все элементы кнопок "добавить в избранное", которые
        // не добавлены в избранное, от них через xpath получить корневой элемент карточки, далее кликнуть на карточку
        // и добавить в избранное со страницы карточки.
        actions.moveToElement(car).pause(Duration.ofSeconds(2)).click().build().perform();
    }

    private WebElement getRandomNonFavoriteCar() {
        List<WebElement> allNonFavoriteCars = getAllNonFavoriteCars();
        Random random = new Random();
        return allNonFavoriteCars.get(random.nextInt(allNonFavoriteCars.size()));
    }

    private List<WebElement> getAllNonFavoriteCars() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(ConstantMainPageSelectors.ADD_TO_FAVORITE_BUTTON_SELECTOR));

    }


    public void changePaginationPage(String numberPage) {
        String pageXpath = XpathGenerator.createXpath(DynamicMainPageSelectors.PAGINATION_PAGE_SELECTOR_RAW, numberPage);
        WebElement paginationPage = driver.findElement(By.xpath(pageXpath));
        paginationPage.click();
    }
}
