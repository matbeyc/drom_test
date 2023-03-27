package elements;

import org.openqa.selenium.WebElement;
import selectors.CarCardSelectors.ConstantCarCardSelectors;

import java.util.Objects;


public class CarCard {
    WebElement baseElement;


    public CarCard(WebElement carCardElement) {
        this.baseElement = carCardElement;
    }


    public Boolean isCarSold() {
        String[] cssValues;
        WebElement carCardTitle = baseElement.findElement(ConstantCarCardSelectors.TITLE_GENERAL_SELECTOR);
        String cssValue = carCardTitle.getCssValue("text-decoration");
        cssValues = cssValue.split(" ");
        if (Objects.equals(cssValues[0], "line-through")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


}
