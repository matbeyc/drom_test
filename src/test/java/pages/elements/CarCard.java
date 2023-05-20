package pages.elements;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.selectors.CarCardSelectors.ConstantCarCardSelectors;
import java.util.List;
import java.util.Objects;


public class CarCard extends BasePage {
    WebElement baseElement;


    public CarCard(WebElement carCardElement) {
        this.baseElement = carCardElement;
    }

    public void goToCarPage() {
        this.baseElement.click();
    }

    public Boolean isCarSold() {
        String[] cssValues;
        WebElement carCardTitleElement = baseElement.findElement(ConstantCarCardSelectors.TITLE_GENERAL_SELECTOR);
        String cssValue = carCardTitleElement.getCssValue("text-decoration");
        cssValues = cssValue.split(" ");
        if (Objects.equals(cssValues[0], "line-through")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public String getMileage() {
        List<WebElement> mileageElements = baseElement.findElements(ConstantCarCardSelectors.MILEAGE_SELECTOR);
        if (!mileageElements.isEmpty()) {
            return mileageElements.get(0).getText();
        }
        return null;
    }

    public Integer getCarYear() {
        String titleText = baseElement.findElement(ConstantCarCardSelectors.TITLE_TEXT_SELECTOR).getText();
        String[] titleList = titleText.split(", ");
        return Integer.parseInt(titleList[1]);
    }
}
