package pages;

import config.Urls;
import helpers.XpathGenerator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import resources.Selectors.ConstantMainPageSelectors;
import resources.Selectors.DynamicMainPageSelectors;

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
        driver.get(Urls.AUTO_MAIN_PAGE + additionalParams);
    }

    public void allCarsOnThePageShouldNotBeSold() {
        for (WebElement carCard : carCardElements) {
            Assertions.assertFalse(isCarSold(carCard));
        }
    }

    private Boolean isCarSold(WebElement carCardElement) {
        String[] cssValues;
        String cssValue = carCardElement.getCssValue("text-decoration");
        cssValues = cssValue.split(" ");

        if (Objects.equals(cssValues[0], "line-through")) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
    

    public void changePaginationPage(String numberPage) {
        String pageXpath = XpathGenerator.createXpath(DynamicMainPageSelectors.PAGINATION_PAGE_SELECTOR_RAW, numberPage);
        System.out.println(pageXpath);
        WebElement paginationPage = driver.findElement(By.xpath(pageXpath));
        paginationPage.click();
    }

}
