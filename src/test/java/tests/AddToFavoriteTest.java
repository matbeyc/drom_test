package tests;

import elements.Header;
import org.checkerframework.checker.units.qual.C;
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
        authPage.fillLogin();
        authPage.fillPassword();
        authPage.doAuth();
        mainPage.addToFavoriteRandomCar();
    }
}
