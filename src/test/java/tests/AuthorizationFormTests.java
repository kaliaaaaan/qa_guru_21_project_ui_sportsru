package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.component.AuthWindow;

import static io.qameta.allure.Allure.step;

public class AuthorizationFormTests extends TestBase {

    MainPage mainPage = new MainPage();
    AuthWindow authWindow = new AuthWindow();

    @Test
    @DisplayName("Проверка окна авторизации")
    @Tag("smoke")
    void testAuth() {
        step("Открываем главную страницу сайта sports.ru", () -> {
            mainPage.openSportsRu();
        });
        step("Нажимаем на кнопку Авторизации", () -> {
            mainPage.clickLoginButton();
        });
        step("Проверяем, что открыто окно авторизации", () -> {
            authWindow.checkOpenAuthWindow("Авторизация");
        });
    }

    @Test
    @DisplayName("Проверка, что кнопка авторизации disabled")
    void testDisabledButton() {
        step("Открываем главную страницу сайта sports.ru", () -> {
            mainPage.openSportsRu();
        });
        step("Нажимаем на кнопку Авторизации", () -> {
            mainPage.clickLoginButton();
        });
        step("Проверяем, что открыто окно авторизации", () -> {
            authWindow.checkOpenAuthWindow("Авторизация");
        });
        step("Проверка, что кнопка авторизации disabled", () -> {
            authWindow.checkDisabledLoginButton();
        });
    }

    @Test
    @DisplayName("Проверка, что кнопка авторизации стала активна после ввода данных в поля логин и пароль")
    void testEnabledButton() {
        Faker faker = new Faker();

        step("Открываем главную страницу сайта sports.ru", () -> {
            mainPage.openSportsRu();
        });
        step("Нажимаем на кнопку Авторизации", () -> {
            mainPage.clickLoginButton();
        });
        step("Проверяем, что открыто окно авторизации", () -> {
            authWindow.checkOpenAuthWindow("Авторизация");
        });
        step("Вводим случайные значение в поля логин и пароль", () -> {
            authWindow.setLoginPassword(faker.internet().emailAddress(), faker.animal().name());
        });
        step("Проверяем, что кнопка авторизации стала активна", () -> {
            authWindow.checkEnabledLoginButton();
        });
    }
}
