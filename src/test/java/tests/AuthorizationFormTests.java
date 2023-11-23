package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class AuthorizationFormTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка окна авторизации")
    @Tag("smoke")
    void testAuth() {
        mainPage.openSportsRu()
                .clickLoginButton()
                .checkOpenAuthWindow("Авторизация");

    }
    @Test
    @DisplayName("Проверка, что кнопка авторизации disabled")
    void testDisabledButton() {
        mainPage.openSportsRu()
                .clickLoginButton()
                .checkOpenAuthWindow("Авторизация")
                .checkDisabledLoginButton();

    }

    @Test
    @DisplayName("Проверка, что кнопка авторизации enabled после ввода данных в поля логин и пароль")
    void testEnabledButton() {
        Faker faker = new Faker();
        mainPage.openSportsRu()
                .clickLoginButton()
                .checkOpenAuthWindow("Авторизация")
                .setLoginPassword(faker.internet().emailAddress(), faker.animal().name())
                .checkEnabledLoginButton();

    }

}
