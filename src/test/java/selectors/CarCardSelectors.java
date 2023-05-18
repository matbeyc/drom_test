package selectors;

import org.openqa.selenium.By;

public class CarCardSelectors {


    public static class ConstantCarCardElementSelectors {
        public final static By ADD_TO_FAVORITE_BUTTON_SELECTOR = By.className("css-1rozdag");
        public final static By TITLE_GENERAL_SELECTOR = By.xpath(".//span[@data-ftid=\"bull_title\"]/parent::div");
        public final static By TITLE_TEXT_SELECTOR = By.xpath(".//span[@data-ftid=\"bull_title\"]");
        public final static By VOLUME_SELECTOR = By.xpath(".//span[@data-ftid=\"bull_description-item\"]/following-sibling::span[0]");
        public final static By FUEL_SELECTOR = By.xpath(".//span[@data-ftid=\"bull_description-item\"]/following-sibling::span[1]");
        public final static By TRANSMISSION_SELECTOR = By.xpath(".//span[@data-ftid=\"bull_description-item\"]/following-sibling::span[2]");
        public final static By WD_SELECTOR = By.xpath(".//span[@data-ftid=\"bull_description-item\"]/following-sibling::span[3]");
        public final static By MILEAGE_SELECTOR = By.xpath(".//span[@data-ftid=\"bull_description-item\"]/following-sibling::span[4]");

    }

    public static class DynamicCarCardElementSelectors {

    }
}
