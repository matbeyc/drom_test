package tests;

import helpers.CarsFilterUrlParams;
import helpers.CarsFilterUrlParamsBuilder;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import tests.baseTests.BaseWebTest;


public class FilterTest extends BaseWebTest {

    @Test
    public void filterTest(){

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
        mainPage.allCarsShouldNotBeSold();
        mainPage.allCarsShouldBeMoreOrEqualThan(2007);
        mainPage.allCarsShouldHaveMileage();
        mainPage.changePaginationPage("2");
        mainPage.allCarsShouldNotBeSold();
        mainPage.allCarsShouldBeMoreOrEqualThan(2007);
        mainPage.allCarsShouldHaveMileage();
    }
}
