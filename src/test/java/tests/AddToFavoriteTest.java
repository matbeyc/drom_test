package tests;
import config.ReadEnvConfig;
import pages.elements.Header;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.CarPage;
import pages.MainPage;
import tests.baseTests.BaseWebTest;

public class AddToFavoriteTest extends BaseWebTest {

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
