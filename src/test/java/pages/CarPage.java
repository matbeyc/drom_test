package pages;

import helpers.Waits;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.selectors.CarPageSelectors.ConstantCarPageSelectors;

public class CarPage extends BasePage {


    public void addToFavorite() {
        waitUntilPageLoaded();
        WebElement addToFavoriteButton = driver.findElement(ConstantCarPageSelectors.ADD_TO_FAVORITE_BUTTON);
        addToFavoriteButton.click();
    }


    public void checkSuccessPopupText() {
        String successPopupExpectedText = "Объявление добавлено в избранное.\n" +
                "Вы получите уведомление при изменении цены.";
        Waits waits = new Waits(driver);
        Assertions.assertTrue(waits.textToBePresentInElementLocated(ConstantCarPageSelectors.SUCCESS_POPUP, successPopupExpectedText));
    }

    private void waitUntilPageLoaded() {
        driver.findElement(ConstantCarPageSelectors.BANNER);
    }
}