package tests;

import config.ReadEnvConfig;
import elements.Header;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.CarPage;
import pages.MainPage;

public class AddToFavoriteTest extends BaseTest {

    @Test
    public void addToFavoriteTest() {
        MainPage mainPage = new MainPage();
        mainPage.open();
        Header headerElement = mainPage.getHeaderElement();
        headerElement.goToAuthPage();
        AuthPage authPage = new AuthPage();
        authPage.fillLogin(ReadEnvConfig.getLogin());
        authPage.fillPassword(ReadEnvConfig.getPassword());
        authPage.clickSubmitButton();
        mainPage.goToRandomNonFavoriteCarPage();
        CarPage carPage = new CarPage();
        carPage.addToFavorite();
        carPage.checkSuccessPopupText();
    }
}
