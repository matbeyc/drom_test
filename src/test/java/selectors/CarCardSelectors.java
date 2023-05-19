package selectors;

import org.openqa.selenium.By;

public class CarCardSelectors {


    public static class ConstantCarCardSelectors {


        public final static By TITLE_GENERAL_SELECTOR = By.xpath(".//span[@data-ftid=\"bull_title\"]/parent::div");
        public final static By TITLE_TEXT_SELECTOR = By.xpath(".//span[@data-ftid=\"bull_title\"]");
        public final static By MILEAGE_SELECTOR = By.xpath(".//span[@data-ftid=\"bull_description-item\"]/following-sibling::span[4]");

    }

    public static class DynamicCarCardSelectors {
        public final static String ADD_TO_FAVORITE_BUTTON_INNER = "div[@class=\"css-1rozdag\"]";

    }
}
