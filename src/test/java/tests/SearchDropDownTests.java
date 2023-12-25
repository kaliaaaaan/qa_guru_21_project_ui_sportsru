package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import page.MainPage;

import static io.qameta.allure.Allure.step;

public class SearchDropDownTests extends TestBase {

    MainPage mainPage = new MainPage();

    @CsvFileSource(resources = "/sportsRuSearch.csv")
    @DisplayName("Проверка выпадающего списка при поиске на сайте sports.ru")
    @ParameterizedTest(name = "При вводе в поиске названия лиги {0} в выпадающем меню отобразилось {1}")
    void successfulSearch(String searhLeague, String resultsDrop) {

        step("Открываем главную страницу сайта sports.ru", () -> {
            mainPage.openSportsRu();
        });
        step("Нажимаем на кнопку поиска", () -> {
            mainPage.searchButtonClick();
        });
        step("Вводим сокращенное название лиги", () -> {
            mainPage.searchInputForDropDown(searhLeague);
        });
        step("Проверяем, что в выпадающем списке отобразилось полное название соответствующей лиги", () -> {
            mainPage.searchDropDownList(resultsDrop);
        });

    }

}
