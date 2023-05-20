package tests;
import pages.elements.FilterElement;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import tests.baseTests.BaseMobileTest;

public class MostSoldMarksTest extends BaseMobileTest {

    @Test
    public void mostSoldMarksTest() {
        MainPage mainPage = new MainPage();
        mainPage.open();
        FilterElement filterElement = mainPage.getFilterElement();
        filterElement.displayTopSoldMarks(20);
    }
}
