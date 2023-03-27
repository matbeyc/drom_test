package resources;

public class Selectors {

    public static class ConstantMainPageSelectors {
        public static final String CAR_CARD_SELECTOR = "//a[@data-ftid=\"bulls-list_bull\"]";

    }

    public static class DynamicMainPageSelectors {
        public static String PAGINATION_PAGE_SELECTOR_RAW = "//div[@data-ftid=\"component_pagination\"]/child::a [contains(@href, \"page{0}\")]";
    }

}
