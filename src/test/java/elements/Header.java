package elements;

import org.openqa.selenium.WebElement;
import selectors.HeaderSelectors.ConstantHeaderElementSelectors;

public class Header {
    WebElement baseElement;

    public Header(WebElement headerElement) {
        this.baseElement = headerElement;
    }

    public void goToAuthPage() {
        this.baseElement.findElement(ConstantHeaderElementSelectors.AUTH_AND_REGISTRATION_BUTTON).click();
    }

}
