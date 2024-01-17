package tests;

import datatest.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.MainPage;
import page.component.MenuElements;
import page.component.NavigationMenu;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$$;

import static io.qameta.allure.Allure.step;

public class MenuTest extends TestBase {
    MainPage mainPage = new MainPage();
    NavigationMenu navigationMenu = new NavigationMenu();

    static Stream<Arguments> sportRuTestMenu() {
        return MenuElements.sportRuTestMenu();
    }

    @MethodSource("sportRuTestMenu")
    @DisplayName("Проверка меню на странице")
    @ParameterizedTest
    void sportRuTest(Menu menu, List<String> expectedButtons) {
        step("Открываем главную страницу сайта sports.ru", () -> {
            mainPage.openSportsRu();
        });
        step("Переходим на проверяемую страницу", () -> {
            navigationMenu.clickOnMenuItem(menu.getPage());
        });
        step("Проверяем, что пункты меню на странице соответсвую ожидаемым", () -> {
            navigationMenu.verifyMenuItems(expectedButtons);
        });
    }
}
