package selectors;

import org.openqa.selenium.By;

public class AuthPageSelectors {
    public static class ConstantAuthPageSelectors {
        public static final By LOGIN_SELECTOR = By.xpath("//input[@name=\"sign\"]");
        public static final By PASSWORD_SELECTOR = By.xpath("//input[@name=\"password\"]");
        public static final By SUBMIT_AUTH_FORM_BUTTON_SELECTOR = By.xpath("//button[@id=\"signbutton\"]");

    }
}
