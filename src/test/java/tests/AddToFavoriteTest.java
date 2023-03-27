package tests;

import elements.Header;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class AddToFavoriteTest extends BaseTest {
    @Test
    public void addToFavoriteTest(){
        MainPage mainPage = new MainPage();
        mainPage.open();
        Header headerElement = mainPage.getHeaderElement();
        headerElement.goToAuthPage();
    }
}
