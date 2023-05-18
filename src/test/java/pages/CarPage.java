package pages;

import org.openqa.selenium.WebElement;
import selectors.CarPageSelectors.ConstantCarPageSelectors;

public class CarPage extends BasePage {

    public CarPage() {
        driver.findElement(ConstantCarPageSelectors.CANVAS);
    }

    public void addToFavorite() throws InterruptedException {
        WebElement addToFavoriteButton = driver.findElement(ConstantCarPageSelectors.ADD_TO_FAVORITE_BUTTON);
        addToFavoriteButton.click();
    }
}
