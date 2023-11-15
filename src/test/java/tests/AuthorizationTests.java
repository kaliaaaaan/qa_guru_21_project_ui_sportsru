package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.MainPage;
import page.components.PersonalMenu;

import java.util.stream.Stream;

import static constants.AuthorizationTextError.ERROR_LOGIN_OR_PASSWORD;

public class AuthorizationTests extends TestBase {

    MainPage mainPage = new MainPage();
    PersonalMenu personalMenu = new PersonalMenu();

    @Test
    @DisplayName("Позитивный тест авторизации")
    @Tag("sanity")
    void positiveTest() {
        mainPage.openSportsRu()
                .clickLoginButton()
                .setLoginPassword("Qaguru21autotest@gmail.com", "13371337");
        personalMenu
                .personalMenuOpen()
                .personalMenuCheckUserName("Autotestqaguru21");

    }

    @ParameterizedTest(name = "[user: {0}; pass: {1}]")
    @DisplayName("Негативный тест авторизации")
    @MethodSource("submitIncorrectParameters")
    void negativeTest(String login, String password, String errorText) {
        mainPage
                .openSportsRu()
                .clickLoginButton()
                .setLoginPassword(login, password)
                .loginError(errorText);

    }

    private static Stream<Arguments> submitIncorrectParameters() {
        Faker faker = new Faker();
        return Stream.of(
                Arguments.of(faker.internet().emailAddress(), faker.artist().name(), ERROR_LOGIN_OR_PASSWORD.getErrorText()),
                Arguments.of("1111", "1111", ERROR_LOGIN_OR_PASSWORD.getErrorText()),
                Arguments.of("*&%#*@@,()_*@@", "*&%#*@@,()_*@@", ERROR_LOGIN_OR_PASSWORD.getErrorText()));
    }

}
