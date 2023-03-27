package elements;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CarCardElementHelper {

    public static class CarCardData {
        public static final Integer VOLUME = 0;
        public static final Integer FUEL = 1;
        public static final Integer TRANSMISSION = 2;
        public static final Integer WD = 3;
        public static final Integer Mileage = 4;

    }

    private final WebElement baseElement;

    public CarCardElementHelper(WebElement baseElement) {
        this.baseElement = baseElement;
    }


    public WebElement getCardTitleElement() {

        return this.baseElement.findElement(By.xpath(".//span[@data-ftid=\"bull_title\"]"));
    }

    public WebElement getCardDescriptionVolumeElement(Integer descriptionVariant) {
            List<WebElement> listOfElements = this.baseElement.findElements(By.xpath(".//span[@data-ftid=\"bull_description-item\"]"));
            return listOfElements.get(descriptionVariant);
    }


}


