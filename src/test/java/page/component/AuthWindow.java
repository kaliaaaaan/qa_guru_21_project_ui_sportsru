package page.component;

import com.codeborne.selenide.SelenideElement;
import page.MainPage;
import tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AuthWindow extends TestBase {

    private SelenideElement

            windowAuth = $(".auth-popup"),
            windowAuthTitle = $(".auth-screen__title"),
            loginInput = $(".auth-screen__input--email"),
            passwordInput = $(".auth-screen__input--password"),
            submitLoginButton = $(".auth-screen__submit");

    public AuthWindow checkOpenAuthWindow(String value) {
        windowAuth.shouldHave(visible);
        windowAuthTitle.shouldHave(text(value));
        loginInput.shouldHave(visible);
        passwordInput.shouldHave(visible);
        return this;
    }

    public AuthWindow checkDisabledLoginButton() {
        submitLoginButton.shouldHave(disabled);
        return this;
    }

    public AuthWindow checkEnabledLoginButton() {
        submitLoginButton.shouldHave(enabled);
        return this;
    }

    public AuthWindow setLoginPassword(String login, String password) {
        loginInput.click();
        loginInput.setValue(login);
        passwordInput.click();
        passwordInput.setValue(password);
        return this;
    }
}
