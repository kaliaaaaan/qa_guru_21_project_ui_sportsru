package tests;

import com.codeborne.selenide.CollectionCondition;
import datatest.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

import static io.qameta.allure.Allure.step;

public class MenuTest extends TestBase {
    MainPage mainPage = new MainPage();


    static Stream<Arguments> sportRuTest() {
        return Stream.of(
                Arguments.of(Menu.MAIN, List.of("Новости", "Посты", "Матчи", "Футбол", "Хоккей", "Баскет", "Фигурка", "Теннис", "Бокс", "Авто")),
                Arguments.of(Menu.FOOTBALL, List.of("Новости", "Посты", "Матчи", "РПЛ", "Фэнтези", "АПЛ", "ЛЧ", "Евро-2024", "ЛЕ", "ЛК", "Серия А")),
                Arguments.of(Menu.HOCKEY, List.of("Новости", "Посты", "Матчи", "НХЛ", "КХЛ", "Фэнтези", "Команды", "Турниры", "Хоккеисты"))
        );
    }

    @MethodSource
    @DisplayName("Проверка меню на странице")
    @ParameterizedTest
    void sportRuTest(Menu menu, List<String> expectedButtons) {
        step("Открываем главную страницу сайта sports.ru", () -> {
            mainPage.openSportsRu();
        });
        step("Переходим на проверяемую страницу", () -> {
            $$(".navigation-navbar__list a").find(href(menu.getPage())).click();
        });
        step("Проверяем, что пункты меню на странице соответсвую ожидаемым", () -> {
            $$(".navigation-navbar__list a").filter(visible).should(CollectionCondition.texts(expectedButtons));
        });

    }

}
