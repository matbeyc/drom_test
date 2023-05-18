package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import selectors.CarCardSelectors.ConstantCarCardElementSelectors;

import javax.swing.text.StyledEditorKit;
import java.util.List;
import java.util.Objects;


public class CarCard extends BasePage {
    WebElement baseElement;


    public CarCard(WebElement carCardElement) {
        this.baseElement = carCardElement;
    }


    public void addCarToFavorite() {
        baseElement.findElement(ConstantCarCardElementSelectors.ADD_TO_FAVORITE_BUTTON_SELECTOR).click();
    }

    public Boolean isCarInFavorite() {
        List<WebElement> mileageElements = baseElement.findElements(ConstantCarCardElementSelectors.ADD_TO_FAVORITE_BUTTON_SELECTOR);
        if (!mileageElements.isEmpty()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean isCarSold() {
        String[] cssValues;
        WebElement carCardTitleElement = baseElement.findElement(ConstantCarCardElementSelectors.TITLE_GENERAL_SELECTOR);
        String cssValue = carCardTitleElement.getCssValue("text-decoration");
        cssValues = cssValue.split(" ");
        if (Objects.equals(cssValues[0], "line-through")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public String getMileage() {
        List<WebElement> mileageElements = baseElement.findElements(ConstantCarCardElementSelectors.MILEAGE_SELECTOR);
        if (!mileageElements.isEmpty()) {
            return mileageElements.get(0).getText();
        }
        return null;
    }

    public Integer getCarYear() {
        String titleText = baseElement.findElement(ConstantCarCardElementSelectors.TITLE_TEXT_SELECTOR).getText();
        String[] titleList = titleText.split(", ");
        return Integer.parseInt(titleList[1]);
    }


}
