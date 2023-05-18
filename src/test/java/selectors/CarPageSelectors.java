package selectors;

import org.openqa.selenium.By;

public class CarPageSelectors {
    public static class ConstantCarPageSelectors {
        public final static By CANVAS = By.xpath("//iframe[@name=\"14193\"]");
        public final static By ADD_TO_FAVORITE_BUTTON = By.xpath("//div[@data-ga-stats-name=\"add_bull_top\"]/div/*");
    }
}
