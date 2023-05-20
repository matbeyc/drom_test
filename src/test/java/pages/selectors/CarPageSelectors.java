package pages.selectors;

import org.openqa.selenium.By;

public class CarPageSelectors {
    public static class ConstantCarPageSelectors {
        public static final By SUCCESS_POPUP = By.xpath("//div[@data-ftid=\"component_notification_type_success\"]");
        public final static By BANNER = By.xpath("//iframe[@name]");
        public final static By ADD_TO_FAVORITE_BUTTON = By.xpath("//div[@data-ga-stats-name=\"add_bull_top\"]/div/*");
    }
}
