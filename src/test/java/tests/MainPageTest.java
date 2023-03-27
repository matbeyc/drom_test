package tests;

import helpers.CarsFilterUrlParams;
import helpers.CarsFilterUrlParamsBuilder;
import org.junit.jupiter.api.Test;
import pages.MainPage;


public class MainPageTest extends BaseTest {

    @Test
    public void openMainPage() {

        CarsFilterUrlParamsBuilder carsFilterUrlBuilder = new CarsFilterUrlParamsBuilder();
        CarsFilterUrlParams carsFilterUrlParams = carsFilterUrlBuilder
                .setModel("toyota")
                .setGeneration("generation4")
                .setMark("harrier")
                .setFuelType("5")
                .setMinYear("2007")
                .setMinMileage("1")
                .setUnsold("1")
                .build();
        MainPage mainPage = new MainPage();
        mainPage.openWithFilter(carsFilterUrlParams.getParams());
        mainPage.allCarsOnThePageShouldNotBeSold();
        mainPage.changePaginationPage("2");
        mainPage.allCarsOnThePageShouldNotBeSold();
    }
}
