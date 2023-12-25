package page;

import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends TestBase {

    private SelenideElement

            loginButton = $(".unauthorized-block"),
            burgerButton = $(".navigation-burger__btn"),
            dropMenu = $(".navigation-item-list__list"),
            searchButton = $(".navigation-search__toggle"),
            searchInput = $(".navigation-search__input"),
            searchResultsDropDown = $(".navigation-search__results-list");


    public MainPage clickLoginButton() {
        loginButton.shouldHave(visible).hover().click();
        return this;
    }

    public MainPage openSportsRu() {
        open("");
        return this;
    }

    public MainPage clickBurgerNavButton() {
        burgerButton.click();
        return this;
    }

    public MainPage checkDropMenu() {
        dropMenu.should(visible);
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