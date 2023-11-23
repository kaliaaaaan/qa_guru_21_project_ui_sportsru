package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class DropMenuTest extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка отображения выпадающего меню")
    void positiveTest() {
        mainPage.openSportsRu()
                .clickBurgerNavButton()
                .checkDropMenu();
    }

}