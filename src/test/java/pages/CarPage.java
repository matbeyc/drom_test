package pages;

import helpers.Waits;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import selectors.CarPageSelectors.ConstantCarPageSelectors;

public class CarPage extends BasePage {


    public void addToFavorite() {
        waitUntilPageLoaded();
        WebElement addToFavoriteButton = driver.findElement(ConstantCarPageSelectors.ADD_TO_FAVORITE_BUTTON);
        addToFavoriteButton.click();
    }


    public void checkSuccessPopupText() {
        WebElement successPopup = new Waits(driver).presenceOfElementLocatedBy(ConstantCarPageSelectors.SUCCESS_POPUP);
        System.out.println(successPopup.getText());
        Assertions.assertEquals("Объявление добавлено в избранное.\n" +
                "Вы получите уведомление при изменении цены.", successPopup.getText());
    }


    private void waitUntilPageLoaded() {
        driver.findElement(ConstantCarPageSelectors.BANNER);
    }
}
