package selectors;

import org.openqa.selenium.By;

public class MainPageSelectors {
    public static class ConstantMainPageSelectors {
        public static final By CANVAS = By.xpath("//a[@data-ftid=\"component_cars-list-item_hidden-link\"]");
        public static final By CAR_CARD_SELECTOR = By.xpath("//a[@data-ftid=\"bulls-list_bull\"]");
        public static final By HEADER_SELECTOR = By.xpath("//div[@data-ftid=\"component_header\"]");
        public final static By ADD_TO_FAVORITE_BUTTON_SELECTOR = By.xpath("//div[@class=\"css-1rozdag\"]");

    }

    public static class DynamicMainPageSelectors {
        public static String PAGINATION_PAGE_SELECTOR_RAW = "//div[@data-ftid=\"component_pagination\"]/child::a [contains(@href, \"page{0}\")]";

    }
}
