package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import page.MainPage;

public class SearchTest extends TestBase {

    MainPage mainPage = new MainPage();

    @ValueSource(
            strings = {"АПЛ", "РПЛ", "eredivisie", "ЛА Лига", "Ligue 1", "Бундеслига"}
    )
    @DisplayName("Проверка поиска и перехода на страницу результатов")
    @Tag("sanity")
    @ParameterizedTest(name = "Результат поиска {0} не пустой")
    void searchResultsShouldHaveValue(String searchLeague) {
        mainPage.openSportsRu()
                .searchButtonClick()
                .searchInput(searchLeague)
                .searchResults(searchLeague);
    }
    @ValueSource(
            strings = {"1"}
    )

    @DisplayName("Проверка короткого поискового запроса")
    @ParameterizedTest(name = "Результат поиска отсутствует, сообщение о коротком запросе")
    void searchResultsShouldHaveValueNull(String searchText) {
        mainPage.openSportsRu()
                .searchButtonClick()
                .searchInput(searchText)
                .searchResults("Поисковый запрос слишком короткий, попробуйте его уточнить");
    }

}