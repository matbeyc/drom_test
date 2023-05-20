package pages.selectors;

import org.openqa.selenium.By;

public class MainPageSelectors {
    public static class ConstantMainPageSelectors {
        public static final By CAR_CARD_SELECTOR = By.xpath("//a[@data-ftid=\"bulls-list_bull\"]");

    }

    public static class DynamicMainPageSelectors {
        public static String PAGINATION_PAGE_SELECTOR_RAW = "//div[@data-ftid=\"component_pagination\"]/child::a [contains(@href, \"page{0}\")]";

    }
}
