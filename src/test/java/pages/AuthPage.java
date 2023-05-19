package pages;

import org.openqa.selenium.WebElement;
import selectors.AuthPageSelectors.ConstantAuthPageSelectors;

public class AuthPage extends BasePage {


    public void fillLogin(String login) {
        WebElement loginField = driver.findElement(ConstantAuthPageSelectors.LOGIN_SELECTOR);
        loginField.sendKeys(login);
    }

    public void fillPassword(String password) {
        WebElement passwordField = driver.findElement(ConstantAuthPageSelectors.PASSWORD_SELECTOR);
        passwordField.sendKeys(password);

    }

    public void clickSubmitButton() {
        WebElement submitAuthFormButton = driver.findElement(ConstantAuthPageSelectors.SUBMIT_AUTH_FORM_BUTTON_SELECTOR);
        submitAuthFormButton.click();
    }
}
