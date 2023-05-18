package pages;

import config.ReadConfig;
import org.openqa.selenium.WebElement;
import selectors.AuthPageSelectors.ConstantAuthPageSelectors;

public class AuthPage extends BasePage {
    String login = ReadConfig.getLogin();
    String password = ReadConfig.getPassword();

    public void fillLogin() {
        WebElement loginField = driver.findElement(ConstantAuthPageSelectors.LOGIN_SELECTOR);
        loginField.sendKeys(login);
    }

    public void fillPassword() {
        WebElement passwordField = driver.findElement(ConstantAuthPageSelectors.PASSWORD_SELECTOR);
        passwordField.sendKeys(password);

    }

    public void doAuth() {
        WebElement submitAuthFormButton = driver.findElement(ConstantAuthPageSelectors.SUBMIT_AUTH_FORM_BUTTON_SELECTOR);
        submitAuthFormButton.click();
    }
}
