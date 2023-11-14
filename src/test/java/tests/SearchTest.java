package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import page.MainPage;

public class SearchTest extends MainPage {

    MainPage mainPage = new MainPage();

    @ValueSource(
            strings = {"АПЛ", "РПЛ", "eredivisie", "ЛА Лига", "Ligue 1", "Бундеслига"}
    )
    @DisplayName("Проверка поиска")
    @Tag("sanity")
    @ParameterizedTest(name = "Результат поиска {0} не пустой")
    void searchResultsShouldHaveValue(String searchLeague) {
        mainPage.openSportsRu()
                .searchButtonClick()
                .searchInput(searchLeague)
                .searchResults(searchLeague);
    }

}