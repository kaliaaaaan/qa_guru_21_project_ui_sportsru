package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import page.MainPage;
import page.SearchResultsPage;

import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {

    MainPage mainPage = new MainPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @ValueSource(
            strings = {"АПЛ", "РПЛ", "eredivisie", "ЛА Лига", "Ligue 1", "Бундеслига"}
    )
    @DisplayName("Проверка поиска и перехода на страницу результатов")
    @Tag("sanity")
    @ParameterizedTest(name = "Результат поиска {0} не пустой")
    void searchResultsShouldHaveValue(String searchLeague) {
        step("Открываем главную страницу сайта sports.ru", () -> {
            mainPage.openSportsRu();
        });
        step("Нажимаем на кнопку поиска", () -> {
            mainPage.searchButtonClick();
        });
        step("Вводим искомое значение", () -> {
            mainPage.searchInput(searchLeague);
        });
        step("Проверяем, что искомый текст отображается нас странице с результатами поиска", () -> {
            searchResultsPage.searchResults(searchLeague);
        });

    }

    @ValueSource(
            strings = {"1"}
    )

    @DisplayName("Проверка короткого поискового запроса")
    @ParameterizedTest(name = "Результат поиска отсутствует, сообщение о коротком запросе")
    void searchResultsShouldHaveValueNull(String searchText) {
        step("Открываем главную страницу сайта sports.ru", () -> {
            mainPage.openSportsRu();
        });
        step("Нажимаем на кнопку поиска", () -> {
            mainPage.searchButtonClick();
        });
        step("Вводим короткий текст для поиска", () -> {
            mainPage.searchInput(searchText);
        });
        step("Проверяем, что получено ожидаемое информационное сообщение", () -> {
            searchResultsPage.searchResults("Поисковый запрос слишком короткий, попробуйте его уточнить");
        });

    }

}