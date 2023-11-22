package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class AuthorizationFormTests extends TestBaseLocale {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка окна авторизации")
    @Tag("sanity")
    void testAuth() {
        mainPage.openSportsRu()
                .clickLoginButton()
                .checkOpenAuthWindow("Авторизация");

    }
    @Test
    @DisplayName("Проверка, что кнопка входа disabled")
    @Tag("sanity")
    void testDisabledButton() {
        mainPage.openSportsRu()
                .clickLoginButton()
                .checkOpenAuthWindow("Авторизация")
                .checkDisabledLoginButton();

    }

    @Test
    @DisplayName("Проверка, что кнопка входа disabled")
    @Tag("sanity")
    void testEnabledButton() {
        Faker faker = new Faker();
        mainPage.openSportsRu()
                .clickLoginButton()
                .checkOpenAuthWindow("Авторизация")
                .setLoginPassword(faker.internet().emailAddress(), faker.animal().name())
                .checkEnabledLoginButton();

    }

}
