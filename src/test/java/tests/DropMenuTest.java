package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static io.qameta.allure.Allure.step;

public class DropMenuTest extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка отображения выпадающего меню")
    void positiveTest() {
        step("Открываем главную страницу сайта sports.ru", () -> {
            mainPage.openSportsRu();
        });
        step("Нажимаем на кнопку раскрытия выпадающего меню (бургер)", () -> {
            mainPage.clickBurgerNavButton();
        });
        step("Проверям, что выпадающее меню раскрыто", () -> {
            mainPage.checkDropMenu();
        });
    }
}