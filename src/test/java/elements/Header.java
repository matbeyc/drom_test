package elements;

import org.openqa.selenium.WebElement;
import pages.BasePage;
import selectors.HeaderSelectors.ConstantHeaderElementSelectors;

public class Header extends BasePage {
    WebElement baseElement;


    public void goToAuthPage() {
        WebElement headerElement = driver.findElement(ConstantHeaderElementSelectors.AUTH_AND_REGISTRATION_BUTTON);
        headerElement.click();
    }

}
