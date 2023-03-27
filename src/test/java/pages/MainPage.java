package pages;

import config.Urls;
import elements.CarCardElementHelper;
import helpers.XpathGenerator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import resources.Selectors.ConstantMainPageSelectors;
import resources.Selectors.DynamicMainPageSelectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class MainPage extends BasePage {


    @FindBys(@FindBy(xpath = ConstantMainPageSelectors.CAR_CARD_SELECTOR))
    private List<WebElement> carCardElements;


    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(Urls.AUTO_MAIN_PAGE);
    }

    public void openWithFilter(String additionalParams) {
        driver.get("https://auto.drom.ru/all/?maxprobeg=1");
    }

    public void allCarsOnThePageShouldNotBeSold() {
        for (WebElement carCard : carCardElements) {
            Assertions.assertFalse(isCarSold(new CarCardElementHelper(carCard)));
        }
    }

    public void allCarsShouldHaveMileage() {
        for (WebElement carCard : carCardElements) {
            String mileage = getCardDescription(new CarCardElementHelper(carCard)).get("mileage");
            Assertions.assertNotNull(mileage);
        }
    }

    public void allCarsShouldBeLessThanYear(String minYear) {
        for (WebElement carCard : carCardElements) {
            String carYear = getCarYear(new CarCardElementHelper(carCard));
            System.out.println(carYear);
        }
    }

    private String getCarYear(CarCardElementHelper carCardElementHelper) {
        WebElement cardTitleElement = carCardElementHelper.getCardTitleElement();
        String cardTitleValue = cardTitleElement.getText();
        String[] helperList = cardTitleValue.split(", ");
        return helperList[1];
    }

    public void findDesc() {

    }

    private HashMap<String, String> getCardDescription(CarCardElementHelper carCardElementHelper) {
        HashMap<String, String> description = new HashMap<>();
        description.put("mileage", carCardElementHelper.getCardDescriptionElement(CarCardElementHelper.CarCardData.Mileage).getText());
        description.put("volume", carCardElementHelper.getCardDescriptionElement(CarCardElementHelper.CarCardData.VOLUME).getText());
        description.put("fuel", carCardElementHelper.getCardDescriptionElement(CarCardElementHelper.CarCardData.FUEL).getText());
        return description;
    }

    private Boolean isCarSold(CarCardElementHelper carCardElementHelper) {
        String[] cssValues;
        WebElement titleElement = carCardElementHelper.getCardTitleElement();
        String cssValue = titleElement.getCssValue("text-decoration");
        cssValues = cssValue.split(" ");

        if (Objects.equals(cssValues[0], "line-through")) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }


    public void changePaginationPage(String numberPage) {
        String pageXpath = XpathGenerator.createXpath(DynamicMainPageSelectors.PAGINATION_PAGE_SELECTOR_RAW, numberPage);
        WebElement paginationPage = driver.findElement(By.xpath(pageXpath));
        paginationPage.click();
    }
}
