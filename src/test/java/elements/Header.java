package elements;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import selectors.HeaderSelectors.ConstantHeaderElementSelectors;

public class Header extends BasePage {


    public void goToAuthPage() {
        WebElement authButton = driver.findElement(ConstantHeaderElementSelectors.AUTH_AND_REGISTRATION_BUTTON);
        authButton.click();
    }

}
