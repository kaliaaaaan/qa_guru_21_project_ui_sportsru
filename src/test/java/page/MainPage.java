package page;

import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;


public class MainPage extends TestBase {

    SelenideElement

            loginButton = $(".unauthorized-block"),
            loginInput = $(".auth-screen__input--email"),
            passwordInput = $(".auth-screen__input--password"),
            submitLoginButton = $(".auth-screen__submit"),
            loginError = $(".auth-screen__error"),
            searchButton = $(".navigation-search__toggle"),
            searchInput = $(".navigation-search__input"),
            searchResults = $(".search-result"),
            searchResultsDropDown = $(".navigation-search__results-list");



    public MainPage clickLoginButton() {
        loginButton.shouldHave(visible).hover().click();
        return this;
    }

    public MainPage setLoginPassword(String login, String password) {
        loginInput.click();
        loginInput.setValue(login);
        passwordInput.click();
        passwordInput.setValue(password);
        submitLoginButton.click();
        return this;
    }

    public MainPage loginError(String errorText) {
        loginError.shouldHave(text(errorText));
        return this;
    }

    public MainPage openSportsRu() {
        open("");
        return this;
    }

    public MainPage searchButtonClick() {
        searchButton.hover().click();
        return this;
    }

    public MainPage searchInput(String value) {
        searchInput.click();
        searchInput.setValue(value);
        searchInput.pressEnter();
        return this;
    }

    public MainPage searchResults(String value) {
        searchResults.shouldHave(visible, ofSeconds(25));
        searchResults.shouldHave(text(value));
        return this;
    }



    public MainPage searchInputForDropDown(String value) {
        searchInput.click();
        searchInput.setValue(value);
        return this;
    }

    public MainPage searchDropDownList(String value) {
        searchResultsDropDown.shouldHave(text(value));
        return this;
    }

}